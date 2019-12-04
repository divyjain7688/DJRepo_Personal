package com.selenium.ebiz.order_history.orderHistory_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewOrderHistory_WORKING extends BaseClassV8_Parallel {


    /**
     * US-244
     * To verify order again on homepage
     *
     * @author lakshmi
     **/

    @Test
    public void verifyOrderHistory() throws Exception {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().headerOrderAgain.isDisplayed();
        pageManager.homePage().OrderAgainContentRecommandation.isDisplayed();

        pageManager.homePage().clickOnViewOrderHistoryButton();
        Assert.assertTrue(pageManager.ordersPage().getOrderspageHeadingText().equalsIgnoreCase("Orders"));
    }
}
