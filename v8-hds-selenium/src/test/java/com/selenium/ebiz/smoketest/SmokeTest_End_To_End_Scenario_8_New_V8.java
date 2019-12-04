/**
 * 
 *  This is for Smoke Test
 *   
 */

package com.selenium.ebiz.smoketest;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest_End_To_End_Scenario_8_New_V8 extends BaseClassV8_Parallel{
	String displayedPnumber;
	String displayedQuantity;
	String displayedQuantityOnPopup;
	String displayedPnumberOnPopup;
	String newlistCreated;
	String newlistDisplayed;

	/**
	 *  Launching of the Browser and login with Valid Credentials
	 *  Select the Property
	 */
	@Test(priority = 0, description="Login To Application")
	public void testLogin() throws Exception {
		LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
	}

	@Test(priority = 1, description="Navigate to Frequently Purchased Page")
	public void navigateToFrequentlyPurchasedPage() throws Exception
	{		
		pageManager.homePage().clickFrePurchasedUtilityBar();
	}

	@Test(priority = 2, description="Select One Item From Frequently Purchased Page")
	public void clickOnFirstProdut() throws Exception
	{		
		pageManager.frequentlyPurchasedPage().clickOnFirstProductDisplayed();
	}


	@Test(priority = 3, description="Fetch Part Number And Quantity")
	public void getPartNumberAndQuantityDisplayed() throws Exception
	{		
		displayedPnumber = pageManager.productDetailsPage().getDisplayedPartNumber();
		displayedQuantity = pageManager.productDetailsPage().getDisplayedQuantity();
		System.out.println("displayedpnumber is "+ displayedPnumber + "displayedQuantity"+ displayedQuantity);
	}

	@Test(priority = 4, description="Add Product To Cart")
	public void clickOnAddToCart() throws Exception
	{		
		pageManager.productDetailsPage().clickAddToCartButton();
	}

/*	@Test(priority = 5, description="Verify Part Number And Quantity")
	public void verifyPartNumberAndQuantity() throws Exception
	{		
		displayedPnumberOnPopup = pageManager.productDetailsPage().getDisplayedPartNumberFromPopup();
		System.out.println("displayedpnumber is "+ displayedPnumberOnPopup);
		displayedQuantityOnPopup = pageManager.productDetailsPage().getDisplayedQuantityFromPopup();
		System.out.println("displayedQuantity"+ displayedQuantityOnPopup);
	}

	@Test(priority = 6, description="Close Add Product To Cart Popup")
	public void closeAddToCartSuccessPopup() throws Exception
	{		
		pageManager.productDetailsPage().clickOnCloseAddtocartSuccessPopup();
		pageManager.productDetailsPage().refreshPage();
	}*/

	@Test(priority = 7, description="Navigate To Frequently Purchase Page Again")
	public void navigaeToFrequentlyPurchasePage() throws Exception
	{		
		pageManager.productDetailsPage().clickOnHDSupplyLogoInHeader();
		pageManager.homePage().clickFrePurchasedUtilityBar();
	}

	@Test(priority = 8, description="Select Seond Item From Frequently Purchased Page")
	public void clickOnSecondProduct() throws Exception
	{		
		pageManager.frequentlyPurchasedPage().clickOnSecondProductDisplayed();
	}

	@Test(priority = 9, description="Add Product To New Save List From PLP")
	public void AddProductToNewSaveList() throws Exception
	{
		String newListName = "List_";
		pageManager.productDetailsPage().clickAddToListButton();
		newlistCreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
	}

	@Test(priority = 10, description="Add List To Cart")
	public void AddListToCart() throws Exception
	{
		//pageManager.productDetailsPage().clickOnHDSupplyLogoInHeader();
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		newlistDisplayed = pageManager.savedListsPage().getNewlyCreatedList();
		System.out.println("newlistdisplayed is "+ newlistDisplayed);
		System.out.println("newlistcreated is "+ newlistCreated);
		Assert.assertTrue(newlistCreated.equals(newlistDisplayed));
		pageManager.savedListsPage().clickOnAddListToCartButton();
		pageManager.common().acceptPopupMessageBox(driver);
	}

	@Test(priority = 11, description="Navigate To Shopping Cart")
	public void navigateToshoppingCart() throws Exception
	{
		pageManager.homePage().clickOnHDSupplyLogoInHeader();
		pageManager.homePage().clickOnShoppingCartIcon();
		//WaitTool.hardWait();

	}

	@Test(priority = 12, description="Continue To Checkout Page")
	public void NavigateToAddPaymentAndCheckoutPage() throws Exception
	{
		pageManager.shoppingCartPage().clickonCheckOutButton();
	}

	@Test(priority = 13, description="Place Web Order")
	public void placeWebOrder() throws Exception{
		pageManager.paymentAndCheckOutPage().clickOnChargeHDSupplyAccountRadioButton();
		pageManager.paymentAndCheckOutPage().insertPONumber();
		pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
	}

	@Test(priority = 14, description="Capture Web Order Number",enabled=false)
	public void captureWebOrderNumber() throws Exception{
		String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
		System.out.println("orderNumber is "+ orderNumber);	
	}

}