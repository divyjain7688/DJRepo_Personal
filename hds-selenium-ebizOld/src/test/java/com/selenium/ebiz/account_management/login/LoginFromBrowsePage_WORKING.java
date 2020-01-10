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
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class LoginFromBrowsePage_WORKING extends BaseClass{

	HomePage homePage;
	CommonFunctions commonFunctions;
	Appliances appliances;	
	LoginPage loginPage;
	ProductPage productPage;
	SubCategoryAppliancesPage subcategoryAppPage;
	ProductDetailsPage productDetailsPage;
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();

	@BeforeMethod
	public void driverSetup() throws MalformedURLException 
	{
		driver = initialize();	
		loginPage = new LoginPage(driver);
	}

	/**
	 * 
	 * @author Smitha
	 * Verify Click Sign In On subcategory and PDP page then Sign In page should appear. Sign In with valid credentials.
	 * Upon successful login, user should return to the subcategory and PDP page they were on
	 * 
	 * This Test script is mapped to US-Cat-561
	 * 
	 */

	@Test
	public void VerifyLoginFromBrowsePageTest() throws Exception {
		loginPage.clickHeaderShopByCategoryLinkText();
		appliances = loginPage.clickCategoryAppliancesLinkText();
		subcategoryAppPage = appliances.clickTopCategoryDishwashersRepairLinkText();
		productPage = subcategoryAppPage.clickSubCategoryDishwashersLinkText();
		Assert.assertTrue(productPage.verifyProductsDisplayed());	
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		productPage = loginPage.loginToHdSupplySiteFromProductPage(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		WaitTool.hardWait();
		Assert.assertTrue(homePage.getCategoryPageHeadingText().equalsIgnoreCase("Dishwashers"));
		loginPage.logoutOfApplication();
		Assert.assertFalse(homePage.getWelcomeNote().contains("Hi"));
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		appliances = homePage.clickCategoryAppliancesLinkText();
		subcategoryAppPage = appliances.clickTopCategoryDishwashersRepairLinkText();
		productPage = subcategoryAppPage.clickSubCategoryDishwashersLinkText();
		Assert.assertTrue(productPage.verifyProductsDisplayed());
		productDetailsPage = productPage.clickFirstProductInProductList();
		Assert.assertTrue(productDetailsPage.isDisplayedproductDetailsHeader());	

		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		WaitTool.hardWait();
		Assert.assertTrue(productDetailsPage.isDisplayedproductDetailsHeader());

	}

}
