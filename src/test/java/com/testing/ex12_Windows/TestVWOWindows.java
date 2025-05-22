package com.testing.ex12_Windows;

import com.testing.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class TestVWOWindows extends CommonToAll {
    @Test
    public void vwo() {
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        driver.manage().window().maximize();
        waitForJVM(5000);
        String parent_window = driver.getWindowHandle();
        List<WebElement> list_heatmaps = driver.findElements(By.xpath("//div[@data-qa=\"yedexafobi\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(list_heatmaps.get(1)).click().build().perform();
        waitForJVM(15000);
        Set<String> all_handles = driver.getWindowHandles();
        System.out.println(all_handles);
        for (String handle : all_handles) {
            if (!handle.equals(parent_window)) {
                driver.switchTo().window(handle);
                driver.switchTo().frame("heatmap-iframe");
                WebElement click_map_button = driver.findElement(By.xpath("//span[@data-qa=\"refoyekife\"]"));
                click_map_button.click();
            }
        }

    }
}
