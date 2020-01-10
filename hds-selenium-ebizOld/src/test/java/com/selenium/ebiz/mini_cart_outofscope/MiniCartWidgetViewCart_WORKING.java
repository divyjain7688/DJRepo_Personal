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

public class MiniCartWidgetViewCart_WORKING extends BaseClass{
	LoginPage loginPage;
	HomePage homePage;
	ShoppingCartPage shoppingCartPage;
	MinicartPage minicartPage;
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();

	@BeforeMethod	
	public void driverSetup() throws Exception {
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());			
	}

	/**Out of scope
	 * 
	 * @author Smitha
	 * 
	 * This test will verify Minicart Widget on Homepage header and verfiy modal overlay should be displayed with cart details
	 * Verify modal if there are no items in the cart
	 * 
	 * This TestScript is Mapped to the US-Ord-246
	 * 
	 * 
	 */
	//@Test	
	public void verifyMiniCartWidgetViewCartTest() throws Exception {

		WaitTool.hardWait();

		//Validating the HomePage displayed or not by checking Hi text.
		System.out.println( homePage.getWelcomeNote());	
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); 

		minicartPage = loginPage.clickOnShoppingCartIcon();
		shoppingCartPage = minicartPage.clickViewCartButton();
		Assert.assertTrue(shoppingCartPage.isDisplayedShoppingCartPage());

	}

}
