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

public class VerifyRemovalOfShippingAddressQTYBackOrderOptionsAndDelivaryDateInShoppingCartLink extends BaseClassV8_ParallelGrid {
    /*
    designed by: Iuliia
    ALM Test ID: 660536
     */

    private ArrayList<UsersListBean> usersList;
    /*
    	8/01/2019 Bhavani: No Issues 
     */
    @Test(dataProvider = "browsers", enabled = true)
    public void shoppingcartUI_VerifyRemovalOfShippingAddressQTYBackOrderOptionsAndDelivaryDateInShoppingCartLink(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getPartNumber3());
        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        pageManager.productDetailsPage().addToCartPDP();
        String pdpPartNumber=pageManager.productDetailsPage().getDisplayedPartNumber();
        pageManager.homePage().clickOnShoppingCartIcon();
        String qtyBeforeUpdate=pageManager.shoppingCartPage().getQuantityOfAddedItemInCart();
        Log.info(qtyBeforeUpdate);
        pageManager.shoppingCartPage().enterQuantityInTheList("2",0);
        String qtyAfterUpdate=pageManager.shoppingCartPage().getQuantityOfAddedItemInCart();
        Log.info(qtyAfterUpdate);
        Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(pdpPartNumber));
        Assert.assertTrue(pageManager.shoppingCartPage().addNewAddressLink.isDisplayed());
        //Assert.assertTrue(pageManager.shoppingCartPage().isDeliveryDateTextDisplayed());
        Assert.assertNotEquals(qtyBeforeUpdate, qtyAfterUpdate);
        //pageManager.shoppingCartPage().checkClearShoppingCart();

        //Unable to locate The text related to 'Back-order Options' is displayed.


    }
}
