/**
 * @author nm064123
 * @Modified Iuliia
 */

package com.selenium.ebiz.add_to_cart.old_add_to_cart_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartUnavailableMessaging_NotWorking extends BaseClassV8_Parallel {

	@Test
	public void test_login() throws Exception {
		LoginToHDS(configread.getUserName(), configread.getPassword());

		waitTool.waitForElement(driver,pageManager.homePage().propertyDropdown);
		pageManager.homePage().clickPropertyDropdown();
		pageManager.propertyLookupPage().clickSAPWebTestActCoreArif();
		pageManager.propertyLookupPage().clickOnHDSupplyLogoInHeader();
		pageManager.homePage().shoppingCartIcon.click();

	}

	/**
	 * 
	 * @author nm064123
	 * @modified Iuliia 12/17/2018
	 * @throws Exception 
	 * @Story US-Ord-210 Shopping Cart- Unavailable item
	 * This Method adds an unavailable item to cart and verifies the error message is displayed
	 *  
	 */

	@Test
	public void validateUnavailableItemMessage() throws Exception {
		pageManager.shoppingCartPage().validateUnavailableMessage("312180");
		Assert.assertEquals(pageManager.shoppingCartPage().getUnavailableMessage(),"Sorry! This item 312180 is no longer available.\nPlease choose another item, or remove this item to continue.");
	}

	 
}
