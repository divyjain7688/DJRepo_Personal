package com.selenium.ebiz.account_management.login;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.tools.WaitTool;

public class GenericSalesRepInfoLoggedInUser_NOTWORKING extends BaseClass{
	HomePage homePage;
	LoginPage loginPage;
	DBCon dbConnection;
	ArrayList<UsersListBean> usersList;	
	List<WebElement> accountLabelsList;

	@BeforeMethod	
	public void driverSetup() throws Exception {
		initialize();	
		loginPage = new LoginPage(driver);
		dbConnection = new DBCon();	
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
	}

	/**
	 * @Description To verify As an Authenticated User I want to see the Generic Sales Rep Image and Site Contact Info if I do not have a specific Sales Rep assigned 
	 * Userstory :US-Cat-237
	 * @author lakshmi
	 * */

	@Test
	public void verifyGenericSalesRepInformation() throws Exception {
		homePage.clickOnAccountUnderUser();
		Assert.assertTrue(homePage.isAccountUnderUserModalDisplayed());
		WaitTool.hardWait();
		homePage.clickOnAccount0012482411UnderUser();
		Assert.assertTrue(homePage.isSalesRepNameDisplayed());
		Assert.assertTrue(homePage.isSalesRepEmailDisplayed());
		Assert.assertTrue(homePage.isSalesRepNumberDisplayed());
		Assert.assertTrue(homePage.isSalesRepNameDisplayed());
		homePage.clickOnAccountUnderUser();
		Assert.assertTrue(homePage.isAccountUnderUserModalDisplayed());
		homePage.clickOnAccount0012482415UnderUser();
		Assert.assertTrue(homePage.salesRepInformationOnHeaderDisplayed());
		homePage.clickOnAccountUnderUser();
		homePage.clickOnAccount0012482411UnderUser();			
	}
}


