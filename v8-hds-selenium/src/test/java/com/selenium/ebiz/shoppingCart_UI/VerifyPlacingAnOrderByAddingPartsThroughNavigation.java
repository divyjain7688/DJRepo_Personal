package com.selenium.ebiz.shoppingCart_UI;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyPlacingAnOrderByAddingPartsThroughNavigation extends BaseClassV8_ParallelGrid {
    /*
    designed by: Iuliia
    mapped with FMQAECOMM-443, ALM Test ID: 660537
     */

    @Test(dataProvider = "browsers")
    public void shoppingcartUI_VerifyPlacingAnOrderByAddingPartsThroughNavigation(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
      //  pageManager.homePage().isDisplayedLeftNavgation();
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().isGridViewDisplayed();
        String partNoPLP = pageManager.productListingPage().getFirstProductPartNumber();
      //  String plpProductPrice = pageManager.productListingPage().getFirstProductPriceInProductList();
        pageManager.productListingPage().clickonFirstProductAddToCart();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().insertSourceCode("WLH");
        pageManager.shoppingCartPage().clickonCheckOutButton();
        pageManager.paymentAndCheckOutPage().isDisplayedAddPaymentAndCheckoutTitle();
        pageManager.paymentAndCheckOutPage().displayedTotalValue();
        pageManager.paymentAndCheckOutPage().insertPONumber();
        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder1();

    }
}
