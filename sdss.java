package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class sdss {
    private static LocalDate getFirstWorkingMonday(LocalDate birthday) {
        LocalDate start = birthday.plusYears(22);

        if (start.getDayOfWeek() == DayOfWeek.MONDAY) {
            return start;
        }

        return start.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    }
        static long count(final LocalDate birthday, final LocalDate today) {
            LocalDate firstMonday = getFirstWorkingMonday(birthday);

            if (firstMonday.isAfter(today)) {
                return 0;
            }

            LocalDate retirement = birthday.plusYears(78).minusDays(1);
            LocalDate end = retirement.isBefore(today) ? retirement : today;

            return 1 + ChronoUnit.DAYS.between(firstMonday, end) / 7;
        }

    public static void main(String[] args) {
        LocalDate date1=LocalDate.now();
        LocalDate dat2=LocalDate.of(1998,5,18);
        long k= count(dat2,date1);
        System.out.print(k);

    }






}
