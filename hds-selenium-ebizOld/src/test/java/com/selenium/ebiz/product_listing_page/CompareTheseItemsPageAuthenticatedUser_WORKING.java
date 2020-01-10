package com.selenium.ebiz.product_listing_page;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.CompareTheseItems;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.ProductListingPage;

public class CompareTheseItemsPageAuthenticatedUser_WORKING extends BaseClass
{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	ProductListingPage productListingPage;
	CompareTheseItems compareTheseItems;

	/**
	 * This method is used to load the property file, launch the browser, 
	 * navigate to the URL(provided in property file), logged in to 
	 * website and navigate to Product Listing Page
	 */
	@BeforeMethod
	public void driverSetup() throws Exception
	{
		driver=initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("verifyLogin","LoginTestData");
		loginPage.clickOnRegisterOrSignIn();
		homePage= loginPage.signInToApplication(usersList.get(0).getuserName(),usersList.get(0).getpassword());
		productListingPage=homePage.moveToSubCategoryPage();
	}

	/** dj073227
	 * US-Cat-362 - This test is to verify that when user logged in,navigate to PLP page,
	 * select 2 or more products, he should be navigated to compare these items page and should see all tag,
	 * tiles and links of selected products.User should also be able to navigate through breadcrum
	 * @throws Exception 
	 */
	@Test(priority=1)
	public void verifyProductTilesWithButtons()
	{
		int productSelectedFromPLPPage = 0;
		int numberOfComparisonTiles;
		int numberOfremoveLinksInsideComparisonTiles ;
		productListingPage.clickonFirstCheckbox();
		productSelectedFromPLPPage =productListingPage.counterIncrease(productSelectedFromPLPPage);
		System.out.println("1 productSelectedFromPLPPage "+ productSelectedFromPLPPage);
		productListingPage.clickonSecondCheckbox();
	//	productSelectedFromPLPPage = CompareTheseItems.counterIncrease();
		productSelectedFromPLPPage =productListingPage.counterIncrease(productSelectedFromPLPPage);
		System.out.println("2 productSelectedFromPLPPage "+ productSelectedFromPLPPage);
		Assert.assertTrue(productListingPage.isComapreProductWidgetDisplayed());
		compareTheseItems = productListingPage.clickCompareTheseButton();	
		numberOfComparisonTiles = compareTheseItems.numberOfComparisonTiles();
		numberOfremoveLinksInsideComparisonTiles = compareTheseItems.numberOfremoveLinksInsideComparisonTiles();
		Assert.assertEquals(numberOfComparisonTiles, productSelectedFromPLPPage,numberOfremoveLinksInsideComparisonTiles);
		Assert.assertTrue(compareTheseItems.isAddAnotherProductTileDisplayed());
		Assert.assertTrue(compareTheseItems.isFirstTileDisplayed());
		Assert.assertTrue(compareTheseItems.isRemoveLinkInsideFirstTileDisplayed());
		Assert.assertTrue(compareTheseItems.isQuantityBarInsideFirstComparisonTileDisplayed());
		Assert.assertTrue(compareTheseItems.isProductImageInsideFirstComparisonTileDisplayed());
		Assert.assertTrue(compareTheseItems.isAddToListInsideFirstComparisonTileDisplayed());
		Assert.assertTrue(compareTheseItems.isAddToQuoteInsideFirstComparisonTile());
		Assert.assertTrue(compareTheseItems.isAddToCartInsideFirstComparisonTile());
		Assert.assertTrue(compareTheseItems.isSecondTileDisplayed());
		Assert.assertTrue(compareTheseItems.isRemoveLinkInsideSecondTileDisplayed());
		Assert.assertTrue(compareTheseItems.isQuantityBarInsideSecondComparisonTileDisplayed());
		Assert.assertTrue(compareTheseItems.isProductImageInsideSecondComparisonTileDisplayed());
		Assert.assertTrue(compareTheseItems.isAddToListInsideSecondComparisonTileDisplayed());
		Assert.assertTrue(compareTheseItems.isAddToQuoteInsideSecondComparisonTile());
		Assert.assertTrue(compareTheseItems.isAddToCartInsideSecondComparisonTile());
		compareTheseItems.clickRemoveLinkInsideFirstTileDisplayed();
	//	numberOfComparisonTiles = CompareTheseItems.counterDecrease();
		numberOfComparisonTiles =productListingPage.counterDecrease(numberOfComparisonTiles);
		Assert.assertEquals(numberOfComparisonTiles,compareTheseItems.numberOfComparisonTiles());
		compareTheseItems.clickRemoveLinkInsideFirstTileDisplayed();
		//numberOfComparisonTiles = CompareTheseItems.counterDecrease();
		numberOfComparisonTiles =productListingPage.counterDecrease(numberOfComparisonTiles);
		Assert.assertEquals(numberOfComparisonTiles,compareTheseItems.isNumberOfComparisonTilesZero());
		productListingPage = compareTheseItems.clickOnL2BreadCrum();
		productListingPage.clickonFirstCheckbox();
		productListingPage.clickonSecondCheckbox();
		productListingPage.clickonThirdCheckbox();
		//productSelectedFromPLPPage = CompareTheseItems.counterIncrease();
		productSelectedFromPLPPage =productListingPage.counterIncrease(productSelectedFromPLPPage);
		compareTheseItems = productListingPage.clickCompareTheseButton();	
		Assert.assertTrue(compareTheseItems.isAddAnotherProductTileDisplayed());
		productListingPage=compareTheseItems.clickOnAddNewProductTile();
		productListingPage.clickonFourthCheckbox();
		compareTheseItems = productListingPage.clickCompareTheseButton();	
		Assert.assertTrue(compareTheseItems.isProductSpecificationExists());
	}

}
