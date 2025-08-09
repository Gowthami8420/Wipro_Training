package com.example.movie_ticket_booking_system.service;

import com.example.movie_ticket_booking_system.model.Booking;
import com.example.movie_ticket_booking_system.model.Customer;
import com.example.movie_ticket_booking_system.model.Movie;
import com.example.movie_ticket_booking_system.model.Theater;
import com.example.movie_ticket_booking_system.repository.BookingRepository;
import com.example.movie_ticket_booking_system.repository.CustomerRepository;
import com.example.movie_ticket_booking_system.repository.MovieRepository;
import com.example.movie_ticket_booking_system.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking createBooking(Long customerId, Long movieId, Long theaterId, Booking booking) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        Optional<Movie> movie = movieRepository.findById(movieId);
        Optional<Theater> theater = theaterRepository.findById(theaterId);

        if (customer.isPresent() && movie.isPresent() && theater.isPresent()) {
            booking.setCustomer(customer.get());
            booking.setMovie(movie.get());
            booking.setTheater(theater.get());
            return bookingRepository.save(booking);
        } else {
            throw new RuntimeException("Invalid movie/theater/customer ID");
        }
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setSeats(bookingDetails.getSeats());
            booking.setBookingDate(bookingDetails.getBookingDate());
            return bookingRepository.save(booking);
        }).orElse(null);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
