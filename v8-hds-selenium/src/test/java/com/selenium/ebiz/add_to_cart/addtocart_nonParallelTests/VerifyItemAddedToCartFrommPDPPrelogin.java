package com.selenium.ebiz.add_to_cart.addtocart_nonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author dj073227
 * To Verify if item can be added to the Cart from Product Detail Page - Prelogin
 * ALM Test Instance id 649231
 *
 */
public class VerifyItemAddedToCartFrommPDPPrelogin  extends BaseClassV8_Parallel
{
	String displayedPriceOnPDP,displayedPriceOnSC,displayedPartNumberOnSC;

	@Test(description="Cart Empty Confirmation")
	public void testClearCart() throws Exception{
		pageManager.shoppingCartPage().checkClearShoppingCart();
		Log.info("Shopping cart was checked and cleared");
	}

	@Test(dependsOnMethods = {"testClearCart"}, description="Search by Product Number")
	public void test_searchByProductNumber() throws Exception{
		GetUserList("searchByKeywordOrPartNumber","Search");
		Log.info(usersList.get(0).getSearchProductPartNumber());
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		displayedPriceOnPDP = pageManager.productDetailsPage().getDisplayedPrice();
	}

	@Test(dependsOnMethods = {"test_searchByProductNumber"}, description="Add Product to Cart from PDP")
	public void test_AddProductFromPDP() throws Exception
	{
		pageManager.productDetailsPage().clickAddToCartButton();
	}

	@Test(dependsOnMethods = {"test_AddProductFromPDP"}, description="verify product on Shopping cart page")
	public void test_verifyProductOnSCPage() throws Exception
	{
		GetUserList("searchByKeywordOrPartNumber","Search");
		pageManager.homePage().clickOnShoppingCartIcon();
		displayedPartNumberOnSC=pageManager.shoppingCartPage().getDisplayedPartNumber();
		displayedPriceOnSC=pageManager.shoppingCartPage().getDisplayedPrice();
		Assert.assertTrue(displayedPartNumberOnSC.contains(usersList.get(0).getSearchProductPartNumber()));
		Assert.assertEquals(displayedPriceOnSC, displayedPriceOnPDP);

	}
/*
	@Test(dependsOnMethods = {"test_verifyProductOnSCPage"}, description="verify Address book and Source code")
	public void test_verifyAddressBookSourceCode()
	{
		pageManager.shoppingCartPage().isDisplayedSourceCode();
		pageManager.shoppingCartPage().isDefaultShippingAddressDisplayed();
	}
*/
}
