package com.selenium.ebiz.account_management.login;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;

public class SeeMoreTopCategories_NOTWORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	HomePage homePage;
	LoginPage	loginPage;
	DBCon dbConnection;

	@BeforeMethod	
	public void driverSetup() throws Throwable {
		driver = initialize();		
		loginPage = new LoginPage(driver);
		dbConnection = new DBCon();	
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
	}

	/**
	 * Description :To verify the  most popular top categories in home page.
	 * @author lakshmi
	 * US-Cat-243
	 * */

	@Test
	public void verifySeeMoreOptionforTopCategories() throws Exception {
		Assert.assertTrue(homePage.getWelcomeNote().contains("Create an account"));

		// to verify see more categories.Webelement not visible currently

	}

}
