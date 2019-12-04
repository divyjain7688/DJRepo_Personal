package com.selenium.ebiz.search;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;

public class VerifyLookAheadSearchForACategoryNegative extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-548, ALM Test ID: 663238
	 */

	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider = "browsers")
	public void search_VerifyLookAheadSearchForTwoInteger(String browser, String version, String os, Method method) throws Exception {
		/*
		 09/04/2019 Divy Jain : No change in code and script is working fine 
		*/
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByTwoInteger", "Search");
		pageManager.homePage().enterSearchEdit(usersList.get(0).getSearchProductKeyword());
		String fetchedValue = pageManager.homePage().getValueFromSearchTextBox();
		Assert.assertTrue(fetchedValue.equals(usersList.get(0).getSearchProductKeyword()));
	}

	@Test(dataProvider = "browsers")
	public void search_VerifyLookAheadSearchForOneCharacter(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByOneCharacter", "Search");
		pageManager.homePage().enterSearchEdit(usersList.get(0).getSearchProductKeyword());
		Assert.assertFalse(pageManager.homePage().isAutoCompleteSectionDisplayed());
	}
}
