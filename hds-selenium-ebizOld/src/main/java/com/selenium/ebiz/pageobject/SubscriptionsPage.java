package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;

public class SubscriptionsPage extends BaseClass{

	public SubscriptionsPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(subscriptionsPageHeadingText));		
	}

	@FindBy(tagName = "h1")
	WebElement subscriptionsPageHeadingText;

	/**
	 * get Page Heading text
	 * @return string page heading text
	 */
	public String getSubscriptionspageHeadingText() {
		return subscriptionsPageHeadingText.getText().trim();
	}

}

