package com.selenium.ebiz.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;

public class GooglePage extends BaseClass {

	public GooglePage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(googleLogo));
	}

	//Header google hogo
	@FindBy(xpath = "//span[@class='ctr-p']//img")
	WebElement googleLogo;

	//google search text field
	@FindBy(xpath = "//div[@id='gs_lc0']/input")
	WebElement googleSearchText;

	/**
	 * Method to verify if google logo is displayed.
	 * @return driver to GoogleSearchResultPage
	 */
	public boolean isDisplayedgoogleLogo(){
		return CommonFunctions.isElementPresent(googleLogo);
	}

	/**
	 * Method to enter the search data in google search and click on enter.
	 * @return driver to GoogleSearchResultPage
	 */
	public GoogleSearchResultPage enterGoogleSearchData(String Data){
		System.out.println("jsafdjakfd");
		googleSearchText.sendKeys(Data);
		System.out.println("jsafdjakfd");
		googleSearchText.sendKeys(Keys.ENTER);
		return new GoogleSearchResultPage(driver);

	}
}
