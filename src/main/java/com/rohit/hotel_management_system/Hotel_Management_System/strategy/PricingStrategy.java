package com.rohit.hotel_management_system.Hotel_Management_System.strategy;

import com.rohit.hotel_management_system.Hotel_Management_System.entity.Inventory;

import java.math.BigDecimal;


public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);
}
