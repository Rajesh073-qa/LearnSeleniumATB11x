package com.testing.ex07_Actions_Class;

import com.testing.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Lab36_ActionClass_Drag_Drop extends CommonToAll {

    @Test
    public void test_actions_p5() {

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement column_a = driver.findElement(By.id("column-a"));
        WebElement column_b = driver.findElement(By.id("column-b"));
        actions.dragAndDrop(column_a, column_b).build().perform();

    }
}