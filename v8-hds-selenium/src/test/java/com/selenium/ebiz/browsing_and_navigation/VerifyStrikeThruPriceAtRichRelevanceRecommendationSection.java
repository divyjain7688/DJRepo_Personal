package com.selenium.ebiz.browsing_and_navigation;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class VerifyStrikeThruPriceAtRichRelevanceRecommendationSection extends BaseClassV8_ParallelGrid {

    private ArrayList<UsersListBean> usersList;

    /*
    @designed by: Iuliia
    mapped with ALM 657870
     */

    @Test(dataProvider = "browsers", enabled = false)
    public void browsingAndNavigation_VerifyStrikeThruPriceAtRichRelevanceRecommendationSection(String browser, String version, String os, Method method) throws Exception {

        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc", "Search");
        Log.info("Search product number from list" + usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        Assert.assertTrue(pageManager.productListingPage().isDisplayedRichRelevanceThroughSearch());
        pageManager.productListingPage().isStrikedPriceUnderRichRelevanceDisplayed();
    }
}
