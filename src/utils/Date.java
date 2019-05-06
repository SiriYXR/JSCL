package utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Date {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(1993, Month.OCTOBER, 19);
        System.out.println("开始时间  : " + startDate);

        LocalDate endDate = LocalDate.of(2017, Month.JUNE, 16);
        System.out.println("结束时间 : " + endDate);

        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("两天之间的差在天数   : " + daysDiff);

        Period p = Period.between(startDate, endDate);
        System.out.printf("两天之间的差 : %d 年 %d 月 %d 日", p.getYears(), p.getMonths(), p.getDays());
    }
}


