package com.library.library.service;


import com.library.library.model.Author;
import com.library.library.model.Book;
import com.library.library.model.Reservation;
import com.library.library.model.User;
import com.library.library.repository.BookRepository;
import com.library.library.repository.ReservationBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

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
       bookRepository.save(new Book(3L,"Маленький принц423423",Collections.singletonList(new Author(5L)),"QWE","2012",Collections.singletonList("Ru"),"О книге "));

    }

}
