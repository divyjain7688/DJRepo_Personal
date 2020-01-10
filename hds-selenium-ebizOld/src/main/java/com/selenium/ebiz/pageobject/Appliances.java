/**
 * @author Suresh
 */

package com.selenium.ebiz.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class Appliances extends BaseClass{
	WebDriver driver;
	public Appliances(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOf(topCategoryDishwashersRepairLinkText));
		wait.until(ExpectedConditions.visibilityOf(appliancesText));
	}

	// Top Categories Washers and Dryers
	@FindBy(linkText = "Washers & Dryers")
	WebElement topCategoryWashersDryersLinkText;

	// Method to Click on Washers Dryers in Top Categories

	public SubCategoryAppliancesPage clickTopCategoryWashersDryersLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, topCategoryWashersDryersLinkText);
		topCategoryWashersDryersLinkText.click();
		WaitTool.waitFor(driver,true) ;
		return new SubCategoryAppliancesPage(driver);
	}


	// Top Categories DishWashers and Repair
	@FindBy(xpath="//span[text()='Dishwashers & Repair']")
	WebElement topCategoryDishwashersRepairLinkText;

	// Method to Click on Dishwashers Repair in Top Categories	
	public SubCategoryAppliancesPage clickTopCategoryDishwashersRepairLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, topCategoryDishwashersRepairLinkText);
		topCategoryDishwashersRepairLinkText.click();
		WaitTool.waitFor(driver,true) ;
		return new SubCategoryAppliancesPage(driver);
	}

	// e Spot at Top Categories
	@FindBy(xpath="//div[@class=\"row margin-true\"][2]")
	WebElement eSpotCategoryImage;

	// To Verify wheather eSpot is displayed
	public boolean isDisplayedeSpotTopCategory(){
		return CommonFunctions.isElementPresent(eSpotCategoryImage);
	}

	// e Spot at Top Categories
	@FindBy(xpath="//section[@class=\"category-tiles\"]")
	WebElement contentCarouselImage;

	// To Verify wheather eSpot is displayed
	public boolean isDisplayedeContentCarouselTopCategory(){
		return CommonFunctions.isElementPresent(contentCarouselImage);
	}

	// Shop by Category
	@FindBy(xpath="//span[@class='shop-by-category__label']")
	WebElement headerShopByCategoryLinkText;
	
	@FindBy(xpath="//h1[contains(text(),'Appliances')]")
	WebElement appliancesText;
	
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

	// Method to Click on Shop By Category in Header	
	public void clickHeaderShopByCategoryLinkText() throws InterruptedException {
		Thread.sleep(10000);
		WaitTool.waitForElement(driver, headerShopByCategoryLinkText);
		headerShopByCategoryLinkText.click();
		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

	// Method to Click on Disposers Repair in Top Categories
	public void clickTopCategoryDisposersRepairLinkText() throws InterruptedException {
		Thread.sleep(10000);
		WaitTool.waitForElement(driver, topCategoryDisposersRepairLinkText);
		topCategoryDisposersRepairLinkText.click();
		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	// Method to Click on Category Ovens Ranges in Top Categories
	public void clickTopCategoryOvensRangesLinkText() throws InterruptedException {
		Thread.sleep(10000);
		WaitTool.waitForElement(driver, topCategoryOvensRangesLinkText);
		topCategoryOvensRangesLinkText.click();
		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	// Method to Click on Microwaves Repair in Top Categories
	public void clickTopCategoryMicrowavesRepairLinkText() throws InterruptedException {
		Thread.sleep(10000);
		WaitTool.waitForElement(driver, topCategoryMicrowavesRepairLinkText);
		topCategoryMicrowavesRepairLinkText.click();
		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	// Method to Click on RangeHoods Repair in Top Categories
	public void clickTopCategoryRangeHoodsRepairLinkText() throws InterruptedException {
		Thread.sleep(10000);
		WaitTool.waitForElement(driver, topCategoryRangeHoodsRepairLinkText);
		topCategoryRangeHoodsRepairLinkText.click();
		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	// Method to Click on Refrigerators Freezers  in Top Categories
	public void clickTopCategoryRefrigeratorsFreezersLinkText() throws InterruptedException {
		Thread.sleep(10000);
		WaitTool.waitForElement(driver, topCategoryRefrigeratorsFreezersLinkText);
		topCategoryRefrigeratorsFreezersLinkText.click();
		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	// Method to Click on Small Appliances in Top Categories
	public void clickTopCategorySmallAppliancesLinkText() throws InterruptedException {
		Thread.sleep(10000);
		WaitTool.waitForElement(driver, topCategorySmallAppliancesLinkText);
		topCategorySmallAppliancesLinkText.click();
		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	// Method to Click on Trash Compactors Repair in Top Categories
	public void clickTopCategoryTrashCompactorsRepairLinkText() throws InterruptedException {
		Thread.sleep(10000);
		WaitTool.waitForElement(driver, topCategoryTrashCompactorsRepairLinkText);
		topCategoryTrashCompactorsRepairLinkText.click();
		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	// Method to Click on home in Top Categories	
	public void clickCategoryHomeLinkText() throws InterruptedException {
		Thread.sleep(10000);
		WaitTool.waitForElement(driver, categoryHomeLinkText);
		categoryHomeLinkText.click();
		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

}
