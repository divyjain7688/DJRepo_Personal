package com.selenium.ebiz.header;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.pageobject.LoginPage;

public class DisplayPromotionalStaticContentPagesGuestUser_WORKING extends BaseClass {

	LoginPage loginPage;

	@BeforeMethod
	public void DriverSetUP() throws Exception 
	{
		driver = initialize();
		loginPage = new LoginPage(driver);
	}

	/**
	 * 
	 * @author Neha Dev
	 * Display Static Content Pages for guest User
	 * This Test script is mapped to US-Cat-870
	 * @throws Exception 
	 * 
	 */

	@Test

	public void verifyPromotionalStaticContentPageGuestUser() throws Exception
	{

		Assert.assertTrue(loginPage.isDisplayedPromotionalContent());
		Assert.assertTrue(loginPage.isDisplayedshopByCategoryLinkText());
		Assert.assertTrue(loginPage.isDisplayedHeaderServicesLinkText());
		Assert.assertTrue(loginPage.isDisplayedHeaderResourcesLinkText());
		Assert.assertTrue(loginPage.isDisplayedHeaderOffersLinkText());
		Assert.assertTrue(loginPage.isDisplayedHeaderecatalogsLinktext());
		Assert.assertTrue(loginPage.isDisplayedheaderQuickOrderLinkText());
		Assert.assertTrue(loginPage.isDisplayedheaderWebsitehelpEdit());
		Assert.assertTrue(loginPage.isDisplayedheaderMyCartLinkText());
		Assert.assertTrue(loginPage.isDisplayedheaderQuickOrderLinkText());
		Assert.assertTrue(loginPage.isDisplayedtopHeaderquotesLinkText());
		Assert.assertTrue(loginPage.isDisplayedtopHeadersavedlistLinkText());
		Assert.assertTrue(loginPage.isDisplayedtopHeaderfrequentlyPurchasedLinkText());
		Assert.assertTrue(loginPage.isDisplayedtopHeaderorderHisStatusLinkText());

	}	   

}


