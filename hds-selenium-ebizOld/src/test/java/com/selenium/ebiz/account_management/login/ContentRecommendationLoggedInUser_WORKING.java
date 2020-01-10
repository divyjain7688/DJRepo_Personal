package com.selenium.ebiz.account_management.login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.tools.CommonFunctions;

public class ContentRecommendationLoggedInUser_WORKING extends BaseClass {

	HomePage homePage;
	CommonFunctions commonFunctions;
	DBCon dbConnection;
	LoginPage loginPage;

	@BeforeMethod	
	public void driverSetup() throws Exception {
		driver = initialize();	
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
		//testing
	}

	/**
	 * To verify as Authenticated User I want to view the User Content Recommendations which displays recommended 
	 * product content to the user. 
	 * 
	 * 
	 * US-Cat-1110
	 * 
	 * */

	@Test
	public void verifyContentRecommandationForAuthenticatedUser() throws Exception {

		Assert.assertTrue(homePage.isYourTopCategoriesCarouselSection());
		Assert.assertTrue(homePage.isDisplayedOrderAgainContentRecommandation());
	}

}
