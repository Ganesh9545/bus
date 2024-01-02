package com.redbus.user.Contoller;

import com.redbus.user.Service.BookingService;
import com.redbus.user.payload.BookingDetailsDto;
import com.redbus.user.payload.PassengerDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {


    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    //http://localhost:8080/api/bookings?busId=&ticketId=
    @PostMapping
    public ResponseEntity<BookingDetailsDto> bookbus(
            @RequestParam("busId")  String busId,
            @RequestParam("ticketId")  long ticketId,
            @RequestBody PassengerDetails passengerDetails){

       BookingDetailsDto dto= bookingService.createBus(busId,ticketId,passengerDetails);
       return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

}
