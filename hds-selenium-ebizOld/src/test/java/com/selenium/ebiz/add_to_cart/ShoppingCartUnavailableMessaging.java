/**
 * @author nm064123
 */

package com.selenium.ebiz.add_to_cart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.PropertyLookupPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.tools.WaitTool;

public class ShoppingCartUnavailableMessaging extends BaseClass{

	HomePage homePage;
	LoginPage loginPage;
	ShoppingCartPage shoppingCartPage;
	PropertyLookupPage propertyLookupPage;

	@BeforeMethod
	public void initializeDriver() throws Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
		WaitTool.hardWait();
		//Validating the HomePage displayed or not by checking Hi text.
		System.out.println( homePage.getWelcomeNote());	
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); 
		propertyLookupPage = homePage.clickPropertyDropdown();
		propertyLookupPage.clickSAPWebTestActCoreArif();
		homePage = propertyLookupPage.clickOnHDSupplyLogoInHeader();
		shoppingCartPage = homePage.clickOnShoppingCartIcon();

	}

	/**
	 * 
	 * @author nm064123
	 * @throws Exception 
	 * @Story US-Ord-210 Shopping Cart- Unavailable item
	 * This Method adds an unavailable item to cart and verifies the error message is displayed
	 *  
	 */

	@Test
	public void validateUnavailableItemMessage() throws Exception {
		shoppingCartPage.validateUnavailableMessage("312180");
		Assert.assertEquals(shoppingCartPage.getUnavailableMessage(),"Sorry! This item 312180 is no longer available.\nPlease choose another item, or remove this item to continue.");
	}

	 
}
