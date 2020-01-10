/*
 *  This Test Script Address in the 
 *  
 *  This Script is mapped to US-Acct-520

 */package com.selenium.ebiz.account_management.my_account;

 import java.util.ArrayList;

 import org.testng.Assert;
 import org.testng.annotations.BeforeMethod;
 import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MyAccountPage;

 public class ManageExistingShippingAddress_WORKING extends BaseClass{
	 HomePage homePage;
	 LoginPage loginPage;
	 MyAccountPage myAccountPage;
	 DBCon dbConnection = new DBCon();
	 ArrayList<UsersListBean> usersList;
	 public static String updatedHeading="MANAGE SHIPPING ADDRESS";

	 /*
	  *  Launching of the browser by entering Valid Credentials
	  */
	 @BeforeMethod	
	 public void driverSetup() throws Exception {
		 driver = initialize();
		 loginPage = new LoginPage(driver);
		 usersList = dbConnection.loadDataFromExcel("verifyLogin","LoginTestData");
		 loginPage.clickOnRegisterOrSignIn();
		 homePage= loginPage.signInToApplication(usersList.get(0).getuserName(),usersList.get(0).getpassword());
		 myAccountPage=homePage.moveToMyAccountPage();
	 }

	 /**
	  *@storyDescription :  To verify as As an authenticated user, I want to Edit and Update the Address
	  * @US :US-Acct-520
	  * @author Suresh
	  * */

	 @Test
	 public void verifyUpdateAddress() throws Exception {
		 myAccountPage.goToAddressBook();	
		 myAccountPage.clickOnDeleteButtons();
		 myAccountPage.addNewShippingAddressButton();
		 usersList = dbConnection.loadDataFromExcel("verifyMyAccountsPageLinks","MyAccount");
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

		 myAccountPage.clickOnEditButton();
		 usersList = dbConnection.loadDataFromExcel("editExistingShippingQAddress","MyAccount");
		 myAccountPage.clearAllFieldsinAddressBookBeforeEdit();
		 myAccountPage.updateAddress(usersList.get(0).getAddress(),usersList.get(0).getFloorOrSuite(), usersList.get(0).getCity(),
				 usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName());
		 //expectedAddressline1 = usersList.get(0).getShippingAddressName();
		 expectedAddressline2 = usersList.get(0).getAddress()+", null";
		 expectedAddressline3 = usersList.get(0).getCity();
		 expectedAddressline4 = usersList.get(0).getZipCode();
		 expectedAddressline4 =expectedAddressline4.replaceAll("'", "");
		 System.out.println("expectedAddressline1" + expectedAddressline1+ "	expectedAddressline2"+ expectedAddressline2+
				 "	expectedAddressline3"+expectedAddressline3+"	expectedAddressline4"+expectedAddressline4);
		 System.out.println("actualAddressline1"+myAccountPage.addressLine1()+"          actualAddressline2"+myAccountPage.addressLine2()+
				 "          actualAddressline3"+myAccountPage.addressLine3()+"          actualAddressline4"+myAccountPage.addressLine4());
		 //Assert.assertEquals(myAccountPage.addressLine1(),expectedAddressline1);
		 Assert.assertEquals(myAccountPage.addressLine2(),expectedAddressline2);
		 Assert.assertEquals(myAccountPage.addressLine3(),expectedAddressline3);
		 Assert.assertTrue(myAccountPage.addressLine4().contains(expectedAddressline4));
		 myAccountPage.clickOnDeleteButtons();

	 }
 }

