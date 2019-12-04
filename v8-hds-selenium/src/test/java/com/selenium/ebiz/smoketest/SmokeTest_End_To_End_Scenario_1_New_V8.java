package com.selenium.ebiz.smoketest;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class SmokeTest_End_To_End_Scenario_1_New_V8 extends BaseClassV8_Parallel {

	   public String newListName="List_";
	    private ArrayList<UsersListBean> usersList;


	    @Test(priority = 0, description="Login")
	    public void testLogin() throws Exception {
	      //  username = RandomAccountSelect.users.pop();
	      //  pageManager.commonLogin().navigateToShopAllFromPopUpWindow();
	        LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
	        Assert.assertTrue(pageManager.loginPage().loggedAccountNumberText.isDisplayed());

	    }

	    /**
	     * This test is used to verify end to end happy path after any deployment.
	     * This test solve the purpose of smoke test
	     */

	    @Test(priority = 1, description="Check if Cart is Empty")
	    public void testClearCart() throws Exception{

	        pageManager.shoppingCartPage().checkClearShoppingCart();
	        Log.info("Shopping cart was checked and cleared");
	    }

	   /* @Test(priority = 2, description="Verify Rich Relevance Through Item Search")
	    public void test_VerifyRichRelevanceThroughItemSearch(){
	        pageManager.homePage().searchByKeywordOrPartNumber("bulbs");
	        pageManager.productListingPage().isGridViewDisplayed();
	        Assert.assertTrue(pageManager.productListingPage().isDisplayedRichRelevanceThroughSearch());
	    }

	    @Test(priority = 3, description="Verify Rich Relevance Through Category Search")
	    public void test_VerifyRichRelevanceThroughCategorySearch(){
	        pageManager.homePage().searchByKeywordOrPartNumber("electrical");
	        pageManager.categoryElectricalPage().electricalCategoryTitleIsDisplayed();
	        Assert.assertTrue(pageManager.productListingPage().isRichRelevanceDisplayed());
	    }

	    @Test(priority = 4, description = "PeachTree Customize item")
	    public void test_PeachTreeCustomizeItem() throws Exception {

	        pageManager.shoppingCartPage().clickOnQuickOrderLink();
	        usersList=pageManager.dBCon().loadDataFromExcel("addPeachtreeProductsUsingQuickOrder", "QuickOrder");
	        Log.info(usersList.get(0).getPartNumber1() +"__"+ usersList.get(0).getQuantity1());
	        pageManager.quickOrderPad().fillFirstPartNumberTextBox(usersList.get(0).getPartNumber1());
	        pageManager.quickOrderPad().fillFirstQuantityTextBox(usersList.get(0).getQuantity1());

	        pageManager.quickOrderPad().clickonFirstAddToCartbtn();
	        pageManager.shoppingCartPage().isCustomizeThisItemLinkDisplayed();
	        pageManager.shoppingCartPage().clickOnCustomizeThisItemLink();
	        pageManager.customizeConfigModal().customizeWithPeachTreeProduct();

	        Assert.assertTrue(pageManager.shoppingCartPage().isYouHaveCustomizeLinkDisplayed());
	    }
	*/

	    @Test(priority = 5, description="Search by Product Number")
	    public void test_searchByProductNumber() throws Exception{
	        usersList=pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
	        Log.info(usersList.get(0).getSearchProductPartNumber());
	        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
	      //  softAssert.assertAll();
	    }

		@Test(priority = 6, description="Add Product to Cart from PDP")
		public void test_AddProductFromPDP() throws Exception{
	        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
			pageManager.productDetailsPage().addToCartPDP();
			//pageManager.homePage().clickOnShoppingCartIcon();
			//Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(usersList.get(0).getSearchProductPartNumber()));
		}

	    @Test(priority = 7, description="Search by Product Description")
	    public void test_SearchByProductDesc() throws Exception{
	        usersList=pageManager.dBCon().loadDataFromExcel("searchByProductDesc","Search");
	        Log.info(usersList.get(0).getSearchProductKeyword());
	        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
	      //  softAssert.assertAll();
	    }

	    @Test(priority = 8, description="Add Product to Cart from PLP")
	    public void test_AddProductFromPLP() throws Exception{
	        pageManager.productListingPage().clickonFirstProductAddToCart();
	        pageManager.homePage().clickOnShoppingCartIcon();
	    }

	    @Test(priority = 10, description="Quick Order from SC page")
	    public void test_quickOrderFromShoppingCart() throws Exception {

	       usersList= pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
	       pageManager.shoppingCartPage().clickOnQuickOrderLink();

	       pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(),usersList.get(0).getQuantity1());
	       Log.info(usersList.get(0).getPartNumber1());
	       pageManager.quickOrderPad().clickOnAddToCartButton();
	       Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(usersList.get(0).getPartNumber1()));
	    }
	    /*
	    @Test(priority = 11, description="Add to Saved List from SC Page")
	    public void test_addToSavedListFromShoppingCart() throws Exception{
	       // pageManager.shoppingCartPage().clickCreateOrEditSavedList();
	        pageManager.quickOrderPad().clickAddTolist();
	      //  pageManager.shoppingCartPage().isAddToExistingOrCreateNewListTitleTextDisplayed();
	        Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedExistingOrNewTabsOnAddToListModal());
	    }

	    @Test(priority = 12, description="Creating New Saved List")
	    public void test_createNewSavedList(){
	        pageManager.addToExistingORCreateNewList_modal().createNewListInAddToListModal();
	    }

	    @Test(priority = 13, description="Validate Print Bin Labels")
	    public void test_validatePrintBinLabels() throws Exception{
	        pageManager.savedListsPage().clickOnNewlyCreatedList();
	        pageManager.savedListsPage().clickOnPrintBinLabelsLink();
	        Assert.assertTrue(pageManager.savedListsPage().isContactNumberOnBinLabelDisplayed());
	        Assert.assertTrue(pageManager.savedListsPage().isProductDescriptionOnBinLabelDisplayed());
	        Assert.assertTrue(pageManager.savedListsPage().isHDSPartTextOnBinLabelDisplayed());
	    }

	    @Test(priority = 14, description="Click Cart Icon")
	    public void test_navigateToShoppingCart() throws Exception{
	        pageManager.savedListsPage().navigateBackToMainWindowFromPrintLabel();
	        pageManager.homePage().clickOnShoppingCartIcon();
	    }

	*/
	    @Test(priority = 15, description="Add Payment and Checkout Page")
	    public void test_VerifyValuesOnPaymentAndCheckoutPage() throws Exception{
	        pageManager.shoppingCartPage().clickonCheckOutButton();
	        Log.info("Click Checkout btn on SC page");
	        pageManager.paymentAndCheckOutPage().isPageTitleDisplayed();
	        Log.info("Wait for Payment and Checkout page");
	        pageManager.paymentAndCheckOutPage().VerifyPNAValuesIsDisplayed();

	        //softAssert.assertAll();
	    }
	    @Test(priority = 16, description="Place web order")
	    public void test_placeWebOrder() throws Exception{
	        pageManager.paymentAndCheckOutPage().insertPONumber();
	        Log.info("*******Inserted PO number**********");
	        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
	        Log.info("Click submit secure order");
	        //softAssert.assertAll();

	    }

	    @Test(priority = 17, description="Capture Web Order Number",enabled=false)
	    public void test_ValidateWebOrderNumber(){
	        String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
	        Log.info("orderNumber is "+ orderNumber);
	        Assert.assertTrue(pageManager.orderConfirmationPage().orderNumber.isDisplayed());

	    }

}
