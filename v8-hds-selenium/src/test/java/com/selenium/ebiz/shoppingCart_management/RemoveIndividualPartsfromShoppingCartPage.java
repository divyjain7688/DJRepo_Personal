package com.selenium.ebiz.shoppingCart_management;
/**
 * @author Bhavani
 * FMQAECOMM-185 [1]Remove Individual Parts from Shopping Cart Page
 * ALM Test Instance ID: 649410
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
import java.util.List;

public class RemoveIndividualPartsfromShoppingCartPage extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;


    @Test(dataProvider = "browsers")
    public void shopCartManagement_RemoveIndividualPartsfromShoppingCartPage(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        String UserNameTemp = RandomAccountSelect.users.pop();

        pageManager.commonLogin().LoginToHDS(UserNameTemp, configread.getPassword());
        pageManager.homePage().clickOnShoppingCartIcon();

        usersList = pageManager.dBCon().loadDataFromExcel("verifyQuickAddPartsToCart", "QuickOrder");
        String partNumber = usersList.get(0).getPartNumber1();
        String qty = usersList.get(0).getQuantity2();
        Log.info("PartNum: " + partNumber + "Quantity: " + qty);
        pageManager.shoppingCartPage().checkPartsAddedToShoppingCart(partNumber, qty, UserNameTemp, configread.getPassword());

        List<String> scpPartNumBeforeRemove = pageManager.shoppingCartPage().getAllPartNumbers();
        Log.info("scpPartNumBeforeRemove: " + scpPartNumBeforeRemove);

        //pageManager.shoppingCartPage().clickFirstRemoveButton();
        pageManager.shoppingCartPage().removeAllItemShoppingCart();

        Log.info("Assert: " + pageManager.shoppingCartPage().isAddedPartsRemovedFromShoppingCart(scpPartNumBeforeRemove));
        Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartsRemovedFromShoppingCart(scpPartNumBeforeRemove));

    }
}
