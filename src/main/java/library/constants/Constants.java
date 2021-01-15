package library.constants;

import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class Constants {

    private  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public Constants() {}

    public Constants(DateTimeFormatter dtf) {
        this.dtf = dtf;
    }

    public DateTimeFormatter getDtf() {
        return dtf;
    }

    public void setDtf(DateTimeFormatter dtf) {
        this.dtf = dtf;
    }
}
