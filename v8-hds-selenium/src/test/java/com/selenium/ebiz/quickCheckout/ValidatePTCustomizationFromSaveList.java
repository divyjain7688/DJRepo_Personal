package com.selenium.ebiz.quickCheckout;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class ValidatePTCustomizationFromSaveList extends BaseClassV8_ParallelGrid{
	/*
    @designed by: Divy
    mapped with: W80-5949/FMQAECOMM-722
	 */
	private ArrayList<UsersListBean> usersList;
	String list = "List_";
	@Test(dataProvider="browsers",enabled =false)
	//blocked because of defect W80-7644
	public void quickCheckout_ValidatePTCustomizationFromSaveList(String browser,String version, String os, Method method) throws  Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("searchBySecondPeachTreePartNumber","Search");
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().clickAddToListButton();
		String listName = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(list);
		pageManager.homePage().clickSavedListUtilityBar();
		pageManager.savedListsPage().clickOnRecentlyUpdatedLink();
		pageManager.savedListsPage().clickFirstSavedListNameLinkText();
		pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(usersList.get(0).getSearchProductPartNumber());
		pageManager.savedListsDetailPage().quickCheckoutButton.click();
		pageManager.quickCheckout().customizeThisItemLink.click();
		
		//pageManager.savedListsDetailPage().customizeThisItem.click();
		pageManager.customizeConfigModal().customizeWithPeachTreeProductSimple();
		pageManager.quickCheckout().isYouHaveCustomizedThisItemDisplayed();
		pageManager.quickCheckout().youHaveCustomizedThisItem.click();
		pageManager.customizeConfigModal().clickOnUpdate();
		pageManager.quickCheckout().submitSecureOrder();
		
	}
}
