package com.selenium.ebiz.mini_cart_outofscope;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.Appliances;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MinicartPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.WaitTool;

public class MiniCartShowNumberOfItems_WORKING extends BaseClass{
	LoginPage loginPage;
	HomePage homePage;
	ShoppingCartPage shoppingCartPage;
	Appliances appliances;	
	ProductPage productPage;
	SubCategoryAppliancesPage subcategoryAppPage;
	ProductDetailsPage productDetailsPage;
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	MinicartPage minicartPage;

	@BeforeMethod
	public void driverSetup() throws Exception {
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());		
	}

	/** Out of scope
	 * @author Smitha
	 * 
	 * This test will verify number of items in my Cart On the Minicart widget. 
	 * Number of Items displayed on Minicart should match with Cart Items count
	 * 
	 * This TestScript is Mapped to the US-Ord-242
	 */

	//@Test
	public void verifyMiniCartWidgetShowNumberOfItemsTest() throws Exception {

		WaitTool.hardWait();

		//Validating the HomePage displayed or not by checking Hi text.
		System.out.println( homePage.getWelcomeNote());	
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); 

		minicartPage = loginPage.clickOnShoppingCartIcon();
		if(minicartPage.isDisplayedHeaderMiniCartEmpty()) {			
			Assert.assertEquals(minicartPage.getHeaderMinicartEmptyText(), "There are currently no items in your shopping cart.");

		}else {
			shoppingCartPage = minicartPage.clickViewCartButton();
			String itemsCountInCartBeforeAddItemToCart = shoppingCartPage.getItemsCountFromCart();
			minicartPage = loginPage.clickOnShoppingCartIcon();
			Assert.assertEquals(itemsCountInCartBeforeAddItemToCart , minicartPage.getMiniCartHeaderDisplayTotalNumberOfItems());

			homePage.clickHeaderShopByCategoryLinkText();
			WaitTool.hardWait();
			appliances = homePage.clickCategoryAppliancesLinkText();
			subcategoryAppPage = appliances.clickTopCategoryDishwashersRepairLinkText();
			productPage = subcategoryAppPage.clickSubCategoryDishwashersLinkText();
			Assert.assertTrue(productPage.verifyProductsDisplayed());
			productDetailsPage = productPage.clickFirstProductInProductList();
			Assert.assertTrue(productDetailsPage.isDisplayedproductDetailsHeader());		
			productDetailsPage.clickAddToCartButton();
			homePage.clickBreadCrumbHomeLinkText();
			minicartPage = loginPage.clickOnShoppingCartIcon();
			shoppingCartPage = minicartPage.clickViewCartButton();
			String itemsCountInCartAfterAddItemToCart = shoppingCartPage.getItemsCountFromCart();
			minicartPage = loginPage.clickOnShoppingCartIcon();
			Assert.assertEquals(itemsCountInCartAfterAddItemToCart , minicartPage.getMiniCartHeaderDisplayTotalNumberOfItems());

		}

	}

}
