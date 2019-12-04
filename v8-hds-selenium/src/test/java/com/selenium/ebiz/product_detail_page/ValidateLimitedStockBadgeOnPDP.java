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

public class ValidateLimitedStockBadgeOnPDP extends BaseClassV8_ParallelGrid {

    /*
    designed by: Iuliia
    mapped with W80-7015
     */

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void pdp_ValidateLimitedStockBadgeOnPDP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchLimitedStockProduct", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productListingPage().clickFirstProductInProductList();
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
        Assert.assertTrue(pageManager.productDetailsPage().getDisplayedPartNumber().contains(usersList.get(0).getSearchProductPartNumber()));
        Assert.assertTrue(pageManager.productDetailsPage().limitedStock.isDisplayed());
    }
}
