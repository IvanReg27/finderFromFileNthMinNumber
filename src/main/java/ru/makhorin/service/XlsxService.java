package ru.makhorin.service;

/**
 * Интерфейс для поиска пользователем минимального числа из файла
 */
public interface XlsxService {

    /**
     * Метод для поиска минимального числа из файла
     */
    public int findMin(String path);
}
