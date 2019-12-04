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

public class ManageShippingAddressPage extends BaseClassV8_ParallelGrid {
	private ArrayList<UsersListBean> usersList;

	/*
    @designed by: Divy Jain
    mapped with: W80-8156
	 */
	@Test(dataProvider = "browsers")
	public void myAccount_ManageShippingAddressPage(String browser, String version, String os, Method method) throws Exception
	{

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();
		pageManager.myAccountPage().goToAddressBook();
		pageManager.myAccountPage().yourPropertiesHeaderTextInManageShippingAdddress.isDisplayed();
		pageManager.myAccountPage().defaultShippingAddress.isDisplayed();
		usersList = pageManager.dBCon().loadDataFromExcel("addNewShippingAddress", "ShippingAddress");
	    pageManager.myAccountPage().fillOutNewShippingAddress(usersList.get(0).getShippingAddressName(),usersList.get(0).getCompanyOrPropertyName(),usersList.get(0).getAddress(),
				usersList.get(0).getCity(),usersList.get(0).getState(),usersList.get(0).getZipCode(),usersList.get(0).getPhoneNumber());
	    Assert.assertTrue(pageManager.myAccountPage().areHeadersDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isListOfAddressesInManageShippingAddressDisplayed());
	}

}
