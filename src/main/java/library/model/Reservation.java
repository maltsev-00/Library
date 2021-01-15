package library.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "reservation")
public class Reservation  {
    @Id
    private Long id;
    private User user;
    private Book book;
    private Date dateReserved;

    public Reservation() {}

    public Reservation(Long id, User user, Book book) {
        this.id = id;
        this.user = user;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDateReserved() {
        return dateReserved;
    }

    public void setDateReserved(Date dateReserved) {
        this.dateReserved = dateReserved;
    }
}
