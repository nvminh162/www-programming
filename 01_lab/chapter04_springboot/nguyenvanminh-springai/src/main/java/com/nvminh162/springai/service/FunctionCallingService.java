package com.nvminh162.springai.service;

import com.nvminh162.springai.model.BookingDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class FunctionCallingService {

    // Định nghĩa functions như Java functions để sử dụng với Spring AI
    // Spring AI sẽ tự động detect và register các Bean functions
    
    @Bean(name = "getBookingDetails")
    public Function<GetBookingDetailsRequest, BookingDetails> getBookingDetailsFunction(BookingService bookingService) {
        return request -> bookingService.getBookingDetails(
            request.bookingNumber(), 
            request.firstName(), 
            request.lastName()
        );
    }

    // Request DTOs
    public record GetBookingDetailsRequest(String bookingNumber, String firstName, String lastName) {}
}

