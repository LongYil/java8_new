package datetime;

import java.time.*;

public class TestLocalDateTime {

    public static void main(String[] args){
        //1.LocalDate LocalTime LocalDateTime
        /*
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2015,10,10,12,22,33);

        System.out.println(ldt2);

        System.out.println(ldt2.plusDays(1));

        System.out.println(ldt2.getMonthValue());
        System.out.println(ldt2.getSecond());
        */

        //2.Instant:时间戳(以Unix 元年：1970年1月1日 到某个时间之间的毫秒值)
        /*
        Instant instant1 = Instant.now();//默认获取 UTC 时区
        System.out.println(instant1);

        OffsetDateTime odt = instant1.atOffset(ZoneOffset.ofHours(8));

        System.out.println(odt);

        Instant instant2 = Instant.ofEpochSecond(1);
        System.out.println(instant2);
        */

        //3.计算时间间隔
        //Duration：计算两个 时间 之间的间隔
        //Period: 计算两个 日期之间的间隔
        Instant instant1 = Instant.now();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant2 = Instant.now();

        Duration duration = Duration.between(instant1,instant2);
        System.out.println(duration.toMillis());

        LocalDate ld1 = LocalDate.of(2019,1,1);
        LocalDate ld2 =  LocalDate.now();
        Period period = Period.between(ld1,ld2);

        System.out.println(period);

        System.out.println(period.getDays());

    }
}
