package com.example.reservations.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie_entity")
public class MovieEntity extends NamedEntity {

	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<ActorEntity> actors;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<ProducerEntity> producers;

	@Column
	private BigDecimal price;
	
	public List<ActorEntity> getActors() {
		return actors;
	}

	public void setActors(List<ActorEntity> actors) {
		this.actors = actors;
	}

	public List<ProducerEntity> getProducers() {
		return producers;
	}

	public void setProducers(List<ProducerEntity> producers) {
		this.producers = producers;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public MovieEntity(List<ActorEntity> actors, List<ProducerEntity> producers, BigDecimal price) {
		super();
		this.actors = actors;
		this.producers = producers;
		this.price = price;
	}

	public MovieEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
