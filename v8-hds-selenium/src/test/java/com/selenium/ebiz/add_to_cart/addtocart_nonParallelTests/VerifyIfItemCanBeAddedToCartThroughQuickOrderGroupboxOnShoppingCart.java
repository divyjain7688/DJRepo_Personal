/**
 *
 * @author Iuliia
 *
 *  FMQA-2449 Verify if item can be added to the Cart through Quick Order Groupbox on Shopping Cart
 *
 *  ALM Test Instance ID: 649412
 */

package com.selenium.ebiz.add_to_cart.addtocart_nonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.AccountsRandomSelectFromTextFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyIfItemCanBeAddedToCartThroughQuickOrderGroupboxOnShoppingCart extends BaseClassV8_Parallel {
 //   WebDriver driver = this.getWebDriver();

    String firstPartNumberTextBoxValue;

    @Test(description="Login")
    public void test_Login() throws IOException {

     //   LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        LoginToHDS(AccountsRandomSelectFromTextFile.users.pop(),configread.getPassword());
        Log.info(pageManager.loginPage().loggedAccountNumberText.getText());
    }

    @Test(dependsOnMethods = {"test_Login"}, description="Clear Cart")
    public void testClearCart() throws Exception {
        pageManager.shoppingCartPage().checkClearShoppingCart();
       // Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
    }

    @Test(dependsOnMethods = {"testClearCart"}, description="Quick Order page should get displayed")
    public void test_VerifyQuickOrderPadIsDisplayed() throws Exception {
        GetUserList("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        Assert.assertTrue(pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad());
    }

    @Test(dependsOnMethods = {"test_VerifyQuickOrderPadIsDisplayed"}, description="Add Product Into Quick Order Pad")
    public void test_AddProductIntoQuickOrderPad() throws Exception {
        GetUserList("addProductsUsingQuickOrder", "QuickOrder");
        Log.info("usersList getPartNumber1: " + usersList.get(0).getPartNumber1() + " usersList getQuantity1: " + usersList.get(0).getQuantity1());

        pageManager.quickOrderPad().fillFirstPartNumberTextBox(usersList.get(0).getPartNumber1());
        pageManager.quickOrderPad().fillFirstQuantityTextBox(usersList.get(0).getQuantity1());

        firstPartNumberTextBoxValue = pageManager.quickOrderPad().firstPartNumberTextBoxFilledValue();
        String firstQuantityrTextBoxValue = pageManager.quickOrderPad().firstQuantityTextBoxFilledValue();
        Log.info("firstPartNumberTextBoxValue is:_ " + firstPartNumberTextBoxValue + "firstQuantityrTextBoxValue is:_ " + firstQuantityrTextBoxValue);

        Assert.assertEquals(usersList.get(0).getPartNumber1(), firstPartNumberTextBoxValue);
        Assert.assertEquals(usersList.get(0).getQuantity1(), firstQuantityrTextBoxValue);

    }

    @Test(dependsOnMethods = {"test_AddProductIntoQuickOrderPad"}, description = "Shopping Cart page should get displayed with the item added to the cart")
    public void test_VerifyPartWasAddedIntoSC()throws Exception{
    //    pageManager.quickOrderPad().addToCartButton.click();
    	pageManager.quickOrderPad().clickOnAddToCartButton();
       // waitTool.waitForElement(driver,pageManager.shoppingCartPage().partNumberDisplayed_text);
        String addedPart = pageManager.shoppingCartPage().partNumberDisplayed_text.getText();
        Log.info(firstPartNumberTextBoxValue + addedPart);
        Assert.assertTrue(addedPart.contains(firstPartNumberTextBoxValue));
    }

    @Test(dependsOnMethods = {"test_VerifyPartWasAddedIntoSC"}, description="Logout")
    public void testLogout() throws Exception
    {
        pageManager.loginPage().logoutOfApplication();

    }


}
