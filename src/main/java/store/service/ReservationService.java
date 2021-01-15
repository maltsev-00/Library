package store.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.model.Book;
import store.model.Reservation;
import store.model.User;
import store.repository.BookRepository;
import store.repository.ReservationBookRepository;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationBookRepository reservationBookRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ReservationService(ReservationBookRepository reservationBookRepository, BookRepository bookRepository) {
        this.reservationBookRepository = reservationBookRepository;
        this.bookRepository = bookRepository;
    }

    public void addNewReservation(String nameBook,String name){
        Reservation reservation = reservationBookRepository.findReservationByBookName(nameBook);
        if(reservation==null) {
            List<Reservation> reservations = reservationBookRepository.findReservationByUserName(name);


            if (reservations.size() < 5) {

                Book book = bookRepository.findByName(nameBook);
                if (book != null)
                    reservationBookRepository.save(new Reservation(4L, new User(name), book));

            }
        }



    }
    public void deleteReservation(String nameBook){
        reservationBookRepository.deleteByBookName(nameBook);
    }


}
