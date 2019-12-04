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

public class ValidateDiscontinuedPartWithoutAReplacementPart extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-546, ALM Test ID: 663236
	 */
	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider = "browsers")
	public void search_ValidateDiscontinuedPartWithoutAReplacementPartGuestUser(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchBydiscontinuedPartwithReplacement", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productListingPage().replacementForDiscontinuedPartMessage.isDisplayed();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Assert.assertTrue(pageManager.productDetailsPage().isProductDetailsTitleDisplayed());
	}
	
	@Test(dataProvider = "browsers")
	public void search_ValidateDiscontinuedPartWithoutAReplacementPartLoggedInUser(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		usersList = pageManager.dBCon().loadDataFromExcel("searchBydiscontinuedPartwithReplacement", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productListingPage().replacementForDiscontinuedPartMessage.isDisplayed();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Assert.assertTrue(pageManager.productDetailsPage().isProductDetailsTitleDisplayed());
	}

}
