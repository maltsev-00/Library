package com.library.library.repository;

import com.library.library.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface BookRepository extends MongoRepository<Book, Long> {
    Book findByName(String name);
    List<Book> findBookByGenre(String genre);
    List<Book> findBookByAuthorsName(String genre);
}
