package com.selenium.ebiz.add_to_cart;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MinicartPage;
import com.selenium.ebiz.pageobject.MyAccountPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.ProductPage;
import com.selenium.ebiz.pageobject.SearchResultPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class ShoppingCartDeliveryDatesAvailableProducts_WORKING extends BaseClass{

	HomePage homePage;
	DBCon dbConnection;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	SearchResultPage searchResultPage;
	ProductDetailsPage productDetailsPage;
	MinicartPage miniCartPage;
	ArrayList<UsersListBean> usersList;
	ArrayList<WebElement>shoppingCartListItems;
	ShoppingCartPage shoppingCartPage;
	ProductPage productPage;
	ProductListingPage productListingPage;

	@BeforeMethod	
	public void driverSetup() throws Exception {
		driver = initialize();		
		dbConnection = new DBCon();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

	}

	/**
	 *@storyDescription :  To verify As a user I want my defaut shipping address to appear on the Shopping Cart page
	 *@US :US-Ord-202
	 *@author Lakshmi
	 * */

	@Test
	public void verifyShoppingCartDeliveryDatesAvailableProducts() throws Exception {


		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		WaitTool.hardWait();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		} else {
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCartReturnsHomePage();
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		}
		WaitTool.hardWait();
		productListingPage = homePage.moveToSubCategoryPage();
		productListingPage.clickonFirstProductAddToCart();
		productListingPage.clickOnCloseAddtocartSuccessPopup();
		productListingPage.refreshPage();
		int counter = CommonFunctions.counterIncrease();
		productListingPage.clickonSecondProductAddToCart();
		productListingPage.clickOnCloseAddtocartSuccessPopup();
		counter = CommonFunctions.counterIncrease();
		homePage=productListingPage.clickOnHDSupplyLogoInHeader();
		shoppingCartPage= homePage.clickOnShoppingCartIcon();
		Assert.assertTrue(shoppingCartPage.isDeliverDatesSorted());
		int pnumber = shoppingCartPage.displyedPartNumberText();
		Assert.assertEquals(pnumber, counter);
		int qstepper = shoppingCartPage.displayedQuantityStepperText();
		Assert.assertEquals(qstepper, counter);
		int prodprice = shoppingCartPage.displayedProductPriceText();
		Assert.assertEquals(prodprice, counter);	
		int addToList = shoppingCartPage.isAddToListButtonDisplayed();
		Assert.assertEquals(addToList, counter);
		int addToQuote = shoppingCartPage.isAddToQuoteButtonDisplayed();
		Assert.assertEquals(addToQuote, counter);

	}

}

