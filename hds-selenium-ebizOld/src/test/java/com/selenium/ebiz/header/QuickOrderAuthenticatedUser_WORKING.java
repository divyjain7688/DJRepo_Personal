package com.selenium.ebiz.header;

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
import com.selenium.ebiz.pageobject.QuickOrderPad;
import com.selenium.ebiz.pageobject.QuickOrderPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.tools.WaitTool;

public class QuickOrderAuthenticatedUser_WORKING extends BaseClass{

	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	QuickOrderPad quickOrderPad;
	QuickOrderPage quickOrderPage;
	MinicartPage miniCartPage;
	ShoppingCartPage shoppingCartPage;

	/**
	 * This method is used to load the property file, launch the browser, 
	 */
	@BeforeMethod
	public void driverSetup() throws Exception
	{
		driver=initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("verifyLogin","LoginTestData");
		loginPage.clickOnRegisterOrSignIn();
		homePage= loginPage.signInToApplication(usersList.get(0).getuserName(),usersList.get(0).getpassword());
		/*miniCartPage = homePage.clickOnShoppingCartIcon();
		if(miniCartPage.isDisplayedHeaderMiniCartEmpty()){
			homePage = miniCartPage.clickOnShoppingCartIcon();
		}else{
			ShoppingCartPage shoppingCartPage = miniCartPage.clickViewCartButton();
			homePage = shoppingCartPage.clearCartReturnsHomePage();	
		}*/
	}

	/*Scripting is done till step 4. Fucntionality is not available from step 5 in google doc*/
	/** dj073227
	 *US-Ord-185 - This method is used to verify that authenticated user can click on quick order link and add product.User can navigate 
	 *to quick order page and able to verify all buttons, labels on Quick order page.
	 */
	@Test(priority=0)
	public void addProductsUsingQuickOrder() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("addProductsUsingQuickOrder","QuickOrder");
		quickOrderPad=homePage.clickOnQuickOrderLink();
		Assert.assertTrue(quickOrderPad.isDisplayedDefaultSixRowsInQuickOrderPad());
		quickOrderPad.clickAddMoreRowsFirstTime();
		Assert.assertTrue(quickOrderPad.isDisplayedTwelveRowsInQuickOrderPad());
		quickOrderPad.fillFirstSixPartNumberTextBox(usersList.get(0).getPartNumber1(),usersList.get(0).getPartNumber2(),usersList.get(0).getPartNumber3(),
				usersList.get(0).getPartNumber4(),usersList.get(0).getPartNumber5(),usersList.get(0).getPartNumber6());
		quickOrderPad.fillFirstSixQuantityTextBox(usersList.get(0).getQuantity1(),usersList.get(0).getQuantity2(),usersList.get(0).getQuantity3(),
				usersList.get(0).getQuantity4(),usersList.get(0).getQuantity5(),usersList.get(0).getQuantity6());
		WaitTool.hardWait();
		quickOrderPage = quickOrderPad.clickAddMoreRowsSecondTime();
		Assert.assertTrue(quickOrderPage.isDisplayedAddToCartButton());
		Assert.assertTrue(quickOrderPage.isAddToListButtondisplayed());
		//Assert.assertTrue(quickOrderPage.isAddToQuoteButtondisplayed());
		Assert.assertTrue(quickOrderPage.isAddMorePartsButtondisplayed());
		Assert.assertTrue(quickOrderPage.insertSpecialCharInPartNumberTextbox(usersList.get(0).getPartNumber7()));
	}

	
}
