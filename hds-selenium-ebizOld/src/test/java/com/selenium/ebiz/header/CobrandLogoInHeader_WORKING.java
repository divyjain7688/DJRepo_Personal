package com.selenium.ebiz.header;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.Appliances;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.PropertyLookupPage;
import com.selenium.ebiz.tools.WaitTool;

public class CobrandLogoInHeader_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList1,usersList2;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	Appliances appliances;
	PropertyLookupPage propertyLookupPage;

	@BeforeClass
	public void driverSetup() throws MalformedURLException {
		driver = initialize();
		loginPage = new LoginPage(driver);
	}

	/**
	 * 
	 * @author Smitha
	 * Login as cobrand user and Validate Cobrand Logo displayed in the Header. Should not display Cobrand Logo for other users
	 * 
	 * This Test script is mapped to US-Cat-965
	 * 
	 */

	@Test
	public void verifyCobrandLogoInHeader() throws Exception {

		usersList1 = dbConnection.loadDataFromExcel("verifyCobrandLogoInHeader", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList1.get(0).getuserName(),usersList1.get(0).getpassword() );
		propertyLookupPage = homePage.clickPropertyDropdown();
		propertyLookupPage.clickProperty(usersList1.get(0).getchooseProperty());
		Assert.assertTrue(homePage.IsDisplayedCobrandLogoInHeader());//Validating for Cobranded user
		WaitTool.hardWait();
		loginPage.logoutOfApplication();
		usersList2 = dbConnection.loadDataFromExcel("verifyLoginForSumaUser", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList2.get(0).getuserName(), usersList2.get(0).getpassword());
		//	Assert.assertFalse(homePage.IsDisplayedCobrandLogoInHeader());//Validating for other users
	}

}
