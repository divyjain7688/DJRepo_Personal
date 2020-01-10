package com.selenium.ebiz.add_to_cart;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MinicartPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.tools.WaitTool;

public class AddPartsToCart_ShoppingCart_WORKING extends BaseClass{
	LoginPage loginPage;
	HomePage homePage;
	ShoppingCartPage shoppingCartPage;
	MinicartPage minicartPage;
	ArrayList<UsersListBean> usersList1,usersList2;
	DBCon dbConnection = new DBCon();

	@BeforeMethod	
	public void driverSetup() throws Exception {

		driver = initialize();
		loginPage = new LoginPage(driver);
		usersList1 = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList1.get(0).getuserName(), usersList1.get(0).getpassword());		
	}


	/**
	 * Reviewed and modified by Bhavani
	 * @throws Exception
	 */
	@Test
	public void verifyQuickAddPartsToCart() throws Exception {
		WaitTool.hardWait();
		//Validating the HomePage displayed or not by checking Hi text.
		shoppingCartPage = loginPage.clickShoppingCartIcon();
		Assert.assertTrue(shoppingCartPage.isDisplayedAddPartsToYourCart());
		/*Assert.assertTrue(shoppingCartPage.isDisplayedPartNumber());
		Assert.assertTrue(shoppingCartPage.isDisplayedQuantity());*/
		//shoppingCartPage.clearCart();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
		} 
		else 
		{
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCart();
		}

		usersList2 = dbConnection.loadDataFromExcel("verifyQuickAddPartsToCart", "QuickOrder");
		shoppingCartPage.addPartsToYourCart(usersList2.get(0).getPartNumber1(), usersList2.get(0).getQuantity1());
		//Assert.assertTrue(shoppingCartPage.getSuccessOrErrorMessageText().equalsIgnoreCase("The item has been successfully added to your current order"));
		Assert.assertEquals(shoppingCartPage.getQuantityOfAddedItemInCart(),usersList2.get(0).getQuantity1());

		WaitTool.hardWait();
		shoppingCartPage.clearCart();
		shoppingCartPage.addPartsToYourCart(usersList2.get(0).getPartNumber2(), usersList2.get(0).getQuantity1());
		String partNumber = usersList2.get(0).getPartNumber2();/*.substring(0, 6);*/
		System.out.println("partNumber: "+partNumber);
		Assert.assertTrue(shoppingCartPage.isErrorMessageTextDisplayed());
	}

}
