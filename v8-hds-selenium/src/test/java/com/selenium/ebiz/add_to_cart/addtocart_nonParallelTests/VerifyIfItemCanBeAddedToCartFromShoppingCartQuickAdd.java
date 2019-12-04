/**
 * 
 * @author Bhavani
 * 
 *  FMQA-2352 Add to cart [1]To Verify if item can be added to cart from Shopping Cart Quick Add
 *  
 *  ALM Test Instance ID: 649230
 */
package com.selenium.ebiz.add_to_cart.addtocart_nonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;


public class VerifyIfItemCanBeAddedToCartFromShoppingCartQuickAdd extends BaseClassV8_Parallel {

	int productAddedToCart,displayedShoppingCartProductCount;
	String priceOnSCP;
	
	@Test
	public void test_VerifyIfItemCanBeAddedToCartFromShoppingCartQuickAdd() throws Exception {
		LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		//LoginToHDS(AccountsRandomSelectFromTextFile.users.pop(),configread.getPassword());
		Log.info("Login");
		
		pageManager.homePage().isDisplayedLeftNavgation();
		Log.info(pageManager.loginPage().loggedAccountNumberText.getText());
	
		pageManager.shoppingCartPage().checkClearShoppingCart();
		//Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
		Log.info("Clear the cart");
		
		GetUserList("invalidPartNumber", "QuickOrder");
		Log.info(" ******* partNumInvalid: " + usersList.get(0).getPartNumber1());
		String partNumInvalid = usersList.get(0).getPartNumber1();
		pageManager.shoppingCartPage().enterPartNumber(usersList.get(0).getPartNumber1());
		
		String partNumValid = pageManager.shoppingCartPage().getPartNumber();
		Log.info(" ******* partNumValid: " + pageManager.shoppingCartPage().getPartNumber() );
		assertNotEquals(partNumValid, partNumInvalid);
	
		GetUserList("invalidPartNumber", "QuickOrder");
		Log.info(" ******* qtyInvalid: " + usersList.get(0).getQuantity1());
		String qtyInvalid = usersList.get(0).getQuantity1();
		pageManager.shoppingCartPage().enterQuantity((usersList.get(0).getQuantity1()));
		
		String qtyValid = pageManager.shoppingCartPage().getQty();
		Log.info(" ******* qtyValid: " + pageManager.shoppingCartPage().getQty() );
		assertNotEquals(qtyValid, qtyInvalid);
	
	
		GetUserList("verifyQuickAddPartsToCart", "QuickOrder");
		pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getPartNumber1(), usersList.get(0).getQuantity2());

		productAddedToCart = pageManager.homePage().counterIncrease(productAddedToCart);
		Log.info("productAddedToCart is "+ productAddedToCart);

		pageManager.common().refresh();
		displayedShoppingCartProductCount = pageManager.homePage().getShoppingCartProductCount();
		Log.info("displayedShoppingCartProductCount is "+ displayedShoppingCartProductCount);
		Assert.assertEquals(displayedShoppingCartProductCount, productAddedToCart);

	
		String part= "PART " + usersList.get(0).getPartNumber1();
		Log.info(pageManager.shoppingCartPage().getPartNumberText());
		Assert.assertEquals(pageManager.shoppingCartPage().getPartNumberText(), part);
		
	
		priceOnSCP = pageManager.shoppingCartPage().getProductPrice();
		pageManager.shoppingCartPage().productImage.isDisplayed();
	
		
		pageManager.shoppingCartPage().clickProductImage();
		pageManager.productDetailsPage().productDetailsModuleTitle.isDisplayed();
	
		String priceOnPDP = pageManager.productDetailsPage().getProductPrice();
		//pageManager.productDetailsPage().PageNavigateBack();
        pageManager.common().navigateBack();
		Log.info("priceOnSCP: " + priceOnSCP+ "          "+"priceOnPDP: "+ priceOnPDP);
		Assert.assertEquals(priceOnSCP, priceOnPDP);
	
	
		pageManager.loginPage().logoutOfApplication();


}
	
}	
