package com.testing.Task;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Calculate_amount_table {
    @Description("Calculate the Total Amount of Money Spent via Selenium Script ")
    @Owner("Rajesh")
    @Test
    public void amount() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://demo.applitools.com");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("Admin");
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("Password@123");
        WebElement submit = driver.findElement(By.id("log-in"));
        submit.click();
        String dashboard = driver.getCurrentUrl();
        Assert.assertEquals(dashboard, "https://demo.applitools.com/app.html");

        //table[@class='table table-padded']/tbody/tr[1]/td[5]
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
                //+ 1,250 USD
                amountText = amountText.replace(",", "").replace("USD", "").replace(" ", "").replace("$", "").trim();

                try {
                    amount = Double.parseDouble(amountText);
                    total += amount;
                } catch (NumberFormatException e) {
                    System.out.println("Skipping non-numeric value at row " + i + ": " + amountText);
                }

            }

        }
        System.out.println("Total amount - " + total);
        Assert.assertEquals(total, "1996.22", "Assertion verified");
        driver.quit();


    }
}
