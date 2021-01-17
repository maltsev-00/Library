package library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation  {


    @Id
    private String id;
    private User user;
    private Book book;
    private String dateReserved;


}
