package com.selenium.ebiz.quotes;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyingEmailOnQuoteLandingPage  extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: W80-5971 :01/FMQAECOMM-569
	 */
	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers",enabled=false)
	//disabled the test case becaise of bug W80-7517
	public void quotes_VerifyingEmailOnQuoteLandingPage(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickQuotesUtilityBar();
		pageManager.quoteListsPage().createNewQuote();
		pageManager.quoteListsPage().emailToLink.click();
		usersList=pageManager.dBCon().loadDataFromExcel("sendQuotesPricePage","EMail");
		pageManager.eMailPage().fillOutEmailFields(usersList.get(0).getEMail(),usersList.get(0).getMessage());
		pageManager.quoteListsPage().clickOnFirstQuoteName();
		pageManager.quotesPriceDetailPage().clilckOnEmailToLink();
		usersList=pageManager.dBCon().loadDataFromExcel("sendQuotesPricePage","EMail");
		pageManager.eMailPage().fillOutEmailFields(usersList.get(0).getEMail(),usersList.get(0).getMessage());
		pageManager.quotesPriceDetailPage().clilckOnshareQuoteLink();
		pageManager.eMailPage().fillOutEmailFields(usersList.get(0).getEMail(),usersList.get(0).getMessage());
		Assert.assertTrue(pageManager.quotesPriceDetailPage().isDisplayedPriceQuoteTitle());
	}

}
