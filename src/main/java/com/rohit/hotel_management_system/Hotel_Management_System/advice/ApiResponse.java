package com.rohit.hotel_management_system.Hotel_Management_System.advice;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private LocalDateTime timeStamp;
    private T data;
    private ApiError error;

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }


    public ApiResponse(T data){
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error){
        this();
        this.error = error;
    }
}
