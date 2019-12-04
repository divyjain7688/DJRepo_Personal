package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CategoryAppliancesPage {
    private WebDriver driver;
    protected WaitTool waitTool;
    private PageManager pageManager;

    public CategoryAppliancesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitTool  = new WaitTool();
        pageManager = new PageManager(driver);
    }

    //  This is used to verify for L3 Categories
    @FindAll(@FindBy(xpath = "//div[@class='category-info__sub-categories type--body-small']"))
    List<WebElement> l3Categories;
    @FindBy(xpath = "//a[@data-hds-tag='flyout-nav--shop-by-category__top'][text()='All Appliances']")
    WebElement allApplicancesFlyout;
    @FindBy(xpath = "//h1[contains(text(),'Appliances')]")
    WebElement applicancesText;
    //  This is used to verify for number of top Categories
    @FindAll(@FindBy(xpath = "//div[@data-slot-id='8']/section/a"))
    List<WebElement> rowCount;
    @FindBy(xpath = "//div[starts-with(@id,'container_')]/div[5]/div[1]/section")
    WebElement l2CategoryImage;

    @FindBy(xpath = "//*[contains(text(),'All Appliances')]")
    WebElement categoriesAllAppliancesLinkText;
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
    @FindBy(xpath = "//div[@data-hds-tag=\"breadcrumbs\"]")
    WebElement breadcrumbLink;
    @FindBy(xpath = "//div[@class='breadcrumbs']//a[contains(text(),'Home')]")
    WebElement homeLinkOnBreadcrumb;



    public String getCategoryPageHeadingText() {
        return topCategoryPageHeadingText.getText().trim();
    }

    // To Navigate to back Page
    public void navigateBackToPage() {

        driver.navigate().back();
    }

    public void clickAllAppliancesLinkUnderShopCategories(){
        waitTool.waitForElement(driver,categoriesAllAppliancesLinkText);
        categoriesAllAppliancesLinkText.click();
    }

    // Method to Click on Dishwashers Repair in Top Categories
    public void clickTopCategoryDishwashersRepairLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, topCategoryDishwashersRepairLinkText);
        topCategoryDishwashersRepairLinkText.click();
        waitTool.waitFor(driver, true);

    }

    // Method to Click on Disposers Repair in Top Categories
    public void clickTopCategoryDisposersRepairLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, topCategoryDisposersRepairLinkText);
        topCategoryDisposersRepairLinkText.click();
        waitTool.waitFor(driver, true);

    }

    // Method to Click on Category Ovens Ranges in Top Categories
    public void clickTopCategoryOvensRangesLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, topCategoryOvensRangesLinkText);
        topCategoryOvensRangesLinkText.click();
        waitTool.waitFor(driver, true);

    }

    // Method to Click on Microwaves Repair in Top Categories
    public void clickTopCategoryMicrowavesRepairLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, topCategoryMicrowavesRepairLinkText);
        topCategoryMicrowavesRepairLinkText.click();
        waitTool.waitFor(driver, true);

    }

    // Method to Click on RangeHoods Repair in Top Categories
    public void clickTopCategoryRangeHoodsRepairLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, topCategoryRangeHoodsRepairLinkText);
        topCategoryRangeHoodsRepairLinkText.click();
        waitTool.waitFor(driver, true);

    }

    // Method to Click on Refrigerators Freezers  in Top Categories
    public void clickTopCategoryRefrigeratorsFreezersLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, topCategoryRefrigeratorsFreezersLinkText);
        topCategoryRefrigeratorsFreezersLinkText.click();
        waitTool.waitFor(driver, true);

    }

    // Method to Click on Small Appliances in Top Categories
    public void clickTopCategorySmallAppliancesLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, topCategorySmallAppliancesLinkText);
        topCategorySmallAppliancesLinkText.click();
        waitTool.waitFor(driver, true);

    }

    // Method to Click on Washers Dryers in Top Categories

    public void clickTopCategoryWashersDryersLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, topCategoryWashersDryersLinkText);
        topCategoryWashersDryersLinkText.click();
        waitTool.waitFor(driver, true);
    }

    // Method to Click on Trash Compactors Repair in Top Categories
    public void clickTopCategoryTrashCompactorsRepairLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, topCategoryTrashCompactorsRepairLinkText);
        topCategoryTrashCompactorsRepairLinkText.click();
        waitTool.waitFor(driver, true);
    }

    // Method to Click on home in Top Categories
    public void clickCategoryHomeLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, categoryHomeLinkText);
        categoryHomeLinkText.click();
        waitTool.waitFor(driver, true);
    }

    // Method to Click on home in Top Categories
    public int getCategoryLinkText() throws InterruptedException {
        waitTool.waitFor(driver, true);
        return rowCount.size();
    }

    // Method to for L2 Category
    public boolean isDisplayedL2Categories() {
        return pageManager.common().isElementPresent(l2CategoryImage);
    }


    // Method to get all the sub Categories
    public List<WebElement> getSubCategoryLinkText() throws InterruptedException {
        waitTool.waitFor(driver, true);
        return l3Categories;
    }

    // method to check if the values are there in subcategories
    public boolean isL3CategoriesDisplayed(int numbers) throws Exception {
        boolean display = false;
        List<WebElement> subcategoriesAllLinks = driver.findElements(By.xpath("//div[starts-with(@id,\'container_\')]/div[5]/div[1]/section/div[" + numbers + "]/div/div/a"));
        waitTool.waitFor(driver, true);
        if (subcategoriesAllLinks.size() > 0) {
            display = true;
        }
        return display;
    }

    public void isBreadcrumbHasSearchedCategory(String cat) {
    	waitTool.waitForElement(driver, breadcrumbLink);
        String breadcrumbText = breadcrumbLink.getText();
        System.out.println("breadcrumbText is " + breadcrumbText + "and cat is " + cat);
        Assert.assertTrue(breadcrumbText.contains(cat));
    }

    public void clickOnHomeLinkOnBreadcrumb() {
        homeLinkOnBreadcrumb.click();
    }

}
