package com.mystore.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {
	//create object of webdriver
	WebDriver ldriver;

	//constructor
	public IndexPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//identify webelements
	@FindBy(xpath= "//input[@name='q']")
	WebElement SearchBar;
	
	@FindBy(xpath="(//input[@type='checkbox']/following::div)[3]")
	WebElement cbFlipkartAssured;

	@FindBy(xpath="//div[text()='Internal Storage']")
	WebElement InternalStorage;

	//identify action on webelement
	public void clickOnSearchBarAndSearchProduct() {
		SearchBar.click();
		SearchBar.sendKeys("Samsung Galaxy S24");
		SearchBar.submit();
	}

	public void clickOnFlipkartAssured() {
		WebDriverWait wait = new WebDriverWait(ldriver, 10);
		wait.until(ExpectedConditions.visibilityOf(cbFlipkartAssured));
		cbFlipkartAssured.click();
	}
	
}
