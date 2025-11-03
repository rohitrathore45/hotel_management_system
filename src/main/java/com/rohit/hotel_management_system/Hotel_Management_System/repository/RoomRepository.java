package com.rohit.hotel_management_system.Hotel_Management_System.repository;

import com.rohit.hotel_management_system.Hotel_Management_System.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
