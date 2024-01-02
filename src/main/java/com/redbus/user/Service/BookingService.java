package com.redbus.user.Service;

import com.redbus.Operator.entity.BusOperator;
import com.redbus.Operator.entity.TicketCost;
import com.redbus.Operator.repository.BusOperatorRepository;
import com.redbus.Operator.repository.TicketCostRepository;
import com.redbus.user.entity.Booking;
import com.redbus.user.payload.BookingDetailsDto;
import com.redbus.user.payload.PassengerDetails;
import com.redbus.user.repository.BookingRepository;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private BusOperatorRepository busOperatorRepository;
    private TicketCostRepository ticketCostRepository;

    public BookingService(BookingRepository bookingRepository, BusOperatorRepository busOperatorRepository, TicketCostRepository ticketCostRepository) {
        this.bookingRepository = bookingRepository;
        this.busOperatorRepository = busOperatorRepository;
        this.ticketCostRepository = ticketCostRepository;

    }


    public BookingDetailsDto createBus(String busId, long ticketId, PassengerDetails passengerDetails) {
        BusOperator bus = busOperatorRepository.findById(busId).get();
        TicketCost ticketCost = ticketCostRepository.findById(ticketId).get();


        Booking booking=new Booking();
        String bookingId = UUID.randomUUID().toString();
        booking.setBookingId(bookingId);
        booking.setBusId(busId);
        booking.setTicketId(ticketId);
        booking.setBusId(bus.getBusId());
        booking.setToCity(bus.getArrivalCity());
        booking.setFromCity(bus.getDepartureCity());
        booking.setBusCompany(bus.getBusOperatorCompanyName());
        booking.setPrice(ticketCost.getCost());
        booking.setFirstName(passengerDetails.getFirstName());
        booking.setLastName(passengerDetails.getLastName());
        booking.setEmail(passengerDetails.getEmail());
        booking.setMobile(passengerDetails.getMobile());
        Booking booked= bookingRepository.save(booking);


        BookingDetailsDto dto=new BookingDetailsDto();
        dto.setBookingId(booked.getBookingId());
        dto.setBusCompany(booked.getBusCompany());
        dto.setToCity(booked.getToCity());
        dto.setFromCity(booked.getFromCity());
        dto.setFirstName(booked.getFirstName());
        dto.setEmail(booked.getEmail());
        dto.setLastName(booked.getLastName());
        dto.setMobile(booked.getMobile());
        return  dto;
    }
}

