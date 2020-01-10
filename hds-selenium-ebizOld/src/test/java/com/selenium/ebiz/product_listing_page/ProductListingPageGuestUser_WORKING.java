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
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.tools.WaitTool;

/**
 * @author dj073227
 *
 */
public class ProductListingPageGuestUser_WORKING extends BaseClass
{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	ProductListingPage productListingPage;
	String expectedPopupErrorMessage ="The maximum number of products that can be compared is 4. Please refine your selection."; 			

	/**
	 * This method is used to load the property file, launch the browser, 
	 * navigate to the URL(provided in property file),does not logged in to 
	 * website and navigate to Product Listing Page
	 */
	@BeforeMethod
	public void driverSetup() throws Exception
	{
		driver=initialize();
		loginPage = new LoginPage(driver);
		productListingPage=loginPage.moveToSubCategoryPage();
	}

	/** dj073227
	 * US-Cat-320 - This method is used to verify that when user does not logged in to website 
	 * and navigate to PLP page, products are displayed in Grid view on Product Listing Page
	 */
	@Test(priority=1)
	public void verifySubCategoryPageGridView() 
	{
		Boolean flag = productListingPage.isGridViewDisplayed();
		Assert.assertTrue(flag);
	}

	/** dj073227
	 * US-Cat-340 - This method is used to verify that when user does not logged in to website 
	 * and navigate to PLP page, products are displayed in List view by default
	 * on Product Listing Page
	 */

	/*	Test was failing: expecting list view by default right but currently it is grid view by default.W80-1730  is raised
	Requirement got updated to have grid view as default view*/
	@Test(priority=2)
	public void verifySubCategoryPageListView() 
	{
		Boolean flag = productListingPage.isListViewDisplayed();
		Assert.assertTrue(flag);
	}

	/** dj073227
	 * US-Cat-361 - This method is used to verify that when user does not logged in to website,navigate to PLP page
	 * and select a product from PLP page ,Product compare widget should gets displayed in 
	 * bottom of page and user can select max of 4 products to compare on PLP page.
	 */
	@Test(priority=3)
	public void verifyProductSelectWidget() throws Exception
	{
		Assert.assertFalse(productListingPage.isComapreProductWidgetDisplayed());
		productListingPage.clickonFirstCheckbox();
		Assert.assertTrue(productListingPage.isFirstProductOnProductWidgetSelected());
		productListingPage.clickonSecondCheckbox();
		Assert.assertTrue(productListingPage.isSecondProductOnProductWidgetSelected());		
		productListingPage.clickonThirdCheckbox();
		Assert.assertTrue(productListingPage.isThirdProductOnProductWidgetSelected());
		productListingPage.clickonFourthCheckbox();
		Assert.assertTrue(productListingPage.isFourthProductOnProductWidgetSelected());
		Assert.assertTrue(productListingPage.isComapreProductWidgetDisplayed());
		productListingPage.clickonFifthCheckbox();
		String actualPopupErrorMessage = productListingPage.isTextOnPopupWindowDisplayed();
		WaitTool.hardWait();
		Assert.assertTrue(actualPopupErrorMessage.contains(expectedPopupErrorMessage));
	}

	/** dj073227
	 * US-Cat-360 - This method is used to verify that when a user does not logged in to website,navigate to PLP page
	 * and select th eproduct and then deselect the selected product from PLP page, Product compare widget
	 * should gets updated accordingly.When user scroll up or scroll down the PLP page, Product compare 
	 * widget should be in place.
	 */
	@Test(priority=4)
	public void verifyProductSelectDeselectWidgetAndScrollUpDown() throws Exception
	{
		Assert.assertFalse(productListingPage.isComapreProductWidgetDisplayed());
		productListingPage.clickonFirstCheckbox();
		Assert.assertTrue(productListingPage.isFirstProductOnProductWidgetSelected());
		productListingPage.clickonSecondCheckbox();
		Assert.assertTrue(productListingPage.isSecondProductOnProductWidgetSelected());		
		productListingPage.scrollUp();
		Assert.assertTrue(productListingPage.isComapreProductWidgetDisplayed());
		productListingPage.scrollDown();
		Assert.assertTrue(productListingPage.isComapreProductWidgetDisplayed());
		productListingPage.clickonThirdCheckbox();
		Assert.assertTrue(productListingPage.isThirdProductOnProductWidgetSelected());
		productListingPage.clickonFourthCheckbox();
		Assert.assertTrue(productListingPage.isFourthProductOnProductWidgetSelected());
		Assert.assertTrue(productListingPage.isComapreProductWidgetDisplayed());
		productListingPage.clickonFifthCheckbox();
		String actualPopupErrorMessage = productListingPage.isTextOnPopupWindowDisplayed();
		WaitTool.hardWait();
		Assert.assertTrue(actualPopupErrorMessage.contains(expectedPopupErrorMessage));
		productListingPage.clickonFourthCheckbox();
		Assert.assertTrue(productListingPage.isFourthProductOnProductWidgetDeselected());
		productListingPage.clickonThirdCheckbox();
		Assert.assertTrue(productListingPage.isThirdProductOnProductWidgetDeselected());
		productListingPage.clickonSecondCheckbox();
		Assert.assertTrue(productListingPage.isSecondProductOnProductWidgetDeselected());
		productListingPage.clickonFirstCheckbox();
		Assert.assertFalse(productListingPage.isComapreProductWidgetDisplayed());
	}


}
