package library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private String name;//Расчет на то что тут будет больше параметров.Один параметр для проверки работы сервера
}
