package com.example.reservations.endpoint;

import java.util.List;

import com.example.reservations.entity.ReservationEntity;

public class ReservationResponse {

	private Long reservationId;
	private Movie movie;
	private List<String> seats;
	private List<Beverages> beverages;
	private String errorMessage;

	public Long getReservationId() {
		return reservationId;
	}
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public List<String> getSeats() {
		return seats;
	}
	public void setSeats(List<String> seats) {
		this.seats = seats;
	}
	public List<Beverages> getBeverages() {
		return beverages;
	}
	public void setBeverages(List<Beverages> beverages) {
		this.beverages = beverages;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ReservationResponse(Long reservationId, Movie movie, List<String> seats, List<Beverages> beverages) {
		super();
		this.reservationId = reservationId;
		this.movie = movie;
		this.seats = seats;
		this.beverages = beverages;
	}
	public ReservationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReservationResponse(ReservationEntity reservation) {
		this.reservationId = reservation.getId();
//		TODO finish boilerplate
	}
	
}
