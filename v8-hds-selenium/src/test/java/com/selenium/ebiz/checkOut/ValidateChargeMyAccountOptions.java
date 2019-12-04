package com.selenium.ebiz.checkOut;
/*
 @designed by: Iuliia
 https://hdsdigital.atlassian.net/browse/W80-4421: CheckOut: Validate Charge My Account option
 */

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ValidateChargeMyAccountOptions extends BaseClassV8_ParallelGrid {

    private ArrayList<UsersListBean> usersList;
    /*
    8/6/2019 Updated addPartsToYourCart with getPartNumber1(). Previous part number was out of stock.
     */

    @Test(dataProvider = "browsers")
    public void checkout_VerifyChargeMyAccountAndCreditCardOptionsOnBillingPage(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("addDifferentProductsUsingQuickOrder", "QuickOrder");
        pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getPartNumber1(), usersList.get(0).getQuantity1());
        Log.info(usersList.get(0).getPartNumber1() +  usersList.get(0).getQuantity1());
        driver.navigate().refresh();
        pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(usersList.get(0).getPartNumber1());
        pageManager.shoppingCartPage().clickShoppingCartCheckOutButton();
        pageManager.paymentAndCheckOutPage().isDisplayedAddPaymentAndCheckoutTitle();
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isChargeMyHDSupplyAccountIsDisplayed());
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedRadioButtonForChargeMyCreditCard());

        ///div[contains(text(),'Charge my HD Supply Account')]/../span


    }
}
