package com.rohit.hotel_management_system.Hotel_Management_System.dto;

import com.rohit.hotel_management_system.Hotel_Management_System.entity.HotelContactInfo;
import lombok.Data;

@Data
public class HotelDto {

    private Long id;

    private String name;

    private String city;

    // stores the url of images
    private String[] photos;

    // stores the list of amenities -> Wi-Fi, and all
    private String[] amenities;

    private HotelContactInfo contactInfo;

    private Boolean active;
}
