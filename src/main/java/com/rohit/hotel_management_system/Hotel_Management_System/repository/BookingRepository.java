package com.rohit.hotel_management_system.Hotel_Management_System.repository;


import com.rohit.hotel_management_system.Hotel_Management_System.entity.Booking;
import com.rohit.hotel_management_system.Hotel_Management_System.entity.Hotel;
import com.rohit.hotel_management_system.Hotel_Management_System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByPaymentSessionId(String sessionId);

    List<Booking> findByHotel(Hotel hotel);

    List<Booking> findByHotelAndCreatedAtBetween(Hotel hotel, LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<Booking> findByUser(User user);
}
