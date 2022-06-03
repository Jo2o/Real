package j.problems.ch03.BONUS_1_ConvertYearMonthToDate.src.main.java.modern.challenge;

import java.time.YearMonth;
import java.util.Date;

public class MainApplication {

    public static void main(String[] args) {

        System.out.println("Date to YearMonth: " + Converters.toYearMonth(new Date()));
        System.out.println("YearMonth to Date: " + Converters.toDate(YearMonth.now()));
    }
}
