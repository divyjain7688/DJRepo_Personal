package com.selenium.ebiz.save_list;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.SavedListsPage;


public class AccountHighLightsSavedList extends BaseClass {

	HomePage homePage;
	DBCon dbConnection;
	LoginPage loginPage;
	SavedListsPage savedListPage;
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
	 * To verify when clicked on Saved List link from the account highlights, User should be taken to Saved List Page
	 * @author lakshmi
	 * US-235
	 */

	@Test
	public void verifySavedListLink() throws Exception { 

		Assert.assertTrue(homePage.isDisplayedtopHeaderquotesLinkText());
		Assert.assertTrue(homePage.isDisplayedtopHeadersavedlistLinkText());
		Assert.assertTrue(homePage.isDisplayedtopHeaderfrequentlyPurchasedLinkText());
		Assert.assertTrue(homePage.isDisplayedtopHeaderorderHisStatusLinkText());

		//click on saved lists.
		savedListPage =homePage.clickSavedListUtilityBar();
		Assert.assertTrue(savedListPage.getSavedListspageHeadingText().equalsIgnoreCase("SAVED LISTS"));
	}

}
