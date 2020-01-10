package com.selenium.ebiz.check_out;

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
import com.selenium.ebiz.pageobject.OrderConfirmationPage;
import com.selenium.ebiz.pageobject.PaymentAndCheckOutPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.SearchResultPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.pageobject.SignInOrRegisterPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.CommonFunctions;


public class GuestUserCheckout extends BaseClass {
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	HomePage homePage;
	Appliances appliances;
	SubCategoryAppliancesPage subCategoryAppliancesPage;
	CommonFunctions commonFunctions;
	SearchResultPage searchResultPage;
	ProductListingPage productListingPage;
	LoginPage loginPage;
	ProductDetailsPage productDetailsPage;
	ShoppingCartPage shoppingCartPage;
	SignInOrRegisterPage signInOrRegisterPage;
	PaymentAndCheckOutPage paymentAndCheckOutPage;
	OrderConfirmationPage orderConfirmationPage;

	@BeforeMethod    
	public void driverSetup() throws MalformedURLException {
		initialize();        
		homePage = new HomePage(driver);
		commonFunctions = new CommonFunctions();
		loginPage = new LoginPage(driver);

	}

	/**Author : Sandhya
	 * Unauthenticated User Sign In for Checkout 
	 * 
	 * 
	 * US-Acct-570
	 * 
	 * */

	public void verifySubCategoryPageGridView() 
	{
		Boolean flag = productListingPage.isGridViewDisplayed();
		Assert.assertTrue(flag);
	}

	@Test
	public void verifyGuestUserCheckout() throws Exception {
		usersList = dbConnection.loadDataFromExcel("verifyLogin","LoginTestData");
		productListingPage=loginPage.moveToSubCategoryPage();    
		productListingPage.clickonFirstProductAddToCart();
		productListingPage.clickOnCloseAddtocartSuccessPopup();
		productListingPage.refreshPage();
		shoppingCartPage = loginPage.clickShoppingCartIcon();

		signInOrRegisterPage =  shoppingCartPage.clickShoppingCartCheckOutButtonAsGuestUser();
		signInOrRegisterPage.enterUserName(prop.getProperty("username"));
		signInOrRegisterPage.enterPassword(prop.getProperty("password"));
		signInOrRegisterPage.clickSignInButton();  
		paymentAndCheckOutPage  = shoppingCartPage.clickShoppingCartCheckOutButton();
		paymentAndCheckOutPage.insertPONumber();
		orderConfirmationPage = paymentAndCheckOutPage.clickOnSubmitSecureOrder();
		String orderNumber = orderConfirmationPage.storeOrderNumber();
		System.out.println("orderNumber is "+ orderNumber);

	}

}