package com.library.library.controller;


import com.library.library.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("reservation")
public class ReservationController {

    @Autowired
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("addReservation/{nameUser}/{nameBook}")
    public void addReservation(@PathVariable String nameUser,@PathVariable String nameBook) {

        reservationService.addNewReservation(nameBook,nameUser);
    }

    @DeleteMapping("deleteReservation/{nameBook}")
    public void deleteReservation(@PathVariable String nameBook) {
        reservationService.deleteReservation(nameBook);
    }

}
