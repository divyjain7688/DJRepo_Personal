package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;

public class CreateNewQuote_Modal {
	private WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;
	private String newQuoteName;
	String quoteName = "Quote_";
	
	public CreateNewQuote_Modal(WebDriver driver) 	
	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager=new PageManager(driver);
	}

	@FindBy(xpath="//input[@data-hds-tag='create-new-quote__add-parts__part-row']")
	public List<WebElement> partNumbers;
	
	@FindBy(xpath="//input[@class='jq-quote-add--input']")
	public WebElement quoteNameTextBox;
	
	@FindBy(xpath="//button[@id='createNewQuoteBtn']")
	public WebElement createNewQuoteButton;
	
	@FindBy(xpath="//*[@data-hds-tag='create-new-list__header']")
	public WebElement createNewQuoteText;
	
	public String createNewQuoteWithSixPartNumbers(String partNumber1,String partNumber2,String partNumber3,String partNumber4
			,String partNumber5,String partNumber6) 
	{
		String partnumber[] = { partNumber1, partNumber2, partNumber3, partNumber4, partNumber5, partNumber6 };
		waitTool.waitForElement(driver, createNewQuoteText);
		pageManager.common().scrolltoViewElement(createNewQuoteText, driver);
		int i = 0;
		for (WebElement pn : partNumbers) {
			pageManager.common().scrolltoViewElement(pn, driver);
			pn.clear();
			pn.sendKeys(partnumber[i]);
			i++;
		}
		String quoteName = enterQuoteName();
	//	createNewQuoteButton.click();
		pageManager.common().scrolltoClickElement(createNewQuoteButton, driver);
		System.out.println("quoteName is "+ quoteName);
		return quoteName;
	}
	
	
	public String createNewQuoteWithOnePartNumber(String partNumber1) 
	{
		waitTool.waitForElement(driver, createNewQuoteText);
		pageManager.common().scrolltoViewElement(createNewQuoteText, driver);
		pageManager.common().scrolltoViewElement(partNumbers.get(0), driver);
		partNumbers.get(0).clear();
		partNumbers.get(0).sendKeys(partNumber1);
		String quoteName = enterQuoteName();
		createNewQuoteButton.click();
		System.out.println("quoteName is "+ quoteName);
		return quoteName;
	}

	
	public String enterQuoteName()
	{
		quoteName=quoteName+pageManager.common().getRandomNumber();
		waitTool.waitForElement(driver, quoteNameTextBox);
		quoteNameTextBox.sendKeys(quoteName);
		return quoteName;
	}
}
