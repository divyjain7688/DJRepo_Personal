package com.selenium.ebiz.search;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyBreadcrumbForCategoryLandingPageSearch extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-504, ALM Test ID: 660993
	 */

	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")
	public void search_VerifyBreadcrumbProductDetailPageSearchGuestUser(String browser, String version, String os, Method method) throws Exception {
		/*
		 09/04/2019 Divy Jain : No change in code and script is working fine 
		*/
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByTopCategory", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		pageManager.categoryAppliancesPage().isBreadcrumbHasSearchedCategory(usersList.get(0).getSearchProductKeyword());
		pageManager.categoryAppliancesPage().clickOnHomeLinkOnBreadcrumb();
		pageManager.homePage().isDisplayedCategoryleftNavigation();
		usersList = pageManager.dBCon().loadDataFromExcel("searchFlooringAndCeiling", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		pageManager.categoryAppliancesPage().isBreadcrumbHasSearchedCategory(usersList.get(0).getSearchProductKeyword());

	}

	@Test(dataProvider = "browsers")
	public void search_VerifyBreadcrumbProductDetailPageSearchLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		usersList = pageManager.dBCon().loadDataFromExcel("searchByTopCategory", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		pageManager.categoryAppliancesPage().isBreadcrumbHasSearchedCategory(usersList.get(0).getSearchProductKeyword());
		pageManager.categoryAppliancesPage().clickOnHomeLinkOnBreadcrumb();
		pageManager.homePage().isDisplayedCategoryleftNavigation();
		usersList = pageManager.dBCon().loadDataFromExcel("searchFlooringAndCeiling", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		pageManager.categoryAppliancesPage().isBreadcrumbHasSearchedCategory(usersList.get(0).getSearchProductKeyword());

	}

}
