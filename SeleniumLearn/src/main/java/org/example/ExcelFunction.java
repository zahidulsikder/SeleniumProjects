package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelFunction {
    void saveDataExcel(HashMap<String, String> excel) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sh = workbook.createSheet();
        int rowCount = 0;
        Cell celKey;
        Cell cellValue;
        for (Map.Entry<String, String> eachMap : excel.entrySet()) {
            Row row = sh.createRow(rowCount++);
            celKey = row.createCell(0);
            cellValue = row.createCell(1);
            celKey.setCellValue(eachMap.getKey());
            cellValue.setCellValue(eachMap.getValue());
        }
        FileOutputStream fso = new FileOutputStream(new File("output//excel.xlsx"));
        workbook.write(fso);
    }
}
