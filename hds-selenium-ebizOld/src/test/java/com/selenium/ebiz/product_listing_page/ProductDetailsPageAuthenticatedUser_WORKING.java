package com.selenium.ebiz.product_listing_page;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;

public class ProductDetailsPageAuthenticatedUser_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	ProductListingPage productListingPage;
	ProductDetailsPage productDetailsPage;
	/**
	 * This method is used to load the property file, launch the browser, navigate to the URL(provided in property file), 
	 * logged in to website and navigate to Product Listing Page
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

	/*Sub category filter on frequently purchased page is not working. W80-2087 bug raised for the same.*/
	/**
	 * US-Cat-390 - This test is to verify that as a authenticated User I want to view the Product Details Page 
	 * so I can view specifications and details of products in the catalog to make a purchase.
	 */
	@Test
	public void specificationAndDetailsOfProduct()
	{
		productDetailsPage = productListingPage.clickOnFirstProduct();
		Assert.assertTrue(productDetailsPage.isBreadcrumbDisplayed());
		Assert.assertTrue(productDetailsPage.isImageThumbnailsDisplayed());
		Assert.assertTrue(productDetailsPage.isProductNameDisplayed());
		Assert.assertTrue(productDetailsPage.isPartNumberDisplayed());
		Assert.assertTrue(productDetailsPage.isPriceDisplayed());
		//	Assert.assertTrue(productDetailsPage.isShippingChargesDisplayed());
		//	Assert.assertTrue(productDetailsPage.isReturnsDisplayed());
		//	Assert.assertTrue(productDetailsPage.isDeliveryDayDisplayed());
		Assert.assertTrue(productDetailsPage.isQuantityStepperDisplayed());
		Assert.assertTrue(productDetailsPage.isBrandNameDisplayed());
		Assert.assertTrue(productDetailsPage.isAddToCartButtonDisplayed());
		Assert.assertTrue(productDetailsPage.isAddToQuoteButtonDisplayed());
		//Assert.assertTrue(productDetailsPage.isQuickCheckOutButtonDisplayed());
		Assert.assertTrue(productDetailsPage.isAddToLisButtonDisplayed());
		Assert.assertTrue(productDetailsPage.isProductDescriptionDisplayed());
		Assert.assertTrue(productDetailsPage.isProductSpecificationDisplayed());
	}
	
}
