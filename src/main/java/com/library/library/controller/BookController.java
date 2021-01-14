package com.library.library.controller;



import com.library.library.model.Book;
import com.library.library.repository.BookRepository;
import com.library.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("allBooks")
    public List<Book> showBooks() {
        return bookService.findAll();
    }

    @GetMapping("booksFree")
    public List<Book> showFreeBooks(){
        return bookService.freeBooks();
    }

    @GetMapping("searchBooksByAuthor/{nameAuthor}")
    public List<Book> showBooksAuthor(@PathVariable String nameAuthor){

        return bookService.searchBooksByAuthor(nameAuthor);
    }

    @GetMapping("searchBooksByGenre/{nameGenre}")
    public List<Book> showBooksGenre(@PathVariable String nameGenre){
        return bookService.searchBookByGenre(nameGenre);
    }



}
