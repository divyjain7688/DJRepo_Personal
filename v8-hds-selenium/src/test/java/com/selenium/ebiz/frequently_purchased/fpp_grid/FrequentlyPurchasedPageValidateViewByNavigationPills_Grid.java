package com.selenium.ebiz.frequently_purchased.fpp_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FrequentlyPurchasedPageValidateViewByNavigationPills_Grid extends BaseClassV8_ParallelGrid {

    /**
     * @author Bhavani
     * FMQAECOMM-250 [1]FPP_ValidateViewBy_NavigationPills
     * Test Instance Id: 657863
     */

    @Test(description = "Validate View By Navigation Pills", dataProvider = "browsers")
    public void fpp_ValidateViewByNavigationPills(String browser, String version, String os, Method method) throws Exception, Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        pageManager.homePage().clickFrePurchasedUtilityBar();

        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedPageHeadingTextDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isPaginationformatdisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isDisplayedOverThePastDropDown());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isDisplayedSortByDropDown());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isSortByFrequencyValue());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isSortByQuantityValue());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isSortByTotalSpentValue());
    }


}


