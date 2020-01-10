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
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.SearchPage;

/*
 * @author dj073227
 *
 */
public class StayConnectedHomePageLoggedInUser extends BaseClass
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
	int expectedPartNumbersInsideOrderOnceSection=8;
	int expectedImagesInsideOrderOnceSection = 8;
	int expectedProductDescriptionsInsideOrderOnceSection = 8;
	int expectedPricesInsideOrderOnceSection = 8;
	int expectedAddToCartButtonsInsideOrderOnceSection = 8;

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
		homePage = new HomePage(driver);
	}

	/**
	 * US-Cat-920 - This method is used to verify that footer links ie AboutUs,Returns,Terms
	 *  and Conditions, Help are displayed on Home page
	 */

	@Test(priority=0)
	public void verifyFooterLinksTest() 
	{
		Assert.assertTrue(homePage.isAboutUsDisplayed());
		Assert.assertTrue(homePage.isReturnsLinkDisplayed());
		Assert.assertTrue(homePage.isTermsAndPoliciesLinkDisplayed());
		Assert.assertTrue(homePage.isHelpLinkDisplayed());
	}

	/**
	 * US-Cat-922 - This method is used to verify that social networking links are displayed 
	 * on Home Page
	 */

	@Test(priority=1)
	public void verifySocialNetworkLinksTest()
	{
		Assert.assertTrue(homePage.isFacebookLinkDisplayed());
		Assert.assertTrue(homePage.isTwitterLinkDisplayed());
		Assert.assertTrue(homePage.isGoogleplusLinkDisplayed());
		Assert.assertTrue(homePage.isLinkedinLinkDisplayed());
		Assert.assertTrue(homePage.isYoutubeLinkDisplayed());
	}

	/**
	 * US-Cat-931 - This method is used to verify that HD supply logo is displayed
	 * on Home Page
	 */
	@Test(priority=2)
	public void verifyHDSupplyLogoTest() 
	{
		Assert.assertTrue(homePage.isHDSupplyLogoDisplayed());
	}

	/**
	 * US-PostOrd-002 -This test is used to verify that once user logged in, user should be able to see "Order once" section in 
	 * home page and also he can navigate to PDP page by clicking any product from Order once section.
	 */
	@Test(priority=3)
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
	}

	/**
	 * US-Cat-951 - This method is used to verify that when user logged in and search any product with either keyword
	 * or partnumber, user should be able to see result on search page.
	 */
	/*@Test(priority=5)
	public void searchByKeywordOrPartNumber() throws Exception 
	{
		usersList = dbConnection.loadDataFromExcel("searchByKeywordOrPartNumber","SearchTestData");
		searchPage= homePage.searchByKeywordOrPartNumber(usersList.get(0).getSearchKeyword());
		homePage.navigateBack();
		searchPage= homePage.searchByKeywordOrPartNumber(usersList.get(0).getSearchPartNumber());
	}*/
	
	@Test(priority=4)
	public void searchByKeywordOrPartNumber() throws Exception 
	{
		usersList = dbConnection.loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		searchPage= homePage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		homePage.navigateBack();
		searchPage= homePage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
	}
	/**
	 * US-Cat-963 - This method is used to verify that user logged in and successfully navigates
	 * to offers page
	 */
	@Test(priority=5)
	public void moveToOfferPage()
	{
		offerPage = homePage.isMovetoOfferPage();
	}

	/**
	 * US-Cat-961 - This method is used to verify that user logged in and click on resources, user
	 * should be able to see resources flyout.
	 */
	@Test(priority=6)
	public void verifyResourcesFlyout()
	{
		Assert.assertTrue(homePage.isResourceFlyoutDisplayed());
	}

	/**
	 * US-Cat-962 - This method is used to verify that user logged in and successfully navigates
	 * to ecatalog page
	 */
	@Test(priority=7)
	public void moveToEcatalogPage()
	{
		ecatalogPage = homePage.isMovetoECatalogPage();
	}


}
