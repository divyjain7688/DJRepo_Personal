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

public class VerifyMergeCartForExistingSumaUser extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void shopCartManagement__VerifyMergeCartForExistingSumaUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        String userId = RandomAccountSelect.sumausers.pop();
        pageManager.commonLogin().LogInToHDSAsSuma(userId, configread.getPassword());
        pageManager.homePage().closePropertiesPopupIfDisplayed();
        pageManager.shoppingCartPage().checkClearShoppingCart();
        String accountNumber = pageManager.homePage().getAccountNumber();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        String pnumber1 = usersList.get(0).getSearchProductPartNumber();
        pageManager.productDetailsPage().clickAddToCartButton();
        pageManager.homePage().clickOnSignOutIcon();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        String pnumber2 = usersList.get(0).getSearchProductPartNumber();
        pageManager.productDetailsPage().clickAddToCartButton();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(pnumber2);
        pageManager.shoppingCartPage().clickOnHDSupplyLogoInHeader();
        pageManager.commonLogin().LogInToHDSAsSuma(userId, configread.getPassword());
        pageManager.homePage().closePropertiesPopupAndClickCancel();
        pageManager.homePage().selectAccountNumberFromPropertiesWindow(accountNumber);
        pageManager.homePage().clickOnShoppingCartIcon();
        Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(pnumber1));
        Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(pnumber2));

    }
}