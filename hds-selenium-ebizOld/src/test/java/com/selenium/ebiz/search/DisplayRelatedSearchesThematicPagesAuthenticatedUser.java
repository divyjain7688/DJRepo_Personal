package com.selenium.ebiz.search;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.GooglePage;
import com.selenium.ebiz.pageobject.GoogleSearchResultPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductPage;

public class DisplayRelatedSearchesThematicPagesAuthenticatedUser extends BaseClass{
	HomePage homePage;
	GooglePage googlePage;
	DBCon dbConnection;
	LoginPage loginPage;
	ProductPage productPage;
	ProductDetailsPage productDetailsPage;
	ArrayList<UsersListBean> usersList;
	GoogleSearchResultPage googleSearchResultPage;

	@BeforeMethod	
	public void driverSetup() throws MalformedURLException, Exception {
		initialize();
		driver.get("https://www.google.com");
		//loginPage = new LoginPage(driver);
		//	homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
		dbConnection = new DBCon();
		googlePage = new GooglePage(driver);
	}

	/**
	 * To verify Display of Related Searches Thematic Pages for Authenticated User
	 * @author lakshmi
	 * US-cat-820
	 */			
	@Test
	public void verifyDisplayRelatedSearchesThematicPagesAuthenticatedUser() throws Exception {
		Assert.assertTrue(googlePage.isDisplayedgoogleLogo());
		usersList = dbConnection.loadDataFromExcel("verifyDisplayRelatedSearchesThematicPagesAuthenticatedUser","Search");
		String searchData = usersList.get(0).getGoogleSearchData();
		googleSearchResultPage = googlePage.enterGoogleSearchData(searchData);
		Assert.assertEquals(googleSearchResultPage.findSpecificLinkinSearchresultList(), true);
		//googleSearchResultPage.clickOnSearchResultLink();	
		//homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
		//Assert.assertTrue(CommonFunctions.getCurrentUrl(driver).contains("/tp/"));
	}
}
