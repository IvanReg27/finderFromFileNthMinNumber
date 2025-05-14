package ru.makhorin.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import ru.makhorin.algorithm.QuickSelect;
import ru.makhorin.service.XlsxService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class XlsxServiceImpl implements XlsxService {

    public int findNthMinNumber(String path, int n) {
        try (FileInputStream fis = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            List<Integer> numbers = new ArrayList<>();

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }

            if (numbers.size() < n) {
                throw new IllegalArgumentException("В файле меньше чисел, чем указано");
            }

            // эффективный алгоритм (применяем свой QuickSelect, средняя сложность алгоритма O(n))
            int[] arr = numbers.stream().mapToInt(i -> i).toArray();
            QuickSelect qs = new QuickSelect();
            return qs.findNthSmallest(arr, n);

        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла", e);
        }
    }
}
