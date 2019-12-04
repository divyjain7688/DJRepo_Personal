/**
 * 

 * @author suresh
 * modified by Iuliia
 * 12/12/2018
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
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddToCartSubCategoryPageLoggedInUser_WORKING extends BaseClassV8_Parallel {

	/*
	 *  Login with Valid Credentials
	 */

	@Test(priority = 0)
	public void test_Login()
	{
		LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
	//	homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));

	}


	@Test(priority = 1)
	public void test_verifyLeftNavgation() throws Exception
	{
		Assert.assertTrue(pageManager.homePage().isDisplayedLeftNavgation());
	}

	@Test(priority = 3)
	public void test_verifyListViewDisplayed() throws Exception {
		pageManager.homePage().moveToSubCategoryPage();
		Log.info("Selected sub categories");
		// click on the List View
		Assert.assertTrue(pageManager.productListingPage().isDisplayedListViewButton());
	}

	@Test(priority = 4)
	public void test_addToCartSubCategoryAndVerifyMessage() throws Exception
	{

		pageManager.productListingPage().getFirstProductPartNumber();
		pageManager.productListingPage().clickonFirstProductAddToCart();
	//TODO- add another assertion
		// 	Assert.assertTrue(pageManager.productListingPage().isDisplayedAddToCartSuccessPopup());
	}


}
