
package com.selenium.ebiz.account_management.my_account;

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
import com.selenium.ebiz.tools.WaitTool;

/**
 * @author dj073227
 *
 */
public class ClickMyAccountLinkAuthenticatedUser_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	String exceptedMessageForSuccessfullyAddedToCartItem= "Successfully added to your shopping cart";
	String communicationPreferenceReceiveOnlyMyOrder = "Receive only my web orders";
	String communicationPreferenceReceiveAllOrder = "Receive all order at my property";
	String IncorrectPasswordErrorMsg = "Either the logon ID or the password entered is incorrect. Enter the information again.";
	String expectedNickNameError = "The Shipping Address Name cannot be empty.";
	String expectedAddressError = "Type an address in the Street address field.";
	String expectedCityError = "Type a city name in the City field.";
	String expectedStateError = "Type a state or province name in the State/province field.";
	String expectedZipCodeError = "Type a ZIP or postal code in the ZIP/postal code field.";


	/**
	 * This test is used to verify that when user logged in and click on my account link,
	 * user should able to navigate to My account page.
	 */
	@BeforeMethod
	public void driverSetup() throws Exception
	{
		driver = initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("verifyLogin","LoginTestData");
		System.out.println("asdasd");
		loginPage.clickOnRegisterOrSignIn();
		homePage= loginPage.signInToApplication(usersList.get(0).getuserName(),usersList.get(0).getpassword());
		myAccountPage=homePage.moveToMyAccountPage();
	}

	/*RecurringOrdersLink is not displayed in Qa*/
	/** dj073227
	 * US-Acct-460 -This method is used to verify that all links are displaying correct 
	 * text on it and navigating to expected page from my account page.
	 * @throws Exception 
	 */
	@Test(priority=1)
	public void verifyMyAccountsPageAndItsLinks() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("verifyMyAccountsPageLinks","MyAccount");
		System.out.println("getUpdateEmailAddress"+usersList.get(0).getUpdateEmailAddress());
		System.out.println("getOldPassword"+usersList.get(0).getOldPassword());
		System.out.println("getNewPassword"+usersList.get(0).getNewPassword());
		System.out.println("getUsername"+usersList.get(0).getUsername());
		Assert.assertTrue(myAccountPage.isOrdersLinkDisplayed());
		Assert.assertTrue(myAccountPage.isListsLinkDisplayed());
		Assert.assertTrue(myAccountPage.isQuotesLinkDisplayed());
		Assert.assertTrue(myAccountPage.isFrequentlyPurchasedLinkDisplayed());
		//	Assert.assertTrue(myAccountPage.isRecurringOrdersLinkDisplayed());
		Assert.assertTrue(myAccountPage.isElectronicInvoicingLinkDisplayed());
		//Assert.assertTrue(myAccountPage.isApproveOrdersLinkDisplayed());                   -----> approve order is removed from my account section
		Assert.assertTrue(myAccountPage.isAboutYouBlockUnderManageAccountSectionDisplayed());
		Assert.assertTrue(myAccountPage.isBillingInformationBlockUnderManageAccountSectionDisplayed());
		Assert.assertTrue(myAccountPage.isShippingInformationBlockUnderManageAccountSectionDisplayed());
		Assert.assertTrue(myAccountPage.isEmailConfirmationsBlockUnderManageAccountSectionDisplayed());
		Assert.assertTrue(myAccountPage.isChangeEmailAddressLinkInsideAboutYouBlockDisplayed());
		Assert.assertTrue(myAccountPage.isChangePasswordLinkInsideAboutYouBlockDisplayed());
		Assert.assertTrue(myAccountPage.isDefaultBillingAddressInsideBillingInformationBlockDisplayed());
		Assert.assertTrue(myAccountPage.isManageShippingAddressLinkInsideShippingInformationBlockDisplayed());
		Assert.assertTrue(myAccountPage.isAddShippingAddressLinkInsideShippingInformationBlockDisplayed());
		Assert.assertTrue(myAccountPage.isCommunicationPreferencesInsideEmailConfirmationsBlockDisplayed());
		Assert.assertTrue(myAccountPage.isProductFromOrderOnceSectionAddedToCart());     
		//myAccountPage.disaplyedOldEmailAddressValue();
		String  disaplyedOldEmailAddressValue= myAccountPage.disaplyedOldEmailAddressValue();
		myAccountPage.changeEmailAddress(usersList.get(0).getUpdateEmailAddress());
		Assert.assertEquals(myAccountPage.dispalyedUpdatedEmailAddress(),usersList.get(0).getUpdateEmailAddress());
		myAccountPage.revertEmailAddress(disaplyedOldEmailAddressValue);
		myAccountPage.changeCommunicationPrefenceToReceiveOnlyMyOrder();
		Assert.assertEquals(communicationPreferenceReceiveOnlyMyOrder,myAccountPage.changeCommunicationPrefenceToReceiveOnlyMyOrder());
		myAccountPage.changeCommunicationPrefenceToReceiveAllOrder();
		Assert.assertEquals(communicationPreferenceReceiveAllOrder,myAccountPage.changeCommunicationPrefenceToReceiveAllOrder());
		myAccountPage.goToAddressBook();	
		myAccountPage.clickOnDeleteButtons();
		myAccountPage.addNewShippingAddressButton();

		Assert.assertTrue(myAccountPage.shippingAddressNameError( usersList.get(0).getAddress(), usersList.get(0).getCity(),
				usersList.get(0).getState(),usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(), usersList.get(0).getCompanyOrPropertyName()));
		myAccountPage.clearAllFieldsinAddressBook();

		Assert.assertTrue(myAccountPage.addressError(usersList.get(0).getShippingAddressName(),usersList.get(0).getCity(),
				usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName()));
		myAccountPage.clearAllFieldsinAddressBook();

		Assert.assertTrue(myAccountPage.cityError(usersList.get(0).getShippingAddressName(),usersList.get(0).getAddress(),usersList.get(0).getState(), 
				usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName()));
		myAccountPage.clearAllFieldsinAddressBook();

		Assert.assertTrue(myAccountPage.stateError(usersList.get(0).getShippingAddressName(),usersList.get(0).getAddress(),
				usersList.get(0).getCity(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName()));
		myAccountPage.clearAllFieldsinAddressBook();

		Assert.assertTrue(myAccountPage.zipcodeError(usersList.get(0).getShippingAddressName(),usersList.get(0).getAddress(),
				usersList.get(0).getCity(), usersList.get(0).getState(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName()));
		myAccountPage.clearAllFieldsinAddressBook();

		Assert.assertTrue(myAccountPage.companyPropertyError(usersList.get(0).getShippingAddressName(),usersList.get(0).getAddress(),
				usersList.get(0).getCity(), usersList.get(0).getState(), usersList.get(0).getPhoneNumber(),usersList.get(0).getZipCode()));
		myAccountPage.clearAllFieldsinAddressBook();


		Assert.assertTrue(myAccountPage.phoneNumberError(usersList.get(0).getShippingAddressName(),usersList.get(0).getAddress(),
				usersList.get(0).getCity(), usersList.get(0).getState(), usersList.get(0).getCompanyOrPropertyName(),usersList.get(0).getZipCode()));
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
System.out.println("validated addresssssssssss");
		myAccountPage.goToMyAccountsFrommBreadCrum();
		myAccountPage.changePassword(usersList.get(0).getOldPassword(),usersList.get(0).getNewPassword());
		loginPage=myAccountPage.logoutFromMyAccount();
		loginPage.clickOnRegisterOrSignIn();
		loginPage.signInToApplicationWithIncorrectPassword(usersList.get(0).getUsername(),usersList.get(0).getOldPassword());
		Assert.assertEquals(IncorrectPasswordErrorMsg,loginPage.invalidUserNameOrPasswordMessageText());
		homePage=loginPage.signInToApplication(usersList.get(0).getUsername(),usersList.get(0).getNewPassword());
		myAccountPage=homePage.moveToMyAccountPage();
		myAccountPage.changePassword(usersList.get(0).getNewPassword(),usersList.get(0).getOldPassword());
		loginPage=myAccountPage.logoutFromMyAccount();
		loginPage.clickOnRegisterOrSignIn();
		homePage=loginPage.signInToApplication(usersList.get(0).getUsername(),usersList.get(0).getOldPassword());

	}

	/**	dj073227
	 * 	97916 - Verify that user cannot delete or edit default address
	 */
	@Test(priority=2)
	public void deleteEditDefaultAddress()
	{
		myAccountPage.goToAddressBook();	
		myAccountPage.clickOnDeleteButtons();
		myAccountPage.isDeleteButtonNotdisplayed();
		myAccountPage.isEditButtonNotdisplayed();
		myAccountPage.isDefaultShippingAddressText();

	}


	/**	dj073227
	 * 	97915 - Verify ability to edit existing shipping address
	 * 
	 */
	@Test(priority=3)
	public void editExistingShippingQAddress() throws Exception
	{
		myAccountPage.goToAddressBook();	
		myAccountPage.clickOnDeleteButtons();
		myAccountPage.addNewShippingAddressButton();
		usersList = dbConnection.loadDataFromExcel("verifyMyAccountsPageLinks","MyAccount");
		myAccountPage.clearAllFieldsinAddressBook();
		/*	myAccountPage.addAddress(usersList.get(0).getShippingAddressName(), usersList.get(0).getAddress(),usersList.get(0).getFloorOrSuite(), usersList.get(0).getCity(),
				usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(),usersList.get(0).getCompanyOrPropertyName());
		String expectedAddressline1 = usersList.get(0).getFloorOrSuite()+", "+usersList.get(0).getAddress()+",";
		String expectedAddressline2 = usersList.get(0).getCity();
		String expectedAddressline3 = usersList.get(0).getZipCode();
		System.out.println("expectedAddressline1" + expectedAddressline1+ "expectedAddressline2"+ expectedAddressline2+"expectedAddressline3"+expectedAddressline3);
		Assert.assertEquals(myAccountPage.addrressLine1(),expectedAddressline1);
		Assert.assertEquals(myAccountPage.addrressLine2(),expectedAddressline2);
		Assert.assertEquals(myAccountPage.addrressLine3(),expectedAddressline3);*/

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



	/**	dj073227
	 * 	79946 - Verify error message is displayed when invalid or blank Passwords are entered
	 * 
	 */
	@Test(priority=3)
	public void verifyInvalidBlankPassword() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("verifyInvalidBlankPassword","MyAccount");
		Assert.assertTrue(myAccountPage.isOldPasswordErrorDisplayed(usersList.get(0).getOldPassword(),usersList.get(0).getNewPassword()));
		Assert.assertTrue(myAccountPage.isNewPasswordLengthErrorDisplayed(usersList.get(0).getOldPassword(),usersList.get(0).getNewPassword()));
		Assert.assertTrue(myAccountPage.isNewPasswordBlankErrorDisplayed(usersList.get(0).getOldPassword()));
	}

	/**	dj073227
	 * 	79944 - Verify error message when New Email and Confirm New Email do not match
	 * 
	 */
	@Test(priority=4)
	public void verifyEmailUpdateError() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("verifyEmailUpdateError","MyAccount");
	//	myAccountPage.disaplyedOldEmailAddressValue();
		String disaplyedOldEmailAddressValue =myAccountPage.disaplyedOldEmailAddressValue();
		Assert.assertTrue(myAccountPage.changeEmailAddressError(disaplyedOldEmailAddressValue,usersList.get(0).getUpdateEmailAddress()));
	}

	/**	dj073227
	 * 	79943 - Verify error messages when updating Email Addresses with empty or invalid address
	 * 
	 */
	@Test(priority=5)
	public void verifyInvalidBlankEmail() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("verifyInvalidBlankEmail","MyAccount");
		myAccountPage.changeEmailAddress(usersList.get(0).getUpdateEmailAddress());
		Assert.assertTrue(myAccountPage.isEmailAddressErrorDisplayed());
		myAccountPage.goToMyAccountsFrommBreadCrum();
		myAccountPage.changeEmailAddress();
		Assert.assertTrue(myAccountPage.isEmailAddressErrorDisplayed());
	}

	/**	dj073227
	 * 	110711 - Verify back button on adress book-View all shipping addresses
	 * 
	 */
	@Test(priority=6)
	public void verifyBackButtonOnAddressBook() throws Exception
	{

		myAccountPage.goToAddressBook();	
		myAccountPage.addNewShippingAddressButton();
		//WaitTool.hardWait();
		myAccountPage=myAccountPage.navigateBackToAddressBookFromNewShipingAddress();

	}

	/**	dj073227
	 * 	97914 - Verify ability to delete existing shipping address

	 * 
	 */
	@Test(priority=7)
	public void verifyDeleteAddressFromAddressBook() throws Exception
	{

		myAccountPage.goToAddressBook();	
		myAccountPage.clickOnDeleteButtons();
		myAccountPage.isDeleteButtonNotdisplayed();
		myAccountPage.isDefaultShippingAddressText();
	}

}
