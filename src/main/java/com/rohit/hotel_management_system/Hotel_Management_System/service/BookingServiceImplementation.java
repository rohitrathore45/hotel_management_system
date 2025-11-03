package com.rohit.hotel_management_system.Hotel_Management_System.service;


import com.rohit.hotel_management_system.Hotel_Management_System.dto.BookingDto;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.BookingRequest;
import com.rohit.hotel_management_system.Hotel_Management_System.dto.GuestDto;
import com.rohit.hotel_management_system.Hotel_Management_System.entity.*;
import com.rohit.hotel_management_system.Hotel_Management_System.entity.enums.BookingStatus;
import com.rohit.hotel_management_system.Hotel_Management_System.exception.ResourceNotFoundException;
import com.rohit.hotel_management_system.Hotel_Management_System.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImplementation implements BookingService{
    private final GuestRepository guestRepository;
    private final ModelMapper modelMapper;

    private final BookingRepository bookingRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional
    public BookingDto initialiseBooking(BookingRequest bookingRequest) {

        log.info("Initialising booking for the hotel : {}, room : {}, date {} -- {}", bookingRequest.getHotelId(),
                bookingRequest.getRoomId(), bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate());

        Hotel hotel = hotelRepository.findById(bookingRequest.getHotelId())
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id " + bookingRequest.getHotelId()));

        Room room = roomRepository.findById(bookingRequest.getRoomId())
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id " + bookingRequest.getRoomId()));

        List<Inventory> inventoryList = inventoryRepository.findAndLockAvailableInventory(
                room.getId(),
                bookingRequest.getCheckInDate(),
                bookingRequest.getCheckOutDate(),
                bookingRequest.getRoomsCount()
        );

        long daysCount = ChronoUnit.DAYS.between(bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate()) + 1;

        if (inventoryList.size() != daysCount){
            throw new IllegalStateException("Room is not available anymore");
        }

        // Reserve the room/ update the booked count of inventories
        for(Inventory inventory : inventoryList){
            inventory.setReservedCount(inventory.getReservedCount() + bookingRequest.getRoomsCount());
        }

        inventoryRepository.saveAll(inventoryList);

        // Create the booking


        // TODO : calculate the dynamic price

        Booking booking = Booking.builder()
                .bookingStatus(BookingStatus.RESERVED)
                .hotel(hotel)
                .room(room)
                .checkInDate(bookingRequest.getCheckInDate())
                .checkOutDate(bookingRequest.getCheckOutDate())
                .user(getCurrentUser())
                .roomsCount(bookingRequest.getRoomsCount())
                .amount(BigDecimal.TEN)
                .build();

        booking = bookingRepository.save(booking);
        return modelMapper.map(booking, BookingDto.class);
    }

    @Override
    @Transactional
    public BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList) {

        log.info("Adding guests for booking with id : {}", bookingId);

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + bookingId));

        if(hasBookingExpired(booking)){
            throw new IllegalStateException("Booking has already expired");
        }
        if(booking.getBookingStatus() != BookingStatus.RESERVED){
            throw new IllegalStateException("Booking is not under reserved state, cannot add guests");
        }

        for(GuestDto guestDto : guestDtoList){
            Guest guest = modelMapper.map(guestDto, Guest.class);
            guest.setUser(getCurrentUser());
            guest = guestRepository.save(guest);

            booking.getGuests().add(guest);
        }

        booking.setBookingStatus(BookingStatus.GUESTS_ADDED);
        booking = bookingRepository.save(booking);

        return modelMapper.map(booking, BookingDto.class);
    }

    public boolean hasBookingExpired(Booking booking){
        return booking.getCreatedAt().plusMinutes(10).isBefore(LocalDateTime.now());
    }

    public User getCurrentUser(){
        // Create the booking
        User user = new User();
        user.setId(1L); // TODO: Remove the dummy user
        return user;
    }
}
