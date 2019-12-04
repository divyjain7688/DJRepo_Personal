package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryBedBathTableLinensPage {

	private  WebDriver driver; private WaitTool   waitTool;

	public SubCategoryBedBathTableLinensPage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
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
			waitTool.waitForElement(driver, subCategoryRobesLinkText);
			subCategoryRobesLinkText.click();
			waitTool.waitFor(driver,true) ;
		}
	
	public void clickSubCategoryTableclothsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryTableclothsLinkText);
			subCategoryTableclothsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryNapkinsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryNapkinsLinkText);
			subCategoryNapkinsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryBathTowelsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryBathTowelsLinkText);
			subCategoryBathTowelsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryHandTowelsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryHandTowelsLinkText);
			subCategoryHandTowelsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryKitchenTowelsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryKitchenTowelsLinkText);
			subCategoryKitchenTowelsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryPoolTowelsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryKitchenTowelsLinkText);
			subCategoryKitchenTowelsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryWashClothsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryWashClothsLinkText);
			subCategoryWashClothsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryBathMatsRugsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryBathMatsRugsLinkText);
			subCategoryBathMatsRugsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryBedSkirtsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryBedSkirtsLinkText);
			subCategoryBedSkirtsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryBedspreadsCoverletsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryBedspreadsCoverletsLinkText);
			subCategoryBedspreadsCoverletsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryBlanketsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryBlanketsLinkText);
			subCategoryBlanketsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryComfortersDuvetInsertsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryComfortersDuvetInsertsLinkText);
			subCategoryComfortersDuvetInsertsLinkText.click();
			waitTool.waitFor(driver,true) ;
		}
	
	public void clickSubCategoryDecorativeTopSheetsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryDecorativeTopSheetsLinkText);
			subCategoryDecorativeTopSheetsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	public void clickSubCategoryDuvetCoversLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryDuvetCoversLinkText);
			subCategoryDuvetCoversLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Mattress Pads, Protectors & Toppers in Sub Categories
	public void clickSubCategoryMattressPadsProtectorsToppersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryMattressPadsProtectorsToppersLinkText);
			subCategoryMattressPadsProtectorsToppersLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	// Method to Click on Pillows & Pillow Protectors in Sub Categories
	public void clickSubCategoryPillowsPillowProtectorsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryPillowsPillowProtectorsLinkText);
			subCategoryPillowsPillowProtectorsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Bed Scarves in Sub Categories
	public void clickSubCategoryBedScarvesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryBedScarvesLinkText);
			subCategoryBedScarvesLinkText.click();
			waitTool.waitFor(driver,true) ;
		}
	
	// Method to Click on Shams in Sub Categories
	public void clickSubCategoryShamsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryShamsLinkText);
			subCategoryShamsLinkText.click();
			waitTool.waitFor(driver,true) ;
		}
	
	// Method to Click on Sheets & Pillowcases in Sub Categories
	public void clickSubCategorySheetsPillowcasesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategorySheetsPillowcasesLinkText);
			subCategorySheetsPillowcasesLinkText.click();
			waitTool.waitFor(driver,true) ;
		}
	
	// Method to Click on Storage Bags in Sub Categories
	public void clickSubCategoryStorageBagsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryStorageBagsLinkText);
			subCategoryStorageBagsLinkText.click();
			waitTool.waitFor(driver,true) ;
		}
}
