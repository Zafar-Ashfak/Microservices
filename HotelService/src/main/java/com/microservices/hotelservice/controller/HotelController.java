package com.microservices.hotelservice.controller;

import com.microservices.hotelservice.model.Hotel;
import com.microservices.hotelservice.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    // Create hotel
    @PostMapping
    public ResponseEntity<?> createHotel(Hotel hotel) {
        try {
             Hotel savedHotel =  this.hotelService.createHotel(hotel);
            return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
        } catch (Exception e) {
            e.fillInStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create hotel");
        }
    }

    // Get hotel by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getHotel(@PathVariable String id) {
        Hotel hotel =  this.hotelService.getHotel(id);
        if (hotel != null) {
            ResponseEntity.ok(hotel);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID: " + id + "not found");
    }

    // Get all hotels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotelList = this.hotelService.getAllHotels();
        if (hotelList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(hotelList);
        }
    }

    // update hotel

    // delete hotel
}
