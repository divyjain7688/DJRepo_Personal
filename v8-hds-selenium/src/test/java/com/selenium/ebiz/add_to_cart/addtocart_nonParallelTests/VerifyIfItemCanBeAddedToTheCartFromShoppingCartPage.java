/**
 * 
 * @author Bhavani
 * 
 * FMQA-2362 08_To Verify if item can be added to the cart from Shopping Cart Page
 * 
 * ALM Test Instance ID: 649222
 */
package com.selenium.ebiz.add_to_cart.addtocart_nonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyIfItemCanBeAddedToTheCartFromShoppingCartPage extends BaseClassV8_Parallel {

	/**
	 *  Verifying the add to Cart from PLP List View
	 * @throws Exception
	 */

	int productAddedToCart,displayedShoppingCartProductCount;
	
	@Test(description="Login")
	public void testLogin() throws Exception {
		LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		Assert.assertTrue(pageManager.homePage().isDisplayedLeftNavgation());
	}
	
	@Test(dependsOnMethods ={"testLogin"}, description="Clear Cart")
	public void testClearCart() throws Exception {
		pageManager.shoppingCartPage().checkClearShoppingCart();
		//Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
	}

	@Test(dependsOnMethods ={"testClearCart"}, description=" Item added to cart from SCP")
	public void test_itemAddedToCartFromSCP() throws Exception
	{
		GetUserList("verifyQuickAddPartsToCart", "QuickOrder");
		pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getPartNumber1(), usersList.get(0).getQuantity1());
		
	}
	
	@Test(dependsOnMethods ={"test_itemAddedToCartFromSCP"}, description="verify Item Added To Cart Count Updated")
	public void test_verifyItemAddedToCartCountUpdated() throws Exception{

		productAddedToCart = pageManager.homePage().counterIncrease(productAddedToCart);
		Log.info("productAddedToCart is "+ productAddedToCart);
//		.refresh(driver);

		displayedShoppingCartProductCount = pageManager.homePage().getShoppingCartProductCount();
		Log.info("displayedShoppingCartProductCount is "+ displayedShoppingCartProductCount);
		Assert.assertEquals(productAddedToCart, displayedShoppingCartProductCount);

	}
	
	@Test(dependsOnMethods ={"test_verifyItemAddedToCartCountUpdated"}, description="verify Item Added To Cart Part Number")
	public void test_verifyItemAddedToCartPartNumber() throws Exception{

		String part= "PART " + usersList.get(0).getPartNumber1();
		Log.info(pageManager.shoppingCartPage().partNumberDisplayed_text.getText());
		Assert.assertEquals(pageManager.shoppingCartPage().partNumberDisplayed_text.getText(), part);
		
	}
	
	@Test(dependsOnMethods ={"test_verifyItemAddedToCartPartNumber"}, description="Logout")
	public void testLogout() throws Exception
	{
		pageManager.loginPage().logoutOfApplication();

	}

}
