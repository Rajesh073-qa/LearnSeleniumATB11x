package com.testing.Automation_challenge;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

//Calculate the Total Amount of Money Spent via Selenium Script
//Open the https://demo.applitools.com
//Enter the Username as Admin and Password as Password@123
//Verify that you are on the app.html page afterward.
//Calculate the total amount spent this month.
//Create a util which will parse and check for spent vs earned.
//Verify total is 1996.22
//Use - https://github.com/PramodDutta/AdvanceSeleniumFrameworkTTA
//Automation Table Challenge #1 - Watch Video
//Create a Framework and Use the following:
//Java, Selenium, TestNG, POM
public class Challenge01 {
    @Description("Calculate the Total Amount of Money Spent via Selenium Script")
    @Owner("Rajesh")
    @Test
    public void total_sum() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("-start--maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.applitools.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password@123");
        WebElement login = driver.findElement(By.id("log-in"));
        login.click();

        String first_part = "//table[@class='table table-padded']/tbody/tr[",
                second_part = "]/td[",
                third_part = "]";

        int row = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr")).size();
        int column = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr[1]/td")).size();
        System.out.println(row);
        System.out.println(column);
        Double amount, total = 0.0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                String dynamic_path = first_part + i + second_part + j + third_part;
                String amountText = driver.findElement(By.xpath(dynamic_path)).getText();
                amountText = amountText
                        .replace(",", "")
                        .replace("USD", "")
                        .replace(" ", "")
                        .replace("$", "")
                        .trim();

                try {
                    amount = Double.parseDouble(amountText);
                    total += amount;
                } catch (NumberFormatException e) {
                    System.out.println("Skipping non-numeric value at row " + i + ": " + amountText);
                }
            }
            System.out.println("Total amount - " + total);
            Assert.assertEquals(total, "1996.22", "Assertion verified");
            driver.quit();

        }

    }

}
