package com.selenium.ebiz.account_management.login;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class HomePageContentHeroLoggedInAndUnauthenticatedUser extends BaseClassV8_ParallelGrid{

	/**
	 * Reviewed and updated  by Divy Jain
	 * @story:  US-Cat-891 && US-Cat-893 && US-Cat-252 && US-Cat-892
	 * @storyDescription:
	 *  US-Cat-891:Display large marketing hero on the Home Page Authenticated User  &&  Display Video Content Blocks for Authenticated User
	 *  US-Cat-893: Display Verify the title of the content widget is 'Learn Something New'
	 *  US-Cat-252: Display 'Your Top Categories' Carousel on Home Page Authenticated & Cookied User
	 *  US-Cat-892: Display Home Page Hero Content Small Blocks Authenticated User
	 * 
	 * Modified - Bhavani
	 */
	@Test(dataProvider = "browsers", enabled = false)
	public void login_validateContentHerosDisplayForLoginUser(String browser, String version, String os, Method method) throws Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		Assert.assertTrue(pageManager.homePage().largeMarketingHeroContent.isDisplayed());
		Assert.assertTrue(pageManager.homePage().heroContentSmallBlock1.isDisplayed());
		Assert.assertTrue(pageManager.homePage().heroContentSmallBlock2.isDisplayed());
		Assert.assertTrue(pageManager.homePage().heroContentSmallBlock3.isDisplayed());
		Assert.assertTrue(pageManager.homePage().isYourTopCategoriesTitleDisplayed());
		Assert.assertTrue(pageManager.homePage().isDisplayedlearnSomethingNew());
		Assert.assertTrue(pageManager.homePage().isDisplayedlearnSomethingNewRightBlock());
		Assert.assertTrue(pageManager.homePage().isDisplayedlearnSomethingNewLeftBlock());
	}
	
	@Test(dataProvider = "browsers")
	public void login_verifyContentHeroDisplayForUnAuthenticatedUser(String browser, String version, String os, Method method) throws Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		Assert.assertTrue(pageManager.homePage().largeMarketingHeroContent.isDisplayed());
		Assert.assertTrue(pageManager.homePage().heroContentSmallBlock1.isDisplayed());
		Assert.assertTrue(pageManager.homePage().heroContentSmallBlock2.isDisplayed());
		Assert.assertTrue(pageManager.homePage().heroContentSmallBlock3.isDisplayed());
		Assert.assertTrue(pageManager.homePage().isDisplayedlearnSomethingNew());
		Assert.assertTrue(pageManager.homePage().isDisplayedlearnSomethingNewRightBlock());
		Assert.assertTrue(pageManager.homePage().isDisplayedlearnSomethingNewLeftBlock());
	
	}

}
