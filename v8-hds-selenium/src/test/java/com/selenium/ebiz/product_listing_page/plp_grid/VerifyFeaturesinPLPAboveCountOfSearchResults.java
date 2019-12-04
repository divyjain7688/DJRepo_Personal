package com.selenium.ebiz.product_listing_page.plp_grid;
/**
 * @author Iuliia
 * <p>
 * FMQAECOMM-126
 * <p>
 * ALM Test Instance ID: 657785
 */

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class VerifyFeaturesinPLPAboveCountOfSearchResults extends BaseClassV8_ParallelGrid {

    @Test(dataProvider = "browsers")
    public void plp_VerifyProductFilteredByMadeInUSA(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().searchByKeywordOrPartNumber("faucet");
        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.plpFilters().filterByMadeInTheUSA();
        pageManager.plpFilters().VerifyPLPCountResultWasUpdatedAfterFiltered(
                pageManager.plpFilters().yesMadeInUSACheckBoxText, pageManager.plpFilters().subcategoryResultCountAfterFilter);

    }


    @Test(dataProvider = "browsers")
    public void plp_VerifyProductFilteredByADAApproved(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().searchByKeywordOrPartNumber("faucet");
        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.plpFilters().filterByADAApproved();
        pageManager.plpFilters().VerifyPLPCountResultWasUpdatedAfterFiltered(
                pageManager.plpFilters().noADAApprovedCheckBoxText, pageManager.plpFilters().subcategoryResultCountAfterFilter);

    }

    @Test(dataProvider = "browsers")
    public void plp_VerifyProductFilteredByGSAScheduled(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().searchByKeywordOrPartNumber("faucet");
        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.plpFilters().filterByGSAScheduled();
        pageManager.plpFilters().VerifyPLPCountResultWasUpdatedAfterFiltered(
                pageManager.plpFilters().yesGSAScheduledCheckBoxText, pageManager.plpFilters().subcategoryResultCountAfterFilter);

    }

}
