package com.rohit.hotel_management_system.Hotel_Management_System.service;



import com.rohit.hotel_management_system.Hotel_Management_System.dto.BookingDto;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.BookingRequest;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.GuestDto;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.HotelReportDto;
import com.stripe.model.Event;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {


    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);

    String initiatePayments(Long bookingId);

    void capturePayment(Event event);

    void cancelBooking(Long bookingId);

    String getBookingStatus(Long bookingId);

    List<BookingDto> getAllBookingsByHotelId(Long hotelId);

    HotelReportDto getHotelReport(Long hotelId, LocalDate startDate, LocalDate endDate);

    List<BookingDto> getMyBookings();
}
