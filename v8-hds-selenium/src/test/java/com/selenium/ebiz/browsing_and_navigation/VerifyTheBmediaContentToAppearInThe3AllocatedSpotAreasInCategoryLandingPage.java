package com.selenium.ebiz.browsing_and_navigation;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyTheBmediaContentToAppearInThe3AllocatedSpotAreasInCategoryLandingPage extends BaseClassV8_ParallelGrid {

   /*
    @designed by: Iuliia
    mapped with ALM 663259
     */

    @Test(dataProvider = "browsers")
    public void browsingAndNavigation_VerifyTheBmediaContentToAppearInThe3AllocatedSpotAreasInCategoryLandingPage(String browser, String version, String os, Method method) throws Exception {

        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.homePage().movetoCategoryLandingPage();
        Assert.assertTrue(pageManager.appliances().iSeSpotCategoryImageDisplayed());
        Assert.assertTrue(pageManager.appliances().isRichRelevBannerDisplayed());
    }
}
