package com.selenium.ebiz.account_management.suma;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyEscKeyIsNotClosingUserAccountModalWindow  extends BaseClassV8_ParallelGrid{
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-1050, W80-7260
	 */

	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")
	public void suma_VerifyEscKeyIsNotClosingUserAccountModalWindow(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
		pageManager.homePage().searchByPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().clickAddToCartButton();
		//pageManager.productDetailsPage().clickOnHDSupplyLogoInHeader();
		pageManager.commonLogin().LogInToHDSAsSuma(RandomAccountSelect.sumausers.pop(), configread.getPassword());	
		pageManager.homePage().ispropertyModalWindowDisplayed();
		pageManager.common().pressEscape();
		pageManager.homePage().ispropertyModalWindowDisplayed();
		pageManager.homePage().closePropertiesPopupIfDisplayed();
		pageManager.productDetailsPage().isDisplayedproductDetailsHeader();

		
}
}
