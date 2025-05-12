package ru.makhorin.service;

/**
 * Интерфейс для получения пользователем минимального числа из файла
 */
public interface XlsxService {

    /**
     * Метод для получения минимального числа из файла
     *
     */
    public int findMin(String path);
}
