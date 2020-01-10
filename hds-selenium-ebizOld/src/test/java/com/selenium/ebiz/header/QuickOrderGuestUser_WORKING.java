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
import com.selenium.ebiz.pageobject.SignInOrRegisterPage;
import com.selenium.ebiz.tools.WaitTool;

/**
 * @author dj073227
 *
 */
public class QuickOrderGuestUser_WORKING extends BaseClass
{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	SignInOrRegisterPage signInOrRegisterPage;
	QuickOrderPad quickOrderPad;


	/**
	 * This method is used to load the property file, launch the browser, 
	 * navigate to the URL(provided in property file) and go to home page
	 */
	@BeforeMethod
	public void driverSetup() throws Exception
	{
		driver=initialize();
		loginPage = new LoginPage(driver);
	}

	/*Scripting is done till step 4. Fucntionality is not available from step 5 in google doc*/
	/** dj073227
	 *US-Ord-180 - This method is used to verify that guest user can click on quick order link and add product.User can navigate 
	 *to quick order page and able to verify all buttons, labels on Quick order page.
	 */
	@Test(priority=0)
	public void addProductsUsingQuickOrder() throws Exception
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
		WaitTool.hardWait();

		/*
		 * Added By Bhavani Manthri


		SignInOrRegisterPage signInOrRegisterPage = quickOrderPad.clickAddToCartButton();
		usersList = dbConnection.loadDataFromExcel("commonUserNameAndPassword", "LoginTestData");
		QuickOrderPage quickOrderPage = signInOrRegisterPage.loginToFromQO(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		Assert.assertTrue(quickOrderPage.isDisplayedErrorMsg(), "passed");
		 */
	}

}
