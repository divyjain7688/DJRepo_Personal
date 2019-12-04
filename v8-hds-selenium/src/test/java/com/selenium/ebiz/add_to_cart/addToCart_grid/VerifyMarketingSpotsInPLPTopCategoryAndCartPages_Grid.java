/**
 * @author Bhavani
 * <p>
 * FMQA-2363 Verify marketing Spots in PLP, Top category and cart pages
 * <p>
 * ALM Test Instance ID: 649229
 */
package com.selenium.ebiz.add_to_cart.addToCart_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class VerifyMarketingSpotsInPLPTopCategoryAndCartPages_Grid extends BaseClassV8_ParallelGrid {

    /**
     *  Verifying the add to Cart from PLP List View
     * @throws Exception
     */

    String partNum;

    @Test(dataProvider = "browsers")
    public void addtocart_VerifyAddToCartFromPLPListView(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        //Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
        pageManager.homePage().clickOnHDSupplyLogoInHeader();
        //pageManager.homePage().isDisplayedCategoryleftNavigation();
        pageManager.homePage().clickCategoryAppliancessLinkText();
        pageManager.appliances().isDisplayedAppliancesTitle();
        pageManager.appliances().clickTopCategoryWashersDryersLinkText();
        pageManager.productListingPage().clickFirstProductInProductList();
        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        partNum = pageManager.productDetailsPage().getDisplayedPartNumber();
        pageManager.productDetailsPage().clickAddToCartButton();
        pageManager.homePage().clickOnShoppingCartIcon();
        Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedProductImage());
        Assert.assertEquals(pageManager.shoppingCartPage().getDisplayedPartNumber(), partNum);
    }


}
