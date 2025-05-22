package com.testing.ex12_Windows;

import com.testing.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class Lab38_Windows_Part1 extends CommonToAll {
    @Test
    public void test_windows() {

        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        driver.manage().window().maximize();
        String parent_window = driver.getWindowHandle();
        System.out.println(parent_window);
        WebElement link_parent = driver.findElement(By.xpath("//a[text()=\"Click Here\"]"));
        link_parent.click();
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);
        for (String handle : windows) {
            driver.switchTo().window(handle);
            if (driver.getPageSource().contains("New Window")) {
                System.out.println("Testcase passed!");

            }
        }
    }

}
