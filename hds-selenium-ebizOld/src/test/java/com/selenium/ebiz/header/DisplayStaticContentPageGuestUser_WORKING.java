package com.selenium.ebiz.header;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.pageobject.Appliances;
import com.selenium.ebiz.pageobject.HeaderServicesPage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;


public class DisplayStaticContentPageGuestUser_WORKING extends BaseClass {

	LoginPage loginPage;
	Appliances appliances;
	SubCategoryAppliancesPage subCategoryAppliancesPage;
	HeaderServicesPage headerServicesPage;

	//  Launching of the Browser as a guest user

	@BeforeMethod

	public void DriverSetUP() throws MalformedURLException {
		driver= initialize();
		headerServicesPage = new HeaderServicesPage(driver);
		loginPage = new LoginPage(driver);

	}

	/**
	 * 
	 * @author Neha Dev
	 * Display Static Content Pages for Unauthenticated User
	 * This Test script is mapped to US-Cat-850
	 * @throws Exception 
	 * 
	 */

	@Test

	public void verifyDisplayStaticContentPage() throws Exception {


		//Verify that static content pages are displayed on HD Supply website
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


		//Verify that user can navigate through different product categories and services

		// Clicking on the Shop by Category
		loginPage.clickHeaderShopByCategoryLinkText();

		// Clicking on the Appliances
		appliances=loginPage.clickCategoryAppliancesLinkText();

		// Clicking on the Washers and Dryers
		subCategoryAppliancesPage=appliances.clickTopCategoryWashersDryersLinkText();

		// Clicking on the Washer Dryer Repair
		subCategoryAppliancesPage.clickSubCategoryWasherDryerRepairLinkText();

		// Clicking on the HDLogo Image in Header
		loginPage.clickHeaderHDLogoImage();

		// Verifying the Left Navigation in the homePage
		Assert.assertTrue(loginPage.isDisplayedLeftNavigation());

		// Click on the header Services
		headerServicesPage.clickHeaderServicesLinkText();

		// Verifying the L1 Flyout of Services
		Assert.assertTrue(headerServicesPage.isDisplayedL1FlyoutServices());

		// Click on the Custom products link
		headerServicesPage.clickHeaderServicesCustomProductsLinkText();

		// Verifying the L2 Flyout Services
		Assert.assertTrue(headerServicesPage.isDisplayedL2FlyoutServices());

		// clicking on the Order Forms
		headerServicesPage.clickHeaderServicesOrderFormsLinkText();

	}
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	} 

}


