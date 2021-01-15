package library.listener;



import library.repository.BookRepository;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import library.model.Book;

@Service
public class ConsumerService {

    private final BookService bookService;

    @Autowired
    public ConsumerService(BookService bookService) {
        this.bookService = bookService;
    }


    @KafkaListener(topics = "test", group = "group_json", containerFactory = "bookKafkaListenerFactory")
    public void consumeJson(Book book) {
        bookService.addNewBook(book);
    }
}
