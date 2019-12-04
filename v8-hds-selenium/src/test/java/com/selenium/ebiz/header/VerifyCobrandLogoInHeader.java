package com.selenium.ebiz.header;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class VerifyCobrandLogoInHeader extends BaseClassV8_ParallelGrid{

	private ArrayList<UsersListBean> usersList1,usersList2;

	/**
	 * 
	 * @author Smitha
	 * Login as cobrand user and Validate Cobrand Logo displayed in the Header. Should not display Cobrand Logo for other users
	 * 
	 * This Test script is mapped to US-Cat-965
	 * modified by Iuliia
	 */

	@Test(dataProvider = "browsers")
	public void header_VerifyCobrandLogoInHeader(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(configread.getUserName(),configread.getPassword());
		pageManager.homePage().clickPropertyDropdown();
		usersList1 = pageManager.dBCon().loadDataFromExcel("verifyCobrandLogoInHeader", "LoginTestData");
		pageManager.propertyLookupPage().clickProperty(usersList1.get(0).getchooseProperty());
		Assert.assertTrue(pageManager.homePage().IsDisplayedCobrandLogoInHeader());
	}

}
