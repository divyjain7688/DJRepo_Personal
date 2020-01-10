package com.selenium.ebiz.header;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.selenium.ebiz.pageobject.V8_Homepage;
import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MinicartPage;
import com.selenium.ebiz.pageobject.QuickOrderPad;
import com.selenium.ebiz.pageobject.ShoppingCartPage;

public class HomepageHeaderDisplayLoggedInUser_WORKING extends BaseClass{
	HomePage homePage;
	LoginPage loginPage;
	QuickOrderPad quickOrderPad;
	DBCon dbConnection;
	MinicartPage miniCartPage;
	ShoppingCartPage shoppingCartPage;
	ArrayList<UsersListBean> usersList;

	@BeforeMethod	
	public void driverSetup() throws Exception {
		dbConnection = new DBCon();
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());		
	}


	/**
	 * To Verify As an authenticated User I want to view the Header from anywhere on the site so that  I can quickly navigate the catalog or access
 		my account pages.
	 * @author lakshmi
	 * US-950
	 */

	@Test 
	public void verifyDisplayHeaderForLoggeduser() throws Exception {
		//Assert.assertTrue(homePage.isDisplayedaccountInfoSectionText());
		Assert.assertTrue(homePage.isDisplayedshopByCategoryLinkText());
		Assert.assertTrue(homePage.isDisplayedHeaderResourcesLinkText());
		Assert.assertTrue(homePage.isDisplayedHeaderOffersLinkText());
		Assert.assertTrue(homePage.isDisplayedHeaderecatalogsLinktext());
		Assert.assertTrue(homePage.isDisplayedHeaderServicesLinkText());

		//Assert.assertTrue(homePage.isDisplayedRegisterOrSignIn());
		Assert.assertTrue(homePage.isDisplayedheaderWebsitehelpEdit());

		Assert.assertTrue(homePage.isDisplayedheaderMyCartLinkText());
		Assert.assertTrue(homePage.isDisplayedheaderQuickOrderLinkText());

		Assert.assertTrue(homePage.isDisplayedtopHeaderquotesLinkText());
		Assert.assertTrue(homePage.isDisplayedtopHeadersavedlistLinkText());
		Assert.assertTrue(homePage.isDisplayedtopHeaderfrequentlyPurchasedLinkText());
		Assert.assertTrue(homePage.isDisplayedtopHeaderorderHisStatusLinkText());

		quickOrderPad = homePage.clickOnQuickOrderLink();
		Assert.assertTrue(quickOrderPad.isDisplayedquickOrderSection());

		homePage = quickOrderPad.clickHeaderHDLogoImage();
		shoppingCartPage = homePage.clickHeaderMyCartLinkText();
		//shoppingCartPage = miniCartPage.clickViewCartButton();
		//	Assert.assertTrue(shoppingCartPage.isDisplayedShoppingCartPage());		

	}

}
