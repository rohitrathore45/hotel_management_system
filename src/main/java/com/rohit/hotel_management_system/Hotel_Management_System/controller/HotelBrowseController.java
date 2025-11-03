package com.rohit.hotel_management_system.Hotel_Management_System.controller;


import com.rohit.hotel_management_system.Hotel_Management_System.dto.HotelDto;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.HotelInfoDto;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.HotelSearchRequest;
import com.rohit.hotel_management_system.Hotel_Management_System.service.HotelService;
import com.rohit.hotel_management_system.Hotel_Management_System.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelBrowseController {

    private final InventoryService inventoryService;
    private final HotelService hotelService;

    @GetMapping("/search")
    public ResponseEntity<Page<HotelDto>> searchHotels(@RequestBody HotelSearchRequest hotelSearchRequest){
        Page<HotelDto> page = inventoryService.searchHotels(hotelSearchRequest);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{hotelId}/info")
    public ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId){
        return ResponseEntity.ok(hotelService.getHotelInfoById(hotelId));
    }
}
