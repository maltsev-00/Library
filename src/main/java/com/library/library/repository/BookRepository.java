package com.library.library.repository;

import com.library.library.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface BookRepository extends MongoRepository<Book, Long> {
    Book findByName(String name);

}
