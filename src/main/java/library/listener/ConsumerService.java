package library.listener;//package com.library.library.listener;



import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import library.model.Book;

@Service
public class ConsumerService {

    @KafkaListener(topics = "test", group = "group_json", containerFactory = "bookKafkaListenerFactory")
    public void consumeJson(Book book) {
        System.out.println("Consumed JSON Message: " + book);
    }
}
