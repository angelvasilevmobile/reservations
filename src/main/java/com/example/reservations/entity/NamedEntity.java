package com.example.reservations.entity;

import javax.persistence.Column;

public class NamedEntity extends BaseEntity {

	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
