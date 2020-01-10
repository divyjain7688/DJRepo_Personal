package com.selenium.ebiz.account_management.login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.pageobject.LoginPage;

public class MostPopularTopCategoriesGuestUser_WORKING extends BaseClass{

	LoginPage loginPage;

	@BeforeMethod	
	public void driverSetup() throws Exception {
		driver = initialize();		
		loginPage = new LoginPage(driver);
	}

	/**
	 * Description :To verify the  most popular top categories in home page.
	 * @author lakshmi
	 * US-Cat-242
	 * */

	@Test
	public void verifyMostPopularTopCategories() throws Exception {
		Assert.assertTrue(loginPage.getTextCreateAnAccount().contains("Create an account"));

		// to verify most popular categories.Webelement not visible currently

	}

}
