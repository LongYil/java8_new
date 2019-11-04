package datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestDateFormatApi {

    public static void main(String[] args){
        //DateTimeFormatter：格式化时间/日期
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldft = LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh");

        String str = dateTimeFormatter.format(ldft);

        System.out.println(str);

        LocalDateTime newDate = ldft.parse(str);

        System.out.println(newDate);

    }
}
