package com.selenium.ebiz.product_detail_page;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ValidateClearanceBadgeOnPLPSearchResults extends BaseClassV8_ParallelGrid {
    /*
    designed by: Iuliia
    mapped with W80-6987/W80-6993
     */

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void pdp_ValidateClearanceBadgeOnPLPSearchResultsLoggedUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchClearanceProduct", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().clickFirstProductInProductList();
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
        Assert.assertTrue(pageManager.productDetailsPage().clearanceBadge.isDisplayed());
    }

    @Test(dataProvider = "browsers")
    public void pdp_ValidateClearanceBadgeOnPLPSearchResultsGuestUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        usersList = pageManager.dBCon().loadDataFromExcel("searchClearanceProduct", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        Log.info(usersList.get(0).getSearchProductPartNumber());
        pageManager.productListingPage().clickFirstProductInProductList();
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
        Assert.assertTrue(pageManager.productDetailsPage().clearanceBadge.isDisplayed());
    }

}
