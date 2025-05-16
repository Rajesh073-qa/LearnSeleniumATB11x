package com.testing.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestSelenium15_OptionClasses {
    public static void main(String[] args) {
        ChromeOptions Options = new ChromeOptions();
        //Options.addArguments("--window-size=800,600");
        Options.addArguments("--incognito");
        Options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(Options);
        driver.get("https://google.com");
        driver.quit();


    }
}