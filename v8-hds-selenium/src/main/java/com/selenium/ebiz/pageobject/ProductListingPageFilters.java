package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductListingPageFilters {
    private WebDriver driver;
    private WaitTool waitTool;
    private PageManager pageManager;
    public String radiobtnNumber;

    public ProductListingPageFilters(WebDriver driver)
    {
        this.driver = driver;
        this.waitTool = new WaitTool();
        PageFactory.initElements(driver, this);
        this.pageManager = new PageManager(driver);
    }

    @FindBy(xpath ="//*[@class='facetSelect']//div" )
    public
    List<WebElement> expandedCategoryFilterFacetQuantity;

    @FindBy(xpath = "//*[@class='categoryNavPrevious changePointer subcat-level-previous']")
    public WebElement categoryNavigateToAllArrow;

    @FindBy(xpath = "//*[@class='facetSelect']/*[@class=' l1 category-tree__category']//label")
       //     "//*[@class='facetSelect']/div")
    public List<WebElement> displayedCategoryFilterFacets;

    @FindBy(xpath = "//*[@class='subcat-filter-box__items--more']/*[@class=' l1 category-tree__category']//label")
    //     "//*[@class='facetSelect']/div")
    public List<WebElement> showMoreCategoryFilterFacets;


    @FindBy(xpath ="//a[contains(text(),'Made in the USA')]" )
    WebElement madeInUSAFilterTab;

    @FindBy(xpath = "//*[@data-hds-tag='breadcrumbs']/a[3]")
    public WebElement thirdFilterInBreadcrumb;

    @FindBy(xpath ="//*[@id='facet_77971001013210511032116104101328583655889101115_10_-3004_16951']/span")
    public WebElement yesMadeInUSACheckBox;

    @FindBy(xpath ="//*[@id='77971001013210511032116104101328583655889101115_ACCE_Label']")
    public WebElement yesMadeInUSACheckBoxText;

    @FindBy(xpath ="//*[@id='facet_77971001013210511032116104101328583655878111_10_-3004_16951']/span")
    WebElement noMadeInUSACheckBox;

    @FindBy(xpath ="//a[contains(text(),'ADA Approved')]" )
    WebElement adaApprovedFilterTab;

    @FindBy(xpath ="//*[@id='facet_65686532651121121141111181011005878111_10_-3004_16951']/span")
    WebElement noADAApprovedCheckBox;

    @FindBy(xpath ="//*[@id='65686532651121121141111181011005878111_ACCE_Label']")
    public WebElement noADAApprovedCheckBoxText;

    @FindBy(xpath ="//a[contains(text(),'GSA Scheduled')]" )
    WebElement gsaScheduledFilterTab;

    @FindBy(xpath ="//*[@id='facet_71836532651121121141111181011005889101115_10_-3004_16951']/span" )
    WebElement yesGSAScheduledCheckBox;

    @FindBy(xpath ="//*[@id='71836532651121121141111181011005889101115_ACCE_Label']")
    public WebElement yesGSAScheduledCheckBoxText;

    @FindBy(xpath ="//*[@id='facet_71836532651121121141111181011005878111_10_-3004_16951']/span" )
    WebElement noGSAScheduledCheckBox;


    @FindBy(xpath ="//*[text()='Category']" )
    WebElement categoryFilterTab;

    @FindBy(xpath ="//*[@class='subcat-filters']//*[text()='Show more']" )
    public
    WebElement showMoreOnCategoryFilterTab;

    @FindBy(xpath ="//*[@data-hds-tag='subcat-header__result-count']" )
    public
    WebElement subcategoryResultCountAfterFilter;

    @FindBy(xpath = "//a[contains(text(),'Clearance')]")
    public WebElement clearanceFilter;

    @FindBy(xpath = "//*[@id='facet_671081019711497110991015889101115_10_-3004_16951']/span" )
    public WebElement clearanceYesCheckBox;

    @FindBy(xpath ="" )
    WebElement element;



    public int getExtandedFacetNumberInCategoryTab() {
       int facetsize = expandedCategoryFilterFacetQuantity.size();
       System.out.println("facetsize" + facetsize);
       return facetsize;
    }

    public void clickShowMoreOnCategoryFilterTab(){
    	try {
        showMoreOnCategoryFilterTab.click();
    	}
    	catch(Exception e)
    	{
    		System.out.println("showMoreOnCategoryFilterTab is not diaplyed " + e);
    	}
    }

    public boolean isDisplayedShowMoreOnCategoryFilterTab(){
    	Boolean flag = false;
    	try {
        waitTool.waitForElement(driver,categoryFilterTab);
        showMoreOnCategoryFilterTab.isDisplayed();
        flag=true;
        return flag;
    	}
    	catch(Exception e)
    	{
    		System.out.println("categoryFilterTab is not dispalyed" + e);
    	}
		return flag;
    }

    public boolean isDisplayedCategoryFilterTab(){
        waitTool.waitForElement(driver,categoryFilterTab);
        return categoryFilterTab.isDisplayed();
    }

    public boolean verifyShowMoreAbsent() throws Exception {
        try {
            showMoreOnCategoryFilterTab.isDisplayed();
            System.out.println("Element Present");
            return false;

        } catch (NoSuchElementException e) {
            System.out.println("Show More is absent");
            return true;
        }
    }


    public void selectAndClickSubCategory(int facet){

    	waitTool.waitForElement(driver, displayedCategoryFilterFacets.get(facet));
        pageManager.common().scrolltoViewElement(categoryFilterTab, driver);
        //displayedCategoryFilterFacets.size();
        displayedCategoryFilterFacets.get(facet).click();
    //	System.out.println("clicked on " + displayedCategoryFilterFacets.get(facet).getText());

    }

    public void navigateBackToPLP(){
        driver.navigate().back();
        waitTool.waitFor(driver,true);
    }

    public boolean filteredBreadcrumbIsDisplayed(int filterBreadcrumb){
        waitTool.waitForElement(driver,thirdFilterInBreadcrumb);

        return pageManager.productListingPage().listfilteredBreadCrumb.get(filterBreadcrumb).isDisplayed();
      //  return thirdFilterInBreadcrumb.isDisplayed();

    }

    public void filterByMadeInTheUSA(){
        pageManager.common().scrolltoViewElement(madeInUSAFilterTab,driver);
        madeInUSAFilterTab.isDisplayed();

        madeInUSAFilterTab.click();
        pageManager.common().radioBtnIsDisplayed(yesMadeInUSACheckBox);
        yesMadeInUSACheckBox.click();
        waitTool.waitFor(driver,true);
    }

    public void VerifyPLPCountResultWasUpdatedAfterFiltered(WebElement beforeFilter, WebElement afterFilter){
        System.out.println("filter count: " + beforeFilter.getText());
        System.out.println("PLP count Result After Filter: " + afterFilter.getText());
        Assert.assertTrue(beforeFilter.getText().contains(afterFilter.getText()));
    }

    public void filterByADAApproved(){
        pageManager.common().scrolltoViewElement(adaApprovedFilterTab,driver);
        adaApprovedFilterTab.isDisplayed();
        adaApprovedFilterTab.click();
        pageManager.common().radioBtnIsDisplayed(noADAApprovedCheckBox);
        noADAApprovedCheckBox.click();
        waitTool.waitFor(driver,true);
    }

    public void filterByGSAScheduled(){
        pageManager.common().scrolltoViewElement(gsaScheduledFilterTab,driver);
        gsaScheduledFilterTab.isDisplayed();
        gsaScheduledFilterTab.click();
        pageManager.common().radioBtnIsDisplayed(yesGSAScheduledCheckBox);
        yesGSAScheduledCheckBox.click();
        waitTool.waitFor(driver,true);
    }

    public boolean waitForAllUnderSubCategoryIsDisplayed(){
        waitTool.waitForElement(driver, categoryNavigateToAllArrow);
       return categoryNavigateToAllArrow.isDisplayed();
    }


    public String getTextsubcategoryResultCountAfterFilter()
    
    {
    	waitTool.waitForElement(driver, subcategoryResultCountAfterFilter);
        pageManager.common().scrolltoViewElement(subcategoryResultCountAfterFilter, driver);
    	return subcategoryResultCountAfterFilter.getText();
    }

    public void selectClearanceFilter() {
        waitTool.waitForElement(driver,clearanceFilter);
        pageManager.common().scrolltoViewElement(pageManager.plpFilters().clearanceFilter,driver);
        pageManager.plpFilters().clearanceFilter.click();
    }



}
