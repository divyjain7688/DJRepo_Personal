/**
 * 
 *  This is for Smoke Test
 *   
 */

package com.selenium.ebiz.smoketest;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.ebiz.add_to_cart.ShoppingCartDefaultShippingAddress_WORKING;
import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.check_out.CheckOutFinalPricingAndBilling_WORKING;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.Appliances;
import com.selenium.ebiz.pageobject.FrequentlyPurchasedPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MinicartPage;
import com.selenium.ebiz.pageobject.OrderConfirmationPage;
import com.selenium.ebiz.pageobject.PaymentAndCheckOutPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.ProductPage;
import com.selenium.ebiz.pageobject.PropertyLookupPage;
import com.selenium.ebiz.pageobject.QuickOrderPad;
import com.selenium.ebiz.pageobject.QuotesPage;
import com.selenium.ebiz.pageobject.SavedListsPage;
import com.selenium.ebiz.pageobject.SearchPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class SmokeTest_End_To_End_Scenario8 extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	HomePage homePage;
	LoginPage loginPage;
	SearchPage searchPage;
	ProductPage productPage;
	Appliances appliances;
	SubCategoryAppliancesPage subcategoryAppPage;
	ProductDetailsPage productDetailsPage;
	MinicartPage miniCartPage;
	ShoppingCartPage shoppingCartPage;
	QuotesPage quotesPage;
	PaymentAndCheckOutPage paymentAndCheckOutPage;
	ShoppingCartDefaultShippingAddress_WORKING shoppingCartDefaultShippingAddress;
	CheckOutFinalPricingAndBilling_WORKING checkOutFinalPricingAndBilling;
	QuickOrderPad quickOrderPad;
	OrderConfirmationPage orderConfirmationPage;
	PropertyLookupPage propertyLookupPage;
	ProductListingPage productListingPage;
	SavedListsPage savedListsPage;
	FrequentlyPurchasedPage frequentlyPurchasedPage;
	WebDriver driver;
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

	@BeforeClass
	public void driverSetup() throws Exception {
		driver = initialize();		
	}

	@Test(priority = 0, description="Login To Application")
	public void testLogin() throws Exception 
	{
		loginPage = new LoginPage(driver);
	//	WaitTool.hardWait();
		homePage = loginPage.loginToHDS();
		homePage.clickPropertyDropdown();
		homePage.clickOnAccount0012482411UnderUser();		
	}

	@Test(priority = 1, description="Navigate to Frequently Purchased Page")
	public void navigateToFrequentlyPurchasedPage() throws Exception
	{		
		frequentlyPurchasedPage = homePage.clickOnFrequentlyPurchasedLink();
		//WaitTool.hardWait();
	}

	@Test(priority = 2, description="Select One Item From Frequently Purchased Page")
	public void clickOnFirstProdut() throws Exception
	{		
		productDetailsPage=frequentlyPurchasedPage.clickOnFirstProductDisplayed();
	//	WaitTool.hardWait();
	}

	@Test(priority = 3, description="Fetch Part Number And Quantity")
	public void getPartNumberAndQuantityDisplayed() throws Exception
	{		
		displayedPnumber = productDetailsPage.getDisplayedPartNumber();
		displayedQuantity = productDetailsPage.getDisplayedQuantity();
		System.out.println("displayedpnumber is "+ displayedPnumber + "displayedQuantity"+ displayedQuantity);
	}

	@Test(priority = 4, description="Add Product To Cart")
	public void clickOnAddToCart() throws Exception
	{		
		productDetailsPage.clickAddToCartButton();
		//WaitTool.hardWait();
	}

	@Test(priority = 5, description="Verify Part Number And Quantity")
	public void verifyPartNumberAndQuantity() throws Exception
	{		
		displayedPnumberOnPopup = productDetailsPage.getDisplayedPartNumberFromPopup();
		System.out.println("displayedpnumber is "+ displayedPnumberOnPopup);
		displayedQuantityOnPopup = productDetailsPage.getDisplayedQuantityFromPopup();
		System.out.println("displayedQuantity"+ displayedQuantityOnPopup);
	}


	@Test(priority = 6, description="Close Add Product To Cart Popup")
	public void closeAddToCartSuccessPopup() throws Exception
	{		
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
	//	WaitTool.hardWait();
		productDetailsPage.refreshPage();
	}

	@Test(priority = 7, description="Navigate To Frequently Purchase Page Again")
	public void navigaeToFrequentlyPurchasePage() throws Exception
	{		
	//	WaitTool.hardWait();
		homePage=productDetailsPage.clickOnHDSupplyLogoInHeader();
		frequentlyPurchasedPage = homePage.clickOnFrequentlyPurchasedLink();
	//	WaitTool.hardWait();
	}

	@Test(priority = 8, description="Select Seond Item From Frequently Purchased Page")
	public void clickOnSecondProdut() throws Exception
	{		
		productDetailsPage=frequentlyPurchasedPage.clickOnSecondProductDisplayed();
	//	WaitTool.hardWait();
	}


	@Test(priority = 9, description="Add Product To New Save List From PLP")
	public void AddProductToNewSaveList() throws Exception
	{
		String newListName = "List_";
		productDetailsPage.clickAddToListButton();
		newlistCreated = productDetailsPage.addItemToNewList(newListName);
		//WaitTool.hardWait();
	}

	@Test(priority = 10, description="Add List To Cart")
	public void AddListToCart() throws Exception
	{
		homePage=productDetailsPage.clickOnHDSupplyLogoInHeader();
		savedListsPage = homePage.clickMyAccountSavedListsQuickLink();
		newlistDisplayed = savedListsPage.getNewlyCreatedList();
		System.out.println("newlistdisplayed is "+ newlistDisplayed);
		System.out.println("newlistcreated is "+ newlistCreated);
		Assert.assertTrue(newlistCreated.equals(newlistDisplayed));
	//	WaitTool.hardWait();
		savedListsPage.clickOnAddListToCartButton();
	//	WaitTool.hardWait();
		CommonFunctions.acceptPopupMessageBox(driver);
	//	WaitTool.hardWait();

	}

	@Test(priority = 11, description="Navigate To Shopping Cart")
	public void navigateToshoppingCart() throws Exception
	{
		homePage = savedListsPage.clickHeaderHDLogoImage();
		shoppingCartPage = homePage.clickOnShoppingCartIcon();
	//	WaitTool.hardWait();
	}

	@Test(priority = 12, description="Continue To Checkout Page")
	public void NavigateToAddPaymentAndCheckoutPage() throws Exception
	{
		paymentAndCheckOutPage = shoppingCartPage.clickonCheckOutButton();
	//	WaitTool.hardWait();
	}

	@Test(priority = 13, description="Place Web Order")
	public void placeWebOrder() throws Exception{
		paymentAndCheckOutPage.clickOnChargeHDSupplyAccountRadioButton();
		paymentAndCheckOutPage.insertPONumber();
		orderConfirmationPage = paymentAndCheckOutPage.clickOnSubmitSecureOrder();
	}

	@Test(priority = 14, description="Capture Web Order Number")
	public void captureWebOrderNumber() throws Exception{
		String orderNumber = orderConfirmationPage.storeOrderNumber();
		System.out.println("orderNumber is "+ orderNumber);	
	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}