package com.testing.Task;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class E2E_mini_project {
    @Description("To verify end to end scenario")
    @Owner("RAJESH")
    @Test
    public void katalon() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement make_my_appointment = driver.findElement(By.cssSelector("a[id='btn-make-appointment']"));
        make_my_appointment.click();
        WebElement Username = driver.findElement(By.cssSelector("input[id='txt-username']"));
        Username.sendKeys("John Doe");
        WebElement Password = driver.findElement(By.cssSelector("input[id='txt-password']"));
        Password.sendKeys("ThisIsNotAPassword");
        WebElement Login = driver.findElement(By.xpath("//button[@id='btn-login']"));
        Login.click();
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Seoul CURA Healthcare Center");
        WebElement checkbox = driver.findElement(By.id("chk_hospotal_readmission"));
        checkbox.click();
        WebElement Radio = driver.findElement(By.id("radio_program_medicaid"));
        Radio.click();
        WebElement date = driver.findElement(By.xpath("//input[contains(@id, 'txt_visit_date')]"));
        date.sendKeys("22/05/2025");
        WebElement comment = driver.findElement(By.id("txt_comment"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt_comment")));
        comment.sendKeys("CHECKING");
        WebElement button = driver.findElement(By.id("btn-book-appointment"));
        button.click();
        WebElement confirmation = driver.findElement(By.xpath("//h2[text()='Appointment Confirmation']"));
        Assert.assertEquals(confirmation.getText(), "Appointment Confirmation");
        driver.quit();

    }

}
