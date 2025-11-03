package com.rohit.hotel_management_system.Hotel_Management_System.service;



import com.rohit.hotel_management_system.Hotel_Management_System.dto.BookingDto;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.BookingRequest;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.GuestDto;

import java.util.List;

public interface BookingService {


    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
