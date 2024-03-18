package ru.neoflex.vacationcalculator;

import jakarta.validation.ValidationException;
import org.junit.jupiter.api.Test;
import ru.neoflex.vacationcalculator.service.CalculatorService;
import ru.neoflex.vacationcalculator.service.CalculatorServiceImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {


    @Test
    public void testCalculateVacationPayDayOff() {
        CalculatorService calculatorService = new CalculatorServiceImpl();
        double averageSalary = 3000.0;
        LocalDate vacationStart = LocalDate.of(2024, 9, 13);
        int vacationDays = 10;
        double expectedVacationPayPlus = Math.round(averageSalary / 29.3 * 6 * 100) / 100.0;

        double actualVacationPayPlus = calculatorService.calculateVacationPay(averageSalary, vacationStart, vacationDays);

        assertEquals(expectedVacationPayPlus, actualVacationPayPlus);
    }

    @Test
    public void testValidationNegativeVacationDays() {
        CalculatorService calculatorService = new CalculatorServiceImpl();
        double averageSalary = 3000.0;
        int vacationDays = -5;
        LocalDate vacationStart = LocalDate.of(2024, 3, 15);
        assertThrows(ValidationException.class, () -> calculatorService.calculateVacationPay(averageSalary, vacationStart, vacationDays));
    }

    @Test
    public void testValidationNegativeAverageSalary() {
        CalculatorService calculatorService = new CalculatorServiceImpl();
        double averageSalary = -3000.0;
        int vacationDays = 10;
        LocalDate vacationStart = LocalDate.of(2024, 3, 15);
        assertThrows(ValidationException.class, () -> calculatorService.calculateVacationPay(averageSalary, vacationStart, vacationDays));
    }

    @Test
    public void testVacationPayHoliday() {
        CalculatorService calculatorService = new CalculatorServiceImpl();
        double averageSalary = 3000.0;
        LocalDate vacationStart = LocalDate.of(2024, 5, 5);
        int vacationDays = 10;
        double expectedVacationPayPlus = Math.round(averageSalary / 29.3 * 5 * 100) / 100.0;

        double actualVacationPayPlus = calculatorService.calculateVacationPay(averageSalary, vacationStart, vacationDays);

        assertEquals(expectedVacationPayPlus, actualVacationPayPlus);
    }
}