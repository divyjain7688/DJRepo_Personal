package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryFoodServicePage
{

	private  WebDriver driver; private WaitTool   waitTool;
	// Constructor
	public CategoryFoodServicePage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		
	}
	
	// Top Categories Chafers & Food Warmers
	@FindBy(linkText = "Chafers & Food Warmers")
	WebElement topCategoryChafersFoodWarmersLinkText;

	// Top Categories Cookware
	@FindBy(linkText = "Cookware")
	WebElement topCategoryCookwareLinkText;

	// Top Categories Dinnerware
	@FindBy(linkText = "Dinnerware")
	WebElement topCategoryDinnerwareLinkText;

	// Top Categories Dispensers
	@FindBy(linkText = "Dispensers")
	WebElement topCategoryDispensersLinkText;
	
	// Top Categories Displays
	@FindBy(linkText = "Displays")
	WebElement topCategoryDisplaysLinkText;

	// Top Categories Disposable Dinnerware, Flatware & Containers
	@FindBy(linkText = "Disposable Dinnerware, Flatware & Containers")
	WebElement topCategoryDDFlatwareContainersLinkText;

	// Top Categories Flatware
	@FindBy(linkText = "Flatware")
	WebElement topCategoryFlatwareLinkText;

	// Top Categories Food & Beverage
	@FindBy(linkText = "Food & Beverage")
	WebElement topCategoryFoodBeverageLinkText;

	// Top Categories Beverage Service
	@FindBy(linkText = "Beverage Service")
	WebElement topCategoryBeverageServiceLinkText;

	// Top Categories Kitchen Kits
	@FindBy(linkText = "Kitchen Kits")
	WebElement topCategoryKitchenKitsLinkText;

	// Top Categories Kitchen Utensils & Accessories
	@FindBy(linkText = "Kitchen Utensils & Accessories")
	WebElement topCategoryKitchenUtensilsAccessoriesLinkText;

	// Top Categories Serveware
	@FindBy(linkText = "Serveware")
	WebElement topCategoryServewareLinkText;

	// Top Categories Serving Trays
	@FindBy(linkText = "Serving Trays")
	WebElement topCategoryServingTraysLinkText;

	// Top Categories High Chair & Booster Seats
	@FindBy(linkText = "High Chair & Booster Seats")
	WebElement topCategoryHighChairBoosterSeatsLinkText;

	// Top Categories Mobile Bars
	@FindBy(linkText = "Mobile Bars")
	WebElement topCategoryMobileBarsLinkText;

	// Top Categories Food Service Carts
	@FindBy(linkText = "Food Service Carts")
	WebElement topCategoryFoodServiceCartsLinkText;

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

	// Method to Click on Chafers & Food Warmers in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryChafersFoodWarmersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryChafersFoodWarmersLinkText);
			topCategoryChafersFoodWarmersLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Cookware in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryCookwareLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryCookwareLinkText);
			topCategoryCookwareLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Dinnerware in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryDinnerwareLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryDinnerwareLinkText);
			topCategoryDinnerwareLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Dispensers in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryDispensersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryDispensersLinkText);
			topCategoryDispensersLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Displays in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryDisplaysLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryDisplaysLinkText);
			topCategoryDisplaysLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Disposable Dinnerware, Flatware & Containers in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryDDFlatwareContainersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryDDFlatwareContainersLinkText);
			topCategoryDDFlatwareContainersLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Flatware in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryFlatwareLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryFlatwareLinkText);
			topCategoryFlatwareLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Food & Beverage in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryFoodBeverageLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryFoodBeverageLinkText);
			topCategoryFoodBeverageLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Beverage Service in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryBeverageServiceLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryBeverageServiceLinkText);
			topCategoryBeverageServiceLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Kitchen Kits in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryKitchenKitsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryKitchenKitsLinkText);
			topCategoryKitchenKitsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Kitchen Utensils & Accessories in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryKitchenUtensilsAccessoriesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryKitchenUtensilsAccessoriesLinkText);
			topCategoryKitchenUtensilsAccessoriesLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Serveware in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryServewareLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryServewareLinkText);
			topCategoryServewareLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Serving Trays in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryServingTraysLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryServingTraysLinkText);
			topCategoryServingTraysLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on High Chair & Booster Seats in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryHighChairBoosterSeatsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryHighChairBoosterSeatsLinkText);
			topCategoryHighChairBoosterSeatsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Mobile Bars in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryMobileBarsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, topCategoryMobileBarsLinkText);
			topCategoryMobileBarsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);	
		}
	// Method to Click on Food Service Carts in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryFoodServiceCartsLinkText() throws InterruptedException {
		 	waitTool.waitForElement(driver, topCategoryFoodServiceCartsLinkText);
			topCategoryFoodServiceCartsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);	
		}
	// Method to Click on home in Top Categories	
	public SubCategoryFoodServicePage clickCategoryHomeLinkText() throws InterruptedException {
		 	waitTool.waitForElement(driver, categoryHomeLinkText);
			categoryHomeLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}	
	
}
