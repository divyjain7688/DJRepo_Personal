/**
 * 
 * @author suresh
 * 
 * This test will verify Increase or Decrease the product numbers in the Sub Category Page
 * 
 * This Test Script is mapped to US-Cat-273
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
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.ProductPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.WaitTool;


public class IncreaseDecreaseQuantitySubCategroy extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	CategoryAppliancesPage categoryAppliancesPage;
	SubCategoryAppliancesPage subCategoryAppliancesPage;
	ProductPage productPage;
	ProductListingPage productListingPage;


	/*
	 *  Launching of the Browser and login with Valid Credentials
	 */

	@BeforeMethod
	public void driverSetup() throws MalformedURLException, Exception {
		initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));

	}

	/**
	 *  Verifying the increase and decrease quantity  in the Sub Category pages
	 */

	@Test
	public void increaseDecreaseQuantitySubCategoryTest() throws Exception
	{
		productListingPage = homePage.moveToSubCategoryPage();
		productListingPage.clickIncreaseQuantity();
		WaitTool.hardWait();
		productListingPage.clickIncreaseQuantity();
		int iQuantity= Integer.parseInt(productListingPage.getQuantity());
		System.out.println("iQuantity"+iQuantity);
		Assert.assertEquals(iQuantity, 3);	
	}


}
