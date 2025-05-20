package com.testing.ex03_Selenium_Locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class TestSelenium18_LinkText_Partial_Text_TagName_Locators {

    // <a
    // href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
    // class="text-link"
    // data-qa="bericafeqo">
    // Start a free trial
    //
    //</a>

//        // Link Text - Full Text Match
//        WebElement a_tag_free_trail_full_match = driver.findElement(By.linkText("Start a free trial"));
//        // If the element locator is invalid - no such element: Unable to locate element: {"method":"link text","selector":"Start a free tria"}
//        a_tag_free_trail_full_match.click();


    // Start a free trial
    // Start a free
    // Start a
    // Start , Trail, free, a, Star...
    @Description("Verify vwo")
    @Owner("Rajesh")
    @Test
    public void test_login_vwo() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");

//        WebElement a_tag_free_trail_full_match = driver.findElement(By.linkText("Start a free trial"));
//        a_tag_free_trail_full_match.click();
        WebElement a_tag_partial_match = driver.findElement(By.partialLinkText("trial"));
        // Start a free trial
        // Start a free
        // Start a
        // Start , Trail, free, a, Star...
        a_tag_partial_match.click();

        driver.quit();


    }
}
