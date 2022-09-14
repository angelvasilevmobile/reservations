package com.example.reservations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservations.entity.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long>{

	List<ReservationEntity> findByDateAndHourIdAndMovieId(String date, String hourId, Long movieId);

	ReservationEntity save(ReservationEntity reservation);

}
