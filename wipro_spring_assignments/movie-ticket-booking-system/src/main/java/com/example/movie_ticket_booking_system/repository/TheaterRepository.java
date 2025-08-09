package com.example.movie_ticket_booking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie_ticket_booking_system.model.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

}
