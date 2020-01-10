/**
 * 
 * @author suresh
 * 
 * This test will verify about the Display HD Logo in Header
 * 
 * 
 * This Test Script is Mapped to US-Cat-964
 * 
 * 
 */
package com.selenium.ebiz.header;
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

public class HeaderHDLogo_WORKING extends BaseClass{
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
	public void driverSetup() throws Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
	}

	/**
	 *  This is to check HD logo and then move to subCategory and then click on HD Logo to come back to homepage
	 */	

	@Test
	public void verifyHDLogoAuthenticateUserTest() throws Exception{
		// Verifying the Left Navigation in the homePage
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		WaitTool.hardWait();
		Assert.assertTrue(homePage.isDisplayedHeaderHDLogoImage());
		// Clicking on the Shop by Category
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// Clicking on the Appliances
		appliances=homePage.clickCategoryAppliancesLinkText();
		WaitTool.hardWait();
		// Clicking on the Washers and Dryers
		subCategoryAppliancesPage=appliances.clickTopCategoryWashersDryersLinkText();
		// Clicking on the Washer Dryer Repair
		subCategoryAppliancesPage.clickSubCategoryWasherDryerRepairLinkText();
		// Clicking on the HDLogo Image in Header
		homePage.clickHeaderHDLogoImage();
		WaitTool.hardWait();
		// Verifying the Left Navigation in the homePage
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());

	}

	
}

