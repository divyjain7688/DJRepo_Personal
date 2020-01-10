/**
 * 
 * @author suresh
 * 
 * This test will verify about the eSpot in the Top Categories
 * 
 * 
 * This Test Script is mapped to US-CAT-264
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

public class HomePageBreadCrumbBySubCategory extends BaseClass{
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
	 *  This is to check the L1, L2 and L3  and then verify for the BreadCrumbs in the SubCategory Page and clicks on the BreadCrumb home which displays homepage
	 */	

	@Test(priority=0)
	public void breadCrumbToHomePageAuthenticateUserTest() throws Exception{
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		WaitTool.hardWait();
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		// clicking on the Appliances from Left Navigation
		appliances = homePage.clickCategoryAppliancesLinkText();
		// Clicking on Washers and Dryers
		subCategoryAppliancesPage = appliances.clickTopCategoryWashersDryersLinkText();
		// Click on Shop by Category
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// Verifying if L1 Flyout is displayed
		Assert.assertTrue(homePage.isDisplayedShopByCategoryL1());
		// Click on Appliances in L1
		homePage.clickHeaderShopByCategoryLinkText();
		homePage.clickBreadCrumbHomeLinkText();
		appliances = homePage.clickCategoryAppliancesLinkText();
		WaitTool.hardWait();
		// Verifying if L2 is displayed
		// clicking on Washers and Dryers
		appliances.clickTopCategoryWashersDryersLinkText();
		// Clicking on the Washer Dryer Repair
		subCategoryAppliancesPage.clickSubCategoryWasherDryerRepairLinkText();
		// Verifying the BreadCrumb
		Assert.assertTrue(subCategoryAppliancesPage.isDisplayedBreadCrumb());
		// click on the home of the BreadCrumb
		homePage= homePage.clickBreadCrumbHomeLinkText();

	}

	@Test(priority=1)
	public void breadCrumbToHomePageGuestUserTest() throws Exception{
		appliances = loginPage.clickCategoryAppliancesLinkText();
		// Clicking on Washers and Dryers
		subCategoryAppliancesPage = appliances.clickTopCategoryWashersDryersLinkText();
		// Click on Shop by Category
		loginPage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// Verifying if L1 Flyout is displayed
		Assert.assertTrue(loginPage.isDisplayedShopByCategoryL1());
		// Click on Appliances in L1
		loginPage.clickHeaderShopByCategoryLinkText();
		loginPage.clickBreadCrumbHomeLinkText();
		appliances = loginPage.clickCategoryAppliancesLinkText();
		WaitTool.hardWait();
		// Verifying if L2 is displayed
		// clicking on Washers and Dryers
		appliances.clickTopCategoryWashersDryersLinkText();
		// Clicking on the Washer Dryer Repair
		subCategoryAppliancesPage.clickSubCategoryWasherDryerRepairLinkText();
		// Verifying the BreadCrumb
		Assert.assertTrue(subCategoryAppliancesPage.isDisplayedBreadCrumb());
		// click on the home of the BreadCrumb
		loginPage= loginPage.clickBreadCrumbHomeLinkText();

	}
}
