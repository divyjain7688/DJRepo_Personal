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
import com.selenium.ebiz.pageobject.PropertyLookupPage;
import com.selenium.ebiz.tools.WaitTool;

public class SumaUserPropertySelectionModal_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	PropertyLookupPage propertyLookupPage;

	@BeforeMethod
	public void driverSetup() throws Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("verifySumaUserPropertySelectionModal", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(),usersList.get(0).getpassword() );

	}

	/**
	 * @author smitha
	 * US-Cat-1012 - Login to HD Supply as Suma user, verify select property from Property Lookup Modal and verify property can be sorted by Name,Account Number, city and state
	 * 
	 * Reviewed and updated by bm071260
	 */

	@Test
	public void verifySumaUserPropertySelectionModal() throws Exception {

		WaitTool.hardWait();
		Assert.assertTrue(homePage.isDisplayedPropertyDropdown());
		propertyLookupPage = homePage.clickPropertyDropdown();
		WaitTool.hardWait();
		String accountNumber = propertyLookupPage.clickOnOneAccount();
		System.out.println("accountNumber is "+ accountNumber);
		System.out.println( homePage.getUserAccountNumber());
		Assert.assertTrue(homePage.getUserAccountNumber().contains(accountNumber));

		propertyLookupPage = homePage.clickPropertyDropdown();
		Assert.assertTrue(propertyLookupPage.IsDisplayedPropertyTableSortedByName());
		Assert.assertTrue(propertyLookupPage.IsDisplayedPropertyTableSortedByAccountNumber());
		Assert.assertTrue(propertyLookupPage.IsDisplayedPropertyTableSortedByCity());
		Assert.assertTrue(propertyLookupPage.IsDisplayedPropertyTableSortedByState());

		propertyLookupPage.clickProperty(usersList.get(0).getchooseProperty());	
		Assert.assertEquals(homePage.getUserAccountName(), usersList.get(0).getchooseProperty());
		homePage.logoutOfApplication();
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(),usersList.get(0).getpassword() );
		Assert.assertEquals(homePage.getUserAccountName(), usersList.get(0).getchooseProperty());
	}

}
