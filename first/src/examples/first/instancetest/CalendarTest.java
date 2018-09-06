package examples.first.instancetest;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = Calendar.getInstance();

        System.out.println(cal2.get(Calendar.YEAR));
        System.out.println(cal2.get(Calendar.MONTH)); // 1월 = 0, 12월 = 11
        System.out.println(cal2.get(Calendar.DATE));
    }
}
