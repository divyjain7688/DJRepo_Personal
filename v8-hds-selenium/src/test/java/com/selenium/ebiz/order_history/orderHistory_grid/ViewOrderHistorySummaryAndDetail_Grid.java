package com.selenium.ebiz.order_history.orderHistory_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author Iuliia
 * <p>
 * FMQAEcomm-52 Verify Order History Summary And Detail
 * <p>
 * ALM Test Instance ID: 649357
 */

public class ViewOrderHistorySummaryAndDetail_Grid extends BaseClassV8_ParallelGrid {
    private String orderNumberOrderPage, poNumberOrderPage, statusOrderPage;

    @Test(dataProvider = "browsers")
    public void test_VerifyOrderHistoryDetailPageWillDisplaySelectedOrderDetails
            (String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
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
