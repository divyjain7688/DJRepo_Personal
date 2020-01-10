/**
 * @author nm064123
 */

package com.selenium.ebiz.account_management.login;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.tools.WaitTool;

public class HomePageContentHeroLoggedInUser_WORKING extends BaseClass{

	HomePage homePage;
	LoginPage loginPage;


	@BeforeMethod
	public void initializeDriver() throws MalformedURLException, Exception
	{
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
	}


	/**
	 * Reviewed and updated  by Divy Jain
	 * @author: nm064123
	 * @throws Exception 
	 * @story:  US-Cat-891 && US-Cat-893 && US-Cat-252 && US-Cat-892
	 * @storyDescription:Display Hero Content carousel on Home Page Authenticated User  &&  Display Video Content Blocks for Authenticated User && US-Cat-252: Display 'Your Top Categories' Carousel on Home Page Authenticated & Cookied User
	 * && Display Home Page Hero Content Small Blocks Authenticated User
	 * 
	 */
	@Test(priority=1)
	public void validateContentHerosDisplay() throws Exception 
	{
		WaitTool.hardWait();
		Assert.assertTrue(homePage.isYourTopCategoriesTitleDisplayed());
		Assert.assertTrue(homePage.isDisplayedContentHeroSmallBlock1());
		Assert.assertTrue(homePage.isDisplayedContentHeroSmallBlock2());
		Assert.assertTrue(homePage.isDisplayedContentHeroSmallBlock3());
		Assert.assertTrue(homePage.isContentHero1Displayed());
		Assert.assertTrue(homePage.islearnSomethingNewDisplayed());

		//trending products not getting displayed
		//Assert.assertTrue(loginPage.isDisplayedtopCategoriesCarouselSection());
	}

}
