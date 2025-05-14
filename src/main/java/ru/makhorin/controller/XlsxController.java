package ru.makhorin.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Интерфейс для поиска пользователем N-ого минимального числа из файла
 */
@RequestMapping("/api/xlsx")
public interface XlsxController {

    /**
     * Метод для поиска N-ого минимального числа из файла
     */
    @Operation(summary = "Найти N-ое минимальное число в .xlsx файле")
    @GetMapping("/min")
    ResponseEntity<Integer> getNthMinNumber(@RequestParam String path, @RequestParam int n);
}
