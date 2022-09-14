package com.example.reservations.endpoint;

public class Actor {

	private Long actorId;
	private String name;
	public Long getActorId() {
		return actorId;
	}
	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Actor(Long actorId, String name) {
		super();
		this.actorId = actorId;
		this.name = name;
	}
	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
