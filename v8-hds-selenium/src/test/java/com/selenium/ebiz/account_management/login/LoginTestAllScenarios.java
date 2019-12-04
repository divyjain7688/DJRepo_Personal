package com.selenium.ebiz.account_management.login;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class LoginTestAllScenarios extends BaseClassV8_ParallelGrid{
	// String expectedCopyrightMessageText = "� 2008 - 2018. HDS IP Holding, LLC.";
	int expectedPartNumbersInsideOrderOnceSection=8;
	int expectedImagesInsideOrderOnceSection = 8;
	int expectedProductDescriptionsInsideOrderOnceSection = 8;
	int expectedPricesInsideOrderOnceSection = 8;
	int expectedAddToCartButtonsInsideOrderOnceSection = 8;
	private ArrayList<UsersListBean> usersList;
	String expectedCopyrightMessageText ="trademarks of HDS IP Holding";

	/**
	 * @author smitha
	 * launch the application in chrome browser then login with valid credentials and 
	 * US-Acct-650 - Verify Logout - Click Sign out link on the account information flyout,then a popup should appear confirming that user wants to sign out,Popup should read "Are you Sure you want to Sign out?"
	 * with Ok and Cancel button, If user presses Cancel the popup should disppear and no action is taken, If user press OK button then user should be logged out and an unauthenticated version of site should be displayed
	 * 
	 * Modified: Bhavani
	 */	
	@Test(dataProvider = "browsers")
	public void login_loginWithValidCredentialAndLogoutTest(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());		
		pageManager.homePage().clickOnSignOutIconAndCancelPopup();
		pageManager.homePage().clickOnSignOutIconAndAcceptPopup();
		Assert.assertTrue(pageManager.loginPage().isDisplayedRegisterOrSignInLinkText());
		
		
	
	}

	/** dj073227
	 *  US-Cat-921 - This  method is used to verify that copyright message is displayed on login page
	 *   
	 * Modified: Bhavani:  : Modified code and added assertions.
	 */
	@Test(dataProvider = "browsers")
	public void login_verifyCopyrightMessageForLogInUser(String browser, String version, String os, Method method) throws  Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());		
		Boolean isDisplayedCopyrightMessage = pageManager.homePage().isDisplayedCopyrightMessage();
		String copyrightMessageText = pageManager.homePage().getTextCopyrightMessage();
		Assert.assertTrue(isDisplayedCopyrightMessage);
		Assert.assertTrue(copyrightMessageText.contains(expectedCopyrightMessageText));
	}

	/** dj073227
	 * US-Acct-560 - This method is used to verify the mandatory check on username and password on login page
	 * @throws Exception
	 */
	@Test(dataProvider = "browsers")
	public void login_verifyCredentialsWhileLogin(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().clickOnRegisterOrSignIn();
		Boolean IsDisplayedUserName = pageManager.loginPage().IsDisplayedUserName();
		Boolean IsDisplayedPassword = pageManager.loginPage().IsDisplayedPassword();
		pageManager.loginPage().clickOnRegisterLink();
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());		
		pageManager.homePage().clickOnSignOutIcon();
		Assert.assertTrue(IsDisplayedUserName);
		Assert.assertTrue(IsDisplayedPassword);
	}

	/**
	 * @author smitha
	 * launch the application in chrome browser and login with valid username and Incorrect password
	 * 
	 * Modified - Bhavani
	 */
	@Test(dataProvider = "browsers")
	public void login_loginWithIncorrectPasswordTest(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);	
		usersList=pageManager.dBCon().loadDataFromExcel("loginWithIncorrectPasswordTest","LoginTestData");
		pageManager.loginPage().loginToHdSupplySite(RandomAccountSelect.users.pop(), usersList.get(0).getpassword());	
		String errorMsg = "Either the logon ID or the password entered is incorrect. Enter the information again.";
		String invalidPwdMsgDisplayed = pageManager.loginPage().getInvalidUserNameOrPasswordMessageText();
		Assert.assertEquals(invalidPwdMsgDisplayed, errorMsg); 
	}
	
	/**
	 * @author smitha
	 * launch the application in chrome browser and login with Invalid username and valid password
	 * 
	 * Modified - Bhavani
	 */
	@Test(dataProvider = "browsers")
	public void login_loginWithInvalidUsernameTest(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());	
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);	
		usersList=pageManager.dBCon().loadDataFromExcel("loginWithInvalidUsernameTest","LoginTestData");
		pageManager.loginPage().loginToHdSupplySite(usersList.get(0).getuserName(),configread.getPassword());
		String errorMsg = "Either the logon ID or the password entered is incorrect. Enter the information again.";
		String invalidUserNameMsgDisplayed = pageManager.loginPage().getInvalidUserNameOrPasswordMessageText();
		Assert.assertEquals(invalidUserNameMsgDisplayed, errorMsg); 
	}

	/**
	 * @author smitha
	 * launch the application in chrome browser and login with valid username and empty password
	 * 
	 * Modified : Bhavani : 09/12/2019
	 */
	@Test(dataProvider = "browsers")
	public void login_loginWithEmptyPasswordTest(String browser, String version, String os, Method method) throws Exception {	
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList=pageManager.dBCon().loadDataFromExcel("loginWithEmptyPasswordTest","LoginTestData");
		pageManager.loginPage().loginToHdSupplySite(RandomAccountSelect.users.pop(), usersList.get(0).getpassword());
		Boolean isDisplayedpasswordErrorMessage = pageManager.loginPage().passwordErrorMessage.isDisplayed();
		Assert.assertTrue(isDisplayedpasswordErrorMessage);
	}

	/**
	 * @author smitha
	 * launch the application in chrome browser and login with Empty username and valid password
	 * 
	 * Modified : Bhavani : 09/12/2019 
	 */
	@Test(dataProvider = "browsers")
	public void login_loginWithEmptyUsernameTest(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);	
		usersList=pageManager.dBCon().loadDataFromExcel("loginWithEmptyUsernameTest","LoginTestData");
		pageManager.loginPage().loginToHdSupplySite(usersList.get(0).getuserName(),configread.getPassword());
		Boolean isDisplayedUserNameErrorMessage = pageManager.loginPage().userNameErrorMessage.isDisplayed();
		Assert.assertTrue(isDisplayedUserNameErrorMessage);
	}
	
	/**
	 * @author smitha
	 * launch the application in chrome browser and Verify Login for Suma user
	 * 
	 * Modified - Bhavani
	 */
	@Test(dataProvider = "browsers")
	public void login_loginWithValidSumaUserCredentialAndLogoutTest(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.sumausers.pop(), configread.getPassword());
        Boolean welcomeNoteDisplayed = pageManager.homePage().getWelcomeNote().contains("Hi");
		pageManager.loginPage().logoutOfApplication();
		Assert.assertTrue(welcomeNoteDisplayed);
		Assert.assertTrue(pageManager.loginPage().isDisplayedRegisterOrSignInLinkText());
	}

	/** dj073227
	 * US-Cat-910 - This method is used to verify that user,without logged in , can see footer links ie AboutUs,
	 * Returns,Terms and Conditions, Help are displayed on Home page
	 * @throws Exception 
	 * @throws  
	 */
	@Test(dataProvider = "browsers")
	public void login_verifyFooterLinksTest(String browser, String version, String os, Method method) throws  Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		Assert.assertTrue(pageManager.homePage().isAboutUsDisplayed());
		Assert.assertTrue(pageManager.homePage().isReturnsLinkDisplayed());
		Assert.assertTrue(pageManager.homePage().isTermsAndPoliciesLinkDisplayed());
		Assert.assertTrue(pageManager.homePage().isHelpLinkDisplayed());
	}

	/**
	 * To verify as unauthenticated User I want to view the User Content Recommendations which displays recommended product content to the user. 
	   US-Cat-1111
	 * @throws Exception 
	 * @throws MalformedURLException 
	 * 
	 * Modified: Bhavani
	 */
	@Test(dataProvider = "browsers")
	public void login_verifyContentRecommandationForUnauthenticatedUser(String browser, String version, String os, Method method) throws Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);	
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickOnSignOutIconAndAcceptPopup();
		pageManager.homePage().clickOnHDSupplyLogoInHeader();
		Assert.assertTrue(pageManager.homePage().isYourTopCategoriesCarouselSection());	
	}

	/**
	 * @story: US-Cat-900: Display Static Content Blocks for Unauthenticated User
	 * @storyDescription: Unauthenticated User wants to view articles, guides or 'how-to' tips on homepage
	 * 
	 * Modified:Bhavani- 9/12/2019 - Updated xpaths 156,160,164 and added methods to respective webelements in HomePage 
	 */
	@Test(dataProvider = "browsers",enabled=true)
	public void login_verifyLearnSomethingNewUnAuthenticatedUser(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		Assert.assertTrue(pageManager.homePage().isDisplayedlearnSomethingNew());
		Assert.assertTrue(pageManager.homePage().isDisplayedlearnSomethingNewRightBlock());
		Assert.assertTrue(pageManager.homePage().isDisplayedlearnSomethingNewLeftBlock());
	}
	
		 
	/**
	 * @author smitha
	 * launch the application in browser and Verify the homepage for Guest user
	 * This Test Script is mapped to user stories US-Cat-150 US-Cat-170 and US-Cat-190
	 *
	 * Modified : Bhavani : 09/12/2019
	 */
	@Test(dataProvider = "browsers")
	public void login_displayHomePageForUnAuthenticatedUserTest(String browser, String version, String os, Method method) throws Exception	{
	this.createDriver(browser, version, os, method.getName());
	WebDriver driver = this.getWebDriver();	
	PageManager pageManager = new PageManager(driver);
	Assert.assertTrue(pageManager.loginPage().isDisplayedRegisterOrSignInLinkText());
	Assert.assertTrue(pageManager.homePage().isDisplayedCategoryleftNavigation());
	}
	
	

	

}
