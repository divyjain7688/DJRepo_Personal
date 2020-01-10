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
import com.selenium.ebiz.tools.WaitTool;

public class SavedListQuickLinks extends BaseClass {

	HomePage homePage;
	LoginPage loginPage;
	SavedListsPage savedListPage;

	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();;

	@BeforeMethod	
	public void driverSetup() throws Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());	
	}

	/**
	 * To verify Saved list quick links are displayed
	 * @author Neha
	 * US-700
	 */

	@Test
	public void verifySavedListQuickLinks() throws Exception { 
		WaitTool.hardWait();
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi"));
		//To verify all utility bar links.
		WaitTool.hardWait();
		Assert.assertTrue(homePage.isDisplayedtopHeaderquotesLinkText() && homePage.isDisplayedtopHeadersavedlistLinkText() && homePage.isDisplayedtopHeaderfrequentlyPurchasedLinkText() && homePage.isDisplayedtopHeaderorderHisStatusLinkText());
		//click on saved lists.
		WaitTool.hardWait();
		savedListPage =homePage.clickSavedListUtilityBar();
		Assert.assertTrue(savedListPage.getSavedListspageHeadingText().equalsIgnoreCase("SAVED LISTS"));

		//Click on Private Lists from the list
		WaitTool.hardWait();
		Assert.assertTrue(savedListPage.isDisplayedPrivateListsTab());
		savedListPage.clickOnPrivateLists();

		// verify Add list to Cart displayed
		Assert.assertTrue(savedListPage.isDisplayedAddListToCart());

		// verify Convert to shared List is displayed
		Assert.assertTrue(savedListPage.isDisplayedConvertToSharedList());

		//Verify Email List is displayed
		Assert.assertTrue(savedListPage.isDisplayedEmailList());

		//Verify Delete is displayed
		Assert.assertTrue(savedListPage.isDisplayeddelete());

		//Verify Print Bin Label is displayed
		Assert.assertTrue(savedListPage.isDisplayedPrintBinLabel());


		//Click on Shared Lists from the list
		WaitTool.hardWait();
		Assert.assertTrue(savedListPage.isDisplayedSharedListsTab());
		savedListPage.clickOnSharedLists();


		// verify Add list to Cart displayed
		Assert.assertTrue(savedListPage.isDisplayedAddListToCart());

		// verify Convert to shared List is displayed
		Assert.assertTrue(savedListPage.isDisplayedConvertToPrivateList());

		//Verify Email List is displayed
		Assert.assertTrue(savedListPage.isDisplayedEmailList());

		//Verify Delete is displayed
		Assert.assertTrue(savedListPage.isDisplayeddelete());

		//Verify Print Bin Label is displayed
		Assert.assertTrue(savedListPage.isDisplayedPrintBinLabel());

	}


}
