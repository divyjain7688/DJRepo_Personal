package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryCabinetsAndCounterTopsPage {
	private  WebDriver driver; private WaitTool   waitTool;

	public SubCategoryCabinetsAndCounterTopsPage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
		
	}
	
	// BreadCrumb
	@FindBy(xpath = "//a[starts-with(@id,'WC_BreadCrumb_Link_2_1_')]")
	WebElement categoryBreadCrumbLinkText;
	
	// Sub Categories Kitchen Countertops & Accessories
	@FindBy(linkText = "Kitchen Countertops & Accessories")
	WebElement subCategoryKitchenCountertopsAccessoriesLinkText;

	// Sub Categories Bath Vanity Tops
	@FindBy(linkText = "Bath Vanity Tops")
	WebElement subCategoryBathVanityTopsLinkText;
	
	// Sub Categories Cabinet Molding
	@FindBy(linkText = "Cabinet Molding")
	WebElement subCategoryCabinetMoldingLinkText;
	
	// Sub Categories Cabinet Shelves
	@FindBy(linkText = "Cabinet Shelves")
	WebElement subCategoryCabinetShelvesLinkText;

	// Sub Categories Dishwasher End Panel
	@FindBy(linkText = "Dishwasher End Panel")
	WebElement subCategoryDishwasherEndPanelLinkText;

	// Sub Categories Fillers, Toe Kicks, & Skins
	@FindBy(linkText = "Fillers, Toe Kicks, & Skins")
	WebElement subCategoryFillersToeKicksSkinsLinkText;

	// Sub Categories Pantries
	@FindBy(linkText = "Pantries")
	WebElement subCategoryPantriesLinkText;

	// Sub Categories Wall Cabinets
	@FindBy(linkText = "Wall Cabinets")
	WebElement subCategoryWallCabinetsLinkText;

	// Sub Categories Kitchen Cabinets
	@FindBy(linkText = "Kitchen Cabinets")
	WebElement subCategoryKitchenCabinetsLinkText;
		
	// Sub Categories Base Cabinets
	@FindBy(linkText = "Base Cabinets")
	WebElement subCategoryBaseCabinetsLinkText;

	// Sub Categories Medicine Cabinets & Accessories
	@FindBy(linkText = "Medicine Cabinets & Accessories")
	WebElement subCategoryMedicineCabinetsAccessoriesLinkText;

	// Sub Categories Cosmetic Boxes & Accessories
	@FindBy(linkText = "Cosmetic Boxes & Accessories")
	WebElement subCategoryCosmeticBoxesAccessoriesLinkText;

	// Sub Categories Vanity Cabinets
	@FindBy(linkText = "Vanity Cabinets")
	WebElement subCategoryVanityCabinetsLinkText;

	// Sub Categories Vanity Combos
	@FindBy(linkText = "Vanity Combos")
	WebElement subCategoryVanityCombosLinkText;

	// Sub Categories Wheelchair Accessible
	@FindBy(linkText = "Wheelchair Accessible")
	WebElement subCategoryWheelchairAccessibleLinkText;

	// Sub Categories Over the John
	@FindBy(linkText = "Over the John")
	WebElement subCategoryOvertheJohnLinkText;

	// Method to Click on Over the John in Sub Categories	
	public void clickSubCategoryOvertheJohnLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryOvertheJohnLinkText);
			subCategoryOvertheJohnLinkText.click();
			waitTool.waitFor(driver,true) ;
		}
	
	// Method to Click on Wheelchair Accessible in Sub Categories	
	public void clickSubCategoryWheelchairAccessibleLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryWheelchairAccessibleLinkText);
			subCategoryWheelchairAccessibleLinkText.click();
			waitTool.waitFor(driver,true) ;
		}
	
	// Method to Click on Vanity Combos in Sub Categories	
	public void clickSubCategoryVanityCombosLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryVanityCombosLinkText);
			subCategoryVanityCombosLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Vanity Cabinets in Sub Categories	
	public void clickSubCategoryVanityCabinetsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryVanityCabinetsLinkText);
			subCategoryVanityCabinetsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Cosmetic Boxes & Accessories in Sub Categories	
	public void clickSubCategoryCosmeticBoxesAccessoriesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryCosmeticBoxesAccessoriesLinkText);
			subCategoryCosmeticBoxesAccessoriesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Medicine Cabinets & Accessories in Sub Categories	
	public void clickSubCategoryMedicineCabinetsAccessoriesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryMedicineCabinetsAccessoriesLinkText);
			subCategoryMedicineCabinetsAccessoriesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Base Cabinets in Sub Categories	
	public void clickSubCategoryBaseCabinetsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryBaseCabinetsLinkText);
			subCategoryBaseCabinetsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Wall Cabinets in Sub Categories	
	public void clickSubCategoryWallCabinetsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryWallCabinetsLinkText);
			subCategoryWallCabinetsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	// Method to Click on Kitchen Cabinets in Sub Categories	
	public String clickSubCategoryKitchenCabinetsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryKitchenCabinetsLinkText);
			subCategoryKitchenCabinetsLinkText.click();
			waitTool.waitFor(driver,true) ;
			return subCategoryKitchenCabinetsLinkText.getText();
			
		}

	
	
	// Method to Click on Pantries in Sub Categories	
	public void clickSubCategoryPantriesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryPantriesLinkText);
			subCategoryPantriesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Fillers, Toe Kicks, & Skins in Sub Categories	
	public void clickSubCategoryFillersToeKicksSkinsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryFillersToeKicksSkinsLinkText);
			subCategoryFillersToeKicksSkinsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	
	// Method to Click on Dishwasher End Panel in Sub Categories	
	public void clickSubCategoryDishwasherEndPanelLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryDishwasherEndPanelLinkText);
			subCategoryDishwasherEndPanelLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Cabinet Shelves in Sub Categories	
	public void clickSubCategoryCabinetShelvesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryCabinetShelvesLinkText);
			subCategoryCabinetShelvesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	
	// Method to Click on Cabinet Molding in Sub Categories	
	public void clickSubCategoryCabinetMoldingLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryCabinetMoldingLinkText);
			subCategoryCabinetMoldingLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Bath Vanity Tops in Sub Categories	
	public void clickSubCategoryBathVanityTopsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryBathVanityTopsLinkText);
			subCategoryBathVanityTopsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	// Method to Click on Kitchen Countertops & Accessories in Sub Categories	
	public void clickSubCategoryKitchenCountertopsAccessoriesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryKitchenCountertopsAccessoriesLinkText);
			subCategoryKitchenCountertopsAccessoriesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on BreadCrumb in Sub Categories	
	public CategoryAppliancesPage clickCategoryBreadCrumbLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, categoryBreadCrumbLinkText);
			categoryBreadCrumbLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new CategoryAppliancesPage(driver);
		}


	// Method to Click on BreadCrumb in Sub Categories	
	public CategoryCabinetsAndCounterTopsPage clickCabinetAndCounterTopsFromBreadCrumbLink() throws InterruptedException {
			waitTool.waitForElement(driver, categoryBreadCrumbLinkText);
			categoryBreadCrumbLinkText.click();
			waitTool.waitFor(driver,true) ;
			return new CategoryCabinetsAndCounterTopsPage(driver);
		}
	
}
