package com.selenium.ebiz.checkOut;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class OrderConfirmation_Grid extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers", enabled = false)
    public void checkout_ValidateLinksInOrderConfirmationPage(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        pageManager.shoppingCartPage().checkClearShoppingCart();

        usersList = pageManager.dBCon().loadDataFromExcel("verifyQuickAddPartsToCart", "QuickOrder");
        pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getPartNumber1(), usersList.get(0).getQuantity1());

        // Verify that there is a breadcrumb which would bring the user back to the shopping cart.
        pageManager.shoppingCartPage().continueShoppingBreadCrumbLink.isDisplayed();

        pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(usersList.get(0).getPartNumber1());
        // Select check out button
        pageManager.common().refresh();
        pageManager.shoppingCartPage().clickonCheckOutButton();
        pageManager.paymentAndCheckOutPage().isDisplayedAddPaymentAndCheckoutTitle();
        pageManager.paymentAndCheckOutPage().insertPONumber();
        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder1();
        Assert.assertTrue(pageManager.orderConfirmationPage().isDisplayedOrderConfirmationPageTitle());
        Assert.assertTrue(pageManager.orderConfirmationPage().isDisplayedThankYouForYourOrderText());
        Assert.assertTrue(pageManager.orderConfirmationPage().isDisplayedOrderConfirmationEmailText());
    }

}


