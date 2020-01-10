package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class SubCategoryFoodServicePage extends BaseClass{

	public SubCategoryFoodServicePage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
		
	}
	
	// Sub Categories Salt & Pepper Shakers
	@FindBy(linkText = "Salt & Pepper Shakers")
	WebElement subCategorySaltPepperShakersLinkText;

	// Sub Categories Syrup
	@FindBy(linkText = "Syrup")
	WebElement subCategorySyrupLinkText;

	// Sub Categories Cutlery Holders
	@FindBy(linkText = "Cutlery Holders")
	WebElement subCategoryCutleryHoldersLinkText;

	// Sub Categories Napkin Holders
	@FindBy(linkText = "Napkin Holders")
	WebElement subCategoryNapkinHoldersLinkText;

	// Sub Categories Flatware
	@FindBy(linkText = "Flatware")
	WebElement subCategoryFlatwareLinkText;

	// Sub Categories Food Containers
	@FindBy(linkText = "Food Containers")
	WebElement subCategoryFoodContainersLinkText;

	// Sub Categories Granola Bars
	@FindBy(linkText = "Granola Bars")
	WebElement subCategoryGranolaBarsLinkText;

	// Sub Categories Condiment Kits
	@FindBy(linkText = "Condiment Kits")
	WebElement subCategoryCondimentKitsLinkText;

	// Sub Categories Cups & Lids
	@FindBy(linkText = "Cups & Lids")
	WebElement subCategoryCupsLidsLinkText;

	// Sub Categories Decanters & Pitchers
	@FindBy(linkText = "Decanters & Pitchers")
	WebElement subCategoryDecantersPitchersLinkText;

	// Sub Categories Can Openers
	@FindBy(linkText = "Can Openers")
	WebElement subCategoryCanOpenersLinkText;

	// Sub Categories Colanders
	@FindBy(linkText = "Colanders")
	WebElement subCategoryColandersLinkText;
	// Method to Click on Colanders in Sub Categories	
	public void clickSubCategoryColandersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryColandersLinkText);
			subCategoryColandersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Can Openers in Sub Categories	
	public void clickSubCategoryCanOpenersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCanOpenersLinkText);
			subCategoryCanOpenersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Decanters & Pitchers in Sub Categories	
	public void clickSubCategoryDecantersPitchersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryDecantersPitchersLinkText);
			subCategoryDecantersPitchersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Cups & Lids in Sub Categories	
	public void clickSubCategoryCupsLidsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCupsLidsLinkText);
			subCategoryCupsLidsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Condiment Kits in Sub Categories	
	public void clickSubCategoryCondimentKitsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCondimentKitsLinkText);
			subCategoryCondimentKitsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Granola Bars in Sub Categories	
	public void clickSubCategoryGranolaBarsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryGranolaBarsLinkText);
			subCategoryGranolaBarsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Food Containers in Sub Categories	
	public void clickSubCategoryFoodContainersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryFoodContainersLinkText);
			subCategoryFoodContainersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Flatware in Sub Categories	
	public void clickSubCategoryFlatwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryFlatwareLinkText);
			subCategoryFlatwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Napkin Holders in Sub Categories	
	public void clickSubCategoryNapkinHoldersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryNapkinHoldersLinkText);
			subCategoryNapkinHoldersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Cutlery Holders in Sub Categories	
	public void clickSubCategoryCutleryHoldersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCutleryHoldersLinkText);
			subCategoryCutleryHoldersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Syrup in Sub Categories	
	public void clickSubCategorySyrupLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategorySyrupLinkText);
			subCategorySyrupLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Salt & Pepper Shakers in Sub Categories	
	public void clickSubCategorySaltPepperShakersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategorySaltPepperShakersLinkText);
			subCategorySaltPepperShakersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	

	
}
