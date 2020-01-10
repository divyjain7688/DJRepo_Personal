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
import com.selenium.ebiz.pageobject.QuickOrderPage;
import com.selenium.ebiz.pageobject.SignInOrRegisterPage;

public class QuickOrderMiniFormHeaderGuestUser extends BaseClass{

	ArrayList<UsersListBean> usersList,usersList1;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	QuickOrderPad quickOrderPad;
	QuickOrderPage quickOrderPage;
	SignInOrRegisterPage signInOrRegisterPage;

	@BeforeMethod
	public void driverSetup() throws Exception
	{
		driver=initialize();
		loginPage = new LoginPage(driver);	
	}

	/** @author Smitha
	 *US-Ord-160 - This method is used to verify Quick order Miniform On Header for guest user
	 */

	@Test
	public void verifyQuickOrderMiniFormHeaderGuestUser() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("addProductsUsingQuickOrder","QuickOrder");
		quickOrderPad=loginPage.clickOnQuickOrderLink();
		Assert.assertTrue(quickOrderPad.isDisplayedDefaultSixRowsInQuickOrderPad());
		quickOrderPad.clickAddMoreRowsFirstTime();
		Assert.assertTrue(quickOrderPad.isDisplayedTwelveRowsInQuickOrderPad());
		quickOrderPad.fillFirstSixPartNumberTextBox(usersList.get(0).getPartNumber1(),usersList.get(0).getPartNumber2(),usersList.get(0).getPartNumber3(),
				usersList.get(0).getPartNumber4(),usersList.get(0).getPartNumber5(),usersList.get(0).getPartNumber6());
		quickOrderPad.fillFirstSixQuantityTextBox(usersList.get(0).getQuantity1(),usersList.get(0).getQuantity2(),usersList.get(0).getQuantity3(),
				usersList.get(0).getQuantity4(),usersList.get(0).getQuantity5(),usersList.get(0).getQuantity6());
		quickOrderPad.clickAddMoreRowsFirstTime();

		usersList1 = dbConnection.loadDataFromExcel("verifyLogin","LoginTestData");
		signInOrRegisterPage = new SignInOrRegisterPage(driver);
		signInOrRegisterPage.loginToFromBrowsePage(usersList1.get(0).getuserName(), usersList1.get(0).getpassword());

		quickOrderPage = new QuickOrderPage(driver);
		//Validate user is navigated to quick order detail page by clicking add more rows 3rd time
		Assert.assertTrue(quickOrderPage.isDisplayedQuickOrderPageHeadingText());

	}
}
