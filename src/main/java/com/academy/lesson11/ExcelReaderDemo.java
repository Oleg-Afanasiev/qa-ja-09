package com.academy.lesson11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReaderDemo {
    private static Logger LOG = LogManager.getLogger(ExcelReaderDemo.class.getName());

    public static void main(String[] args) {
        String path = "d:/tmp/demo/table1.xlsx";
        try(FileInputStream is = new FileInputStream(path)) {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet("sheet-demo");
            int rows = sheet.getLastRowNum();
            for (int r = 0; r <= rows; r++) {
                Row row = sheet.getRow(r);
                int cols = row.getLastCellNum();
                for (int c = 0; c < cols; c++) {
                    Cell cell = row.getCell(c);
                    System.out.println(getValueFromCell(cell));
                }
                }
//            Row row = sheet.getRow(0);
//            Cell cell1 = row.getCell(0);
//            Cell cell2 = row.getCell(1);

//            System.out.println(cell1.getStringCellValue());
//            System.out.println(cell2.getNumericCellValue());

//            System.out.println(getValueFromCell(cell1));
//            System.out.println(getValueFromCell(cell2));

        } catch (IOException e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private static String getValueFromCell(Cell cell) {
        if (cell == null)
            return "";

        if (cell.getCellType() == CellType.STRING)
            return cell.getStringCellValue();

        if (cell.getCellType() == CellType.NUMERIC)
            return Double.toString(cell.getNumericCellValue());

        return "";
    }
}
