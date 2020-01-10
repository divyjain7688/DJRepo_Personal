package com.selenium.ebiz.navigation;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.ProductPage;

public class ViewCategoryProductsFromTopCategories_WORKING extends BaseClass{

	HomePage homePage;
	DBCon dbConnection;
	LoginPage loginPage;
	ProductPage productPage;
	ProductDetailsPage productDetailsPage;
	ProductListingPage productListingPage;
	ArrayList<UsersListBean> usersList;	


	@BeforeMethod	
	public void driverSetup() throws Exception 
	{
		initialize();	
		dbConnection = new DBCon();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
	}

	/**
	 * To verify As a User I want to view the Top Level Category page,
	 * so I can select which  category of products I want to browse in the catalog to make a purchase. 
	 * @autor Lakshmi
	 * US- 240
	 */

	@Test
	public void verifyCategoryProductViewFromTopCategory() throws Exception 
	{
		loginPage.clickHeaderHDLogoImage();
		loginPage.isDisplayedLeftNavigation();
		loginPage.clickOnFirstCategoryInleftNavigationImage();
		Assert.assertTrue(loginPage.isAppliancesTextDisplayed());

	}


}
