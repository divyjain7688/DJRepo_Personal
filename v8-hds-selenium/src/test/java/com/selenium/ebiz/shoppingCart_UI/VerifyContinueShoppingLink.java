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

public class VerifyContinueShoppingLink extends BaseClassV8_ParallelGrid {

    /*
    designed by: Iuliia
    ALM testID: 660539
    FMQAECOMM-445
     */

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void shoppingcartUI_VerifyContinueShoppingLink(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
        String partNumber=usersList.get(0).getSearchProductPartNumber();
        pageManager.homePage().searchByKeywordOrPartNumber(partNumber);
        pageManager.productDetailsPage().addToCartPDP();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(partNumber);
        pageManager.shoppingCartPage().clickContinueShoppingBreadcrumbLink();
        Assert.assertTrue(pageManager.homePage().welcomeTextLoggedUser.isDisplayed());

    }
}
