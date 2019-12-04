package com.selenium.ebiz.header;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyHomepageHeaderLinksDisplayLoggedInUser extends BaseClassV8_ParallelGrid{


	/**
	 * To Verify As an authenticated User I want to view the Header from anywhere on the site so that  I can quickly navigate the catalog or access
 		my account pages.
	 * @author lakshmi
	 * US-950
	 * modified by Iuliia
	 */

	@Test(dataProvider = "browsers")
	public void header_verifyDisplayHeaderLinksForLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

		Assert.assertTrue(pageManager.homePage().shopByCategoryLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().headerResourcesLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().headerOffersLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().headereCatalogsLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().headerServicesLinkText.isDisplayed());
	//	Assert.assertTrue(pageManager.homePage().registerOrSignInLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().headerWebsitehelpLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().shoppingCartIcon.isDisplayed());
		Assert.assertTrue(pageManager.homePage().headerQuickOrderLinkText.isDisplayed());
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountQuotesQuickLinkInUtilityBar());
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountSavedListsQuickLinkInUtilityBar());
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountFrequentlyPurchasedQuickLinkInUtilityBar());
		Assert.assertTrue(pageManager.homePage().isDisplayedTopHeaderOrderHistoryStatusLink());
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountSubscriptionsQuickLinkInUtilityBar());
		
	}
}
