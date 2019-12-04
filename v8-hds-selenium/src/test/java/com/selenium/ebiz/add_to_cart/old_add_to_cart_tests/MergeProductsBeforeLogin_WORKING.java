package com.selenium.ebiz.add_to_cart.old_add_to_cart_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MergeProductsBeforeLogin_WORKING extends BaseClassV8_Parallel {
	private int counter;
	private String username;


	/**
	 * 103995 - Verify Migrate Cart for Existing User Login from Header
	 */

	@Test(priority = 0, description="Cart Empty Confirmation")
	public void test_Login() throws Exception{

		username = RandomAccountSelect.users.pop();
		pageManager.loginPage().loginToHDS_V8(username, configread.getPassword());
		Log.info("Logged in as:" + username);
		waitTool.waitForElement(driver,pageManager.loginPage().loggedAccountNumberText);
	}
	@Test(priority = 1, description="Cart Empty Confirmation")
	public void test_clearCart() throws Exception{
		pageManager.shoppingCartPage().checkClearShoppingCart();
		Log.info("Check and clear Shopping cart");
	}


	@Test(priority= 2 )
	public void test_logout() throws Exception{

		pageManager.homePage().clickOnSignOutIcon();
	}

	@Test(priority = 3)
	public void test_addProductIntoSC() throws Exception {

		GetUserList("searchByKeywordOrPartNumber", "Search");
		Log.info("usersList.get(0).getSearchProductPartNumber()" + usersList.get(0).getSearchProductPartNumber());
		/*searchPage = loginPage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage = searchPage.clickOnProduct();*/
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().clickAddToCartButton();
		counter = pageManager.common().counterIncrease();
		Log.info("counter is " + counter);
	//	pageManager.productDetailsPage().clickOnCloseAddtocartSuccessPopup();
		//	int

	}
	@Test(priority = 4)
	public void test_VerifyPartNumberIsDisplayedonSC() throws Exception {
		driver.navigate().refresh();
		pageManager.homePage().clickOnShoppingCartIcon();
		Log.info("shoppingCartPage.displyedPartNumberText()" + pageManager.shoppingCartPage().displyedPartNumberText());
		Assert.assertEquals(pageManager.shoppingCartPage().displyedPartNumberText(), counter);
	}

	@Test(priority = 5)
	public void test_VerifyShippingAddressTextIsDisplayedonSC() throws Exception {

		Assert.assertFalse(pageManager.shoppingCartPage().isDisplayedShippingAddressText());
	}

	@Test(priority = 6)
	public void test_SourceCodeIsDisplayedonSC() throws Exception {
		Assert.assertFalse(pageManager.shoppingCartPage().isDisplayedSourceCode());
	}

	@Test(priority = 7)

	public void test_login() throws Exception {

		pageManager.homePage().clickOnHDSupplyLogoInHeader();
		pageManager.loginPage().loginToHDS_V8(RandomAccountSelect.users.pop(), configread.getPassword());
		Log.info("Logged in as:" + username);
		waitTool.waitForElement(driver,pageManager.loginPage().loggedAccountNumberText);
		Log.info(pageManager.loginPage().loggedAccountNumberText.getText());
		Assert.assertTrue(pageManager.loginPage().loggedAccountNumberText.getText().contains("Account #"));
	}
	@Test(priority = 8)
	public void test_VerifyPartNumberTextIsEqualToCounter(){
		pageManager.homePage().shoppingCartIcon.click();
		waitTool.waitForElement(driver, pageManager.shoppingCartPage().partNumberDisplayed_text);

		pageManager.shoppingCartPage().displyedPartNumberText();
		Log.info("shoppingCartPage displyedPartNumberText size: " + pageManager.shoppingCartPage().displyedPartNumberText());
		Assert.assertEquals(pageManager.shoppingCartPage().displyedPartNumberText(), counter);
	}
	@Test(priority = 9)
	public void test_placeTheOrder() throws Exception {

		pageManager.shoppingCartPage().insertSourceCode(pageManager.common().getRandomNumber());
		pageManager.shoppingCartPage().clickShoppingCartCheckOutButton();
		waitTool.waitForElement(driver,pageManager.paymentAndCheckOutPage().addPaymentAndCheckoutText);
		pageManager.paymentAndCheckOutPage().insertPONumber();
		pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
		/*String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
		Log.info("orderNumber is "+ orderNumber);
		Assert.assertTrue(pageManager.orderConfirmationPage().storeOrderNumber().contains("W"));*/
	}
}
