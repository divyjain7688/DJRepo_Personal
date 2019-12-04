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

public class VerifyFunctionalityOfClearCartLink extends BaseClassV8_ParallelGrid {
	/*
    designed by: Divy Jain
    ALM Test id:660490
    FMQAECOMM-432
	 */

	private ArrayList<UsersListBean> usersList;
	String expectedPopupMessage = "Are you sure you want to remove these items from your Shopping Cart?";

	@Test(dataProvider = "browsers", enabled = false)
	public void shoppingcartUI_VerifyFunctionalityOfClearCartLink(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.shoppingCartPage().checkClearShoppingCart();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().clickAddToCartButton();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().insertSourceCodeValue();
		String actualPopupMessage = pageManager.shoppingCartPage().clearShoppingCartAncCancel();
		expectedPopupMessage.equals(actualPopupMessage);
		String firstPartNumber = pageManager.shoppingCartPage().getFirstPartNumber();
		pageManager.shoppingCartPage().clickFirstRemoveButton();
		Assert.assertFalse(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(firstPartNumber));
		String secondPartNumber = pageManager.shoppingCartPage().getFirstPartNumber();
		pageManager.shoppingCartPage().clearShoppingCart();
		Assert.assertFalse(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(secondPartNumber));





	}

}