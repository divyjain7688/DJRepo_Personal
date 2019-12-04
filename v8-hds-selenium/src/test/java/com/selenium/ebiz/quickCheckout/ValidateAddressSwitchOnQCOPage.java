package com.selenium.ebiz.quickCheckout;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class ValidateAddressSwitchOnQCOPage extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: W80-5945/FMQAECOMM-723
	 */

	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider = "browsers", enabled = false)

	public void quickCheckout_ValidateAddressSwitchOnQCOPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();
		pageManager.myAccountPage().goToAddressBook();	
		pageManager.myAccountPage().clickOnDeleteButtons();
		pageManager.myAccountPage().addNewShippingAddressButton();
		pageManager.myAccountPage().clearAllFieldsinAddressBook();
		usersList=pageManager.dBCon().loadDataFromExcel("verifyMyAccountsPageLinks","MyAccount");
		pageManager.myAccountPage().addAddress(usersList.get(0).getShippingAddressName(), usersList.get(0).getAddress(),usersList.get(0).getFloorOrSuite(), usersList.get(0).getCity(),
				usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName());
		String shippingAddressName= usersList.get(0).getShippingAddressName();
		String expectedAddressline1 = usersList.get(0).getCompanyOrPropertyName();
		String expectedAddressline2 = usersList.get(0).getAddress()+" null";
		String expectedAddressline3 = usersList.get(0).getCity();
		String expectedAddressline4 = usersList.get(0).getZipCode();
		expectedAddressline4=expectedAddressline4.replace("'", "");
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().clickOnQuickCheckOutButton();
		pageManager.quickCheckout().selectSpecificOptionFromShippingDropdown(shippingAddressName);
		Assert.assertTrue(pageManager.quickCheckout().displayedShippingToAddress1.getText().equals(expectedAddressline1));
		Assert.assertTrue(pageManager.quickCheckout().displayedShippingToAddress2.getText().equals(expectedAddressline2));
		Assert.assertTrue(pageManager.quickCheckout().displayedShippingToAddress3.getText().contains(expectedAddressline3));
		Assert.assertTrue(pageManager.quickCheckout().displayedShippingToAddress3.getText().contains(expectedAddressline4));


	}
}
