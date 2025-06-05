package com.testing.ex17_DataDrivenTesting_POI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class practice {
    static Workbook workbook;
    static Sheet sheet;

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/path");
        workbook = WorkbookFactory.create(fileInputStream);
        sheet = workbook.getSheet("sheet name");

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {

                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();

            }

        }
    }
}
