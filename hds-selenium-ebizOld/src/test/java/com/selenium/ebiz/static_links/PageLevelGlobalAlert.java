package com.selenium.ebiz.static_links;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;

public class PageLevelGlobalAlert extends BaseClass{

	HomePage homePage;
	LoginPage loginPage;
	DBCon dbCon;


	@BeforeMethod
	public void driverSetUp() throws Exception {
		driver=initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test

	public void verifyPageLevelAlert() {
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi"));
	}
	
}
