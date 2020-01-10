package com.selenium.ebiz.order_history;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.OrderHistoryAndStatusPage;
import com.selenium.ebiz.tools.WaitTool;

public class ViewOrderHistory_WORKING extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	OrderHistoryAndStatusPage orderHistoryAndStatusPage;

	DBCon dbConnection = new DBCon();;
	ArrayList<UsersListBean> usersList;

	@BeforeMethod	
	public void driverSetup() throws Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());	
	}

	/** US-244
	 *  To verify order again on homepage.
	 * @author lakshmi
	 **/	

	@Test
	public void verifyOrderHistory() throws Exception {
		WaitTool.hardWait();
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi "));
		Assert.assertTrue(homePage.isDisplayedHeaderOrderAgain());
		homePage.isDisplayedOrderAgainContentRecommandation();
		WaitTool.hardWait();
		orderHistoryAndStatusPage = homePage.clickOnViewOrderHistoryButton();
		Assert.assertTrue(orderHistoryAndStatusPage.getOrderspageHeadingText().equalsIgnoreCase("Orders"));
	}
}
