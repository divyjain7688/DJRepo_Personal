/**
 * 
 * @author suresh
 * 
 * This test will verify Add to Cart in the Sub Category Page
 * 
 * This Test Script is mapped to US-CAT-272
 * 
 * 
 * 
 */
package com.selenium.ebiz.add_to_cart;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.CategoryAppliancesPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;


public class AddToCartSubCategoryPage extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();

	LoginPage loginPage;
	HomePage homePage;
	CategoryAppliancesPage categoryAppliancesPage;
	SubCategoryAppliancesPage subCategoryAppliancesPage;
	ProductListingPage productListingPage;


	/*
	 *  Launching of the Browser and login with Valid Credentials
	 */

	@BeforeMethod
	public void driverSetup() throws MalformedURLException, Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
	}

	/**
	 *  Verifying the add to Cart in the Sub Category pages
	 * Reviewed and modified by bm071260
	 * @throws Exception
	 */
	@Test
	public void addToCartSubCategoryTest() throws Exception{
		// Verifying the Left Navigation 
		WaitTool.hardWait();
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		WaitTool.hardWait();
		// Clicking on the Header Shop By Category
		/*	homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// click on the Appliances
		Appliances appliances = homePage.clickCategoryAppliancesLinkText();
		// click on the DishWashers Repair
		subCategoryAppliancesPage = appliances.clickTopCategoryDishwashersRepairLinkText();
		// click on the Dishwashers link
		productListingPage = subCategoryAppliancesPage.clickSubCategoryDishwashersLink();*/
		productListingPage=homePage.moveToSubCategoryPage();
		// click on the List View
		Assert.assertTrue(productListingPage.isListViewDisplayed());
		productListingPage.clickOnListView();
		//Click on the Add to Cart Button
		List<WebElement> firstProduct = (List<WebElement>) productListingPage.selectSubCategoriesAddtoCartButton();
		System.out.println("firstProduct"+firstProduct);
		WaitTool.hardWait();
		WaitTool.hardWait();
		WaitTool.hardWait();
		CommonFunctions.scrolltoViewElement(firstProduct.get(1), driver);
		// clicking on the first Add to Cart
		firstProduct.get(1).click();
		WaitTool.hardWait();
		// Verifying the Add to Cart Text
		/*String expectedResult = subCategoryAppliancesPage.getAddtoCartText();
        Assert.assertTrue(expectedResult.contains("Successfully added to your shopping cart"));	
 		subCategoryAppliancesPage.close();
        //subCategoryAppliancesPage.alertCancelPopUpWindow();
		 */	}

}
