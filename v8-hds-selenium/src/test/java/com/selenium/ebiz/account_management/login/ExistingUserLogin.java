package com.selenium.ebiz.account_management.login;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ExistingUserLogin extends BaseClassV8_ParallelGrid {

	private ArrayList<UsersListBean> usersList;
	String loginPartNo, guestPartNo;
	/*
	 * 103928 - Verify Merge Cart for Existing User Login from Header.
	 * User Login with Valid Credentials, clears the cart, adds two items to the cart and Logout.
	 * User adds item to cart as guest user, and login from shopping cart and proceeds to checkout
	 * 
	 */

	//Modified: Bhavani 08/29/19
	@Test(dataProvider = "browsers")
	public void login_verifyShippingAddressSourceCodeForMergeCartForExistingUserLogIn(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		String username = RandomAccountSelect.users.pop();
		Log.info("*************************UserName: "+username);
		pageManager.commonLogin().LoginToHDS(username, configread.getPassword());
		pageManager.shoppingCartPage().checkClearShoppingCart();
		
	    usersList=pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
	    Log.info(usersList.get(0).getSearchProductPartNumber());
	    loginPartNo = usersList.get(0).getSearchProductPartNumber();
	    pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
	    pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
		pageManager.productDetailsPage().clickAddToCartButton();
		
	    pageManager.homePage().clickOnHDSupplyLogoInHeader();
		pageManager.homePage().clickOnSignOutIcon();
		
		 usersList=pageManager.dBCon().loadDataFromExcel("searchByProductDesc","Search");
		 Log.info(usersList.get(0).getSearchProductKeyword());
	     pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
	     guestPartNo = pageManager.productListingPage().getFirstProductPartNumber();
	     pageManager.productListingPage().clickonFirstProductAddToCart();
	        
		pageManager.homePage().clickOnShoppingCartIcon();
		
		Assert.assertFalse(pageManager.shoppingCartPage().isDisplayedShippingAddressText());
		Assert.assertFalse(pageManager.shoppingCartPage().isDisplayedSourceCode());
		
	}
	
	@Test(dataProvider = "browsers")
	public void login_verifyMergeCartForExistingUserLogIn(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		String username = RandomAccountSelect.users.pop();
		Log.info(username);
		pageManager.commonLogin().LoginToHDS(username, configread.getPassword());
		pageManager.shoppingCartPage().checkClearShoppingCart();
		
	    usersList=pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
	    Log.info(usersList.get(0).getSearchProductPartNumber());
	    loginPartNo = usersList.get(0).getSearchProductPartNumber();
	    pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
	    pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
		pageManager.productDetailsPage().clickAddToCartButton();
		
	    pageManager.homePage().clickOnHDSupplyLogoInHeader();
		pageManager.homePage().clickOnSignOutIcon();
		
		 usersList=pageManager.dBCon().loadDataFromExcel("searchByProductDesc","Search");
		 Log.info(usersList.get(0).getSearchProductKeyword());
	     pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
	     guestPartNo = pageManager.productListingPage().getFirstProductPartNumber();
	     pageManager.productListingPage().clickonFirstProductAddToCart();
	        
		pageManager.homePage().clickOnShoppingCartIcon();
		
		pageManager.homePage().clickOnHDSupplyLogoInHeader();
		pageManager.commonLogin().LoginToHDS(username, configread.getPassword());
		
		pageManager.homePage().clickOnShoppingCartIcon();  
		
		Boolean isDisplayedLoginPartNo = pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(loginPartNo);
		Boolean isDisplayedGuestPartNo = pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(guestPartNo);

		pageManager.shoppingCartPage().clickShoppingCartCheckOutButton();
		pageManager.paymentAndCheckOutPage().insertPONumber();
		pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
		
		Assert.assertTrue(isDisplayedLoginPartNo);
		Assert.assertTrue(isDisplayedGuestPartNo);
	}
	
}
