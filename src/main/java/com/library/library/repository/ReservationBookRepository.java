package com.library.library.repository;

import com.library.library.model.Book;
import com.library.library.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReservationBookRepository extends MongoRepository<Reservation,Long> {
    void deleteByBookName(String name);
    List<Reservation> findReservationByUserName(String name);

    Reservation findReservationByBookName(String nameBook);
}
