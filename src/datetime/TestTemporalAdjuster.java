package datetime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestTemporalAdjuster {

    public static void main(String[] args){
        //TemporalAdjuster: 时间校正器
        LocalDateTime ldt = LocalDateTime.now();

        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);

        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        System.out.println(ldt3);

        //自定义：下一个工作日是什么时候
        ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dow = ldt4.getDayOfWeek();

            if(dow.equals(DayOfWeek.TUESDAY)){
                return ldt4.plusDays(3);
            }else if(dow.equals(DayOfWeek.SATURDAY)){
                return ldt4.plusDays(2);
            }else{
                return ldt4.plusDays(1);
            }

        });

    }




}
