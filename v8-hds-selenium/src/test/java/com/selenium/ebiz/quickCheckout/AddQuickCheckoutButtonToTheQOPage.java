package com.selenium.ebiz.quickCheckout;

import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class AddQuickCheckoutButtonToTheQOPage extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: W80-5937/FMQAECOMM-724
	 */

    private ArrayList<UsersListBean> usersList;


	@Test(dataProvider = "browsers")

	public void quickCheckout_AddQuickCheckoutButtonToTheQOPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickOnQuickOrderLink();
		pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad();
		pageManager.quickOrderPad().clickAddMoreRowsFirstTime();
		pageManager.quickOrderPage().isDisplayedQuickOrderPageHeadingText();
		usersList = pageManager.dBCon().loadDataFromExcel("invalidPartNumber", "QuickOrder");
		pageManager.quickOrderPage().fillFirstPartNumberTextBox(usersList.get(0).getPartNumber1());
		pageManager.quickOrderPage().quickCheckoutButton.click();
		pageManager.quickCheckout().isPartNumberNoLongerAvailableMessageDisplayed();
		pageManager.homePage().clickOnQuickOrderLink();
		pageManager.quickOrderPad().clickAddMoreRowsFirstTime();
		usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
		pageManager.quickOrderPage().fillFirstPartNumberTextBox(usersList.get(0).getPartNumber1());
		pageManager.quickOrderPage().quickCheckoutButton.click();
		pageManager.quickCheckout().isAddedPartNumberDisplayed(usersList.get(0).getPartNumber1());
	}

}
