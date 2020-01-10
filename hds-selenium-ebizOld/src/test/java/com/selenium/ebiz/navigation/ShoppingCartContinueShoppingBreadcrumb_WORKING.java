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
import com.selenium.ebiz.pageobject.MinicartPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;

public class ShoppingCartContinueShoppingBreadcrumb_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	ShoppingCartPage shoppingCartPage;
	MinicartPage minicartPage;

	@BeforeMethod
	public void driverSetup() throws Exception {
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());		
	}

	/**
	 * 
	 * @author Smitha
	 * 
	 * This test will verify about the Continue Shopping breadcrumb in Shop-Category Page 
	 * Click on breadcrumb should navigate back to HomePage
	 * 
	 * This TestScript is Mapped to the US-Ord-201
	 * 
	 * 
	 */

	@Test
	public void verifyShoppingCartContinueShoppingBreadcrumbTest() throws Exception 
	{
		shoppingCartPage = loginPage.clickShoppingCartIcon();
		Assert.assertTrue(shoppingCartPage.isDisplayedcontinueShoppingBreadCrumbLink());
		homePage = shoppingCartPage.ClickContinueShoppingBreadcrumbLink();

	}


}
