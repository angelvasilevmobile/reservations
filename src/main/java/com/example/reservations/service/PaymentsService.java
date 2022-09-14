package com.example.reservations.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.reservations.entity.BeveragesEntity;
import com.example.reservations.entity.CustomerEntity;
import com.example.reservations.entity.MovieEntity;
import com.example.reservations.entity.PaymentEntity;
import com.example.reservations.exception.PaymentException;
import com.example.reservations.repository.CustomerRepository;
import com.example.reservations.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaymentsService {

	private KafkaTemplate<String, String> kafkaTemplate;
	private ObjectMapper objectMapper = new ObjectMapper();
	private PaymentRepository repository;
	private CustomerRepository customerRepository;
	
	public PaymentsService(KafkaTemplate<String, String> kafkaTemplate,
			PaymentRepository repository,
			CustomerRepository customerRepository) {
		super();
		this.kafkaTemplate = kafkaTemplate;
		this.repository = repository;
		this.customerRepository = customerRepository;
	}


	public void pay(CustomerEntity customer, List<BeveragesEntity> beverages, MovieEntity movieEntity) throws PaymentException {
		BigDecimal totalAmount = new BigDecimal("0.00");
		
		for (BeveragesEntity beveragesEntity : beverages) {
			totalAmount = totalAmount.add(beveragesEntity.getPrice());
		}
		if (movieEntity != null) {
			totalAmount = totalAmount.add(movieEntity.getPrice());
		}
		
		PaymentEntity resultPaymentEntity = new PaymentEntity();
		resultPaymentEntity.setTotalAmount(totalAmount);
		
		if (customer.getBalance().subtract(totalAmount).compareTo(BigDecimal.ZERO) < 0) {
			throw new PaymentException("Not enough balance!");
		}
		
		customer.setBalance(customer.getBalance().subtract(totalAmount));
		this.customerRepository.save(customer);
		this.repository.save(resultPaymentEntity);
		
		try {
			kafkaTemplate.send(Topics.PAYMENT_MADE, objectMapper.writeValueAsString(resultPaymentEntity));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
