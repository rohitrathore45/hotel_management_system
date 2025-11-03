package com.rohit.hotel_management_system.Hotel_Management_System.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> subErrors;
}
