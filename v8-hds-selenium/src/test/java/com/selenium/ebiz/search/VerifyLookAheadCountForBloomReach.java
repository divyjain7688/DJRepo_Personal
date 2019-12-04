package com.selenium.ebiz.search;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;

public class VerifyLookAheadCountForBloomReach extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-544, ALM Test ID: 663234
	 */

	private ArrayList<UsersListBean> usersList;
	String expectedCountOfAutoSuggestedPartNumber="12";
	@Test(dataProvider = "browsers")
	public void search_VerifyLookAheadCountForBloomReach(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByTwoCharacters", "Search");
		pageManager.homePage().enterSearchEdit(usersList.get(0).getSearchProductKeyword());
		pageManager.homePage().isAutoCompleteSectionDisplayed();
		Assert.assertTrue(pageManager.homePage().getCountOfPartsListedInAutoCompleteSection().equals(expectedCountOfAutoSuggestedPartNumber));
		
	}

}
