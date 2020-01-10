package com.selenium.ebiz.quotes;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.pageobject.LoginPage;

public class AccountHighLightsQuotesLink extends BaseClass {
	LoginPage loginPage;

	@BeforeMethod	
	public void driverSetup() throws MalformedURLException {
		initialize();	
		loginPage = new LoginPage(driver);
	}	

	/**
	 * To verify when clicked on Quotes link from the account highlights, User should be taken to Quotes page
	 * @author lakshmi
	 * US-239
	 */
	/*@Test
	public void verifyQuotesLink() throws Exception {
		Assert.assertTrue(homePage.getWelcomeNote().contains("Create an account"));
		//click on quotes 
		homePage.clickQuotesUtilityBar();	
	}
	 */


	/**quote link is not working in qa2 - divy jain
	 * To verify when clicked on Quotes link from the account highlights, User should be taken to Quotes page
	 * 
	 * US-239 @Lakshmi
	 * 
	 * Reviewed and modified bm071260
	 */

	/*@Test
	public void verifyQuotesLink() throws Exception {
		WaitTool.hardWait();
		Assert.assertTrue(loginPage.getTextCreateAnAccount().contains("Create an account"));
		//click on quotes 
		loginPage.clickQuotesUtilityBar();	
	}*/

}
