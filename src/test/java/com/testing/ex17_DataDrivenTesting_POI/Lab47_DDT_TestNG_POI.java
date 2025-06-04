package com.testing.ex17_DataDrivenTesting_POI;

import com.testing.CommonToAll;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab47_DDT_TestNG_POI extends CommonToAll {

    @Test(dataProvider = "getData")
    public void test_vwo_login(String email, String password) {
        System.out.println(email + " - " + password);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                new Object[]{"admin@gmail.com", "pass123"},
                new Object[]{"RANDOM@gmail.com", "pass1234"},


        };
    }
}
