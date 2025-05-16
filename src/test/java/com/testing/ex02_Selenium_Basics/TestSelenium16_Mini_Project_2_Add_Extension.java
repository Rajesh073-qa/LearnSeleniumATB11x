package com.testing.ex02_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class TestSelenium16_Mini_Project_2_Add_Extension {

    @Description("Options Class")
    @Test
    public void test_Selenium01() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--window-size=1920,1000");
        edgeOptions.addExtensions(new File("C:\\Users\\csraj\\IdeaProjects\\LearnSeleniumATB11x\\src\\test\\java\\com\\testing\\ex02_Selenium_Basics\\Adblock.crx"));

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.youtube.com/watch?v=BwTSxsAqlEc");
        driver.manage().deleteAllCookies();

    }
}