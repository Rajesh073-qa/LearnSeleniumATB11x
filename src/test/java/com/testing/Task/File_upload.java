package com.testing.Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class File_upload {
    @Test
    public void file() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.browserstack.com/users/sign_in");
        WebElement sign = driver.findElement(By.xpath("//a[text()='Sign in with Google']"));
        sign.click();
        WebElement select_user = driver.findElement(By.xpath("//div[@data-identifier='cs.rajesh073@gmail.com']"));
        select_user.click();
        WebElement continuee = driver.findElement(By.xpath("//span[text()='Continue']"));
        continuee.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"aa-app-uploader__upload-app-btn aa-app-uploader__upload-app-btn--blue\"]")));
        WebElement upload = driver.findElement(By.xpath("//button[@class=\"aa-app-uploader__upload-app-btn aa-app-uploader__upload-app-btn--blue\"]"));
        String working_dir = System.getProperty("user.dir");
        String file_path = working_dir + "src/test/java/com/testing/APKPure_v3.20.4801_apkpure.com.apk";
        upload.sendKeys(file_path);
        driver.quit();
    }
}
