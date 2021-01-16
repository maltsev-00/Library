package library.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Constants {
    private  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
}
