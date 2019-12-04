package com.selenium.ebiz.account_management.my_account;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class ManageOrders  extends BaseClassV8_ParallelGrid {

	private ArrayList<UsersListBean> usersList;
	/*
   @designed by: Divy Jain
   mapped with: W80-8120
	 */

	@Test(dataProvider = "browsers")
	public void myAccount_verifyManageOrderProperties(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.sumausers.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();
		Assert.assertTrue(pageManager.myAccountPage().manageOrdersHeaderText.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isManageOrdersHeaderTextDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().yourPropertyText.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().accountNumberText.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().changeLink.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().verifyNavigateToYourPropertiesByClickOnChange());
	}
	
	@Test(dataProvider = "browsers")
	public void myAccount_verifyManageOrderOptions(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.sumausers.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();
		//pageManager.myAccountPage().isNavigatedToOrdersPage();
		Assert.assertTrue(pageManager.myAccountPage().isNavigatedToListPage());
		Assert.assertTrue(pageManager.myAccountPage().isNavigatedToQuotesPage());
		Assert.assertTrue(pageManager.myAccountPage().isNavigatedToFrequentlyPurchasedPage());
		Assert.assertTrue(pageManager.myAccountPage().isNavigatedToSubscriptionsPage());
		Assert.assertTrue(pageManager.myAccountPage().isNavigatedToElectronicInvoicingPage());

		
		
	}

}
