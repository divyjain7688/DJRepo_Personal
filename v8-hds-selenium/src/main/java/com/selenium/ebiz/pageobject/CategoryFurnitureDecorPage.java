package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryFurnitureDecorPage
{
	private  WebDriver driver; private WaitTool   waitTool;
	// Constructor
	public CategoryFurnitureDecorPage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		
	}
	
	// Top Categories Beds & Accessories
	@FindBy(linkText = "Beds & Accessories")
	WebElement topCategoryBedsAccessoriesLinkText;
	
	// Top Categories Cribs
	@FindBy(linkText = "Cribs")
	WebElement topCategoryCribsLinkText;

	// Top Categories Desks & Chairs
	@FindBy(linkText = "Desks & Chairs")
	WebElement topCategoryDesksChairsLinkText;

	// Top Categories Framed Artwork
	@FindBy(linkText = "Framed Artwork")
	WebElement topCategoryFramedArtworkLinkText;

	// Top Categories Lecterns
	@FindBy(linkText = "Lecterns")
	WebElement topCategoryLecternsLinkText;

	// Top Categories Mirrors
	@FindBy(linkText = "Mirrors")
	WebElement topCategoryMirrorsLinkText;

	// Top Categories Seating
	@FindBy(linkText = "Seating")
	WebElement topCategorySeatingLinkText;

	// Top Categories Tables
	@FindBy(linkText = "Tables")
	WebElement topCategoryTablesLinkText;

	// Top Categories Welcome Mats
	@FindBy(linkText = "Welcome Mats")
	WebElement topCategoryWelcomeMatsLinkText;

	// Top Categories Artwork
	@FindBy(linkText = "Artwork")
	WebElement topCategoryArtworkLinkText;

	// Top Categories Wall Clocks
	@FindBy(linkText = "Wall Clocks")
	WebElement topCategoryWallClocksLinkText;

	// Top Categories Umbrella Stands
	@FindBy(linkText = "Umbrella Stands")
	WebElement topCategoryUmbrellaStandsLinkText;

	// Top Categories Chair & Table Dollies
	@FindBy(linkText = "Chair & Table Dollies")
	WebElement topCategoryChairTableDolliesLinkText;

	// Top Categories Dining Sets
	@FindBy(linkText = "Dining Sets")
	WebElement topCategoryDiningSetsLinkText;

	// Top Categories Stages & Risers
	@FindBy(linkText = "Stages & Risers")
	WebElement topCategoryStagesRisersLinkText;

	// Top Categories Electronics Charging Carts
	@FindBy(linkText = "Electronics Charging Carts")
	WebElement topCategoryElectronicsChargingCartsLinkText;
	
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

		// Method to Click on Beds & Accessories in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryBedsAccessoriesLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryBedsAccessoriesLinkText);
				topCategoryBedsAccessoriesLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}
		// Method to Click on Cribs in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryCribsLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryCribsLinkText);
				topCategoryCribsLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Desks & Chairs in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryDesksChairsLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryDesksChairsLinkText);
				topCategoryDesksChairsLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Framed Artwork in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryFramedArtworkLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryFramedArtworkLinkText);
				topCategoryFramedArtworkLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Lecternsin Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryLecternsLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryLecternsLinkText);
				topCategoryLecternsLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Mirrors in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryMirrorsLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryMirrorsLinkText);
				topCategoryMirrorsLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Seating in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategorySeatingLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategorySeatingLinkText);
				topCategorySeatingLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Tables in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryTablesLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryTablesLinkText);
				topCategoryTablesLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Welcome Mats in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryWelcomeMatsLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryWelcomeMatsLinkText);
				topCategoryWelcomeMatsLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Artwork in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryArtworkLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryArtworkLinkText);
				topCategoryArtworkLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Wall Clocks in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryWallClocksLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryWallClocksLinkText);
				topCategoryWallClocksLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Umbrella Stands in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryUmbrellaStandsLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryUmbrellaStandsLinkText);
				topCategoryUmbrellaStandsLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Chair & Table Dollies in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryChairTableDolliesLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryChairTableDolliesLinkText);
				topCategoryChairTableDolliesLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Dining Sets in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryDiningSetsLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryDiningSetsLinkText);
				topCategoryDiningSetsLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Stages & Risers in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryStagesRisersLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryStagesRisersLinkText);
				topCategoryStagesRisersLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on Electronics Charging Carts in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickTopCategoryElectronicsChargingCartsLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryElectronicsChargingCartsLinkText);
				topCategoryElectronicsChargingCartsLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}	
		// Method to Click on home in Top Categories	
		public SubCategoryFurnitureAndDecorPage clickCategoryHomeLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, categoryHomeLinkText);
				categoryHomeLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFurnitureAndDecorPage(driver);
			}

		
		
}
