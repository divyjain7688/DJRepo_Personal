package com.selenium.ebiz.header;

import java.util.ArrayList;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.Appliances;
import com.selenium.ebiz.pageobject.HeaderServicesPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.WaitTool;

public class DisplayStaticContentPageLoggedInUser_WORKING extends BaseClass {

	HomePage homePage;
	Appliances appliances;
	SubCategoryAppliancesPage subCategoryAppliancesPage;
	HeaderServicesPage headerServicesPage;
	LoginPage loginPage;
	ArrayList<UsersListBean> usersList;
	DBCon dbConn;

	@BeforeMethod
	public void DriverSetUP() throws Exception {
		driver = initialize();
		headerServicesPage = new HeaderServicesPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		dbConn = new DBCon();
		usersList = dbConn.loadDataFromExcel("verifyLogin","LoginTestData");
		homePage= loginPage.loginToHdSupplySite(usersList.get(0).getuserName(),usersList.get(0).getpassword());
		WaitTool.hardWait();
	}

	/**
	 * 
	 * @author Neha Dev
	 * Display Static Content Pages for authenticated User
	 * This Test script is mapped to US-Cat-860
	 * @throws Exception 
	 * 
	 */

	@Test

	public void verifyDisplayStaticContentPage() throws Exception {

		//Verify that static content pages are displayed on HD Supply website

		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi"));  
		Assert.assertTrue(homePage.isDisplayedshopByCategoryLinkText());
		Assert.assertTrue(homePage.isDisplayedHeaderServicesLinkText());
		Assert.assertTrue(homePage.isDisplayedHeaderResourcesLinkText());
		Assert.assertTrue(homePage.isDisplayedHeaderOffersLinkText());
		Assert.assertTrue(homePage.isDisplayedHeaderecatalogsLinktext());
		Assert.assertTrue(homePage.isDisplayedheaderQuickOrderLinkText());
		Assert.assertTrue(homePage.isDisplayedheaderWebsitehelpEdit());
		Assert.assertTrue(homePage.isDisplayedheaderMyCartLinkText());
		Assert.assertTrue(homePage.isDisplayedheaderQuickOrderLinkText());
		Assert.assertTrue(homePage.isDisplayedtopHeaderquotesLinkText());
		Assert.assertTrue(homePage.isDisplayedtopHeadersavedlistLinkText());
		Assert.assertTrue(homePage.isDisplayedtopHeaderfrequentlyPurchasedLinkText());
		Assert.assertTrue(homePage.isDisplayedtopHeaderorderHisStatusLinkText());


		//Verify that user can navigate through different product categories and services

		// Clicking on the Shop by Category
		homePage.clickHeaderShopByCategoryLinkText();
		// Clicking on the Appliances
		appliances=homePage.clickCategoryAppliancesLinkText();
		// Clicking on the Washers and Dryers
		subCategoryAppliancesPage=appliances.clickTopCategoryWashersDryersLinkText();
		// Clicking on the Washer Dryer Repair
		subCategoryAppliancesPage.clickSubCategoryWasherDryerRepairLinkText();
		// Clicking on the HDLogo Image in Header
		homePage.clickHeaderHDLogoImage();
		// Verifying the Left Navigation in the homePage
		//Assert.assertTrue(homePage.isDisplayedLeftNavgation());

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

		Assert.assertTrue(homePage.isCustomProductsTextDisplayed());
	}
	 
}


