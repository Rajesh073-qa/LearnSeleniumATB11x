package com.testing.ex10_Actions_Class;

import com.testing.CommonToAll;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Lab35_ActionClass_P4 extends CommonToAll {
    @Test
    public void test_page_up_page_down() {
        driver.get("https://thetestingacademy.com/");
        driver.manage().window().maximize();
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_UP).build().perform();
    }
}