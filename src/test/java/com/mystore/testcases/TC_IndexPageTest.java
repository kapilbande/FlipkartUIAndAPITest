package com.mystore.testcases;
import java.util.*;
import com.mystore.pageobject.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_IndexPageTest extends BaseClass {
    static String ProductNameOfsecondHighestPrice = "";
    static int uiProductCount = 0;
    @Test(enabled = true)
    public void verifySearchFlipkart() throws InterruptedException {
        try {
            IndexPage pg = new IndexPage(driver);
            pg.clickOnSearchBarAndSearchProduct();
            pg.clickOnFlipkartAssured();
            System.out.println("flipkart assured success");
            Thread.sleep(10000);
            WebElement internalStorage = driver.findElement(By.xpath("//div[text()='Internal Storage']"));
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(internalStorage));
            internalStorage.click();
            System.out.println("internal storage clicked success");
            driver.findElement(By.xpath("//div[text()='256 GB & Above']")).click();
            System.out.println("256 GB clicked success");
            WebElement highLow = driver.findElement(By.xpath("//div[text()='Price -- High to Low']"));
            wait.until(ExpectedConditions.visibilityOf(highLow));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", highLow);
            System.out.println("high low clicked success");
            driver.navigate().refresh();
            List<WebElement> productsElements = driver.findElements(By.xpath("//div[contains(text(),'SAMSUNG Galaxy')]"));
            uiProductCount = productsElements.size();
            System.out.println("Number of products in list: " + productsElements.size());
            List<WebElement> productPricesElements = driver.findElements(By.xpath("//div[@class='hl05eU']/div[1]"));
            List<WebElement> productDetailsLinks = driver.findElements(By.xpath("//a[contains(@href, 'samsung-galaxy')]"));
            LinkedHashMap<String, Integer> hashmap = new LinkedHashMap<String, Integer>();

            // Print the text of each product
            for (int i = 0; i < productsElements.size(); i++) {
                System.out.println(productsElements.get(i).getText() + " " + productPricesElements.get(i).getText());
                hashmap.put(productsElements.get(i).getText(), Integer.valueOf(productPricesElements.get(i).getText().replaceAll("[^\\d.]", "")));
            }

            // Accessing the second highest Price
            if (hashmap.size() >= 2) {
                int highestValue = 0;
                int secondHighestValue = 0;
                String highestKey = "";
                String secondHighestKey = "";

                // Iterate through the entries of the HashMap
                for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
                    int value = entry.getValue();
                    String key = entry.getKey();

                    // Update highestValue and highestKey if current value is greater
                    if (value > highestValue) {
                        secondHighestValue = highestValue;
                        secondHighestKey = highestKey;
                        highestValue = value;
                        highestKey = key;
                    } else if (value > secondHighestValue && value < highestValue) {
                        // Update secondHighestValue and secondHighestKey if current value is greater than the second highest value
                        secondHighestValue = value;
                        secondHighestKey = key;
                    }
                }

                // Print the second highest value and its corresponding key
                if (secondHighestKey != null) {
                    System.out.println("Second highest price: " + secondHighestValue);
                    System.out.println("Corresponding product: " + secondHighestKey);
                    ProductNameOfsecondHighestPrice = secondHighestKey;
					Assert.assertTrue(true);
                } else {
                    System.out.println("Not enough products to find second highest price.");
					Assert.assertTrue(false);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			System.out.println("Test complete");

        }

    }


}
