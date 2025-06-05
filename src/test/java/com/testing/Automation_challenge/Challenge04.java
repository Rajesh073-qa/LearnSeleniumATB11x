package com.testing.Automation_challenge;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
// Login and Dashboard Page Automation in App.vwo.com and Run in two browsers parallel.
//Open the https://app.vwo.com/
//Enter the Username as 93npu2yyb0@esiix.com and Password as Wingify@123
//Verify that you after log in dashboard is visible with the Wingify username on dashboard page.
//Run them in 2 browsers side by side and check if you can run it parallel.
public class Challenge04 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/");
    }

    @Description("Verify the content of the Model ")
    @Owner("Rajesh C S")
    @Test
    public void content() {
    }
}