package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SubscriptionsPage{
	private  WebDriver driver; private WaitTool   waitTool;private PageManager pageManager;

	public SubscriptionsPage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		pageManager = new PageManager(driver);
	}

	@FindBy(tagName = "h1")
	public WebElement subscriptionsPageHeadingText;
	
	@FindBy(xpath = "//*[text()='Subscription Lists']")
	public WebElement subscriptionsPagebreadcrumbText;
	
	/**
	 * get Page Heading text
	 * @return string page heading text
	 */
	public String getSubscriptionspageHeadingText() {
		waitTool.waitForElement(driver, subscriptionsPageHeadingText);
		return subscriptionsPageHeadingText.getText().trim();
	}
	
	public String getSubscriptionspagebreadcrumbText() {
		waitTool.waitForElement(driver, subscriptionsPagebreadcrumbText);
		return subscriptionsPagebreadcrumbText.getText().trim();
	}


}

