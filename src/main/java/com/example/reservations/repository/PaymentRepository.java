package com.example.reservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservations.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{

}
