package com.rohit.hotel_management_system.Hotel_Management_System.dto;


import com.rohit.hotel_management_system.Hotel_Management_System.entity.enums.BookingStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BookingDto {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer roomsCount;
    private BookingStatus bookingStatus;
    private Set<GuestDto> guests;
}
