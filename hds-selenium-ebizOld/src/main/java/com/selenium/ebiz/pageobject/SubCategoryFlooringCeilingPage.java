package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class SubCategoryFlooringCeilingPage extends BaseClass{

	public SubCategoryFlooringCeilingPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
		
	}
	// Sub Categories Grout & Repair
	@FindBy(linkText = "Grout & Repair")
	WebElement subCategoryGroutRepairLinkText;

	// Sub Categories Tile Adhesive
	@FindBy(linkText = "Tile Adhesive")
	WebElement subCategoryTileAdhesiveLinkText;

	// Sub Categories Carpet Tiles
	@FindBy(linkText = "Carpet Tiles")
	WebElement subCategoryCarpetTilesLinkText;

	// Sub Categories Flooring Accessories
	@FindBy(linkText = "Flooring Accessories")
	WebElement subCategoryFlooringAccessoriesLinkText;

	// Sub Categories Carpet Tools
	@FindBy(linkText = "Carpet Tools")
	WebElement subCategoryCarpetToolsLinkText;

	// Sub Categories Grout Tools
	@FindBy(linkText = "Grout Tools")
	WebElement subCategoryGroutToolsLinkText;

	// Sub Categories Ceiling Tiles & Panels
	@FindBy(linkText = "Ceiling Tiles & Panels")
	WebElement subCategoryCeilingTilesPanelsLinkText;

	// Sub Categories Suspended Frames
	@FindBy(linkText = "Suspended Frames")
	WebElement subCategorySuspendedFramesLinkText;

	// Method to Click on Suspended Frames in Sub Categories	
	public void clickSubCategorySuspendedFramesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategorySuspendedFramesLinkText);
			subCategorySuspendedFramesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Ceiling Tiles & Panels in Sub Categories	
	public void clickSubCategoryCeilingTilesPanelsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCeilingTilesPanelsLinkText);
			subCategoryCeilingTilesPanelsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Grout Tools in Sub Categories	
	public void clickSubCategoryGroutToolsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryGroutToolsLinkText);
			subCategoryGroutToolsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Carpet Tools in Sub Categories	
	public void clickSubCategoryCarpetToolsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCarpetToolsLinkText);
			subCategoryCarpetToolsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Flooring Accessories in Sub Categories	
	public void clickSubCategoryFlooringAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryFlooringAccessoriesLinkText);
			subCategoryFlooringAccessoriesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Carpet Tiles in Sub Categories	
	public void clickSubCategoryCarpetTilesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCarpetTilesLinkText);
			subCategoryCarpetTilesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Tile Adhesive in Sub Categories	
	public void clickSubCategoryTileAdhesiveLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryTileAdhesiveLinkText);
			subCategoryTileAdhesiveLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Grout & Repair in Sub Categories	
	public void clickSubCategoryGroutRepairLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryGroutRepairLinkText);
			subCategoryGroutRepairLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

}
