package com.selenium.ebiz.shoppingCart_management;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
Designed by: Iuliia
ALM TC 659048
JIRA: FMQAECOMM-283
*/
public class VerifySubmitSecureOrderButtonsOnBillingPage extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void shopCartManagement__VerifySubmitSecureOrderButtonsOnBillingPage(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber2(), usersList.get(0).getQuantity1());
        pageManager.quickOrderPad().addToCartButton.click();
        pageManager.shoppingCartPage().clickonCheckOutButton();
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedAddPaymentAndCheckoutTitle());
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().submitSecureOrder1.isDisplayed());
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().submitSecureOrder2.isDisplayed());
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().submitSecureOrder3.isDisplayed());
    }

}


