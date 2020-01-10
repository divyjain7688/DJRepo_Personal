package com.selenium.ebiz.account_management.my_account;


import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.tools.WaitTool;

public class DisplayCookiedHomePageforReturningGuestUser_WORKING extends BaseClass

{
	HomePage homePage;
	LoginPage loginPage;

	@BeforeMethod
	public void DriverSetUp() throws MalformedURLException, Exception 
	{
		// Enter HD Supply site URL
		driver = initialize();

		// Enter you credentials and Login
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"),prop.getProperty("password")); 

	}

	/**
	 * 
	 * @author Neha
	 * Display Cookied Home Page for Returning Guest User
	 * This Test script is mapped to US-Cat-210
	 * 
	 **/	

	@Test
	public void DisplayCookieHomePageforReturningGuestUser() throws Exception{

		// Verify that HD supply login page isDisplayed
		WaitTool.hardWait();
		System.out.println( homePage.getWelcomeNote());	
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); // Validating the HomePage displayed or not by checking Hello text.
		WaitTool.hardWait();

		// Click on Logout button on top of the page
		loginPage.logoutOfApplication();
		Assert.assertTrue(homePage.isDisplayedRegisterOrSignIn());

		// Verify that user sees cookied Home page
		Assert.assertTrue(homePage.getWelcomeNote().contains("Welcome Back"));

		// Verify that My Account Highlights section is displayed
		Assert.assertTrue(homePage.isDisplayedQuotesLinkTextOnAccountHighlites());
		Assert.assertTrue(homePage.isDisplayedSavedListsLinkTextOnAccountHighlites());
		Assert.assertTrue(homePage.isDisplayedFrequentOrdersLinkTextOnAccountHighlites());
		Assert.assertTrue(homePage.isDisplayedOrderHistoryLinkTextOnAccountHighlites());

	}

}	








