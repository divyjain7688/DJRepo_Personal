package com.selenium.ebiz.shoppingCart_UI;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyAddTextToPurchaseOrderField extends BaseClassV8_ParallelGrid 
{
	/*
    designed by: Divy Jain
    ALM Test id:660531
    FMQAECOMM-437
	 */

	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")
	public void shoppingcartUI_VerifyAddTextToPurchaseOrderField(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.shoppingCartPage().checkClearShoppingCart();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productDetailsPage().clickAddToCartButton();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().getDisplayedPartNumber().contains(usersList.get(0).getSearchProductPartNumber());
        pageManager.shoppingCartPage().clickonCheckOutButton();
        pageManager.paymentAndCheckOutPage().clickRadioButtonForChargeMyCreditCard();
        pageManager.paymentAndCheckOutPage().enterCCDetailsInAddPaymentAndCheckoutPage();
        String pnumber = pageManager.paymentAndCheckOutPage().insertPONumber();
        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        pageManager.ordersPage().isPONumberDisapleyed(pnumber);
        
        }
}
