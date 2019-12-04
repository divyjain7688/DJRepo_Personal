package com.selenium.ebiz.mini_cart_outofscope;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MiniCartShowNumberOfItems_WORKING extends BaseClassV8_ParallelGrid{

	/** Out of scope
	 * @author Smitha
	 * 
	 * This test will verify number of items in my Cart On the Minicart widget. 
	 * Number of Items displayed on Minicart should match with Cart Items count
	 * 
	 * This TestScript is Mapped to the US-Ord-242
	 */

	@Test(description= "Verify MiniCart Widget Show NumberOfItems ",dataProvider = "browsers")
	public void verifyMiniCartWidgetShowNumberOfItemsTest(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

		pageManager.homePage().clickOnShoppingCartIcon();
		if(pageManager.minicartPage().headerMinicartEmpty.isDisplayed()) {			
			pageManager.minicartPage().getHeaderMinicartEmptyText().contains("There are currently no items in your shopping cart.");
		}else {	
			pageManager.minicartPage().clickViewCartButton();
			String itemsCountInCartBeforeAddItemToCart = pageManager.shoppingCartPage().getItemsCountFromCart();
			pageManager.homePage().clickOnShoppingCartIcon();
			itemsCountInCartBeforeAddItemToCart.equals(pageManager.minicartPage().getMiniCartHeaderDisplayTotalNumberOfItems());
			pageManager.homePage().clickHeaderShopByCategoryLinkText();
			pageManager.homePage().clickCategoryAppliancessLinkText();
			pageManager.appliances().clickTopCategoryDishwashersRepairLinkText();
			pageManager.subCategoryAppliancesPage().clickSubCategoryDishwashersLinkText();
			pageManager.productPage().verifyProductsDisplayed();
			pageManager.productPage().clickFirstProductInProductList();
			pageManager.productDetailsPage().isDisplayedproductDetailsHeader();		
			pageManager.productDetailsPage().clickAddToCartButton();
			pageManager.homePage().clickBreadCrumbHomeLinkText();
			pageManager.homePage().clickOnShoppingCartIcon();
			pageManager.minicartPage().clickViewCartButton();
			String itemsCountInCartAfterAddItemToCart =pageManager.shoppingCartPage().getItemsCountFromCart();
			pageManager.homePage().clickOnShoppingCartIcon();
			Assert.assertEquals(itemsCountInCartAfterAddItemToCart , pageManager.minicartPage().getMiniCartHeaderDisplayTotalNumberOfItems());
		}

	}

}
