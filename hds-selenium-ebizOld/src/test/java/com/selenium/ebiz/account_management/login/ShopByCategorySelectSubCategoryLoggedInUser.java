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
package com.selenium.ebiz.account_management.login;

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

public class ShopByCategorySelectSubCategoryLoggedInUser extends BaseClass{
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
	public void driverSetup() throws MalformedURLException, Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));

	}

	/**
	 *  This is to check the L1, L2 and L3  and then verify for the BreadCrumbs in the SubCategory Page
	 */	

	@Test
	public void shopByCategorySelectSubCategoryTest() throws Exception{
		// Verifying the Left Navigation in the homePage
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		// Clicking on the Appliances in the Left Navigation
		homePage.clickCategoryAppliancesLinkText();	
		// Clicking on the Top Category  
		appliances.clickTopCategoryWashersDryersLinkText();
		// Clicking on the Shop by Category
		homePage.clickHeaderShopByCategoryLinkText();
		// Verifying if L1 is displayed or not
		Assert.assertTrue(homePage.isDisplayedShopByCategoryL1());
		homePage.clickCategoryAppliancesLinkText();
		WaitTool.hardWait();
		Assert.assertTrue(homePage.isDisplayedShopByCategoryL2());
		appliances.clickTopCategoryWashersDryersLinkText();
		Assert.assertTrue(homePage.isDisplayedShopByCategoryL3());
		subCategoryAppliancesPage.clickSubCategoryWasherDryerRepairLinkText();
		Assert.assertTrue(subCategoryAppliancesPage.isDisplayedBreadCrumb());
	}

}
