package com.example.reservations.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.reservations.service.Topics;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class PaymentsProcessor {

	private ObjectMapper objectMapper = new ObjectMapper();
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@KafkaListener(groupId = Topics.PAYMENT_MADE, topics = Topics.PAYMENT_MADE)
	public void handlePaymentDone(String message) {
		//various after reservation operations
		logger.info(message);
	}
}
