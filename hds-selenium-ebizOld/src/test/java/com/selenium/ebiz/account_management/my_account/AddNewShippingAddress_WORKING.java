package com.selenium.ebiz.account_management.my_account;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.AddNewShippingAddressPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MyAccountPage;
import com.selenium.ebiz.pageobject.MyAddressBookPage;

public class AddNewShippingAddress_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList,usersList1;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	AddNewShippingAddressPage addNewShippingAddressPage;
	MyAddressBookPage myAddressBookPage;
	HomePage homePage;

	@BeforeMethod
	public void driverSetup() throws Exception{
		usersList1 = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage= loginPage.loginToHdSupplySite(usersList1.get(0).getuserName(), usersList1.get(0).getpassword());

	}

	@Test
	public void validateAddNewShippingAddress() throws Exception{
		usersList = dbConnection.loadDataFromExcel("verifyMyAccountsPageLinks","MyAccount");
		myAccountPage = homePage.moveToMyAccountPage();
		myAccountPage.goToAddressBook();	
		myAccountPage.clickOnDeleteButtons();
		myAccountPage.addNewShippingAddressButton();
		myAccountPage.clearAllFieldsinAddressBook();
		myAccountPage.addAddress(usersList.get(0).getShippingAddressName(), usersList.get(0).getAddress(),usersList.get(0).getFloorOrSuite(), usersList.get(0).getCity(),
				usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName());
		String expectedAddressline1 = usersList.get(0).getShippingAddressName();
		String expectedAddressline2 = usersList.get(0).getAddress()+", null";
		String expectedAddressline3 = usersList.get(0).getCity();
		String expectedAddressline4 = usersList.get(0).getZipCode();
		expectedAddressline4 =expectedAddressline4.replaceAll("'", "");
		System.out.println("expectedAddressline1" + expectedAddressline1+ "	expectedAddressline2"+ expectedAddressline2+
				"	expectedAddressline3"+expectedAddressline3+"	expectedAddressline4"+expectedAddressline4);
		System.out.println("actualAddressline1"+myAccountPage.addressLine1()+"          actualAddressline2"+myAccountPage.addressLine2()+
				"          actualAddressline3"+myAccountPage.addressLine3()+"          actualAddressline4"+myAccountPage.addressLine4());
		Assert.assertEquals(myAccountPage.addressLine1(),expectedAddressline1);
		Assert.assertEquals(myAccountPage.addressLine2(),expectedAddressline2);
		Assert.assertEquals(myAccountPage.addressLine3(),expectedAddressline3);
		Assert.assertTrue(myAccountPage.addressLine4().contains(expectedAddressline4));

	}

}
