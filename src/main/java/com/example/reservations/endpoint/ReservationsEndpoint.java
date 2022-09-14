package com.example.reservations.endpoint;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservations.service.ReservationsService;

@RestController
@RequestMapping("movies/reservations")
public class ReservationsEndpoint {

	private ReservationsService reservationsService;

	public ReservationsEndpoint(ReservationsService service) {
		this.reservationsService = service;
	}

	@PostMapping
	public ResponseEntity<ReservationResponse> reserve(@RequestBody ReservationRequest reservationRequest) {
		return ResponseEntity.ok(reservationsService.reserve(reservationRequest));
	}

	@GetMapping
	public ResponseEntity<List<ReservationResponse>> listReservations(@RequestParam("date") String date, @RequestParam("hour") String hour, @RequestParam("movieId") Long movieId) {
		return ResponseEntity.ok(reservationsService.listReservations(date, hour, movieId));
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<ReservationResponse> addBeverages(@PathVariable("id") Long reservationId, @RequestParam("beveragesIds") List<Long> beveragesIds) {
		return ResponseEntity.ok(reservationsService.addBeverages(reservationId, beveragesIds));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ReservationResponse> getReservation(@PathVariable("id") Long reservationId) {
		return ResponseEntity.ok(reservationsService.findReservation(reservationId));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ReservationResponse> cancelReservation(@PathVariable("id") Long reservationId) {
		return ResponseEntity.ok(reservationsService.deleteReservation(reservationId));
	}
}
