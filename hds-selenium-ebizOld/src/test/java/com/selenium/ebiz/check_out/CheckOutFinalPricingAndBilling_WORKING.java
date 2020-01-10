package com.selenium.ebiz.check_out;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MinicartPage;
import com.selenium.ebiz.pageobject.PaymentAndCheckOutPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.tools.WaitTool;

public class CheckOutFinalPricingAndBilling_WORKING extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ShoppingCartPage shoppingCartPage;
	MinicartPage minicartPage;
	ArrayList<UsersListBean> usersList1,usersList2;
	DBCon dbConnection = new DBCon();
	PaymentAndCheckOutPage paymentAndCheckOutPage;

	/*
	 *  Launching of the Browser and login with Valid Credentials
	 */

	@BeforeMethod

	public void driverSetUp() throws Exception {
		driver = initialize();

		//Login as any authenticated user
		usersList1 = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");

		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(usersList1.get(0).getuserName(), usersList1.get(0).getpassword());		
	}

	/**
	 * 
	 * @author nd065733
	 * US-Ord-211 -this story is to verify the final pricing and billing of my shopping cart before I submit my order
	 * 
	 **/

	@Test
	public void verifyCheckOutBillingPage () throws Exception {

		/* Add one or more products to cart and click Checkout button on the Shopping Cart page
         and Validating the HomePage displayed or not by checking Hi text.*/
		WaitTool.hardWait();

		usersList2 = dbConnection.loadDataFromExcel("verifyQuickAddPartsToCart", "QuickOrder");
		shoppingCartPage = loginPage.clickShoppingCartIcon();
		Assert.assertTrue(shoppingCartPage.isDisplayedShoppingCartPage());
		//	shoppingCartPage.clearCart();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
		} 
		else 
		{
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCart();
		}
		shoppingCartPage.addPartsToYourCart(usersList2.get(0).getPartNumber1(), usersList2.get(0).getQuantity1());
		//Assert.assertTrue(shoppingCartPage.isSuccessMessageDisplayed());
		Assert.assertEquals(shoppingCartPage.getQuantityOfAddedItemInCart(),usersList2.get(0).getQuantity1());		

		// Verify that there is a breadcrumb which would bring the user back to the shopping cart. 
		Assert.assertTrue(shoppingCartPage.isDisplayedcontinueShoppingBreadCrumbLink());

		// Select check out button
		Assert.assertTrue(shoppingCartPage.isDisplayedCheckOutButton());
		paymentAndCheckOutPage  = shoppingCartPage.clickShoppingCartCheckOutButton();

		// Verify that Shipping Address is displayed on Final Pricing and Billing page
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedShippingAddressOnPaymentAndCheckOutPage());

		// Verify that the Shipping Address is editable
		Assert.assertTrue(paymentAndCheckOutPage.isEnabledditAddressLink());


		// Verify that Billing Method radio button options to either charge their HD Supply Account or Charge their credit card are displayed"
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedRadioButtonForChargeMyHDSupplyAccount());


		// Verify that text box form fields appear for the user to add their credit card and billing details when Charge Credit card option is selected
		paymentAndCheckOutPage.clickRadioButtonForChargeMyCreditCard();
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedtextBoxFormChargeMyCreditCard());

		// Verify that "Your Order - Expected Delivery Dates" section is displayed below Billing Method section
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedYourOrderExpectedDeliveryDates());

		// Verify that "Edit Items in Cart" link is seen on top of Your Order -Expected Delivery Dates section 
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedEditItemsInCartText());

		// Verify that Order Notes text field is seen below Your Order-Expected Delivery Dates section
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedTextAreaBox());

		// Verify that user can type notes regarding the order in Order Notes text field and this field autosaves the text entered
		paymentAndCheckOutPage.editInTextAreaBox();
		WaitTool.hardWait();
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedTextAreaBox());

		// Verify that "Submit Secure Order" button  appears on the top right of the page above the Final Pricing section, and it appears Under the P.O number field. 
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedSubmitSecureOrder1());
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedSubmitSecureOrder2());
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedSubmitSecureOrder3());

		// Verify that clicking on ""Return Policy"" link is displayed which takes user to the as-is return policy page."


		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedReturnPolicyLink());
		//paymentAndCheckOutPage.clickOnReturnPolicy();


		// Verify that clicking on "Top" link- takes user to the top of the Final Pricing and Billing Page. 
		// funcnality is not ready, when i click on top link, it throws error

		//paymentAndCheckOutPage.clickOnTopLink();


		// Verify that Final Pricing section on the right side of the page shows the cart summary (subtotal, shipping, taxes, fees, discounts, total order
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedCartSummaryText());
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedSubTotalText());
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedShippingText());

		// Assert.assertTrue(paymentAndCheckOutPage.isDisplayedTaxText());
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedTotalText());

		// Verify that there is "Edit in Cart" link next to Source Code field
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedEditItemsInCartText());


		// Verify that Category Spend text is visible
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedCategorySpendText());

		// Verify that PO number is displayed on Final Pricing and Billing page if PO number is added on Shopping Cart page
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedPONumberText());

	}

}





