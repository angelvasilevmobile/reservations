package com.example.reservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservations.entity.SeatsEntity;

public interface SeatRepository extends JpaRepository<SeatsEntity, Long>{

}
