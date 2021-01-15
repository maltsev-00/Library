package library.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import library.model.Author;
import library.model.Book;
import library.model.Reservation;
import library.repository.BookRepository;
import library.repository.ReservationBookRepository;

import java.util.Collections;
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


    public void addNewBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> freeBooks(){

        return  sortBooksByParams(bookRepository.findAll());
    }

    public List<Book> findAll() {
        bookRepository.save(new Book(9L,"Маленький принц 4 часть", Collections.singletonList(new Author(7L,"Maltsev")),"QWE","2012",Collections.singletonList("Ru"),"О книге ",Collections.singletonList("Драма")));

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
