package com.selenium.ebiz.shoppingCart_management;
/*
Designed by: Iuliia
ALM TC 657872
JIRA: FMQAECOMM-187
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

public class ValidateQuickAddToCart extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;
  
    /*
    	8/27/2019 Bhavani: Updated 2044 line in Shopping Cart Page with wait as it is failing due to unable to 
    	locate element partNumbersDisplay
    */
    @Test(dataProvider = "browsers")
    public void shopCartManagement__AddToCartAsGuestUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.homePage().isHDSupplyLogoDisplayed();
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("verifyQuickAddPartsToCart", "QuickOrder");
        String partNumber = usersList.get(0).getPartNumber1();
        Log.info("Part number: " + partNumber);
        pageManager.shoppingCartPage().addPartsToYourCart(partNumber, "1");
        Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(partNumber));

    }

    @Test(dataProvider = "browsers")
    public void shopCartManagement_AddToCartAsLoggedUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("addDifferentProductsUsingQuickOrder", "QuickOrder");
        String partNumber = usersList.get(0).getPartNumber1();
        Log.info("Part number: " + partNumber);
        pageManager.shoppingCartPage().addPartsToYourCart(partNumber, "1");
        driver.navigate().refresh();
        Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(partNumber));

    }
}
