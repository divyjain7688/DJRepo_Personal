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

public class VerifyingRoleShowsUpOnQuoteDetailsPage extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: W80-4086 :02/FMQAECOMM-565
	 */
	private ArrayList<UsersListBean> usersList;
	
	@Test(dataProvider = "browsers")
	public void quotes_VerifyingRoleShowsUpOnQuoteDetailPageForAuthenticatedUser(String browser, String version, String os, Method method) throws Exception {

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
	
	@Test(dataProvider = "browsers", enabled = true)
	//leon.palo@hdsupply.com is not working for stage env
	public void quotes_VerifyingRoleShowsUpOnQuoteDetailsPageForOBOUser(String browser, String version, String os, Method method) throws Exception {

		String expectedCreatedByName="LEE PALO - Sales Rep";
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().loginToHDSForOBOUser(RandomAccountSelect.obousers.pop(), configread.getPassword());
		pageManager.loginPage().clickFirstAccountForOBOUser();
		pageManager.homePage().clickQuotesUtilityBar();
		pageManager.quoteListsPage().createNewQuote();
		String actualCreatedByNameOnQLP = pageManager.quoteListsPage().getFirstCreatedByName();
		System.out.println("actualCreatedByNameOnQLP is "+ actualCreatedByNameOnQLP);
		pageManager.quoteListsPage().clickOnFirstQuoteName();
		String actualCreatedByNameOnQDP = pageManager.quotesPriceDetailPage().getCreatedByNameText();
		System.out.println("actualCreatedByNameOnQDP is "+ actualCreatedByNameOnQDP);
		Assert.assertEquals(actualCreatedByNameOnQDP,actualCreatedByNameOnQLP, expectedCreatedByName);

	}
	
	@Test(dataProvider = "browsers")
	public void quotes_VerifyingRoleShowsUpOnQuoteDetailsPageForEbizSupportUser(String browser, String version, String os, Method method) throws Exception {
		/*11/09/2019 : Divy Jain - Added ebiz Support users in RandomAccountSelect file and script is working fine for 2 users now*/
		String ebizSupportAccountNumber = "0012646822";
		String expectedCreatedByName="Chandra Geddam - eBiz Support";
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().loginToHDSForEbizupportUser(RandomAccountSelect.ebizSupportusers.pop(), configread.getPassword());
		pageManager.loginPage().selectAccountNumberForEbizSupportUser(ebizSupportAccountNumber);
		pageManager.homePage().clickQuotesUtilityBar();
		pageManager.quoteListsPage().createNewQuote();
		String actualCreatedByNameOnQLP = pageManager.quoteListsPage().getFirstCreatedByName();
		System.out.println("actualCreatedByNameOnQLP is "+ actualCreatedByNameOnQLP);
		pageManager.quoteListsPage().clickOnFirstQuoteName();
		String actualCreatedByNameOnQDP = pageManager.quotesPriceDetailPage().getCreatedByNameText();
		System.out.println("actualCreatedByNameOnQDP is "+ actualCreatedByNameOnQDP);
		Assert.assertEquals(actualCreatedByNameOnQDP,actualCreatedByNameOnQLP, expectedCreatedByName);


	}

}
