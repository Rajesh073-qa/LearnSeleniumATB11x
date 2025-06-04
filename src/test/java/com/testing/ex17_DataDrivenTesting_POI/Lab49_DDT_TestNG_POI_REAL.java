package com.testing.ex17_DataDrivenTesting_POI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Lab49_DDT_TestNG_POI_REAL {
    @Test(dataProvider = "getData")
    public void vwo_login(String email, String password) {
        System.out.println(email + " " + password);

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return UtilExcel.getTestDataFromExcel("Sheet1");
    }
}
