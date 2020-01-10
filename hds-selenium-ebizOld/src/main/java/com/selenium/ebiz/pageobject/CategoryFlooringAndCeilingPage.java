package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class CategoryFlooringAndCeilingPage extends BaseClass{

	WebDriver driver;
	// Constructor
	public CategoryFlooringAndCeilingPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// Top Categories Ceramic Tile & Adhesive
	@FindBy(linkText = "Ceramic Tile & Adhesive")
	WebElement topCategoryCeramicTileAdhesiveLinkText;
	
	// Top Categories Flooring & Adhesives
	@FindBy(linkText = "Flooring & Adhesives")
	WebElement topCategoryFlooringAdhesivesLinkText;

	// Top Categories Flooring & Tile Tools
	@FindBy(linkText = "Flooring & Tile Tools")
	WebElement topCategoryFlooringTileToolsLinkText;

	// Top Categories Ceiling
	@FindBy(linkText = "Ceiling")
	WebElement topCategoryCeilingLinkText;

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


	
	// To Navigate to back Page
	public void navigateBackToPage() {
		driver.navigate().back();
	}

	// Method to Click on Ceramic Tile & Adhesive in Top Categories	
	public SubCategoryFlooringCeilingPage clickTopCategoryCeramicTileAdhesiveLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryCeramicTileAdhesiveLinkText);
			topCategoryCeramicTileAdhesiveLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFlooringCeilingPage(driver);
		}
	// Method to Click on Flooring & Adhesives in Top Categories	
	public SubCategoryFlooringCeilingPage clickTopCategoryFlooringAdhesivesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryFlooringAdhesivesLinkText);
			topCategoryFlooringAdhesivesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFlooringCeilingPage(driver);
		}
	// Method to Click on Flooring & Tile Tools in Top Categories	
	public SubCategoryFlooringCeilingPage clickTopCategoryFlooringTileToolsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryFlooringTileToolsLinkText);
			topCategoryFlooringTileToolsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFlooringCeilingPage(driver);
		}
	// Method to Click on Ceiling in Top Categories	
	public SubCategoryFlooringCeilingPage clickTopCategoryCeilingLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryCeilingLinkText);
			topCategoryCeilingLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFlooringCeilingPage(driver);
		}
	// Method to Click on home in Top Categories	
	public SubCategoryFlooringCeilingPage clickCategoryHomeLinkText() throws InterruptedException {
		 	WaitTool.waitForElement(driver, categoryHomeLinkText);
			categoryHomeLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFlooringCeilingPage(driver);
		}	
	
	
}
