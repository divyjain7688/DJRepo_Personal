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

import java.util.ArrayList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.CategoryAppliancesPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;


public class AddToCartSubCategoryPageLoggedInUser_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	CategoryAppliancesPage categoryAppliancesPage;
	SubCategoryAppliancesPage subCategoryAppliancesPage;
	ShoppingCartPage shoppingCartPage;
	ProductListingPage productListingPage;
	/*
	 *  Launching of the Browser and login with Valid Credentials
	 */

	@BeforeMethod
	public void driverSetup() throws Exception 
	{
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));

	}


	@Test(priority=0)
	public void addToCartSubCategoryAuthenticateUserTest() throws Exception
	{

		productListingPage = homePage.moveToSubCategoryPage();
		productListingPage.clickonFirstProductAddToCart();
		productListingPage.clickOnCloseAddtocartSuccessPopup();

	}
	/**
	 *  Verifying the add to Cart in the Sub Category pages
	 */
	/*
	@Test(priority=0)
	public void addToCartSubCategoryAuthenticateUserTest() throws Exception{
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		WaitTool.hardWait();
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		// Verifying the Left Navigation 
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		WaitTool.hardWait();
		shoppingCartPage = homePage.clickShoppingCartCheckOutButton();
		WaitTool.hardWait();
		subCategoryAppliancesPage = shoppingCartPage.clickModalViewCartButton();
		List<WebElement> removeButton = null;
		do {
			removeButton = subCategoryAppliancesPage.getShoppingCartRemoveButton();
			if (removeButton.size()>0) {
				//for(int i =0;i<=removeButton.size();i++) {
					removeButton.get(0).click();
					WaitTool.hardWait();
					//driver.findElement(By.xpath("//a[@id='clickableErrorMessageImg']/div[@class='close_icon']")).click();
					subCategoryAppliancesPage.clickPopupCloseButton();
				//}
			}
			removeButton = subCategoryAppliancesPage.getShoppingCartRemoveButton();
			 if (removeButton.size()==0) {
				 break;
			 }

		} while(removeButton.size()>0);
		// Clicking on the Header Shop By Category
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// click on the Appliances
		categoryAppliancesPage = homePage.clickCategoryAppliancessLinkText();
		// click on the DishWashers Repair
		subCategoryAppliancesPage = categoryAppliancesPage.clickTopCategoryDishwashersRepairLinkText();
		// click on the Dishwashers link
		subCategoryAppliancesPage.clickSubCategoryDishwashersLinkText();
		// click on the List View
		subCategoryAppliancesPage.clickSubCategoryListViewLinkText();
		//Click on the Add to Cart Button
		List<WebElement> firstProduct = (List<WebElement>) subCategoryAppliancesPage.selectSubCategoriesAddtoCartButton();
		// clicking on the first Add to Cart
		firstProduct.get(0).click();
        WaitTool.hardWait();
		// Verifying the Add to Cart Text
        String expectedResult = subCategoryAppliancesPage.getAddtoCartText();
        Assert.assertTrue(expectedResult.contains("Successfully added to your shopping cart"));
        String modalPrice = shoppingCartPage.getModalShoppingCartPriceText();
        double dModalPrice = Double.parseDouble(modalPrice.substring(1));
        subCategoryAppliancesPage.clickModalAddCartCheckOutButton();
       // List<WebElement> removeButton = subCategoryAppliancesPage.getShoppingCartRemoveButton();
     // Verifying the Price is displayed 
     	Assert.assertTrue(shoppingCartPage.isDisplayedPriceText());
     	String price = shoppingCartPage.getShoppingCartPriceText();
     	double dPrice = Double.parseDouble(price.substring(1));
     	Assert.assertEquals(dModalPrice,dPrice);
        // Verifying the Price is displayed 
     	Assert.assertTrue(shoppingCartPage.isDisplayedAddToListButton());
        // Verifying the Price is displayed 
     	Assert.assertTrue(shoppingCartPage.isDisplayedAddToQuote());
        // Verifying the Price is displayed 
     	Assert.assertTrue(shoppingCartPage.isDisplayedRemoveButton());
        // Verifying the Price is displayed 
     	Assert.assertTrue(shoppingCartPage.isDisplayedCheckOutButton());
     	// Clicking on the Checkout Button
     	shoppingCartPage.clickShoppingCartCheckOutButton();
     	WaitTool.hardWait();
     	// Verifying the Add Payment and Checkout
     	Assert.assertTrue(shoppingCartPage.getShoppingCartPaymentText().equalsIgnoreCase("Add payment and checkout"));
     	// Clicking on the Secure To Order Button
     	shoppingCartPage.clickSecureToOrderButton();
     	WaitTool.hardWait();
     	// Verifying the Order Process
    // 	Assert.assertTrue(shoppingCartPage.getShoppingCartOrderProcessText().equalsIgnoreCase("Generic System Error"));

	}

	  /// NEED TO VALIDATE
	// @Test(priority=1)
	public void addToCartSubCategoryGuestUserTest() throws Exception{
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		WaitTool.hardWait();
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

		// Verifying the Left Navigation 
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		WaitTool.hardWait();
		shoppingCartPage = homePage.clickShoppingCartCheckOutButton();
		WaitTool.hardWait();
		subCategoryAppliancesPage = shoppingCartPage.clickModalViewCartButton();
		List<WebElement> removeButton = null;
		do {
			removeButton = subCategoryAppliancesPage.getShoppingCartRemoveButton();
			if (removeButton.size()>0) {
				//for(int i =0;i<=removeButton.size();i++) {
					removeButton.get(0).click();
					WaitTool.hardWait();
					//driver.findElement(By.xpath("//a[@id='clickableErrorMessageImg']/div[@class='close_icon']")).click();
					subCategoryAppliancesPage.clickPopupCloseButton();
				//}
			}
			removeButton = subCategoryAppliancesPage.getShoppingCartRemoveButton();
			 if (removeButton.size()==0) {
				 break;
			 }

		} while(removeButton.size()>0);
		// Clicking on the Header Shop By Category
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// click on the Appliances
		categoryAppliancesPage = homePage.clickCategoryAppliancessLinkText();
		// click on the DishWashers Repair
		subCategoryAppliancesPage = categoryAppliancesPage.clickTopCategoryDishwashersRepairLinkText();
		// click on the Dishwashers link
		subCategoryAppliancesPage.clickSubCategoryDishwashersLinkText();
		// click on the List View
		subCategoryAppliancesPage.clickSubCategoryListViewLinkText();
		//Click on the Add to Cart Button
		List<WebElement> firstProduct = (List<WebElement>) subCategoryAppliancesPage.selectSubCategoriesAddtoCartButton();
		// clicking on the first Add to Cart
		firstProduct.get(0).click();
        WaitTool.hardWait();
		// Verifying the Add to Cart Text
        String expectedResult = subCategoryAppliancesPage.getAddtoCartText();
        Assert.assertTrue(expectedResult.contains("Successfully added to your shopping cart"));
        String modalPrice = shoppingCartPage.getModalShoppingCartPriceText();
        double dModalPrice = Double.parseDouble(modalPrice.substring(1));
        subCategoryAppliancesPage.clickModalAddCartCheckOutButton();
       // List<WebElement> removeButton = subCategoryAppliancesPage.getShoppingCartRemoveButton();
     // Verifying the Price is displayed 
     	Assert.assertTrue(shoppingCartPage.isDisplayedPriceText());
     	String price = shoppingCartPage.getShoppingCartPriceText();
     	double dPrice = Double.parseDouble(price.substring(1));
     	Assert.assertEquals(dModalPrice,dPrice);
        // Verifying the Price is displayed 
     	Assert.assertTrue(shoppingCartPage.isDisplayedAddToListButton());
        // Verifying the Price is displayed 
     	Assert.assertTrue(shoppingCartPage.isDisplayedAddToQuote());
        // Verifying the Price is displayed 
     	Assert.assertTrue(shoppingCartPage.isDisplayedRemoveButton());
        // Verifying the Price is displayed 
     	Assert.assertTrue(shoppingCartPage.isDisplayedCheckOutButton());
     	// Clicking on the Checkout Button
     	shoppingCartPage.clickShoppingCartCheckOutButton();
     	WaitTool.hardWait();
     	// Verifying the Add Payment and Checkout
     	Assert.assertTrue(shoppingCartPage.getShoppingCartPaymentText().equalsIgnoreCase("Add payment and checkout"));
     	// Clicking on the Secure To Order Button
     	shoppingCartPage.clickSecureToOrderButton();
     	WaitTool.hardWait();
     	// Verifying the Order Process
    // 	Assert.assertTrue(shoppingCartPage.getShoppingCartOrderProcessText().equalsIgnoreCase("Generic System Error"));

	}*/

	/**
	 *  Closing the Browser
	 */

	//@AfterMethod
	public void tearDown(){
		driver.quit();
	} 
}
