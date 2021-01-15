package store.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.model.Author;
import store.model.Book;

import java.util.Collections;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, Book> kafkaTemplate;

    private static final String TOPIC = "test";

    @GetMapping("publish")
    public String post() {
        kafkaTemplate.send(TOPIC, new Book(7L,"Гуф", Collections.singletonList(new Author(7L,"Maltsev")),"QWE","2012",Collections.singletonList("Ru"),"О книге ",Collections.singletonList("Драма")));

        return "Published successfully";
    }

    @GetMapping("p")
    public String post1() {
       // kafkaTemplate.send(TOPIC, new Book(7L,"Гуф", Collections.singletonList(new Author(7L,"Maltsev")),"QWE","2012",Collections.singletonList("Ru"),"О книге ",Collections.singletonList("Драма")));

        return "Published successfully";
    }
}
