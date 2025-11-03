package com.rohit.hotel_management_system.Hotel_Management_System.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class HotelContactInfo {

    private String address;

    private String phoneNumber;

    private String email;

    private String location;
}
