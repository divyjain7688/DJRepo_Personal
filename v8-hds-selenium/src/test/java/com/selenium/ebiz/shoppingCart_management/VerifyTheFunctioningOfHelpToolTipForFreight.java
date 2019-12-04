package com.selenium.ebiz.shoppingCart_management;
/*
Designed by: Divy Jain
ALM TC 657865
JIRA: FMQAECOMM-279

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

public class VerifyTheFunctioningOfHelpToolTipForFreight extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void shopCartManagement__VerifyTheFunctioningOfHelpToolTipForFreight(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productDetailsPage().clickAddToCartButton();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(usersList.get(0).getSearchProductPartNumber());
        pageManager.shoppingCartPage().clickonCheckOutButton();
        pageManager.paymentAndCheckOutPage().isDisplayedAddPaymentAndCheckoutTitle();
        pageManager.paymentAndCheckOutPage().displayedShippingAttribute.isDisplayed();
        pageManager.paymentAndCheckOutPage().displayedShippingQuestionMarkAttribute.isDisplayed();
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isShippingToolTipMessageDisplayed());
    }


}
