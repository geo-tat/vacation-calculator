package ru.neoflex.vacationcalculator;

import java.time.LocalDate;

public interface CalculatorService {
    double calculateVacationPay(double averageSalary, LocalDate vacationStart, int vacationDays);


}
