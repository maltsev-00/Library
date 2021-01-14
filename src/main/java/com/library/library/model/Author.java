package com.library.library.model;


public class Author {
    private Long id;

    public Author(Long id) {
        this.id = id;
    }

    public Author(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
