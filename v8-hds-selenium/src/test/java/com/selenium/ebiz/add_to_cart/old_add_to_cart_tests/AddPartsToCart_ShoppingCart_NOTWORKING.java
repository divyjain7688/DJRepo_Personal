package com.selenium.ebiz.add_to_cart.old_add_to_cart_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddPartsToCart_ShoppingCart_NOTWORKING extends BaseClassV8_Parallel {

	//	String usersList1 = ("loginWithValidCredentialAndLogoutTest", "LoginTestData");


	/**
		 * Modified by Iuliia
		 * throws Exception
		 */
		@Test(priority = 0)
		public void test_Login(){
			LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		}

		@Test
		(priority = 1, description="Cart Empty Confirmation")
		public void testClearCart() throws Exception {
			pageManager.shoppingCartPage().checkClearShoppingCart();
			Log.info("Check and clear Shopping cart");
		}

        @Test(priority = 2, description = "Add part numbers from the list to the cart")
		public void test_addPartsToCart() throws Exception {
			waitTool.waitForElement(driver,pageManager.shoppingCartPage().addPartsToYourCartText);
		//	Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedAddPartsToYourCart());
			GetUserList2("verifyQuickAddPartsToCart", "QuickOrder");

			pageManager.shoppingCartPage().addPartsToYourCart(usersList2.get(0).getPartNumber1(), usersList2.get(0).getQuantity1());
			Log.info("**Add parts to the cart from the excel sheet: UsersLisrt2 get quantity1:**   " + usersList2.get(0).getQuantity1());

			Log.info("**Add parts to the cart from the excel sheet: get Quantity Of Added Item In Cart: **  " + pageManager.shoppingCartPage().getQuantityOfAddedItemInCart());
			//Assert.assertTrue(shoppingCartPage.getSuccessOrErrorMessageText().equalsIgnoreCase("The item has been successfully added to your current order"));
			Assert.assertEquals(pageManager.shoppingCartPage().getQuantityOfAddedItemInCart(), usersList2.get(0).getQuantity1());


		}
		@Test(priority = 3)
		public void test_ValidateIsErrorMessage() throws Exception{
			pageManager.shoppingCartPage().clearShoppingCart();
			Log.info("Clear cart");

			GetUserList2("verifyQuickAddPartsToCart", "QuickOrder");
		//	driver.navigate().refresh();
			waitTool.waitForElement(driver,pageManager.shoppingCartPage().addPartsToYourCartText);
			pageManager.shoppingCartPage().addPartsToYourCart(usersList2.get(0).getPartNumber2(), usersList2.get(0).getQuantity1());
			Log.info("Add parts to the cart from the excel sheet");

			String partNumber = usersList2.get(0).getPartNumber2();/*.substring(0, 6);*/
			Log.info("partNumber: " + partNumber);

			Assert.assertTrue(pageManager.shoppingCartPage().isErrorMessageTextDisplayed());
		}
}

