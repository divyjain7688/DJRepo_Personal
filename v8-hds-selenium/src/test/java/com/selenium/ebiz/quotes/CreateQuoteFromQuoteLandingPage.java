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

public class CreateQuoteFromQuoteLandingPage extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: W80-6003 :01/FMQAECOMM-578
	 */
	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider = "browsers")
	public void quotes_CreateQuoteFromQuoteLandingPage(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickQuotesUtilityBar();
		pageManager.quoteListsPage().clickOnCreateNewQuoteButton();
		usersList=pageManager.dBCon().loadDataFromExcel("addProductsInCreateNewQuoteModal","Quotes");
		String quoteNameOnCreateNewQuoteModal = pageManager.createNewQuote_Modal().createNewQuoteWithOnePartNumber(usersList.get(0).getPartNumber1());
		String quoteNameOnQuoteListPage = pageManager.quoteListsPage().getFirstQuoteName();
		Assert.assertEquals(quoteNameOnCreateNewQuoteModal, quoteNameOnQuoteListPage);
		

	}

}
