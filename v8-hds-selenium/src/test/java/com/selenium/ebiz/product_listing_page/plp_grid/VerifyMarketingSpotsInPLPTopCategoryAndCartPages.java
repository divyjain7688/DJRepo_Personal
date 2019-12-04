package com.selenium.ebiz.product_listing_page.plp_grid;

/**
 * @author Iuliia
 * <p>
 * FMQAECOMM-128 : eComm Automate PLP [1]Verify Features in PLP above Count of Search Results
 * <p>
 * ALM Test Instance ID: 657785
 */

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyMarketingSpotsInPLPTopCategoryAndCartPages extends BaseClassV8_ParallelGrid {

    @Test(dataProvider = "browsers")
    public void plp_VerifyBMediaSpotDisplayedInPLP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().isGridViewDisplayed();
        Assert.assertTrue(pageManager.productListingPage().isBMediaBannerDisplayed());
    }

    @Test(dataProvider = "browsers")
    public void plp_VerifyBMediaSpotDisplayedInPDP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.productListingPage().clickFirstProductInProductList();
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
        Assert.assertTrue(pageManager.productDetailsPage().isBMediaBannerDisplayedInPDP());

    }

    @Test(dataProvider = "browsers", enabled = false)
    //as per thr response from Sandhya, this is purely Biz decision .
    //They had removed it on Prod. As the data refresh happens even on lower life cycle those will be deleted. 
    public void plp_VerifyBMediaSpotDisplayedInShoppingCartPage(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickOnShoppingCartIcon();
        Assert.assertTrue(pageManager.shoppingCartPage().isBMediaBannerDisplayedInSCP());
    }


}
