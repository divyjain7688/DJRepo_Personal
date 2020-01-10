
package com.selenium.ebiz.search;
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
import com.selenium.ebiz.pageobject.MyAccountPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.SearchResultPage;
import com.selenium.ebiz.tools.WaitTool;


public class SearchPartWithLoggedInUser extends BaseClass {
	DBCon dbConnection = new DBCon();
	ArrayList<UsersListBean> usersList;

	LoginPage loginPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	ProductDetailsPage productDetailsPage;
	SearchResultPage searchResultPage;
	ProductListingPage productListingPage;

	@BeforeMethod	
	public void driverSetup() throws MalformedURLException, Exception {
		driver = initialize();		
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
	}

	/**
	 *  Getting the Part Number from the input Sheet and searches in the application. The application displays the part number which gets 
	 *  verified.
	 */	 

	@Test(priority=0)
	public void searchByPartNumberLoggedInUserTest() throws Exception{
		WaitTool.hardWait();
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi"));
		// Verifying the Left Navigation
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		// Verifying the Searchbox
		Assert.assertTrue(homePage.isDisplayedSearchBoxText());

		// Getting the data from the input sheet
		usersList = dbConnection.loadDataFromExcel("searchByPartNumberTest", "Search");
		// Entering the Values in the Search Box
		homePage.enterSearchEdit(usersList.get(0).getSearchProductPartNumber());
		// click on Search Button
		searchResultPage = homePage.clickSearchButton();
		WaitTool.hardWait();

		String strPartNumber = searchResultPage.getSearchPartNumberText();
		strPartNumber =  strPartNumber.substring(strPartNumber.lastIndexOf(' ')+1);
		System.out.println("strPartNumber: "+strPartNumber);
		Assert.assertEquals(usersList.get(0).getSearchProductPartNumber(), "P"+strPartNumber);
	}

	/**
	 * Author sandhya
	 * US-Cat-780 Display Search Result Page for Discontinued Part with Replacement for Authenticated User
	 * */
	@Test(priority=1)
	public void discontinuedPartwithReplacementLoggedInUser() throws Exception{
		// Verifying the Searchbox
		WaitTool.hardWait();
		Assert.assertTrue(homePage.isDisplayedSearchBox());

		usersList = dbConnection.loadDataFromExcel("discontinuedPartwithReplacement","Search");
		System.out.println(usersList.get(0).getSearchProductPartNumber());
		homePage.enterSearchEdit(usersList.get(0).getSearchProductPartNumber());
		homePage.clickSearchIcon();
		WaitTool.hardWait();

		Assert.assertTrue(homePage.replacementPartText());
	}

	/**
	 * Author sandhya
	 * US-Cat-720 No Results Displayed on Search Results Page for Authenticated User
	 * */
	@Test(priority=2)
	public void noResultSearchPageLoggedInUser() throws Exception{
		// Verifying the Searchbox
		WaitTool.hardWait();
		Assert.assertTrue(homePage.isDisplayedSearchBox());
		usersList = dbConnection.loadDataFromExcel("noSearchResult", "Search");
		loginPage.enterSearchEdit(usersList.get(0).getSearchProductKeyword());
		// Entering the Values in the Search Box 
		searchResultPage = homePage.clickSearchButton();
		WaitTool.hardWait();
		Assert.assertTrue(searchResultPage.noResultSearchTitle());
		Assert.assertTrue(searchResultPage.noResultPagePara1());
		Assert.assertTrue(searchResultPage.noResultPagePara2());
		//Assert.assertTrue(homePage.richrelevance());
	}

	/**
	 *  Moves from Left Navigation to the Sub Category Pages and clicks on the BreadCrumb which displays homepage and then to the
	 *  Sub Category Pages. Here we are entering product number to search the same and verify the Status,Price etc
	 */	 

	@Test(priority=3)
	public void searchItemInL2CategoryAuthenticateUserTest() throws Exception{
		usersList = dbConnection.loadDataFromExcel("searchItemInL2CategoryTest","Search");
		String sPartNumber   = usersList.get(0).getSearchProductPartNumber();
		int idPartNumber = Integer.parseInt(sPartNumber.substring(1));
		System.out.println("idPartNumber is " + idPartNumber);
		productListingPage = homePage.moveToSubCategoryPage();
		// Verifying the Searchbox
		Assert.assertTrue(homePage.isDisplayedSearchBoxText());
		// Entering the Values in the Search Box
		homePage.enterSearchEdit(usersList.get(0).getSearchProductPartNumber());
		// click on Search Button
		searchResultPage = homePage.clickSearchButton();
		WaitTool.hardWait();
		// Verifying that price on left side is displayed or not
		Assert.assertTrue(searchResultPage.isDisplayedSearchPriceText());
		// Verifying that the Brand on the Left side is displayed or not
		Assert.assertTrue(searchResultPage.isDisplayedSearchBrandText());
		// Clicking on the checkbox of Brand
		// searchResultPage.clickSearchBrandCheckbox();
		// Getting the part number from the checked brand
		String searchPartNumber = searchResultPage.getSearchPartNumberText();
		int iPartNumber = Integer.parseInt(searchPartNumber.substring(5));
		// Verifying the data from the input sheet and that from the page
		Assert.assertEquals(idPartNumber, iPartNumber);
	}

	/**
	 * To verify as As an authenticated user, As a Authenticated User I want to leverage the Search Bar to search for products in the catalog. 
	 * 
	 * 
	 * US-Cat-540
	 * 
	 * */

	@Test(priority=4)
	public void verifySearchResultPageLoggedInUser() throws Exception {

		usersList = dbConnection.loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		String searchData = usersList.get(0).getSearchProductKeyword();
		System.out.println(searchData);
		homePage.enterDataForSearch(searchData);
		searchResultPage = homePage.clickSearchButton();
		// search result displayed for the data entered
		Assert.assertTrue(searchResultPage.isDisplayedSearchResultList());
		//Assert.assertTrue(searchResultPage.isDisplayedSearchResultPageGridViewIcon());			
		homePage = searchResultPage.clickOnHDSupplyLogoAsLoggedinUser();
		//enter one word data in the searchbox
		homePage.enterDataForSearch(searchData.substring(0, 1));
		//No result should be displayed when first charecter is entered.
		Assert.assertFalse(homePage.isDisplayedsearchSuggestedProducts());
		homePage.clearDatainSearchBox();
		homePage.enterDataForSearch(searchData.substring(0, 2));
		WaitTool.hardWait();
		//verify results begin to show when user enters 2nd character
		Assert.assertTrue(loginPage.isDisplayedsearchSuggestedProducts());
		Assert.assertTrue(loginPage.isDisplayedsearchAdvanceSearch());
		homePage.clearDatainSearchBox();
		searchData = searchData.substring(0, 2);
		homePage.enterDataForSearch(searchData);
		WaitTool.hardWait();
		//verify suggested list is displayed.
		Assert.assertTrue(homePage.isDisplayedsearchSuggestedProducts(searchData));
		productDetailsPage= homePage.clickOnSuggestedSearchResult();
		//When clicked on the suggested list search result should be displayed.
		Assert.assertTrue(productDetailsPage.isDisplayedproductDetailsHeader());								
	}

	/**
	 * @Story: Us-cat-700 : Authenticated User Views Search Result Page List View
	 * @Story: US-Cat-680 : Authenticated User Views Search Result Page Grid View
	 * 
	 * @throws Exception
	 */
	@Test(priority=5)
	public void verifySearchResultsListView() throws Exception {

		usersList = dbConnection.loadDataFromExcel("verifySearchResultsListViewLoggedInUser", "Search");
		homePage.enterSearchEdit(usersList.get(0).getSearchProductPartNumber());
		WaitTool.hardWait2sec();
		searchResultPage = homePage.clickSearchButton();
		WaitTool.hardWait();
		//Assert identifies grid view element as disabled and compares with true which leaves list view as enabled.
		//If the assert fails then list view is NOT the displayed view and is a defect.
		Assert.assertEquals(searchResultPage.isDisplayedSearchResultPageGridViewIcon(), true);
		searchResultPage.clickGridViewTextElement();
		WaitTool.hardWait2sec();
		//Assert identifies List view element as disabled and compares with true which leaves grid view as enabled.
		//If the assert fails then Grid view is NOT the displayed view and is a defect.
		Assert.assertEquals(searchResultPage.isDisplayedSearchResultPageListViewIcon(), true);
	}
}


