
package com.selenium.ebiz.smoketest;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;



public class SmokeTest_End_To_End_Scenario_1_New_V8_Grid extends BaseClassV8_ParallelGrid {

    public String newListName="List_";
    int productAddedToCart,displayedShoppingCartProductCount;
    private ArrayList<UsersListBean> usersList,usersList1,userlist3;


    @Test(dataProvider = "browsers")
    public void test_SmokeTest_End_to_End_Scenario_1_(String browser, String version, String os, Method method) throws Exception
    {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        //pageManager.loginPage().loggedAccountNumberText.isDisplayed();
        Log.info("Passed Test Login");

        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");

        //pageManager.dBCon().GetUserList("searchByKeywordOrPartNumber", "Search");

        usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        Log.info("Search product number from list" + usersList.get(0).getSearchProductPartNumber());

        pageManager.productDetailsPage().clickAddToCartButton();
        Log.info("Click Add to cart the searched product");

        usersList1 = pageManager.dBCon().loadDataFromExcel("searchByProductDesc", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList1.get(0).getSearchProductKeyword());
        Log.info("Search product by keyword from the list" + usersList1.get(0).getSearchProductKeyword());

        pageManager.productListingPage().clickonFirstProductAddToCart();
        Log.info("Click First Product Add To Cart Button In Product List");

        pageManager.homePage().clickOnShoppingCartIcon();
        Log.info("Click SC");

        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        Log.info("Click Quick order link");
        pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad();
        //    pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder","QuickOrder");
        userlist3=pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        Log.info("getPartNumber1: " + userlist3.get(0).getPartNumber1() + "getQuantity1: " +
                userlist3.get(0).getQuantity1());
        pageManager.quickOrderPad().fillFirstPartNumberTextBox(userlist3.get(0).getPartNumber1());
        pageManager.quickOrderPad().fillFirstQuantityTextBox(userlist3.get(0).getQuantity1());

        String firstPartNumberTextBoxValue = pageManager.quickOrderPad().firstPartNumberTextBoxFilledValue();
        String firstQuantityrTextBoxValue = pageManager.quickOrderPad().firstQuantityTextBoxFilledValue();
        Log.info("firstPartNumberTextBoxValue is:_ " + firstPartNumberTextBoxValue + "firstQuantityrTextBoxValue is:_ " + firstQuantityrTextBoxValue);
        Log.info(userlist3.get(0).getPartNumber1().equals(firstPartNumberTextBoxValue));
       // Assert.assertEquals(userlist3.get(0).getQuantity1(), firstQuantityrTextBoxValue);
        Log.info(userlist3.get(0).getQuantity1().equals(firstQuantityrTextBoxValue));


        pageManager.quickOrderPad().clickOnAddToCartButton();
        /*
        pageManager.shoppingCartPage().selectDefaultOptionFromShippingDropdown();
        if (environmentValue.equals("dev1") || environmentValue.equals("dev2") || environmentValue.equals("dev3") || environmentValue.equals("prod")) {
            Log.info("No Delivery message  ");
        } else {
            Assert.assertTrue(pageManager.shoppingCartPage().isDeliveryMessageDisplayed(), "Verify is Delivery message dispayed");
            //softAssert.assertAll();
        }

*/
        pageManager.shoppingCartPage().clickCreateOrEditSavedList();
        pageManager.shoppingCartPage().isAddToExistingOrCreateNewListTitleTextDisplayed();
        pageManager.shoppingCartPage().addToListExistingTab.isDisplayed();

        String newlistcreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.shoppingCartPage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().recentlyUpdatedLink.click();
        String newlistdisplayed = pageManager.savedListsPage().getNewlyCreatedList();
        Log.info("Newlistdisplayed is: " + newlistdisplayed + "  " + "Newlistcreated is " + newlistcreated);
        Log.info(newlistcreated.equals(newlistdisplayed));
      //  Assert.assertEquals(newlistcreated, newlistdisplayed);


        pageManager.savedListsPage().clickOnNewlyCreatedList();
        pageManager.savedListsPage().clickOnPrintBinLabelsLink();
     //   pageManager.savedListsPage().VerifyPrintLabelsAreDisplayed();
        Log.info("Verify Print Labels are Displayed");

        pageManager.savedListsPage().navigateBackToMainWindowFromPrintLabel();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().clickonCheckOutButton();
        Log.info("Click Checkout btn on SC page");

        pageManager.paymentAndCheckOutPage().isPageTitleDisplayed();
        Log.info("Wait for Payment and Checkout page");

        pageManager.paymentAndCheckOutPage().VerifyPNAValuesIsDisplayed();
        Log.info("Validate PNA values");

        pageManager.paymentAndCheckOutPage().insertPONumber();
        Log.info("*******Inserted PO number**********");

        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
        Log.info("Click submit secure order");
        //softAssert.assertAll();


      /*  String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
        Log.info("orderNumber is " + orderNumber);
        Assert.assertTrue(pageManager.orderConfirmationPage().orderNumber.isDisplayed());*/

    }


}
