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
import com.selenium.ebiz.pageobject.QuickOrderPad;
import com.selenium.ebiz.tools.WaitTool;

public class QuickOrderMiniFormCheckout_WORKING extends BaseClass{

	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	QuickOrderPad quickOrderPad;

	/**
	 * This method is used to load the property file, launch the browser, 
	 */
	@BeforeMethod
	public void driverSetup() throws Exception
	{
		driver = initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("verifyLogin","LoginTestData");
		loginPage.clickOnRegisterOrSignIn();
		homePage= loginPage.signInToApplication(usersList.get(0).getuserName(),usersList.get(0).getpassword());
	}

	/**  
	 *US-Ord-163 - This method is used to verify QuickOrder checkout.
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
		quickOrderPad.fillFirstSixQuantityTextBox(usersList.get(0).getQuantity1(),usersList.get(0).getQuantity1(),usersList.get(0).getQuantity1(),
				usersList.get(0).getQuantity1(),usersList.get(0).getQuantity1(),usersList.get(0).getQuantity1());
		WaitTool.hardWait();
		quickOrderPad.clickCheckoutButton();
		WaitTool.hardWait();
		Assert.assertTrue(quickOrderPad.shoppingCartPageDispalyed());

	}


}
