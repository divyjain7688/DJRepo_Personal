package com.selenium.ebiz.add_to_cart;

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

public class MergeProductsAfterLogin_WORKING extends BaseClass {
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

	/**
	 *  104794 - Verify Merge Cart for Existing User Login from Header PeachTree Part
	  104789 - Verify Migrate Cart with Peach Tree Part for Existing User Login from Header
	 */
	@Test(priority=1)
	public void verifyMergeCartForPeachTreePartForExistingUserLogInFromHeader() throws Exception 
	{
		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		WaitTool.hardWait();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		} 
		else 
		{
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCart();
			homePage= shoppingCartPage.clickOnHDSupplyLogoInHeader();
		}
		WaitTool.hardWait();
		productListingPage=homePage.moveToSubCategoryPage();
		productListingPage.clickonFirstProductAddToCart();
		int counter = CommonFunctions.counterIncrease();
		System.out.println("counter is "+counter);
		productListingPage.clickOnCloseAddtocartSuccessPopup();
		productListingPage.refreshPage();
		productListingPage.clickonSecondProductAddToCart();
		counter = CommonFunctions.counterIncrease();
		System.out.println("counter is "+counter);
		productListingPage.clickOnCloseAddtocartSuccessPopup();
		productListingPage.refreshPage();
		//first peachtree product added to cart
		usersList = dbConnection.loadDataFromExcel("searchByFirstPeachTreePartNumber","Search");
		searchPage = homePage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage = searchPage.clickOnProduct();
		//productDetailsPage = homePage.searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		//	Assert.assertTrue(productDetailsPage.isPeachTreedTextIdisplayed());
		productDetailsPage.clickAddToCartButton();
		counter = CommonFunctions.counterIncrease();
		System.out.println("counter is "+counter);
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
		productDetailsPage.refreshPage();
		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		System.out.println("shoppingCartPage.displyedPartNumberText()" +    shoppingCartPage.displyedPartNumberText());
		homePage=shoppingCartPage.clickOnHDSupplyLogoInHeader();

		homePage.logoutOfApplication();	
		usersList = dbConnection.loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		System.out.println("usersList.get(0).getSearchProductPartNumber()"+usersList.get(0).getSearchProductPartNumber());
		String pnumber = usersList.get(0).getSearchProductPartNumber();
		/*searchPage = loginPage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage = searchPage.clickOnProduct();*/
		productDetailsPage = loginPage.searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage.clickAddToCartButton();
		counter = CommonFunctions.counterIncrease();
		System.out.println("counter is "+counter);
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
		productListingPage.refreshPage();
		shoppingCartPage = loginPage.clickShoppingCartIcon();
		System.out.println("shoppingCartPage.displyedPartNumberText()" +    shoppingCartPage.displyedPartNumberText());
		WaitTool.hardWait();
		/*Assert.assertFalse(shoppingCartPage.isDisplayedShippingAddressText());
		Assert.assertFalse(shoppingCartPage.isDisplayedSourceCode());*/
		loginPage=shoppingCartPage.clickOnHDSupplyLogo();
		WaitTool.hardWait();
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"),prop.getProperty("password"));
		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		System.out.println("shoppingCartPage.displyedPartNumberText()" +    shoppingCartPage.displyedPartNumberText());
		Assert.assertEquals(shoppingCartPage.displyedPartNumberText(), counter);
		paymentAndCheckOutPage  = shoppingCartPage.clickShoppingCartCheckOutButton();
		paymentAndCheckOutPage.insertPONumber();
		orderConfirmationPage = paymentAndCheckOutPage.clickOnSubmitSecureOrder();
		String orderNumber = orderConfirmationPage.storeOrderNumber();
		System.out.println("orderNumber is "+ orderNumber);
	}

	/**
	 * 104791 - Verify Merge Cart for Existing User Login from Login Modal PeachTree Part
	 */
	@Test(priority=2)
	public void verifyMergeCartForPeachTreePartForExistingUserLogInFromLoginModal() throws Exception 
	{
		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		WaitTool.hardWait();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		} 
		else 
		{
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCart();
			homePage= shoppingCartPage.clickOnHDSupplyLogoInHeader();
		}
		WaitTool.hardWait();
		productListingPage=homePage.moveToSubCategoryPage();
		productListingPage.clickonFirstProductAddToCart();
		int counter = CommonFunctions.counterIncrease();
		System.out.println("counter is "+counter);
		productListingPage.clickOnCloseAddtocartSuccessPopup();
		productListingPage.refreshPage();
		productListingPage.clickonSecondProductAddToCart();
		counter = CommonFunctions.counterIncrease();
		System.out.println("counter is "+counter);
		productListingPage.clickOnCloseAddtocartSuccessPopup();
		productListingPage.refreshPage();

		//Adding first peachtree part to the cart
		usersList = dbConnection.loadDataFromExcel("searchByFirstPeachTreePartNumber","Search");
		searchPage = homePage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage = searchPage.clickOnProduct();
		//productDetailsPage = homePage.searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		//	Assert.assertTrue(productDetailsPage.isPeachTreedTextIdisplayed());
		productDetailsPage.clickAddToCartButton();
		counter = CommonFunctions.counterIncrease();
		System.out.println("counter is "+counter);
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
		productDetailsPage.refreshPage();
		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		System.out.println("shoppingCartPage.displyedPartNumberText()" +    shoppingCartPage.displyedPartNumberText());
		homePage=shoppingCartPage.clickOnHDSupplyLogoInHeader();
		homePage.logoutOfApplication();			
		usersList = dbConnection.loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		System.out.println("usersList.get(0).getSearchProductPartNumber()"+usersList.get(0).getSearchProductPartNumber());
		String pnumber = usersList.get(0).getSearchProductPartNumber();
		/*searchPage = loginPage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage = searchPage.clickOnProduct();*/
		productDetailsPage = loginPage.searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage.clickAddToCartButton();
		counter = CommonFunctions.counterIncrease();
		System.out.println("counter is "+counter);
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
		productDetailsPage.refreshPage();
		shoppingCartPage = loginPage.clickShoppingCartIcon();
		WaitTool.hardWait();
		System.out.println("shoppingCartPage.displyedPartNumberText()"+shoppingCartPage.displyedPartNumberText());
		Assert.assertFalse(shoppingCartPage.isDisplayedShippingAddressText());
		Assert.assertFalse(shoppingCartPage.isDisplayedSourceCode());
		loginPage=shoppingCartPage.clickOnHDSupplyLogo();
		WaitTool.hardWait();

		//Adding second peachtree part to the cart
		usersList = dbConnection.loadDataFromExcel("searchBySecondPeachTreePartNumber","Search");
		searchPage = loginPage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage = searchPage.clickOnProduct();
		//productDetailsPage = loginPage.searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		//	Assert.assertTrue(productDetailsPage.isPeachTreedTextIdisplayed());
		productDetailsPage.clickAddToCartButton();
		counter = CommonFunctions.counterIncrease();
		System.out.println("counter is "+counter);
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
		productDetailsPage.refreshPage();

		shoppingCartPage=productDetailsPage.clickOnShoppingCartIcon();
		System.out.println("shoppingCartPage.displyedPartNumberText()"+shoppingCartPage.displyedPartNumberText());
		signInOrRegisterPage =  shoppingCartPage.clickShoppingCartCheckOutButtonAsGuestUser();
		signInOrRegisterPage.enterUserName(prop.getProperty("username"));
		signInOrRegisterPage.enterPassword(prop.getProperty("password"));
		signInOrRegisterPage.clickSignInButton();
		System.out.println("shoppingCartPage.displyedPartNumberText()"+shoppingCartPage.displyedPartNumberText());
		System.out.println("counter is "+counter);
		Assert.assertEquals(shoppingCartPage.displyedPartNumberText(), counter);
		paymentAndCheckOutPage  = shoppingCartPage.clickShoppingCartCheckOutButton();
		paymentAndCheckOutPage.insertPONumber();
		orderConfirmationPage = paymentAndCheckOutPage.clickOnSubmitSecureOrder();
		String orderNumber = orderConfirmationPage.storeOrderNumber();
		System.out.println("orderNumber is "+ orderNumber);
	}




	/**
	 * 103940 - Verify Merge Cart for Existing User Login from Login Modal
	 */
	//@Test(priority=3)
	public void verifyMergeCartForExistingUserLogInFromLoginModal() throws Exception 
	{
		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		WaitTool.hardWait();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		} 
		else 
		{
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCart();
			homePage= shoppingCartPage.clickOnHDSupplyLogoInHeader();
		}
		WaitTool.hardWait();
		productListingPage=homePage.moveToSubCategoryPage();
		productListingPage.clickonFirstProductAddToCart();
		int counter = CommonFunctions.counterIncrease();
		System.out.println("counter is "+counter);
		productListingPage.clickOnCloseAddtocartSuccessPopup();
		productListingPage.refreshPage();
		homePage.logoutOfApplication();			
		usersList = dbConnection.loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		System.out.println("usersList.get(0).getSearchProductPartNumber()"+usersList.get(0).getSearchProductPartNumber());
		String pnumber = usersList.get(0).getSearchProductPartNumber();
		/*searchPage = loginPage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage = searchPage.clickOnProduct();*/
		productDetailsPage = loginPage.searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage.clickAddToCartButton();
		counter = CommonFunctions.counterIncrease();
		System.out.println("counter is "+counter);
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
		productDetailsPage.refreshPage();
		shoppingCartPage = loginPage.clickShoppingCartIcon();

		signInOrRegisterPage =  shoppingCartPage.clickShoppingCartCheckOutButtonAsGuestUser();
		signInOrRegisterPage.enterUserName(prop.getProperty("username"));
		signInOrRegisterPage.enterPassword(prop.getProperty("password"));
		signInOrRegisterPage.clickSignInButton();
		Assert.assertEquals(shoppingCartPage.displyedPartNumberText(), counter);
		paymentAndCheckOutPage  = shoppingCartPage.clickShoppingCartCheckOutButton();
		paymentAndCheckOutPage.insertPONumber();
		orderConfirmationPage = paymentAndCheckOutPage.clickOnSubmitSecureOrder();
		String orderNumber = orderConfirmationPage.storeOrderNumber();
		System.out.println("orderNumber is "+ orderNumber);

	}


}
