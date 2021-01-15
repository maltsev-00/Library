package library.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "reservation")
public class Reservation  {

    private User user;
    private Book book;
    private String dateReserved;

    public Reservation() {}

    public Reservation(User user, Book book, String dateReserved) {
        this.user = user;
        this.book = book;
        this.dateReserved = dateReserved;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDateReserved() {
        return dateReserved;
    }

    public void setDateReserved(String dateReserved) {
        this.dateReserved = dateReserved;
    }
}
