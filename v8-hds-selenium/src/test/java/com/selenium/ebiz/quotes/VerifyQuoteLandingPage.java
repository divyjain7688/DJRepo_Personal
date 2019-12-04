package com.selenium.ebiz.quotes;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyQuoteLandingPage extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: W80-6001 :01/FMQAECOMM-577
	 */
	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider = "browsers")
	public void quotes_VerifyQuoteLandingPage(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickQuotesUtilityBar();
		pageManager.quoteListsPage().createNewQuote();
		pageManager.quoteListsPage().isPaginationInfoDisplayed();
		Assert.assertTrue(pageManager.quoteListsPage().AreQuotesPageAttributesDisplayed());
		Assert.assertTrue(pageManager.quoteListsPage().AreQuotesPageTableAttributesDisplayed());
		Assert.assertTrue(pageManager.quoteListsPage().areCheckoutButtonsDisplayed());

	}

}
