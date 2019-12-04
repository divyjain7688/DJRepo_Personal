package com.selenium.ebiz.quickCheckout;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class AddingBlindsProductToQuickCheckout extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Iuliia
    mapped with: W80-5931
	 */

	@Test(dataProvider = "browsers")

	public void quickCheckout_AddingBlindsProductToQuickCheckout(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

		ArrayList<UsersListBean> usersList = pageManager.dBCon().loadDataFromExcel("searchByProductDesc", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productListingPage().isGridViewDisplayed();
		pageManager.productListingPage().clickOnFirstCustomizeThisItemLinks();
		pageManager.customizeConfigModal().customizeAndClickQuickCheckout("Blind Size","32","0.25","48");
		pageManager.quickCheckout().isQuickCheckoutPageTitleDisplayed();
		Assert.assertTrue(pageManager.quickCheckout().youHaveCustomizedThisItemText.isDisplayed());
		Log.info("width: " + pageManager.quickCheckout().customizedPartWidthDimension.getText());
		//Log.info("length: " + pageManager.quickCheckout().customizedPartLengthDimension.getText());
		Assert.assertTrue(pageManager.quickCheckout().customizedPartWidthDimension.getText().contains("32"));
		//Assert.assertTrue(pageManager.quickCheckout().customizedPartLengthDimension.getText().contains("18"));

	}
}
