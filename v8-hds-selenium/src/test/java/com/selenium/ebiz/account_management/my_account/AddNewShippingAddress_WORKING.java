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

public class AddNewShippingAddress_WORKING extends BaseClassV8_ParallelGrid {
	private ArrayList<UsersListBean> usersList;

	/*
	 * Updated assertions
	actualAddressLine4 value on UI was displayed  in seperate line earlier as per old code.But now its not there.
	Divy Jain - 23-08-2019
	 */

	/*
    @designed by: Divy Jain
    mapped with: W80-7809
	 */
	@Test(dataProvider = "browsers")
	public void myAccount_AddNewShippingAddress(String browser, String version, String os, Method method) throws Exception
	{

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();
		pageManager.myAccountPage().goToAddressBook();
		usersList = pageManager.dBCon().loadDataFromExcel("addNewShippingAddress", "ShippingAddress");
		String nameFinal = pageManager.myAccountPage().fillOutNewShippingAddress(usersList.get(0).getShippingAddressName(),usersList.get(0).getCompanyOrPropertyName(),usersList.get(0).getAddress(),
				usersList.get(0).getCity(),usersList.get(0).getState(),usersList.get(0).getZipCode(),usersList.get(0).getPhoneNumber());
		Assert.assertTrue(pageManager.myAccountPage().verifyAddress(nameFinal,usersList.get(0).getAddress(),usersList.get(0).getFloorOrSuite(), usersList.get(0).getCity(),
				usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName()));

	}

}
