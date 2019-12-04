package com.selenium.ebiz.shoppingCart_management;
/**
 * @author Bhavani
 * FMQAECOMM-186 [1]Quick Order - not visible_79432 - Discontinued
 * ALM Test Instance ID: 657862
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

public class QuickOrderNotVisible79432Discontinued extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;
    String expectedErrorMessage = "Error:The product you have selected cannot be purchased at this time.";
    /*
      7/29/2019 Bhavani: 
      Updated shoppingCartPage 197: partNumberEdit xpath changed
      Updated productListingPage 300: alertMessageBox xpath changed
      Updated test data in InputExcel sheet
    */

    @Test(dataProvider = "browsers",enabled=true)
    public void shopCartManagement_QuickOrderNotVisible79432DiscontinuedGuestUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        usersList = pageManager.dBCon().loadDataFromExcel("discontinuedPart", "Search");
        Log.info(usersList.get(0).getSearchProductPartNumber());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());

        Boolean actualAlert = pageManager.productListingPage().isDisplayedAlertMessageBox();

        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().isDisplayedShoppingCartTitle();

        usersList = pageManager.dBCon().loadDataFromExcel("discontinuedPart", "QuickOrder");
        String partNumber = usersList.get(0).getPartNumber1();
        String qty = usersList.get(0).getQuantity1();
        Log.info("PartNum: " + partNumber + "Quantity: " + qty);

        pageManager.shoppingCartPage().addDiscontinuedPartsToYourCart(partNumber, qty);
        String actualErrorMessage = pageManager.shoppingCartPage().getErrorMessageText();

        pageManager.shoppingCartPage().clickPopupCloseButton();

        Assert.assertTrue(actualAlert);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test(dataProvider = "browsers",enabled=true)
    public void shopCartManagement_QuickOrderNotVisible79432DiscontinuedLoggedInUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");

        usersList = pageManager.dBCon().loadDataFromExcel("discontinuedPart", "Search");
        Log.info(usersList.get(0).getSearchProductPartNumber());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());

        Boolean actualAlert = pageManager.productListingPage().isDisplayedAlertMessageBox();

        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().isDisplayedShoppingCartTitle();

        usersList = pageManager.dBCon().loadDataFromExcel("discontinuedPart", "QuickOrder");
        String partNumber = usersList.get(0).getPartNumber1();
        String qty = usersList.get(0).getQuantity1();
        Log.info("PartNum: " + partNumber + "Quantity: " + qty);

        pageManager.shoppingCartPage().addDiscontinuedPartsToYourCart(partNumber, qty);
        String actualErrorMessage = pageManager.shoppingCartPage().getErrorMessageText();

        pageManager.shoppingCartPage().clickPopupCloseButton();

        Assert.assertTrue(actualAlert);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        //	pageManager.shoppingCartPage().refresh();
        //	pageManager.loginPage().logoutOfApplication();
    }
}
