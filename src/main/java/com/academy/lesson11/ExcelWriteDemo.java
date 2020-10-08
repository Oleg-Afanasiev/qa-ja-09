package com.academy.lesson11;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExcelWriteDemo {
    public static void main(String[] args) {
        String path = "d:/tmp/demo/table.xlsx";
        try(
                OutputStream os = new FileOutputStream(path);
                Workbook workbook = new SXSSFWorkbook();
        ) {
            Sheet sheet = workbook.createSheet("sheet-demo");
            Row row = sheet.createRow(0);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue("hello world");
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(12345);
            Row row2 = sheet.createRow(1);
            Cell cell3 = row2.createCell(1);
            cell3.setCellValue("Test msg");

            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
