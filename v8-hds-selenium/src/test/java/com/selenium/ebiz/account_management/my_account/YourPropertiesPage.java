package com.selenium.ebiz.account_management.my_account;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class YourPropertiesPage  extends BaseClassV8_ParallelGrid {

	private ArrayList<UsersListBean> usersList;

	/*
   @designed by: Divy Jain
   mapped with: W80-8155
	 */

	@Test(dataProvider = "browsers")
	public void myAccount_VerifyYourPropertiesPageAttributes(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.sumausers.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();
		pageManager.myAccountPage().goToYourProperties();
		Assert.assertTrue(pageManager.myAccountPage().yourPropertiesHeaderText.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().propertyNameText.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().addressText.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().cityStateText.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isListOfCustomersDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().areValuesUnderPropertiesTableSorted("name"));
		Assert.assertTrue(pageManager.myAccountPage().areValuesUnderPropertiesTableSorted("acccountNumber"));
		Assert.assertTrue(pageManager.myAccountPage().areValuesUnderPropertiesTableSorted("city"));
		Assert.assertTrue(pageManager.myAccountPage().areValuesUnderPropertiesTableSorted("state"));	

	}


	@Test(dataProvider = "browsers")
	public void myAccount_VerifyNavigateToOtherCustomer(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.sumausers.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();
		pageManager.myAccountPage().goToYourProperties();
		String accountNumber = pageManager.myAccountPage().navigateToOtherCustomer();
		pageManager.loginPage().loggedAccountNumberText.getText().contains(accountNumber);
	}

}
