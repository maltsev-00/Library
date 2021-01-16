package library.service;


import library.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import library.model.Book;
import library.repository.BookRepository;
import library.repository.ReservationBookRepository;

import java.util.*;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final ReservationBookRepository reservationBookRepository;

    @Autowired
    public BookService(BookRepository bookRepository, ReservationBookRepository reservationBookRepository) {
        this.bookRepository = bookRepository;
        this.reservationBookRepository = reservationBookRepository;
    }


    public void addNewBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> freeBooks(){
        return  sortBooksWithOutReservation();
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

    private List<Book> sortBooksWithOutReservation(){

        List<Book> books = new LinkedList<>();

        bookRepository.findAll().stream().filter(x->reservationBookRepository.findReservationByBookName(x.getName())==null)
                         .forEach(books::add);

        return books;
    }



    public List<String> searchBookTranslator(String translator) {
        List<String> infoList = new LinkedList<>();

        bookRepository.findBooksByTranslators(translator).forEach(x->{
            Reservation reservation =reservationBookRepository.findReservationByBookName(x.getName());
            if(reservation==null){
                infoList.add(x.getName()+" книга доступна");
            }
            else{
                infoList.add(x.getName()+" книга будет доступна "+reservation.getDateReserved());
            }
        });
        return infoList;
    }
}
