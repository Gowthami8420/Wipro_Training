package com.example.movie_ticket_booking_system.service;

import com.example.movie_ticket_booking_system.model.Movie;
import com.example.movie_ticket_booking_system.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Create a new movie
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Get movie by ID
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    // Delete a movie
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    // Update an existing movie
    public Optional<Movie> updateMovie(Long id, Movie movieDetails) {
        return movieRepository.findById(id).map(movie -> {
            movie.setTitle(movieDetails.getTitle());
            movie.setGenre(movieDetails.getGenre());
            movie.setTheaters(movieDetails.getTheaters()); // if you want to update theater association
            return movieRepository.save(movie);
        });
    }
}
