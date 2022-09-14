package com.example.reservations.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer_entity")
public class CustomerEntity extends NamedEntity {
	
	@OneToMany
	private List<ReservationEntity> reservations;
	
	@Column
	private BigDecimal balance;

	public List<ReservationEntity> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationEntity> reservations) {
		this.reservations = reservations;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public CustomerEntity(List<ReservationEntity> reservations, BigDecimal balance) {
		super();
		this.reservations = reservations;
		this.balance = balance;
	}

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}