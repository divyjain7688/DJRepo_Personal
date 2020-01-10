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

public class SalesRepInfoLoggedInUser_NOTWORKING extends BaseClass{

	HomePage homePage;
	LoginPage loginPage;
	DBCon dbConnection;
	ArrayList<UsersListBean> usersList;	


	@BeforeMethod	
	public void driverSetup() throws Exception {
		driver = initialize();		
		loginPage = new LoginPage(driver);
		dbConnection = new DBCon();	
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
	}

	/**
	 * Description :To verify As an Authenticated User I want to see my Sales Rep Image and Contact information in the Account Highlights 
	 * @author lakshmi
	 * US-Cat-236
	 * */

	@Test
	public void verifySalesRepInformation() throws Exception {
		System.out.println("!!!!!!!!!!");
		//Assert.assertTrue(homePage.getWelcomeNote().contains("Hi"));
		System.out.println("2222222222222");
		Assert.assertTrue(homePage.isSalesRepImageOnHeaderDisplayed());
		System.out.println("3333333333333333");
		Assert.assertTrue(homePage.salesRepInformationOnHeaderDisplayed());
		System.out.println("44444444444");
		Assert.assertTrue(homePage.isSalesRepImageDisplayed());
		System.out.println("5555555555555");
		Assert.assertTrue(homePage.isSalesRepNumberDisplayed());
		System.out.println("66666666666666");
		Assert.assertTrue(homePage.isSalesRepNameDisplayed());
		System.out.println("777777777777");
	}

}
