package ru.makhorin.service;

/**
 * Интерфейс для поиска пользователем N-ого минимального числа из файла
 */
public interface XlsxService {

    /**
     * Метод для поиска N-ого минимального числа из файла
     */
    int findNthMinNumber(String path, int n);
}
