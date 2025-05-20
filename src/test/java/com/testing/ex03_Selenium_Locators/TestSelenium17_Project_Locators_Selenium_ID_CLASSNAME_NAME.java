package com.testing.ex03_Selenium_Locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestSelenium17_Project_Locators_Selenium_ID_CLASSNAME_NAME {
    @Owner("Rajesh C S")
    @Description("TC#1 - Verify that with invalid login, error message is displayed!")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void test_vwo_login_invalid_login() throws InterruptedException {

        // Step 1 - Find the EMAIL ID and enter the admin@admin.com.
        // Step 2 - Find the Password  and enter the 1234.
        // Step 3 - Find the Submit  and click on the button.
        // Step 4 - Wait some time.
        // Step 5 - Verify the message error message.

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://app.vwo.com");
        //<input type="email" class="text-input W(100%)" name="username" id="login-username"
        // data-qa="hocewoqisi" data-gtm-form-interact-field-id="0">
        WebElement Email = driver.findElement(By.id("login-username"));
        Email.sendKeys("cs.rajesh073@gmail.com");

        //<input type="password" class="text-input W(100%)" name="password" id="login-password"
        // data-qa="jobodapuxe">
        WebElement Password = driver.findElement(By.id("login-password"));
        Password.sendKeys("83ned93i93");

        //<button type="submit" id="js-login-btn" class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)"
        // onclick="login.login(event)"data-qa="sibequkica">
        //<span class="icon loader hidden" data-qa="zuyezasugu"></span>
        //<span data-qa="ezazsuguuy">Sign in</span>
        //</button>
        WebElement Submit = driver.findElement(By.id("js-login-btn"));
        Submit.click();

        //<div class="notification-box-description" id="js-notification-box-msg" data-qa="rixawilomi">Your email,
        // password, IP address or location did not match</div>
        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        System.out.println(error_message.getText());
        Thread.sleep(3000);

        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");

        driver.quit();

    }
}
