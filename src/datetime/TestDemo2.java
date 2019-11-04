package datetime;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestDemo2 {

    public static void main(String[] args){

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime time = (LocalDateTime) timeFormatter.parse("2019-10-11 12:11:11");

        time.plusHours(1);
        String str = time.toString();
        System.out.println(str);
    }
}
