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
import com.selenium.ebiz.tools.WaitTool;


public class ForgotPasswordGuestUser_NOTWORKING  extends BaseClass {
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	HomePage homePage;
	LoginPage loginPage;
	AccountRetrievalPage accountRetrievalPage;


	@BeforeMethod
	public  void driverSetUp() throws MalformedURLException {
		driver = initialize();		
		loginPage = new LoginPage(driver);
	}

	/**
	 * This test cases will check the checkbox should be unselected and enter the email id to get the password
	 */
	@Test
	public void forgotPasswordonSignInUnauthenticatedUser() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("forgotPasswordonSignInUnauthenticatedUser", "LoginTestData"); 
		System.out.println("usersList.get(0).getEmailAddress()"+usersList.get(0).getEmailAddress());

		//Assert.assertTrue(homePage.getWelcomeNote().contains("Create an account"));
		Assert.assertTrue(loginPage.isDisplayedRegisterOrSignInLinkText());

		// Click on Register or sign in link
		loginPage.clickHeaderRegisterOrSignInLinkText();

		//Click "Forgot Username or Password" link on Sign In Page
		accountRetrievalPage =loginPage.clickForgotUsernameAndPasswordLinkText();

		//Verify that Account Retrieval page has form fields for Username and Email Address
		Assert.assertTrue(accountRetrievalPage.isDisplayedAccountRetrievalPageFormFields());
		WaitTool.hardWait();

		// checking the checkbox
		accountRetrievalPage.selectUserNameCheckbox();	
		WaitTool.hardWait();

		//Enter EmailID
		accountRetrievalPage.enterEmailAddress(usersList.get(0).getEmailAddress());
		// Getting the Attribute value of input of username
		String userName = accountRetrievalPage.getEmailUserNameAttribute();

		if (userName==null || userName=="" ){
			Assert.assertFalse(accountRetrievalPage.isEmailUserNameUnChecked());
		}
		//Select Submit
		accountRetrievalPage.clickSubmitButton();
		WaitTool.hardWait();

		//Verify the text on Account Retrieval Credentials Send Success Page
		accountRetrievalPage.AccountRetrievalCredentialsSendSuccesPage();
		Assert.assertTrue(accountRetrievalPage.AccountRetrievalCredentialsSendSuccesPage().contains("Your credentials have been sent to "));
		System.out.println(accountRetrievalPage.AccountRetrievalCredentialsSendSuccesPage());
	}


}














