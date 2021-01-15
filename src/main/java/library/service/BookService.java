package library.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import library.model.Book;
import library.model.Reservation;
import library.repository.BookRepository;
import library.repository.ReservationBookRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookService {

    private BookRepository bookRepository;
    private ReservationBookRepository reservationBookRepository;

    @Autowired
    public BookService(BookRepository bookRepository, ReservationBookRepository reservationBookRepository) {
        this.bookRepository = bookRepository;
        this.reservationBookRepository = reservationBookRepository;
    }


    public void addNewBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> freeBooks(){
        return  sortBooksByParams(bookRepository.findAll());
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    public List<Book> searchBooksByAuthor(String nameAuthor) {
      return  bookRepository.findBookByAuthorsName(nameAuthor);
    }


    public List<Book> searchBookByGenre(String nameGenre) {
        return  bookRepository.findBookByGenre(nameGenre);
    }

    private List<Book> sortBooksByParams(List<Book> bookList){
        
        List<Book> books = new LinkedList<>(bookList);
        AtomicInteger count= new AtomicInteger();

        for (Book x : bookList) {
            reservationBookRepository.findAll().forEach(y -> {
                        if (y.getBook().getName().equals(x.getName())) {
                            books.remove(count.get());
                            count.set(count.get() - 1);
                        }
                    }
            );
            count.getAndIncrement();
        }
        return books;

    }

    public List<String> searchByBookGenre(String genreBook) {


        HashSet<String> set = new HashSet<>();
        List<Book> books =bookRepository.findBookByGenre(genreBook);
        AtomicInteger count= new AtomicInteger();

        for (Book x : bookRepository.findBookByGenre(genreBook)) {
            reservationBookRepository.findAll().forEach(y -> {
                        if (y.getBook().getName().equals(x.getName())) {
                            set.add(y.getDateReserved()+"!!!"+y.getBook().getName());

                            books.remove(count.get());
                            count.set(count.get() - 1);
                        }else {
                            set.add(y.getBook().getName()+" "+y.getDateReserved());
                        }
                    }
            );
            count.getAndIncrement();
        }

        return new LinkedList<String>(set);
    }
}
