package com.testing.ex15_Relative_locators;

import com.testing.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab42_RL_P1 extends CommonToAll {
    @Test
    public void Relative() {
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();
        WebElement span = driver.findElement(By.xpath("//span[text()='Years of Experience']"));
        driver.findElement((with(By.id("exp-0")).toRightOf(span))).click();
    }
}
