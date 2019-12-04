package com.selenium.ebiz.product_detail_page;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyProductDetailPagePrimaryImageVideos extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-485
    ALM Test ID: 659831
	 */

	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")
	public void pdp_VerifyProductDetailPagePrimaryImageVideosGuestUser(String browser, String version, String os, Method method) throws Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().clickOnBreadcrumb();
		pageManager.homePage().isDisplayedCategoryleftNavigation();				// validating because after clicking on breadcrumb, we need to verify if it navigated properly
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().isPDPDescriptionButtonsPrizeDisplayed();
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.productDetailsPage().clickAddToListButtonAsGuest();
		pageManager.signInOrRegisterPage().userNameEdit.isDisplayed();
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Assert.assertTrue(pageManager.productDetailsPage().zoomedImageDisplayed.isDisplayed());
		Assert.assertTrue(pageManager.productDetailsPage().isImageThumbnailDisplayed());
	}
	

	@Test(dataProvider = "browsers")
	public void pdp_VerifyProductDetailPagePrimaryImageVideosLoggedInUser(String browser, String version, String os, Method method) throws Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().clickOnBreadcrumb();
		pageManager.homePage().isDisplayedCategoryleftNavigation();		// validating because after clicking on breadcrumb, we need to verify if it navigated properly
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().isPDPDescriptionButtonsPrizeDisplayed();
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.productDetailsPage().clickAddToListButton();
		pageManager.addToExistingORCreateNewList_modal().isDisplayedExistingOrNewTabsOnAddToListModal();
		pageManager.addToExistingORCreateNewList_modal().closeSavedListModalWindow();
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Assert.assertTrue(pageManager.productDetailsPage().zoomedImageDisplayed.isDisplayed());
		Assert.assertTrue(pageManager.productDetailsPage().isImageThumbnailDisplayed());

	}
}