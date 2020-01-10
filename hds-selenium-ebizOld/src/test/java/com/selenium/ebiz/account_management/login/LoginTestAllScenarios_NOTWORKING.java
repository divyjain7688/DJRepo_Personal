package com.selenium.ebiz.account_management.login;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.SignInOrRegisterPage;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class LoginTestAllScenarios_NOTWORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	SignInOrRegisterPage signInOrRegisterPage;
	// String expectedCopyrightMessageText = "� 2008 - 2018. HDS IP Holding, LLC.";
	int expectedPartNumbersInsideOrderOnceSection=8;
	int expectedImagesInsideOrderOnceSection = 8;
	int expectedProductDescriptionsInsideOrderOnceSection = 8;
	int expectedPricesInsideOrderOnceSection = 8;
	int expectedAddToCartButtonsInsideOrderOnceSection = 8;

	@BeforeMethod
	public void driverSetup() throws MalformedURLException {
		driver = initialize();
		loginPage = new LoginPage(driver);
	}

	/**
	 * 
	 * @author smitha
	 * launch the application in chrome browser then login with valid credentials and 
	 * US-Acct-650 - Verify Logout - Click Sign out link on the account information flyout,then a popup should appear confirming that user wants to sign out,Popup should read "Are you Sure you want to Sign out?"
	 * with Ok and Cancel button, If user presses Cancel the popup should disppear and no action is taken, If user press OK button then user should be logged out and an unauthenticated version of site should be displayed
	 * 
	 */	
	@Test(priority=0)
	public void loginWithValidCredentialAndLogoutTest() throws Exception {
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		WaitTool.hardWait();
		//Validating the HomePage displayed or not by checking Hi text.
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); // Validating the HomePage displayed or not by checking Hello text.
		loginPage.clickLogoutLinkText();
		Assert.assertTrue(CommonFunctions.getPopupMessage(driver).contains("Are you sure you want to Sign Out?"));
		//cancel the popup
		CommonFunctions.cancelPopupMessageBox(driver);
		//Validating the HomePage displayed or not by checking Hi text.
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); // Validating the HomePage displayed or not by checking Hello text.
		loginPage.clickAccountIcon();
		//logout by clicking ok button on popup
		loginPage.logoutOfApplication();
		// Validating user is successfully logged out
		Assert.assertTrue(loginPage.isDisplayedRegisterOrSignInLinkText());			
	}

	/** dj073227
	 * 
	 * US-Cat-921 - This  method is used to verify that copyright message is displayed on login page
	 * 
	 */
	@Test(priority=1)
	public void verifyCopyrightMessage() 
	{
		loginPage = new LoginPage(driver);
		String copyrightMessageText = loginPage.isCopyrightMessageDisplayed();
		// Assert.assertTrue(copyrightMessageText.contains(expectedCopyrightMessageText));
	}

	/** dj073227
	 * US-Acct-560 - This method is used to verify the mandatory check on username and password on login page
	 * @throws Exception
	 */
	@Test(priority=2)
	public void verifyCredentialsWhileLogin() throws Exception {
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("verifyLogin", "LoginTestData");
		Boolean isPasswordErrorMessageDisplayed=loginPage.signInToApplicationwithoutPassword(usersList.get(0).getuserName());
		Assert.assertTrue(isPasswordErrorMessageDisplayed);
		Boolean isUsernameErrorMessageDisplayed=loginPage.signInToApplicationwithoutUsername(usersList.get(0).getpassword());
		Assert.assertTrue(isUsernameErrorMessageDisplayed);
		homePage=loginPage.signInToApplication(usersList.get(0).getuserName(), usersList.get(0).getpassword());
	}

	/**
	 * 
	 * @author smitha
	 * launch the application in chrome browser and login with valid username and Incorrect password
	 * 
	 */
	@Test(priority = 3)
	public void loginWithIncorrectPasswordTest() throws Exception {

		usersList = dbConnection.loadDataFromExcel("loginWithIncorrectPasswordTest", "LoginTestData");

		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		// Validating the HomePage displayed or not by checking Hi text.
		System.out.println( homePage.returnWelcomeNote());	
		Assert.assertFalse(homePage.getWelcomeNote().contains("Hi")); 
	}

	/**
	 * 
	 * @author smitha
	 * launch the application in chrome browser and login with Invalid username and valid password
	 * 
	 */
	@Test(priority = 4)
	public void loginWithInvalidUsernameTest() throws Exception {

		usersList = dbConnection.loadDataFromExcel("loginWithInvalidUsernameTest", "LoginTestData");

		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		// Validating the HomePage displayed or not by checking Hi text.
		System.out.println( homePage.returnWelcomeNote());	
		Assert.assertFalse(homePage.getWelcomeNote().contains("Hi"));

	}

	/**
	 * 
	 * @author smitha
	 * launch the application in chrome browser and login with valid username and empty password
	 * 
	 */

	@Test(priority = 5)
	public void loginWithEmptyPasswordTest() throws Exception {	
		usersList = dbConnection.loadDataFromExcel("loginWithEmptyPasswordTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		// Validating the HomePage displayed or not by checking Hi text.
		System.out.println( homePage.returnWelcomeNote());	
		Assert.assertFalse(homePage.getWelcomeNote().contains("Hi")); 

	}

	/**
	 * 
	 * @author smitha
	 * launch the application in chrome browser and login with Empty username and valid password
	 * 
	 */
	@Test(priority = 6)
	public void loginWithEmptyUsernameTest() throws Exception {

		usersList = dbConnection.loadDataFromExcel("loginWithEmptyUsernameTest", "LoginTestData");

		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		// Validating the HomePage displayed or not by checking Hi text.
		System.out.println( homePage.returnWelcomeNote());	
		Assert.assertFalse(homePage.getWelcomeNote().contains("Hi")); 

	}

	/**
	 * 
	 * @author smitha
	 * launch the application in chrome browser and Verify Login for Suma user
	 * 
	 */

	//@Test(priority = 7)
	public void loginWithValidSumaUserCredentialAndLogoutTest() throws Exception {

		usersList = dbConnection.loadDataFromExcel("verifyLoginForSumaUser", "LoginTestData");

		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		Thread.sleep(10000);
		// Validating the HomePage displayed or not by checking Hi text.
		System.out.println("homePage.returnWelcomeNote():"+ homePage.returnWelcomeNote());	

		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); // Validating the HomePage displayed or not by checking Hello text.
		Thread.sleep(15000);
		loginPage.logoutOfApplication();

		// Validating user is successfully logged out
		Assert.assertTrue(loginPage.isDisplayedRegisterOrSignInLinkText());

	}

	/** dj073227
	 * US-Cat-910 - This method is used to verify that user,without logged in , can see footer links ie AboutUs,
	 * Returns,Terms and Conditions, Help are displayed on Home page
	 */
	@Test(priority=8)
	public void verifyFooterLinksTest() 
	{
		Assert.assertTrue(loginPage.isAboutUsDisplayed());
		Assert.assertTrue(loginPage.isReturnsLinkDisplayed());
		Assert.assertTrue(loginPage.isTermsAndPoliciesLinkDisplayed());
		Assert.assertTrue(loginPage.isHelpLinkDisplayed());
	}




	/** dj073227
	 * 107684 - Verify sign in error message on LogOn Page
	 *//*
	@Test(priority=8)
	public void verifyErrorMessageOnLogin() 
	{
		loginPage.clickOnRegisterOrSignIn();
		signInOrRegisterPage = loginPage.clickOnRegisterForAnAccountButton();

	}*/

	/**
	 * Reviewed and updated by Divy Jain
	 * @author:nm064123
	 * @story: US-Cat-901 && US-Cat-903 && US-Cat-254 && US-Cat-902
	 * @storyDescription: Display Hero Content Carousel on Home Page Unauthenticated User && Display Video Content Blocks for Unauthenticated User && US-Cat-254: Display 'Trending Products' Carousel on Home Page Unauthenticated User
	 * && Display Home Page Hero  Content Small Blocks Unauthenticated User
	 * 
	 */
	@Test(priority=9)
	public void validateGuestContentHero() 
	{
		Assert.assertTrue(loginPage.isContentHero1Displayed());
		Assert.assertTrue(loginPage.isYourTopCategoriesTitleDisplayed());
		Assert.assertTrue(loginPage.isDisplayedContentHeroSmallBlock1());
		Assert.assertTrue(loginPage.isDisplayedContentHeroSmallBlock2());
		Assert.assertTrue(loginPage.isDisplayedContentHeroSmallBlock3());
		Assert.assertTrue(loginPage.isOrderAgainDisplayed());
		Assert.assertTrue(loginPage.isViewOrderHistoryButtonDisplayed());
		Assert.assertTrue(loginPage.isEightPartNumbersInsideOrderOnceSectionDisplayed().equals(expectedPartNumbersInsideOrderOnceSection));
		Assert.assertTrue(loginPage.isEightImagesInsideOrderOnceSectionDisplayed().equals(expectedImagesInsideOrderOnceSection));
		Assert.assertTrue(loginPage.isEightProductDescriptionsInsideOrderOnceSectionDisplayed().equals(expectedProductDescriptionsInsideOrderOnceSection));
		Assert.assertTrue(loginPage.isEightPricesInsideOrderOnceSectionDisplayed().equals(expectedPricesInsideOrderOnceSection));
		Assert.assertTrue(loginPage.isEightAddToCartButtonsInsideOrderOnceSectionDisplayed().equals(expectedAddToCartButtonsInsideOrderOnceSection));
		Assert.assertTrue(loginPage.isFourProductVisibleInsideOrderOnceSection());
		homePage.clickForwardKeyInsideOrderOnceSection();
		Assert.assertTrue(homePage.isFourProductVisibleInsideOrderOnceSection());
		homePage.clickBackwardKeyInsideOrderOnceSection();
		Assert.assertTrue(homePage.isFourProductVisibleInsideOrderOnceSection());
	}


	/**
	 *
	  To verify as unauthenticated User I want to view the User Content Recommendations which displays recommended product content to the user. 
	 US-Cat-1111
	 */
	@Test(priority=10)
	public void verifyContentRecommandationForUnauthenticatedUser() 
	{
		Assert.assertTrue(loginPage.isYourTopCategoriesCarouselSection());		
	}

	/**
	 * 
	 * @author:sandhya
	 * @story: US-Cat-900: Display Static Content Blocks for Unauthenticated User
	 * @storyDescription: Unauthenticated User wants to view articles, guides or 'how-to' tips on homepage * 
	 */

	@Test(priority=11)
	public void verifyLearnSomethingNew() throws Exception
	{
		Assert.assertTrue(loginPage.learnSomethingNew());
		Assert.assertTrue(loginPage.learnSomethingNewLeftBlock());
		Assert.assertTrue(loginPage.learnSomethingNewRightBlock());
	}

	/**
	 * @author smitha
	 * 
	 * launch the application in browser and Verify the homepage for Guest user
	 * 
	 * This Test Script is mapped to user stories US-Cat-150 US-Cat-170 and US-Cat-190
	 * 
	 */

	@Test(priority=12)
	public void displayHomePageForUnAuthenticatedUserTest() throws Exception
	{

		Assert.assertTrue(loginPage.isDisplayedRegisterOrSignInLinkText());
		Assert.assertTrue(loginPage.isDisplayedCategoryleftNavigation());
		Assert.assertTrue(loginPage.getCategoryRecommendationTitleText().equalsIgnoreCase("Top Categories"));
		Assert.assertTrue(loginPage.isDisplayedContentHeros());
		Assert.assertTrue(loginPage.IsDisplayedContentWidgetLearnSomethingNewTitleText());
	}

}
