package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;

public class OrderHistoryAndStatusPage extends BaseClass{

	public OrderHistoryAndStatusPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(orderspageHeadingText));		
	}

	@FindBy(xpath="//h1[contains(text(),'Orders')]")
	WebElement orderspageHeadingText;

	@FindBy(xpath="//div[@class='breadcrumbs']")
	WebElement breadcrumb;

	@FindBy(xpath="//div[@class='breadcrumbs']/a[contains(text(),'Home')]")
	WebElement homeLinkInBreadcrumb;

	@FindBy(xpath="//div[@class='breadcrumbs']/a[contains(text(),'Account')]")
	WebElement accountLinkInBreadcrumb;

	/**
	 * get Page Heading text
	 * @return string page heading text
	 */
	public String getOrderspageHeadingText() 
	{
		return orderspageHeadingText.getText().trim();
	}

	public Boolean isBreadcrumbDisplayed()
	{
		return breadcrumb.isDisplayed();
	}

	public Boolean isPageTitleOrdersDisplayed()
	{
		return orderspageHeadingText.isDisplayed();
	}

	public HomePage navigateToHomePage()
	{
		homeLinkInBreadcrumb.click();
		return new HomePage(driver);
	}

	public MyAccountPage navigateToMyAccountPage()
	{
		accountLinkInBreadcrumb.click();
		return new MyAccountPage(driver);
	}

}

