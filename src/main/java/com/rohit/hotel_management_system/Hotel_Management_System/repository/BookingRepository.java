package com.rohit.hotel_management_system.Hotel_Management_System.repository;


import com.rohit.hotel_management_system.Hotel_Management_System.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByPaymentSessionId(String sessionId);
}
