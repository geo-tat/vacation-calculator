package ru.neoflex.vacationcalculator.controller;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.vacationcalculator.service.CalculatorService;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService service;

    @GetMapping("/calculate")
    public double calculateVacation(@RequestParam double averageSalary,
                                    @RequestParam  @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate vacationStart,
                                    @RequestParam int vacationDays) {
        return service.calculateVacationPay(averageSalary,vacationStart,vacationDays);
    }
}
