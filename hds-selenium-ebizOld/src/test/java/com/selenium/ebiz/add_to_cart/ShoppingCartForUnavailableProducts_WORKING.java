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
import com.selenium.ebiz.pageobject.SearchPage;
import com.selenium.ebiz.pageobject.SearchResultPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class ShoppingCartForUnavailableProducts_WORKING extends BaseClass {

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	SearchResultPage searchResultPage;
	ProductDetailsPage productDetailsPage;
	MinicartPage miniCartPage;
	ArrayList<WebElement>shoppingCartListItems;
	ShoppingCartPage shoppingCartPage;
	ProductPage productPage;
	ProductListingPage productListingPage;
	SearchPage searchPage;
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();

	@BeforeMethod	
	public void driverSetup() throws Exception {
		driver = initialize();		
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

	}

	/*
	 *@storyDescription :  To verify As a user I want to know if there are items in my shopping cart that are unavailable.
	 *@US :US-Ord-203
	 *@author Lakshmi
	 */

	@Test
	public void verifyShoppingCartForUnavailableProducts() throws Exception {

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


		usersList = dbConnection.loadDataFromExcel("searchForUnavailableProduct","Search");
		searchPage= homePage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		productDetailsPage = searchPage.clickFirstProductInProductList();
		productDetailsPage.clickAddToCartButton();
		WaitTool.hardWait();
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
		productDetailsPage.refreshPage();
		int counter = CommonFunctions.counterIncrease();
		System.out.println("counter is"+ counter);
		shoppingCartPage=productDetailsPage.clickOnShoppingCartIcon();

		int pnumber = shoppingCartPage.displyedPartNumberText();
		System.out.println("pnumber is"+ pnumber);
		Assert.assertEquals(pnumber, counter);

		int qstepper = shoppingCartPage.displayedQuantityStepperText();
		System.out.println("qstepper is"+ qstepper);
		Assert.assertEquals(qstepper, counter);

		int prodprice = shoppingCartPage.displayedProductPriceText();
		System.out.println("prodprice is"+ prodprice);
		Assert.assertEquals(prodprice, counter);

		int addToList = shoppingCartPage.isAddToListButtonDisplayed();
		System.out.println("addToList is"+ addToList);
		Assert.assertEquals(addToList, counter);

	}


}


