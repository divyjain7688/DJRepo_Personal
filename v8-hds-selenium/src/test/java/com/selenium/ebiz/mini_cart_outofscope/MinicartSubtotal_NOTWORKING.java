package com.selenium.ebiz.mini_cart_outofscope;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MinicartSubtotal_NOTWORKING extends BaseClassV8_ParallelGrid{


	/** Out of scope
	 * 
	 * @author Smitha
	 * This test will verify cart subtotal displayed On the Minicart widget	 
	 * Minicart subtotal should match with the total amount shown in Shopping cart page
	 * This TestScript is Mapped to the US-Ord-241
	 */

	@Test(description= "verify MiniCart Widget Subtotal Test",dataProvider = "browsers")
	public void verifyMiniCartWidgetSubtotalTest(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickOnShoppingCartIcon();
		if(pageManager.minicartPage().headerMinicartEmpty.isDisplayed()) {			
			pageManager.minicartPage().getHeaderMinicartEmptyText().contains("There are currently no items in your shopping cart.");
		}else {	
			pageManager.minicartPage().clickViewCartButton();
			String cartSubtotal = pageManager.shoppingCartPage().getCartSubtotal();
			pageManager.homePage().clickOnShoppingCartIcon();
			Assert.assertTrue(pageManager.minicartPage().headerMinicartEmpty.isDisplayed());
			Assert.assertEquals(pageManager.minicartPage().getMinicartSubtotal(), cartSubtotal);
		}	
	}

}
