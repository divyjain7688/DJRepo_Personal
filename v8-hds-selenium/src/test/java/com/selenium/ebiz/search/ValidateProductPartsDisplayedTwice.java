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

public class ValidateProductPartsDisplayedTwice extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Bhavani
    mapped with: FMQAECOMM-1066, W80-6180
	 */
	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider = "browsers", enabled = false)
	public void search_ValidateProductPartsDisplayedTwiceGuestUser(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		usersList = pageManager.dBCon().loadDataFromExcel("ValidateButtonAnimation", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Boolean isDisplayedPDP = pageManager.productDetailsPage().isDisplayedproductDetailsHeader();

		Boolean isDisplayedPartInRelatedPartsAndAccessories = pageManager.productDetailsPage().isDisplayedRelatedPartsAndAccessories128001();
		Boolean isDisplayedPartInCollections = pageManager.productDetailsPage().isDisplayedcollections128001();

		pageManager.productDetailsPage().clickOnAddToCartFromCollectionsPart128001();

		Assert.assertTrue(isDisplayedPDP);
		Assert.assertTrue(isDisplayedPartInRelatedPartsAndAccessories);
		Assert.assertTrue(isDisplayedPartInCollections);
	}

	@Test(dataProvider = "browsers", enabled = false)
	public void search_ValidateProductPartsDisplayedTwiceAuthenticatedUser(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

		usersList = pageManager.dBCon().loadDataFromExcel("ValidateButtonAnimation", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Boolean isDisplayedPDP = pageManager.productDetailsPage().isDisplayedproductDetailsHeader();

		Boolean isDisplayedPartInRelatedPartsAndAccessories = pageManager.productDetailsPage().isDisplayedRelatedPartsAndAccessories128001();
		Boolean isDisplayedPartInCollections = pageManager.productDetailsPage().isDisplayedcollections128001();

		pageManager.productDetailsPage().clickOnAddToCartFromCollectionsPart128001();

		Assert.assertTrue(isDisplayedPDP);
		Assert.assertTrue(isDisplayedPartInRelatedPartsAndAccessories);
		Assert.assertTrue(isDisplayedPartInCollections);
	}

}