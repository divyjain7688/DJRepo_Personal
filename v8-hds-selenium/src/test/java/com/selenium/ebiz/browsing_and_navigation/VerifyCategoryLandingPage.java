package com.selenium.ebiz.browsing_and_navigation;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class VerifyCategoryLandingPage extends BaseClassV8_ParallelGrid {

    public PageManager getPageManager(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        return new PageManager(driver);
    }
    /*
    @designed by: Iuliia
    mapped with ALM 657871
     */

    private ArrayList<UsersListBean> usersList;
    @Test(dataProvider = "browsers")
    public void browserAndNavigation_VerifyCategoryLandingPage(String browser, String version, String os, Method method) throws Exception {

        PageManager pageManager = getPageManager(browser, version, os, method);
    //    pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().movetoCategoryLandingPage();
        Assert.assertTrue(pageManager.appliances().isContentCarouselSubCategoriesDisplayed());
        Assert.assertTrue(pageManager.appliances().iSeSpotCategoryImageDisplayed());
        Assert.assertTrue(pageManager.appliances().isRichRelevBannerDisplayed());
    }

    @Test(dataProvider = "browsers")
    public void browserAndNavigation_NavigateEachSubCategoryFromCategoryLandPage(String browser, String version, String os, Method method) throws Exception {

        PageManager pageManager = getPageManager(browser, version, os, method);
        pageManager.homePage().movetoCategoryLandingPage();
        pageManager.appliances().clickEachSubCategoryOnLandingPage();

    }




}
