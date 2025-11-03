package com.rohit.hotel_management_system.Hotel_Management_System.service;


import com.rohit.hotel_management_system.Hotel_Management_System.dto.HotelDto;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.HotelSearchRequest;
import com.rohit.hotel_management_system.Hotel_Management_System.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteInventories(Room room);

    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);

}
