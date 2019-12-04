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

public class VerifyAddDeliveryDateToEachItemInTheShoppingCart extends BaseClassV8_ParallelGrid 
{
	/*
   designed by: Divy Jain
   ALM Test id:660513
   FMQAECOMM-434
	 */

	private ArrayList<UsersListBean> usersList;
	String defaultAddress = "Default";
	@Test(dataProvider = "browsers")
	public void shoppingcartUI_VerifyAddDeliveryDateToEachItemInTheShoppingCart(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.shoppingCartPage().checkClearShoppingCart();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
		System.out.println("part is " + usersList.get(0).getSearchProductPartNumber());
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().selectSpecificOptionFromShippingDropdown(defaultAddress);
		Assert.assertTrue(pageManager.shoppingCartPage().isDeliveryDateTextDisplayed());   
	}

}