package com.rohit.hotel_management_system.Hotel_Management_System.repository;


import com.rohit.hotel_management_system.Hotel_Management_System.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
