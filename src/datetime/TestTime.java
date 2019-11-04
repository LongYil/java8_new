package datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestTime {

    public static void main(String[] args) throws Exception{
/*
        ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<>();


        ExecutorService pool = Executors.newFixedThreadPool(10);

        Callable<Date> task = ()->{
            return DateFormatThreadLocal.convert("20191015");
        };

        List<Future<Date>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            results.add(pool.submit(task));
        }

        for(Future<Date> future: results){
            System.out.println(future.get());
        }

        pool.shutdown();
*/
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");

        ExecutorService pool = Executors.newFixedThreadPool(10);

        Callable<LocalDate> task = ()->{
            return LocalDate.parse("20191015",df);
        };

        List<Future<LocalDate>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            results.add(pool.submit(task));
        }

        for(Future<LocalDate> future: results){
            System.out.println(future.get());
        }

        pool.shutdown();


    }
}

class DateFormatThreadLocal{

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static Date convert(String source) throws ParseException{
        return df.get().parse(source);
    }
}