package com.testing.ex15_Relative_locators;

import com.testing.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab43_RL_P2 extends CommonToAll {
    @Test
    public void relative() {
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();
        driver.switchTo().frame("result");
        WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
        submit.click();
        WebElement Username = driver.findElement(By.id("username"));
        WebElement error_message = driver.findElement(with(By.tagName("small")).below(Username));
        String error_text_user = error_message.getText();
        Assert.assertEquals(error_text_user, "Username must be at least 3 characters", "Testcase Passed!");
        WebElement email = driver.findElement(By.id("email"));
        WebElement error_message_email = driver.findElement(with(By.tagName("small")).below(email));
        String error_text_email = error_message_email.getText();
        Assert.assertEquals(error_text_email, "Email is not invalid");
        WebElement password = driver.findElement(By.id("password"));
        WebElement error_pwd = driver.findElement(with(By.tagName("small")).below(password));
        String error_pwd_text = error_pwd.getText();
        Assert.assertEquals(error_pwd_text, "Password must be at least 6 characters");
        WebElement confirm_pwd = driver.findElement(By.id("password2"));
        WebElement error_message_confirm_pwd = driver.findElement(with(By.tagName("small")).below(confirm_pwd));
        String error_text_confirm_pwd = error_message_confirm_pwd.getText();
        Assert.assertEquals(error_text_confirm_pwd, "Password2 is required");
    }
}
