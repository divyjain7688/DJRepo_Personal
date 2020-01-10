package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class SubCategoryCabinetsAndCounterLoopsPage extends BaseClass{

	public SubCategoryCabinetsAndCounterLoopsPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
	}
	
	@FindBy(linkText = "Kitchen Countertops & Accessories")
	WebElement subCategoryKitchenCountertopsAccessoriesLinkText;

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
			WaitTool.waitForElement(driver, subCategoryOvertheJohnLinkText);
			subCategoryOvertheJohnLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Wheelchair Accessible in Sub Categories	
	public void clickSubCategoryWheelchairAccessibleLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryWheelchairAccessibleLinkText);
			subCategoryWheelchairAccessibleLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Vanity Combos in Sub Categories	
	public void clickSubCategoryVanityCombosLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryVanityCombosLinkText);
			subCategoryVanityCombosLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Vanity Cabinets in Sub Categories	
	public void clickSubCategoryVanityCabinetsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryVanityCabinetsLinkText);
			subCategoryVanityCabinetsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Cosmetic Boxes & Accessories in Sub Categories	
	public void clickSubCategoryCosmeticBoxesAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCosmeticBoxesAccessoriesLinkText);
			subCategoryCosmeticBoxesAccessoriesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Medicine Cabinets & Accessories in Sub Categories	
	public void clickSubCategoryMedicineCabinetsAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryMedicineCabinetsAccessoriesLinkText);
			subCategoryMedicineCabinetsAccessoriesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Base Cabinets in Sub Categories	
	public void clickSubCategoryBaseCabinetsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryBaseCabinetsLinkText);
			subCategoryBaseCabinetsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Wall Cabinets in Sub Categories	
	public void clickSubCategoryWallCabinetsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryWallCabinetsLinkText);
			subCategoryWallCabinetsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Pantries in Sub Categories	
	public void clickSubCategoryPantriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryPantriesLinkText);
			subCategoryPantriesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Fillers, Toe Kicks, & Skins in Sub Categories	
	public void clickSubCategoryFillersToeKicksSkinsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryFillersToeKicksSkinsLinkText);
			subCategoryFillersToeKicksSkinsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	
	// Method to Click on Dishwasher End Panel in Sub Categories	
	public void clickSubCategoryDishwasherEndPanelLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryDishwasherEndPanelLinkText);
			subCategoryDishwasherEndPanelLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Cabinet Shelves in Sub Categories	
	public void clickSubCategoryCabinetShelvesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCabinetShelvesLinkText);
			subCategoryCabinetShelvesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	
	// Method to Click on Cabinet Molding in Sub Categories	
	public void clickSubCategoryCabinetMoldingLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCabinetMoldingLinkText);
			subCategoryCabinetMoldingLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Bath Vanity Tops in Sub Categories	
	public void clickSubCategoryBathVanityTopsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryBathVanityTopsLinkText);
			subCategoryBathVanityTopsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	// Method to Click on Kitchen Countertops & Accessories in Sub Categories	
	public void clickSubCategoryKitchenCountertopsAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryKitchenCountertopsAccessoriesLinkText);
			subCategoryKitchenCountertopsAccessoriesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

}
