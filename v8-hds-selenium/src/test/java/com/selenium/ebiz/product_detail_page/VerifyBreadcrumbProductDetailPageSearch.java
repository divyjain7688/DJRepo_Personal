package com.selenium.ebiz.product_detail_page;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyBreadcrumbProductDetailPageSearch extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-479, ALM Test ID: 654939
	 */

	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")

	public void pdp_VerifyBreadcrumbProductDetailPageSearch(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productDetailsPage().isBreadcrumbDisplayed();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc", "Search");
        System.out.println("usersList.get(0).getSearchProductKeyword() is "+ usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().isBreadCrumbDisplayed(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().clickOnHDSupplyLogoInHeader();
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productDetailsPage().isBreadcrumbDisplayed();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc", "Search");
        System.out.println("usersList.get(0).getSearchProductKeyword() is "+ usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().isBreadCrumbDisplayed(usersList.get(0).getSearchProductKeyword());

	}
}