package com.selenium.ebiz.shoppingCart_management;

/*
Designed by: Iuliia
ALM TC 657873
JIRA: FMQAECOMM-188

8/27/2019 - Iuliia: added pageManager.common().scrolltoViewElement(addButton,driver) into quickOrderPad().fillFirstPartAndQuantityQuickOrderPad
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

public class VerifySystemDisplaysDefaultShippingToAddressEvenWhenThereIsAlternativeAddress extends BaseClassV8_ParallelGrid {

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers", enabled=false)
    public void shopCartManagement_VerifySystemDisplaysDefaultShippingToAddressEvenWhenThereIsAlternativeAddress(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickAccountLinkText();
        usersList = pageManager.dBCon().loadDataFromExcel("addNewShippingAddress", "ShippingAddress");
        pageManager.myAccountPage().fillOutNewShippingAddress(usersList.get(0).getShippingAddressName(), usersList.get(0).getCompanyOrPropertyName(), usersList.get(0).getAddress(), usersList.get(0).getCity(), usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber());
        pageManager.homePage().clickAccountLinkText();
        String accountDefaultShippingAddressLineOne = pageManager.myAccountPage().getShippingAddressLine2Text();
        String accountDefaultShippingAddressLineTwo = pageManager.myAccountPage().getShippingAddressLine3Text();
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(), usersList.get(0).getQuantity1());
        pageManager.quickOrderPad().addToCartButton.click();
        //pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(usersList.get(0).getPartNumber1());
        //pageManager.shoppingCartPage().isDisplayedShippingAddressText();
        String scpDefaultShippingAddressLineOne = pageManager.shoppingCartPage().getShippingAddressLine3Text();
        String scpDefaultShippingAddressLineTwo = pageManager.shoppingCartPage().getShippingAddressLine2Text();
        Log.info(scpDefaultShippingAddressLineTwo);
        Log.info(accountDefaultShippingAddressLineOne);
        Assert.assertTrue(scpDefaultShippingAddressLineTwo.contains(accountDefaultShippingAddressLineOne));
        Assert.assertTrue(accountDefaultShippingAddressLineTwo.contains(scpDefaultShippingAddressLineOne));

    }

}
