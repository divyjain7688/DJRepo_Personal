

package com.selenium.ebiz.account_management.login;

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
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.pageobject.SignInOrRegisterPage;
import com.selenium.ebiz.tools.WaitTool;

public class ShopByCategorySelectSubCategoryGuestUser_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	ProductListingPage productListingPage;
	MinicartPage miniCartPage;
	ProductDetailsPage productDetailsPage;
	ShoppingCartPage shoppingCartPage;
	SignInOrRegisterPage signInOrRegisterPage;

	/**
	 * This method is used to load the property file, launch the browser, navigate to the URL(provided in property file), 
	 * logged in to website and navigate to Product Listing Page
	 */
	@BeforeMethod
	public void driverSetup() throws Exception
	{
		driver=initialize();
		loginPage = new LoginPage(driver);
		shoppingCartPage = loginPage.clickShoppingCartIcon();
		if(shoppingCartPage.isShoppingCartEmptyMessageDisplayed	()){
			loginPage = shoppingCartPage.clickOnHDSupplyLogo();
		}
		else
		{

			loginPage = shoppingCartPage.clearCartReturnsLoginPage();	
			//homePage = shoppingCartPage.clearCartReturnsHomePage();	
			shoppingCartPage.clearCartReturnsHomePage();
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		}
		WaitTool.hardWait();
		productListingPage=loginPage.moveToSubCategoryPage();

	}		

	/** 
	 *  104306 - Guest Shopping Login Modal Messages
	 */	
	@Test(priority=1)
	public void guestShoppingLoginModalMessages() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("loginWithInvalidUsernameTest", "LoginTestData");
		productListingPage.clickonFirstProductAddToCart();
		productListingPage.clickOnCloseAddtocartSuccessPopup();
		productListingPage.refreshPage();
		WaitTool.hardWait();
		shoppingCartPage =loginPage.clickShoppingCartIcon();
		signInOrRegisterPage = shoppingCartPage.clickOnShoppingCartCheckOutButton();
		signInOrRegisterPage.enterUserName(usersList.get(0).getuserName());
		signInOrRegisterPage.enterPassword(usersList.get(0).getpassword());
		signInOrRegisterPage.clickSignInButton();
		Assert.assertTrue(signInOrRegisterPage.isUserNamePasswordErrorMessageDisplayed());
	}

}
