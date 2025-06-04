package com.testing.ex17_DataDrivenTesting_POI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {
    static Workbook book;
    static Sheet sheet;
    public static String path = System.getProperty("user.dir") + "/src/test/java/com/testing/Resource/TestData.xlsx";

    public static Object[][] getTestDataFromExcel(String SheetName) throws FileNotFoundException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            System.out.println(path);
            book = WorkbookFactory.create(fileInputStream);
            sheet = book.getSheet(SheetName);
        } catch (IOException e) {
            System.out.println("File not found!!");
        }
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {

                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();

            }

        }
        return data;
    }
}