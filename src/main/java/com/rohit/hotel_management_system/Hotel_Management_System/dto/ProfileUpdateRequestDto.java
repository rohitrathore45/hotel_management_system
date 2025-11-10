package com.rohit.hotel_management_system.Hotel_Management_System.dto;

import com.rohit.hotel_management_system.Hotel_Management_System.entity.enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileUpdateRequestDto {

    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
}
