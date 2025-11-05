package com.rohit.hotel_management_system.Hotel_Management_System.dto;

import com.rohit.hotel_management_system.Hotel_Management_System.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelPriceDto {

    private Hotel hotel;
    private Double price;
}
