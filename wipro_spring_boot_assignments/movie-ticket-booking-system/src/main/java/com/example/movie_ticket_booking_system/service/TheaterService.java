package com.example.movie_ticket_booking_system.service;

import com.example.movie_ticket_booking_system.model.Theater;
import com.example.movie_ticket_booking_system.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Optional<Theater> getTheaterById(Long id) {
        return theaterRepository.findById(id);
    }

    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public Theater updateTheater(Long id, Theater theaterDetails) {
        return theaterRepository.findById(id).map(theater -> {
            theater.setName(theaterDetails.getName());
            theater.setLocation(theaterDetails.getLocation());
            return theaterRepository.save(theater);
        }).orElse(null);
    }

    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}
