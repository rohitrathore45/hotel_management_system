package com.rohit.hotel_management_system.Hotel_Management_System.dto;

import lombok.Data;

@Data
public class SingUpRequestDto {

    private String email;
    private String password;
    private String name;
}
