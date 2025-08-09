package com.example.movie_ticket_booking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie_ticket_booking_system.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
