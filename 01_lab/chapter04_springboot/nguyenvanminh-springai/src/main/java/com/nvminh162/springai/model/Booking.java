package com.nvminh162.springai.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    
    @Id
    @Column(name = "booking_number", length = 20)
    private String bookingNumber;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "from_location", nullable = false)
    private String from;
    
    @Column(name = "to_location", nullable = false)
    private String to;
    
    @Column(name = "flight_date", nullable = false)
    private String date;
    
    @Column(name = "passenger_count")
    private Integer passengerCount;
    
    @Column(name = "seat_class")
    private String seatClass;
}

