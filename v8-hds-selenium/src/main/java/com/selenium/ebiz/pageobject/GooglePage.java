package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage
{
	private WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;

	public GooglePage(WebDriver driver) 	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		this.pageManager=new PageManager(driver);
		PageFactory.initElements(driver, this);

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
		return pageManager.common().isElementPresent(googleLogo);
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
