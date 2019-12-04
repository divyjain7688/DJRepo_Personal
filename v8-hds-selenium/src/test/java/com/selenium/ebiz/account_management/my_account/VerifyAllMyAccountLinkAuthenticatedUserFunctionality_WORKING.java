
package com.selenium.ebiz.account_management.my_account;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author dj073227
 * @modified: Iuliia
 *
 */
public class VerifyAllMyAccountLinkAuthenticatedUserFunctionality_WORKING extends BaseClassV8_ParallelGrid {

	private ArrayList<UsersListBean> usersList;


	/**
	 * This test is used to verify that when user logged in and click on my account link,
	 * user should able to navigate to My account page.
	 */

	/*RecurringOrdersLink is not displayed in Qa*/
	/** dj073227
	 * US-Acct-460 -This method is used to verify that all links are displaying correct 
	 * text on it and navigating to expected page from my account page.
	 * @throws Exception 
	 */

	@Test(dataProvider = "browsers")
	public void myAccount_verifyLinksDisplayedInAccountPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();

		//usersList = pageManager.dBCon().loadDataFromExcel("verifyMyAccountsPageLinks", "MyAccount");
		//Log.info("getUpdateEmailAddress" + usersList.get(0).getUpdateEmailAddress());
		//Log.info("getOldPassword" + usersList.get(0).getOldPassword());
		//Log.info("getNewPassword" + usersList.get(0).getNewPassword());
		//Log.info("getUsername" + usersList.get(0).getUsername());
		Assert.assertTrue(pageManager.myAccountPage().isOrdersLinkDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isListsLinkDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isQuotesLinkDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isFrequentlyPurchasedLinkDisplayed());
		//	Assert.assertTrue(myAccountPage.isRecurringOrdersLinkDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isElectronicInvoicingLinkDisplayed());
		//Assert.assertTrue(myAccountPage.isApproveOrdersLinkDisplayed());                   -----> approve order is removed from my account section
		Assert.assertTrue(pageManager.myAccountPage().isAboutYouBlockUnderManageAccountSectionDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isBillingInformationBlockUnderManageAccountSectionDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isShippingInformationBlockUnderManageAccountSectionDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isEmailConfirmationsBlockUnderManageAccountSectionDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isChangeEmailAddressLinkInsideAboutYouBlockDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isChangePasswordLinkInsideAboutYouBlockDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isDefaultBillingAddressInsideBillingInformationBlockDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isManageShippingAddressLinkInsideShippingInformationBlockDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isAddShippingAddressLinkInsideShippingInformationBlockDisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isCommunicationPreferencesInsideEmailConfirmationsBlockDisplayed());
		//Assert.assertTrue(pageManager.myAccountPage().isProductFromOrderOnceSectionAddedToCart());
		//myAccountPage.disaplyedOldEmailAddressValue();

	}

	/*
	 * Updated assertions
	actualAddressLine4 value on UI was displayed  in seperate line earlier as per old code.But now its not there.
	Divy Jain - 23-08-2019
	 */
	@Test(dataProvider = "browsers")
	public void myAccount_verifyShippingAddressErrorWithWrongInputs(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();

		pageManager.myAccountPage().goToAddressBook();
		pageManager.myAccountPage().clickOnDeleteButtons();
		pageManager.myAccountPage().addNewShippingAddressButton();
		usersList = pageManager.dBCon().loadDataFromExcel("verifyMyAccountsPageLinks", "MyAccount");

		Assert.assertTrue(pageManager.myAccountPage().shippingAddressNameError(usersList.get(0).getAddress(), usersList.get(0).getCity(),
				usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(), usersList.get(0).getCompanyOrPropertyName()));
		pageManager.myAccountPage().clearAllFieldsinAddressBook();

		Assert.assertTrue(pageManager.myAccountPage().addressError(usersList.get(0).getShippingAddressName(), usersList.get(0).getCity(),
				usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(), usersList.get(0).getCompanyOrPropertyName()));
		pageManager.myAccountPage().clearAllFieldsinAddressBook();

		Assert.assertTrue(pageManager.myAccountPage().cityError(usersList.get(0).getShippingAddressName(), usersList.get(0).getAddress(), usersList.get(0).getState(),
				usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(), usersList.get(0).getCompanyOrPropertyName()));
		pageManager.myAccountPage().clearAllFieldsinAddressBook();

		Assert.assertTrue(pageManager.myAccountPage().stateError(usersList.get(0).getShippingAddressName(), usersList.get(0).getAddress(),
				usersList.get(0).getCity(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(), usersList.get(0).getCompanyOrPropertyName()));
		pageManager.myAccountPage().clearAllFieldsinAddressBook();

		Assert.assertTrue(pageManager.myAccountPage().zipcodeError(usersList.get(0).getShippingAddressName(), usersList.get(0).getAddress(),
				usersList.get(0).getCity(), usersList.get(0).getState(), usersList.get(0).getPhoneNumber(), usersList.get(0).getCompanyOrPropertyName()));
		pageManager.myAccountPage().clearAllFieldsinAddressBook();

		Assert.assertTrue(pageManager.myAccountPage().companyPropertyError(usersList.get(0).getShippingAddressName(), usersList.get(0).getAddress(),
				usersList.get(0).getCity(), usersList.get(0).getState(), usersList.get(0).getPhoneNumber(), usersList.get(0).getZipCode()));
		pageManager.myAccountPage().clearAllFieldsinAddressBook();


		Assert.assertTrue(pageManager.myAccountPage().phoneNumberError(usersList.get(0).getShippingAddressName(), usersList.get(0).getAddress(),
				usersList.get(0).getCity(), usersList.get(0).getState(), usersList.get(0).getCompanyOrPropertyName(), usersList.get(0).getZipCode()));
		pageManager.myAccountPage().clearAllFieldsinAddressBook();

		pageManager.myAccountPage().addAddress(usersList.get(0).getShippingAddressName(), usersList.get(0).getAddress(), usersList.get(0).getFloorOrSuite(), usersList.get(0).getCity(),
				usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber(), usersList.get(0).getCompanyOrPropertyName());
		String expectedAddressline1 = usersList.get(0).getShippingAddressName();
		String expectedAddressline2 = usersList.get(0).getAddress() + ", null";
		String expectedAddressline3 = usersList.get(0).getCity();
		String expectedAddressline4 = usersList.get(0).getZipCode();
		expectedAddressline4 = expectedAddressline4.replaceAll("'", "");
		Log.info("expectedAddressline1 is " + expectedAddressline1+ "	expectedAddressline2 is "+ expectedAddressline2+
				"	expectedAddressline3 is "+expectedAddressline3+"	expectedAddressline4 is "+expectedAddressline4);
		Log.info("actualAddressline1 is "+pageManager.myAccountPage().addressLine1()+"          actualAddressline2 is "+pageManager.myAccountPage().addressLine2()+
				"          actualAddressline3 is "+pageManager.myAccountPage().addressLine3(1));
		Assert.assertEquals(pageManager.myAccountPage().addressLine1(),expectedAddressline1);
		Assert.assertEquals(pageManager.myAccountPage().addressLine2(),expectedAddressline2);
		Assert.assertTrue(pageManager.myAccountPage().addressLine3(1).contains(expectedAddressline3));
		Assert.assertTrue(pageManager.myAccountPage().addressLine3(1).contains(expectedAddressline4));

	}

	/**	dj073227
	 * 	97916 - Verify that user cannot delete or edit default address
     * 	modified: Iuliia
	 */
	@Test(dataProvider = "browsers", description="Delete Edit Default Address")
	public void myAccount_deleteEditDefaultAddress(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		pageManager.homePage().clickAccountLinkText();

		pageManager.myAccountPage().goToAddressBook();	
		pageManager.myAccountPage().clickOnDeleteButtons();
		pageManager.myAccountPage().isDefaultShippingAddressText();
		Assert.assertTrue(pageManager.myAccountPage().isDeleteButtonNotdisplayed());
		Assert.assertTrue(pageManager.myAccountPage().isEditButtonNotdisplayed());

	}



	/**	dj073227
	 * 	79946 - Verify error message is displayed when invalid or blank Passwords are entered
	 * 
	 */
	@Test(dataProvider = "browsers", description="Verify Invalid BlankPassword")
	public void myAccount_verifyInvalidBlankPassword(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();

		usersList=pageManager.dBCon().loadDataFromExcel("verifyInvalidBlankPassword","MyAccount");
		Assert.assertTrue(pageManager.myAccountPage().isOldPasswordErrorDisplayed(usersList.get(0).getOldPassword(),usersList.get(0).getNewPassword()));
		Assert.assertTrue(pageManager.myAccountPage().isNewPasswordLengthErrorDisplayed(usersList.get(0).getOldPassword(),usersList.get(0).getNewPassword()));
		Assert.assertTrue(pageManager.myAccountPage().isNewPasswordBlankErrorDisplayed(usersList.get(0).getOldPassword()));
	}

	/**	dj073227
	 * 	79944 - Verify error message when New Email and Confirm New Email do not match
	 * 
	 */
	@Test(dataProvider = "browsers", description="Verify Email Update Error", enabled = false)
	public void myAccount_verifyEmailUpdateError(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();

		usersList=pageManager.dBCon().loadDataFromExcel("verifyEmailUpdateError","MyAccount");
		//	myAccountPage.disaplyedOldEmailAddressValue();
		String disaplyedOldEmailAddressValue = pageManager.myAccountPage().disaplyedOldEmailAddressValue();
		Assert.assertTrue(pageManager.myAccountPage().changeEmailAddressError(disaplyedOldEmailAddressValue,usersList.get(0).getUpdateEmailAddress()));
	}

	/**	dj073227
	 * 	79943 - Verify error messages when updating Email Addresses with empty or invalid address
	 * 
	 */
	@Test(dataProvider = "browsers", description="Verify Invalid Blank Email")
	public void myAccount_verifyInvalidBlankEmail(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();

		usersList=pageManager.dBCon().loadDataFromExcel("verifyInvalidBlankEmail","MyAccount");
		pageManager.myAccountPage().changeEmailAddress(usersList.get(0).getUpdateEmailAddress());
		Assert.assertTrue(pageManager.myAccountPage().isEmailAddressErrorDisplayed());
		pageManager.myAccountPage().goToMyAccountsFrommBreadCrum();
		pageManager.myAccountPage().changeEmailAddress();
		Assert.assertTrue(pageManager.myAccountPage().isEmailAddressErrorDisplayed());
	}

	/**	dj073227
	 * 	110711 - Verify back button on adress book-View all shipping addresses
	 * 
	 */
	@Test(dataProvider = "browsers", description="Verify BackButton On AddressBook")
	public void myAccount_verifyBackButtonOnAddressBook(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();

		pageManager.myAccountPage().goToAddressBook();	
		pageManager.myAccountPage().addNewShippingAddressButton();
		pageManager.myAccountPage().navigateBackToAddressBookFromNewShipingAddress();

	}

	/**	dj073227
	 * 	97914 - Verify ability to delete existing shipping address

	 * 
	 */
	@Test(dataProvider = "browsers", description="Verify Delete Address From AddressBook")
	public void myAccount_verifyDeleteAddressFromAddressBook(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();

		pageManager.myAccountPage().goToAddressBook();	
		pageManager.myAccountPage().clickOnDeleteButtons();
		pageManager.myAccountPage().isDeleteButtonNotdisplayed();
		pageManager.myAccountPage().isDefaultShippingAddressText();
	}

}
