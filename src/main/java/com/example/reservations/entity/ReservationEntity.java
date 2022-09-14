package com.example.reservations.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation_entity")
public class ReservationEntity extends BaseEntity {

	@OneToOne
	private CustomerEntity customer;
	
	@OneToOne
	private MovieEntity movie;

	@OneToMany
	private List<BeveragesEntity> beverages;
	
	@OneToMany
	private List<SeatsEntity> seats;
	
	@Column
	private String date;
	
	@Column
	private String hourId;

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	public List<SeatsEntity> getSeats() {
		return seats;
	}

	public void setSeats(List<SeatsEntity> seats) {
		this.seats = seats;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHourId() {
		return hourId;
	}

	public void setHourId(String hour) {
		this.hourId = hour;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public List<BeveragesEntity> getBeverages() {
		return beverages;
	}

	public void setBeverages(List<BeveragesEntity> beverages) {
		this.beverages = beverages;
	}

	public ReservationEntity(MovieEntity movie, List<BeveragesEntity> beverages, List<SeatsEntity> seats, String date,
			String hour, CustomerEntity customer) {
		super();
		this.movie = movie;
		this.beverages = beverages;
		this.seats = seats;
		this.date = date;
		this.hourId = hour;
		this.customer = customer;
	}

	public ReservationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReservationEntity(CustomerEntity customerEntity, MovieEntity movieEntity, List<SeatsEntity> seats,
			List<BeveragesEntity> beverages, String date, String hour) {
		this.customer = customerEntity;
		this.movie = movieEntity;
		this.beverages = beverages;
		this.seats = seats;
		this.hourId = hour;
		this.date = date;
	}

	public void addBeverages(List<BeveragesEntity> beverages) {
		if (this.beverages == null) {
			this.beverages = new ArrayList<>();
		}
		this.beverages.addAll(beverages);
	}
	
	
}
