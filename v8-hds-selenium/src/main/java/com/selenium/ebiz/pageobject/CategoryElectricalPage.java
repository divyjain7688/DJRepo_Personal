package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryElectricalPage {

	private WebDriver driver;
	private WaitTool waitTool;
	// Constructor
	public CategoryElectricalPage(WebDriver driver)
	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		
	}
	/* Element identifiers. */
	
	// Top Categories Chargers
	@FindBy(linkText = "Chargers")
	WebElement topCategoryChargersLinkText; 
	
	// Top Categories Circuit Breakers, Fuses and Load Centers
	@FindBy(linkText = "Circuit Breakers, Fuses & Load Centers")
	WebElement topCategoryCBFLoadCentersLinkText; 

   // Top Categories Conduit, Raceway and fittings
	@FindBy(linkText = "Conduit, Raceway & Fittings")
	WebElement topCategoryConduitRacewayFittingsLinkText; 

	// Top Categories Doorbells, chimes and intercoms
	@FindBy(linkText = "Doorbells, Chimes & Intercoms")
	WebElement topCategoryDoorbellsChimesIntercomsLinkText;
	
	
	// Top Categories Electrical Boxes
	@FindBy(linkText = "Electrical Boxes")
	WebElement topCategoryElectricalBoxesLinkText;

	// Top Categories Electrical Tools and Accessories
	@FindBy(linkText = "Electrical Tools & Accessories")
	WebElement topCategoryElectricalToolsAccessoriesLinkText;

	// Top Categories Fire Safety
	@FindBy(linkText = "Fire Safety")
	WebElement topCategoryFireSafetyLinkText;

	// Top Categories Batteries
	@FindBy(linkText = "Batteries")
	WebElement topCategoryBatteriesLinkText;

	// Top Categories Power Cords, Extension cords and Adapters
	@FindBy(linkText = "Power Cords, Extension Cords & Adapters")
	WebElement topCategoryPCECAdaptersLinkText;
	
	// Top Categories Timers and Accessories
	@FindBy(linkText = "Timers & Accessories")
	WebElement topCategoryTimersAccessoriesLinkText;
	
	// Top Categories Wall Plates and Accessories
	@FindBy(linkText = "Wall Plates & Accessories")
	WebElement topCategoryWallPlatesAccessoriesLinkText;

	// Top Categories wiring Devices
	@FindBy(linkText = "Wiring Devices")
	WebElement topCategoryWiringDevicesLinkText;

	// Top Categories Wiring Supplies
	@FindBy(linkText = "Wiring Supplies")
	WebElement topCategoryWiringSuppliesLinkText;

	//To home page link
	@FindBy(xpath = "//*[@id='WC_BreadCrumb_Link_1_1_-3028_40453']")
	WebElement categoryHomeLinkText;

    @FindBy(xpath = "//*[@data-hds-tag='PageHeading__flexible-header']")
    public
    WebElement electricalCategoryTitlePage;
	

	//To Verify for the top category
	@FindBy(xpath = "//*[@id='PageHeading_2_-3001_40466']/h1")
	WebElement topCategoryPageHeadingText;
	
	// To Get the Text from the Page Heading
	public String getCategoryPageHeadingText() {
		return topCategoryPageHeadingText.getText().trim();
	}

	public Boolean electricalCategoryTitleIsDisplayed(){
	    waitTool.waitForElement(driver,electricalCategoryTitlePage);
	    return electricalCategoryTitlePage.isDisplayed();
    }


	// Navigate to Previous Page
	public void navigateBackToPage() {
		driver.navigate().back();
	}
	
	// Method to Click on Chargers in Top Categories
	public SubCategoryElectricalPage clickTopCategoryChargersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryChargersLinkText);
			topCategoryChargersLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectricalPage(driver);
		}
	
	// Method to Click on CBF Load Centers in Top Categories
	public SubCategoryElectricalPage clickTopCategoryCBFLoadCentersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryCBFLoadCentersLinkText);
			topCategoryCBFLoadCentersLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectricalPage(driver);
		}	
	// Method to Click on Conduit Raceway Fittings in Top Categories
	public SubCategoryElectricalPage clickTopCategoryConduitRacewayFittingsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryConduitRacewayFittingsLinkText);
			topCategoryConduitRacewayFittingsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectricalPage(driver);
		}
	// Method to Click on Door Bells Chimes and Intercoms in Top Categories
	public SubCategoryElectricalPage clickTopCategoryDoorbellsChimesIntercomsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryDoorbellsChimesIntercomsLinkText);
			topCategoryDoorbellsChimesIntercomsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectricalPage(driver);
		}
	// Method to Click on electrical boxes in Top Categories
	public SubCategoryElectricalPage clickTopCategoryElectricalBoxesLinkText() throws InterruptedException {
		 	waitTool.waitForElement(driver, topCategoryElectricalBoxesLinkText);
			topCategoryElectricalBoxesLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectricalPage(driver);
		}
	
	// Method to Click on electrical Tools Accessories in Top Categories
	public SubCategoryElectricalPage clickTopCategoryElectricalToolsAccessoriesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryElectricalToolsAccessoriesLinkText);
			topCategoryElectricalToolsAccessoriesLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectricalPage(driver);
		}
	
	// Method to Click on fire Safety in Top Categories
	public SubCategoryElectricalPage clickTopCategoryFireSafetyLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryFireSafetyLinkText);
			topCategoryFireSafetyLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectricalPage(driver);
		}
	
	// Method to Click on Batteries in Top Categories
	public SubCategoryElectricalPage clickTopCategoryBatteriesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryBatteriesLinkText);
			topCategoryBatteriesLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectricalPage(driver);
		}
	// Method to Click on PCEC Adapters in Top Categories
	public SubCategoryElectricalPage clickTopCategoryPCECAdaptersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryPCECAdaptersLinkText);
			topCategoryPCECAdaptersLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectricalPage(driver);
		}

	// Method to Click on Timers Accessories in Top Categories
	public SubCategoryElectricalPage clickTopCategoryTimersAccessoriesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryTimersAccessoriesLinkText);
			topCategoryTimersAccessoriesLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectricalPage(driver);
		}
	// Method to Click on Wall Plates Accessories in Top Categories
	public SubCategoryElectricalPage clickTopCategoryWallPlatesAccessoriesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryWallPlatesAccessoriesLinkText);
			topCategoryWallPlatesAccessoriesLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectricalPage(driver);
		}
	
	// Method to Click on Wiring Devices in Top Categories
	public SubCategoryElectricalPage clickTopCategoryWiringDevicesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryWiringDevicesLinkText);
			topCategoryWiringDevicesLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectricalPage(driver);
		}
	// Method to Click on Wiring Supplies in Top Categories
	public SubCategoryElectricalPage clickTopCategoryWiringSuppliesLinkText() throws InterruptedException {
		 	waitTool.waitForElement(driver, topCategoryWiringSuppliesLinkText);
			topCategoryWiringSuppliesLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryElectricalPage(driver);
		}

	// Method to Click on home in Top Categories	
		public SubCategoryElectricalPage clickCategoryHomeLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, categoryHomeLinkText);
				categoryHomeLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryElectricalPage(driver);
			}
}
