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

import static com.sun.imageio.plugins.jpeg.JPEG.version;

public class VerifyQuoteLandingPageFunctionality extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: W80-6001 :02/FMQAECOMM-575
	 */
	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider = "browsers")
	public void quotes_VerifyQuoteLandingPageAttributesAndDropdown(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickQuotesUtilityBar();
		pageManager.quoteListsPage().isActiveTabAndOnlineQuotesDisplayed();
		pageManager.quoteListsPage().isActiveTabAndOfflineQuotesDisplayed();
		Assert.assertTrue(pageManager.quoteListsPage().areDigitalQuoteAttributesDispalyed());
		Assert.assertTrue(pageManager.quoteListsPage().areAllOtherQuotesAttributesDispalyed());
		Assert.assertTrue(pageManager.quoteListsPage().veriyNumberOfQuotesPerPage(24));
		Assert.assertTrue(pageManager.quoteListsPage().veriyNumberOfQuotesPerPage(48));
		Assert.assertTrue(pageManager.quoteListsPage().veriyNumberOfQuotesPerPage(72));
		Assert.assertTrue(pageManager.quoteListsPage().veriyNumberOfQuotesPerPage(96));
		Assert.assertTrue(pageManager.quoteListsPage().veriyNumberOfQuotesPerPage(120));

	}


	@Test(dataProvider = "browsers")
    /*
    8/6/2019 Updated createNewQuoteIfQuotesAreLessThenTwentyFour to add one part number/quote. Adding 6 parts overlapped the btn
     */
	  /*
    8/26/2019 Divy jain - Updated createNewQuoteWithSixPartNumbers where clicking on createNewQuoteButton is done using javascript 
    so even createNewQuoteButton button is overlapped by suggested values, script will click on buttoncreateNewQuote Button
         */
	public void quotes_VerifyQuoteLandingPageSortingAndPagination(String browser, String version, String os, Method method) throws Exception {
		String pageNumberText="2";
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickQuotesUtilityBar();
		pageManager.quoteListsPage().areQuotesSortedByQuoteName();
		pageManager.quoteListsPage().areQuotesSortedByQuoteID();
		pageManager.quoteListsPage().areQuotesSortedByCreatedBy();
		pageManager.quoteListsPage().areQuotesSortedByLastUpdated();
		pageManager.quoteListsPage().areQuotesSortedByQuotesTotal();
		pageManager.quoteListsPage().createNewQuoteIfQuotesAreLessThenTwentyFour();
		Assert.assertEquals(pageManager.quoteListsPage().verifyPaginationOption(), pageNumberText);
	}
}
