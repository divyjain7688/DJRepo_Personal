/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-3 : Order History - Order History Summary - Verify Order History Summary page displays correct total
 * <p>
 * ALM Test Instance ID: 649213
 */
package com.selenium.ebiz.order_history.orderHistory_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class VerifyOrderHistorySummaryPageDisplaysCorrectTotal_Grid extends BaseClassV8_ParallelGrid {

    private ArrayList<UsersListBean> usersList;
    String orderNumber, totalFromPaymentAndCheckoutPage, sumofSubTotalAndTax, totalFromOHDP;
    
    @Test(description = "Verify Order History Summary page displays correct total", dataProvider = "browsers", enabled = true)
    public void orderHistory_VerifyOrderHistorySummaryPageDisplaysCorrectTotal(String browser, String version, String os, Method method) throws Exception {

        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Log.info("Passed Test Login");

        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");
        pageManager.shoppingCartPage().isDisplayedShoppingCartTitle();

        usersList = pageManager.dBCon().loadDataFromExcel("partNumberHandlingFee", "QuickOrder");
        pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getPartNumber1(), usersList.get(0).getQuantity1());

        pageManager.shoppingCartPage().clickOnCheckOutButton();
        Log.info("Clicked Checkout btn on SC page");
        
        pageManager.paymentAndCheckOutPage().VerifyPNAValuesIsDisplayed();
        totalFromPaymentAndCheckoutPage = pageManager.paymentAndCheckOutPage().displayedTotalValue();
        Log.info("totalFromPaymentAndCheckoutPage: " + totalFromPaymentAndCheckoutPage);
        Log.info("Handling Fee: " + pageManager.paymentAndCheckOutPage().getHandlingFeeText());
        sumofSubTotalAndTax = pageManager.paymentAndCheckOutPage().sumOfSubTotalAndTax();
        Log.info("sumofSubTotalAndTax: " + sumofSubTotalAndTax);
        Boolean handlingFee = pageManager.paymentAndCheckOutPage().isDisplayedHandlingFeeText();
        pageManager.paymentAndCheckOutPage().insertPONumber();
        Log.info("*******Inserted PO number**********");
       
        String EnvValue = getEnvValue();
		System.out.println("EnvValue: " + EnvValue );
		orderNumber = pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder(EnvValue);
		/*Log.info("Clicked submit secure order button");
		Log.info(pageManager.orderConfirmationPage().storeOrderNumber());
		orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
		pageManager.orderConfirmationPage().isDisplayedOrderConfirmationPageTitle();*/

        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        pageManager.ordersPage().isDisplayedOrderspageHeading();

        pageManager.ordersPage().clickOnCreatedOrderNumberInOrdersPage(orderNumber);
        pageManager.ordersHistoryDetailsPage().isDisplayedTotalValue();
        totalFromOHDP = pageManager.ordersHistoryDetailsPage().getTotalValue().substring(1);
        Log.info("SumofSubTotalAndTax: " + sumofSubTotalAndTax + "     " + "totalFromOHDP: " + totalFromOHDP);
        
        Assert.assertEquals(totalFromOHDP, sumofSubTotalAndTax);
        Assert.assertTrue(handlingFee);

        pageManager.loginPage().logoutOfApplication();

    }
}
