package com.nvminh162.springai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetails {
    private String number;
    private String firstName;
    private String lastName;
    private String from;
    private String to;
    private String date;
}

