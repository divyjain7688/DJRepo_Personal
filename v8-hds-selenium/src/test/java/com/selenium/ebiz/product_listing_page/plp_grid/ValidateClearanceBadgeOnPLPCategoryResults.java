package com.selenium.ebiz.product_listing_page.plp_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ValidateClearanceBadgeOnPLPCategoryResults extends BaseClassV8_ParallelGrid {

    /*
    designed by: Iuliia
    mapped with: W80-6989/ FMQAECOMM-940
     */

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void plp_ValidateClearanceBadgeOnPLPCategoryResultsLoggedUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().searchKeywordOrPartNumber("decorative top sheets");
        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.plpFilters().selectClearanceFilter();
        pageManager.plpFilters().clearanceYesCheckBox.click();
        Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
        Assert.assertTrue(pageManager.productListingPage().listClearanceBadges.get(0).isDisplayed());
       // Assert.assertTrue(pageManager.productListingPage().listClearanceBadges.get(1).isDisplayed());
    }



    @Test(dataProvider = "browsers")
    public void plp_ValidateClearanceBadgeOnPLPCategoryResultsGuestUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.homePage().searchKeywordOrPartNumber("decorative top sheet");
        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.plpFilters().selectClearanceFilter();
        pageManager.plpFilters().clearanceYesCheckBox.click();
        Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
        Assert.assertTrue(pageManager.productListingPage().listClearanceBadges.get(0).isDisplayed());
       // Assert.assertTrue(pageManager.productListingPage().listClearanceBadges.get(1).isDisplayed());
    }



}
