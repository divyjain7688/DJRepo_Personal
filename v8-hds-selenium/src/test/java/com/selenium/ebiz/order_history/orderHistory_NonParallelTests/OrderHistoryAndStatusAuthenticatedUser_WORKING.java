package com.selenium.ebiz.order_history.orderHistory_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.annotations.Test;

public class OrderHistoryAndStatusAuthenticatedUser_WORKING extends BaseClassV8_Parallel {

	/*	Breadcrumb is not updated when user click on any link from my account.
	Addressed the same to malachi in jira and waiting for confirmation.Also W80-1784 
	raised for the same issue.*/

    /**
     * US-PostOrd-003 - This test is to verify that when user navigate to order history page,
     * user should be able to see title, breadcrumb and also user should be navigate from breadcrumb.
     *
     * @throws Exception
     */
    @Test
    public void verifyOrderHistoryBreadcrumAndtitle() throws Exception {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
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
