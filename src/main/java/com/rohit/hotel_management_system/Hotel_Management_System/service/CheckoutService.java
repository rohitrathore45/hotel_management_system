package com.rohit.hotel_management_system.Hotel_Management_System.service;

import com.rohit.hotel_management_system.Hotel_Management_System.entity.Booking;

public interface CheckoutService {

    String getCheckoutSession(Booking booking, String successUrl, String failureUrl);
}
