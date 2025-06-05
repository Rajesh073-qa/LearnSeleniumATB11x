package com.testing.Automation_challenge;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;
//Open the link of Heatmap
//      With Action class click on the Link to open the variation.
//     Verify that you are able to click on the Click map

public class Challenge05 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1&accountId=666400");
    }

    @Description("Verify the content of the Model ")
    @Owner("Rajesh C S")
    @Test
    public void iframe() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> view_heatwave = driver.findElements(By.xpath("//li[@id='js-heatmap-thumbnail']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(view_heatwave));
        Actions actions = new Actions(driver);
        actions.moveToElement(view_heatwave.get(1)).click().build().perform();
        String parent_window = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);
        for (String handle : windows) {
            if (!handle.equals(parent_window)) {
                driver.switchTo().window(handle);
                driver.switchTo().frame("heatmap-iframe");

                WebElement click = driver.findElement(By.xpath("//div[@data-qa=\"liqokuxuba\"]"));
                click.click();
            }
        }


    }

    @AfterClass
    public void tear() {
        driver.quit();
    }
}
