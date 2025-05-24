package com.testing.ex15_Relative_locators;

import com.testing.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab44_REAL extends CommonToAll {
    @Test
    public void pollution() {
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();
        WebElement search = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
        search.sendKeys("india" + Keys.ENTER);
        waitForJVM(5000);
        List<WebElement> locations = driver.findElements(By.xpath("//div[contains(@class, 'location-name')]"));
        for (WebElement location : locations) {
            String rank = driver.findElement(with(By.tagName("p")).toLeftOf(location)).getText();
            String AQI = driver.findElement(with(By.tagName("span")).toRightOf(location)).getText();
            System.out.println("| " + rank + " " + location.getText() + " | " + AQI + "|");
        }
    }
}
