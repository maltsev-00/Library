package com.example.maltsev;

import library.LibraryApplication;
import library.controller.BookController;
import library.controller.ReservationController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)

public class LibraryApplicationTests {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private BookController bookController;

    @Autowired
    private ReservationController reservationController;

    @Test
    public void checkController(){
        Assert.assertNotNull(bookController);
        Assert.assertNotNull(reservationController);
    }
    @Test
    public void testGetEmployeeListSuccess() throws URISyntaxException
    {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort + "/books/allBooks";
        URI uri = new URI(baseUrl);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        Assert.assertEquals(200, result.getStatusCodeValue());

    }


    @Test
    public void showFreeBooks() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort + "/books/booksFree";
        URI uri = new URI(baseUrl);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        Assert.assertEquals(200, result.getStatusCodeValue());

    }




}