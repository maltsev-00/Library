package com.library.library.service;

import com.library.library.model.Book;
import com.library.library.model.Reservation;
import com.library.library.repository.BookRepository;
import com.library.library.repository.ReservationBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;
    private ReservationBookRepository reservationBookRepository;

    @Autowired
    public BookService(BookRepository bookRepository, ReservationBookRepository reservationBookRepository) {
        this.bookRepository = bookRepository;
        this.reservationBookRepository = reservationBookRepository;
    }

    public List<Book> freeBooks(){
        List<Reservation> reservations = reservationBookRepository.findAll();
        if(reservations.size()==0){
            return bookRepository.findAll();
        }

        List<Book> allBooks = bookRepository.findAll();
        List<Book> booksFree = new LinkedList<>();


        for(Book book:allBooks){
            for(Reservation reservation: reservations){

                if(!book.getName().equals(reservation.getBook().getName())){
                    booksFree.add(book);
                }
            }
        }
        return booksFree;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
