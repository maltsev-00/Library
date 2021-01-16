package library.service;


import library.constants.Constants;
import library.model.Book;
import library.model.Reservation;
import library.model.User;
import library.repository.BookRepository;
import library.repository.ReservationBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationService {

    private final ReservationBookRepository reservationBookRepository;
    private final BookRepository bookRepository;
    private final Constants constants;

    @Autowired
    public ReservationService(ReservationBookRepository reservationBookRepository, BookRepository bookRepository, Constants constants) {
        this.reservationBookRepository = reservationBookRepository;
        this.bookRepository = bookRepository;
        this.constants = constants;
    }

    public String addNewReservation(String nameBook,String name){

        if(reservationBookRepository.findReservationByBookName(nameBook)==null) {

            if (reservationBookRepository.findReservationByUserName(name).size() < 5) {

                Book book = bookRepository.findByName(nameBook);
                if (book != null) {
                    reservationBookRepository.save(new Reservation(new User(name), book, constants.getDtf().format(LocalDateTime.now().plusDays(5L))));
                    return "Книга зарезервирована";
                }
            }
        }
        return  "Книга не зарезервирована";

    }
    public String  deleteReservation(String nameBook){
        reservationBookRepository.deleteByBookName(nameBook);
        return "Резерв был удален";
    }


    public String changeDate(String nameBook) {

         return "Продление резерва успешно !";
    }
}
