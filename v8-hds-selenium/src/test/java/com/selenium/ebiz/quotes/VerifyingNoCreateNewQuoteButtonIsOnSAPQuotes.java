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

public class VerifyingNoCreateNewQuoteButtonIsOnSAPQuotes extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: W80-6020/FMQAECOMM-567
	 */
	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider = "browsers")
	public void quotes_VerifyingNoCreateNewQuoteButtonIsOnSAPQuotes(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickQuotesUtilityBar();
		Assert.assertFalse(pageManager.quoteListsPage().isCreateNewQuoteButtonDisplayedForallOtherQuotes());
		
	}

}
