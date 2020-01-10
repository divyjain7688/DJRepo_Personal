package com.selenium.ebiz.header;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.selenium.ebiz.pageobject.V8_Homepage;
import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.QuickOrderPad;
import com.selenium.ebiz.pageobject.QuickOrderPage;

public class HomepageHeaderDisplayGuestsUser_WORKING extends BaseClass{


	HomePage homePage;
	LoginPage loginPage;
	QuickOrderPage quickOrderPage;
	QuickOrderPad quickOrderPad;

	@BeforeMethod	
	public void driverSetup() throws MalformedURLException {
		initialize();		
		loginPage = new LoginPage(driver);
		//homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
	}	

	/**
	 * To Verify As an Unauthenticated User I want to view the Header from anywhere on the site so that  I can quickly navigate the catalog or access
 my account pages.
	 * 
	 * US-940
	 */


	@Test 
	public void verifyDisplayHeaderForGuestuser() throws Exception {

		Assert.assertTrue(loginPage.isDisplayedshopByCategoryLinkText());
		Assert.assertTrue(loginPage.isDisplayedHeaderResourcesLinkText());
		Assert.assertTrue(loginPage.isDisplayedHeaderOffersLinkText());
		Assert.assertTrue(loginPage.isDisplayedHeaderecatalogsLinktext());
		Assert.assertTrue(loginPage.isDisplayedHeaderServicesLinkText());

		Assert.assertTrue(loginPage.isDisplayedRegisterOrSignIn());
		Assert.assertTrue(loginPage.isDisplayedheaderWebsitehelpEdit());

		Assert.assertTrue(loginPage.isDisplayedheaderMyCartLinkText());
		Assert.assertTrue(loginPage.isDisplayedheaderQuickOrderLinkText());

		Assert.assertTrue(loginPage.isDisplayedtopHeaderquotesLinkText());
		Assert.assertTrue(loginPage.isDisplayedtopHeadersavedlistLinkText());
		Assert.assertTrue(loginPage.isDisplayedtopHeaderfrequentlyPurchasedLinkText());
		Assert.assertTrue(loginPage.isDisplayedtopHeaderorderHisStatusLinkText());


	}


}
