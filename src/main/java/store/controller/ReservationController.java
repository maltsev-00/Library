package store.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.service.ReservationService;


@RestController
@RequestMapping("reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
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
