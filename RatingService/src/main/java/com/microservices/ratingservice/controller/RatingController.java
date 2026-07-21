package com.microservices.ratingservice.controller;

import com.microservices.ratingservice.model.Rating;
import com.microservices.ratingservice.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    // Create rating
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Rating rating) {
        try {
            Rating savedRating =  this.ratingService.create(rating);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
        } catch (Exception e) {
            e.fillInStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add rating");
        }
    }

    // Get all ratings
    @GetMapping
    public ResponseEntity<?> getAllRatings() {
        List<Rating> ratings = this.ratingService.getAllRatings();
        if (ratings.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(ratings);
    }

    // Get all ratings by userId
    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getAllRatingsByUserId(@PathVariable String userId) {
        List<Rating> ratings = this.ratingService.getAllRatingsByUserId(userId);
        if (ratings.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(ratings);
    }


    // Get all ratings by hotelId
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<?> getAllRatingsByHotelId(@PathVariable String hotelId) {
        List<Rating> ratings = this.ratingService.getAllRatingsByHotelId(hotelId);
        if (ratings.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(ratings);
    }


}
