package com.testing.Task;

import com.testing.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EbayAutomation extends CommonToAll {

    @Test
    public void findMacMiniLowestPrice() {
        driver.get("https://www.ebay.com/b/PC-Desktops-All-In-One-Computers/179/bn_661752");

        // Locate the search box and enter "macmini"
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Search for anything']"));
        searchBox.sendKeys("macmini");
        searchBox.submit();

        // Explicit wait for search results container to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'srp-results')]")));

        // Find all product items in results
        List<WebElement> items = driver.findElements(By.xpath("//li[contains(@class,'s-item')]"));
        System.out.println("Total items found: " + items.size());

        TreeMap<Double, String> priceToTitleMap = new TreeMap<>();

        for (WebElement item : items) {
            try {
                WebElement titleElement = item.findElement(By.xpath(".//h3[contains(@class,'s-item__title')]"));
                WebElement priceElement = item.findElement(By.xpath(".//span[contains(@class,'s-item__price')]"));

                String title = titleElement.getText().trim();
                String priceText = priceElement.getText().toLowerCase();

                // Debug prints
                System.out.println("Title: " + title);
                System.out.println("Raw Price: " + priceText);

                // Handle price range
                if (priceText.contains("to")) {
                    priceText = priceText.split("to")[0].trim();
                }

                // Remove everything except numbers, dot, comma
                priceText = priceText.replaceAll("[^0-9.,]", "");
                priceText = priceText.replace(",", "");

                double price = Double.parseDouble(priceText);
                priceToTitleMap.put(price, title);

            } catch (Exception e) {
                // Log or ignore
                System.out.println("Skipped item due to: " + e.getMessage());
            }
        }

        if (priceToTitleMap.isEmpty()) {
            System.out.println("No valid products with prices were found.");
        } else {
            System.out.println("Price → Product Name (Lowest first):");
            for (Map.Entry<Double, String> entry : priceToTitleMap.entrySet()) {
                System.out.println("$" + entry.getKey() + " → " + entry.getValue());
            }
        }
    }
}
