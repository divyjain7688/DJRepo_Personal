package com.selenium.ebiz.account_management.my_account;

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

public class MyAccountsChangeEmailAddress_WORKING extends BaseClass{
	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();

	@BeforeMethod	
	public void driverSetup() throws Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("verifyLogin","LoginTestData");
		System.out.println("asdasd");
		loginPage.clickOnRegisterOrSignIn();
		homePage= loginPage.signInToApplication(usersList.get(0).getuserName(),usersList.get(0).getpassword());
		myAccountPage=homePage.moveToMyAccountPage();

	}

	/**
	 *@storyDescription :  To verify as As an authenticated user, I want to change my email address so that I can receive communications to the new address in the future.
	 * @US :US-Cat-470
	 * @author Lakshmi
	 * */

	@Test
	public void verifyMyAccountsChangeEmailAddress() throws Exception 
	{
		usersList = dbConnection.loadDataFromExcel("verifyMyAccountsPageLinks","MyAccount");
		String disaplyedOldEmailAddressValue = myAccountPage.disaplyedOldEmailAddressValue();
		myAccountPage.changeEmailAddress(usersList.get(0).getUpdateEmailAddress());
		Assert.assertEquals(myAccountPage.dispalyedUpdatedEmailAddress(),usersList.get(0).getUpdateEmailAddress());
		myAccountPage.revertEmailAddress(disaplyedOldEmailAddressValue);

	}

}
