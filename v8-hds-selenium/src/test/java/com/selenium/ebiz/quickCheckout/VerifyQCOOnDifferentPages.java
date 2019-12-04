package com.selenium.ebiz.quickCheckout;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyQCOOnDifferentPages extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: W80-5392/FMQAECOMM-716
	 */

	private ArrayList<UsersListBean> usersList;


	@Test(dataProvider = "browsers")

	public void quickCheckout_VerifyQCOOnDifferentPages(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		ArrayList<UsersListBean> usersList;
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickOnQuickOrderLink();
		pageManager.quickOrderPad().clickAddMoreRowsFirstTime();
		pageManager.quickOrderPage().isDisplayedQuickOrderPageHeadingText();
		pageManager.quickOrderPage().quickCheckoutButton.isDisplayed();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc", "Search");
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().isQuickCheckoutButtonsIdsplayed();
    	usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productDetailsPage().isQuickCheckOutButtonDisplayed();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByProductDesc", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productListingPage().clickOnFirstCustomizeThisItemLinks();
        pageManager.customizeConfigModal().isQuickCheckoutButtonDisplayed();
        
        
	}

}
