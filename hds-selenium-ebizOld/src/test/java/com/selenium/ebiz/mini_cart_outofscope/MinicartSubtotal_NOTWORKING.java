package com.selenium.ebiz.mini_cart_outofscope;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MinicartPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.tools.WaitTool;

public class MinicartSubtotal_NOTWORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	ShoppingCartPage shoppingCartPage;
	MinicartPage minicartPage;

	@BeforeMethod
	public void driverSetup() throws Exception {
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());		
	}

	/** Out of scope
	 * 
	 * @author Smitha
	 * This test will verify cart subtotal displayed On the Minicart widget	 
	 * Minicart subtotal should match with the total amount shown in Shopping cart page
	 * This TestScript is Mapped to the US-Ord-241
	 */

	//@Test
	public void verifyMiniCartWidgetSubtotalTest() throws Exception {

		WaitTool.hardWait();

		//Validating the HomePage displayed or not by checking Hi text.
		System.out.println( homePage.getWelcomeNote());	
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); 

		minicartPage = loginPage.clickOnShoppingCartIcon();
		if(minicartPage.isDisplayedHeaderMiniCartEmpty()) {			
			Assert.assertEquals(minicartPage.getHeaderMinicartEmptyText(), "There are currently no items in your shopping cart.");
		}else {	
			shoppingCartPage = minicartPage.clickViewCartButton();
			String cartSubtotal = shoppingCartPage.getCartSubtotal();
			minicartPage = loginPage.clickOnShoppingCartIcon();
			Assert.assertTrue(minicartPage.isDisplayedMinicartSubtotal());
			Assert.assertEquals(minicartPage.getMinicartSubtotal(), cartSubtotal);
		}	
	}

}
