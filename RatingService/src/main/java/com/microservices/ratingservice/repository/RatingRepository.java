package com.microservices.ratingservice.repository;

import com.microservices.ratingservice.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {
    public List<Rating> findAllByUserId(String userId);
    public List<Rating> findAllByHotelId(String hotelId);
}
