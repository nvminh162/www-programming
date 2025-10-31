package com.nvminh162.springai.repository;

import com.nvminh162.springai.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    
    Optional<Booking> findByBookingNumberAndFirstNameAndLastName(
        String bookingNumber, 
        String firstName, 
        String lastName
    );
}

