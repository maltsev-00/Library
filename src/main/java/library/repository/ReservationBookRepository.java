package library.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import library.model.Reservation;

import java.util.List;

public interface ReservationBookRepository extends MongoRepository<Reservation,Long> {
    void deleteByBookName(String name);
    List<Reservation> findReservationByUserName(String name);
    Reservation findReservationByBookName(String nameBook);
    void deleteByDateReserved(String data);
}
