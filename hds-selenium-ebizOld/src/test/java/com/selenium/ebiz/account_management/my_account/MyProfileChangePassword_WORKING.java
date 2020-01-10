/*
 *  This Test Script changes the password in the profile
 *  
 *  This Script is mapped to US-Acct-480

 */package com.selenium.ebiz.account_management.my_account;

 import java.util.ArrayList;

 import org.testng.Assert;
 import org.testng.annotations.BeforeMethod;
 import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MyAccountPage;

 public class MyProfileChangePassword_WORKING extends BaseClass{
	 HomePage homePage;
	 DBCon dbConnection;
	 LoginPage loginPage;
	 MyAccountPage myAccountPage;
	 ArrayList<UsersListBean> usersList;

	 /*
	  *  Launching of the browser by entering Valid Credentials
	  */
	 @BeforeMethod	
	 public void driverSetup() throws Exception {
		 driver = initialize();		
		 dbConnection = new DBCon();
		 loginPage = new LoginPage(driver);
		 usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		 homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
	 }

	 /**
	  *@storyDescription :  To verify as As an authenticated user, I want to change my password.
	  * @US :US-Acct-480
	  * @author Suresh
	  * */

	 @Test
	 public void verifyMyProfileChangePassword() throws Exception {
		 usersList = dbConnection.loadDataFromExcel("verifyMyProfileChangePassword","MyAccount");
		 // Moves to the Account page and click on change password
		 myAccountPage=homePage.moveToMyAccountPage();
		 // Enters the old and new passwowrd
		 myAccountPage.changePassword(usersList.get(0).getOldPassword(),usersList.get(0).getNewPassword());
		 // Verifying that the password is changed
		 Assert.assertTrue(myAccountPage.getMyaccountWelcomeNote().contains("Thanks for being a loyal HD Supply customer"));
		 // Log out of the application
		 loginPage=myAccountPage.logoutFromMyAccount();
		 // Sign in to the application
		 loginPage.clickOnRegisterOrSignIn();
		 // Entering the new password
		 homePage=loginPage.signInToApplication(usersList.get(0).getUsername(),usersList.get(0).getNewPassword());
		 // Moves to the account page
		 myAccountPage=homePage.moveToMyAccountPage();
		 // Reverts back to the old password
		 myAccountPage.changePassword(usersList.get(0).getNewPassword(),usersList.get(0).getOldPassword());
		 // Verifying that the password is changed
		 Assert.assertTrue(myAccountPage.getMyaccountWelcomeNote().contains("Thanks for being a loyal HD Supply customer"));
		 // logout of the application
		 loginPage=myAccountPage.logoutFromMyAccount();
		 // Click on the Sign in
		 loginPage.clickOnRegisterOrSignIn();
		 // Entering with the changed password Credentials
		 homePage=loginPage.signInToApplication(usersList.get(0).getUsername(),usersList.get(0).getOldPassword());
		 //Validating the HomePage displayed or not by checking Hi text.
		 Assert.assertTrue(homePage.getWelcomeNote().contains("Hi"));
	 }

 }

