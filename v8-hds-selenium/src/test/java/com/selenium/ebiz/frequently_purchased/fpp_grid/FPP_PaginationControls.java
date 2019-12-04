package com.selenium.ebiz.frequently_purchased.fpp_grid;
/*
Designed by: Iuliia
ALM: 657867
FMQAECOMM-253
eComm Automate FPP_PaginationControls
 */

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FPP_PaginationControls extends BaseClassV8_ParallelGrid {

    @Test(dataProvider = "browsers")
    public void fpp_ValidateFilterPageResultsOnFPP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickFrePurchasedUtilityBar();
        pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedpageHeadingTextIdsplayed();
        int allPoductsSize = pageManager.frequentlyPurchasedPage().allProducts.size();
        Log.info(allPoductsSize);
        String filterValueBeforeFilter = pageManager.frequentlyPurchasedPage().displayedHeaderPaging.getText();
        String productDescriptionBeforeSort = pageManager.frequentlyPurchasedPage().listProductsShortDescription.get(0).getText();
        Log.info("filterValueBeforeFilter: " + filterValueBeforeFilter);
        Log.info("beforeSort: " + productDescriptionBeforeSort);
        pageManager.frequentlyPurchasedPage().activeStatusFilter.click();
        pageManager.frequentlyPurchasedPage().getSortByDropdown();
        pageManager.frequentlyPurchasedPage().isSortByQuantityValue();
        String filterValueAfterFilter = pageManager.frequentlyPurchasedPage().displayedHeaderPaging.getText();
        String productDescriptionAfterSort = pageManager.frequentlyPurchasedPage().listProductsShortDescription.get(0).getText();
        int allPoductsSizeAfterFilters = pageManager.frequentlyPurchasedPage().allProducts.size();
        Log.info("allPoductsQtyAfterFilters: " + allPoductsSizeAfterFilters);
        Log.info("afterSort:" + productDescriptionAfterSort);
        Assert.assertEquals(filterValueBeforeFilter, filterValueAfterFilter, "Validate the record count displays accord to filter");
        Assert.assertEquals(allPoductsSize, allPoductsSizeAfterFilters, "Validate the product count/page is 24");
        //Assert.assertEquals(productDescriptionBeforeSort,productDescriptionAfterSort);
    }


    @Test(dataProvider = "browsers")
    /*
    Test is only valid when: a user has more than 50 entries (more than 2 pages when the Results Per Page is set to 24.)
     */
    /*
    8/21/2019: updated navigationToNextAndPreviousPage method with the condition to check if products q-ty are equal on both pages
     */
    public void fpp_VerifyPaginationControlsArrows(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickFrePurchasedUtilityBar();
        pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedpageHeadingTextIdsplayed();
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().navigationToNextAndPreviousPage());

    }

    @Test(dataProvider = "browsers")
    public void fpp_BrowserBackFromFPP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickFrePurchasedUtilityBar();
        pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedpageHeadingTextIdsplayed();
        driver.navigate().back();
        pageManager.loginPage().welcomeText.isDisplayed();
    }
}
