package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class SubCategoryFurnitureAndDecorPage  extends BaseClass{

	public SubCategoryFurnitureAndDecorPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
		
	}


	// Sub Categories Mattresses
	@FindBy(linkText = "Mattresses")
	WebElement subCategoryMattressesLinkText;

	// Sub Categories Rollaway Beds
	@FindBy(linkText = "Rollaway Beds")
	WebElement subCategoryRollawayBedsLinkText;

	// Sub Categories Desk Chairs
	@FindBy(linkText = "Desk Chairs")
	WebElement subCategoryDeskChairsLinkText;

	// Sub Categories Desks
	@FindBy(linkText = "Desks")
	WebElement subCategoryDesksLinkText;

	// Sub Categories Wall Mirrors & Frames
	@FindBy(linkText = "Wall Mirrors & Frames")
	WebElement subCategoryWallMirrorsFramesLinkText;

	// Sub Categories Vanity Mirrors
	@FindBy(linkText = "Vanity Mirrors")
	WebElement subCategoryVanityMirrorsLinkText;

	// Sub Categories Recliners
	@FindBy(linkText = "Recliners")
	WebElement subCategoryReclinersLinkText;

	// Sub Categories Ottomans
	@FindBy(linkText = "Ottomans")
	WebElement subCategoryOttomansLinkText;

	// Sub Categories Catering Tables
	@FindBy(linkText = "Catering Tables")
	WebElement subCategoryCateringTablesLinkText;

	// Sub Categories Cocktail Tables
	@FindBy(linkText = "Cocktail Tables")
	WebElement subCategoryCocktailTablesLinkText;

	// Sub Categories Risers
	@FindBy(linkText = "Risers")
	WebElement subCategoryRisersLinkText;

	// Sub Categories Steps & Guardrails
	@FindBy(linkText = "Steps & Guardrails")
	WebElement subCategoryStepsGuardrailsLinkText;

	// Method to Click on Steps & Guardrails in Sub Categories	
	public void clickSubCategoryStepsGuardrailsLinkText() throws InterruptedException {
		 	WaitTool.waitForElement(driver, subCategoryStepsGuardrailsLinkText);
			subCategoryStepsGuardrailsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Risers in Sub Categories	
	public void clickSubCategoryRisersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryRisersLinkText);
			subCategoryRisersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Cocktail Tables in Sub Categories	
	public void clickSubCategoryCocktailTablesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCocktailTablesLinkText);
			subCategoryCocktailTablesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Catering Tables in Sub Categories	
	public void clickSubCategoryCateringTablesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCateringTablesLinkText);
			subCategoryCateringTablesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Ottomans in Sub Categories	
	public void clickSubCategoryOttomansLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryOttomansLinkText);
			subCategoryOttomansLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Recliners in Sub Categories	
	public void clickSubCategoryReclinersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryReclinersLinkText);
			subCategoryReclinersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Vanity Mirrors in Sub Categories	
	public void clickSubCategoryVanityMirrorsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryVanityMirrorsLinkText);
			subCategoryVanityMirrorsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Wall Mirrors & Frames in Sub Categories	
	public void clickSubCategoryWallMirrorsFramesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryWallMirrorsFramesLinkText);
			subCategoryWallMirrorsFramesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Desks in Sub Categories	
	public void clickSubCategoryDesksLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryDesksLinkText);
			subCategoryDesksLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Desk Chairs in Sub Categories	
	public void clickSubCategoryDeskChairsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryDeskChairsLinkText);
			subCategoryDeskChairsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Rollaway Beds in Sub Categories	
	public void clickSubCategoryRollawayBedsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryRollawayBedsLinkText);
			subCategoryRollawayBedsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Mattresses in Sub Categories	
	public void clickSubCategoryMattressesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryMattressesLinkText);
			subCategoryMattressesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	

	

	

}
