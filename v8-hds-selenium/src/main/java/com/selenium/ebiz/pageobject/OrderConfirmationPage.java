package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

	private  WebDriver driver;
	private WaitTool   waitTool;
	private PageManager pageManager ;

	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager=new PageManager(driver);

	}

	@FindBy(xpath ="//h1[contains(text(),'Order Confirmation')]")
	public WebElement orderConfirmationPageTitle;

	@FindBy(xpath ="//p[contains(text(),'You will receive your order confirmation via email shortly.')]")
	WebElement orderConfirmationEmailText;

	//@FindBy(xpath ="//h3[contains(text(),'Thank you for your order, it has been successfully placed.')]")
	@FindBy(xpath ="//h3[contains(text(),'Thank you for shopping with HD Supply.')]")
	public WebElement thankYouForYourOrderText;

	@FindBy(xpath ="//div[@class=\"checkout__content checkout__content--direction\"]/p[@class=\"type--caption\"]//strong")
	public WebElement orderNumber;

	@FindBy(xpath ="//div[@class=\"account__orders-item\"]//h3[text()='Orders']")
	WebElement ordersLink;


	public boolean isDisplayedOrderConfirmationEmailText() {
		return pageManager.common().isElementPresent(orderConfirmationEmailText);
	}


	public boolean isDisplayedThankYouForYourOrderText() {
		return pageManager.common().isElementPresent(thankYouForYourOrderText);
	}


	public boolean isDisplayedOrderConfirmationPageTitle() {
		waitTool.waitForElement(driver, orderConfirmationPageTitle);
		return pageManager.common().isElementPresent(orderConfirmationPageTitle);
	}

	public String storeOrderNumber()
	{
		waitTool.waitForElement(driver, orderNumber);
		pageManager.common().scrolltoViewElement(orderNumber, driver);
		return orderNumber.getText();
	}

	public void clickOnOrdersLink()
	{
		ordersLink.click();
		//	return new OrdersPage(driver);
	}


}
