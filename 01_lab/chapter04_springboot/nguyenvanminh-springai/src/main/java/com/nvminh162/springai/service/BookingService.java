package com.nvminh162.springai.service;

import com.nvminh162.springai.model.Booking;
import com.nvminh162.springai.model.BookingDetails;
import com.nvminh162.springai.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingDetails getBookingDetails(String bookingNumber, String firstName, String lastName) {
        Optional<Booking> bookingOpt = bookingRepository.findByBookingNumberAndFirstNameAndLastName(
            bookingNumber, 
            firstName, 
            lastName
        );
        
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            return new BookingDetails(
                booking.getBookingNumber(),
                booking.getFirstName(),
                booking.getLastName(),
                booking.getFrom(),
                booking.getTo(),
                booking.getDate()
            );
        }
        
        // Không tìm thấy booking
        return null;
    }
}

