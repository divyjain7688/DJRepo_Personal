package com.selenium.ebiz.shoppingCart_UI;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyDisplayTheShippingAddress extends BaseClassV8_ParallelGrid {
	/*
	   designed by: Divy Jain
	   ALM Test id:660513
	   FMQAECOMM-433
	 */
	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers", enabled=false)
	public void shoppingcartUI_VerifyDisplayTheShippingAddress(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

		usersList=pageManager.dBCon().loadDataFromExcel("verifyMyAccountsPageLinks","MyAccount");
		pageManager.homePage().clickAccountLinkText();
		pageManager.myAccountPage().goToAddressBook();	
		pageManager.myAccountPage().clickOnDeleteButtons();
		pageManager.myAccountPage().addNewShippingAddressButton();
		pageManager.myAccountPage().clearAllFieldsinAddressBook();
		pageManager.myAccountPage().addAddress(usersList.get(0).getShippingAddressName(), usersList.get(0).getAddress(),usersList.get(0).getFloorOrSuite(), usersList.get(0).getCity(),
				usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName());
		String shippingAddressName= usersList.get(0).getShippingAddressName();
		String expectedAddressline1 = usersList.get(0).getCompanyOrPropertyName();
		String expectedAddressline2 = usersList.get(0).getAddress()+" null";
		String expectedAddressline3 = usersList.get(0).getCity();
		String expectedAddressline4 = usersList.get(0).getZipCode();
		expectedAddressline4=expectedAddressline4.replace("'", "");
		System.out.println("expectedAddressline1 is "+ expectedAddressline1);
		System.out.println("expectedAddressline2 is "+ expectedAddressline2);
		System.out.println("expectedAddressline3 is "+ expectedAddressline3);
		System.out.println("expectedAddressline4 is "+ expectedAddressline4);
		pageManager.myAccountPage().addressLine1().equals(usersList.get(0).getShippingAddressName());
		pageManager.shoppingCartPage().checkClearShoppingCart();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
		System.out.println("part is " + usersList.get(0).getSearchProductPartNumber());
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().selectSpecificOptionFromShippingDropdown(shippingAddressName);
		System.out.println("displayedShippingToAddress1.getText()  "+ pageManager.shoppingCartPage().displayedShippingToAddress1.getText());
		System.out.println("displayedShippingToAddress2.getText()  "+ pageManager.shoppingCartPage().displayedShippingToAddress2.getText());
		System.out.println("displayedShippingToAddress3.getText()  "+ pageManager.shoppingCartPage().displayedShippingToAddress3.getText());
		Assert.assertTrue(pageManager.shoppingCartPage().displayedShippingToAddress1.getText().equals(expectedAddressline1));
		Assert.assertTrue(pageManager.shoppingCartPage().displayedShippingToAddress2.getText().equals(expectedAddressline2));
		Assert.assertTrue(pageManager.shoppingCartPage().displayedShippingToAddress3.getText().contains(expectedAddressline3));
		Assert.assertTrue(pageManager.shoppingCartPage().displayedShippingToAddress3.getText().contains(expectedAddressline4));
		Assert.assertTrue(pageManager.shoppingCartPage().addNewAddressLink.isDisplayed());
	}
}