package com.selenium.ebiz.email_and_print_page;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.SavedListsPage;
import com.selenium.ebiz.tools.WaitTool;

public class emailAPageTest extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	SavedListsPage savedListsPage;

	@BeforeMethod
	public void driverSetup() throws Exception {
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
	}

	/**
	 * verify email Link is displayed and click on email link
	 * This Test script is mapped to US-Cat-153
	 */
	@Test
	public void verifyprintAPage() throws Exception {	
		WaitTool.hardWait();

		savedListsPage = homePage.clickMyAccountSavedListsQuickLink();
		Assert.assertTrue(savedListsPage.getSavedListspageHeadingText().equalsIgnoreCase("Saved Lists"));

		Assert.assertTrue(savedListsPage.isDisplayedEmailPageLink());
		savedListsPage.clickEmailPageLink();

		WaitTool.hardWait();

	}
}
