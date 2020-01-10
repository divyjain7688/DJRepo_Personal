package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class SubCategoryBedBathTableLinensPage extends BaseClass{

	public SubCategoryBedBathTableLinensPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
		
	}

	@FindBy(linkText = "Robes")
	WebElement subCategoryRobesLinkText;

	@FindBy(linkText = "Tablecloths")
	WebElement subCategoryTableclothsLinkText;
	
	@FindBy(linkText = "Napkins")
	WebElement subCategoryNapkinsLinkText;

	@FindBy(linkText = "Bath Towels")
	WebElement subCategoryBathTowelsLinkText;

	@FindBy(linkText = "Hand Towels")
	WebElement subCategoryHandTowelsLinkText;
	
	@FindBy(linkText = "Kitchen Towels")
	WebElement subCategoryKitchenTowelsLinkText;

	@FindBy(linkText = "Pool Towels")
	WebElement subCategoryPoolTowelsLinkText;

	@FindBy(linkText = "Wash Cloths")
	WebElement subCategoryWashClothsLinkText;
	
	@FindBy(linkText = "Bath Mats & Rugs")
	WebElement subCategoryBathMatsRugsLinkText;

	@FindBy(linkText = "Bed Skirts")
	WebElement subCategoryBedSkirtsLinkText;

	@FindBy(linkText = "Bedspreads & Coverlets")
	WebElement subCategoryBedspreadsCoverletsLinkText;

	@FindBy(linkText = "Blankets")
	WebElement subCategoryBlanketsLinkText;

	@FindBy(linkText = "Comforters & Duvet Inserts")
	WebElement subCategoryComfortersDuvetInsertsLinkText;

	@FindBy(linkText = "Decorative Top Sheets")
	WebElement subCategoryDecorativeTopSheetsLinkText;

	@FindBy(linkText = "Duvet Covers")
	WebElement subCategoryDuvetCoversLinkText;

	@FindBy(linkText = "Mattress Pads, Protectors & Toppers")
	WebElement subCategoryMattressPadsProtectorsToppersLinkText;

	@FindBy(linkText = "Pillows & Pillow Protectors")
	WebElement subCategoryPillowsPillowProtectorsLinkText;

	@FindBy(linkText = "Bed Scarves")
	WebElement subCategoryBedScarvesLinkText;

	@FindBy(linkText = "Shams")
	WebElement subCategoryShamsLinkText;
	
	@FindBy(linkText = "Sheets & Pillowcases")
	WebElement subCategorySheetsPillowcasesLinkText;
	
	@FindBy(linkText = "Storage Bags")
	WebElement subCategoryStorageBagsLinkText;
	
	public void clickSubCategoryRobesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryRobesLinkText);
			subCategoryRobesLinkText.click();
			WaitTool.waitFor(driver,true) ;
		}
	
	public void clickSubCategoryTableclothsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryTableclothsLinkText);
			subCategoryTableclothsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryNapkinsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryNapkinsLinkText);
			subCategoryNapkinsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryBathTowelsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryBathTowelsLinkText);
			subCategoryBathTowelsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryHandTowelsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryHandTowelsLinkText);
			subCategoryHandTowelsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryKitchenTowelsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryKitchenTowelsLinkText);
			subCategoryKitchenTowelsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryPoolTowelsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryKitchenTowelsLinkText);
			subCategoryKitchenTowelsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryWashClothsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryWashClothsLinkText);
			subCategoryWashClothsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryBathMatsRugsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryBathMatsRugsLinkText);
			subCategoryBathMatsRugsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryBedSkirtsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryBedSkirtsLinkText);
			subCategoryBedSkirtsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryBedspreadsCoverletsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryBedspreadsCoverletsLinkText);
			subCategoryBedspreadsCoverletsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryBlanketsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryBlanketsLinkText);
			subCategoryBlanketsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryComfortersDuvetInsertsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryComfortersDuvetInsertsLinkText);
			subCategoryComfortersDuvetInsertsLinkText.click();
			WaitTool.waitFor(driver,true) ;
		}
	
	public void clickSubCategoryDecorativeTopSheetsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryDecorativeTopSheetsLinkText);
			subCategoryDecorativeTopSheetsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryDuvetCoversLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryDuvetCoversLinkText);
			subCategoryDuvetCoversLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Mattress Pads, Protectors & Toppers in Sub Categories
	public void clickSubCategoryMattressPadsProtectorsToppersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryMattressPadsProtectorsToppersLinkText);
			subCategoryMattressPadsProtectorsToppersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	// Method to Click on Pillows & Pillow Protectors in Sub Categories
	public void clickSubCategoryPillowsPillowProtectorsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryPillowsPillowProtectorsLinkText);
			subCategoryPillowsPillowProtectorsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Bed Scarves in Sub Categories
	public void clickSubCategoryBedScarvesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryBedScarvesLinkText);
			subCategoryBedScarvesLinkText.click();
			WaitTool.waitFor(driver,true) ;
		}
	
	// Method to Click on Shams in Sub Categories
	public void clickSubCategoryShamsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryShamsLinkText);
			subCategoryShamsLinkText.click();
			WaitTool.waitFor(driver,true) ;
		}
	
	// Method to Click on Sheets & Pillowcases in Sub Categories
	public void clickSubCategorySheetsPillowcasesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategorySheetsPillowcasesLinkText);
			subCategorySheetsPillowcasesLinkText.click();
			WaitTool.waitFor(driver,true) ;
		}
	
	// Method to Click on Storage Bags in Sub Categories
	public void clickSubCategoryStorageBagsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryStorageBagsLinkText);
			subCategoryStorageBagsLinkText.click();
			WaitTool.waitFor(driver,true) ;
		}
}
