package com.selenium.ebiz.mini_cart_outofscope;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MinicartInHeader_WORKING extends BaseClassV8_ParallelGrid{
	

	/**Out of scope
	 * 
	 * @author Smitha
	 * 
	 * This test will verify Minicart Widget on Homepage header and verfiy model overlay should be displayed with cart details
	 * Verify modal if there are no items in the cart
	 * 
	 * This TestScript is Mapped to the US-Ord-246
	 * 
	 * 
	 */

	@Test(description= "Verify MiniCart Widget In HeaderTest",dataProvider = "browsers")
	public void verifyMiniCartWidgetInHeaderTest(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickOnShoppingCartIcon();
		if(pageManager.minicartPage().headerMinicartEmpty.isDisplayed()) {			
			Assert.assertEquals(pageManager.minicartPage().getHeaderMinicartEmptyText(), "There are currently no items in your shopping cart.");

		}else {	
			Assert.assertTrue(pageManager.minicartPage().minicartSubTotal.isDisplayed() && pageManager.minicartPage().miniCartHeaderTotalNumberOfItems.isDisplayed() && pageManager.minicartPage().viewCartButton.isDisplayed() );

		}

	}

}
