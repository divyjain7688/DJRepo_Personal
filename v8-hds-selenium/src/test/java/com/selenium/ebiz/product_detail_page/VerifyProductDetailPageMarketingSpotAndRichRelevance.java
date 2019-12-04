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

public class VerifyProductDetailPageMarketingSpotAndRichRelevance extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-482
    ALM Test ID: 659828
	 */

	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")

	public void pdp_VerifyProductDetailPageMarketingSpotAndRichRelevanceGuestUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().richRelevanceSection.isDisplayed();
		pageManager.productListingPage().clickOnHDSupplyLogoInHeader();
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Assert.assertTrue(pageManager.productDetailsPage().richRelevanceSection.isDisplayed());
		
	}

}
