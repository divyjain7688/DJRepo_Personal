package com.selenium.ebiz.frequently_purchased;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.FrequentlyPurchasedPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.tools.CommonFunctions;

public class AccountHighLightsFrePurchasedLink_WORKING extends BaseClass {

	HomePage homePage;
	CommonFunctions commonFunctions;
	DBCon dbConnection;	
	LoginPage loginPage;
	FrequentlyPurchasedPage frequentlyPurchasedPage;

	@BeforeMethod	
	public void driverSetup() throws Exception {
		initialize();		
		dbConnection = new DBCon();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
	}	

	/**
	 * UserStory : US-238
	 * To verify when clicked on FrequentlyPurchased link from the account highlights, User should be taken to Frequently Purchased page
	 * @Author : Lakshmi
	 */

	@Test
	public void verifyFrePurchasLink() throws Exception
	{
		frequentlyPurchasedPage = homePage.clickFrePurchasedUtilityBar();
	}	

}
