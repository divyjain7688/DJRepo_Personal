package com.selenium.ebiz.header;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
public class VerifyStaticWebsiteHelpInUtilityBarDisplayed extends BaseClassV8_ParallelGrid{
	/**
	 * 
	 * @author Smitha
	 * Validating the Static Website Help Phone number and Hours should be displayed in Utility bar On Homepage,Category and Subcategory page
	 * 
	 * This Test script is mapped to US-Cat-981
	 *
	 * MODIFIED: IULIIA
	 * 
	 */

	@Test(dataProvider = "browsers")
	public void header_DisplayStaticWebsiteHelpInUtilityBar(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpLabel());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpPhoneNumber());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpTime());
	}


	@Test(dataProvider = "browsers")
	public void header_DisplayStaticWebsiteHelpInUtilityBarOnCategoryPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickCategoryAppliancessLinkText();
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpLabel());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpPhoneNumber());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpTime());
		//Log.info(pageManager.homePage().getCategoryPageHeadingText());
		Assert.assertTrue(pageManager.homePage().getCategoryPageHeadingText().contains("APPLIANCES"));
	}


	@Test(dataProvider = "browsers")
	public void header_DisplayStaticWebsiteHelpInUtilityBarOnSubcategoryPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickCategoryAppliancessLinkText();
		pageManager.appliances().clickTopCategoryDishwashersRepairLinkText();
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpLabel());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpPhoneNumber());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpTime());
		//Log.info(pageManager.homePage().getCategoryPageHeadingText());
		Assert.assertTrue(pageManager.homePage().getCategoryPageHeadingText().contains("DISHWASHERS & REPAIR"));
	}

	@Test(dataProvider = "browsers")
	public void header_DisplayStaticWebsiteHelpInUtilityBarOnSubscriptionPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickMyAccountSubscriptionsQuickLink();
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpLabel());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpPhoneNumber());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpTime());
		Assert.assertTrue(pageManager.subscriptionsPage().getSubscriptionspageHeadingText().contains("SUBSCRIPTIONS"));

	}


	@Test(dataProvider = "browsers")
	public void header_DisplayStaticWebsiteHelpInUtilityBarOnSaveListPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
		Assert.assertTrue(pageManager.savedListsPage().getSavedListspageHeadingText().contains("SAVED LISTS"));
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpLabel());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpPhoneNumber());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpTime());
	}


	@Test(dataProvider = "browsers")
	public void header_DisplayStaticWebsiteHelpInUtilityBarOnOrderHistoryPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpLabel());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpPhoneNumber());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpTime());
		Log.info(pageManager.ordersPage().getOrderspageHeadingText());
		Assert.assertTrue(pageManager.ordersPage().getOrderspageHeadingText().contains("ORDER HISTORY"));
	}


	@Test(dataProvider = "browsers")
	public void header_DisplayStaticWebsiteHelpInUtilityBarOnFrequentlyPurchasePage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickFrePurchasedUtilityBar();
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpLabel());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpPhoneNumber());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpTime());
		Assert.assertTrue(pageManager.frequentlyPurchasedPage().getFrequentlyPurchasedpageHeadingText().contains("FREQUENTLY PURCHASED"));
	}


	@Test(dataProvider = "browsers")
	public void header_DisplayStaticWebsiteHelpInUtilityBarOnPDPPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().moveToSubCategoryPage();
		pageManager.productPage().clickFirstProductInProductList();
		Assert.assertTrue(pageManager.productDetailsPage().isDisplayedproductDetailsHeader());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpLabel());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpPhoneNumber());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpTime());
	}

	@Test(dataProvider = "browsers")
	public void header_DisplayStaticWebsiteHelpInUtilityBarOnSCPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickOnShoppingCartIcon();
		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpLabel());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpPhoneNumber());
		Assert.assertTrue(pageManager.homePage().isDisplayedStaticWebsiteHelpTime());
	}

}
