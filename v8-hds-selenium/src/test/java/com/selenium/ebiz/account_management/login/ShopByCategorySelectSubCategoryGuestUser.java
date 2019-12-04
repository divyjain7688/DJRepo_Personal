package com.selenium.ebiz.account_management.login;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ShopByCategorySelectSubCategoryGuestUser extends BaseClassV8_ParallelGrid{
	private ArrayList<UsersListBean> usersList;


	/**
	 * This method is used to load the property file, launch the browser, navigate to the URL(provided in property file), 
	 * logged in to website and navigate to Product Listing Page
	 */

	/** 
	 *  104306 - Guest Shopping Login Modal Messages
	 */	

	@Test(description="guestShoppingLoginModalMessages", dataProvider = "browsers")
	public void login_guestShoppingLoginModalMessages(String browser, String version, String os, Method method) throws Exception 
	{	
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().checkClearShoppingCart();
		
		pageManager.homePage().moveToSubCategoryPage();
		pageManager.productListingPage().clickonFirstProductAddToCart();
		
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().clickShoppingCartCheckOutButtonAsGuestUser();
		
		usersList=pageManager.dBCon().loadDataFromExcel("loginWithInvalidUsernameTest","LoginTestData");
		pageManager.signInOrRegisterPage().enterUserName(usersList.get(0).getuserName());
		pageManager.signInOrRegisterPage().enterPassword(usersList.get(0).getpassword());
		pageManager.signInOrRegisterPage().clickSignInButton();
		
		Assert.assertTrue(pageManager.signInOrRegisterPage().isUserNamePasswordErrorMessageDisplayed());
	}

}
