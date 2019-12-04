package com.selenium.ebiz.quickCheckout;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyExistingIPCCustomizationRetainedOnQuickCheckout extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy 
    mapped with: W80-5952/FMQAECOMM-719
	 */
	public String newListName = "List_",newlistcreated;
	@Test(dataProvider = "browsers")
	public void quickCheckout_VerifyExistingIPCCustomizationRetainedOnQuickCheckout(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.shoppingCartPage().checkClearShoppingCart();
		ArrayList<UsersListBean> usersList = pageManager.dBCon().loadDataFromExcel("searchByProductDesc", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productListingPage().isGridViewDisplayed();
		String partNumber = pageManager.productListingPage().clickOnFirstCustomizeThisItemLinks();
		pageManager.customizeConfigModal().customizeProduct();
		pageManager.customizeConfigModal().clickOnAddToList();
        newlistcreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewListForCustomizedProduct(newListName);
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(partNumber));
        Assert.assertTrue(pageManager.savedListsDetailPage().youHaveCustomizedThisItem.isDisplayed());
        pageManager.savedListsDetailPage().quickCheckoutButton.click();
        Assert.assertTrue(pageManager.quickCheckout().isAddedPartNumberDisplayed(partNumber));
        pageManager.quickCheckout().customizedThisItemLink.isDisplayed();
        pageManager.quickCheckout().submitSecureOrder();

	}
}
