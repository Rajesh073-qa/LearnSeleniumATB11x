package com.testing.ex04_Selenium_XPATH;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium21_MiniProject_3 {
    @Description("")
    @Owner("Rajesh")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void test_katalon_login() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement make_my_appointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        make_my_appointment.click();
        List<WebElement> username = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username.get(1).sendKeys("John Doe");

        List<WebElement> password = driver.findElements(By.xpath("//input[@placeholder='Password']"));
        password.get(1).sendKeys("ThisIsNotAPassword");

        WebElement login = driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();

        driver.quit();

    }
}
