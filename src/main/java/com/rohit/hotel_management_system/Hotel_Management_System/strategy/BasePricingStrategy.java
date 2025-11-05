package com.rohit.hotel_management_system.Hotel_Management_System.strategy;

import com.rohit.hotel_management_system.Hotel_Management_System.entity.Inventory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public class BasePricingStrategy implements PricingStrategy{

    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        return inventory.getRoom().getBasePrice();
    }
}
