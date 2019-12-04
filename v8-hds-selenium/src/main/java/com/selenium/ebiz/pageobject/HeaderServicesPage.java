package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderServicesPage {
    // Shop by Category
    @FindBy(xpath = "//span[@class='shop-by-category__label']")
    public WebElement headerShopByCategoryLinkText;
    // Header in Services
    @FindBy(xpath = "//div[@id='headerRow1']/div/section/div/div/div/span[1]/a")
    public WebElement headerServicessLinkText;
    // Header in Resources
    @FindBy(xpath = "//div[@id='headerRow1']/div/section/div/div/div/span[2]/a")
    public WebElement headerResourcesLinkText;
    // Header in Offers
    @FindBy(xpath = "//div[@id='headerRow1']/div/section/div/div/div/span[3]/a")
    public WebElement headerOffersLinkText;
    // Header in eCatalogs
    @FindBy(xpath = "//div[@id='headerRow1']/div/section/div/div/div/span[4]/a")
    public WebElement headereCatalogsLinkText;
    // L1 Product
    @FindBy(xpath = "//a[contains(text(),'Custom Products')]")
    WebElement headerServicesCustomProductsLinkText;
    // L2 Product
    @FindBy(xpath = "//div[@class='nav__links type--caption type--extra-bold']/span/a[contains(text(),'Services')]/../div/div[@class='contentRecommendationWidget']//div/div/nav/div/div/ul/li/a[contains(text(),'Custom Products')]/../div/div/ul/li/a[contains(text(),'Order Forms')]")
    WebElement headerServicesOrderFormsLinkText;
    @FindBy(xpath = "//div[@class='nav__links type--caption type--extra-bold']/span/a[contains(text(),'Services')]/../div")
    WebElement flyoutServicesL1Image;
    // L2 Flyout Services in Header
    @FindBy(xpath = "//div[@class='nav__links type--caption type--extra-bold']/span/a[contains(text(),'Services')]/../div/div[@class='contentRecommendationWidget']//div/div/nav/div/div/ul/li/a[contains(text(),'Custom Products')]/../div")
    WebElement flyoutServicesL2Image;
    private WebDriver driver;
    private WaitTool waitTool;
    private PageManager pageManager;

    // Constructor
    public HeaderServicesPage(WebDriver driver) {
        this.driver = driver;
        this.waitTool = new WaitTool();
        this.pageManager=new PageManager(driver);
        PageFactory.initElements(driver, this);

    }

    // Navigate to Previous Page
    public void navigateBackToPage() {
        driver.navigate().back();
    }

    // Method to Click on Services
    public void clickHeaderServicesLinkText() throws InterruptedException {
        System.out.println("inside header");
        waitTool.waitForElement(driver, headerServicessLinkText);
        pageManager.common().scrolltoViewElement(headerServicessLinkText, driver);
        System.out.print("After wait");
        ;
        headerServicessLinkText.click();
        System.out.println("After Clicking");
        waitTool.waitFor(driver, true);
    }

    // Method to Verify for L1 Flyout Services
    public boolean isDisplayedL1FlyoutServices() {
        return pageManager.common().isElementPresent(flyoutServicesL1Image);
    }

    // Method to Verify for L2 Flyout Services
    public boolean isDisplayedL2FlyoutServices() {
        return pageManager.common().isElementPresent(flyoutServicesL2Image);
    }

    // Method to click on the Services of L1
    public void clickHeaderServicesCustomProductsLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, headerServicesCustomProductsLinkText);
        pageManager.common().scrolltoViewElement(headerServicesCustomProductsLinkText, driver);
        headerServicesCustomProductsLinkText.click();
        waitTool.waitFor(driver, true);
    }

    // Method to click on the Services of L2
    public void clickHeaderServicesOrderFormsLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, headerServicesOrderFormsLinkText);
        pageManager.common().scrolltoViewElement(headerServicesOrderFormsLinkText, driver);
        headerServicesOrderFormsLinkText.click();
        waitTool.waitFor(driver, true);
    }

/*		// Method to Verify for Shop By Category
		public boolean isDisplayedShopByCategoryLinkText(){
			return .isElementPresent(headerShopByCategoryLinkText);
		}

		// Method to Verify for Header Services
		public boolean isDisplayedServicessLinkText(){
			return .isElementPresent(headerServicessLinkText);
		}
		// Method to Verify for Resources Services
		public boolean isDisplayedResourcesLinkText(){
			return .isElementPresent(headerResourcesLinkText);
		}
		// Method to Verify for Offers Services
		public boolean isDisplayedOffersLinkText(){
			return .isElementPresent(headerOffersLinkText);
		}
		// Method to Verify for eCatalogs Services
		public boolean isDisplayedeCatalogsLinkText(){
			return .isElementPresent(headereCatalogsLinkText);
		}*/


}
