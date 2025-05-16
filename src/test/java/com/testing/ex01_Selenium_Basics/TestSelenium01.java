package com.testing.ex01_Selenium_Basics;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium01 {
    @Test
    public void test_openVWOloginPage() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://app.vwo.com");
        driver.quit();
    }
}
