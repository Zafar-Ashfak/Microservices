package com.microservices.hotelservice.services;

import com.microservices.hotelservice.exceptions.ResourceNotFoundException;
import com.microservices.hotelservice.model.Hotel;
import com.microservices.hotelservice.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
    
    public Hotel createHotel(Hotel hotel) {
        return this.hotelRepository.save(hotel);
    }

    public Hotel getHotel(String id) {
        return this.hotelRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Hotel with ID: " + id + " not found"));
    }

    public List<Hotel> getAllHotels() {
        return this.hotelRepository.findAll();
    }
}
