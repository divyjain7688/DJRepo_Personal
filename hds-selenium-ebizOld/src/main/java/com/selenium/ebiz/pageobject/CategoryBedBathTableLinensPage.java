package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class CategoryBedBathTableLinensPage extends BaseClass{

	WebDriver driver;
	
	// Constructors
	public CategoryBedBathTableLinensPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Top Categories Crib Sheets and Blankets
	@FindBy(linkText = "Crib Sheets & Blankets")
	WebElement topCategoryCribSheetsBlanketsLinkText;
	
	// Top Categories Pot Holders
	@FindBy(linkText = "Pot Holders")
	WebElement topCategoryPotHoldersLinkText;

	// Top Categories Robes and Slippers
	@FindBy(linkText = "Robes & Slippers")
	WebElement topCategoryRobesSlippersLinkText;

	// Top Categories Shower Curtains and Liners
	@FindBy(linkText = "Shower Curtains & Liners")
	WebElement topCategoryShowerCurtainsLinersLinkText;

	// Top Categories Table Linens
	@FindBy(linkText = "Table Linens")
	WebElement topCategoryTableLinensLinkText;

	// Top Categories Towels
	@FindBy(linkText = "Towels")
	WebElement topCategoryTowelsLinkText;
 
	// Top Categories Bedding
	@FindBy(linkText = "Bedding")
	WebElement topCategoryBeddingLinkText;
	
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


	// Navigate to Back Page
	public void navigateBackToPage() {
		driver.navigate().back();
	}
	
	// Method to Click on Crib Sheets Blankets in Top Categories
	public SubCategoryBedBathTableLinensPage clickTopCategoryCribSheetsBlanketsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryCribSheetsBlanketsLinkText);
			topCategoryCribSheetsBlanketsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on Pot Holders in Top Categories
	public SubCategoryBedBathTableLinensPage clickTopCategoryPotHoldersLinkText() throws InterruptedException {
		 	WaitTool.waitForElement(driver, topCategoryPotHoldersLinkText);
			topCategoryPotHoldersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on Robes Slippers in Top Categories
	public SubCategoryBedBathTableLinensPage clickTopCategoryRobesSlippersLinkText() throws InterruptedException {
		 	WaitTool.waitForElement(driver, topCategoryRobesSlippersLinkText);
			topCategoryRobesSlippersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on Shower Curtains Liners in Top Categories
	public SubCategoryBedBathTableLinensPage clickTopCategoryShowerCurtainsLinersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryShowerCurtainsLinersLinkText);
			topCategoryShowerCurtainsLinersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on Table Linens in Top Categories
	public SubCategoryBedBathTableLinensPage clickTopCategoryTableLinensLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryTableLinensLinkText);
			topCategoryTableLinensLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on Towels in Top Categories
	public SubCategoryBedBathTableLinensPage clickTopCategoryTowelsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryTowelsLinkText);
			topCategoryTowelsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on Bedding in Top Categories
	public SubCategoryBedBathTableLinensPage clickTopCategoryBeddingLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryBeddingLinkText);
			topCategoryBeddingLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on home in Top Categories	
	public SubCategoryBedBathTableLinensPage clickCategoryHomeLinkText() throws InterruptedException {
		 	WaitTool.waitForElement(driver, categoryHomeLinkText);
			categoryHomeLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}
}
