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

public class ValidateLimitedStockBadgeOnPLPCategorySearch extends BaseClassV8_ParallelGrid {
     /*
    designed by: Iuliia
    mapped with /W80-7018
     */

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void plp_ValidateLimitedStockBadgeOnPLPGridView(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchLimitedStockProduct", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productListingPage().isGridViewDisplayed();
        Assert.assertTrue(pageManager.productListingPage().getFirstProductPartNumber().contains(usersList.get(0).getSearchProductPartNumber()));
        Assert.assertTrue(pageManager.productListingPage().limitedStockBadge.isDisplayed());
    }

    @Test(dataProvider = "browsers")
    public void plp_ValidateLimitedStockBadgeOnPLPListView(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchLimitedStockProduct", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().clickOnListView();
        pageManager.productListingPage().isDisplayedListView();
        Assert.assertTrue(pageManager.productListingPage().getFirstProductPartNumberListView().contains(usersList.get(0).getSearchProductKeyword()));
        Assert.assertTrue(pageManager.productListingPage().limitedStockBadge.isDisplayed());
    }
}
