package com.selenium.ebiz.search;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;

public class VerifyParWithSpace extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-554, ALM Test ID: 661743
	 */

	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider = "browsers")
	public void search_VerifyParWithSpace(String browser, String version, String os, Method method) throws Exception {
		
		/*09/09/2019 : Divy Jain - No issue found after executing it for 10 times in local and executing on remote*/
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
		Log.info("search_VerifyParWithSpace searched product number: " + usersList.get(0).getSearchProductPartNumber());
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber()+"  ");
		Assert.assertTrue(pageManager.productDetailsPage().isPDPSectionsDisplayed());

	}

}
