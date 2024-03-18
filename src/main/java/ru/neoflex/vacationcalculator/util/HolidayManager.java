package ru.neoflex.vacationcalculator.util;


import lombok.Getter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class HolidayManager {

    @Getter
    private static Set<LocalDate> holidays;

    static {
        holidays = new HashSet<>();

        holidays.add(LocalDate.of(2024, 1, 1));
        holidays.add(LocalDate.of(2024, 1, 2));
        holidays.add(LocalDate.of(2024, 1, 3));
        holidays.add(LocalDate.of(2024, 1, 4));
        holidays.add(LocalDate.of(2024, 1, 5));
        holidays.add(LocalDate.of(2024, 1, 6));
        holidays.add(LocalDate.of(2024, 1, 7));
        holidays.add(LocalDate.of(2024, 1, 8));
        holidays.add(LocalDate.of(2024, 2, 23));
        holidays.add(LocalDate.of(2024, 3, 8));
        holidays.add(LocalDate.of(2024, 4, 29));
        holidays.add(LocalDate.of(2024, 4, 30));
        holidays.add(LocalDate.of(2024, 5, 1));
        holidays.add(LocalDate.of(2024, 5, 9));
        holidays.add(LocalDate.of(2024, 5, 10));
        holidays.add(LocalDate.of(2024, 6, 12));
        holidays.add(LocalDate.of(2024, 11, 4));
        holidays.add(LocalDate.of(2024, 12, 30));
        holidays.add(LocalDate.of(2024, 12, 31));
    }

}

