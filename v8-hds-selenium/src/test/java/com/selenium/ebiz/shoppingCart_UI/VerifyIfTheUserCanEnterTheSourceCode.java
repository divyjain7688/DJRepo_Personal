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

public class VerifyIfTheUserCanEnterTheSourceCode extends BaseClassV8_ParallelGrid 
{
	 /*
    designed by: Divy Jain
    ALM Test id:660489
    FMQAECOMM-431
     */
	
	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")
	public void shoppingcartUI_VerifyIfTheUserCanEnterTheSourceCode(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.shoppingCartPage().checkClearShoppingCart();
		usersList=pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder","QuickOrder");
		pageManager.homePage().clickOnQuickOrderLink();
		pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad();
		pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(), usersList.get(0).getQuantity1());
		pageManager.quickOrderPad().clickOnAddToCartButton();
		String sourceCodeValue = pageManager.shoppingCartPage().insertSourceCodeValue();
		String updatedSourceCodeValue = pageManager.shoppingCartPage().deletingOneCharFromString();
        pageManager.shoppingCartPage().clickonCheckOutButton();
        pageManager.paymentAndCheckOutPage().insertPONumber();
        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
        String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
        Log.info("orderNumber is "+ orderNumber);
        Assert.assertFalse(updatedSourceCodeValue.equals(sourceCodeValue));
        Assert.assertTrue(pageManager.orderConfirmationPage().orderNumber.isDisplayed());
	}
}