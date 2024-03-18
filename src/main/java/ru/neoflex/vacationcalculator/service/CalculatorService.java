package ru.neoflex.vacationcalculator.service;

import java.time.LocalDate;

public interface CalculatorService {
    double calculateVacationPay(double averageSalary, LocalDate vacationStart, int vacationDays);


}
