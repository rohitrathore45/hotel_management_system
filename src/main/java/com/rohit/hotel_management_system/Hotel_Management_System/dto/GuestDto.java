package com.rohit.hotel_management_system.Hotel_Management_System.dto;


import com.rohit.hotel_management_system.Hotel_Management_System.entity.User;
import com.rohit.hotel_management_system.Hotel_Management_System.entity.enums.Gender;
import lombok.Data;

@Data
public class GuestDto {

    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
