package com.example.reservations.endpoint;

import java.util.List;

public class Movie {

	private Long movieId;
	private String name;
	private List<Actor> actors;
	private List<Producer> producers;
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	public List<Producer> getProducers() {
		return producers;
	}
	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}
	public Movie(Long movieId, String name, List<Actor> actors, List<Producer> producers) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.actors = actors;
		this.producers = producers;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
