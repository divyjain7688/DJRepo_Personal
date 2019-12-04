package com.selenium.ebiz.qualityOfLife;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class QualityOfLife_PnA extends BaseClassV8_ParallelGrid {
    /*
    designed by Iuliia
    mapped with QL-64
     */

    public String newListName = "List_";
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void qualityOfLife_PnA(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList=pageManager.dBCon().loadDataFromExcel("addDifferentProductsUsingQuickOrder", "QuickOrder");
        pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getPartNumber3(),usersList.get(0).getQuantity1());
        pageManager.shoppingCartPage().clickonCheckOutButton();
        Log.info("Click Checkout btn on SC page");
        pageManager.paymentAndCheckOutPage().isPageTitleDisplayed();
        Log.info("Wait for Billing page");
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().displayedTotalValue.isDisplayed());
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().totalValue.isDisplayed());
        Log.info("PnA is successfully called because total order price is displayed");
    }
}