package com.selenium.ebiz.product_detail_page;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyProductDetailPageBrandLogoShortDesc extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-480
    ALM Test ID: 654940
	 */

	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")

	public void pdp_VerifyProductDetailPageBrandLogoShortDesc(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().isBreadcrumbDisplayed();
		pageManager.productDetailsPage().clickOnBreadcrumb();
		pageManager.homePage().isDisplayedCategoryleftNavigation();
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().productDescription.isDisplayed();
		pageManager.productDetailsPage().isBrandNameDisplayed();
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().isBreadcrumbDisplayed();
        pageManager.productListingPage().clickOnHDSupplyLogoInHeader();
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().isBreadcrumbDisplayed();
		pageManager.productDetailsPage().clickOnBreadcrumb();
		pageManager.homePage().isDisplayedCategoryleftNavigation();
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().productDescription.isDisplayed();
		Assert.assertTrue(pageManager.productDetailsPage().isBrandNameDisplayed());
	}

}
