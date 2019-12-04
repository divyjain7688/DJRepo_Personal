package com.selenium.ebiz.header;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyHomepageHeaderLinksDisplayed extends BaseClassV8_ParallelGrid{

	/**
	 * To Verify As an Unauthenticated User I want to view the Header from anywhere on the site so that  I can quickly navigate the catalog or access
 my account pages.
	 * 
	 * US-940
	 */


	@Test(dataProvider = "browsers")
	public void header_verifyHeaderLinksDisplayedForGuestUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountQuotesQuickLinkInUtilityBar());
		Assert.assertTrue(pageManager.homePage().shopByCategoryLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().headerResourcesLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().headerOffersLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().headereCatalogsLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().headerServicesLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().registerOrSignInLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().headerWebsitehelpLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().shoppingCartIcon.isDisplayed());
		Assert.assertTrue(pageManager.homePage().headerQuickOrderLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountSavedListsQuickLinkInUtilityBar());
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountFrequentlyPurchasedQuickLinkInUtilityBar());
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountSubscriptionsQuickLinkInUtilityBar());
		Assert.assertTrue(pageManager.homePage().isDisplayedTopHeaderOrderHistoryStatusLink());
		
	}


	@Test(dataProvider = "browsers")
	public void header_verifyDisplayStaticContentPageLoggedUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

		org.junit.Assert.assertTrue(pageManager.homePage().shopByCategoryLinkText.isDisplayed());
		org.junit.Assert.assertTrue(pageManager.homePage().headerResourcesLinkText.isDisplayed());
		org.junit.Assert.assertTrue(pageManager.homePage().headerOffersLinkText.isDisplayed());
		org.junit.Assert.assertTrue(pageManager.homePage().headereCatalogsLinkText.isDisplayed());
		org.junit.Assert.assertTrue(pageManager.homePage().headerServicesLinkText.isDisplayed());
		org.junit.Assert.assertTrue(pageManager.homePage().headerQuickOrderLinkText.isDisplayed());
		org.junit.Assert.assertTrue(pageManager.homePage().headerWebsitehelpLinkText.isDisplayed());
		org.junit.Assert.assertTrue(pageManager.homePage().shoppingCartIcon.isDisplayed());
		org.junit.Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountQuotesQuickLinkInUtilityBar());
		org.junit.Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountSavedListsQuickLinkInUtilityBar());
		org.junit.Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountFrequentlyPurchasedQuickLinkInUtilityBar());
		org.junit.Assert.assertTrue(pageManager.homePage().isDisplayedTopHeaderOrderHistoryStatusLink());

	}


}
