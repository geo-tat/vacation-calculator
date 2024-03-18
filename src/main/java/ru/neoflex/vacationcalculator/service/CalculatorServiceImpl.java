package ru.neoflex.vacationcalculator.service;


import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;
import ru.neoflex.vacationcalculator.util.HolidayManager;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public double calculateVacationPay(double averageSalary, LocalDate vacationStart, int vacationDays) {
        validation(averageSalary, vacationDays, vacationStart);
        if (vacationStart == null) {
            return Math.round(averageSalary / 29.3 * vacationDays * 100) / 100.0;
        }
        LocalDate vacationEnd = vacationStart.plusDays(vacationDays - 1);
        Set<LocalDate> holidays = HolidayManager.getHolidays();
        int workingDays = 0;
        LocalDate countDate = vacationStart;
        while (!countDate.isAfter(vacationEnd)) {
            if (countDate.getDayOfWeek() != DayOfWeek.SATURDAY && countDate.getDayOfWeek() != DayOfWeek.SUNDAY && !holidays.contains(countDate)) {
                workingDays++;
            }
            countDate = countDate.plusDays(1);
        }
        return Math.round(averageSalary / 29.3 * workingDays * 100) / 100.0;
    }

    private static void validation(Double averageSalary, Integer vacationDays, LocalDate vacationStart) {
        if (vacationStart != null && vacationStart.isBefore(LocalDate.now())) {
            throw new ValidationException("Дата начала отпуска в прошлом");
        }
        if (vacationDays < 0) {
            throw new ValidationException("Количество отпускных дней не может быть отрицательным");
        }
        if (averageSalary < 0) {
            throw new ValidationException("Средняя заработная плата не может быть отрицательной величиной");
        }
    }
}
