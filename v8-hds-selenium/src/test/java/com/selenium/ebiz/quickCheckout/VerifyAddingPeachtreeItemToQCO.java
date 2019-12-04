package com.selenium.ebiz.quickCheckout;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyAddingPeachtreeItemToQCO extends BaseClassV8_ParallelGrid{
	/*
    @designed by: Divy Jain
    mapped with: W80-5392:02/FMQAECOMM-715
	 */

	/*
	 * updated simple click on addPartsToYourOrderButton to click using javascriptExecutor
	failed intermittently due to Stale Reference Element
	Divy Jain - 16-08-2019
	 */

	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider="browsers")
	public void quickCheckout_VerifyAddingPeachtreeItemToQCO(String browser,String version,String os,Method method) throws  Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickOnQuickOrderLink();
		pageManager.quickOrderPad().clickAddMoreRowsFirstTime();
		usersList=pageManager.dBCon().loadDataFromExcel("searchByPartNumber","Search");
		pageManager.quickOrderPage().fillFirstPartNumberTextBox(usersList.get(0).getSearchProductPartNumber());
		pageManager.quickOrderPage().quickCheckoutButton.click();
		usersList=pageManager.dBCon().loadDataFromExcel("searchBySecondPeachTreePartNumber","Search");
		pageManager.quickCheckout().addpartToOrder(usersList.get(0).getSearchProductPartNumber());
		Assert.assertTrue(pageManager.quickCheckout().isCustomizeThisItemLinkDisplayed());
	}
}
