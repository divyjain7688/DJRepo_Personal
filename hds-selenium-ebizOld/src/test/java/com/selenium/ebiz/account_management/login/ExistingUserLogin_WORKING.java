package com.selenium.ebiz.account_management.login;

import java.util.ArrayList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.miscellaneousmethods.CommonTestMethods;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MinicartPage;
import com.selenium.ebiz.pageobject.OrderConfirmationPage;
import com.selenium.ebiz.pageobject.PaymentAndCheckOutPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.SavedListsPage;
import com.selenium.ebiz.pageobject.SearchPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.pageobject.SignInOrRegisterPage;
import com.selenium.ebiz.tools.WaitTool;

public class ExistingUserLogin_WORKING extends BaseClass {
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	HomePage homePage;
	LoginPage loginPage;
	SearchPage searchPage;
	ProductDetailsPage productDetailsPage;
	ProductListingPage productListingPage;
	MinicartPage miniCartPage;
	ShoppingCartPage shoppingCartPage;
	PaymentAndCheckOutPage paymentAndCheckOutPage;
	SavedListsPage savedListsPage;
	OrderConfirmationPage orderConfirmationPage;
	SignInOrRegisterPage signInOrRegisterPage;

	public String newListName;

	/*
	 * Launching of the Browser and login with Valid Credentials
	 */

	@BeforeMethod
	public void driverSetup() throws Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"),prop.getProperty("password"));
	}

	/*
	 * 103928 - Verify Merge Cart for Existing User Login from Header.
	 * User Login with Valid Credentials, clears the cart, adds two items to the cart and Logout.
	 * User adds item to cart as guest user, and login from shopping cart and proceeds to checkout
	 * 
	 */

	@Test
	public void verifyMergeCartForExistingUserLogIn() throws Exception {
		ShoppingCartPage shoppingCartPage = homePage.clickOnShoppingCartIcon();
		WaitTool.hardWait();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		} else {
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCartReturnsHomePage();
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		}

		usersList = dbConnection.loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		CommonTestMethods CommonTestMethods = new CommonTestMethods();
		homePage = CommonTestMethods.clickAddToCart(driver,usersList.get(0).getSearchProductPartNumber(), homePage);
		usersList = dbConnection.loadDataFromExcel("searchByPartNumberTest","Search");
		homePage = CommonTestMethods.clickAddToCart(driver, usersList.get(0).getSearchProductPartNumber(), homePage);
		homePage.logoutOfApplication();
		usersList = dbConnection.loadDataFromExcel("searchItemInL2CategoryGuestUserTest", "Search");
		homePage = CommonTestMethods.clickAddToCartGuestUser(driver, usersList.get(0).getSearchProductPartNumber(), homePage);
		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		/*	Assert.assertFalse(shoppingCartPage.isDisplayedShippingAddressText());
		Assert.assertFalse(shoppingCartPage.isDisplayedSourceCode());*/
		loginPage = shoppingCartPage.clickOnHDSupplyLogo();
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"),prop.getProperty("password"));
		/*	homePage.mouseHooverOnShoppingCartIcon();
		shoppingCartPage = homePage.clickViewCart();*/
		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		paymentAndCheckOutPage  = shoppingCartPage.clickShoppingCartCheckOutButton();
		paymentAndCheckOutPage.insertPONumber();
		orderConfirmationPage = paymentAndCheckOutPage.clickOnSubmitSecureOrder();
		String orderNumber = orderConfirmationPage.storeOrderNumber();
		System.out.println("orderNumber is "+ orderNumber);
	}
}
