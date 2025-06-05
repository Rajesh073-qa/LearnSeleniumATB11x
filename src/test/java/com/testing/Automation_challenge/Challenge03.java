package com.testing.Automation_challenge;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Verify the content of the Model
//https://demoqa.com/modal-dialogs
public class Challenge03 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/modal-dialogs");
    }

    @Description("Verify the content of the Model ")
    @Owner("Rajesh C S")
    @Test
    public void content() {
        WebElement Large = driver.findElement(By.id("showLargeModal"));
        Large.click();

        String actual_text = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println(actual_text);
        Assert.assertEquals(actual_text, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");


    }

    @AfterClass
    public void tear() {
        driver.quit();
    }
}

