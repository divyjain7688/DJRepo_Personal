package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuotesConfirmationPage {

	private  WebDriver driver; private WaitTool   waitTool;

	public QuotesConfirmationPage(WebDriver driver) {
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath ="//h1[contains(text(),'Quote Confirmation')]")
	public WebElement quoteConfirmationText;

	@FindBy(xpath ="//p[contains(text(),'You will receive your order confirmation via email shortly.')]")
	public WebElement orderConfirmationEmailText;

	@FindBy(xpath ="//h3[contains(text(),'Thank you for your order, it has been successfully placed.')]")
	public WebElement thankYouForYourOrderText;

	//Order Confirmation Number
	@FindBy(xpath ="//div[@class='checkout__content checkout__content--direction']/p[@class='type--caption']/strong")
	WebElement orderNumber;

	@FindBy(xpath ="//div[@class=\"account__orders-item\"]//h3[text()='Orders']")
	WebElement ordersLink;

	public String storeOrderNumber()
	{
		waitTool.waitForElement(driver, orderNumber);
		return orderNumber.getText();
	}
	
	public boolean isDisplayedQuoteConfirmationText()
	{
		waitTool.waitForElement(driver, quoteConfirmationText);
		return quoteConfirmationText.isDisplayed();
	}

	public OrdersPage clickOnOrdersLink()
	{
		ordersLink.click();
		return new OrdersPage(driver);
	}

}
