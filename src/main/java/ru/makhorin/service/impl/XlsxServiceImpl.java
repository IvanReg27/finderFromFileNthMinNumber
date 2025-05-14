package ru.makhorin.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import ru.makhorin.service.XlsxService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class XlsxServiceImpl implements XlsxService {

    @Override
    public int findNthMinNumber(String path, int n) {
        List<Integer> numbers = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }

            if (numbers.isEmpty()) {
                throw new IllegalArgumentException("Файл не содержит чисел");
            }

            if (n <= 0 || n > numbers.size()) {
                throw new IllegalArgumentException("Некорректное значение N: " + n);
            }

            // Сортировка пузырьком
            for (int i = 0; i < numbers.size() - 1; i++) {
                for (int j = 0; j < numbers.size() - i - 1; j++) {
                    if (numbers.get(j) > numbers.get(j + 1)) {
                        int temp = numbers.get(j);
                        numbers.set(j, numbers.get(j + 1));
                        numbers.set(j + 1, temp);
                    }
                }
            }

            return numbers.get(n - 1);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла: " + e.getMessage(), e);
        }
    }
}
