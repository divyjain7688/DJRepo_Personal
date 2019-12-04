package com.selenium.ebiz.frequently_purchased.fpp_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FrequentlyPurchasedPageValidateTabs_Grid extends BaseClassV8_ParallelGrid {

    /**
     * @author Bhavani
     * FMQAECOMM-251 [1]FPP_ValidateTabs
     * Test Instance Id: 657864
     */
/*
      7/29/2019 Bhavani: 
      Updated homePage 156: Subscribtions top hearder link xpath changed
     
 */
    @Test(dataProvider = "browsers", enabled = true)
    public void fpp_verifyFrequentlyPurchasedPageTabs(String browser, String version, String os, Method method) throws Exception, Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        pageManager.homePage().clickFrePurchasedUtilityBar();
        Boolean fpHeadingDisplayed = pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedPageHeadingTextDisplayed();
        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        Boolean OHSPHeadingDisplayed = pageManager.ordersPage().isDisplayedOrderspageHeading();

        pageManager.homePage().clickFrePurchasedUtilityBar();
        Boolean fpHeadingDisplayedfromOHSP = pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedPageHeadingTextDisplayed();
        pageManager.homePage().clickSavedListUtilityBar();
        Boolean SLHeadingDisplayed = pageManager.savedListsPage().isDisplayedSavedListspageHeadingText();

        pageManager.homePage().clickFrePurchasedUtilityBar();
        Boolean fpHeadingDisplayedfromSLP = pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedPageHeadingTextDisplayed();
        pageManager.homePage().clickMyAccountSubscriptionsQuickLink();
        Boolean SubscriptionPageHeadingDisplayed = pageManager.subscriptionsPage().subscriptionsPageHeadingText.isDisplayed();

        pageManager.homePage().clickFrePurchasedUtilityBar();
        Boolean fpHeadingDisplayedfromSubscriptionPage = pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedPageHeadingTextDisplayed();
        pageManager.homePage().clickQuotesUtilityBar();
        Boolean QuotesHeadingDisplayed = pageManager.quoteListsPage().isDisplayedQuotesPageHeadingText();

        pageManager.homePage().clickFrePurchasedUtilityBar();
        Boolean fpHeadingDisplayedfromQuotes = pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedPageHeadingTextDisplayed();

        Assert.assertTrue(fpHeadingDisplayed);
        Assert.assertTrue(OHSPHeadingDisplayed);
        Assert.assertTrue(fpHeadingDisplayedfromOHSP);
        Assert.assertTrue(SLHeadingDisplayed);
        Assert.assertTrue(fpHeadingDisplayedfromSLP);
        Assert.assertTrue(SubscriptionPageHeadingDisplayed);
        Assert.assertTrue(fpHeadingDisplayedfromSubscriptionPage);
        Assert.assertTrue(QuotesHeadingDisplayed);
        Assert.assertTrue(fpHeadingDisplayedfromQuotes);

    }

}


