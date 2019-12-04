package com.selenium.ebiz.account_management.login;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;

import org.apache.xpath.operations.Bool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class HomepageForLoggedInUserwithWinRel extends BaseClassV8_ParallelGrid{

	private ArrayList<UsersListBean> usersList;

	/**
	 * launch the application in browser,Login with cobrand user credentials and verify the homepage 
	 * This Test Script is mapped to user stories US-Cat-161 US-Cat-181 and US-Cat-201
	 */

	/*Modified : Bhavani */
	
	@Test(dataProvider = "browsers")
	public void login_displayHomePageForCobrandUserTest(String browser, String version, String os, Method method) throws Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		usersList=pageManager.dBCon().loadDataFromExcel("verifyCobrandLogoInHeader","LoginTestData");
		pageManager.commonLogin().LoginToHDS(usersList.get(0).getuserName(), configread.getPassword());	   
		pageManager.homePage().clickPropertyDropdown();
		pageManager.homePage().clickOnAccount0012482411UnderUser();

		Boolean isDisplayedUserName = pageManager.homePage().isDisplayedUserNameText();
		Assert.assertTrue(pageManager.homePage().getUserAccountNumber().contains("Customer #"));	
		Assert.assertTrue(pageManager.homePage().getUserAccountName().contains("Account"));

		Assert.assertTrue(isDisplayedUserName);
		Assert.assertTrue(pageManager.homePage().IsDisplayedCobrandLogoInHeader());

	}

}

