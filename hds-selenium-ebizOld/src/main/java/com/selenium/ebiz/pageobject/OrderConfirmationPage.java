package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;

public class OrderConfirmationPage extends BaseClass {
	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf((thankYouForYourOrderText)));
	}
	/**
	 * added by Neha Dev
	 **/

	@FindBy(xpath ="//h1[contains(text(),'Order Confirmation')]")
	WebElement orderConfirmationText;

	@FindBy(xpath ="//p[contains(text(),'You will receive your order confirmation via email shortly.')]")
	WebElement orderConfirmationEmailText;

	@FindBy(xpath ="//h3[contains(text(),'Thank you for your order, it has been successfully placed.')]")
	WebElement thankYouForYourOrderText;

	//Order Confirmation Number
	@FindBy(xpath ="//div[@class='checkout__content checkout__content--direction']/p[@class='type--caption']/strong")
	WebElement orderConfirmationNumberText;
	
	
	@FindBy(xpath ="//div[@class=\"checkout__content checkout__content--direction\"]/p[@class=\"type--caption\"]//strong")
	WebElement orderNumber;


	@FindBy(xpath ="//div[@class=\"account__orders-item\"]//h3[text()='Orders']")
	WebElement ordersLink;
	

	@FindBy(xpath = "//div[@class='header__main']//div[@id='contentRecommendationWidget_HdsHeaderLogoESpot']")
	WebElement hDSupplyLogoInHeader;
	
	//
	
	/**
	 * @name getShoppingCartPaymentText
	 * @description Method to verify presence of shipping address below checkout.
	 */	
	public String getOrderConfirmationNumberText(){
		return orderConfirmationNumberText.getText().trim() ;	
	}


	
	
	public boolean isDisplayedOrderConfirmationEmailText() {
		return CommonFunctions.isElementPresent(orderConfirmationEmailText);
	}


	public boolean isDisplayedThankYouForYourOrderText() {
		return CommonFunctions.isElementPresent(thankYouForYourOrderText);
	}


	public boolean isDisplayedOrderConfirmationText() {
		return CommonFunctions.isElementPresent(orderConfirmationText);
	}
	
	public String storeOrderNumber()
	{
		return orderNumber.getText();
	}
	
	public OrderHistoryAndStatusPage clickOnOrdersLink()
	{
		ordersLink.click();
		return new OrderHistoryAndStatusPage(driver);
	}
	
	public HomePage clickOnHDSupplyLogoInHeader()
	{
		CommonFunctions.scrolltoViewElement(hDSupplyLogoInHeader, driver);
		hDSupplyLogoInHeader.click();
		return new HomePage(driver);
	}
	

}
