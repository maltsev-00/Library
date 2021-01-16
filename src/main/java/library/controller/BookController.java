package library.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import library.model.Book;
import library.service.BookService;

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

    @GetMapping("searchBookByTranslate/{translator}")
    public List<String> searchByBookByName(@PathVariable String translator){
        return bookService.searchBookTranslator(translator);
    }



}
