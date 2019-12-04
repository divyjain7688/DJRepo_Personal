/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-120 [1]Verify Customizable part filters in Product Listing Page
 * <p>
 * ALM Test Instance ID: 649559
 */
package com.selenium.ebiz.product_listing_page.plp_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class VerifyCustomizablePartFiltersInProductListingPage extends BaseClassV8_ParallelGrid {

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
	/*
	description="Verify Customizable part filters in Product Listing Page - AuthenticatedUser",
	 */
    public void plp_VerifyCustomizablePartFiltersInProductListingPage_AuthenticatedUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        //pageManager.loginPage().loggedAccountNumberText.isDisplayed();
        Log.info("Passed Test Login");

        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");

        //usersList = pageManager.dBCon().loadDataFromExcel("searchByProductNumber","Search");
        //Log.info("Search product number from list" + usersList.get(0).getSearchProductPartNumber());
        //SearchProductPartNumber
        pageManager.homePage().searchKeywordOrPartNumber("custom sign");

        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.productListingPage().isDisplayedFirstCustomizeThisItemLinks();
        pageManager.productListingPage().clickFirstProductInProductList();

        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        pageManager.homePage().navigateBack();

        pageManager.productListingPage().isPlpHeadingTextDisplayed();
        pageManager.productListingPage().clickCompareCheckBoxes(3);
        pageManager.productListingPage().clickCompareTheseButton();
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();
        Log.info("Get all the part numbers from compare products page");
        pageManager.compareTheseItems().clickBackToSearchLink();
        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.productListingPage().isDisplayedFirstCustomizeThisItemLinks();
        pageManager.productListingPage().isFirstProductOnProductWidgetSelected();
        pageManager.productListingPage().isSecondProductOnProductWidgetSelected();
        pageManager.productListingPage().isThirdProductOnProductWidgetSelected();

        pageManager.productListingPage().clickOnListView();
        pageManager.productListingPage().isDisplayedListView();
        Assert.assertTrue(pageManager.productListingPage().isDisplayedFirstCustomizeThisItemLinks());
        Assert.assertTrue(pageManager.productListingPage().isFirstProductOnProductWidgetSelected());
        Assert.assertTrue(pageManager.productListingPage().isSecondProductOnProductWidgetSelected());
        Assert.assertTrue(pageManager.productListingPage().isThirdProductOnProductWidgetSelected());
    }

    @Test(dataProvider = "browsers")
    //description = "Verify Customizable part filters in Product Listing Page - Guest User",
    public void plp_VerifyCustomizablePartFiltersInProductListingPage_GuestUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        //usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc","Search");
        //Log.info("Search product number from list" + usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber("blinds");

        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.productListingPage().isDisplayedFirstCustomizeThisItemLinks();
        pageManager.productListingPage().clickFirstProductInProductList();

        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        pageManager.homePage().navigateBack();

        pageManager.productListingPage().plpHeadingText.isDisplayed();
        pageManager.productListingPage().clickCompareCheckBoxes(3);
        pageManager.productListingPage().clickCompareTheseButton();
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();
        Log.info("Get all the part numbers from compare products page");
        pageManager.compareTheseItems().clickBackToSearchLink();
        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.productListingPage().isDisplayedFirstCustomizeThisItemLinks();
        pageManager.productListingPage().isFirstProductOnProductWidgetSelected();
        pageManager.productListingPage().isSecondProductOnProductWidgetSelected();
        pageManager.productListingPage().isThirdProductOnProductWidgetSelected();

        pageManager.productListingPage().clickOnListView();
        pageManager.productListingPage().isDisplayedListView();
        Assert.assertTrue(pageManager.productListingPage().isDisplayedFirstCustomizeThisItemLinks());
        Assert.assertTrue(pageManager.productListingPage().isFirstProductOnProductWidgetSelected());
        Assert.assertTrue(pageManager.productListingPage().isSecondProductOnProductWidgetSelected());
        Assert.assertTrue(pageManager.productListingPage().isThirdProductOnProductWidgetSelected());
    }

}
