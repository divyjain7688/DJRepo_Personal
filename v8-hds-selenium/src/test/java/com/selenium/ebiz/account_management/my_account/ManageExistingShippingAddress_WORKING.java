/*
 *  This Test Script Address in the 
 *  
 *  This Script is mapped to US-Acct-520

 */package com.selenium.ebiz.account_management.my_account;

 import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
 import com.selenium.ebiz.beans.UsersListBean;
 import com.selenium.ebiz.tools.PageManager;
 import com.selenium.ebiz.tools.RandomAccountSelect;
 import org.openqa.selenium.WebDriver;
 import org.testng.Assert;
 import org.testng.annotations.Test;

 import java.lang.reflect.Method;
 import java.util.ArrayList;

 public class ManageExistingShippingAddress_WORKING extends BaseClassV8_ParallelGrid {

	 private ArrayList<UsersListBean> usersList;
	 /**
	  *@storyDescription :  To verify as As an authenticated user, I want to Edit and Update the Address
	  * @US :US-Acct-520
	  * @author Suresh
	  * @modified Iuliia 3/5/2019
	  *
	  * */

	 /*
    @designed by: Divy Jain
    mapped with: W80-7808,W80-8160
	  */

	 @Test(dataProvider = "browsers")
	 public void myAccount_EditNewShippingAddressAndCancel(String browser, String version, String os, Method method) throws Exception {
		 this.createDriver(browser, version, os, method.getName());
		 WebDriver driver = this.getWebDriver();
		 PageManager pageManager = new PageManager(driver);
		 pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		 pageManager.homePage().clickAccountLinkText();
		 pageManager.myAccountPage().goToAddressBook();
		 usersList = pageManager.dBCon().loadDataFromExcel("addNewShippingAddress", "ShippingAddress");
		 String nameFinal = pageManager.myAccountPage().fillOutNewShippingAddress(usersList.get(0).getShippingAddressName(),usersList.get(0).getCompanyOrPropertyName(),usersList.get(0).getAddress(),
				 usersList.get(0).getCity(),usersList.get(0).getState(),usersList.get(0).getZipCode(),usersList.get(0).getPhoneNumber());
		 pageManager.myAccountPage().clickOnEditButtonForAddedAddress(nameFinal);
		 pageManager.myAccountPage().clearAllFieldsinAddressBookBeforeEdit();
		 usersList=pageManager.dBCon().loadDataFromExcel("editExistingShippingQAddress","MyAccount");
		 pageManager.myAccountPage().updateAddressAndCancel(usersList.get(0).getAddress(),usersList.get(0).getFloorOrSuite(), usersList.get(0).getCity(),
				 usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName());
		 Assert.assertFalse(pageManager.myAccountPage().verifyAddress(nameFinal,usersList.get(0).getAddress(),usersList.get(0).getFloorOrSuite(), usersList.get(0).getCity(),
				 usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName()));	

	 }
	 
	 @Test(dataProvider = "browsers")
	 public void myAccount_EditNewShippingAddressAndConfirm(String browser, String version, String os, Method method) throws Exception {
		 this.createDriver(browser, version, os, method.getName());
		 WebDriver driver = this.getWebDriver();
		 PageManager pageManager = new PageManager(driver);
		 pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		 pageManager.homePage().clickAccountLinkText();
		 pageManager.myAccountPage().goToAddressBook();
		 usersList = pageManager.dBCon().loadDataFromExcel("addNewShippingAddress", "ShippingAddress");
		 String nameFinal = pageManager.myAccountPage().fillOutNewShippingAddress(usersList.get(0).getShippingAddressName(),usersList.get(0).getCompanyOrPropertyName(),usersList.get(0).getAddress(),
				 usersList.get(0).getCity(),usersList.get(0).getState(),usersList.get(0).getZipCode(),usersList.get(0).getPhoneNumber());
		 pageManager.myAccountPage().clickOnEditButtonForAddedAddress(nameFinal);
		 pageManager.myAccountPage().clearAllFieldsinAddressBookBeforeEdit();
		 usersList=pageManager.dBCon().loadDataFromExcel("editExistingShippingQAddress","MyAccount");
		 pageManager.myAccountPage().updateAddress(usersList.get(0).getAddress(),usersList.get(0).getFloorOrSuite(), usersList.get(0).getCity(),
				 usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName());
		 Assert.assertTrue(pageManager.myAccountPage().verifyAddress(nameFinal,usersList.get(0).getAddress(),usersList.get(0).getFloorOrSuite(), usersList.get(0).getCity(),
				 usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName()));
	 }
 }

