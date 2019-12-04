package com.selenium.ebiz.add_to_cart.addToCart_grid;


import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author dj073227
 * To Verify if item can be added to the Cart from Product Detail Page - Prelogin
 * ALM Test Instance id 649231
 */
public class VerifyItemAddedToCartFrommPDPPrelogin_Grid extends BaseClassV8_ParallelGrid {
    String displayedPriceOnPDP, displayedPriceOnSC, displayedPartNumberOnSC;
    private ArrayList<UsersListBean> usersList;


    @Test(dataProvider = "browsers")
    public void addtocart_VerifyItemAddedToCartFrommPDPPrelogin(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
        Log.info(usersList.get(0).getSearchProductPartNumber());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());

        displayedPriceOnPDP = pageManager.productDetailsPage().getDisplayedPrice();
        //pageManager.productDetailsPage().clickAddToCartButton();
        pageManager.productDetailsPage().clickAddToCartButton();
        ;
        pageManager.homePage().clickOnShoppingCartIcon();
        displayedPartNumberOnSC = pageManager.shoppingCartPage().getDisplayedPartNumber();
        displayedPriceOnSC = pageManager.shoppingCartPage().getDisplayedPriceFromProductByInt(0);
        Assert.assertTrue(displayedPartNumberOnSC.contains(usersList.get(0).getSearchProductPartNumber()));
        Assert.assertEquals(displayedPriceOnSC, displayedPriceOnPDP);

    }

}
