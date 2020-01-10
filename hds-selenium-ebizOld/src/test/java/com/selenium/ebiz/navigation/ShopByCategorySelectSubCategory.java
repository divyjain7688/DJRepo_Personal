/**
 * 
 * @author suresh
 * 
 * This test will verify about the eSpot in the Top Categories
 * 
 * 
 * This Test Script is Mapped to US-CAT-263
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
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.WaitTool;

public class ShopByCategorySelectSubCategory extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	Appliances appliances;
	SubCategoryAppliancesPage subCategoryAppliancesPage;

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
	 *  This is to check the L1, L2 and L3  and then verify for the BreadCrumbs in the SubCategory Page
	 */	

	@Test(priority=0)
	public void shopByCategorySelectSubCategoryAuthenticateUserTest() throws Exception{
		// Verifying the Left Navigation in the homePage
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		WaitTool.hardWait();
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		WaitTool.hardWait();
		// Clicking on the Appliances in the Left Navigation
		appliances = homePage.clickCategoryAppliancesLinkText();	
		// Clicking on the Top Category  
		subCategoryAppliancesPage=appliances.clickTopCategoryWashersDryersLinkText();
		// Clicking on the Shop by Category
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// Verifying if L1 is displayed or not
		Assert.assertTrue(homePage.isDisplayedShopByCategoryL1());
		homePage.clickCategoryAppliancesLinkText();
		WaitTool.hardWait();
		Assert.assertTrue(homePage.isDisplayedShopByCategoryL2());
		subCategoryAppliancesPage = appliances.clickTopCategoryWashersDryersLinkText();
		Assert.assertTrue(homePage.isDisplayedShopByCategoryL3());
		//subCategoryAppliancesPage.clickSubCategoryWasherDryerRepairLinkText();
		Assert.assertTrue(subCategoryAppliancesPage.isDisplayedBreadCrumb());
	}

	@Test(priority=1)
	public void shopByCategorySelectSubCategoryGuestUserTest() throws Exception{

		appliances = loginPage.clickCategoryAppliancesLinkText();	
		// Clicking on the Top Category  
		appliances.clickTopCategoryWashersDryersLinkText();
		// Clicking on the Shop by Category
		loginPage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// Verifying if L1 is displayed or not
		Assert.assertTrue(loginPage.isDisplayedShopByCategoryL1());
		loginPage.clickCategoryAppliancesLinkText();
		WaitTool.hardWait();
		Assert.assertTrue(loginPage.isDisplayedShopByCategoryL2());
		subCategoryAppliancesPage = appliances.clickTopCategoryWashersDryersLinkText();
		Assert.assertTrue(loginPage.isDisplayedShopByCategoryL3());
	//	subCategoryAppliancesPage.clickSubCategoryWasherDryerRepairLinkText();
		Assert.assertTrue(subCategoryAppliancesPage.isDisplayedBreadCrumb());
	}


	//@AfterMethod
	public void tearDown(){
		driver.quit();
	} 
}
