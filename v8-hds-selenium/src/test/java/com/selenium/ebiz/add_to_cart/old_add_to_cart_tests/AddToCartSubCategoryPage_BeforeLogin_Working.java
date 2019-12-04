/**
 * 
 * @author suresh
 * 
 * This test will verify Add to Cart in the Sub Category Page
 * 
 * This Test Script is mapped to US-CAT-272
 * 
 * 
 * 
 */
package com.selenium.ebiz.add_to_cart.old_add_to_cart_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddToCartSubCategoryPage_BeforeLogin_Working extends BaseClassV8_Parallel {

	/**
	 *  Verifying the add to Cart in the Sub Category pages
	 * Reviewed and modified by Iuliia
	 * @throws Exception
	 */

	@Test(priority = 1)
	public void test_VerifyLeftNavigationisDispplayed() throws Exception {

		Assert.assertTrue(pageManager.homePage().isDisplayedLeftNavgation());
	}
	@Test(priority = 2)
	public void test_verifyListViewDisplayed() throws Exception {
		pageManager.homePage().moveToSubCategoryPage();
		Log.info("Selected sub categories");
		// click on the List View
		Assert.assertTrue(pageManager.productListingPage().isDisplayedListViewButton());
	}

	@Test(priority = 3)
	public void test_addToCartSubCategoryAndVerifyMessage() throws Exception
	{

		pageManager.productListingPage().getFirstProductPartNumber();
		pageManager.productListingPage().clickonFirstProductAddToCart();
		//Assert.assertTrue(pageManager.productListingPage().isDisplayedAddToCartSuccessPopup());
	}

}
