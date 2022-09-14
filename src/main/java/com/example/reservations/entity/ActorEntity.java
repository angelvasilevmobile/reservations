package com.example.reservations.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "actor_entity")
public class ActorEntity extends NamedEntity {

	
	@ManyToMany(mappedBy = "actors")
	private List<MovieEntity> movies;
}
