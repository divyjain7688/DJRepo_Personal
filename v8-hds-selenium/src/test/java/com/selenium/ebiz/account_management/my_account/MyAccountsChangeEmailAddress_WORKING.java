package com.selenium.ebiz.account_management.my_account;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MyAccountsChangeEmailAddress_WORKING extends BaseClassV8_ParallelGrid {
	private ArrayList<UsersListBean> usersList;

	/**
	 *@storyDescription :  To verify as As an authenticated user, I want to change my email address so that I can receive communications to the new address in the future.
	 * @US :US-Cat-470
	 * @author Lakshmi
	 * @modified Iuliia 3/5/2019
	 * working
	 * @throws Exception 
	 * */
	/*
    @designed by: Divy Jain
    mapped with: W80-7840
	 */
	@Test(dataProvider = "browsers")
	public void myAccount_verifyEmailChangedANdRevert(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();
		pageManager.myAccountPage().clickOnMyProfileLogo();
		usersList = pageManager.dBCon().loadDataFromExcel("verifyMyAccountsPageLinks", "MyAccount");
		pageManager.myAccountPage().changeEmailAddressToGetError(usersList.get(0).getUpdateEmailAddress());
		pageManager.myAccountPage().isEmailDoesNotErrorDisplayed();
		pageManager.myAccountPage().changeEmailAddress(usersList.get(0).getUpdateEmailAddress());
		Assert.assertTrue(pageManager.myAccountPage().displayedUpdatedEmailAddress(usersList.get(0).getUpdateEmailAddress()));
		Assert.assertTrue(pageManager.myAccountPage().isSuccessfulEmailUpdateMessageDisplayed());
	}

}