package com.selenium.ebiz.header;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyMyAccountQuickLinksInUtilityBarLoggedInUser extends BaseClassV8_ParallelGrid{

	/**
	 * 
	 * Validating My Account quick links are displayed on utility bar for Guest and Logged users
	 * 
	 * This Test script is mapped to US-Cat-980
	 *
	 * modified by Iuliia: broke down the test into 3 different tests
	 * 
	 */
	@Test(dataProvider = "browsers")

	public void header_verifyMyAccountQuickLinksInUtilityBarLoggedUser(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountQuotesQuickLinkInUtilityBar());
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountSavedListsQuickLinkInUtilityBar());
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountFrequentlyPurchasedQuickLinkInUtilityBar());
		Assert.assertTrue(pageManager.homePage().isDisplayedTopHeaderOrderHistoryStatusLink());
	}


	@Test(dataProvider = "browsers")

	public void header_verifySubscriptionsPageHeadingText(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickMyAccountSubscriptionsQuickLink();
		Assert.assertTrue(pageManager.subscriptionsPage().subscriptionsPageHeadingText.isDisplayed());

	}

	@Test(dataProvider = "browsers")
	public void header_verifyMyAccountQuickLinksInUtilityBarSignedOutUser(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickOnSignOutIcon();
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountQuotesQuickLinkInUtilityBar());
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountSavedListsQuickLinkInUtilityBar());
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountFrequentlyPurchasedQuickLinkInUtilityBar());
		Assert.assertTrue(pageManager.homePage().isDisplayedTopHeaderOrderHistoryStatusLink());
	}

}
