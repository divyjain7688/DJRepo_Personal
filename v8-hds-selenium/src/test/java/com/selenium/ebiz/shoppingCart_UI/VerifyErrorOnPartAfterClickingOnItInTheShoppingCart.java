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

/**
 * @author Iuliia
 *
 * FMQAECOMM-439  eComm Automate shoppingCartUI - [1]Verify error on part after clicking on it in the Shopping Cart
 *
 * ALM Test Instance ID: 660533
 *
 * some steps from that Test Case were automated as a part of order history package
 */

public class VerifyErrorOnPartAfterClickingOnItInTheShoppingCart extends BaseClassV8_ParallelGrid {

    private String partNumberPDP;
    private ArrayList<UsersListBean> usersList;


    @Test(dataProvider = "browsers")
    public void shoppingcartUI_addPartToCartFromPDPVerifyNoError(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        partNumberPDP = usersList.get(0).getPartNumber2();
        pageManager.homePage().searchByKeywordOrPartNumber(partNumberPDP);
        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        pageManager.productDetailsPage().addToCartPDP();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(partNumberPDP);
        pageManager.shoppingCartPage().productsImages.get(0).click();
        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        Assert.assertTrue(pageManager.productDetailsPage().getDisplayedPartNumber().contains(partNumberPDP));
    }


    @Test(dataProvider = "browsers")
    public void shoppingcartUI_AddPartToCartFromPLPVerifyNoError(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByProductDesc", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().clickonFirstProductAddToCart();
        String plpPartNumber = pageManager.productListingPage().getFirstProductPartNumber();
        Log.info(plpPartNumber);
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(plpPartNumber);
        pageManager.shoppingCartPage().productsImages.get(0).click();
        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        Assert.assertTrue(pageManager.productDetailsPage().getDisplayedPartNumber().contains(plpPartNumber));
    }


}
