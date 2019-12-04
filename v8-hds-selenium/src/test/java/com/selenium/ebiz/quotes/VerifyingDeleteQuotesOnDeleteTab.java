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

public class VerifyingDeleteQuotesOnDeleteTab extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: W80-4098 :01/FMQAECOMM-570
	 */
	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider = "browsers")
	public void quotes_VerifyingDeleteQuotesOnDeleteTab(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickQuotesUtilityBar();
		pageManager.quoteListsPage().deleteaQuoteIfThereIsNoDeletedQuote();
		pageManager.quoteListsPage().navigateToDigitalQuotesDeleted();
		pageManager.quoteListsPage().isDigitalQuotesRequoteLinkDisplayed();
		String exceptedQuoteId = pageManager.quoteListsPage().clickOnRequoteLink();
		System.out.println("exceptedQuoteId is "+ exceptedQuoteId);
		Assert.assertTrue(pageManager.quoteListsPage().getFirstAciveDigitalQuoteID().equals(exceptedQuoteId));		
	}

}
