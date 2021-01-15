package store.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import store.model.Book;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Long> {
    Book findByName(String name);
    List<Book> findBookByGenre(String genre);
    List<Book> findBookByAuthorsName(String genre);
}