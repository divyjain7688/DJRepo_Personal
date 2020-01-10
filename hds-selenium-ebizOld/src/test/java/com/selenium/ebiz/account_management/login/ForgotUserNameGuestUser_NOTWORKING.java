package com.selenium.ebiz.account_management.login;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.AccountRetrievalPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;

public class ForgotUserNameGuestUser_NOTWORKING  extends BaseClass {
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	HomePage homePage;
	LoginPage loginPage;
	AccountRetrievalPage AccountRetrievalPage;


	@BeforeMethod
	public  void driverSetUp() throws MalformedURLException {
		driver = initialize();		
		loginPage = new LoginPage(driver);
	}
	/*
	 * @author Neha Dev
	 * 
	 * launch the application in browser and Verify the homepage for Unauthenticated user
	 * 
	 * This Test Script is mapped to user stories US-Acct-620: Forgot User Name on Sign In Unauthenticated User
	 * 
	 */ 

	@Test
	public void ForgotUserNameonSignInUnauthenticatedUser() throws Exception {
		usersList = dbConnection.loadDataFromExcel("ForgotUserNameonSignInUnauthenticatedUser", "LoginTestData");
		//Assert.assertTrue(homePage.getWelcomeNote().contains("Create an account"));
		Assert.assertTrue(loginPage.isDisplayedRegisterOrSignInLinkText());
		loginPage.clickHeaderRegisterOrSignInLinkText();

		//Click "Forgot Username or Password" link on Sign In Page

		AccountRetrievalPage =loginPage.clickForgotUsernameAndPasswordLinkText();

		//Verify that Account Retrieval page has form fields for Username and Email Address

		Assert.assertTrue(AccountRetrievalPage.isDisplayedAccountRetrievalPage());

		//Enter EmailID
		AccountRetrievalPage.enterEmailAddress(usersList.get(0).getEmailAddress());

		//AccountRetrievalPage.clickSubmitButton();		    

		//Verify the text on Account Retrieval Credentials Send Success Page

		AccountRetrievalPage.AccountRetrievalCredentialsSendSuccesPage();

		Assert.assertTrue(AccountRetrievalPage.AccountRetrievalCredentialsSendSuccesPage().contains("Your credentials have been sent to "));

		System.out.println(AccountRetrievalPage.AccountRetrievalCredentialsSendSuccesPage());

	}

}













