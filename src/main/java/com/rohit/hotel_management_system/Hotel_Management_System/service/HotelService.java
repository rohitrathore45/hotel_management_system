package com.rohit.hotel_management_system.Hotel_Management_System.service;


import com.rohit.hotel_management_system.Hotel_Management_System.dto.HotelDto;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.HotelInfoDto;

import java.util.List;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activateHotel(Long hotelId);

    HotelInfoDto getHotelInfoById(Long hotelId);

    List<HotelDto> getAllHotels();
}
