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

public class VerifySearchForGenericCompetitorPartNumberOneToOne  extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-552, ALM Test ID: 663242
	 */
	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider = "browsers",enabled = false)
	public void search_VerifySearchForGenericCompetitorPartNumberOneToOne(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		usersList = pageManager.dBCon().loadDataFromExcel("searchByCompitetorPartNumber", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productListingPage().isBreadCrumbDisplayed(usersList.get(0).getSearchProductPartNumber());
		pageManager.productListingPage().manufacturerNumberMessage.isDisplayed();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByInvalidCompitetorPartNumber", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productListingPage().isBreadCrumbDisplayed(usersList.get(0).getSearchProductPartNumber());
		pageManager.productListingPage().weAreSorryWeCouldNotFindProductText.isDisplayed();
		
	}


}
