package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class CategoryFoodServicePage extends BaseClass{

	WebDriver driver;
	// Constructor
	public CategoryFoodServicePage(WebDriver driver) 	{
		this.driver = driver;
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
			WaitTool.waitForElement(driver, topCategoryChafersFoodWarmersLinkText);
			topCategoryChafersFoodWarmersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Cookware in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryCookwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryCookwareLinkText);
			topCategoryCookwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Dinnerware in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryDinnerwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryDinnerwareLinkText);
			topCategoryDinnerwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Dispensers in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryDispensersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryDispensersLinkText);
			topCategoryDispensersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Displays in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryDisplaysLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryDisplaysLinkText);
			topCategoryDisplaysLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Disposable Dinnerware, Flatware & Containers in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryDDFlatwareContainersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryDDFlatwareContainersLinkText);
			topCategoryDDFlatwareContainersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Flatware in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryFlatwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryFlatwareLinkText);
			topCategoryFlatwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Food & Beverage in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryFoodBeverageLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryFoodBeverageLinkText);
			topCategoryFoodBeverageLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Beverage Service in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryBeverageServiceLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryBeverageServiceLinkText);
			topCategoryBeverageServiceLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Kitchen Kits in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryKitchenKitsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryKitchenKitsLinkText);
			topCategoryKitchenKitsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Kitchen Utensils & Accessories in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryKitchenUtensilsAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryKitchenUtensilsAccessoriesLinkText);
			topCategoryKitchenUtensilsAccessoriesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Serveware in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryServewareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryServewareLinkText);
			topCategoryServewareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Serving Trays in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryServingTraysLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryServingTraysLinkText);
			topCategoryServingTraysLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on High Chair & Booster Seats in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryHighChairBoosterSeatsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryHighChairBoosterSeatsLinkText);
			topCategoryHighChairBoosterSeatsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}
	// Method to Click on Mobile Bars in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryMobileBarsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryMobileBarsLinkText);
			topCategoryMobileBarsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);	
		}
	// Method to Click on Food Service Carts in Top Categories	
	public SubCategoryFoodServicePage clickTopCategoryFoodServiceCartsLinkText() throws InterruptedException {
		 	WaitTool.waitForElement(driver, topCategoryFoodServiceCartsLinkText);
			topCategoryFoodServiceCartsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);	
		}
	// Method to Click on home in Top Categories	
	public SubCategoryFoodServicePage clickCategoryHomeLinkText() throws InterruptedException {
		 	WaitTool.waitForElement(driver, categoryHomeLinkText);
			categoryHomeLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryFoodServicePage(driver);
		}	
	
}
