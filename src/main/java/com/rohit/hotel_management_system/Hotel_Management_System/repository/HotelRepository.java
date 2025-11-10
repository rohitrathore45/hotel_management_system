package com.rohit.hotel_management_system.Hotel_Management_System.repository;

import com.rohit.hotel_management_system.Hotel_Management_System.entity.Hotel;
import com.rohit.hotel_management_system.Hotel_Management_System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByOwner(User user);
}
