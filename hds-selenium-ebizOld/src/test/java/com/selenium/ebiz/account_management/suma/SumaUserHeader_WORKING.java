package com.selenium.ebiz.account_management.suma;

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

public class SumaUserHeader_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void driverSetup() throws Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("verifyLoginForSumaUser", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(),usersList.get(0).getpassword() );

	}

	/**
	 * 
	 * @author smitha
	 * US-Cat-1010 - Login to HD Supply as Suma user and Verify Homepage for the name ,account and the property drop down displayed on the Home page header.  
	 * 
	 */

	@Test
	public void verifySumaUserHeader() throws Exception {
		WaitTool.hardWait();

		// Validating the HomePage displayed or not by checking Hi text.
		System.out.println( homePage.getWelcomeNote());	
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); // Validating the HomePage displayed or not by checking Hello text.

		System.out.println( homePage.getUserSignedInUser());	
		Assert.assertFalse(homePage.getUserSignedInUser().contains("Account"));

		System.out.println( homePage.getUserAccountNumber());
		Assert.assertTrue(homePage.getUserAccountNumber().contains("Account #"));

		System.out.println( homePage.getUserAccountName());
		Assert.assertTrue(homePage.isDisplayedPropertyDropdown());

	}

}
