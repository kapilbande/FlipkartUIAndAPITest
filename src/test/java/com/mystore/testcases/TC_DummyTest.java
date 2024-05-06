package com.mystore.testcases;

import com.mystore.pageobject.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TC_DummyTest extends BaseClass {

    @Test(enabled = true)
    public void searchOnlyFlipkart() throws InterruptedException {
        try {
            IndexPage pg = new IndexPage(driver);
            pg.clickOnSearchBarAndSearchProduct();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			System.out.println("Test complete");

        }

    }


}
