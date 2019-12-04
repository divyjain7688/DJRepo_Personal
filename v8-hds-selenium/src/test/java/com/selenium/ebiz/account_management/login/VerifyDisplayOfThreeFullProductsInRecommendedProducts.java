package com.selenium.ebiz.account_management.login;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyDisplayOfThreeFullProductsInRecommendedProducts extends BaseClassV8_ParallelGrid{
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-1067, W80-6176
	 */

	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")
	public void login_VerifyDisplayOfThreeFullProductsInRecommendedProductsForGuestUser(String browser, String version, String os, Method method) throws Exception {
		int expectedNumberOfProductImages = 3;
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc", "Search");
		pageManager.homePage().enterSearchEdit(usersList.get(0).getSearchProductKeyword());
		Assert.assertEquals(expectedNumberOfProductImages, pageManager.homePage().getCountOfProductImagesInSuggestedProductsResultsBlock());
	}
	
	@Test(dataProvider = "browsers")
	public void login_VerifyDisplayOfThreeFullProductsInRecommendedProductsForLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		int expectedNumberOfProductImages = 3;
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc", "Search");
		pageManager.homePage().enterSearchEdit(usersList.get(0).getSearchProductKeyword());
		Assert.assertEquals(expectedNumberOfProductImages, pageManager.homePage().getCountOfProductImagesInSuggestedProductsResultsBlock());
	}
}
