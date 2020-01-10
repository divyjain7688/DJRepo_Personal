/**
 * 
 * @author suresh
 * 
 * This test will verify about the blank spot when clicked in the Category Page 
 * 
 * This TestScript is Mapped to the US-CAT-257
 * 
 * 
 * 
 */

package com.selenium.ebiz.navigation;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.CategoryAppliancesPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.tools.WaitTool;


public class VerifyL2CategoryProductBlank extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	CategoryAppliancesPage categoryAppliancesPage;

	/*
	 *  Launching of the Browser and login with Valid Credentials
	 */

	@BeforeMethod
	public void driverSetup() throws MalformedURLException
	{
		driver = initialize();
		loginPage = new LoginPage(driver);
	}

	/**
	 *  Moves from Left Navigation to the L2 Category Pages and verify the blanks
	 */	
	@Test(priority=0)
	public void verifyL2CategoryProductAuthenticateUserTest() throws Exception{
		//	homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		WaitTool.hardWait();
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());	
		// clicking on the Appliances on the left Navigation page
		categoryAppliancesPage = homePage.clickCategoryAppliancessLinkText();	
		// Taking the number of products and divide by Column
		double iColumn = categoryAppliancesPage.getCategoryLinkText();
		System.out.println("iColumn is " + iColumn);
		double totalCount = iColumn/6;
		System.out.println("totalCount is " + totalCount);

		String numberAsString = String.valueOf(totalCount);
		System.out.println("numberAsString is " + numberAsString);

		String length = numberAsString.substring(numberAsString.lastIndexOf("."));
		System.out.println("length is " + length);

		double remainder = .0;
		// Verifying if the remainder is more that .0 then this condition will verify for images and blank
		if((Double.parseDouble(length))>remainder) {
			Assert.assertTrue(categoryAppliancesPage.isDisplayedL2Categories());	

		}
		else {
			Assert.assertFalse(categoryAppliancesPage.isDisplayedL2Categories());	
		}
	}

	/**
	 *  Moves from Left Navigation to the L2 Category Pages and verify the blanks
	 */	
	@Test(priority=1)
	public void verifyL2CategoryProductGuestUserTest() throws Exception
	{	
		categoryAppliancesPage = loginPage.clickCategoryAppliancessLinkText();	
		double iColumn = categoryAppliancesPage.getCategoryLinkText();
		double totalCount = iColumn/6;
		String numberAsString = String.valueOf(totalCount);
		String length = numberAsString.substring(numberAsString.lastIndexOf("."));
		double remainder = .0;
		// Verifying if the remainder is more that .0 then this condition will verify for images and blank
		if((Double.parseDouble(length))>remainder) {
			Assert.assertTrue(categoryAppliancesPage.isDisplayedL2Categories());	

		}
		else {
			Assert.assertFalse(categoryAppliancesPage.isDisplayedL2Categories());	
		}
	}


}	

