package com.testing.ex10_Actions_Class;

import com.testing.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Lab34_ActionClass_MakeMyTRIP_example extends CommonToAll {

    @Test
    public void test_actions_p4() {
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        // Wait for the popup to come and click the x icon
        //span[@data-cy='closeModal']
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
        WebElement modal = driver.findElement(By.xpath("span[@data-cy='closeModal']"));
        modal.click();
        WebElement fromCity = driver.findElement(By.xpath("//input[@data-cy='fromCity']"));


        // sendKeys ->
        // popups, moveElement -> actions.send
        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("IXR").build().perform();
        waitForJVM(3000);
        List<WebElement> auto_suggestion= driver.findElements(By.className("//ul[@class='react-autosuggest__suggestions-list']"));
        for(WebElement e:auto_suggestion){
            if(e.getText().contains("Chandigarh")){
                e.click();

                driver.quit();
            }
        }
    }
}