/**
 * 
 * @author suresh
 * 
 * This test will verify about the Content Carousel in the Category to the HomePage
 * 
 * This Test Script is Mapped to the US-CAT-260
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

public class TopProductsCategoryCarousel extends BaseClass{
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
	 *  Moves from Left Navigation to the Category and verify Content Carousel
	 */	

	@Test(priority=0)
	public void contentCarouselTopCategoriesAuthenticateUserTest() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		WaitTool.hardWait();
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		//Clicking on the Appliances in the Left Navigation
		appliances = homePage.clickCategoryAppliancesLinkText();	
		// Verifying the Content Carousel
		Assert.assertTrue(appliances.isDisplayedeContentCarouselTopCategory()); 

	}

	@Test(priority=1)
	public void contentCarouselTopCategoriesGuestUserTest() throws Exception{
		//Clicking on the Appliances in the Left Navigation
		appliances = loginPage.clickCategoryAppliancesLinkText();	
		// Verifying the Content Carousel
		Assert.assertTrue(appliances.isDisplayedeContentCarouselTopCategory()); 

	}
	

}
