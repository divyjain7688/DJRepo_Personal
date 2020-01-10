package com.selenium.ebiz.account_management.login;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.EcatalogPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.OfferPage;
import com.selenium.ebiz.pageobject.OrderHistoryAndStatusPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.SearchPage;
import com.selenium.ebiz.tools.CommonFunctions;

/*
 * @author dj073227
 *
 */
public class HomePageAuthenticatedUser_NOTWORKING extends BaseClass
{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	ProductListingPage productListingPage;
	ProductDetailsPage productDetailPage;
	OfferPage offerPage; 
	EcatalogPage ecatalogPage;
	OrderHistoryAndStatusPage orderHistoryAndStatusPage;
	int expectedPartNumbersInsideOrderOnceSection=8;
	int expectedImagesInsideOrderOnceSection = 8;
	int expectedProductDescriptionsInsideOrderOnceSection = 8;
	int expectedPricesInsideOrderOnceSection = 8;
	int expectedAddToCartButtonsInsideOrderOnceSection = 8;
	String facebook = "Facebook";
	String twitter = "Twitter";
	String googleplus = "Google+";
	String linkedin = "LinkedIn";
	String youtube = "YouTube";

	/**
	 * This method is used to load the property file, launch the browser 
	 * and navigate to the URL(provided in property file)
	 */
	@BeforeMethod
	public void driverSetup() throws Exception
	{
		driver = initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("verifyLogin","LoginTestData");
		loginPage.clickOnRegisterOrSignIn();
		homePage= loginPage.signInToApplication(usersList.get(0).getuserName(),usersList.get(0).getpassword());
	}

	/** dj073227
	 * US-Cat-920 - This method is used to verify that footer links ie AboutUs,Returns,Terms
	 *  and Conditions, Help are displayed on Home page
	 */

	@Test(priority=1)
	public void verifyFooterLinksTest() 
	{
		Assert.assertTrue(homePage.isAboutUsDisplayed());
		Assert.assertTrue(homePage.isReturnsLinkDisplayed());
		Assert.assertTrue(homePage.isTermsAndPoliciesLinkDisplayed());
		Assert.assertTrue(homePage.isHelpLinkDisplayed());
	}


	/** dj073227
	 * US-Cat-922 - This method is used to verify that social networking links are displayed 
	 * on Home Page
	 */

	@Test(priority=2)
	public void verifySocialNetworkLinksTest()
	{
		Assert.assertTrue(homePage.isFacebookLinkDisplayed());
		String title = homePage.clickOnFacebookLink();
		Assert.assertTrue(title.contains(facebook));
		CommonFunctions.closecurrentBrowser(driver);
		CommonFunctions.moveToNewWindow(driver);

		Assert.assertTrue(homePage.isTwitterLinkDisplayed());
		title = homePage.clickOnTwitterLink();
		Assert.assertTrue(title.contains(twitter));
		CommonFunctions.closecurrentBrowser(driver);
		CommonFunctions.moveToNewWindow(driver);

		Assert.assertTrue(homePage.isGoogleplusLinkDisplayed());
		title = homePage.clickOnGoogleplusLink();
		Assert.assertTrue(title.contains(googleplus));
		CommonFunctions.closecurrentBrowser(driver);
		CommonFunctions.moveToNewWindow(driver);

		Assert.assertTrue(homePage.isLinkedinLinkDisplayed());
		title = homePage.clickOnLinkedinLink();
		Assert.assertTrue(title.contains(linkedin));
		CommonFunctions.closecurrentBrowser(driver);
		CommonFunctions.moveToNewWindow(driver);

		Assert.assertTrue(homePage.isYoutubeLinkDisplayed());
		title = homePage.clickOnYoutubeLink();
		Assert.assertTrue(title.contains(youtube));
		CommonFunctions.closecurrentBrowser(driver);
		CommonFunctions.moveToNewWindow(driver);
	}

	/** dj073227
	 * US-Cat-931 - This method is used to verify that HD supply logo is displayed
	 * on Home Page
	 */
	@Test(priority=3)
	public void verifyHDSupplyLogoTest() 
	{
		Assert.assertTrue(homePage.isHDSupplyLogoDisplayed());
	}

	/** dj073227
	 * US-PostOrd-002 -This test is used to verify that once user logged in, user should be able to see "Order once" section in 
	 * home page and also he can navigate to PDP page by clicking any product from Order once section.
	 */
	/*Failing because in order again section, number of element are displayed as 6 intead of 8.
	W80-2142 already raised for this.Also Order again section is not visible in QA*/
	@Test(priority=4)
	public void verifyOnceOrderSection()
	{
		Assert.assertTrue(homePage.isOrderAgainDisplayed());
		Assert.assertTrue(homePage.isViewOrderHistoryButtonDisplayed());
		Assert.assertTrue(homePage.isEightPartNumbersInsideOrderOnceSectionDisplayed().equals(expectedPartNumbersInsideOrderOnceSection));
		Assert.assertTrue(homePage.isEightImagesInsideOrderOnceSectionDisplayed().equals(expectedImagesInsideOrderOnceSection));
		Assert.assertTrue(homePage.isEightProductDescriptionsInsideOrderOnceSectionDisplayed().equals(expectedProductDescriptionsInsideOrderOnceSection));
		Assert.assertTrue(homePage.isEightPricesInsideOrderOnceSectionDisplayed().equals(expectedPricesInsideOrderOnceSection));
		Assert.assertTrue(homePage.isEightAddToCartButtonsInsideOrderOnceSectionDisplayed().equals(expectedAddToCartButtonsInsideOrderOnceSection));
		Assert.assertTrue(homePage.isFourProductVisibleInsideOrderOnceSection());
		homePage.clickForwardKeyInsideOrderOnceSection();
		Assert.assertTrue(homePage.isFourProductVisibleInsideOrderOnceSection());
		homePage.clickBackwardKeyInsideOrderOnceSection();
		Assert.assertTrue(homePage.isFourProductVisibleInsideOrderOnceSection());
		productDetailPage = homePage.clickOnFirstProductInsideOrderOnceSection();
		productDetailPage = new ProductDetailsPage(driver);
		homePage.navigateBack();
		orderHistoryAndStatusPage=homePage.clickOnViewOrderHistoryButton();
	}

	/** dj073227
	 * US-Cat-951 - This method is used to verify that when user logged in and search any product with either keyword
	 * or partnumber, user should be able to see result on search page.
	 */
	@Test(priority=5)
	public void searchByKeywordOrPartNumber() throws Exception 
	{
		usersList = dbConnection.loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		searchPage= homePage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		homePage.navigateBack();
		searchPage= homePage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
	}
	/** dj073227
	 * US-Cat-963 - This method is used to verify that user logged in and successfully navigates
	 * to offers page
	 */
	@Test(priority=6)
	public void moveToOfferPage()
	{
		offerPage = homePage.isMovetoOfferPage();
	}

	/** dj073227
	 * US-Cat-961 - This method is used to verify that user logged in and click on resources, user
	 * should be able to see resources flyout.
	 */
	@Test(priority=7)
	public void verifyResourcesFlyout()
	{
		Assert.assertTrue(homePage.isResourceFlyoutDisplayed());
	}

	/** dj073227
	 * US-Cat-962 - This method is used to verify that user logged in and successfully navigates
	 * to ecatalog page
	 */
	@Test(priority=8)
	public void moveToEcatalogPage()
	{
		ecatalogPage = homePage.isMovetoECatalogPage();
	}

	/** dj073227
	 * US-Cat-930 -This test is to verify that as an Authenticated User I want to view 
	 * my Sales Rep and sales rep contact information in the header.
	 * @throws Exception 
	 */
	@Test(priority=9)
	public void verifySalesRep() throws Exception
	{
		homePage.clickOnAccountUnderUser();
		Assert.assertTrue(homePage.isAccountUnderUserModalDisplayed());
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
