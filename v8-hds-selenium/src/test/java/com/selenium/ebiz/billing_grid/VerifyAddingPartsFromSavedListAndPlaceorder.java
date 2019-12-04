/**
 * @author Bhavani
 * FMQAECOMM-476 [1]Verify Adding parts from Saved List and Placing an order
 * ALM Test Instance ID: 660487
 */
package com.selenium.ebiz.billing_grid;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyAddingPartsFromSavedListAndPlaceorder extends BaseClassV8_ParallelGrid {

	@Test(dataProvider = "browsers")
	public void billing_VerifyAddingPartsFromSavedListAndPlaceorderCreditCard(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.shoppingCartPage().checkClearShoppingCart();
		
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		pageManager.savedListsPage().clickOnExistingFirstSavedList();

		pageManager.savedListsDetailPage().isSavedListDetailPageTitle();
		String slPartNum = pageManager.savedListsDetailPage().getdisplayedPartNumber();
		pageManager.savedListsDetailPage().clickonFirstAddToCartbtn();
		
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().isDisplayedShoppingCartTitle();
		Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(slPartNum));
		
		pageManager.shoppingCartPage().clickonCheckOutButton();
		
		pageManager.paymentAndCheckOutPage().isPageTitleDisplayed();
        pageManager.paymentAndCheckOutPage().VerifyPNAValuesIsDisplayed();
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedDeliveryDateInMMDDYYYY());
        Log.info("Delivery Date: " + pageManager.paymentAndCheckOutPage().deliveryDateInMMDDYYYY.getText());
        
        pageManager.paymentAndCheckOutPage().clickRadioButtonForChargeMyCreditCard();
        pageManager.paymentAndCheckOutPage().enterCCDetailsInAddPaymentAndCheckoutPage();
        
        pageManager.paymentAndCheckOutPage().insertPONumber();
        
        String EnvValue = getEnvValue();
		System.out.println("EnvValue: " + EnvValue );
        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder(EnvValue);
        
        String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
        Assert.assertTrue(pageManager.orderConfirmationPage().orderNumber.isDisplayed());
        

	}
	
	@Test(dataProvider = "browsers")
	public void billing_VerifyAddingPartsFromSavedListAndPlaceorderChargeMyHDSAccount(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.shoppingCartPage().checkClearShoppingCart();
		
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		pageManager.savedListsPage().clickOnExistingFirstSavedList();

		pageManager.savedListsDetailPage().isSavedListDetailPageTitle();
		String slPartNum = pageManager.savedListsDetailPage().getdisplayedPartNumber();
		pageManager.savedListsDetailPage().clickonFirstAddToCartbtn();
		
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().isDisplayedShoppingCartTitle();
		Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(slPartNum));
		
		pageManager.shoppingCartPage().clickonCheckOutButton();
		
		pageManager.paymentAndCheckOutPage().isPageTitleDisplayed();
        pageManager.paymentAndCheckOutPage().VerifyPNAValuesIsDisplayed();
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedDeliveryDateInMMDDYYYY());
        Log.info("Delivery Date: " + pageManager.paymentAndCheckOutPage().deliveryDateInMMDDYYYY.getText());
        
        pageManager.paymentAndCheckOutPage().insertPONumber();
        
        String EnvValue = getEnvValue();
		System.out.println("EnvValue: " + EnvValue );
        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder(EnvValue);

        String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
        Log.info("orderNumber is "+ orderNumber);
        Assert.assertTrue(pageManager.orderConfirmationPage().orderNumber.isDisplayed());
        

	}
}
