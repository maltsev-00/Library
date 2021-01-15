package library.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "books")

public class Book {

	private String name;
    private List<Author> authors;
    private String publisher;
    private String year;
    private List<String> translators;
    private String description;
    private List<String> genre;

    public Book() {}

    public Book( String name, List<Author> authors, String publisher, String year, List<String> translators, String description, List<String> genre) {

        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.year = year;
        this.translators = translators;
        this.description = description;
        this.genre = genre;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getTranslators() {
        return translators;
    }

    public void setTranslators(List<String> translators) {
        this.translators = translators;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authors=" + authors +
                ", publisher='" + publisher + '\'' +
                ", year='" + year + '\'' +
                ", translators=" + translators +
                ", description='" + description + '\'' +
                ", genre=" + genre +
                '}';
    }
}
