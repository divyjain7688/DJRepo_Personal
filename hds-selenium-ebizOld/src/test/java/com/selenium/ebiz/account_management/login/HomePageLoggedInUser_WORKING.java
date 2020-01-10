package com.selenium.ebiz.account_management.login;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;

public class HomePageLoggedInUser_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void driverSetup() throws Exception 
	{
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

	}

	/**
	 * @author smitha
	 * 
	 * launch the application in browser,Login with valid credentials and verify the homepage for authenticated user
	 * 
	 * This Test Script is mapped to user stories US-Cat-160 US-Cat-180 and US-Cat-200
	 * 
	 */

	@Test
	public void displayHomePageForAuthenticatedUserTest() throws Exception 
	{
		//Validating the HomePage displaying Signed In Username
		System.out.println( homePage.getUserSignedInUser());	
		Assert.assertFalse(homePage.getUserSignedInUser().contains("Account"));

		//Validating the HomePage displaying Account Number
		System.out.println( homePage.getUserAccountNumber());
		Assert.assertTrue(homePage.getUserAccountNumber().contains("Account #"));

		System.out.println( homePage.getUserAccountName());
		Assert.assertTrue(homePage.isDisplayedPropertyDropdown());

		Assert.assertTrue(homePage.isDisplayedCategoryleftNavigation());
		Assert.assertTrue(homePage.getCategoryRecommendationTitleText().equalsIgnoreCase("Your Top Categories"));
		Assert.assertTrue(homePage.isDisplayedHeaderOrderAgain());
		Assert.assertTrue(homePage.IsDisplayedContentWidgetLearnSomethingNewTitleText());

	}
}
