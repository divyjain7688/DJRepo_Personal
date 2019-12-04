/**
 * 
 * @author Bhavani
 * 
 * FMQA-2447 Verify If Item Can Be Added To Cart From Order History Detail Page - All items
 * 
 * ALM Test Instance ID: 649410
 */
package com.selenium.ebiz.add_to_cart.addtocart_nonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class VerifyIfItemCanBeAddedToCartFromOrderHistoryDetailPageAllitems extends BaseClassV8_Parallel {

	/**
	 *  Verifying the add to Cart from PLP List View
	 * @throws Exception
	 */

	int productAddedToCart,displayedShoppingCartProductCount;
	String partNumberFromOHDP, partNumberFromSCP;
	String productPriceFromOHDP, productPriceFromSCP;
	List<String> OHDP, OHDPPrice;
	List<String> SCP, SCPPrice;
	
	
	@Test
	public void test_VerifyIfItemCanBeAddedToCartFromOrderHistoryDetailPageAllitems() throws Exception {
		LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		Log.info("Login");
		
		pageManager.shoppingCartPage().checkClearShoppingCart();
		Log.info("Clear the cart");
		pageManager.shoppingCartPage().isDisplayedShoppingCartTitle();
		
		pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
		Log.info("Navigate to Order History Status");
		pageManager.ordersPage().isDisplayedOrderspageHeading();
		//pageManager.ordersPage().clickCreatedOrderNumberInOrdersPage("W240030807");
		pageManager.ordersPage().clickOnFirstOrderNumberInOrdersPage();
		Log.info("Select first order number in orders page");
		
		pageManager.ordersHistoryDetailsPage().isDisplayedOrderHistoryDetailsTitle();
		Log.info("Order History Details page title is displayed");
		pageManager.ordersHistoryDetailsPage().clickOnShowItems();
		Log.info("Click on Show items");
		OHDP = pageManager.ordersHistoryDetailsPage().getAllPartNumbers();
		Log.info("Get all the part numbers in OHDP: " + OHDP);
		OHDPPrice = pageManager.ordersHistoryDetailsPage().getAllProductPrice();
		Log.info("Get the price of all part numbers in OHDP: " + OHDPPrice);
		pageManager.ordersHistoryDetailsPage().clickOnAddAllToCartButton();
		Log.info("Click Add All to cart");
		
		pageManager.shoppingCartPage().isDisplayedShoppingCartTitle();
		Log.info("Verify SC page is displayed");
		SCP = pageManager.shoppingCartPage().getAllPartNumbers();
		Log.info("Get all part numbers in SC page");
		
		pageManager.shoppingCartPage().compareParts(OHDP, SCP);
		Log.info("Compare Parts OHDP and SCP");
		SCPPrice = pageManager.shoppingCartPage().getAllProductPrice();
		Log.info("Get all product price in SC page");
		Assert.assertTrue(pageManager.shoppingCartPage().compareParts(OHDPPrice, SCPPrice));
		Log.info("Compare Prices OHDPPrice and SCPPrice");
		pageManager.loginPage().logoutOfApplication();
	}

	
	
}
