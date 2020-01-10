package com.selenium.ebiz.account_management.login;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.tools.WaitTool;

public class RememberLoginDetailsGuestUser_Working extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void driverSetup() throws MalformedURLException {
		driver = initialize();
		loginPage = new LoginPage(driver);
	}

	/**
	 * @author smitha
	 * US-Acct-571 - Login to HD Supply site by clicking Remember Me checkbox. On next login attempt username should be prepopulated to the user
	 * And verify login to HD supply  by entering password and prepopulated username
	 */	
	@Test(priority = 0)
	public void verifySelectRememberMeCheckboxAndloginToHdSupplySite() throws Exception {
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.selectRememberMeCheckboxAndloginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		WaitTool.hardWait();

		//Validating the HomePage displayed or not by checking Hi text.
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); // Validating the HomePage displayed or not by checking Hello text.
		WaitTool.hardWait();
		//logout
		loginPage.logoutOfApplication();

		// Validating user is successfully logged out
		Assert.assertTrue(loginPage.isDisplayedRegisterOrSignInLinkText());	
		loginPage.clickHeaderRegisterOrSignInLinkText();
		Assert.assertTrue(loginPage.getUsernamePrepopulatedValue().equals(usersList.get(0).getuserName()));
		WaitTool.hardWait();

		//Login to HD supply by entering password and prepopulated username
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getpassword());
		WaitTool.hardWait();

		//Validating the HomePage displayed or not by checking Hi text.
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); // Validating the HomePage displayed or not by checking Hello text.
		WaitTool.hardWait();
		//logout
		loginPage.logoutOfApplication();

	}

	/**
	 * @author smitha
	 * US-Acct-571 - Login to HD Supply site by not clicking Remember Me checkbox. on next login attempt username should not be prepopulated 
	 */	
	@Test(priority = 1)
	public void verifyloginToHdSupplySiteByNotSelectingRememberMeCheckbox() throws Exception {
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		WaitTool.hardWait();

		//Validating the HomePage displayed or not by checking Hi text.
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); // Validating the HomePage displayed or not by checking Hello text.
		WaitTool.hardWait();
		WaitTool.hardWait();
		//logout
		loginPage.logoutOfApplication();

		// Validating user is successfully logged out
		Assert.assertTrue(loginPage.isDisplayedRegisterOrSignInLinkText());	
		loginPage.clickHeaderRegisterOrSignInLinkText();
		Assert.assertTrue(loginPage.getUsernamePrepopulatedValue().equals(""));
		WaitTool.hardWait();

	}

}