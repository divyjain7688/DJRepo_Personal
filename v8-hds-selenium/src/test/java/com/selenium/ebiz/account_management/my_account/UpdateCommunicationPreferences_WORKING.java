/**
 * @author nm064123
 */

package com.selenium.ebiz.account_management.my_account;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class UpdateCommunicationPreferences_WORKING extends BaseClassV8_ParallelGrid {

	String communicationPreferenceReceiveOnlyMyOrder = "Receive only my web orders";
	String communicationPreferenceReceiveAllOrder = "Receive all order at my property";



	/**
	 * @author nm064123
	 * @Story US-Acct-610: Update Communication Preferences for Authenticated User 
	 * 
	 * working
	 * modified Iuliia
	 */
	/*
    @designed by: Divy Jain
    mapped with: W80-7840
	 */

	@Test(dataProvider = "browsers")
	public void myAccount_changeCommunicationPrefencesToReceiveOnlyMyOrder(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();
		pageManager.myAccountPage().clickOnMyProfileLogo();
		Assert.assertTrue(pageManager.myAccountPage().changeCommunicationPrefenceToReceiveOnlyMyOrder());
		Assert.assertTrue(pageManager.myAccountPage().changeCommunicationPrefenceToReceiveAllOrder());
		Assert.assertTrue(pageManager.myAccountPage().changeCommunicationPrefenceToNoConfirmation());

	}
}
