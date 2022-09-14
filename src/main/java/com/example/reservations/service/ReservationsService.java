package com.example.reservations.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.reservations.endpoint.Actor;
import com.example.reservations.endpoint.Beverages;
import com.example.reservations.endpoint.Movie;
import com.example.reservations.endpoint.Producer;
import com.example.reservations.endpoint.ReservationRequest;
import com.example.reservations.endpoint.ReservationResponse;
import com.example.reservations.entity.BeveragesEntity;
import com.example.reservations.entity.CustomerEntity;
import com.example.reservations.entity.MovieEntity;
import com.example.reservations.entity.ReservationEntity;
import com.example.reservations.entity.SeatsEntity;
import com.example.reservations.repository.BeverageRepository;
import com.example.reservations.repository.CustomerRepository;
import com.example.reservations.repository.MovieRepository;
import com.example.reservations.repository.ReservationRepository;
import com.example.reservations.repository.SeatRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ReservationsService {

	private ObjectMapper objectMapper = new ObjectMapper();
	private ReservationRepository repository;
	private CustomerRepository customerRepository;
	private MovieRepository movieRepository;
	private SeatRepository seatsRepository;
	private BeverageRepository beveragesRepository;
	private PaymentsService paymentsService;
	private KafkaTemplate<String, String> kafkaTemplate;

	public ReservationsService(ReservationRepository repository, CustomerRepository customerRepository,
			MovieRepository movieRepository, SeatRepository seatsRepository, BeverageRepository beveragesRepository,
			PaymentsService paymentsService, KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.repository = repository;
		this.customerRepository = customerRepository;
		this.seatsRepository = seatsRepository;
		this.beveragesRepository = beveragesRepository;
		this.paymentsService = paymentsService;
		this.kafkaTemplate = kafkaTemplate;

	}

	public List<ReservationResponse> listReservations(String date, String hour, Long movieId) {
		return repository.findByDateAndHourIdAndMovieId(date, hour, movieId).stream()
				.map(reservationEntity -> new ReservationResponse(reservationEntity.getId(), new Movie(
						reservationEntity.getMovie().getId(), reservationEntity.getMovie().getName(),
						reservationEntity.getMovie().getActors().stream()
								.map(actorEntity -> new Actor(actorEntity.getId(), actorEntity.getName()))
								.collect(Collectors.toList()),
						reservationEntity.getMovie().getProducers().stream()
								.map(producerEntity -> new Producer(producerEntity.getId(), producerEntity.getName()))
								.collect(Collectors.toList())),
						reservationEntity.getSeats().stream().map(seats -> seats.getName())
								.collect(Collectors.toList()),
						reservationEntity.getBeverages().stream()
								.map(beverage -> new Beverages(beverage.getId(), beverage.getPrice(),
										beverage.getName()))
								.collect(Collectors.toList())))
				.collect(Collectors.toList());
	}

	@Transactional
	public ReservationResponse reserve(ReservationRequest reservationRequest) {
		ReservationResponse reservationResponse = new ReservationResponse();
		try {

			Optional<CustomerEntity> customer = customerRepository.findById(reservationRequest.getCustomerId());
			Optional<MovieEntity> movie = movieRepository.findById(reservationRequest.getMovieId());
			List<SeatsEntity> seats = seatsRepository.findAllById(reservationRequest.getSeatIds());
			List<BeveragesEntity> beverages = beveragesRepository.findAllById(reservationRequest.getBeverageIds());
			
			ReservationEntity reservation = new ReservationEntity(customer.get(), movie.get(), seats, beverages,
					reservationRequest.getDate(), reservationRequest.getHour());
			
			paymentsService.pay(customer.get(), beverages, movie.get());

			reservation = repository.save(reservation);
			reservationResponse.setReservationId(reservation.getId());
			
			kafkaTemplate.send(Topics.RESERVATION_MADE, toJson(reservationResponse));
		} catch (Exception e) {
			reservationResponse.setErrorMessage(e.getLocalizedMessage());
			kafkaTemplate.send(Topics.RESERVATION_FAILURE, toJson(reservationResponse));
		}

		return reservationResponse;
	}

	public ReservationResponse addBeverages(Long reservationId, List<Long> beveragesIds) {
		ReservationResponse response = new ReservationResponse();
		try {
			Optional<ReservationEntity> reservation = repository.findById(reservationId);
			List<BeveragesEntity> beverages = beveragesRepository.findAllById(beveragesIds);

			ReservationEntity reservationObject = reservation.get();

			CustomerEntity customer = reservationObject.getCustomer();

			paymentsService.pay(customer, beverages, null);

			reservationObject.addBeverages(beverages);

			ReservationEntity updatedReservation = repository.save(reservationObject);
			response = new ReservationResponse(updatedReservation);
		} catch (Exception e) {
			response.setErrorMessage(e.getLocalizedMessage());
		}
		return response;
	}

	public ReservationResponse findReservation(Long reservationId) {
		Optional<ReservationEntity> reservation = repository.findById(reservationId);
		return new ReservationResponse(reservation.get());
	}

	public void deleteReservation(Long reservationId) {
		repository.deleteById(reservationId);
	}

	private String toJson(ReservationResponse reservationResponse) {
		String json = null;
		try {
			json = objectMapper.writeValueAsString(reservationResponse);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
}
