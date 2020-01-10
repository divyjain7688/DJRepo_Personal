package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class QuotesPage extends BaseClass{
	
	public QuotesPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(quotespageHeadingText));		
	}
	
	@FindBy(xpath="//h1[text()='Quote Lists']")
	WebElement quotespageHeadingText;
	
	@FindBy(xpath = "//div[contains(text(),'Quote2')]")
	WebElement quoteNameInTable;
	
	@FindBy(xpath = "//tbody[@id=\"quote-table-body\"]/tr[1]//a[text()='Checkout Quote']")
	WebElement checkoutQuoteLinkOfLatestQuote;
	
	/**
	 * get Page Heading text
	 * @return string page heading text
	 */
	public String getQuotesPageHeadingText() {
		return quotespageHeadingText.getText().trim();
	}

	public boolean isDisplayedQuotesPageHeadingText(){
		return quotespageHeadingText.isDisplayed();	
	}
	
	public void QuotesPageHeadingText(){
		quotespageHeadingText.isDisplayed();	
	}
	
	public boolean isDisplayedQuoteNameInTable(){
		return quoteNameInTable.isDisplayed();	
	}
	
	public PaymentAndCheckOutPage clickOnCheckoutQuoteLinkOfLatestQuote() throws Exception
	{
		//WaitTool.hardWait();
		WaitTool.waitForElement(driver, checkoutQuoteLinkOfLatestQuote);
		CommonFunctions.scrolltoViewElement(checkoutQuoteLinkOfLatestQuote, driver);
		checkoutQuoteLinkOfLatestQuote.click();
		return new PaymentAndCheckOutPage(driver);
	}
	
}

