/**
 * 
 * @author Bhavani
 * 
 * FMQA-2363 Verify marketing Spots in PLP, Top category and cart pages
 * 
 * ALM Test Instance ID: 649229
 */
package com.selenium.ebiz.add_to_cart.addtocart_nonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyMarketingSpotsInPLPTopCategoryAndCartPages extends BaseClassV8_Parallel {

	/**
	 *  Verifying the add to Cart from PLP List View
	 * @throws Exception
	 */

	String partNum;
	
	@Test(description="Login")
	public void testLogin() throws Exception {
		LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
	}
	
	@Test(dependsOnMethods = {"testLogin"}, description="Clear Cart")
	public void testClearCart() throws Exception {
		pageManager.shoppingCartPage().checkClearShoppingCart();
		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
	}

	@Test(dependsOnMethods = {"testClearCart"}, description=" Verify HomePage")
	public void verifyHomePage() throws Exception
	{
		pageManager.homePage().clickOnHDSupplyLogoInHeader();
		Assert.assertTrue(pageManager.homePage().isDisplayedCategoryleftNavigation());
		
	}
	
	@Test(dependsOnMethods = {"verifyHomePage"}, description="verify Appliance Page")
	public void verifyAppliancePage() throws Exception{
		pageManager.homePage().clickCategoryAppliancessLinkText();
		Assert.assertTrue(pageManager.appliances().isDisplayedAppliancesTitle());
		
		
	}
	
	@Test(dependsOnMethods = {"verifyAppliancePage"}, description="verify PDP Page")
	public void verifyPDPPage() throws Exception{
		pageManager.appliances().clickTopCategoryWashersDryersLinkText();
		pageManager.productListingPage().clickFirstProductInProductList();
		Assert.assertTrue(pageManager.productDetailsPage().isDisplayedproductDetailsHeader());
		
	}
	
	@Test(dependsOnMethods = {"verifyPDPPage"}, description="verify Item Added To Cart")
	public void veriyItemAddedToCart() throws Exception{
		partNum = pageManager.productDetailsPage().getDisplayedPartNumber();
		pageManager.productDetailsPage().clickAddToCartButton();
		
	}
	
	@Test(dependsOnMethods = {"veriyItemAddedToCart"}, description="Verify Product Image On SCP")
	public void verifyProductImageOnSCP() throws Exception{
		pageManager.homePage().clickOnShoppingCartIcon();
		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedProductImage());
		Log.info(pageManager.shoppingCartPage().getDisplayedPartNumber());
		Assert.assertEquals(pageManager.shoppingCartPage().getDisplayedPartNumber(),partNum);
		
	}

	@Test(dependsOnMethods = {"verifyProductImageOnSCP"}, description="Logout")
	public void testLogout()
	{
		pageManager.loginPage().logoutOfApplication();

	}

}
