package com.example.reservations.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producer_entity")
public class ProducerEntity extends NamedEntity {

	@ManyToMany(mappedBy = "producers")
	private List<MovieEntity> movies;
}
