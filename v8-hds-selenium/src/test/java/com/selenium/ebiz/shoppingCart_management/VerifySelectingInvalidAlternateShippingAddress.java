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
Designed by: Divy Jain
ALM TC 637455
JIRA: FMQAECOMM-280
 */
public class VerifySelectingInvalidAlternateShippingAddress extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers", enabled = false)
    public void shopCartManagement__VerifySelectingInvalidAlternateShippingAddress(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickAccountLinkText();
        pageManager.myAccountPage().deleteNonDefaultAddress();
        pageManager.homePage().clickOnHDSupplyLogoInHeader();
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productDetailsPage().clickAddToCartButton();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().clickOnAddNewAddressLink();
        usersList = pageManager.dBCon().loadDataFromExcel("addInvalidShippingAddress", "ShippingAddress");
        pageManager.shoppingCartPage().createInvalidAddress(usersList.get(0).getShippingAddressName(), usersList.get(0).getCompanyOrPropertyName(), usersList.get(0).getAddress(), usersList.get(0).getCity(), usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber());
        System.out.println("usersList.get(0).getShippingAddressName() " + usersList.get(0).getShippingAddressName());
        Assert.assertTrue(pageManager.shoppingCartPage().getNewlyAddValueFromShippingDropdown().equals(usersList.get(0).getShippingAddressName()));
        Assert.assertTrue(pageManager.shoppingCartPage().displayedShippingToAddress1.getText().equals(usersList.get(0).getCompanyOrPropertyName()));
        Assert.assertTrue(pageManager.shoppingCartPage().displayedShippingToAddress2.getText().equals(usersList.get(0).getAddress()));
        Assert.assertTrue(pageManager.shoppingCartPage().displayedShippingToAddress3.getText().contains(usersList.get(0).getCity()));
        Assert.assertTrue(pageManager.shoppingCartPage().displayedShippingToAddress3.getText().contains(usersList.get(0).getZipCode()));

    }
}
