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

public class VerifyDisplayWarningMessagePopupWhenUserSubmitsBlindsItemsQCO extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy 
    mapped with: W80-5950/FMQAECOMM-721
	 */
	public String newListName = "List_",newlistcreated;
	@Test(dataProvider = "browsers", enabled = false)
	public void quickCheckout_VerifyDisplayWarningMessagePopupWhenUserSubmitsBlindsItemsQCO(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.shoppingCartPage().checkClearShoppingCart();
		ArrayList<UsersListBean> usersList = pageManager.dBCon().loadDataFromExcel("searchByProductDesc", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productListingPage().clickOnFirstQuickCheckOutButtonForCustomizedProduct();
		pageManager.quickCheckout().clickOnCustomizeThisItemLink();
		pageManager.customizeConfigModal().customizeProduct();
		pageManager.customizeConfigModal().clickOnUpdateBtnSCP();
		Assert.assertTrue(pageManager.quickCheckout().submitSecureOrder());
	}
}
