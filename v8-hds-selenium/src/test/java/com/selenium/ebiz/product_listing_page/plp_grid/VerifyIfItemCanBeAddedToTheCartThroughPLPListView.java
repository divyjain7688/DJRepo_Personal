/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-124 Verify if item can be added to the cart through Product Listing Page - List View
 * <p>
 * ALM Test Instance ID: 657778
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


public class VerifyIfItemCanBeAddedToTheCartThroughPLPListView extends BaseClassV8_ParallelGrid {

    private ArrayList<UsersListBean> usersList;
    String plpTotalPrice;
    String partNoPLP, partNoSCP, scpPrice;
    /*
    8/05/2019 Bhavani: No Issues Noticed 
    */
    /**
     * 8/11/2019
	 * Fixed by Bino Jayasingh
	 * Mapped with W80-9406
	 * Fixed the issue related to assertion failure of product price.
	 * enabling the test for execution
	 */
    @Test(dataProvider = "browsers")
    public void plp_VerifyIfItemCanBeAddedToTheCartThroughPLPListView(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Log.info("Passed Test Login");
        //pageManager.homePage().isDisplayedLeftNavgation();

        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");

        pageManager.homePage().moveToSubCategoryPage();
        //pageManager.productListingPage().isGridViewDisplayed();

        pageManager.productListingPage().clickOnListView();
        //pageManager.productListingPage().productListingPageListView.isDisplayed();

        partNoPLP = pageManager.productListingPage().getFirstProductPartNumberListView();

        usersList = pageManager.dBCon().loadDataFromExcel("verifySearchResultsListViewLoggedInUser", "QuickOrder");
        Log.info("usersList.get(0).getQuantity1(): " + usersList.get(0).getQuantity1());
        pageManager.productListingPage().enterPLPListViewProductQuantity(usersList.get(0).getQuantity1());
        plpTotalPrice = pageManager.productListingPage().getFirstProductPriceInProductList();
        pageManager.productListingPage().addToCartAndNavigateToSCP(0);

        //	pageManager.homePage().clickOnShoppingCartIcon();
        //	pageManager.shoppingCartPage().isDisplayedShoppingCartTitle();
        partNoSCP = pageManager.shoppingCartPage().getDisplayedPartNumber();
        scpPrice = pageManager.shoppingCartPage().getEachProductPrice();

        Log.info("partNoSCP: " + partNoSCP + "  " + "partNoPLP: " + partNoPLP);
        Assert.assertEquals(partNoSCP, partNoPLP);

        Log.info("scpTotalPrice: " + scpPrice + "  " + "plpTotalPrice: " + plpTotalPrice);
        Assert.assertEquals(scpPrice, plpTotalPrice);

    }

}
