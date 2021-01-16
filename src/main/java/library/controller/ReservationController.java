package library.controller;




import library.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import library.service.ReservationService;




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

    @PutMapping("renewal/{nameBook}")
    public Reservation changeRenewal(@RequestBody Reservation reservation,@PathVariable("nameBook") String nameBook){


//        Reservation reservationImpl= reservationBookRepository.findReservationByBookName(nameBook);
//        reservationImpl.setDateReserved(constants.getDtf().format(LocalDateTime.now().plusDays(5L)));
//        reservation=reservationImpl;
//        reservationBookRepository.save(reservation);

        return new Reservation();
    }


}
