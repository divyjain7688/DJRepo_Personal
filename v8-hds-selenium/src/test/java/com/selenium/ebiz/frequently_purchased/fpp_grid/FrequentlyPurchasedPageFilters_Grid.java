package com.selenium.ebiz.frequently_purchased.fpp_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class FrequentlyPurchasedPageFilters_Grid extends BaseClassV8_ParallelGrid {

    ArrayList<String> optionsText = new ArrayList<String>();
    String displayedFilterValue1, displayedFilterValue2, displayedFilterValue3, displayedFilterValue4, displayedFilterValue5;

    /**
     * This test is used to verify that when user logged in and click on my account link,
     * user should able to navigate to My account page.
     */


    /**
     * Modified by Bhavani
     * US-PostOrd-072 - This method is used to test that logged in user has ability to filter which products
     * on the frequently purchased page I want to view.
     */

    @Test(description = "Verify Frequently PurchasedPage Filters", dataProvider = "browsers")
    public void fpp_verifyFrequentlyPurchasedPageFilters(String browser, String version, String os, Method method) throws Exception, Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickFrePurchasedUtilityBar();
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isStatusFilterDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isCategoryFilterDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isSubcategoryFilterDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isBrandFilterDisplayed());
    }
    //enabled is false due to issue in stage 
    @Test(description = "Verify Frequently PurchasedPage Filters Values", dataProvider = "browsers",enabled=false)
    public void fpp_verifyFrequentlyPurchasedPageFiltersValues(String browser, String version, String os, Method method) throws Exception, Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickFrePurchasedUtilityBar();
        String statusFilterActiveValue = pageManager.frequentlyPurchasedPage().statusFilterActiveValue();
        displayedFilterValue1 = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        System.out.println("displayedFilterValue1 is "+ displayedFilterValue1 + "and statusFilterActiveValue is "+ statusFilterActiveValue);
        
        String eligibleForSbscriptionsFilterFirstValue = pageManager.frequentlyPurchasedPage().getTextAndclickOnEligibleForSbscriptionsFilterFirstValueCheckBox();
        displayedFilterValue2 = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        pageManager.frequentlyPurchasedPage().clickOnEligibleForSbscriptionsFilterFirstValueCheckBox();
        
        String brandFilterFirstValue = pageManager.frequentlyPurchasedPage().getTextAndclickOnBrandFilterFirstValueCheckBox();
        displayedFilterValue3 = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        pageManager.frequentlyPurchasedPage().clickOnBrandFilterFirstValueCheckBox();
        
       String categoryFilterFirstValue = pageManager.frequentlyPurchasedPage().getTextAndclickOnCategoryFilterFirstValueCheckBox();
        displayedFilterValue4 = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        pageManager.frequentlyPurchasedPage().clickOnCategoryFilterFirstValueCheckBox();
        
        String subcategoryFilterFirstValue = pageManager.frequentlyPurchasedPage().getTextAndclickOnSubcategoryFilterFirstValueCheckBox();
        displayedFilterValue5 = pageManager.frequentlyPurchasedPage().displayedFilterValue();

        Log.info("filter values are" + displayedFilterValue1 + displayedFilterValue2 + displayedFilterValue3 + displayedFilterValue4 + displayedFilterValue5);
        Log.info(statusFilterActiveValue + eligibleForSbscriptionsFilterFirstValue + brandFilterFirstValue + categoryFilterFirstValue + subcategoryFilterFirstValue);
        Assert.assertTrue(statusFilterActiveValue.contains(displayedFilterValue1));
        Assert.assertTrue(eligibleForSbscriptionsFilterFirstValue.contains(displayedFilterValue2));
        Assert.assertTrue(brandFilterFirstValue.contains(displayedFilterValue3));
        Assert.assertTrue(categoryFilterFirstValue.contains(displayedFilterValue4));
        Assert.assertTrue(subcategoryFilterFirstValue.contains(displayedFilterValue5));
    }

}


