package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class CategoryAppliancesPage extends BaseClass{

	WebDriver driver;
	public CategoryAppliancesPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver,1300);
	//	wait.until(ExpectedConditions.visibilityOf(allApplicancesFlyout));
		wait.until(ExpectedConditions.visibilityOf(applicancesText));

	}

//  This is used to verify for L3 Categories
	@FindAll(@FindBy(xpath="//div[@class='category-info__sub-categories type--body-small']"))
	List<WebElement> l3Categories;
	
	
	@FindBy(xpath="//a[@data-hds-tag='flyout-nav--shop-by-category__top'][text()='All Appliances']")
	WebElement allApplicancesFlyout;
	
	
	@FindBy(xpath="//h1[contains(text(),'Appliances')]")
	WebElement applicancesText;
	
	
 //  This is used to verify for number of top Categories
	@FindAll(@FindBy(xpath="//div[@data-slot-id='8']/section/a"))
	List<WebElement> rowCount;
	
	@FindBy(xpath="//div[starts-with(@id,'container_')]/div[5]/div[1]/section")
	WebElement l2CategoryImage;
	
	// Top Categories DishWashers and Repair
	@FindBy(linkText = "Dishwashers & Repair")
	WebElement topCategoryDishwashersRepairLinkText;
	
    // Top Categories Disposers and Repair	
	@FindBy(linkText = "Disposers & Repair")
	WebElement topCategoryDisposersRepairLinkText;
	
	// Top Categories Ovens and Ranges
	@FindBy(linkText = "Ovens & Ranges")
	WebElement topCategoryOvensRangesLinkText;

	//Top Categories Microwaves Repair
	@FindBy(linkText = "Microwaves & Repair")
	WebElement topCategoryMicrowavesRepairLinkText;
	
    // Top Categories Range Hoods and Repair
	@FindBy(linkText = "Range Hoods & Repair")
	WebElement topCategoryRangeHoodsRepairLinkText;

	//Top Categories Refrigerators and Freezers  
	@FindBy(linkText = "Refrigerators & Freezers")
	WebElement topCategoryRefrigeratorsFreezersLinkText;

    // Top Categories Small Appliances
	@FindBy(linkText = "Small Appliances")
	WebElement topCategorySmallAppliancesLinkText;

	// Top Categories Washers and Dryers
	@FindBy(xpath = "//a[@data-hds-tag='flyout-nav--shop-by__sub-category__link'][text()='Washers & Dryers']")
	WebElement topCategoryWashersDryersLinkText;

	// Top Cagetories Trash Compactors and Repair  
	@FindBy(linkText = "Trash Compactors & Repair")
	WebElement topCategoryTrashCompactorsRepairLinkText;
	
	//To home page link
	@FindBy(xpath = "//*[@id='WC_BreadCrumb_Link_1_1_-3028_40453']")
	WebElement categoryHomeLinkText;

	//To Verify for the top category
	@FindBy(xpath = "//*[@id='PageHeading_2_-3001_40466']/h1")
	WebElement topCategoryPageHeadingText;
	
	public String getCategoryPageHeadingText() {
		return topCategoryPageHeadingText.getText().trim();
	}
	
	// To Navigate to back Page
	public void navigateBackToPage() {
		
		driver.navigate().back();
	}


	
	// Method to Click on Dishwashers Repair in Top Categories	
	public SubCategoryAppliancesPage clickTopCategoryDishwashersRepairLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryDishwashersRepairLinkText);
			topCategoryDishwashersRepairLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryAppliancesPage(driver);
			
		}
	

	// Method to Click on Disposers Repair in Top Categories
	public SubCategoryAppliancesPage clickTopCategoryDisposersRepairLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryDisposersRepairLinkText);
			topCategoryDisposersRepairLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryAppliancesPage(driver);
		}

	// Method to Click on Category Ovens Ranges in Top Categories
	public SubCategoryAppliancesPage clickTopCategoryOvensRangesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryOvensRangesLinkText);
			topCategoryOvensRangesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryAppliancesPage(driver);
		}

	// Method to Click on Microwaves Repair in Top Categories
	public SubCategoryAppliancesPage clickTopCategoryMicrowavesRepairLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryMicrowavesRepairLinkText);
			topCategoryMicrowavesRepairLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryAppliancesPage(driver);
		}
	
	// Method to Click on RangeHoods Repair in Top Categories
	public SubCategoryAppliancesPage clickTopCategoryRangeHoodsRepairLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryRangeHoodsRepairLinkText);
			topCategoryRangeHoodsRepairLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryAppliancesPage(driver);
		}
	
	// Method to Click on Refrigerators Freezers  in Top Categories
	public SubCategoryAppliancesPage clickTopCategoryRefrigeratorsFreezersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryRefrigeratorsFreezersLinkText);
			topCategoryRefrigeratorsFreezersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryAppliancesPage(driver);
		}
	
	// Method to Click on Small Appliances in Top Categories
	public SubCategoryAppliancesPage clickTopCategorySmallAppliancesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategorySmallAppliancesLinkText);
			topCategorySmallAppliancesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryAppliancesPage(driver);
		}
	
	// Method to Click on Washers Dryers in Top Categories

	public SubCategoryAppliancesPage clickTopCategoryWashersDryersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryWashersDryersLinkText);
			topCategoryWashersDryersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryAppliancesPage(driver);
		}
	
	// Method to Click on Trash Compactors Repair in Top Categories
		public SubCategoryAppliancesPage clickTopCategoryTrashCompactorsRepairLinkText() throws InterruptedException {
				WaitTool.waitForElement(driver, topCategoryTrashCompactorsRepairLinkText);
				topCategoryTrashCompactorsRepairLinkText.click();
				WaitTool.waitFor(driver,true) ;
				return new SubCategoryAppliancesPage(driver);
			}
	
		// Method to Click on home in Top Categories	
		public SubCategoryAppliancesPage clickCategoryHomeLinkText() throws InterruptedException {
				WaitTool.waitForElement(driver, categoryHomeLinkText);
				categoryHomeLinkText.click();
				WaitTool.waitFor(driver,true) ;
				return new SubCategoryAppliancesPage(driver);
			}
		
		// Method to Click on home in Top Categories	
		public int getCategoryLinkText() throws InterruptedException {
			WaitTool.waitFor(driver,true) ;	
			return rowCount.size();
		}
		
		// Method to for L2 Category
		public boolean isDisplayedL2Categories(){
		   return CommonFunctions.isElementPresent(l2CategoryImage);
		}
		
	
		// Method to get all the sub Categories	
		public List<WebElement> getSubCategoryLinkText() throws InterruptedException {
			WaitTool.waitFor(driver,true) ;	
			return l3Categories;
		}	
		
		// method to check if the values are there in subcategories
		public boolean isL3CategoriesDisplayed(int numbers) throws Exception {
            boolean display = false;
            List<WebElement> subcategoriesAllLinks = driver.findElements(By.xpath("//div[starts-with(@id,\'container_\')]/div[5]/div[1]/section/div["+numbers+"]/div/div/a"));
            WaitTool.waitFor(driver, true);	
            if (subcategoriesAllLinks.size()>0){
                display = true; 
             }
            return display;
}
}
