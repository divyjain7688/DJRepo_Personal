package com.selenium.ebiz.prerequisites_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class OrderCreationTest extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;
    private String newlistcreated, newListName;


    @Test(dataProvider = "browsers", invocationCount = 100)
    public void createOrdersWithChargeMyAccountOption(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList=pageManager.dBCon().loadDataFromExcel("addDifferentProductsUsingQuickOrder", "QuickOrder");
        pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getPartNumber5(),usersList.get(0).getQuantity1());
        pageManager.shoppingCartPage().clickOnQuickOrderLink();

        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(),usersList.get(0).getQuantity1());
        pageManager.quickOrderPad().addToCartButton.click();
        pageManager.shoppingCartPage().clickonCheckOutButton();
        Log.info("Click Checkout btn on SC page");
        pageManager.paymentAndCheckOutPage().isPageTitleDisplayed();
        Log.info("Wait for Payment and Checkout page");
        pageManager.paymentAndCheckOutPage().insertPONumber();
        Log.info("*******Inserted PO number**********");
        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
      /*  Log.info("Click submit secure order");
        String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
        Log.info("orderNumber is "+ orderNumber);*/

    }

    @Test(dataProvider = "browsers", invocationCount = 83, enabled = false)
    public void createOrdersWithCreditCard(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList=pageManager.dBCon().loadDataFromExcel("addDifferentProductsUsingQuickOrder", "QuickOrder");
        pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getPartNumber2(),usersList.get(0).getQuantity1());
        pageManager.shoppingCartPage().clickOnQuickOrderLink();

        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber3(),usersList.get(0).getQuantity1());
        pageManager.quickOrderPad().addToCartButton.click();
        pageManager.shoppingCartPage().clickonCheckOutButton();
        Log.info("Click Checkout btn on SC page");
        pageManager.paymentAndCheckOutPage().isPageTitleDisplayed();
        Log.info("Wait for Payment and Checkout page");
        pageManager.paymentAndCheckOutPage().enterCCDetailsInAddPaymentAndCheckoutPage();
        String pONumber = pageManager.paymentAndCheckOutPage().insertPONumber();
        Log.info("*******Inserted PO number**********");
        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
      /*  Log.info("Click submit secure order");
        String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
        Log.info("orderNumber is "+ orderNumber);*/

    }
}