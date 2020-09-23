package com.academy.lesson11;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExcelWriteDemo {
    public static void main(String[] args) {
        try(
                OutputStream os = new FileOutputStream("d:/tmp/demo/table.xlsx");
                Workbook workbook = new SXSSFWorkbook();
        ) {
            Sheet sheet = workbook.createSheet("sheet-demo");
            Row row = sheet.createRow(0);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue("hello");
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(123);

            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
