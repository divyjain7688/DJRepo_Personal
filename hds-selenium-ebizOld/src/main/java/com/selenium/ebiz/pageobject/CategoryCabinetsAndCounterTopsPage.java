package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class CategoryCabinetsAndCounterTopsPage  extends BaseClass {

	WebDriver driver;
	
	// Constructor
	public CategoryCabinetsAndCounterTopsPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	WebDriverWait wait = new WebDriverWait(driver,1300);
	wait.until(ExpectedConditions.visibilityOf(cabinetsAndCountertopsText));
	
	}

	@FindBy(linkText = "Under Sink Mats")
	WebElement cabinetsAndCountertopsText;
	
	@FindBy(xpath="//section[@class=\"category-tiles\"]//span")
	List<WebElement> L2Categories;
	
   // Top Categories Under Sink Mats
	@FindBy(linkText = "Under Sink Mats")
	WebElement topCategoryUnderSinkMatsLinkText;

	// Top Categories Counter tops
	@FindBy(linkText = "Countertops")
	WebElement topCategoryCountertopsLinkText;
	
	// Top Categories Kitchen Cabinets
	@FindBy(linkText = "Kitchen Cabinets")
	WebElement topCategoryKitchenCabinetsLinkText;	

	// Top Categories Medicine Cabinets and Cosmetic Boxes
	@FindBy(linkText = "Medicine Cabinets & Cosmetic Boxes")
	WebElement topCategoryMCCosmeticBoxesLinkText;	

	// Top Categories Bath Vanities
	@FindBy(linkText = "Bath Vanities")
	WebElement topCategoryBathVanitiesLinkText;	

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
	
	
	// Navigate to Back Page
	public void navigateBackToPage() {
		driver.navigate().back();
	}
	
	// Method to Click on Under Sink Mats in Top Categories
	public SubCategoryCabinetsAndCounterTopsPage clickTopCategoryUnderSinkMatsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryUnderSinkMatsLinkText);
			topCategoryUnderSinkMatsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryCabinetsAndCounterTopsPage(driver);
		}

	// Method to Click on counter Tops in Top Categories
	public SubCategoryCabinetsAndCounterTopsPage clickTopCategoryCountertopsLinkText() throws InterruptedException {
		 	WaitTool.waitForElement(driver, topCategoryCountertopsLinkText);
			topCategoryCountertopsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryCabinetsAndCounterTopsPage(driver);
		}
	
	// Method to Click on Kitchen Cabinets in Top Categories
	public SubCategoryCabinetsAndCounterTopsPage clickTopCategoryKitchenCabinetsLinkText() throws InterruptedException {
		 	WaitTool.waitForElement(driver, topCategoryKitchenCabinetsLinkText);
			topCategoryKitchenCabinetsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryCabinetsAndCounterTopsPage(driver);	
		}

	// Method to Click on Cosmetic Boxes in Top Categories
	public SubCategoryCabinetsAndCounterTopsPage clickTopCategoryMCCosmeticBoxesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryMCCosmeticBoxesLinkText);
			topCategoryMCCosmeticBoxesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryCabinetsAndCounterTopsPage(driver);	
		}
	
	// Method to Click on Bath Vanities in Top Categories
	public SubCategoryCabinetsAndCounterTopsPage clickTopCategoryBathVanitiesLinkText() throws InterruptedException {
		 	WaitTool.waitForElement(driver, topCategoryBathVanitiesLinkText);
			topCategoryBathVanitiesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryCabinetsAndCounterTopsPage(driver);
		}
	
	// Method to Click on home in Top Categories	
	public SubCategoryCabinetsAndCounterTopsPage clickCategoryHomeLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, categoryHomeLinkText);
			categoryHomeLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryCabinetsAndCounterTopsPage(driver);	
		}
	
	public Boolean isSelectedL2CategoryDisplayed(String l2categry)
	{
		Boolean flag=false;
		for(WebElement L2Category: L2Categories)
		{
			if(L2Category.getText().equals(l2categry))
			{
				flag= true;
				break;
			}
		}
		return flag;
	}
	
	
}
