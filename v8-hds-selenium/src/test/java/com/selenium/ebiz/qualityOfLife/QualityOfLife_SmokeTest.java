package com.selenium.ebiz.qualityOfLife;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;


public class QualityOfLife_SmokeTest extends BaseClassV8_ParallelGrid {

    public String newListName="List_";
    private ArrayList<UsersListBean> usersList;


    @Test(dataProvider = "browsers")
    public void qualityOfLife_smoketestOBOUser(String browser, String version, String os, Method method) throws Exception
    {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.loginPage().loginToHDSForOBOUser("qa_rep",configread.getPassword2());
        //select account
        pageManager.loginPage().clickFirstAccountForOBOUser();

        pageManager.shoppingCartPage().checkClearShoppingCartOBOUser();
        usersList=pageManager.dBCon().loadDataFromExcel("addDifferentProductsUsingQuickOrder", "QuickOrder");
        pageManager.shoppingCartPage().addPartsToYourCartAsOBOUser(usersList.get(0).getPartNumber3(),usersList.get(0).getQuantity1());
        pageManager.shoppingCartPage().clickOnQuickOrderLink();

        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(),usersList.get(0).getQuantity1());

        pageManager.common().scrolltoViewElement( pageManager.quickOrderPad().addToCartButton,driver);
        pageManager.quickOrderPad().addToCartButton.click();
       // pageManager.common().acceptPopupMessageBox(driver);
        pageManager.shoppingCartPage().clickonCheckOutButton();
        Log.info("Click Checkout btn on SC page");
        pageManager.paymentAndCheckOutPage().isPageTitleDisplayed();
        Log.info("Wait for Payment and Checkout page");
       // pageManager.paymentAndCheckOutPage().VerifyPNAValuesIsDisplayed();
        pageManager.paymentAndCheckOutPage().insertPONumber();
        Log.info("*******Inserted PO number**********");

        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
        Log.info("Click submit secure order");
        String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
        Log.info("orderNumber is "+ orderNumber);
        pageManager.orderConfirmationPage().orderNumber.click();
        pageManager.ordersHistoryDetailsPage().isDisplayedOrderHistoryDetailsTitle();
        Assert.assertTrue(pageManager.ordersHistoryDetailsPage().orderStatus.getText().contains("Submitted"));

    }


}
