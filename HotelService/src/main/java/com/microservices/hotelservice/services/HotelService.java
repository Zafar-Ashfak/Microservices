package com.microservices.hotelservice.services;

import com.microservices.hotelservice.exceptions.ResourceNotFoundException;
import com.microservices.hotelservice.model.Hotel;
import com.microservices.hotelservice.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
    
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return this.hotelRepository.save(hotel);
    }

    public Hotel getHotel(String id) {
        return this.hotelRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Hotel with ID: " + id + " not found"));
    }

    public List<Hotel> getAllHotels() {
        return this.hotelRepository.findAll();
    }

    public Hotel update(Hotel hotel, String id) {
        Hotel existingHotel = this.hotelRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Hotel with ID: " + id + " not found"));

        existingHotel.setName(hotel.getName());
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setAbout(hotel.getAbout());

        return this.hotelRepository.save(existingHotel);
    }

    public void delete(String id) {
        this.hotelRepository.deleteById(id);
    }
}
