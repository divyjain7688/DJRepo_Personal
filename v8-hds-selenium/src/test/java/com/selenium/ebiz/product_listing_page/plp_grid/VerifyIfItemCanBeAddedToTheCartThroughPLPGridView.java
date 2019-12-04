/**
 * @author Bhavani
 * <p>
 * FMQAECOMM- Verify if item can be added to the cart through Product Listing Page - Grid View
 * <p>
 * ALM Test Instance ID: 657779
 */
package com.selenium.ebiz.product_listing_page.plp_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class VerifyIfItemCanBeAddedToTheCartThroughPLPGridView extends BaseClassV8_ParallelGrid {

    String partNoPLP, partNoSCP, scpPrice, scpTotalPrice, plpProductPrice;

    @Test(dataProvider = "browsers", enabled = false)
    //description = "Verify if item can be added to the cart through Product Listing Page - Grid View",
    public void test_VerifyIfItemCanBeAddedToTheCartThroughPLPGridView(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Log.info("Passed Test Login");
        pageManager.homePage().isDisplayedLeftNavgation();

        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");

        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().isGridViewDisplayed();

        partNoPLP = pageManager.productListingPage().getFirstProductPartNumber();
        plpProductPrice = pageManager.productListingPage().getFirstProductPriceInProductList();
        pageManager.productListingPage().clickonFirstProductAddToCart();

        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().isDisplayedShoppingCartTitle();

        partNoSCP = pageManager.shoppingCartPage().getDisplayedPartNumber();
        scpPrice = pageManager.shoppingCartPage().getProductPrice();
        //scpPrice = pageManager.shoppingCartPage().getProductPrice();
        //scpTotalPrice = Double.parseDouble(scpPrice.substring(1));

        Log.info("partNoSCP: " + partNoSCP + "  " + "partNoPLP: " + partNoPLP);
        Log.info("scpTotalPrice: " + scpPrice + "  " + "plpTotalPrice: " + plpProductPrice);

        Assert.assertEquals(partNoSCP, partNoPLP);
        Assert.assertEquals(scpPrice, plpProductPrice);

        pageManager.loginPage().logoutOfApplication();


    }

}
