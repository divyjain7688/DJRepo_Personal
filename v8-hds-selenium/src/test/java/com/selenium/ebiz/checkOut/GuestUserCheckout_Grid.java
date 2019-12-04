package com.selenium.ebiz.checkOut;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class GuestUserCheckout_Grid extends BaseClassV8_ParallelGrid {

    /**
     * Author : Sandhya
     * Unauthenticated User Sign In for Checkout
     * <p>
     * US-Acct-570
     * <p>
     * Modified by Bhavani, Iuliia
     */

    @Test(description = "Add Product From PLP, signin and checkout", dataProvider = "browsers", enabled = false)
    public void checkout_SignInAddProductIntoShoppingCart(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().clickonFirstProductAddToCart();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().shoppingCartPageHeadingText.isDisplayed();
        pageManager.shoppingCartPage().clickShoppingCartCheckOutButtonAsGuestUser();
        pageManager.signInOrRegisterPage().signInOrRegisterTitle.isDisplayed();
        pageManager.commonLogin().signIn(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().shoppingCartPageHeadingText.isDisplayed();
        pageManager.shoppingCartPage().clickShoppingCartCheckOutButton();
        pageManager.paymentAndCheckOutPage().isDisplayedAddPaymentAndCheckoutTitle();
        pageManager.paymentAndCheckOutPage().insertPONumber();
        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
        //	Assert.assertTrue(pageManager.orderConfirmationPage().orderNumber.isDisplayed());

    }

}