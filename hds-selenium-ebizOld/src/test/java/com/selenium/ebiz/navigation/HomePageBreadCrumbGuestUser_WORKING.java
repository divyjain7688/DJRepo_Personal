package com.selenium.ebiz.navigation;
import java.net.MalformedURLException;
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

public class HomePageBreadCrumbGuestUser_WORKING extends BaseClass{

	HomePage homePage;
	DBCon dbConnection;
	Appliances appliances;
	SubCategoryAppliancesPage subcategoryAppPage;
	ArrayList<UsersListBean> usersList;	
	ProductPage productPage;	
	ProductListingPage productListingPage;
	LoginPage loginPage;

	@BeforeMethod	
	public void driverSetup() throws MalformedURLException {
		initialize();
		dbConnection = new DBCon();
		loginPage = new LoginPage(driver);
	}	

	/**
	 * To Verify that breadcrumb never displays the current page that the user is on
	 * @author lakshmi
	 * US-590
	 */

	@Test
	public void verifyBreadCrumbForCurrentPageUnautheticateduser() throws Exception 
	{
		productListingPage=loginPage.moveToSubCategoryPage();	
		Assert.assertTrue(productListingPage.verifyBreadCrumbForCurrentPage(productListingPage.getHeaderName()));	


	}

	//@AfterMethod
	public void tearDown(){
		driver.quit();
	} 

}
