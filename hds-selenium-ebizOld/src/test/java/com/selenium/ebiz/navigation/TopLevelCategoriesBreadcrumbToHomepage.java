/**
 * 
 * @author suresh
 * 
 * This test will verify about the breadcrumb clicked in the SubCategory Page to the HomePage
 * 
 * This TestScript is Mapped to the US-CAT-255
 * 
 * 
 * 
 */

package com.selenium.ebiz.navigation;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.Appliances;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.WaitTool;


public class TopLevelCategoriesBreadcrumbToHomepage extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	Appliances appliances;
	SubCategoryAppliancesPage subCategoryAppliancesPage;
	ProductListingPage productListingPage;
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
	 *  Moves from Left Navigation to the Sub Category Pages and clicks on the BreadCrumb which displays homepage
	 */	
	@Test(priority=0)
	public void topLevelCategoriesBreadcrumbToHomepageAuthenticateUserTest() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		WaitTool.hardWait();
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		// Verifying the left Navigation Page
		// clicking on the Appliances on the left Navigation page
		productListingPage = homePage.moveToSubCategoryPage();
		productListingPage.isBreadcrumbDisplayed();
		homePage = productListingPage.clickOnHomeLinkOnBreadcrumb();		
	}

	/**
	 *  Moves from Left Navigation to the Sub Category Pages and clicks on the BreadCrumb which displays homepage
	 */	
	@Test(priority=1)
	public void topLevelCategoriesBreadcrumbToHomepageGuestUserTest() throws Exception{
		productListingPage = loginPage.moveToSubCategoryPage();
		productListingPage.isBreadcrumbDisplayed();
		homePage = productListingPage.clickOnHomeLinkOnBreadcrumb();	

	}


}
