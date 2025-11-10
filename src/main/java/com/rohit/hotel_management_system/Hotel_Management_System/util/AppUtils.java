package com.rohit.hotel_management_system.Hotel_Management_System.util;

import com.rohit.hotel_management_system.Hotel_Management_System.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class AppUtils {

    public static User getCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
