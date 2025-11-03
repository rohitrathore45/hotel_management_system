package com.rohit.hotel_management_system.Hotel_Management_System.service;


import com.rohit.hotel_management_system.Hotel_Management_System.dto.HotelDto;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.HotelInfoDto;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.RoomDto;
import com.rohit.hotel_management_system.Hotel_Management_System.entity.Hotel;
import com.rohit.hotel_management_system.Hotel_Management_System.entity.Room;
import com.rohit.hotel_management_system.Hotel_Management_System.exception.ResourceNotFoundException;
import com.rohit.hotel_management_system.Hotel_Management_System.repository.HotelRepository;
import com.rohit.hotel_management_system.Hotel_Management_System.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImplementation implements HotelService{

    private final HotelRepository hotelRepository;
    private final InventoryService inventoryService;
    private final ModelMapper modelMapper;
    private final RoomRepository roomRepository;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating new Hotel with name : {}", hotelDto.getName());
        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        hotel.setActive(false);
        hotel = hotelRepository.save(hotel);
        log.info("Created new Hotel with id : {}", hotel.getId());
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting the hotel by id : {}", id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id : " + id));
        log.info("Successfully  fetched the hotel with id {} ", id);
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Updating the hotel by id : {}", id);

        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id : " + id));

        modelMapper.map(hotelDto, hotel);
        hotel.setId(id);

        hotel = hotelRepository.save(hotel);

        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    @Transactional
    public void deleteHotelById(Long id) {
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id : " + id));

        for(Room room : hotel.getRooms()){
            inventoryService.deleteInventories(room);
            roomRepository.deleteById(room.getId());
        }
        hotelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void activateHotel(Long hotelId) {
        log.info("Activating the hotel by id : {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id : " + hotelId));

        hotel.setActive(true);

        // assuming only does it once
        for(Room room : hotel.getRooms()){
            inventoryService.initializeRoomForAYear(room);
        }
    }

    @Override
    public HotelInfoDto getHotelInfoById(Long hotelId) {
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id : " + hotelId));

        List<RoomDto> rooms = hotel.getRooms()
                .stream()
                .map((element) -> modelMapper.map(element, RoomDto.class))
                .toList();

        return new HotelInfoDto(modelMapper.map(hotel, HotelDto.class), rooms);
    }
}
