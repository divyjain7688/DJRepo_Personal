package com.selenium.ebiz.frequently_purchased;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.tools.CommonFunctions;

public class AccountHighLightsFrePurchasedLink_NOTWORKING extends BaseClass {

	HomePage homePage;
	CommonFunctions commonFunctions;
	DBCon dbConnection;	
	LoginPage loginPage;

	@BeforeMethod	
	public void driverSetup() throws MalformedURLException, Exception {
		initialize();		
		homePage = new HomePage(driver);
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
	public void verifyFrePurchasLink() throws Exception {
		Assert.assertTrue(homePage.getWelcomeNote().contains("Create an account"));
		//click on frequently purchased
		homePage.clickFrePurchasedUtilityBar();
	}	

}
