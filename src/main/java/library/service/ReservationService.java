package library.service;


import library.constants.Constants;
import library.exception.ResourceNotFoundException;
import library.model.Book;
import library.model.Reservation;
import library.model.User;
import library.repository.BookRepository;
import library.repository.ReservationBookRepository;

import library.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;



@Service
public class ReservationService {

    private final ReservationBookRepository reservationBookRepository;
    private final BookRepository bookRepository;
    private final Constants constants;
    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public ReservationService(ReservationBookRepository reservationBookRepository, BookRepository bookRepository, Constants constants, UserDetailsServiceImpl userDetailsService) {
        this.reservationBookRepository = reservationBookRepository;
        this.bookRepository = bookRepository;
        this.constants = constants;
        this.userDetailsService = userDetailsService;
    }

    public String addNewReservation(String nameBook){

        if(reservationBookRepository.findReservationByBookName(nameBook)==null) {

            User user =userDetailsService.currentUser();
            if (reservationBookRepository.findReservationByUserName(user.getName()).size() < 5) {

                Book book = bookRepository.findByName(nameBook);
                if (book != null) {

                    reservationBookRepository.save(new Reservation(book.getName()+"#",user, book,
                            constants.getParserFormat().format(LocalDateTime.now().plusDays(5L))));

                    return "Книга зарезервирована";
                }
                else {
                    throw new ResourceNotFoundException();
                }
            }
        }
        return  "Книга не зарезервирована";

    }
    public String deleteReservation(String nameBook)  {
       Reservation reservation = reservationBookRepository.findReservationByBookName(nameBook);
        if(reservation==null) {
            throw new ResourceNotFoundException();
        }
        reservationBookRepository.delete(reservation);
        return "Резерв был удален";

    }


    public String updateReservations() {
        LocalDateTime localDateTime =LocalDateTime.now();

        reservationBookRepository.findAll().stream()
                .filter(x->LocalDate.parse(x.getDateReserved(), constants.getParserFormat()).getDayOfMonth()<localDateTime.getDayOfMonth())
                .forEach(x->reservationBookRepository.deleteByBookName(x.getBook().getName()));

        return "База обновлена !";
    }

    public Reservation updateDate(Reservation reservation) {

        reservation.setDateReserved(String.valueOf(LocalDate.parse(reservation.getDateReserved(), constants.getParserFormat()).plusDays(5L)));
        reservationBookRepository.save(reservation);
        return reservation;
    }
}
