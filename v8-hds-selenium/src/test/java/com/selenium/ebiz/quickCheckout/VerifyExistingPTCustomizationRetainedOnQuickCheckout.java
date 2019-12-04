package com.selenium.ebiz.quickCheckout;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyExistingPTCustomizationRetainedOnQuickCheckout extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy 
    mapped with: FMQAECOMM-718
	 */

	private ArrayList<UsersListBean> usersList;
	public String newListName = "List_",newlistcreated;
	@Test(dataProvider="browsers",enabled=false)
	//blocked because of defect W80-7703
	public void quickCheckout_VerifyExistingPTCustomizationRetainedOnQuickCheckout(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("searchBySecondPeachTreePartNumber","Search");
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().addToListButton.click();
		pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		pageManager.savedListsPage().clickOnRecentlyUpdatedLink();
		pageManager.savedListsPage().clickOnNewlyCreatedList();
		pageManager.savedListsDetailPage().customizeThisItem.click();
		pageManager.customizeConfigModal().customizeWithPeachTreeProduct();
		pageManager.savedListsDetailPage().quickCheckoutButton.click();
		pageManager.quickCheckout().youHaveCustomizedThisItem.isDisplayed();
		pageManager.quickCheckout().submitSecureOrder();
	}

}
