package com.example.reservations.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.reservations.endpoint.Beverages;
import com.example.reservations.endpoint.Movie;

public class Payment {

	private Customer customer;
	private List<Beverages> products;
	private Movie movie;
	private BigDecimal totalAmount;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Beverages> getProducts() {
		return products;
	}
	public void setProducts(List<Beverages> products) {
		this.products = products;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Payment(Customer customer, List<Beverages> products, Movie movie, BigDecimal totalAmount) {
		super();
		this.customer = customer;
		this.products = products;
		this.movie = movie;
		this.totalAmount = totalAmount;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
