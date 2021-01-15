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

        return  sortBooksByParams(bookRepository.findAll());
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    public List<Book> searchBooksByAuthor(String nameAuthor) {

      return  sortBooksByParams(bookRepository.findBookByAuthorsName(nameAuthor));
    }


    public List<Book> searchBookByGenre(String nameGenre) {

        return  sortBooksByParams(bookRepository.findBookByGenre(nameGenre));
    }

    private List<Book> sortBooksByParams(List<Book> bookList){
        List<Reservation> reservations = reservationBookRepository.findAll();

        if(reservations.size()==0){
            return  bookList;
        }

        List<Book> listSearch = new LinkedList<>();
        bookList.forEach(x ->
                reservations.stream()
                        .filter(y-> !x.getName().equals(y.getBook().getName()))
                        .forEach(y ->listSearch.add(x))
        );


        return listSearch;

    }
}
