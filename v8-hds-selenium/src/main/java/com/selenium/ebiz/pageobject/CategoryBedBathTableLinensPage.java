package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryBedBathTableLinensPage {

	private  WebDriver driver; private WaitTool   waitTool;
	// Constructors
	public CategoryBedBathTableLinensPage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
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
			waitTool.waitForElement(driver, topCategoryCribSheetsBlanketsLinkText);
			topCategoryCribSheetsBlanketsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on Pot Holders in Top Categories
	public SubCategoryBedBathTableLinensPage clickTopCategoryPotHoldersLinkText() throws InterruptedException {
		 	waitTool.waitForElement(driver, topCategoryPotHoldersLinkText);
			topCategoryPotHoldersLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on Robes Slippers in Top Categories
	public SubCategoryBedBathTableLinensPage clickTopCategoryRobesSlippersLinkText() throws InterruptedException {
		 	waitTool.waitForElement(driver, topCategoryRobesSlippersLinkText);
			topCategoryRobesSlippersLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on Shower Curtains Liners in Top Categories
	public SubCategoryBedBathTableLinensPage clickTopCategoryShowerCurtainsLinersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryShowerCurtainsLinersLinkText);
			topCategoryShowerCurtainsLinersLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on Table Linens in Top Categories
	public SubCategoryBedBathTableLinensPage clickTopCategoryTableLinensLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryTableLinensLinkText);
			topCategoryTableLinensLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on Towels in Top Categories
	public SubCategoryBedBathTableLinensPage clickTopCategoryTowelsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryTowelsLinkText);
			topCategoryTowelsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on Bedding in Top Categories
	public SubCategoryBedBathTableLinensPage clickTopCategoryBeddingLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryBeddingLinkText);
			topCategoryBeddingLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}

	// Method to Click on home in Top Categories	
	public SubCategoryBedBathTableLinensPage clickCategoryHomeLinkText() throws InterruptedException {
		 	waitTool.waitForElement(driver, categoryHomeLinkText);
			categoryHomeLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryBedBathTableLinensPage(driver);
		}
}
