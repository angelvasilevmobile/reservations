package com.example.reservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservations.entity.BeveragesEntity;

public interface BeverageRepository extends JpaRepository<BeveragesEntity, Long>{

}
