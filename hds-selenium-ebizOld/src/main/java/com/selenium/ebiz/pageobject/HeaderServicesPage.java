package com.selenium.ebiz.pageobject;

	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

	public class HeaderServicesPage extends BaseClass{

		// Constructor
		public HeaderServicesPage(WebDriver driver) 	{
			this.driver = driver;
			PageFactory.initElements(driver, this);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(headerShopByCategoryLinkText));		
		}

		// Shop by Category
		@FindBy(xpath="//span[@class='shop-by-category__label']")
		WebElement headerShopByCategoryLinkText;
		
		// L1 Product
		@FindBy(xpath="//a[contains(text(),'SERVICES')]/../div[@class='flyout-nav flyout-nav--visible']/div[@id='contentRecommendationWidget_HdsHeaderServicesFlyoutESpot']//nav/div/div/ul/li/a[contains(text(),'Custom Products')]")
		WebElement headerServicesCustomProductsLinkText;

		// L2 Product
		@FindBy(xpath = "//a[contains(text(),'SERVICES')]/../div[@class='flyout-nav flyout-nav--visible']/div[@id='contentRecommendationWidget_HdsHeaderServicesFlyoutESpot']//nav/div/div/ul/li/a[contains(text(),'Custom Products')]/../div/div/ul/li/a[text()='Order Forms']")
		WebElement headerServicesOrderFormsLinkText;

		@FindBy(xpath="//a[contains(text(),'SERVICES')]/../div[@class='flyout-nav flyout-nav--visible']/div[@id='contentRecommendationWidget_HdsHeaderServicesFlyoutESpot']//nav/div/div/ul/li/a[contains(text(),'Custom Products')]/../../../..")
		WebElement flyoutServicesL1Image;
		
		// L2 Flyout Services in Header
		@FindBy(xpath="//a[contains(text(),'SERVICES')]/../div[@class='flyout-nav flyout-nav--visible']/div[@id='contentRecommendationWidget_HdsHeaderServicesFlyoutESpot']//nav/div/div/ul/li/a[contains(text(),'Custom Products')]/../div[@class='flyout-menu__page']")
		WebElement flyoutServicesL2Image;
		
		// Header in Services
		@FindBy(xpath="//div[@id='headerRow1']/div/section/div/div/div/span[1]/a")
		WebElement headerServicessLinkText;

		// Header in Resources
		@FindBy(xpath="//div[@id='headerRow1']/div/section/div/div/div/span[2]/a")
		WebElement headerResourcesLinkText;
		
		// Header in Offers
		@FindBy(xpath="//div[@id='headerRow1']/div/section/div/div/div/span[3]/a")
		WebElement headerOffersLinkText;

		// Header in eCatalogs
		@FindBy(xpath="//div[@id='headerRow1']/div/section/div/div/div/span[4]/a")
		WebElement headereCatalogsLinkText;

		
		// Navigate to Previous Page
		public void navigateBackToPage() {
			driver.navigate().back();
		}
		
		// Method to Click on Services 
		public void clickHeaderServicesLinkText() throws InterruptedException {
			   System.out.println("inside header");
				WaitTool.waitForElement(driver, headerServicessLinkText);
				System.out.print("After wait");;
				headerServicessLinkText.click();
				System.out.println("After Clicking");
				WaitTool.waitFor(driver,true) ;
			}
		
		// Method to Verify for L1 Flyout Services
		public boolean isDisplayedL1FlyoutServices(){
			return CommonFunctions.isElementPresent(flyoutServicesL1Image);
		}

		// Method to Verify for L2 Flyout Services
		public boolean isDisplayedL2FlyoutServices(){
			return CommonFunctions.isElementPresent(flyoutServicesL2Image);
		}
		
		// Method to click on the Services of L1
		public  void clickHeaderServicesCustomProductsLinkText() throws InterruptedException {
			headerServicesCustomProductsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
		// Method to click on the Services of L2
		public  void clickHeaderServicesOrderFormsLinkText() throws InterruptedException {
			headerServicesOrderFormsLinkText.click();
			WaitTool.waitFor(driver, true);
		}

		// Method to Verify for Shop By Category
		public boolean isDisplayedShopByCategoryLinkText(){
			return CommonFunctions.isElementPresent(headerShopByCategoryLinkText);
		}

		// Method to Verify for Header Services
		public boolean isDisplayedServicessLinkText(){
			return CommonFunctions.isElementPresent(headerServicessLinkText);
		}
		// Method to Verify for Resources Services
		public boolean isDisplayedResourcesLinkText(){
			return CommonFunctions.isElementPresent(headerResourcesLinkText);
		}
		// Method to Verify for Offers Services
		public boolean isDisplayedOffersLinkText(){
			return CommonFunctions.isElementPresent(headerOffersLinkText);
		}
		// Method to Verify for eCatalogs Services
		public boolean isDisplayedeCatalogsLinkText(){
			return CommonFunctions.isElementPresent(headereCatalogsLinkText);
		}

		
}
