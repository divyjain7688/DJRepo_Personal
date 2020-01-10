package com.selenium.ebiz.order_history;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MyAccountPage;
import com.selenium.ebiz.pageobject.OrderHistoryAndStatusPage;

public class OrderHistoryAndStatusAuthenticatedUser_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	OrderHistoryAndStatusPage orderHistoryAndStatusPage;

	/**
	 * This test is used to verify that when user logged in and click on my account link,
	 * user should able to navigate to My account page.
	 */
	@BeforeMethod
	public void driverSetup() throws Exception
	{
		driver=initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("verifyLogin","LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		//loginPage.clickOnRegisterOrSignIn();
		//homePage= loginPage.signInToApplication(usersList.get(0).getuserName(),usersList.get(0).getpassword());

	}

	/*	Breadcrumb is not updated when user click on any link from my account.
	Addressed the same to malachi in jira and waiting for confirmation.Also W80-1784 
	raised for the same issue.*/
	/**
	 * US-PostOrd-003 - This test is to verify that when user navigate to order history page, 
	 * user should be able to see title, breadcrumb and also user should be navigate from breadcrumb.
	 * @throws Exception 
	 */
	@Test
	public void verifyOrderHistoryBreadcrumAndtitle() throws Exception 
	{
		myAccountPage=homePage.moveToMyAccountPage();
		orderHistoryAndStatusPage=myAccountPage.moveToOrderHistoryAndStatusPage();
		Assert.assertTrue(orderHistoryAndStatusPage.isBreadcrumbDisplayed());
		Assert.assertTrue(orderHistoryAndStatusPage.isPageTitleOrdersDisplayed());
		homePage = orderHistoryAndStatusPage.navigateToHomePage();
		myAccountPage=homePage.moveToMyAccountPage();
		orderHistoryAndStatusPage=myAccountPage.moveToOrderHistoryAndStatusPage();
		myAccountPage = orderHistoryAndStatusPage.navigateToMyAccountPage();
	}
	
	
	@AfterMethod
	
	public void tearDown(){
		driver.quit();
	}
	
}
