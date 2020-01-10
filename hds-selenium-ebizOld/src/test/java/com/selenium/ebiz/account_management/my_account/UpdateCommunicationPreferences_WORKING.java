/**
 * @author nm064123
 */

package com.selenium.ebiz.account_management.my_account;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.CommunicationsPreferencesPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MyAccountPage;
import com.selenium.ebiz.tools.WaitTool;

public class UpdateCommunicationPreferences_WORKING extends BaseClass{

	HomePage homePage;
	DBCon dbConnection;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	ArrayList<UsersListBean> usersList;
	CommunicationsPreferencesPage communicationsPreferencesPage;
	String communicationPreferenceReceiveOnlyMyOrder = "Receive only my web orders";
	String communicationPreferenceReceiveAllOrder = "Receive all order at my property";

	@BeforeMethod
	public void driverInitialize() throws Exception 
	{
		driver = initialize();		
		dbConnection = new DBCon();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
	}


	/**
	 * @author nm064123
	 * @throws Exception 
	 * @Story US-Acct-610: Update Communication Preferences for Authenticated User 
	 * 
	 */

	@Test
	public void updateCommunucationPreferences() throws Exception 
	{
		myAccountPage=homePage.moveToMyAccountPage();
		myAccountPage.changeCommunicationPrefenceToReceiveOnlyMyOrder();
		Assert.assertEquals(communicationPreferenceReceiveOnlyMyOrder,myAccountPage.changeCommunicationPrefenceToReceiveOnlyMyOrder());
		myAccountPage.changeCommunicationPrefenceToReceiveAllOrder();
		Assert.assertEquals(communicationPreferenceReceiveAllOrder,myAccountPage.changeCommunicationPrefenceToReceiveAllOrder());
	}
}
