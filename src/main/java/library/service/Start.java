package library.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import library.model.Author;
import library.model.Book;
import library.repository.BookRepository;
import library.repository.ReservationBookRepository;

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
      //  System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      // bookRepository.save(new Book("Маленький принц 4 часть",Collections.singletonList(new Author("Maltsev")),"QWE","2012",Collections.singletonList("Ru"),"О книге ",Collections.singletonList("Драма")));

    }

}
