/**
 * US-Cat-1010 - Login to HD Supply as Suma user and Verify Homepage for the name ,account and the property drop down displayed on the Home page header.  
 * Reviewed and updated by bm071260
 */

package com.selenium.ebiz.account_management.suma;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class SumaUserHeader_Grid extends BaseClassV8_ParallelGrid{
	ArrayList<UsersListBean> usersList;


	@Test(dataProvider = "browsers")
	public void verifySumaUserHeader(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LogInToHDSAsSuma(RandomAccountSelect.sumausers.pop(), configread.getPassword());
		Assert.assertTrue( pageManager.homePage().getWelcomeNote().contains("Hi")); 
		Assert.assertTrue( pageManager.homePage().isDisplayedUserNameText());
		Assert.assertTrue( pageManager.homePage().getUserAccountNumber().contains("Customer #"));
		Assert.assertTrue( pageManager.homePage().isDisplayedPropertyDropdown());
	}

}
