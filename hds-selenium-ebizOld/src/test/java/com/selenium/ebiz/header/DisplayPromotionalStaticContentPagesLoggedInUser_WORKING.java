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


public class DisplayPromotionalStaticContentPagesLoggedInUser_WORKING extends BaseClass {

	HomePage homePage;
	Appliances appliances;
	SubCategoryAppliancesPage subCategoryAppliancesPage;
	HeaderServicesPage headerServicesPage;
	LoginPage loginPage;
	ArrayList<UsersListBean> usersList;
	DBCon dbConn;



	//  Launching of the Browser as valid user

	@BeforeMethod

	public void DriverSetUP() throws Exception {
		driver= initialize();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		dbConn = new DBCon();
		usersList = dbConn.loadDataFromExcel("verifyLogin","LoginTestData");
		homePage= loginPage.loginToHdSupplySite(usersList.get(0).getuserName(),usersList.get(0).getpassword());
	}

	/**
	 * 
	 * @author Neha Dev
	 * Display Promotional Static ContentPages LoggedInUser
	 * This Test script is mapped to US-Cat-880
	 * @throws Exception 
	 * 
	 */

	@Test

	public void verifyPromotionalStaticContentPageLoggedInUser() throws Exception 
	{

		//Verify that static content pages are displayed on HD Supply website
		Assert.assertTrue(homePage.isDisplayedPromotionalContent());
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
	}


}


