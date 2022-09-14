package com.example.reservations.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.reservations.service.Topics;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class ReservationsProcessor {

	private ObjectMapper objectMapper = new ObjectMapper();
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@KafkaListener(groupId = Topics.RESERVATION_MADE, topics = Topics.RESERVATION_MADE)
	public void handleReservationDone(String message) {
		//various after reservation operations
		logger.info(message);
	}
	
	@KafkaListener(groupId = Topics.RESERVATION_FAILURE, topics = Topics.RESERVATION_FAILURE)
	public void handleReservationFailure(String message) {
		//TODO extract this method in separate processor class
		logger.info(message);
	}
}
