package library.controller;


import library.model.Reservation;
import library.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("reservation")
public class ReservationController {

    private final ReservationService reservationService;



    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;

    }

    @PostMapping("addReservation/{nameUser}/{nameBook}")
    public String addReservation(@PathVariable String nameUser,@PathVariable String nameBook) {
        return  reservationService.addNewReservation(nameBook,nameUser);
    }



    @DeleteMapping("deleteReservation/{nameBook}")
    public String deleteReservation(@PathVariable String nameBook) {
      return reservationService.deleteReservation(nameBook);
    }

    @PostMapping("/renewal/{nameBook}")
    public Reservation updateDept(@RequestBody Reservation reservation) {

        return reservationService.updateDate(reservation);
    }

    @GetMapping("update")
    public String updateReservation(){
        return  reservationService.updateReservations();
    }



}
