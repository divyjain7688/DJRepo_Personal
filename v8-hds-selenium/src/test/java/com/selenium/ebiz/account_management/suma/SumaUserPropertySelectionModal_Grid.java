/**
 * US-Cat-1012 - Login to HD Supply as Suma user, verify select property from Property Lookup Modal and verify property can be sorted by Name,Account Number, city and state
 * 
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

public class SumaUserPropertySelectionModal_Grid extends BaseClassV8_ParallelGrid{
	ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")
	public void suma_verifySumaUsersPropeprtySelectionModal(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		String username = RandomAccountSelect.sumausers.pop();
		pageManager.commonLogin().LogInToHDSAsSuma(username, configread.getPassword());
		pageManager.homePage().isDisplayedPropertyDropdown();
		pageManager.homePage().clickPropertyDropdown();
		String accountNumber = pageManager.propertyLookupPage().clickOnOneAccount();
		Log.info("accountNumber is: "+ accountNumber);
		Log.info( pageManager.homePage().getUserAccountNumber().substring(10));
		pageManager.homePage().clickOnSignOutIcon();
		pageManager.commonLogin().LogInToHDSAsSuma(username, configread.getPassword());
		Assert.assertEquals(pageManager.homePage().getUserAccountNumber().substring(11), accountNumber);
	}


	@Test(dataProvider = "browsers", enabled = false)
	public void suma_verifySumaUserPropertyDropdown(String browser, String version, String os, Method method) throws Exception 
	{	
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LogInToHDSAsSuma(RandomAccountSelect.sumausers.pop(), configread.getPassword());
		pageManager.homePage().clickPropertyDropdown();
		Assert.assertTrue(pageManager.propertyLookupPage().IsDisplayedPropertyTableSortedByName());
		Assert.assertTrue(pageManager.propertyLookupPage().IsDisplayedPropertyTableSortedByAccountNumber());
		Assert.assertTrue(pageManager.propertyLookupPage().IsDisplayedPropertyTableSortedByCity());
		Assert.assertTrue(pageManager.propertyLookupPage().IsDisplayedPropertyTableSortedByState());
	}

}
