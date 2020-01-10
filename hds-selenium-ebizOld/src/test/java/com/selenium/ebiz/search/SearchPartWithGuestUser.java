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

public class SearchPartWithGuestUser extends BaseClass {

	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();

	LoginPage loginPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	ProductDetailsPage productDetailsPage;
	SearchResultPage searchResultPage;
	ProductListingPage productListingPage;

	@BeforeMethod	
	public void driverSetup() throws MalformedURLException {
		driver = initialize();
		loginPage = new LoginPage(driver);
	}

	@Test(priority=0)
	public void searchByPartNumberGuestUserTest() throws Exception{
		WaitTool.hardWait();
		Assert.assertTrue(loginPage.IsDisplayedCreateAnAccount());
		// Verifying the Searchbox
		Assert.assertTrue(loginPage.isDisplayedSearchBox());

		// Getting the data from the input sheet and entering in the search box
		usersList = dbConnection.loadDataFromExcel("searchByPartNumberTest", "Search");
		System.out.println(usersList.get(0).getSearchProductPartNumber());
		loginPage.enterSearchEdit(usersList.get(0).getSearchProductPartNumber());		
		searchResultPage = loginPage.clickOnSearchButton();
		String strPartNumber = searchResultPage.getSearchPartNumberText();
		strPartNumber =  strPartNumber.substring(strPartNumber.lastIndexOf(' ')+1);
		System.out.println("strPartNumber: "+strPartNumber);
		Assert.assertEquals(usersList.get(0).getSearchProductPartNumber(), "P"+strPartNumber);
	}

	/**
	 * Author sandhya
	 * US-Cat-770 Display Search Result Page for Discontinued Part with Replacement for Unauthenticated User
	 * */
	@Test(priority=1)
	public void discontinuedPartwithReplacementGuestUser() throws Exception{
		//WaitTool.hardWait();
		WaitTool.hardWait();
		Assert.assertTrue(loginPage.IsDisplayedCreateAnAccount());
		// Verifying the Searchbox
		Assert.assertTrue(loginPage.isDisplayedSearchBox());
		usersList = dbConnection.loadDataFromExcel("discontinuedPartwithReplacement", "Search");
		System.out.println(usersList.get(0).getSearchProductPartNumber());
		loginPage.enterSearchEdit(usersList.get(0).getSearchProductPartNumber());		
		searchResultPage = loginPage.clickOnSearchButton();
		WaitTool.hardWait();

		//** Verifying Replacement part text on Grid view*** 
		//homePage.gridViewIcon();
		//WaitTool.hardWait();
		Assert.assertTrue(homePage.replacementPartText());
	}

	/**
	 * Author sandhya
	 * US-Cat-710 No Results Displayed on Search Results Page for Unauthenticated User
	 * 
	 * Reviewed and Modified by Bhavani
	 * */
	@Test(priority=2)
	public void noResultSearchPageGuestUser() throws Exception{
		// Verifying the Searchbox
		WaitTool.hardWait();
		Assert.assertTrue(loginPage.isDisplayedSearchBox());
		usersList = dbConnection.loadDataFromExcel("noSearchResult", "Search");
		loginPage.enterSearchEdit(usersList.get(0).getSearchProductKeyword());
		searchResultPage = loginPage.clickOnSearchButton();
		WaitTool.hardWait();
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
	 * To verify , As a Unauthenticated User I want to leverage the Search Bar to search for products in the catalog. 
	 * 
	 * US-Cat-560
	 * 
	 * */
	@Test(priority=4)
	public void verifySearchResultPageUnauthorizedUser() throws Exception {

		usersList = dbConnection.loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		String searchData = usersList.get(0).getSearchProductKeyword();
		System.out.println("searchData is"+ searchData);	
		loginPage.enterDataForSearch(searchData);
		searchResultPage = loginPage.clickSearchButton();
		// search result displayed for the data entered
		Assert.assertTrue(searchResultPage.isDisplayedSearchResultList());
		//Assert.assertTrue(searchResultPage.isDisplayedSearchResultPageGridViewIcon());			
		loginPage = searchResultPage.clickOnHDSupplyLogo();
		//enter one word data in the searchbox
		loginPage.enterDataForSearch(searchData.substring(0, 1));
		//No result should be displayed when first charecter is entered.
		Assert.assertFalse(loginPage.isDisplayedsearchSuggestedProducts());
		loginPage.clearDatainSearchBox();
		loginPage.enterDataForSearch(searchData.substring(0, 2));
		WaitTool.hardWait();
		//verify results begin to show when user enters 2nd character
		Assert.assertTrue(loginPage.isDisplayedsearchSuggestedProducts());
		Assert.assertTrue(loginPage.isDisplayedsearchAdvanceSearch());

		loginPage.clearDatainSearchBox();
		searchData = searchData.substring(0, 2);
		loginPage.enterDataForSearch(searchData);
		WaitTool.hardWait();
		//verify suggested list is displayed.
		Assert.assertTrue(loginPage.isDisplayedsearchSuggestedProducts(searchData));
		productDetailsPage= loginPage.clickOnSuggestedSearchResult();
		//When clicked on the suggested list search result should be displayed.
		Assert.assertTrue(productDetailsPage.isDisplayedproductDetailsHeader());								
	}

	/**
	 * @Story: Us-cat-690 :Unauthenticated User Views Search Result Page List View
	 * Assert fails if the list view is NOT the default view  
	 * 
	 * @throws Exception
	 */

	@Test(priority=5)
	public void verifySearchResultsListView() throws Exception {

		usersList = dbConnection.loadDataFromExcel("verifySearchResultsListViewLoggedInUser", "Search");
		homePage = new HomePage(driver);
		homePage.enterSearchEdit(usersList.get(0).getSearchProductPartNumber());
		WaitTool.hardWait2sec();
		searchResultPage = homePage.clickSearchButton();
		WaitTool.hardWait();
		//Assert identifies grid view element as disabled and compares with true which leaves list view as enabled.
		//If the assert fails then list view is NOT the displayed view and is a defect.
		Assert.assertEquals(searchResultPage.isDisplayedSearchResultPageGridViewIcon(), true);
	}

}


