package com.selenium.ebiz.navigation;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.Appliances;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.ProductPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;

public class HomePageBreadCrumbLoggedInUser_WORKING extends BaseClass{

	HomePage homePage;
	ProductPage productPage;
	DBCon dbConnection;
	Appliances appliances;
	SubCategoryAppliancesPage subcategoryAppPage;
	LoginPage loginPage;
	ArrayList<UsersListBean> usersList;	
	ProductListingPage productListingPage;

	@BeforeMethod	
	public void driverSetup() throws Exception {
		dbConnection = new DBCon();
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());	
	}	

	/**
	 * To Verify that breadcrumb never displays the current page that the user is on
	 * @author lakshmi
	 *  US-600
	 */

	@Test
	public void verifyBreadCrumbForCurrentPageAutheticateduser() throws Exception {
		productListingPage=homePage.moveToSubCategoryPage();	
		Assert.assertTrue(productListingPage.verifyBreadCrumbForCurrentPage(productListingPage.getHeaderName()));	


	}


}
