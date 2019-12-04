package com.selenium.ebiz.shoppingCart_UI;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ShoppingCartUIPostLoginVerifyChangeQTYandAddToSavedListLink extends BaseClassV8_ParallelGrid {
    /*
    @designed by: Iuliia
    mapped with: FMQAECOMM-438, ALM Test ID: 660532
     */

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")

    public void shoppingcartUI_ShoppingCartUIPostLoginVerifyChangeQTYandAddToSavedListLink(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        Log.info(usersList.get(0).getSearchProductPartNumber());
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
        pageManager.productDetailsPage().enterQuantity("2");
        pageManager.productDetailsPage().addToCartPDP();
        String addedQty = pageManager.productDetailsPage().getDisplayedQuantity();
        Log.info(addedQty);
        pageManager.homePage().clickOnShoppingCartIcon();
        // pageManager.shoppingCartPage().isDisplayedShoppingCartTitle();
        String displayedQtySCP = pageManager.shoppingCartPage().getQuantityOfAddedItemInCart();
        Log.info(displayedQtySCP);
        Assert.assertEquals(addedQty, displayedQtySCP);
        Assert.assertTrue(pageManager.shoppingCartPage().addToListButton.isDisplayed());
    }

}
