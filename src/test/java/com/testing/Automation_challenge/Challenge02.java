package com.testing.Automation_challenge;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

//Navigate to the Web Tables - Pgae - https://demoqa.com/webtables
//Click on the 3rd edit button
public class Challenge02 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
    }

    @Test
    public void webTableAddAndVerify() throws InterruptedException {
        // Click 3rd Edit button (use dynamic locator based on row index)
        List<WebElement> editButtons = driver.findElements(By.xpath("//span[@title='Edit']"));
        if (editButtons.size() >= 3) {
            WebElement element = editButtons.get(2);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500); // Give time for scrolling and any overlays to disappear
        }

        // Click "Add" button
        driver.findElement(By.id("addNewRecordButton")).click();

        // New Employee Data
        String firstName = "Rajesh";
        String lastName = "CS";
        String email = "rajeshcs@test.com";
        String age = "27";
        String salary = "85001";
        String department = "QA";

        // Fill the form
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(age);
        driver.findElement(By.id("salary")).sendKeys(salary);
        driver.findElement(By.id("department")).sendKeys(department);
        driver.findElement(By.id("submit")).click();

        // Verify the new row is present using email (unique field)
        WebElement newRow = driver.findElement(By.xpath("//div[@class='rt-tr-group']//div[text()='" + email + "']/ancestor::div[@class='rt-tr-group']"));

        // Assert each field
        Assert.assertTrue(newRow.getText().contains(firstName));
        Assert.assertTrue(newRow.getText().contains(lastName));
        Assert.assertTrue(newRow.getText().contains(email));
        Assert.assertTrue(newRow.getText().contains(age));
        Assert.assertTrue(newRow.getText().contains(salary));
        Assert.assertTrue(newRow.getText().contains(department));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}