package com.selenium.ebiz.add_to_cart.old_add_to_cart_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MergeProductsAfterLogin_NOTWORKING extends BaseClassV8_Parallel {
	/*
	* modified by Iuliia
	* 12/17/2018
	*/
	private String username;

	public String newListName;

	/*
	 * Login with Valid Credentials
	 */

	@Test
	public void test_Login(){
		username = RandomAccountSelect.users.pop();

		LoginToHDS(username,configread.getPassword());


	}


	@Test(priority = 1, description="Cart Empty Confirmation")
	public void testClearCart() throws Exception{
		pageManager.shoppingCartPage().checkClearShoppingCart();
		Log.info("Check and clear Shopping cart");

	}
	/**
	 *  104794 - Verify Merge Cart for Existing User Login from Header PeachTree Part
	 104789 - Verify Migrate Cart with Peach Tree Part for Existing User Login from Header
	 */

	@Test(priority = 2)
	public void test_verifyMergeCartForPeachTreePartForExistingUserLogInFromHeader() throws Exception{
		pageManager.homePage().moveToSubCategoryPage();
		pageManager.productListingPage().clickonFirstProductAddToCart();
	//	productListingPage.clickonFirstProductAddToCart();
		int counter = pageManager.common().counterIncrease();
		Log.info("First counter is "+ counter);
		pageManager.productListingPage().clickOnCloseAddtocartSuccessPopup();
		driver.navigate().refresh();
		pageManager.productListingPage().addToCartAndNavigateToSCP(1);
		counter = pageManager.common().counterIncrease();
		Log.info("Second counter is "+ counter);
		pageManager.productListingPage().clickOnCloseAddtocartSuccessPopup();
		driver.navigate().refresh();
		//first peachtree product added to cart
		GetUserList("searchByFirstPeachTreePartNumber","Search");
		//usersList = dbConnection.loadDataFromExcel("searchByFirstPeachTreePartNumber","Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
	//	pageManager.searchPage().clickOnProduct();
		//productDetailsPage = homePage.searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		//	Assert.assertTrue(productDetailsPage.isPeachTreedTextIdisplayed());
		pageManager.productDetailsPage().clickAddToCartButton();
		counter = pageManager.common().counterIncrease();
		Log.info("Third counter is "+counter);
		pageManager.productDetailsPage().clickOnCloseAddtocartSuccessPopup();
		driver.navigate().refresh();

		pageManager.homePage().shoppingCartIcon.click();
		Log.info("shoppingCartPage.displyedPartNumberText()  " + pageManager.shoppingCartPage().displyedPartNumberText());
		pageManager.homePage().clickOnHDSupplyLogoInHeader();

		pageManager.homePage().clickOnSignOutIcon();
		Log.info("Logout");
		//usersList = dbConnection.loadDataFromExcel("searchByKeywordOrPartNumber","Search");

		String pnumber = usersList.get(0).getSearchProductPartNumber();
		Log.info("usersList.get(0).getSearchProductPartNumber():"+ usersList.get(0).getSearchProductPartNumber());
		/*searchPage = loginPage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage = searchPage.clickOnProduct();*/
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Log.info("search Keyword Or Part Number");

	//	driver.navigate().refresh();

	//	.scrolltoViewElement(pageManager.productDetailsPage().addToCartButton,driver);

//TODO unable to scroll into clickAddToCartButton
		pageManager.productListingPage().clickonFirstProductAddToCart();
	//	pageManager.productDetailsPage().addToCartButton.click();
		Log.info("Click add to cart btn on the product detail page");

		counter = pageManager.common().counterIncrease();
		Log.info("counter is " + counter);

		pageManager.productDetailsPage().clickOnCloseAddtocartSuccessPopup();
		driver.navigate().refresh();

		pageManager.homePage().clickOnShoppingCartIcon();
		Log.info("shoppingCartPage.displyedPartNumberText()" +    pageManager.shoppingCartPage().displyedPartNumberText());
		/*Assert.assertFalse(shoppingCartPage.isDisplayedShippingAddressText());
		Assert.assertFalse(shoppingCartPage.isDisplayedSourceCode());*/
		pageManager.homePage().clickOnHDSupplyLogoInHeader();

		pageManager.loginPage().loginToHDS_V8(username,configread.getPassword());
		waitTool.waitForElement(driver,pageManager.loginPage().loggedAccountNumberText);

		//homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"),prop.getProperty("password"));
		pageManager.homePage().shoppingCartIcon.click();
		Log.info("shoppingCartPage.displyedPartNumberText()" + pageManager.shoppingCartPage().displyedPartNumberText());

		Assert.assertEquals(pageManager.shoppingCartPage().displyedPartNumberText(), counter);
		pageManager.shoppingCartPage().clickShoppingCartCheckOutButton();
		pageManager.paymentAndCheckOutPage().insertPONumber();
		pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
		/*String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
		Log.info("orderNumber is "+ orderNumber);*/
	}
/*
	@Test(priority = 3, description="Cart Empty Confirmation")
	public void test_ClearCart() throws Exception{
		pageManager.homePage().clickOnShoppingCartIcon();
		try{
			pageManager.shoppingCartPage().shoppingCartEmptyMessage.isDisplayed();
			Log.info("Cart is Empty :"+ pageManager.shoppingCartPage().shoppingCartEmptyMessage.getText());
			pageManager.homePage().clickOnHDSupplyLogoInHeader();
		} catch (Exception e){

			pageManager.shoppingCartPage().clearShoppingCart();
			pageManager.homePage().hDSupplyLogoInHeader.click();
		}

	}

	/**
	 * 104791 - Verify Merge Cart for Existing User Login from Login Modal PeachTree Part

	@Test(priority=4)
	public void test_verifyMergeCartForPeachTreePartForExistingUserLogInFromLoginModal() throws Exception
	{
	/*	homePage.shoppingCartIcon.click();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			homePage.clickOnHDSupplyLogoInHeader();
		} 
		else 
		{
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCart();
			homePage.clickOnHDSupplyLogoInHeader();
		}
		*/
	/*	pageManager.homePage().moveToSubCategoryPage();
		pageManager.productListingPage().clickonFirstProductAddToCart();
		int counter = .counterIncrease();
		Log.info("counter is "+counter);
		pageManager.productListingPage().clickOnCloseAddtocartSuccessPopup();
		pageManager.productListingPage().refreshPage();
		pageManager.productListingPage().addToCartAndNavigateToSCP();
		counter = .counterIncrease();
		Log.info("counter is "+counter);
		pageManager.productListingPage().clickOnCloseAddtocartSuccessPopup();
		driver.navigate().refresh();

		//Adding first peachtree part to the cart
		GetUserList("searchByFirstPeachTreePartNumber","Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.searchPage().clickOnProduct();
		//productDetailsPage = homePage.searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		//	Assert.assertTrue(productDetailsPage.isPeachTreedTextIdisplayed());
		pageManager.productDetailsPage().clickAddToCartButton();
		counter = .counterIncrease();
		Log.info("counter is "+counter);
		pageManager.productDetailsPage().clickOnCloseAddtocartSuccessPopup();
		pageManager.productDetailsPage().refreshPage();
		pageManager.homePage().shoppingCartIcon.click();
		Log.info("shoppingCartPage.displyedPartNumberText()" +    pageManager.shoppingCartPage().displyedPartNumberText());
		pageManager.homePage().clickOnHDSupplyLogoInHeader();
		pageManager.homePage().clickOnSignOutIcon();
		Log.info("Logout");
		GetUserList("searchByKeywordOrPartNumber","Search");
		System.out.println("usersList.get(0).getSearchProductPartNumber()"+usersList.get(0).getSearchProductPartNumber());
		String pnumber = usersList.get(0).getSearchProductPartNumber();
		//searchPage = loginPage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		//productDetailsPage = searchPage.clickOnProduct();
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().clickAddToCartButton();
		counter = .counterIncrease();
		Log.info("counter is "+counter);
		pageManager.productDetailsPage().clickOnCloseAddtocartSuccessPopup();
		pageManager.productDetailsPage().refreshPage();
		pageManager.homePage().clickShoppingCartIcon();
		Log.info("shoppingCartPage.displyedPartNumberText()"+pageManager.shoppingCartPage().displyedPartNumberText());
		Assert.assertFalse(pageManager.shoppingCartPage().isDisplayedShippingAddressText());
		Assert.assertFalse(pageManager.shoppingCartPage().isDisplayedSourceCode());
		pageManager.homePage().clickOnHDSupplyLogoInHeader();


		//Adding second peachtree part to the cart
		GetUserList("searchBySecondPeachTreePartNumber","Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.searchPage().clickOnProduct();
		//productDetailsPage = loginPage.searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		//	Assert.assertTrue(productDetailsPage.isPeachTreedTextIdisplayed());
		pageManager.productDetailsPage().clickAddToCartButton();
		counter = .counterIncrease();
		Log.info("counter is "+counter);
		pageManager.productDetailsPage().clickOnCloseAddtocartSuccessPopup();
		driver.navigate().refresh();
		pageManager.productDetailsPage().clickOnShoppingCartIcon();
		Log.info("shoppingCartPage.displyedPartNumberText()"+ pageManager.shoppingCartPage().displyedPartNumberText());
		pageManager.shoppingCartPage().clickShoppingCartCheckOutButtonAsGuestUser();
		pageManager.signInOrRegisterPage().enterUserName(username);
		Log.info("Enter user name on signin form");
		pageManager.signInOrRegisterPage().enterPassword(configread.getPassword());
		Log.info("Enter password on signin form");
		pageManager.signInOrRegisterPage().clickSignInButton();
		Log.info("Click signin btn");
		waitTool.waitForElement(driver,pageManager.loginPage().loggedAccountNumberText);

		Log.info("shoppingCartPage.displyedPartNumberText() "+ pageManager.shoppingCartPage().displyedPartNumberText());
		Log.info("counter is "+counter);
		Assert.assertEquals(pageManager.shoppingCartPage().displyedPartNumberText(), counter);
		pageManager.shoppingCartPage().clickShoppingCartCheckOutButton();
		pageManager.paymentAndCheckOutPage().insertPONumber();
		pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
		String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
		Log.info("orderNumber is "+ orderNumber);
	}

	@Test(priority = 5, description="Cart Empty Confirmation")
	public void test_ClearCart3() throws Exception{
		pageManager.homePage().clickOnShoppingCartIcon();
		try{
			pageManager.shoppingCartPage().shoppingCartEmptyMessage.isDisplayed();
			Log.info("Cart is Empty :"+ pageManager.shoppingCartPage().shoppingCartEmptyMessage.getText());
			pageManager.homePage().clickOnHDSupplyLogoInHeader();
		} catch (Exception e){

			pageManager.shoppingCartPage().clearShoppingCart();
			pageManager.homePage().hDSupplyLogoInHeader.click();
		}

	}


	/**
	 * 103940 - Verify Merge Cart for Existing User Login from Login Modal

	@Test(priority=6)
	public void test_verifyMergeCartForExistingUserLogInFromLoginModal() throws Exception
	{

	/*	homePage.shoppingCartIcon.click();
		//waitTool.hardWait();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			homePage.clickOnHDSupplyLogoInHeader();
		} 
		else 
		{
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCart();
			homePage.clickOnHDSupplyLogoInHeader();
		}
		*/

/*		//waitTool.hardWait();
		pageManager.homePage().moveToSubCategoryPage();
		pageManager.productListingPage().clickonFirstProductAddToCart();
		int counter = .counterIncrease();
		Log.info("counter is "+counter);
		pageManager.productListingPage().clickOnCloseAddtocartSuccessPopup();
		driver.navigate().refresh();
		pageManager.homePage().clickOnSignOutIcon();
		Log.info("Logout");
		GetUserList("searchByKeywordOrPartNumber","Search");
		Log.info("usersList.get(0).getSearchProductPartNumber()"+usersList.get(0).getSearchProductPartNumber());
		String pnumber = usersList.get(0).getSearchProductPartNumber();
		//searchPage = loginPage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		//productDetailsPage = searchPage.clickOnProduct();
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().clickAddToCartButton();
		counter = .counterIncrease();
		Log.info("counter is "+counter);
		pageManager.productDetailsPage().clickOnCloseAddtocartSuccessPopup();
		pageManager.productDetailsPage().refreshPage();
		pageManager.homePage().clickShoppingCartIcon();

		pageManager.shoppingCartPage().clickShoppingCartCheckOutButtonAsGuestUser();
		pageManager.signInOrRegisterPage().enterUserName(username);
		Log.info("Enter user name on signin form");
		pageManager.signInOrRegisterPage().enterPassword(configread.getPassword());
		Log.info("Enter password on signin form");
		pageManager.signInOrRegisterPage().clickSignInButton();
		Log.info("Click signin btn");
		waitTool.waitForElement(driver,pageManager.loginPage().loggedAccountNumberText);
		Assert.assertEquals(pageManager.shoppingCartPage().displyedPartNumberText(), counter);
		pageManager.shoppingCartPage().clickShoppingCartCheckOutButton();
		pageManager.paymentAndCheckOutPage().insertPONumber();

		pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
		String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
		Log.info("orderNumber is "+ orderNumber);

	}
*/

}
