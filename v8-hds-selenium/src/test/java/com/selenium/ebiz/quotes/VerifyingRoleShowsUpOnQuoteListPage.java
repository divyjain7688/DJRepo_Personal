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

public class VerifyingRoleShowsUpOnQuoteListPage extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: W80-4086/FMQAECOMM-566
	 */
	private ArrayList<UsersListBean> usersList;
	
	@Test(dataProvider = "browsers")
	public void quotes_VerifyingRoleShowsUpOnQuoteListPageForAuthenticatedUser(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickQuotesUtilityBar();
		String accountName = pageManager.homePage().getUserAccountNameText();
		pageManager.quoteListsPage().createNewQuote();
		String createdByName = pageManager.quoteListsPage().getFirstCreatedByName();
		Assert.assertEquals(accountName, createdByName);
	}
	
	@Test(dataProvider = "browsers", enabled = false)
	//leon.palo@hdsupply.com is not working for stage env
	public void quotes_VerifyingRoleShowsUpOnQuoteListPageForOBOUser(String browser, String version, String os, Method method) throws Exception {

		String expectedCreatedByName="LEE PALO - Sales Rep";
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().loginToHDSForOBOUser(RandomAccountSelect.obousers.pop(), configread.getPassword());
		pageManager.loginPage().clickFirstAccountForOBOUser();
		pageManager.homePage().clickQuotesUtilityBar();
		pageManager.quoteListsPage().createNewQuote();
		String actualCreatedByName = pageManager.quoteListsPage().getFirstCreatedByName();
		System.out.println("actualCreatedByName is "+ actualCreatedByName);
		Assert.assertEquals(actualCreatedByName, expectedCreatedByName);

	}
	
	@Test(dataProvider = "browsers", enabled=false)
	public void quotes_VerifyingRoleShowsUpOnQuoteListPageForEbizSupportUserListPage(String browser, String version, String os, Method method) throws Exception {
		String ebizSupportAccountNumber = "0012646822";
		String expectedCreatedByName="Chandra Geddam - eBiz Support";
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().loginToHDSForEbizupportUser(RandomAccountSelect.ebizSupportusers.pop(), configread.getPassword());
		pageManager.loginPage().selectAccountNumberForEbizSupportUser(ebizSupportAccountNumber);
		pageManager.homePage().clickQuotesUtilityBar();
		pageManager.quoteListsPage().createNewQuote();
		String actualCreatedByName = pageManager.quoteListsPage().getFirstCreatedByName();
		System.out.println("actualCreatedByName is "+ actualCreatedByName);
		Assert.assertEquals(actualCreatedByName, expectedCreatedByName);

	}

}
