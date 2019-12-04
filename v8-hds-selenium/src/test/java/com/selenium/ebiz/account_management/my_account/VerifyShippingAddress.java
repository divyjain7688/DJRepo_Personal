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
/*
8/12/2019 Bhavani: No Issues noticed 
*/

public class VerifyShippingAddress extends BaseClassV8_ParallelGrid {
	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers", description="Login", enabled = true)
	public void myAccount_AddNewShippingAddress(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

		usersList=pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
        Log.info(usersList.get(0).getSearchProductPartNumber());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
		pageManager.productDetailsPage().addToCartPDP();
		
		pageManager.homePage().clickOnShoppingCartIcon();
		
		pageManager.shoppingCartPage().clickOnAddNewAddressLink();
		
		usersList=pageManager.dBCon().loadDataFromExcel("addNewShippingAddressNY","ShippingAddress");
        Log.info(usersList.get(0).getState());
        pageManager.shoppingCartPage().selectStateDropdown(usersList.get(0).getState());
        
        Assert.assertEquals(pageManager.shoppingCartPage().getTextFromStateDropdown(), usersList.get(0).getState());
		
		

	}

}
