package ru.makhorin.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import ru.makhorin.service.XlsxService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

@Service
public class XlsxServiceImpl implements XlsxService {

    /**
     * Метод для получения минимального числа из файла
     *
     */
    public int findMin(String path) {
        try (FileInputStream fis = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            Integer min = null;

            while (rows.hasNext()) {
                Row row = rows.next();
                Cell cell = row.getCell(0);

                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    int value = (int) cell.getNumericCellValue();
                    if (min == null || value < min) {
                        min = value;
                    }
                }
            }

            if (min == null) {
                throw new IllegalArgumentException("Файл не содержит чисел");
            }

            return min;
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + e.getMessage(), e);
        }
    }
}
