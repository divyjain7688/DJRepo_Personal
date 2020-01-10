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

public class ViewCategoryProductsFromLeftNavigation_WORKING extends BaseClass{

	HomePage homePage;
	DBCon dbConnection;
	LoginPage loginPage;
	ProductPage productPage;
	ProductDetailsPage productDetailsPage;
	ArrayList<UsersListBean> usersList;	
	ProductListingPage productListingPage;

	@BeforeMethod	
	public void driverSetup() throws Exception {
		initialize();	
		dbConnection = new DBCon();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
	}

	/**
	 * To verify As a User I want to view the Top Level Category from left navigation,
	 * so I can select which  category of products I want to browse in the catalog to make a purchase. 
	 * @author lakshmi
	 * US- 241
	 */


	@Test
	public void verifyCategoryProductViewFromLeftNavigation() throws Exception
	{
		loginPage.clickShopByCategory();
		Assert.assertTrue(loginPage.isDisplayedShopByCategoryL1());
		loginPage.clickShopByCategory();
		productListingPage=loginPage.moveToSubCategoryPage();

	}

}
