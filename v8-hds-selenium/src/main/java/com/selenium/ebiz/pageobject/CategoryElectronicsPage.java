package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryElectronicsPage {


	private  WebDriver driver; private WaitTool   waitTool;
	// Constructor
	public CategoryElectronicsPage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		
	}

	/* Element identifiers. */

	// Top Categories Surveillance and Security
	@FindBy(linkText = "Surveillance & Security")
	WebElement topCategorySurveillanceSecurityLinkText;

	// Top Categories Telephone and Video Repair
	@FindBy(linkText = "Telephone & Video Repair")
	WebElement topCategoryTelephoneVideoRepairLinkText;
	
	// Top Categories Speaker
	@FindBy(linkText = "Speakers")
	WebElement topCategorySpeakersLinkText;
	
	// Top Categories Television Mounts
	@FindBy(linkText = "Television Mounts")
	WebElement topCategoryTelevisionMountsLinkText;

	// Top Categories Television Remote Controls
	@FindBy(linkText = "Television Remote Controls")
	WebElement topCategoryTelevisionRemoteControlsLinkText;

	// Top Categories Televisions
	@FindBy(linkText = "Televisions")
	WebElement topCategoryTelevisionsLinkText;

	// Top Categories clock Radios
	@FindBy(linkText = "Clock Radios")
	WebElement topCategoryClockRadiosLinkText;

	// Top Categories ADA Communications
	@FindBy(linkText = "ADA Communications")
	WebElement topCategoryADACommunicationsLinkText;

	// Top Categories TDD Telecom kits
	@FindBy(linkText = "TDD Telecom Kits")
	WebElement topCategoryTDDTelecomKitsLinkText;

	// Top Categories Telephones
	@FindBy(linkText = "Telephones")
	WebElement topCategoryTelephonesLinkText;

	// Top Categories Two way Radios
	@FindBy(linkText = "Two-Way Radios")
	WebElement topCategoryTwoWayRadiosLinkText;
	
	//To Verify for the top category
	@FindBy(xpath = "//*[@id='PageHeading_2_-3001_40466']/h1")
	WebElement topCategoryPageHeadingText;

	//To home page link
	@FindBy(xpath = "//*[@id='WC_BreadCrumb_Link_1_1_-3028_40453']")
	WebElement categoryHomeLinkText;
	
		
	// To Get the Text from the Page Heading
	public String getCategoryPageHeadingText() {
		return topCategoryPageHeadingText.getText().trim();
		}

	// Navigate to Previous Page
	public void navigateBackToPage() {
		driver.navigate().back();
	}
	
	// Method to Click on Surveillance Security in Top Categories
	public SubCategoryElectronicsPage clickTopCategorySurveillanceSecurityLinkText() throws InterruptedException {
		 	waitTool.waitForElement(driver, topCategorySurveillanceSecurityLinkText);
			topCategorySurveillanceSecurityLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectronicsPage(driver);
		}	
	// Method to Click on Telephone video Repair in Top Categories
	public SubCategoryElectronicsPage clickTopCategoryTelephoneVideoRepairLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryTelephoneVideoRepairLinkText);
			topCategoryTelephoneVideoRepairLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectronicsPage(driver);
		}	
	// Method to Click on Speakers Top Categories
	public SubCategoryElectronicsPage clickTopCategorySpeakersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategorySpeakersLinkText);
			topCategorySpeakersLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectronicsPage(driver);
		}	
	// Method to Click on Television Mounts in Top Categories
	public SubCategoryElectronicsPage clickTopCategoryTelevisionMountsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryTelevisionMountsLinkText);
			topCategoryTelevisionMountsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectronicsPage(driver);
		}	
	// Method to Click on Television Remote Controls in Top Categories
	public SubCategoryElectronicsPage clickTopCategoryTelevisionRemoteControlsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryTelevisionRemoteControlsLinkText);
			topCategoryTelevisionRemoteControlsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectronicsPage(driver);
		}	
	// Method to Click on Televisions in Top Categories
	public SubCategoryElectronicsPage clickTopCategoryTelevisionsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryTelevisionsLinkText);
			topCategoryTelevisionsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectronicsPage(driver);
		}	
	// Method to Click on ClockRadios in Top Categories
	public SubCategoryElectronicsPage clickTopCategoryClockRadiosLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryClockRadiosLinkText);
			topCategoryClockRadiosLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectronicsPage(driver);
		}	
	// Method to Click on ADA Commnunications in Top Categories
	public SubCategoryElectronicsPage clickTopCategoryADACommunicationsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryADACommunicationsLinkText);
			topCategoryADACommunicationsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectronicsPage(driver);
		}	

	// Method to Click on TDD Telecom Kits in Top Categories
	public SubCategoryElectronicsPage clickTopCategoryTDDTelecomKitsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryTDDTelecomKitsLinkText);
			topCategoryTDDTelecomKitsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectronicsPage(driver);
		}	

	// Method to Click on Telephones in Top Categories
	public SubCategoryElectronicsPage clickTopCategoryTelephonesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryTelephonesLinkText);
			topCategoryTelephonesLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectronicsPage(driver);
		}	
	// Method to Click on Two way Radio in Top Categories
	public SubCategoryElectronicsPage clickTopCategoryTwoWayRadiosLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryTwoWayRadiosLinkText);
			topCategoryTwoWayRadiosLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectronicsPage(driver);
		}	
	// Method to Click on home in Top Categories	
	public SubCategoryElectronicsPage clickCategoryHomeLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, categoryHomeLinkText);
			categoryHomeLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectronicsPage(driver);
		}
}
