package com.example.reservations.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments_entity")
public class PaymentEntity extends BaseEntity {

	@OneToOne
	private CustomerEntity customer;
	
	@OneToMany
	private List<BeveragesEntity> beverages;
	
	@OneToOne
	private MovieEntity movie;

	@Column
	private BigDecimal totalAmount;
	
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

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public PaymentEntity(Long id, CustomerEntity customer, List<BeveragesEntity> beverages, MovieEntity movie) {
		super(id);
		this.customer = customer;
		this.beverages = beverages;
		this.movie = movie;
	}

	public PaymentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
