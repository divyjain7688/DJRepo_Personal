package com.selenium.ebiz.account_management.login;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;


public class HomePageContentImageCarousel_WORKING extends BaseClass{
	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	ArrayList<UsersListBean> usersList;

	@BeforeMethod
	public void driverSetup() throws MalformedURLException, Exception 
	{
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));

	}


	/**@author:sandhya
	 * 	US-Cat-891 As a Authenticated  User I want to view a large marketing hero on the home page 
	so that I can be made aware of any promotional deals or product savings before navigating off the home page.

	 */
	@Test 
	public void heroImageCarouselScroll() throws Exception 
	{
		Assert.assertTrue(homePage.heroImageCarousel());
		Assert.assertTrue(homePage.IsHeroImageCarouselOneDisplayed());
		Assert.assertTrue(homePage.IsHeroImageCarouselTwoDisplayed());
		Assert.assertTrue(homePage.IsHeroImageCarouselThreeDisplayed());

	}

}


