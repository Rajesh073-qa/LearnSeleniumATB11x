package com.testing.ex13_Javascript_ex;

import com.testing.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Lab40_JS_Code extends CommonToAll {

    @Test
    public void test_js() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location = 'https://www.google.com'");
        driver.get("https://selectorshub.com/xpath-practice-page/");
        WebElement div_to_scroll = driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("window.scroll(0,100)");
        String url = js.executeScript("return document.URL;").toString();
        String title = js.executeScript("return document.title;").toString();
        System.out.println(url);
        System.out.println(title);

    }
}