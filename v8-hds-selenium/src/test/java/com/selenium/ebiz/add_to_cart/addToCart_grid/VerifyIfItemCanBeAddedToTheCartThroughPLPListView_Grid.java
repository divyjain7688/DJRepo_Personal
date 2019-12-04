/**
 * @author Bhavani
 * <p>
 * FMQA-2361 Verify if item can be added to the cart through Product Listing Page - List View
 * <p>
 * ALM Test Instance ID: 649146
 */
package com.selenium.ebiz.add_to_cart.addToCart_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class VerifyIfItemCanBeAddedToTheCartThroughPLPListView_Grid extends BaseClassV8_ParallelGrid {

    /**
     *  Verifying the add to Cart from PLP List View
     * @throws Exception
     * modified: Iuliia
     * fixe: updated getFirstProductPartNumberTEXTFromListView
     */

    @Test(dataProvider = "browsers")
    public void addtocart_VerifyItemCanBeAddedToCartFromPLPGrid
    (String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");
        pageManager.homePage().moveToSubCategoryPage();
        //pageManager.productListingPage().isDisplayedListViewButton();
        pageManager.productListingPage().clickOnListView();
        //pageManager.productListingPage().isDisplayedListView();
        String plpPartNumber = pageManager.productListingPage().getFirstProductPartNumberTEXTFromListView();
        Log.info("plpPartNumber: " + plpPartNumber);
        pageManager.productListingPage().clickonFirstProductAddToCartListView();
        pageManager.homePage().clickOnShoppingCartIcon();
        String scpProductNumber = pageManager.shoppingCartPage().getpartNumberDisplayed();
        Log.info("scpProductNumber: " + scpProductNumber);
        Assert.assertEquals(plpPartNumber, scpProductNumber);
    }
}
