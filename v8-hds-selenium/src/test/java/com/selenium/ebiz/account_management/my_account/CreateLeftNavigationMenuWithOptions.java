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


public class CreateLeftNavigationMenuWithOptions extends BaseClassV8_ParallelGrid {

	private ArrayList<UsersListBean> usersList;

	/*
   @designed by: Divy Jain
   mapped with: W80-7937
	 */

	@Test(dataProvider = "browsers")
	public void myAccount_verifyLeftNavigationMenuWithOptions(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.sumausers.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();
		Assert.assertTrue(pageManager.myAccountPage().signOutLinkInMenu.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().accountHeaderText.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().myProfileLinkInMenu.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().manageShippingAddressLinkInAccountMenu.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().yourPropertiesLinkInAccountMenu.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().manageOrdersLinkInAccountMenu.isDisplayed());
		pageManager.myAccountPage().clickOnMyProfileLogo();
		Assert.assertTrue(pageManager.myAccountPage().communicationPreferencesLink.isDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().aboutLink.isDisplayed());

	}
	
	
	@Test(dataProvider = "browsers")
	public void myAccount_verifyNavigationsAfterClickingOptions(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.sumausers.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();
		Assert.assertTrue(pageManager.myAccountPage().isYourPropertiesHeaderTextDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isManageShippingAddressHeaderTextDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isManageOrdersHeaderTextDisplayed());
		pageManager.myAccountPage().clickOnMyProfileLogo();
		Assert.assertTrue(pageManager.myAccountPage().isAboutYouPageDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isCommunicationPreferencesHeaderTextDisplayed());
	}
	
	@Test(dataProvider = "browsers")
	public void myAccount_verifySignOut(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.sumausers.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();
		pageManager.myAccountPage().verifyCancelSignOut();
		pageManager.myAccountPage().verifySignOut();
	
	}
}
