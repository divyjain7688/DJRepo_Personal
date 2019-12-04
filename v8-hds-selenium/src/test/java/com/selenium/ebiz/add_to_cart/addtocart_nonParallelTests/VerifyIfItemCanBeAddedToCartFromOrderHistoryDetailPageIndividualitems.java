/**
 * 
 * @author Bhavani
 * 
 * FMQA-2445 Verify If Item Can Be Added To Cart From Order History Detail Page - Individual items
 * 
 * ALM Test Instance ID: 649407
 */
package com.selenium.ebiz.add_to_cart.addtocart_nonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyIfItemCanBeAddedToCartFromOrderHistoryDetailPageIndividualitems extends BaseClassV8_Parallel {
	//WebDriver driver = this.getDriver();

	/**
	 *  Verifying the add to Cart from PLP List View
	 * @throws Exception
	 */

	int productAddedToCart,displayedShoppingCartProductCount;
	String partNumberFromOHDP, partNumberFromSCP;
	String productPriceFromOHDP, productPriceFromSCP;
	
	@Test(description="Login")
	public void testLogin(){
		LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
	}

	@Test(dependsOnMethods ={"testLogin"}, description="Clear Cart")
	public void testClearCart() throws Exception {
		pageManager.shoppingCartPage().checkClearShoppingCart();
		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
	}

	@Test(dependsOnMethods ={"testClearCart"}, description="Verify Orders Page")
	public void verifyOrdersPage(){
		pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
		Assert.assertTrue(pageManager.ordersPage().isDisplayedOrderspageHeading());
	}

	@Test(dependsOnMethods ={"verifyOrdersPage"}, description=" Verify Order History Details Page")
	public void verifyOrderHistoryDetailsPage() throws Exception {
		pageManager.ordersPage().clickOnFirstOrderNumberInOrdersPage();
		Assert.assertTrue(pageManager.ordersHistoryDetailsPage().isDisplayedOrderHistoryDetailsTitle());
	}

	@Test(dependsOnMethods ={"verifyOrderHistoryDetailsPage"}, description="Verify Item Added To Cart ")
	public void veriyItemAddedToCart() throws Exception {
		partNumberFromOHDP = pageManager.ordersHistoryDetailsPage().getFirstPartNumber();
		productPriceFromOHDP = pageManager.ordersHistoryDetailsPage().getFirstProductPrice();
		
		pageManager.ordersHistoryDetailsPage().clickOnFirstAddToCartButton();
	//	.refresh(driver);
		pageManager.homePage().HomePageRefresh();
		displayedShoppingCartProductCount = pageManager.homePage().getShoppingCartProductCount();
		Log.info("displayedShoppingCartProductCount is "+ displayedShoppingCartProductCount);
		
		productAddedToCart = pageManager.homePage().counterIncrease(productAddedToCart);
		Log.info("productAddedToCart is "+ productAddedToCart);

		Assert.assertEquals(displayedShoppingCartProductCount, productAddedToCart);
	}

	@Test(dependsOnMethods ={"veriyItemAddedToCart"}, description="Verify Shopping Cart Page")
	public void verifyShoppingCartPage(){
		pageManager.homePage().shoppingCartIcon.click();
		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
	}

	@Test(dependsOnMethods ={"verifyShoppingCartPage"}, description="Verify Product Part Number")
	public void verifyProductPartNumber(){
		partNumberFromSCP = pageManager.shoppingCartPage().getPartNumberText();
		Assert.assertEquals(partNumberFromSCP, "PART " + partNumberFromOHDP);
	}
	
	@Test(dependsOnMethods ={"verifyProductPartNumber"}, description="Verify Product Price")
	public void verifyProductPrice(){
		productPriceFromSCP = pageManager.shoppingCartPage().getProductPrice();
		Log.info("productPriceFromSCP: "+ productPriceFromSCP +"    " + "productPriceFromOHDP: " +  productPriceFromOHDP);
		Assert.assertEquals(productPriceFromSCP,  productPriceFromOHDP);
	}

	@Test(dependsOnMethods ={"verifyProductPrice"}, description="Logout")
	public void testLogout()
	{
		pageManager.loginPage().logoutOfApplication();

	}

}
