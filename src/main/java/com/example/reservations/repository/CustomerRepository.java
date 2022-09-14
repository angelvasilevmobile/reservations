package com.example.reservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservations.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

}
