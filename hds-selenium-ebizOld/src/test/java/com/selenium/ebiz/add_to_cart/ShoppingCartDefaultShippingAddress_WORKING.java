package com.selenium.ebiz.add_to_cart;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MinicartPage;
import com.selenium.ebiz.pageobject.MyAccountPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.ProductPage;
import com.selenium.ebiz.pageobject.SearchResultPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.tools.WaitTool;

public class ShoppingCartDefaultShippingAddress_WORKING extends BaseClass {

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	SearchResultPage searchResultPage;
	ProductDetailsPage productDetailsPage;
	MinicartPage miniCartPage;
	ArrayList<WebElement>shoppingCartListItems;
	ShoppingCartPage shoppingCartPage;
	ProductPage productPage;
	ProductListingPage productListingPage;
	DBCon dbConnection = new DBCon();
	ArrayList<UsersListBean> usersList;


	@BeforeMethod	
	public void driverSetup() throws Exception {
		driver = initialize();		
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

	}

	/**
	 *@storyDescription :  To verify As a user I want my default shipping address to appear on the Shopping Cart page
	 *@US :US-Ord-205
	 *@author Lakshmi
	 * */

	@Test
	public void verifyShoppingCartDefaultShippingAddress() throws Exception {		
		usersList = dbConnection.loadDataFromExcel("verifyMyAccountsPageLinks","MyAccount");
		/*usersList = dbConnection.loadDataFromExcel("verifyBreadCrumbForCurrentPageUnautheticateduser","Categories");
			homePage.clickHeaderShopByCategoryLinkText();
			WaitTool.hardWait();
			productListingPage = homePage.clickonCategoriesToreachProductList(driver, usersList.get(0).getCategory(),usersList.get(0).getL1SubCategory(),usersList.get(0).getL2SubCategory());
			Assert.assertTrue(productPage.verifyProductsDisplayed());
			productDetailsPage = productPage.clickFirstProductInProductList();
			//verify if user is able to select a product and product details page is displayed.
			Assert.assertTrue(productDetailsPage.isDisplayedproductDetailsHeader());
			productDetailsPage.clickAddToCartButton();
			WaitTool.hardWait();
			homePage =productDetailsPage.clickcloseAddtocartSuccessPopup();
			WaitTool.hardWait();
			homePage.clickHeaderMyCartLinkTextAfterAddTocart();
			shoppingCartPage = homePage.clickHeaderMyCartLinkText();*/


		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		WaitTool.hardWait();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		} else {
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCartReturnsHomePage();
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		}
		WaitTool.hardWait();
		productListingPage = homePage.moveToSubCategoryPage();
		productDetailsPage = productListingPage.clickOnFirstProduct();
		productDetailsPage.clickAddToCartButton();
		WaitTool.hardWait();
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
		WaitTool.hardWait();
		productDetailsPage.refreshPage();
		WaitTool.hardWait();
		shoppingCartPage=productDetailsPage.clickOnShoppingCartIcon();
		//Verify that Ship to Address is displayed 
		shoppingCartPage.selectDefaultOptionFromShippingDropdown();
		Assert.assertTrue(shoppingCartPage.isDisplayedShippingAddressText());
		String shippingAddressLine1OnSC = shoppingCartPage.getShippingAddressLine1Text();
		String shippingAddressLine2OnSC = shoppingCartPage.getShippingAddressLine2Text();
		String shippingAddressLine3OnSC = shoppingCartPage.getShippingAddressLine3Text();
		WaitTool.hardWait();
		myAccountPage = homePage.moveToMyAccountPage();
		String shippingAddressLine1OnMA = myAccountPage.getShippingAddressLine1Text();
		String shippingAddressLine2OnMA = myAccountPage.getShippingAddressLine2Text();
		String shippingAddressLine3OnMA = myAccountPage.getShippingAddressLine3Text();
		Assert.assertTrue(shippingAddressLine1OnSC.equals(shippingAddressLine1OnMA));
		Assert.assertTrue(shippingAddressLine2OnSC.equals(shippingAddressLine2OnMA));
		Assert.assertTrue(shippingAddressLine3OnSC.equals(shippingAddressLine3OnMA));
		shoppingCartPage = myAccountPage.clickOnShoppingCartIcon();
		shoppingCartPage.selectNonDefaultOptionFromShippingDropdown();
		WaitTool.hardWait();
		String shippingAddressLine1OnSCForND = shoppingCartPage.getShippingAddressLine1Text();
		String shippingAddressLine2OnSCForND = shoppingCartPage.getShippingAddressLine2Text();
		String shippingAddressLine3OnSCForND = shoppingCartPage.getShippingAddressLine3Text();
		Assert.assertFalse(shippingAddressLine1OnSCForND.equals(shippingAddressLine1OnMA));
		Assert.assertFalse(shippingAddressLine2OnSCForND.equals(shippingAddressLine2OnMA));
		Assert.assertFalse(shippingAddressLine3OnSCForND.equals(shippingAddressLine3OnMA));
		shoppingCartPage.clickOnAddNewAddressLink();
		WaitTool.hardWait();
		Assert.assertTrue(shoppingCartPage.isAddNewAddressModalWindowDisplayed());
		shoppingCartPage.createNewAddress(usersList.get(0).getShippingAddressName(), usersList.get(0).getCompanyOrPropertyName(), usersList.get(0).getAddress(),
				usersList.get(0).getCity(), usersList.get(0).getState(), usersList.get(0).getZipCode(), usersList.get(0).getPhoneNumber());
		WaitTool.hardWait();
		System.out.println(shoppingCartPage.getShippingAddressLine1Text() + "    "+usersList.get(0).getCompanyOrPropertyName() );
		Assert.assertTrue(shoppingCartPage.getShippingAddressLine1Text().equals(usersList.get(0).getCompanyOrPropertyName()));

		myAccountPage=homePage.moveToMyAccountPage();
		myAccountPage.goToAddressBook();	
		myAccountPage.clickOnDeleteButtons();

		/*			//Verify that default Shipping Address is displayed as the default Ship To Address
			System.out.println("actual adress =====================" +addres);
			//Assert.assertTrue(addres.equalsIgnoreCase("default"));
			Assert.assertTrue(shoppingCartPage.isDisplayedShippingToDropDown());
			//Verify that there is a dropdown menu for the user to select a different address from the list of saved addresses
			Assert.assertTrue(shoppingCartPage.selectShippingtoAddressApartfromDefaultaddress());
			WaitTool.hardWait();
			//Verify that Dropdown menu allows user to select a different address from the list of addresses saved 
			String addres1 = shoppingCartPage.getFirstSelectedOptionFromShippingtoDrpDown();
			Assert.assertFalse(addres.equalsIgnoreCase(addres1),"Address have been change after selecting new address");*/
	}

}


