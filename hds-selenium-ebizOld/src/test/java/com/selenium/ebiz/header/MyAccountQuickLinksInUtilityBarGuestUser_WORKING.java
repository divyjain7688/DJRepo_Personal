package com.selenium.ebiz.header;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.FrequentlyPurchasedPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.OrderHistoryAndStatusPage;
import com.selenium.ebiz.pageobject.QuotesPage;
import com.selenium.ebiz.pageobject.SavedListsPage;
import com.selenium.ebiz.pageobject.SignInOrRegisterPage;
import com.selenium.ebiz.pageobject.SubscriptionsPage;
import com.selenium.ebiz.tools.WaitTool;

public class MyAccountQuickLinksInUtilityBarGuestUser_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	QuotesPage quotesPage;
	SavedListsPage savedListsPage;
	FrequentlyPurchasedPage frequentlyPurchasedPage;
	OrderHistoryAndStatusPage orderHistoryAndStatusPage;
	SignInOrRegisterPage signInOrRegisterPage;
	SubscriptionsPage subscriptionsPage;

	@BeforeMethod
	public void driverSetup() throws Exception 
	{
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
	}

	/**
	 * 
	 * Validating My Account quick links on utility bar for Guest user and Click on each link should be redirected to 
	 * specific my account links page
	 * 
	 * This Test script is mapped to US-Cat-980
	 * 
	 */
	@Test
	public void verifyMyAccountQuickLinksInUtilityBarGuestUser() throws Exception {

		WaitTool.hardWait();
		/*Assert.assertTrue(homePage.isDisplayedMyAccountQuotesQuickLinkInUtilityBar());
		quotesPage = homePage.clickMyAccountQuotesQuickLink();  //.......Commented because Quotes page is not implemented
		Assert.assertTrue(quotesPage.getQuotesPageHeadingText().equalsIgnoreCase("Quotes"));*/

		Assert.assertTrue(homePage.isDisplayedMyAccountSubscriptionsQuickLinkInUtilityBar());
		subscriptionsPage = homePage.clickMyAccountSubscriptionsQuickLink();

		Assert.assertTrue(homePage.isDisplayedMyAccountSavedListsQuickLinkInUtilityBar());
		savedListsPage = homePage.clickMyAccountSavedListsQuickLink();

		Assert.assertTrue(homePage.isDisplayedMyAccountOrderHistoryQuickLinkInUtilityBar());
		orderHistoryAndStatusPage = homePage.clickMyAccountOrderHistoryAndStatusQuickLink();

		Assert.assertTrue(homePage.isDisplayedMyAccountFrequentlyPurchasedQuickLinkInUtilityBar());
		frequentlyPurchasedPage = homePage.clickMyAccountFrequentlyPurchasedQuickLink();

		homePage.logoutOfApplication();
		Assert.assertTrue(loginPage.isDisplayedMyAccountSubscriptionsQuickLinkInUtilityBar());
		Assert.assertTrue(loginPage.isDisplayedMyAccountSavedListsQuickLinkInUtilityBar());
		Assert.assertTrue(loginPage.isDisplayedMyAccountOrderHistoryQuickLinkInUtilityBar());
		Assert.assertTrue(loginPage.isDisplayedMyAccountFrequentlyPurchasedQuickLinkInUtilityBar());
	}

}
