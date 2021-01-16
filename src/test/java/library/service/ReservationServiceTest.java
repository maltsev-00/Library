package library.service;

import junit.framework.TestCase;
import library.LibraryApplication;
import library.model.Author;
import library.model.Book;
import library.repository.BookRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReservationServiceTest extends TestCase {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReservationService reservationService;

    @Test
    public void checkBookAdd(){
        Book book =new Book("Маленький принц 7 часть", Collections.singletonList(new Author("Maltsev")),"QWE","2012",Collections.singletonList("Ru"),"О книге ",Collections.singletonList("Драма"));
        Book saveBook= bookRepository.save(book);

        assertThat(saveBook).usingRecursiveComparison()
                .ignoringFields("name").isEqualTo(book);

        Assert.assertNotNull(book);
        Assert.assertNotNull(book.getName());
        Assert.assertTrue(CoreMatchers.is(book.getName()).matches(("Маленький принц 7 часть")));

    }

    @Test
    public void checkSearchByGenres(){
        assertThat(bookService.searchBookByGenre("Драма")).isNotEmpty();
    }

    @Test
    public void checkSearchByAuthors(){
        assertThat(bookService.searchBooksByAuthor("Maltsev")).isNotEmpty();
    }

    @Test
    public void findFreeBooks(){
        assertThat(bookService.freeBooks()).isNotEmpty();
    }

    @Test
    public void deleteReservation(){
        assertThat(reservationService.deleteReservation("Маленький принц 7 часть")).contains("Резерв был удален");
    }

}