package com.selenium.ebiz.account_management.login;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.PropertyLookupPage;

public class HomepageForLoggedInUserwithWinRel_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	PropertyLookupPage propertyLookupPage;

	@BeforeMethod
	public void driverSetup() throws Exception {
		driver = initialize();
		usersList = dbConnection.loadDataFromExcel("verifyCobrandLogoInHeader", "LoginTestData");
		loginPage = new LoginPage(driver);		
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(),usersList.get(0).getpassword() );
	}

	/**
	 * @author smitha
	 * 
	 * launch the application in browser,Login with cobrand user credentials and verify the homepage 
	 * 
	 * This Test Script is mapped to user stories US-Cat-161 US-Cat-181 and US-Cat-201
	 * 
	 */

	@Test
	public void displayHomePageForCobrandUserTest() throws Exception {

		usersList = dbConnection.loadDataFromExcel("verifyCobrandLogoInHeader", "LoginTestData");
		propertyLookupPage = homePage.clickPropertyDropdown();
		propertyLookupPage.clickProperty(usersList.get(0).getchooseProperty());

		//Validating the HomePage displayed or not by checking Hi text.
		System.out.println( homePage.getWelcomeNote());	
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); 

		//Validating the HomePage displaying Signed In Username
		System.out.println( homePage.getUserSignedInUser());	
		Assert.assertFalse(homePage.getUserSignedInUser().contains("Account"));

		//Validating the HomePage displaying Account Number
		System.out.println( homePage.getUserAccountNumber());
		Assert.assertTrue(homePage.getUserAccountNumber().contains("Account #"));

		System.out.println( homePage.getUserAccountName());
		Assert.assertTrue(homePage.isDisplayedPropertyDropdown());

		Assert.assertTrue(homePage.isDisplayedCategoryleftNavigation());
		//	Assert.assertTrue(	homePage.getYourCompanysProductsTitleText().equalsIgnoreCase("Your Company's Products"));
		Assert.assertTrue(homePage.getCategoryRecommendationTitleText().equalsIgnoreCase("Your Top Categories"));
		Assert.assertTrue(homePage.isDisplayedHeaderOrderAgain());
		Assert.assertTrue(homePage.IsDisplayedContentWidgetLearnSomethingNewTitleText());


	}

}

