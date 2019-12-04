package com.selenium.ebiz.browsing_and_navigation;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyTheRichRelevanceSectionNeedToAppearInCategoryLandingPage extends BaseClassV8_ParallelGrid {

    /*
    @designed by: Iuliia
    mapped with ALM 663258

    8/27/2019 Iuliia
     */

    @Test(dataProvider = "browsers", enabled = false)
    public void browsingAndNavigation_VerifyTheRichRelevanceSectionNeedToAppearInCategoryLandingPage(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager= new PageManager(driver);
        pageManager.homePage().movetoCategoryLandingPage();
        Assert.assertTrue(pageManager.appliances().isRichRelevanceCarouselDisplayed());
    }


}
