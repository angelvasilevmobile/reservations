package com.example.reservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservations.entity.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long>{

}
