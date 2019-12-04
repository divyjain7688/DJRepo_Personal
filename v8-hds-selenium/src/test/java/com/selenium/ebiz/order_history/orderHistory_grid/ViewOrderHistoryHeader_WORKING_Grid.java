package com.selenium.ebiz.order_history.orderHistory_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ViewOrderHistoryHeader_WORKING_Grid extends BaseClassV8_ParallelGrid {


    /**
     * US-244
     * To verify order again on homepage
     *
     * @author lakshmi
     **/

    @Test(dataProvider = "browsers")
    public void orderHistory_verifyOrderHistoryHeadingText(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().isHeaderOrderAgainDisplayed();
        pageManager.homePage().OrderAgainContentRecommandation.isDisplayed();

        pageManager.homePage().clickOnViewOrderHistoryButton();
        Assert.assertTrue(pageManager.ordersPage().getOrderspageHeadingText().equalsIgnoreCase("Orders"));
    }
}
