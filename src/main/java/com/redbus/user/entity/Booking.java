package com.redbus.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @Column(name="booking_Id")
    private  String bookingId;

    @Column(name="bus_id")
    private String busId;

    @Column(name="ticket_id")
    private long ticketId;

    @Column(name="bus_company")
    private String busCompany;

    @Column(name="to_City")
    private String toCity;

    @Column(name="from_City")
    private  String fromCity;

    @Column(name="first_Name")
    private String firstName;

    @Column(name="last_Name")
    private String  lastName;

    private String email;
    private String mobile;
    private double price;

}
