/**
 * 
 *  This is for Smoke Test for Production
 *   
 */

package com.selenium.ebiz.prod_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest_End_To_End_Prod_NewV8 extends BaseClassV8_Parallel {
	
	public String newListName;
	
	/**
	 *  Launching of the Browser and login with Valid Credentials
	 *  Select the Property
	 */

	@Test(priority = 0, description="Login")
	public void testLogin() throws Exception {

		LoginToHDS(configread.getUserName(),configread.getPassword());
		Assert.assertTrue(pageManager.loginPage().loggedAccountNumberText.isDisplayed());

		pageManager.homePage().selectPropertyDropdownForProd_wchoi();
	}

	/**
	 * This test is used to verify end to end happy path after any deployment.
	 * This test solve the purpose of smoke test
	 */
	@Test(priority = 1, description="Cart Empty Confirmation")
	public void testClearCart() throws Exception{
		pageManager.shoppingCartPage().checkClearShoppingCart();
		Log.info("Shopping cart was checked and cleared");
	}


	@Test(priority = 2, description="Search by Product Number")
	public void test_searchByProductNumber() throws Exception{
		GetUserList("searchByKeywordOrPartNumber","Search");
		Log.info(usersList.get(0).getSearchProductPartNumber());
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		//  softAssert.assertAll();
	}

	@Test(priority = 3, description="Add Product to Cart from PDP")
	public void test_AddProductFromPDP() throws Exception{

		pageManager.productDetailsPage().clickAddToCartButton();
	}

	@Test(priority = 4, description="Search by Product Description")
	public void test_SearchByProductDesc() throws Exception{
		GetUserList("searchByProductDesc","Search");
		Log.info(usersList.get(0).getSearchProductKeyword());
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		softAssert.assertAll();
	}

	@Test(priority = 5, description="Add Product to Cart from PLP")
	public void test_AddProductFromPLP() throws Exception{
		pageManager.productListingPage().clickonFirstProductAddToCart();
		//    Assert.assertTrue(pageManager.searchPage().isDisplayedCheckoutButton());
	}

	@Test(priority = 6, description="Click on Shopping Cart PLP")
	public void test_clickOnShoppingCartIcon() throws Exception{
		pageManager.homePage().clickOnShoppingCartIcon();

	}

	@Test(priority = 7, description="Quick Order from SC page")
	public void test_quickOrderFromShoppingCart() throws Exception {

		GetUserList("addProductsUsingQuickOrder", "QuickOrder");
		pageManager.shoppingCartPage().clickOnQuickOrderLink();
		pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad();
		Log.info("usersList getPartNumber1: " + usersList.get(0).getPartNumber1() + " usersList getQuantity1: " + usersList.get(0).getQuantity1());
		pageManager.quickOrderPad().fillFirstPartNumberTextBox(usersList.get(0).getPartNumber1());
		pageManager.quickOrderPad().fillFirstQuantityTextBox(usersList.get(0).getQuantity1());

		String firstPartNumberTextBoxValue = pageManager.quickOrderPad().firstPartNumberTextBoxFilledValue();
		String firstQuantityrTextBoxValue = pageManager.quickOrderPad().firstQuantityTextBoxFilledValue();
		Log.info("firstPartNumberTextBoxValue is:_ " + firstPartNumberTextBoxValue + "firstQuantityrTextBoxValue is:_ " + firstQuantityrTextBoxValue);
		Assert.assertEquals(usersList.get(0).getPartNumber1(), firstPartNumberTextBoxValue);
		Assert.assertEquals(usersList.get(0).getQuantity1(), firstQuantityrTextBoxValue);

	}

	@Test(priority = 8)
	public void test_VerifyisDeliveryMessageDisplayed() throws Exception
	{
		pageManager.quickOrderPad().clickOnAddToCartButton();
		pageManager.shoppingCartPage().selectDefaultOptionFromShippingDropdown();
		if ( environmentValue.equals("dev1")||environmentValue.equals("dev2")||environmentValue.equals("dev3")||environmentValue.equals("prod")){
			Log.info("No Delivery message  ");
		}
		else{
			Assert.assertTrue(pageManager.shoppingCartPage().isDeliveryMessageDisplayed(), "Verify is Delivery message dispayed");
			//softAssert.assertAll();
		}
	}

	@Test(priority = 9, description="Add to Saved List from SC Page")
	public void test_addToSavedListFromShoppingCart() throws Exception{
		pageManager.shoppingCartPage().clickCreateOrEditSavedList();
		pageManager.shoppingCartPage().isAddToExistingOrCreateNewListTitleTextDisplayed();
		Assert.assertTrue(pageManager.shoppingCartPage().addToListExistingTab.isDisplayed());
	}

	@Test(priority = 10, description="Creating New Saved List")
	public void test_createNewSavedList(){
		String newlistcreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		pageManager.savedListsPage().recentlyUpdatedLink.click();
		String newlistdisplayed = pageManager.savedListsPage().getNewlyCreatedList();
		Log.info("Newlistdisplayed is: "+ newlistdisplayed + "  "+ "Newlistcreated is "+ newlistcreated);
		Assert.assertEquals(newlistcreated, newlistdisplayed);
	}

	@Test(priority = 11, description="Validate Print Bin Labels")
	public void test_validatePrintBinLabels() throws Exception{
		pageManager.savedListsPage().clickOnNewlyCreatedList();
		pageManager.savedListsPage().clickOnPrintBinLabelsLink();
		// pageManager.common().moveToNewWindow(driver);
		// .moveToNewWindow(driver);
		//pageManager.savedListsPage().VerifyPrintLabelsAreDisplayed();
        /*
        Assert.assertTrue(pageManager.savedListsPage().isContactNumberOnBinLabelDisplayed());
        Assert.assertTrue(pageManager.savedListsPage().isProductDescriptionOnBinLabelDisplayed());
        Assert.assertTrue(pageManager.savedListsPage().isHDSPartTextOnBinLabelDisplayed());
*/
	}

	@Test(priority = 12, description="Click Cart Icon")
	public void test_navigateToShoppingCart() throws Exception{
		pageManager.savedListsPage().navigateBackToMainWindowFromPrintLabel();
		pageManager.homePage().clickOnShoppingCartIcon();
	}

	@Test(priority = 13, description="Add Payment and Checkout Page")
	public void test_addPaymentAndCheckoutPage() throws Exception{
		pageManager.shoppingCartPage().clickonCheckOutButton();
		Log.info("Click Checkout btn on SC page");
		pageManager.paymentAndCheckOutPage().isPageTitleDisplayed();
		Log.info("Wait for Payment and Checkout page");
		pageManager.paymentAndCheckOutPage().VerifyPNAValuesIsDisplayed();

		//softAssert.assertAll();
	}

	@Test(priority = 14, description="Place web order")
	public void test_placeWebOrder() throws Exception{
		pageManager.paymentAndCheckOutPage().insertPONumber();
		Log.info("*******Inserted PO number**********");
		pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
		Log.info("Click submit secure order");
		//softAssert.assertAll();

	}

	@Test(priority = 15, description="Capture Web Order Number",enabled=false)
	public void test_ValidateWebOrderNumber(){
		String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
		Log.info("orderNumber is "+ orderNumber);
		Assert.assertTrue(pageManager.orderConfirmationPage().orderNumber.isDisplayed());

	}


}