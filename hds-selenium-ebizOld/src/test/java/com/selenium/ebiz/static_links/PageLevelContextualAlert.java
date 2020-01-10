package com.selenium.ebiz.static_links;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;

/**
 * 
 * @author Neha
 * US-Acct-343 - Page Level Alert -> Contextual Alert
 * User must have already registered and created a user name and password with HD Supply.
 * 
 * 
 */	

public class PageLevelContextualAlert extends BaseClass{

	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;

	//launch the application in chrome browser then login with inValid password  
	@BeforeMethod
	public void driverSetup() throws MalformedURLException {
		driver=initialize();
		loginPage = new LoginPage(driver);
	}

	/*
	 * Verify the Page Level Alert
	 * 
	 */

	@Test(priority=0)

	public void verifyPageLevelAlertForInvalidPassword() throws Exception {

		usersList =dbConnection.loadDataFromExcel("loginWithIncorrectPasswordTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		// Validating the HomePage displayed or not, by checking Hi text.
		System.out.println( homePage.returnWelcomeNote());	
		Assert.assertFalse(homePage.getWelcomeNote().contains("Hi")); 
		Thread.sleep(5000);	

		String actual_message = loginPage.invalidUserNameOrPasswordMessageText();
		String expected_Message= "Either the logon ID or the password entered is incorrect. Enter the information again.";

		//Assert.assertEquals(expected_Message, expected_Message);

		Assert.assertTrue("Fail, Actual and Expected message are different", actual_message.contains(expected_Message));	 		 		
		System.out.println("Pass, Actual and Expected error message are same");

	} 
	/**
	 * 
	 * 
	 * launch the application in chrome browser and login with Invalid username and valid password
	 * 
	 */

	@Test(priority=1)
	public void verifyPageLevelAlertForInvalidUserId() throws Throwable {
		usersList = dbConnection.loadDataFromExcel("loginWithInvalidUsernameTest", "LoginTestData");
		homePage =loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		// Validating the HomePage displayed or not by checking Hi text.

		//Assert.assertFalse(homePage.getWelcomeNote().contains("Hi")); 
		String Actual_Message = loginPage.invalidUserNameOrPasswordMessageText();
		String Expected_Message = "Either the logon ID or the password entered is incorrect. Enter the information again.";

		Assert.assertTrue("Fail, Actual and Expected message are different", Actual_Message.contains(Expected_Message));
		System.out.println("Pass, Actual and Expected error message are same");
	}

	/**

	 * launch the application in chrome browser and login with Empty username and Valid password
	 * 
	 */

	@Test(priority = 2)
	public void loginWithEmptyUserNameTest() throws Exception {	
		usersList = dbConnection.loadDataFromExcel("loginWithEmptyUsernameTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		// Validating the HomePage displayed or not by checking Hi text.
		System.out.println( homePage.returnWelcomeNote());	
		Assert.assertFalse(homePage.getWelcomeNote().contains("Hi")); 

		String Actual_Message = loginPage.emptyUserNameMessageText();
		String Expected_Message = "Please type a valid usernam";

		Assert.assertTrue("Fail, Actual and Expected message are different", Actual_Message.contains(Expected_Message));
		System.out.println("Pass, Actual and Expected error message are same");
	}


	/**
	 * 

	 * launch the application in chrome browser and login with valid username and empty password
	 * 
	 */

	@Test(priority = 3)
	public void loginWithEmptyPasswordTest() throws Exception {	
		usersList = dbConnection.loadDataFromExcel("loginWithEmptyPasswordTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		// Validating the HomePage displayed or not by checking Hi text.
		System.out.println( homePage.returnWelcomeNote());	
		Assert.assertFalse(homePage.getWelcomeNote().contains("Hi")); 

		String Actual_Message = loginPage.invalidUserNameOrPasswordMessageText();
		String Expected_Message = "Please type a valid password";

		Assert.assertTrue("Fail, Actual and Expected message are different", Actual_Message.contains(Expected_Message));
		System.out.println("Pass, Actual and Expected error message are same");
	}

}

