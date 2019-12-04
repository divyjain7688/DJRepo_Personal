package com.selenium.ebiz.shoppingCart_management;
/*
Designed by Iuliia
ALM id: 659049
JIRA: FMQAECOMM-284
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

public class VerifyTheFunctioningOfHelpToolTipForServiceFees extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;
    /*
    	8/06/2019 Bhavani: Updated test data from 702448 to 703057 in InputData sheet.
    	Updated line 36 : Updated method as item 703057 has length increment option displayed
     */
    @Test(dataProvider = "browsers", enabled = false)
    public void shopCartManagement__VerifyTheFunctioningOfHelpToolTipForServiceFees(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
        pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getSearchProductKeyword(), "1");
        driver.navigate().refresh();
        pageManager.shoppingCartPage().clickOnCustomizeThisItemLink();
        pageManager.customizeConfigModal().customizeAndUpdateItemOnShoppingCart("Blind Size", "53", "0.25", "11", "0.50");
        pageManager.shoppingCartPage().isYouHaveCustomizeLinkDisplayed();
        pageManager.shoppingCartPage().clickShoppingCartCheckOutButton();
        driver.switchTo().alert().accept();
        pageManager.paymentAndCheckOutPage().isDisplayedAddPaymentAndCheckoutTitle();
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isServiseFeeToolTipDisplayed());
    }

}


