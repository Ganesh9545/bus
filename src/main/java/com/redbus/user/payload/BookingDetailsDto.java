package com.redbus.user.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetailsDto {

    private  String bookingId;
    private String busCompany;
    private String toCity;
    private  String fromCity;
    private String firstName;
    private String  lastName;
    private String email;
    private String mobile;
    private double price;
}
