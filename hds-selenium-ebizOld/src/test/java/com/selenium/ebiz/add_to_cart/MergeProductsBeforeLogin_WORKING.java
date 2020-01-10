package com.selenium.ebiz.add_to_cart;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
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
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class MergeProductsBeforeLogin_WORKING extends BaseClass{
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

	@BeforeTest()
	public void driverSetup() throws Exception 
	{
		driver = initialize();
		loginPage = new LoginPage(driver);
	}

	/**
	 * 103995 - Verify Migrate Cart for Existing User Login from Header
	 */

	@Test(priority=1)
	public void verifyMergeCartBeforeLoginInFromHeader() throws Exception 
	{
		shoppingCartPage = loginPage.clickShoppingCartIcon();
		WaitTool.hardWait();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			loginPage = shoppingCartPage.clickOnHDSupplyLogo();
		} 
		else 
		{
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCart();
			loginPage= shoppingCartPage.clickOnHDSupplyLogo();
		}
		WaitTool.hardWait();
		usersList = dbConnection.loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		System.out.println("usersList.get(0).getSearchProductPartNumber()"+usersList.get(0).getSearchProductPartNumber());
		/*searchPage = loginPage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage = searchPage.clickOnProduct();*/
		productDetailsPage= loginPage.searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage.clickAddToCartButton();
		int counter = CommonFunctions.counterIncrease();
		System.out.println("counter is "+counter);
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
		productDetailsPage.refreshPage();
		shoppingCartPage = loginPage.clickShoppingCartIcon();
		System.out.println("shoppingCartPage.displyedPartNumberText()" +    shoppingCartPage.displyedPartNumberText());
		Assert.assertEquals(shoppingCartPage.displyedPartNumberText(), counter);
		Assert.assertFalse(shoppingCartPage.isDisplayedShippingAddressText());
		Assert.assertFalse(shoppingCartPage.isDisplayedSourceCode());
		loginPage=shoppingCartPage.clickOnHDSupplyLogo();
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"),prop.getProperty("password"));
		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		System.out.println("shoppingCartPage.displyedPartNumberText()" +    shoppingCartPage.displyedPartNumberText());
		Assert.assertEquals(shoppingCartPage.displyedPartNumberText(), counter);
		shoppingCartPage.insertSourceCode();
		paymentAndCheckOutPage  = shoppingCartPage.clickShoppingCartCheckOutButton();
		paymentAndCheckOutPage.insertPONumber();
		orderConfirmationPage = paymentAndCheckOutPage.clickOnSubmitSecureOrder();
		String orderNumber = orderConfirmationPage.storeOrderNumber();
		System.out.println("orderNumber is "+ orderNumber);
	}
}
