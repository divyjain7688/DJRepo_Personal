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

public class VerifyIPCCanBeCustomizedOnQCO extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy 
    mapped with: FMQAECOMM-717
	 */
	/**
	 * Fixed by Bino Jayasingh
	 * Mapped with W80-9394
	 * Fixed the issue causing failure to Click update button in customizeConfigModal.
	 * Fixed the assertion failure in Order confirmation page due to change in success message in order confirmation page
	 * enabling the test for execution
	 */
	public String newListName = "List_",newlistcreated;
	@Test(dataProvider = "browsers")
	public void quickCheckout_VerifyIPCCanBeCustomizedOnQCO(String browser, String version, String os, Method method) throws Exception {
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
		pageManager.quickCheckout().submitSecureOrder();
		Assert.assertTrue(pageManager.orderConfirmationPage().isDisplayedThankYouForYourOrderText());
		 
	}
}
