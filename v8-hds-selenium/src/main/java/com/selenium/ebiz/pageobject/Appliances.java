/**
 * @author Suresh
 */

package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Appliances {

	private WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;

	public Appliances(WebDriver driver) {
		this.driver = driver;
		this.waitTool = new WaitTool();
		this.pageManager=new PageManager(driver);
		PageFactory.initElements(driver, this);

	}

	// Top Categories Washers and Dryers
	@FindBy(xpath="//*[@class='category-tiles__tile']//*[text()='Washers & Dryers']")
	WebElement topCategoryWashersDryersLinkText;

	// e Spot at Top Categories
	@FindBy(xpath = "//div[@class='row margin-true'][2]")
	public WebElement eSpotCategoryImage;

	@FindBy(xpath = "//*[@data-hds-tag='rich-relevance__block']/a")
	public WebElement bannersRichRelevance;

	// e Spot at Top Categories
	@FindBy(xpath = "//section[@class='category-tiles']")
	public WebElement contentCarouselImage;

	@FindBy(xpath = "//section[@class='category-tiles']/a")
	List<WebElement> listOfSubCategoriesOnThePage;


	@FindBy(xpath = "//*[@class='carousel clip-true']")
	WebElement richRelevanceCarousel;

	// Top Categories DishWashers and Repair
	@FindBy(xpath = "//span[text()='Dishwashers & Repair']")
	WebElement topCategoryDishwashersRepairLinkText;

	// Shop by Category
	@FindBy(xpath = "//span[@class='shop-by-category__label']")
	WebElement headerShopByCategoryLinkText;

	@FindBy(xpath = "//h1[contains(text(),'Appliances')]")
	WebElement appliancesTitle;

	// Top Categories Disposers and Repair
	@FindBy(linkText = "Disposers & Repair")
	WebElement topCategoryDisposersRepairLinkText;

	// Top Categories Ovens and Ranges
	@FindBy(linkText = "Ovens & Ranges")
	WebElement topCategoryOvensRangesLinkText;

	// Top Categories Microwaves Repair
	@FindBy(linkText = "Microwaves & Repair")
	WebElement topCategoryMicrowavesRepairLinkText;

	// Top Categories Range Hoods and Repair
	@FindBy(linkText = "Range Hoods & Repair")
	WebElement topCategoryRangeHoodsRepairLinkText;

	// Top Categories Refrigerators and Freezers
	@FindBy(linkText = "Refrigerators & Freezers")
	WebElement topCategoryRefrigeratorsFreezersLinkText;

	// Top Categories Small Appliances
	@FindBy(linkText = "Small Appliances")
	WebElement topCategorySmallAppliancesLinkText;

	// Top Categories Trash Compactors and Repair
	@FindBy(linkText = "Trash Compactors & Repair")
	WebElement topCategoryTrashCompactorsRepairLinkText;

	// To home page link
	@FindBy(xpath = "//*[@id='WC_BreadCrumb_Link_1_1_-3028_40453']")
	WebElement categoryHomeLinkText;

	// To Verify for the top category
	@FindBy(xpath = "//*[@id='PageHeading_2_-3001_40466']/h1")
	WebElement topCategoryPageHeadingText;


//eSpotCategoryImage

	public Boolean isContentCarouselSubCategoriesDisplayed(){
		waitTool.waitForElement(driver,contentCarouselImage);
		int categList = listOfSubCategoriesOnThePage.size();
		if(categList>0) {
			return contentCarouselImage.isDisplayed();
		} else {
			return false;
		}
	}

	public Boolean iSeSpotCategoryImageDisplayed(){
		waitTool.waitForElement(driver,eSpotCategoryImage);
		return eSpotCategoryImage.isDisplayed();
	}


	public Boolean isRichRelevBannerDisplayed(){
		waitTool.waitForElement(driver,bannersRichRelevance);
		return bannersRichRelevance.isDisplayed();
	}

	public Boolean isRichRelevanceCarouselDisplayed() {

		pageManager.common().scrollDown(driver);
		waitTool.waitForElement(driver,richRelevanceCarousel);
		return richRelevanceCarousel.isDisplayed();
	}

	public void clickEachSubCategoryOnLandingPage (){

		waitTool.waitForElement(driver,appliancesTitle);
		int categList = listOfSubCategoriesOnThePage.size();
		System.out.println("categ list before loop: " + categList);
			for (int i=0;i<categList;i++){
				    List<WebElement> subCategory = listOfSubCategoriesOnThePage;

					pageManager.common().scrolltoViewElement(contentCarouselImage,driver);
					System.out.println(subCategory.get(i).getText());
					subCategory.get(i).click();
					System.out.println("Click SubCategory");
					pageManager.productListingPage().plpHeadingText.isDisplayed();
					System.out.println("PLP title displayed");
					driver.navigate().back();
					System.out.println("Naviagte back to the Landing page");
				}
		}



	// Method to Click on Washers Dryers in Top Categories
	public void clickTopCategoryWashersDryersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, topCategoryWashersDryersLinkText);
		pageManager.common().scrolltoViewElement(topCategoryWashersDryersLinkText,driver);
		topCategoryWashersDryersLinkText.click();
	}

	// Method to Click on Dishwashers Repair in Top Categories
	public SubCategoryAppliancesPage clickTopCategoryDishwashersRepairLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, topCategoryDishwashersRepairLinkText);
		topCategoryDishwashersRepairLinkText.click();
		waitTool.waitFor(driver, true);
		return new SubCategoryAppliancesPage(driver);
	}

	public String getCategoryPageHeadingText() {
		return topCategoryPageHeadingText.getText().trim();
	}

	// To Navigate to back Page
	public void navigateBackToPage() {

		driver.navigate().back();
	}

	// Method to Click on Shop By Category in Header
	public void clickHeaderShopByCategoryLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, headerShopByCategoryLinkText);
		headerShopByCategoryLinkText.click();
	}

	// Method to Click on Disposers Repair in Top Categories
	public void clickTopCategoryDisposersRepairLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, topCategoryDisposersRepairLinkText);
		topCategoryDisposersRepairLinkText.click();
	}

	// Method to Click on Category Ovens Ranges in Top Categories
	public void clickTopCategoryOvensRangesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, topCategoryOvensRangesLinkText);
		topCategoryOvensRangesLinkText.click();
	}

	// Method to Click on Microwaves Repair in Top Categories
	public void clickTopCategoryMicrowavesRepairLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, topCategoryMicrowavesRepairLinkText);
		topCategoryMicrowavesRepairLinkText.click();
	}

	// Method to Click on RangeHoods Repair in Top Categories
	public void clickTopCategoryRangeHoodsRepairLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, topCategoryRangeHoodsRepairLinkText);
		topCategoryRangeHoodsRepairLinkText.click();
	}

	// Method to Click on Refrigerators Freezers in Top Categories
	public void clickTopCategoryRefrigeratorsFreezersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, topCategoryRefrigeratorsFreezersLinkText);
		topCategoryRefrigeratorsFreezersLinkText.click();
	}
	
	public String getRefrigeratorFreezerText(){
		return topCategoryRefrigeratorsFreezersLinkText.getText();
	}

	// Method to Click on Small Appliances in Top Categories
	public void clickTopCategorySmallAppliancesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, topCategorySmallAppliancesLinkText);
		topCategorySmallAppliancesLinkText.click();
	}

	// Method to Click on Trash Compactors Repair in Top Categories
	public void clickTopCategoryTrashCompactorsRepairLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, topCategoryTrashCompactorsRepairLinkText);
		topCategoryTrashCompactorsRepairLinkText.click();
	}

	// Method to Click on home in Top Categories
	public void clickCategoryHomeLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryHomeLinkText);
		categoryHomeLinkText.click();
	}
	
	public Boolean isDisplayedAppliancesTitle()
    {
		waitTool.waitForElement(driver, appliancesTitle);
        return appliancesTitle.isDisplayed();
    }

}
