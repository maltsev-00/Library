package store.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import store.model.Author;
import store.model.Book;
import store.repository.BookRepository;
import store.repository.ReservationBookRepository;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class Start {

    private final BookRepository bookRepository;

    private final ReservationBookRepository reservationBookRepository;


    @Autowired
    public Start(BookRepository bookRepository, ReservationBookRepository reservationBookRepository) {
        this.bookRepository = bookRepository;
        this.reservationBookRepository = reservationBookRepository;
    }

    @PostConstruct
    public void start() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
       bookRepository.save(new Book(9L,"Маленький принц 4 часть",Collections.singletonList(new Author(7L,"Maltsev")),"QWE","2012",Collections.singletonList("Ru"),"О книге ",Collections.singletonList("Драма")));

    }

}
