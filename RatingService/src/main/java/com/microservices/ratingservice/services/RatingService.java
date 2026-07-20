package com.microservices.ratingservice.services;

import com.microservices.ratingservice.model.Rating;
import com.microservices.ratingservice.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    public Rating create(Rating rating) {
        String id = UUID.randomUUID().toString();
        rating.setRatingId(id);
        return this.ratingRepository.save(rating);
    }

    public List<Rating> getAllRatings() {
        return this.ratingRepository.findAll();
    }

    public List<Rating> getAllRatingsByUserId(String userId) {
        return this.ratingRepository.findAllByUserId(userId);
    }

    public List<Rating> getAllRatingsByHotelId(String hotelId) {
        return this.ratingRepository.findAllByHotelId(hotelId);
    }
}
