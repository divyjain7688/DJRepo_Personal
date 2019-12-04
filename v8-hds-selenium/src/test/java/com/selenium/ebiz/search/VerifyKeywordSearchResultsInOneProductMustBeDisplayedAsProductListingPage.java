package com.selenium.ebiz.search;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;

public class VerifyKeywordSearchResultsInOneProductMustBeDisplayedAsProductListingPage  extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-556, ALM Test ID: 661745
	 */
	private ArrayList<UsersListBean> usersList;
	int expectedProductCount = 1;

	@Test(dataProvider = "browsers")
	public void search_VerifyKeywordSearchResultsInOneProductMustBeDisplayedAsProductListingPage(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		pageManager.productListingPage().isSortByLabelDisplayed();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumberTest", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		int actualProductCount = pageManager.productListingPage().getTotalNumberOfProductDisplayd();
		Assert.assertEquals(actualProductCount, expectedProductCount);
	}
}
