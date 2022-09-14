package com.example.reservations.endpoint;

public class Producer {

	private Long producerId;
	private String name;
	public Long getProducerId() {
		return producerId;
	}
	public void setProducerId(Long producerId) {
		this.producerId = producerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Producer(Long producerId, String name) {
		super();
		this.producerId = producerId;
		this.name = name;
	}
	public Producer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
