package com.selenium.ebiz.order_history.orderHistory_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Iuliia
 * <p>
 * FMQAEcomm-52 Verify Order History Summary And Detail
 * <p>
 * ALM Test Instance ID: 649357
 */

public class ViewOrderHistorySummaryAndDetail extends BaseClassV8_Parallel {
    private String orderNumberOrderPage, poNumberOrderPage, statusOrderPage;

    @Test
    public void orderHistory_VerifyOrderHistoryDetailPageWillDisplaySelectedOrderDetails() throws Exception {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        //pageManager.loginPage().loggedAccountNumberText.isDisplayed();
        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        pageManager.ordersPage().isDisplayedOrderspageHeading();
        orderNumberOrderPage = pageManager.ordersPage().orderNumbers.get(0).getText();
        poNumberOrderPage = pageManager.ordersPage().poNumbers.get(0).getText();
        statusOrderPage = pageManager.ordersPage().statuses.get(0).getText();
        pageManager.ordersPage().clickOnFirstOrderNumberInOrdersPage();
        pageManager.ordersHistoryDetailsPage().isDisplayedOrderHistoryDetailsTitle();
        Assert.assertTrue(pageManager.ordersHistoryDetailsPage().orderNumber.getText().contains(orderNumberOrderPage));
        Assert.assertTrue(pageManager.ordersHistoryDetailsPage().poNumber.getText().contains(poNumberOrderPage));
        Assert.assertTrue(pageManager.ordersHistoryDetailsPage().orderStatus.getText().contains(statusOrderPage));
    }
}
