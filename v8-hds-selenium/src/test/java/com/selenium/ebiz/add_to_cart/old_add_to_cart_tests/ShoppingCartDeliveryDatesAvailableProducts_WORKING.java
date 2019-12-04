package com.selenium.ebiz.add_to_cart.old_add_to_cart_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartDeliveryDatesAvailableProducts_WORKING extends BaseClassV8_Parallel {
	int counter;

	@Test(priority = 0)
	public void test_Login() throws Exception {

		LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		waitTool.waitForElement(driver,pageManager.loginPage().loggedAccountNumberText);

	}


	/**
	 *@storyDescription :  To verify As a user I want my defaut shipping address to appear on the Shopping Cart page
	 *@US :US-Ord-202
	 *@author Lakshmi
	 * */

	@Test(priority = 1, description="Cart Empty Confirmation")
	public void testClearCart() throws Exception{
		pageManager.shoppingCartPage().checkClearShoppingCart();
		Log.info("Check and clear Shopping cart");

	}
	@Test(priority = 2)
	public void test_AddProductsPDP() throws Exception {


		pageManager.homePage().moveToSubCategoryPage();
		pageManager.productListingPage().clickonFirstProductAddToCart();
		//ToDO add the verification
		//	productListingPage.clickOnCloseAddtocartSuccessPopup();

		//productListingPage.refreshPage();
	//	counter = .counterIncrease();
		pageManager.productListingPage().addToCartAndNavigateToSCP(1);
	}
	@Test(priority = 3)
	public void test_verifyDeliveryDatesSorted() throws Exception
	{

		//productListingPage.clickOnCloseAddtocartSuccessPopup();
		counter = pageManager.common().counterIncrease();
		Log.info("Counter when 2 products added  " + counter);
	//	pageManager.homePage().clickOnHDSupplyLogoInHeader();
		pageManager.homePage().shoppingCartIcon.click();
		Assert.assertTrue(pageManager.shoppingCartPage().isDeliverDatesSorted());
	}
	@Test(priority = 4)
	public void test_verifyPartNumberTextDisplayed() {
		int pnumber = pageManager.shoppingCartPage().displyedPartNumberText();
		Assert.assertEquals(pnumber, counter);
	}
	@Test(priority = 5)
	public void test_verifyQuantityStepperText()

	{
		int qstepper = pageManager.shoppingCartPage().displayedQuantityStepperText();
		Assert.assertEquals(qstepper, counter);
	}
	@Test(priority = 6)
	public void test_verifyProductPriceText()

	{
		int prodprice = pageManager.shoppingCartPage().displayedProductPriceText();
		Assert.assertEquals(prodprice, counter);
	}
	@Test(priority = 7)
	public void test_verifyAddToListBtnDisplayed()

	{
		int addToList = pageManager.shoppingCartPage().isAddToListButtonDisplayed();
		Assert.assertEquals(addToList, counter);
	}
	@Test(priority = 8)
	public void test_verifyAddToQuoteButtonDisplayed()
	{
		int addToQuote = pageManager.shoppingCartPage().isAddToQuoteButtonDisplayed();
		Assert.assertEquals(addToQuote, counter);

	}

}

