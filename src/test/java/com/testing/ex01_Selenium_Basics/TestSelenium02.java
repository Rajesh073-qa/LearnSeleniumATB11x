package com.testing.ex01_Selenium_Basics;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium02 {
    @Description("Open the app.vwo.com and verify the title!")
    @Test

    public void test_selenium02() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        String tittle = driver.getTitle();
        System.out.println(tittle);
        Assert.assertEquals(driver.getTitle(), tittle);
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");
        driver.quit();
    }
}
