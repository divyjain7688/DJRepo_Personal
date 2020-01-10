/**
 * 
 * @author suresh
 * 
 * This test will verify about the eSpot in the Top Categories
 * 
 * This Test Script is mapped to US-CAT-259
 * 
 * 
 * 
 */
package com.selenium.ebiz.navigation;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.Appliances;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.tools.WaitTool;

public class TopLevelCategorieseSpot extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	Appliances appliances;

	/*
	 *  Launching of the Browser and login with Valid Credentials
	 */

	@BeforeMethod
	public void driverSetup() throws MalformedURLException {
		driver = initialize();
		loginPage = new LoginPage(driver);
		//homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));

	}

	/**
	 *  Verifying the eSpot in the Category pages below the Top Brands
	 */

	@Test(priority=0)
	public void eSpotTopCategoriesAuthenticateUserTest() throws Exception{
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		appliances = homePage.clickCategoryAppliancesLinkText();	
		Assert.assertTrue(appliances.isDisplayedeSpotTopCategory()); 

	}

	@Test(priority=1)
	public void eSpotTopCategoriesGuestUserTest() throws Exception{
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		WaitTool.hardWait();
		// Clicking on the Appliances link in the Left Navigation
		appliances = homePage.clickCategoryAppliancesLinkText();	
		//Verifying the eSpot in the Categories below the Top Brands 
		Assert.assertTrue(appliances.isDisplayedeSpotTopCategory()); 

	}


}
