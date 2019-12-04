/**
 * 
 * @author Bhavani
 * 
 * FMQA-2361 Verify if item can be added to the cart through Product Listing Page - List View
 * 
 * ALM Test Instance ID: 649146
 * 
 */
package com.selenium.ebiz.add_to_cart.addtocart_nonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyIfItemCanBeAddedToTheCartThroughPLPListView extends BaseClassV8_Parallel {

	/**
	 *  Verifying the add to Cart from PLP List View
	 * @throws Exception
	 */

	@Test(description="Login")
	public void testLogin() throws Exception {
		LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		Assert.assertTrue(pageManager.homePage().isDisplayedLeftNavgation());
	}
	
	@Test(dependsOnMethods = {"testLogin"}, description="Cart Empty Confirmation")
    public void testClearCart() throws Exception{
        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");
    }
	
	@Test(dependsOnMethods = {"testClearCart"}, description="Verify ListView Button Displayed ")
	public void test_verifyListViewButtonDisplayed() throws Exception {
		Log.info("Before moving to Sub Category");
		pageManager.homePage().moveToSubCategoryPage();
		Log.info("After moving to Sub Category");
		Assert.assertTrue(pageManager.productListingPage().isDisplayedListViewButton());
	}

	@Test(dependsOnMethods = {"test_verifyListViewButtonDisplayed"}, description="Verify PLP In ListView Pattern")
	public void test_verifyPLPInListView() throws Exception
	{
		pageManager.productListingPage().clickOnListView();
		Assert.assertTrue(pageManager.productListingPage().productListingPageListView.isDisplayed());
	}
	
	@Test(dependsOnMethods = {"test_verifyPLPInListView"}, description="Add To Cart From PLP List View")
	public void test_addToCartFromPLPListView() throws Exception
	{
		pageManager.productListingPage().clickonFirstProductAddToCartListView();
		pageManager.homePage().clickOnShoppingCartIcon();
		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
	}
	
	@Test(dependsOnMethods = {"test_addToCartFromPLPListView"}, description="Logout")
	public void testLogout() throws Exception
	{
		pageManager.loginPage().logoutOfApplication();

	}

}
