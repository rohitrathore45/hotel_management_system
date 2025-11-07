package com.rohit.hotel_management_system.Hotel_Management_System.repository;

import com.rohit.hotel_management_system.Hotel_Management_System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
