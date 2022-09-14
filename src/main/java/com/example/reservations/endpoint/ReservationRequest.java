package com.example.reservations.endpoint;

import java.util.List;

public class ReservationRequest {

	private Long customerId;
	private Long movieId;
	private List<Long> seatIds;
	private List<Long> beverageIds;
	private String date;
	private String hour;

	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public List<Long> getSeatIds() {
		return seatIds;
	}
	public void setSeatIds(List<Long> seatIds) {
		this.seatIds = seatIds;
	}
	public List<Long> getBeverageIds() {
		return beverageIds;
	}
	public void setBeverageIds(List<Long> beverageIds) {
		this.beverageIds = beverageIds;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public ReservationRequest(Long customerId, Long movieId, List<Long> seatIds, List<Long> beverageIds, String date,
			String hour) {
		super();
		this.customerId = customerId;
		this.movieId = movieId;
		this.seatIds = seatIds;
		this.beverageIds = beverageIds;
		this.date = date;
		this.hour = hour;
	}
	public ReservationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
