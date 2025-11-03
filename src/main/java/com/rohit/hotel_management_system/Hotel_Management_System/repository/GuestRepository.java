package com.rohit.hotel_management_system.Hotel_Management_System.repository;

import com.rohit.hotel_management_system.Hotel_Management_System.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}