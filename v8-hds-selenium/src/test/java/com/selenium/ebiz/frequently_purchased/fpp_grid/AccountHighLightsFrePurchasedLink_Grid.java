package com.selenium.ebiz.frequently_purchased.fpp_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AccountHighLightsFrePurchasedLink_Grid extends BaseClassV8_ParallelGrid {

    /**
     * @throws Exception UserStory : US-238
     *                   To verify when clicked on FrequentlyPurchased link from the account highlights, User should be taken to Frequently Purchased page
     * @throws
     * @author Bhavani
     */

    @Test(description = "Verify Frequently Purchased Link", dataProvider = "browsers", enabled = false)
    public void fpp_accountHighLightsFrePurchasedLink(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        Log.info("Click on Frequently Purchased Link");
        pageManager.homePage().clickFrePurchasedUtilityBar();
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().getFrequentlyPurchasedpageHeadingText().equalsIgnoreCase("FREQUENTLY PURCHASED"));
    }

}
