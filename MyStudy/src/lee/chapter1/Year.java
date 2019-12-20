package lee.chapter1;

import sun.java2d.pipe.SpanIterator;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
//真香
public class Year {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        int year = today.getYear();
        System.out.println(year);
        int dayOfMonth = today.getDayOfMonth();
        System.out.println(dayOfMonth);
        int monthValue = today.getMonthValue();
        System.out.println(monthValue);
        LocalDate localDate = today.minusYears(1);
        System.out.println(localDate);
    }
}
