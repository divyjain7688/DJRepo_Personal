/**
 * @author Iuliia
 * <p>
 * FMQA-2449 Verify if item can be added to the Cart through Quick Order Groupbox on Shopping Cart
 * <p>
 * ALM Test Instance ID: 649412
 */

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

public class VerifyIfItemCanBeAddedToCartThroughQuickOrderGroupboxOnShoppingCart_Grid extends BaseClassV8_ParallelGrid {

    String firstPartNumberTextBoxValue;
    private ArrayList<UsersListBean> usersList;


    @Test(dataProvider = "browsers")
    public void addtocart_VerifyPartWasAddedIntoSCFromQuickOrderPad(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Log.info(pageManager.loginPage().loggedAccountNumberText.getText());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(), usersList.get(0).getQuantity1());
        firstPartNumberTextBoxValue = pageManager.quickOrderPad().firstPartNumberTextBoxFilledValue();
        pageManager.quickOrderPad().clickOnAddToCartButton();
        String addedPart = pageManager.shoppingCartPage().partNumberDisplayed_text.getText();
        Log.info(firstPartNumberTextBoxValue + addedPart);
        Assert.assertTrue(addedPart.contains(firstPartNumberTextBoxValue));
    }


}
