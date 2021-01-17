package library.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {


	private String name;
    private List<Author> authors;
    private String publisher;
    private String year;
    private List<String> translators;
    private String description;
    private List<String> genre;

   
}
