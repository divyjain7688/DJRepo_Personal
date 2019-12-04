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

public class VerifyOrderSummary extends BaseClassV8_ParallelGrid 
{
	/*
   designed by: Divy Jain
   ALM Test id:660530
   FMQAECOMM-436
	 */

	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")
	public void shoppingcartUI_VerifyReturnPolicyMesssage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.shoppingCartPage().checkClearShoppingCart();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productDetailsPage().clickAddToCartButton();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().cartSummarySection.isDisplayed();
        pageManager.shoppingCartPage().subTotalInCartSummarySection.isDisplayed(); 
        pageManager.shoppingCartPage().clickOnReturnPolicyLinkInFooter();
        Assert.assertTrue(pageManager.shoppingCartPage().returnPolicyMesssage.isDisplayed());
 
	}

}