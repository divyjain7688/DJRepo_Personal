package com.selenium.ebiz.search;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyCategoriesAndProductsForDynamicCategoryLandingPages extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-550, ALM Test ID: 663240
	 */
	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")
	public void search_VerifyCategoriesAndProductsForDynamicCategoryLandingPagesGuestUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.homePage().clickCategoryAppliancessLinkText();
		Assert.assertTrue(pageManager.categoryAppliancesPage().isDisplayedL2Categories());
		pageManager.categoryAppliancesPage().clickTopCategoryMicrowavesRepairLinkText();
		Assert.assertTrue(pageManager.productListingPage().isSortByLabelDisplayed());
	}

	@Test(dataProvider = "browsers")
	public void search_VerifyCategoriesAndProductsForDynamicCategoryLandingPagesLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickCategoryAppliancessLinkText();
		Assert.assertTrue(pageManager.categoryAppliancesPage().isDisplayedL2Categories());
		pageManager.categoryAppliancesPage().clickTopCategoryMicrowavesRepairLinkText();
		Assert.assertTrue(pageManager.productListingPage().isSortByLabelDisplayed());
	}
	
}
