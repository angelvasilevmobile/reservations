package com.example.reservations.endpoint;

import java.math.BigDecimal;

public class Beverages {

	private Long beverageId;
	private BigDecimal price;
	private String name;
	public Long getBeverageId() {
		return beverageId;
	}
	public void setBeverageId(Long beverageId) {
		this.beverageId = beverageId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Beverages(Long beverageId, BigDecimal price, String name) {
		super();
		this.beverageId = beverageId;
		this.price = price;
		this.name = name;
	}
	public Beverages() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
