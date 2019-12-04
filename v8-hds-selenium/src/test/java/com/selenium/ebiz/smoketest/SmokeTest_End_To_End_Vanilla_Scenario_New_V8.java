/**
 *
 * @author Bhavani
 * 
 *  FMQA-2051 Smoke Test e2e Vanilla Scenario
 *  
 */

package com.selenium.ebiz.smoketest;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SmokeTest_End_To_End_Vanilla_Scenario_New_V8 extends BaseClassV8_Parallel {

	public String newListName="List_";
	public String newlistcreated, subtotalValue, shippingValue;
	int productAddedToCart,displayedShoppingCartProductCount;

	@Test(priority = 0, description="Login")
	public void testLogin(){
		LoginToHDS(configread.getUserName(),configread.getPassword());
		Assert.assertTrue(pageManager.loginPage().loggedAccountNumberText.isDisplayed());

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
		GetUserList("searchByProductNumber","Search");
		Log.info(usersList.get(0).getSearchProductPartNumber());
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Assert.assertTrue(pageManager.productDetailsPage().productDetailsModuleTitle.isDisplayed());
	}

	@Test(priority = 3, description="Add Product to Cart from PDP")
	public void test_AddProductFromPDP() throws Exception{

		pageManager.productDetailsPage().clickAddToCartButton();

	}

	@Test(priority = 4, description="Search by Product Description")
	public void test_SearchByProductDesc() throws Exception{
		GetUserList("searchByProdDesc","Search");
		Log.info(usersList.get(0).getSearchProductKeyword());
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
	}

	@Test(priority = 5, description="Add Product to Cart from PLP")
	public void test_AddProductFromPLP() throws Exception{
		pageManager.productListingPage().clickonFirstProductAddToCart();
	}

	@Test(priority = 6, description="Click on Shopping Cart PLP")
	public void test_clickOnShoppingCartIcon(){
		pageManager.homePage().shoppingCartIcon.click();
		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShippingToDropDown());
	}

	@Test(priority = 7, description="Quick Order from SC page")
	public void test_quickOrderFromShoppingCart() throws Exception {

		pageManager.shoppingCartPage().clickOnQuickOrderLink();
		GetUserList("addFDProduct", "QuickOrder");
		Log.info("usersList getPartNumber1: " + usersList.get(0).getPartNumber1() + " usersList getQuantity1: " + usersList.get(0).getQuantity1());
		pageManager.quickOrderPad().fillFirstPartNumberTextBox(usersList.get(0).getPartNumber1());
		pageManager.quickOrderPad().fillFirstQuantityTextBox(usersList.get(0).getQuantity1());

		String firstPartNumberTextBoxValue = pageManager.quickOrderPad().firstPartNumberTextBoxFilledValue();
		String firstQuantityrTextBoxValue = pageManager.quickOrderPad().firstQuantityTextBoxFilledValue();
		Log.info("firstPartNumberTextBoxValue is:_ " + firstPartNumberTextBoxValue +"   "+ "firstQuantityrTextBoxValue is:_ " + firstQuantityrTextBoxValue);
		Assert.assertEquals(usersList.get(0).getPartNumber1(), firstPartNumberTextBoxValue);
		Assert.assertEquals(usersList.get(0).getQuantity1(), firstQuantityrTextBoxValue);
		// pageManager.quickOrderPad().clickonFirstAddToCartbtn();
	}

	@Test(priority = 8, description="Verify Is FD Message Displayed")
	public void test_VerifyisFDMessageDisplayed() throws Exception
	{
		pageManager.quickOrderPad().clickOnAddToCartButton();
		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedProductFDMessage());

	}

	@Test(priority = 9, description="Add to Saved List from SC Page")
	public void test_addToSavedListFromShoppingCart() throws Exception{
		pageManager.shoppingCartPage().clickCreateOrEditSavedList();
		pageManager.shoppingCartPage().isAddToExistingOrCreateNewListTitleTextDisplayed();
		Assert.assertTrue(pageManager.shoppingCartPage().addToListExistingTab.isDisplayed());
	}

	@Test(priority = 10, description="Create New Saved List")
	public void test_createNewSavedList() throws Exception{
		newlistcreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		Assert.assertTrue(pageManager.savedListsPage().isDisplayedSavedListspageHeadingText());
	}

	@Test(priority = 11, description="Validate New List Dispalyed")
	public void test_validateNewListDispalyed() throws Exception{
		pageManager.savedListsPage().recentlyUpdatedLink.click();
		String newlistdisplayed = pageManager.savedListsPage().getNewlyCreatedList();
		Log.info("Newlistdisplayed is: "+ newlistdisplayed + "  "+ "Newlistcreated is "+ newlistcreated);
		Assert.assertEquals(newlistcreated, newlistdisplayed);

	}

	@Test(priority = 12, description="Validate Print Bin Labels")
	public void test_validatePrintBinLabels() throws Exception{
		pageManager.savedListsPage().clickOnNewlyCreatedList();
		pageManager.savedListsPage().clickOnPrintBinLabelsLink();
		//.moveToNewWindow(driver);
		//pageManager.savedListsPage().VerifyPrintLabelsAreDisplayed();

		Assert.assertTrue(pageManager.savedListsPage().isContactNumberOnBinLabelDisplayed());
		Assert.assertTrue(pageManager.savedListsPage().isProductDescriptionOnBinLabelDisplayed());
		Assert.assertTrue(pageManager.savedListsPage().isHDSPartTextOnBinLabelDisplayed());

	}

	@Test(priority = 13, description="Click Cart Icon On Closing PDF")
	public void test_navigateToShoppingCart() throws Exception{
		pageManager.savedListsPage().navigateBackToMainWindowFromPrintLabel();
		pageManager.homePage().clickOnShoppingCartIcon();
		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
	}

	@Test(priority = 14, description="Capture PNA Values On SCP")
	public void test_capturePNAValuesOnSCP() throws Exception{
		//.scrolltoViewElement(pageManager.shoppingCartPage().displayedSubtotalValue,driver);
		subtotalValue = pageManager.shoppingCartPage().displayedSubtotalValue();
		shippingValue = pageManager.shoppingCartPage().displayedShippingValue();
		Log.info("SubtotalValue: " + subtotalValue);
		Log.info("ShippingValue: "+ shippingValue);
		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedCheckoutButton());
	}


	@Test(priority = 15, description="Add Payment and Checkout Page")
	public void test_addPaymentAndCheckoutPage() throws Exception{
		pageManager.shoppingCartPage().clickonCheckOutButton();
		Log.info("Click Checkout btn on SC page");
		pageManager.paymentAndCheckOutPage().isPageTitleDisplayed();
		Log.info("Wait for Payment and Checkout page");
		Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedAddPaymentAndCheckoutTitle());
	}

	@Test(priority = 16, description="Add Payment and Checkout Page")
	public void test_verifyPNAValuesOnPaymentAndCheckoutPage() throws Exception{
		Log.info("PNA Values :");	
		pageManager.paymentAndCheckOutPage().VerifyPNAValuesIsDisplayed();
		Assert.assertEquals(pageManager.paymentAndCheckOutPage().displayedSubtotalValue(), subtotalValue);
		Assert.assertEquals(pageManager.paymentAndCheckOutPage().displayShippingValuealValue(), shippingValue);
	}


	@Test(priority = 17, description="Place web order")
	public void test_placeWebOrder() throws Exception{
		pageManager.paymentAndCheckOutPage().insertPONumber();
		Log.info("*******Inserted PO number**********");
		pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
		Log.info("Clicked submit secure order button");
		Assert.assertTrue(pageManager.orderConfirmationPage().isDisplayedOrderConfirmationPageTitle());

	}

	@Test(priority = 18, description="Capture Web Order Number",enabled=false)
	public void test_ValidateWebOrderNumber(){
		String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
		Log.info("orderNumber is "+ orderNumber);
		Assert.assertTrue(pageManager.orderConfirmationPage().orderNumber.isDisplayed());

	}


}
