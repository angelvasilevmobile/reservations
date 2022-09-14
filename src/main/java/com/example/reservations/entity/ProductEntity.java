package com.example.reservations.entity;

import java.math.BigDecimal;

import javax.persistence.Column;

public class ProductEntity extends NamedEntity {

	@Column
	private BigDecimal price;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ProductEntity(BigDecimal price) {
		super();
		this.price = price;
	}

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
