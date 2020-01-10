package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class CategoryDoorsAndMoldingPage extends BaseClass{

	WebDriver driver;
	// Constructor
	public CategoryDoorsAndMoldingPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	// Top Categories Doors
	@FindBy(linkText = "Doors")
	WebElement topCategoryDoorsLinkText;
	
	// Top Categories Molding
	@FindBy(linkText = "Molding")
	WebElement topCategoryMoldingLinkText;

	//To home page link
	@FindBy(xpath = "//*[@id='WC_BreadCrumb_Link_1_1_-3028_40453']")
	WebElement categoryHomeLinkText;
	
	//To Verify for the top category
	@FindBy(xpath = "//*[@id='PageHeading_2_-3001_40466']/h1")
	WebElement topCategoryPageHeadingText;
	
	// To Get the Text from the Page Heading
	public String getCategoryPageHeadingText() {
		return topCategoryPageHeadingText.getText().trim();
	}

	
	// Navigate to Previous page
	public void navigateBackToPage() {
		driver.navigate().back();
	}
	
	// Method to Click on Doors in Top Categories
	public SubCategoryDoorsAndMouldingPage clickTopCategoryDoorsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryDoorsLinkText);
			topCategoryDoorsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryDoorsAndMouldingPage(driver);
		}

	// Method to Click on Molding in Top Categories
	public SubCategoryDoorsAndMouldingPage clickTopCategoryMoldingLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryMoldingLinkText);
			topCategoryMoldingLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryDoorsAndMouldingPage(driver);
		}	

	// Method to Click on home in Top Categories	
		public SubCategoryDoorsAndMouldingPage clickCategoryHomeLinkText() throws InterruptedException {
				WaitTool.waitForElement(driver, categoryHomeLinkText);
				categoryHomeLinkText.click();
				WaitTool.waitFor(driver,true) ;
				return new SubCategoryDoorsAndMouldingPage(driver);
			}
	

}
