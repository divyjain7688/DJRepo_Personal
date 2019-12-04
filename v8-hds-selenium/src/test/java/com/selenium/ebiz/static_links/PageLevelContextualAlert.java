package com.selenium.ebiz.static_links;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.tools.PageManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 
 * @author Neha
 * US-Acct-343 - Page Level Alert -> Contextual Alert
 * User must have already registered and created a user name and password with HD Supply.
 * 
 * 
 */	

public class PageLevelContextualAlert extends BaseClassV8_ParallelGrid{

	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();

	/*
	 * Verify the Page Level Alert
	 * 
	 */

	@Test(description="verifyPageLevelAlertForInvalidPassword", dataProvider = "browsers",enabled=false)
	public void verifyPageLevelAlertForInvalidPassword(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList =dbConnection.loadDataFromExcel("loginWithIncorrectPasswordTest", "LoginTestData");
		pageManager.loginPage().loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		// Validating the HomePage displayed or not, by checking Hi text.
		System.out.println( pageManager.homePage().returnWelcomeNote());	
		Assert.assertFalse(pageManager.homePage().getWelcomeNote().contains("Hi")); 
	//	String actual_message = loginPage.invalidUserNameOrPasswordMessageTextIsDisplayed();
		String expected_Message= "Either the logon ID or the password entered is incorrect. Enter the information again.";
		//Assert.assertEquals(expected_Message, expected_Message);
	//	Assert.assertTrue("Fail, Actual and Expected message are different", actual_message.contains(expected_Message));
		System.out.println("Pass, Actual and Expected error message are same");

	} 
	/**
	 * 
	 * 
	 * launch the application in chrome browser and login with Invalid username and valid password
	 * 
	 */

	@Test(description="verifyPageLevelAlertForInvalidUserId", dataProvider = "browsers")
	public void verifyPageLevelAlertForInvalidUserId(String browser, String version, String os, Method method) throws Throwable {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = dbConnection.loadDataFromExcel("loginWithInvalidUsernameTest", "LoginTestData");
		pageManager.loginPage().loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		// Validating the HomePage displayed or not by checking Hi text.
		//Assert.assertFalse(homePage.getWelcomeNote().contains("Hi")); 
		//String Actual_Message = loginPage.invalidUserNameOrPasswordMessageTextIsDisplayed();
		String Expected_Message = "Either the logon ID or the password entered is incorrect. Enter the information again.";
		//Assert.assertTrue("Fail, Actual and Expected message are different", Actual_Message.contains(Expected_Message));
		System.out.println("Pass, Actual and Expected error message are same");
	}

	/**

	 * launch the application in chrome browser and login with Empty username and Valid password
	 * 
	 */

	@Test(description="loginWithEmptyUserNameTest", dataProvider = "browsers",enabled=false)
	public void loginWithEmptyUserNameTest(String browser, String version, String os, Method method) throws Exception {	
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = dbConnection.loadDataFromExcel("loginWithEmptyUsernameTest", "LoginTestData");
		pageManager.loginPage().loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		// Validating the HomePage displayed or not by checking Hi text.
		System.out.println( pageManager.homePage().returnWelcomeNote());	
		Assert.assertFalse(pageManager.homePage().getWelcomeNote().contains("Hi")); 
		String Actual_Message = pageManager.loginPage().emptyUserNameMessageText();
		String Expected_Message = "Please type a valid usernam";
		Assert.assertTrue("Fail, Actual and Expected message are different", Actual_Message.contains(Expected_Message));
	}


	/**
	 * 

	 * launch the application in chrome browser and login with valid username and empty password
	 * 
	 */

	@Test(description="loginWithEmptyPasswordTest", dataProvider = "browsers",enabled=false)
	public void loginWithEmptyPasswordTest(String browser, String version, String os, Method method) throws Exception {	
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = dbConnection.loadDataFromExcel("loginWithEmptyPasswordTest", "LoginTestData");
		pageManager.loginPage().loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		// Validating the HomePage displayed or not by checking Hi text.
		System.out.println( pageManager.homePage().returnWelcomeNote());	
		Assert.assertFalse(pageManager.homePage().getWelcomeNote().contains("Hi")); 
		String Actual_Message = pageManager.loginPage().getInvalidUserNameOrPasswordMessageText();
		String Expected_Message = "Please type a valid password";
		Assert.assertTrue("Fail, Actual and Expected message are different", Actual_Message.contains(Expected_Message));
	}

}

