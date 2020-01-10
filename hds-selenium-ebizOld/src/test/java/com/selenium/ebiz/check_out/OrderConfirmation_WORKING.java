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
import com.selenium.ebiz.pageobject.OrderConfirmationPage;
import com.selenium.ebiz.pageobject.PaymentAndCheckOutPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.tools.WaitTool;

public class OrderConfirmation_WORKING extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	ShoppingCartPage shoppingCartPage;
	MinicartPage minicartPage;
	ArrayList<UsersListBean> usersList1,usersList2,usersList3;
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
	 * US-Ord-212 -this story is to validate the order confirmation page
	 * @throws Exception 
	 **/


	@Test 
	public void orderConfirmationPage() throws Exception {

		//Validating the HomePage displayed or not by checking Hi text.*/
		System.out.println( homePage.getWelcomeNote());	
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); 

		// Add one or more products to cart and click Checkout button on the Shopping Cart page
		usersList2 = dbConnection.loadDataFromExcel("verifyQuickAddPartsToCart", "QuickOrder");
		usersList3 = dbConnection.loadDataFromExcel("verifySmokeTest","SmokeTest");

		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		Assert.assertTrue(shoppingCartPage.isDisplayedShoppingCartPage());
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
		} 
		else 
		{
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCart();
		}
		shoppingCartPage.addPartsToYourCart(usersList2.get(0).getPartNumber1(), usersList2.get(0).getQuantity1());
		//Assert.assertTrue(shoppingCartPage.getSuccessOrErrorMessageText().equalsIgnoreCase("The item has been successfully added to your current order"));
		Assert.assertEquals(shoppingCartPage.getQuantityOfAddedItemInCart(),usersList2.get(0).getQuantity1());

		shoppingCartPage = homePage.clickOnShoppingCartIcon();


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

		// Verify that clicking on ""Return Policy"" link is displayed which takes user to the as-is return policy page."
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedReturnPolicyLink());

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
		paymentAndCheckOutPage.enterPONumberInTextBox(usersList3.get(0).getPurchaseOrderNumber());

		//Verify Submit Secure Order Text and  Click on Submit Secure Order
		Assert.assertTrue(paymentAndCheckOutPage.isDisplayedSubmitSecureOrder1());
		OrderConfirmationPage orderConfirmationPage = paymentAndCheckOutPage.clickOnSubmitSecureOrder1();

		/* "Verify the following text on Order Confirmation page-Thank you for your order, it has been successfully placed.*/
		Assert.assertTrue(orderConfirmationPage.isDisplayedOrderConfirmationText());
		Assert.assertTrue(orderConfirmationPage.isDisplayedThankYouForYourOrderText());
		Assert.assertTrue(orderConfirmationPage.isDisplayedOrderConfirmationEmailText());



	}

}


