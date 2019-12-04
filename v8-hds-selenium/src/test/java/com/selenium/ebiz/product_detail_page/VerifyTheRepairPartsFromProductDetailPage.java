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

public class VerifyTheRepairPartsFromProductDetailPage extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-484
    ALM Test ID: 659830
	 */

	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider = "browsers", enabled = false)
	public void pdp_VerifyTheRepairPartsFromProductDetailPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartForRepairPartsCarousal", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().isRepairPartsDisplayed(); 
		pageManager.productDetailsPage().clickOnOneRepairPart();
		Assert.assertTrue(pageManager.productDetailsPage().isDisplayedproductDetailsHeader());
	}
}