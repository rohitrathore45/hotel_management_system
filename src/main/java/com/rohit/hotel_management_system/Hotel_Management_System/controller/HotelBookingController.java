package com.rohit.hotel_management_system.Hotel_Management_System.controller;


import com.rohit.hotel_management_system.Hotel_Management_System.dto.BookingDto;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.BookingRequest;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.GuestDto;
import com.rohit.hotel_management_system.Hotel_Management_System.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class HotelBookingController {

    private final BookingService bookingService;

    @PostMapping("/init")
    public ResponseEntity<BookingDto> initialiseBooking(@RequestBody BookingRequest bookingRequest){
        return ResponseEntity.ok(bookingService.initialiseBooking(bookingRequest));
    }

    @PostMapping("/{bookingId}/addGuests")
    public ResponseEntity<BookingDto> addGuests(@PathVariable Long bookingId, @RequestBody List<GuestDto> guestDtoList){
        return ResponseEntity.ok(bookingService.addGuests(bookingId, guestDtoList));
    }
}
