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
import com.selenium.ebiz.pageobject.PaymentAndCheckOutPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.QuotesPage;
import com.selenium.ebiz.pageobject.SearchResultPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class ShoppingCartLinksButtons_WORKING extends BaseClass {

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	SearchResultPage searchResultPage;
	ProductDetailsPage productDetailsPage;
	MinicartPage miniCartPage;
	PaymentAndCheckOutPage paymentAndCheckoutPage;
	ArrayList<WebElement>shoppingCartListItems;
	ShoppingCartPage shoppingCartPage;
	ProductListingPage productListingPage;
	QuotesPage quotesPage;
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();


	@BeforeMethod	
	public void driverSetup() throws Exception {
		driver = initialize();		
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

	}

	/**
	 * Description : To verify As a user I want the ability to perform certain actions in the shopping cart
	 *  via links and buttons.
	 * @author lakshmi
	 * US-Ord-204
	 * */

	@Test
	public void verifyShoppingCartLinksButtons() throws Exception {

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
		System.out.println("counter value is "+ counter);
		/*productListingPage.clickonSecondProductAddToCart();
		productListingPage.clickOnCloseAddtocartSuccessPopup();
		productListingPage.refreshPage();
		counter = CommonFunctions.counterIncrease();
		System.out.println("counter value is "+ counter);*/
		homePage=productListingPage.clickOnHDSupplyLogoInHeader();
		shoppingCartPage= homePage.clickOnShoppingCartIcon();

		//links,buttons are displayed on the Shopping cart page
		Assert.assertTrue(shoppingCartPage.isDisplayedFooterTopLink());				
		Assert.assertTrue(shoppingCartPage.isDisplayedReturnPolicyLink());
		Assert.assertTrue(shoppingCartPage.isDisplayedSaveAsQuoteButton());
		Assert.assertTrue(shoppingCartPage.isDisplayedViewSavedQuotesLink());
		Assert.assertTrue(shoppingCartPage.isDisplayedEmptyCartLink());
		Assert.assertTrue(shoppingCartPage.isDisplayedCheckoutButton());

		shoppingCartPage.clickOnSaveAsQuoteButton();
		Assert.assertTrue(shoppingCartPage.isAddToQuoteModalDisplayed());
		shoppingCartPage.clickFirstExistingQuote();
		shoppingCartPage.clickAddToQuoteButtonOnQuoteModal();
		WaitTool.hardWait10sec();
		WaitTool.hardWait10sec();
		Assert.assertTrue(shoppingCartPage.isSuccessMessageAfterAddToQuoteDisplayed());
		shoppingCartPage.clickCloseButtonOnAddToQuoteSuccessMessage();
		Assert.assertTrue(shoppingCartPage.areThreeCheckOutButtonsDisplayed());
		shoppingCartPage.ClickEmptyCartLinkAndCancel();
		Assert.assertTrue(shoppingCartPage.areThreeCheckOutButtonsDisplayed());
		quotesPage =shoppingCartPage.clickOnViewSavedQuotesLink();
		CommonFunctions.navigateBack(driver);
		shoppingCartPage.clickOnReturnPolicyLink();
		Assert.assertTrue(shoppingCartPage.isReturnPolicyTextDisplayed());
		CommonFunctions.navigateBack(driver);
		shoppingCartPage.ClickTopLink();
		Assert.assertTrue(shoppingCartPage.isDisplayedShoppingCartPage());
		paymentAndCheckoutPage=shoppingCartPage.clickonCheckOutButton();

		/*	//verify that we have 3 checkout buttons in shopping cart page.
		Assert.assertEquals(shoppingCartPage.getNumberofCheckoutBtn(), 3);
		//verify a pop up is displayed when we click on empty cart.
		shoppingCartPage.ClickEmptyCartLink();
		WaitTool.hardWait();
		Thread.sleep(6000);			
		//shoppingCartPage.isDialogPresent(driver);
		//System.out.println("kjadfds");
		CommonFunctions.acceptPopupMessageBox(driver);
		//System.out.println(alert.getText());
		//verify click onsave as quote
		//shoppingCartPage.clickSaveasQuoteButton();

		//verify Authenticated user will be take to Final Pricing and Billing page
		paymentAndCheckoutPage=shoppingCartPage.clickonCheckOutButton();
		Assert.assertTrue(CommonFunctions.isElementPresent(paymentAndCheckoutPage.paymentAndCheckoutPageHeadingText));	

		//"Top" link - Takes user to the very top of the Shopping Cart page. 
		shoppingCartPage.ClickTopLink();
		Assert.assertTrue(shoppingCartPage.isDisplayedShoppingCartPage());*/
	}

}


