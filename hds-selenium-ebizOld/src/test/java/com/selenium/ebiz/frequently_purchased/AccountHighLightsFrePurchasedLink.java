package com.selenium.ebiz.frequently_purchased;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.FrequentlyPurchasedPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;

public class AccountHighLightsFrePurchasedLink extends BaseClass {

	HomePage homePage;
	LoginPage loginPage;
	DBCon dbConnection;
	FrequentlyPurchasedPage frequentlyPurchasedPage;

	@BeforeMethod	
	public void driverSetup() throws MalformedURLException, Exception {
		driver = initialize();		
		loginPage = new LoginPage(driver);
		dbConnection = new DBCon();	
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
	}	

	/**
	 * To verify when clicked on FrequentlyPurchased link from the account highlights, User should be taken to Frequently Purchased page
	 * @author lakshmi
	 * US-238
	 */

	@Test
	public void verifyFrePurchasLink() throws Exception {

		//click on frequently purchased
		frequentlyPurchasedPage = homePage.clickFrePurchasedUtilityBar();	
		Assert.assertTrue(frequentlyPurchasedPage.getFrequentlyPurchasedpageHeadingText().equalsIgnoreCase("FREQUENTLY PURCHASED"));
	}	

}
