package com.selenium.ebiz.search;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifySearchBoxFieldAccepts50Chars extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-544, ALM Test ID: 661742
	 */

	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")
	public void search_VerifySearchBoxFieldAccepts50CharsGuestUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByMoreThanFiftyChars", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		String actualInputValue = pageManager.homePage().getValueFromSearchTextBox();
		Assert.assertFalse(actualInputValue.equals(usersList.get(0).getSearchProductKeyword()));
		usersList = pageManager.dBCon().loadDataFromExcel("searchBySpecialCharacters", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		actualInputValue = pageManager.homePage().getValueFromSearchTextBox();
		Assert.assertTrue(actualInputValue.equals(usersList.get(0).getSearchProductKeyword()));
	}
	
	@Test(dataProvider = "browsers")
	public void search_VerifySearchBoxFieldAccepts50CharsLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		usersList = pageManager.dBCon().loadDataFromExcel("searchByMoreThanFiftyChars", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		String actualInputValue = pageManager.homePage().getValueFromSearchTextBox();
		Assert.assertFalse(actualInputValue.equals(usersList.get(0).getSearchProductKeyword()));
		usersList = pageManager.dBCon().loadDataFromExcel("searchBySpecialCharacters", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		actualInputValue = pageManager.homePage().getValueFromSearchTextBox();
		Assert.assertTrue(actualInputValue.equals(usersList.get(0).getSearchProductKeyword()));
	}

}
