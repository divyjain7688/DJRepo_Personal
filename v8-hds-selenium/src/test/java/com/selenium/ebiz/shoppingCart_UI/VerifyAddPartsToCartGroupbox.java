package com.selenium.ebiz.shoppingCart_UI;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyAddPartsToCartGroupbox extends BaseClassV8_ParallelGrid 
{
	/*
    designed by: Divy Jain
    ALM Test id:660529
    FMQAECOMM-435
	 */

	private ArrayList<UsersListBean> usersList;
	 /*
    	8/02/2019 Bhavani: Updated 46 line elements xpath  
	  */
	@Test(dataProvider = "browsers", enabled = true)
	public void shoppingcartUI_VerifyAddPartsToCartGroupbox(String browser, String version, String os, Method method) throws Exception {
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
        pageManager.shoppingCartPage().displayedPartNumber.getText().contains(usersList.get(0).getSearchProductPartNumber());
        pageManager.shoppingCartPage().displayedProductDescription.click();
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().clickProductImage();
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
        pageManager.homePage().clickOnShoppingCartIcon();
        Assert.assertTrue(pageManager.shoppingCartPage().partNumberTextBoxUnderAddPartsToYourCart.isDisplayed());
        Assert.assertTrue(pageManager.shoppingCartPage().addButtonUnderAddPartsToYourCart.isDisplayed());
        Assert.assertTrue(pageManager.shoppingCartPage().quantityStepperUnderAddPartsToYourCart.isDisplayed());

	}

}