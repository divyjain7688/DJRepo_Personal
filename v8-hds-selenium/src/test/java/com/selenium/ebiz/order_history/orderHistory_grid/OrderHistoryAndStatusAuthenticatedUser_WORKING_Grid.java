package com.selenium.ebiz.order_history.orderHistory_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class OrderHistoryAndStatusAuthenticatedUser_WORKING_Grid extends BaseClassV8_ParallelGrid {

	/*	Breadcrumb is not updated when user click on any link from my account.
	Addressed the same to malachi in jira and waiting for confirmation.Also W80-1784 
	raised for the same issue.*/

    /**
     * US-PostOrd-003 - This test is to verify that when user navigate to order history page,
     * user should be able to see title, breadcrumb and also user should be navigate from breadcrumb.
     *
     * @throws Exception
     */
    @Test(dataProvider = "browsers")
    public void orderHistory_verifyOrderHistoryBreadcrumAndtitle(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickAccountLinkText();
        pageManager.myAccountPage().moveToOrderHistoryAndStatusPage();
        pageManager.ordersPage().isBreadcrumbDisplayed();
        pageManager.ordersPage().isDisplayedOrderspageHeading();
        pageManager.ordersPage().navigateToHomePage();
        pageManager.homePage().clickAccountLinkText();
        pageManager.myAccountPage().moveToOrderHistoryAndStatusPage();
        pageManager.ordersPage().navigateToMyAccountPage();
    }


}
