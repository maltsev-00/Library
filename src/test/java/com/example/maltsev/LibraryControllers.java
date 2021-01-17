package com.example.maltsev;

import library.LibraryApplication;
import library.controller.BookController;
import library.controller.ReservationController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LibraryControllers {

    @Autowired
    private BookController bookController;

    @Autowired
    private ReservationController reservationController;

    private MockMvc mockMvc;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController)
                .build();
    }

    @Test
    public void testControllersClass(){
        Assert.assertNotNull(bookController);
        Assert.assertNotNull(reservationController);
    }

    @Test
    public void testAllBooks() throws Exception {

        mockMvc.perform(get("/books/allBooks")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void showFreeBooks() throws Exception {

        mockMvc.perform(get("/books/booksFree"))
                .andExpect(status().isOk());

    }




}