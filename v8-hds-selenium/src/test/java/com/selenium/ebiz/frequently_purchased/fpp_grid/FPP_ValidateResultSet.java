package com.selenium.ebiz.frequently_purchased.fpp_grid;
/*
Designed by Iuliia
ALM: 657868
 */

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FPP_ValidateResultSet extends BaseClassV8_ParallelGrid {
    String newQuoteName;

    @Test(dataProvider = "browsers", description = "Verify part information shows part # and Part image. along with the product short description")
    public void fpp_ValidateButtonsOnFPP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickFrePurchasedUtilityBar();
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedpageHeadingTextIdsplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().firstProductImage.isDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().listProductPartNumbers.get(0).isDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().listProductsShortDescription.get(0).isDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().addToListBtn.get(0).isDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().addTocartBtn.get(0).isDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().addToQuotetBtn.get(0).isDisplayed());
    }

    @Test(dataProvider = "browsers")
    //description = "Click on the part image or the part # and validate the user is navigated to the product detail page")
    public void fpp_ValidateItemInPDPAddedFromFPP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickFrePurchasedUtilityBar();
        pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedpageHeadingTextIdsplayed();
        pageManager.frequentlyPurchasedPage().firstProductImage.click();
        Assert.assertTrue(pageManager.productDetailsPage().isProductDetailsTitleDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isProductNameDisplayed());
    }

    /*
    8/23/2019 Bhavani: Updated line 142 addTocartBtn webElement property  in FrequentlyPurchasedpage
*/
    
    @Test(dataProvider = "browsers", enabled = true)
    public void fpp_VerifyAddToCartFromFPP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.homePage().clickFrePurchasedUtilityBar();
        pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedpageHeadingTextIdsplayed();
        pageManager.frequentlyPurchasedPage().addToCartFirstProduct();
        String partNumber = pageManager.frequentlyPurchasedPage().listProductPartNumbers.get(0).getText();
        Log.info("FPP First Part No.:" + partNumber);
        pageManager.homePage().clickOnShoppingCartIcon();
        Log.info("SCP Part No.: " + pageManager.shoppingCartPage().partNumbersDisplayed.get(0).getText());
        Assert.assertTrue(partNumber.contains(pageManager.shoppingCartPage().partNumbersDisplayed.get(0).getText()));
    }

    @Test(dataProvider = "browsers")

    public void fpp_VerifyAddToListFromFPP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.homePage().clickFrePurchasedUtilityBar();
        pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedpageHeadingTextIdsplayed();
        String partNumber = pageManager.frequentlyPurchasedPage().listProductPartNumbers.get(0).getText();
        Log.info(partNumber);
        pageManager.frequentlyPurchasedPage().addToListBtn.get(0).click();
        pageManager.addToExistingORCreateNewList_modal().addItemToExistingList();
        driver.navigate().refresh();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnExistingFirstSavedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(partNumber));
    }

    @Test(dataProvider = "browsers")
    public void fpp_VerifyAddToQuoteFromFPP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.homePage().clickFrePurchasedUtilityBar();
        pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedpageHeadingTextIdsplayed();
        String partNumber = pageManager.frequentlyPurchasedPage().listProductPartNumbers.get(0).getText();
        Log.info(partNumber);
        pageManager.frequentlyPurchasedPage().addToQuotetBtn.get(0).click();
        pageManager.addToExistingORCreateNewQUOTE_modal().createAndVerifyNewQuote();

    }

}
