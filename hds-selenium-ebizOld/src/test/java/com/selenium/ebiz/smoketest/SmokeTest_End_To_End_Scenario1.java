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
import org.testng.asserts.SoftAssert;

import com.selenium.ebiz.add_to_cart.ShoppingCartDefaultShippingAddress_WORKING;
import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.check_out.CheckOutFinalPricingAndBilling_WORKING;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.Appliances;
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
import com.selenium.ebiz.pageobject.SavedListsPage;
import com.selenium.ebiz.pageobject.SearchPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class SmokeTest_End_To_End_Scenario1 extends BaseClass{
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
	PaymentAndCheckOutPage paymentAndCheckOutPage;
	ShoppingCartDefaultShippingAddress_WORKING shoppingCartDefaultShippingAddress;
	CheckOutFinalPricingAndBilling_WORKING checkOutFinalPricingAndBilling;
	QuickOrderPad quickOrderPad;
	OrderConfirmationPage orderConfirmationPage;
	PropertyLookupPage propertyLookupPage;
	ProductListingPage productListingPage;
	SavedListsPage savedListsPage;
	WebDriver driver;
	public String newListName;
	SoftAssert softAssert = new SoftAssert();
	/**
	 *  Launching of the Browser and login with Valid Credentials
	 *  Select the Property
	 */

	@BeforeClass
	public void driverSetup() throws Exception {
		driver = initialize();		
	}

	@Test(priority = 0, description="Login")
	public void testLogin() throws Exception {
		loginPage = new LoginPage(driver);
	//	WaitTool.hardWait();
		homePage = loginPage.loginToHDS();
		System.out.println( "Welcome Note :"+homePage.getWelcomeNote());	
		System.out.println( "Its Smoke Test");	
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); 
		homePage.selectPropertyDropdown();
		//softAssert.assertAll();		
	}

	/**
	 * This test is used to verify end to end happy path after any deployment.
	 * This test solve the purpose of smoke test
	 */

	@Test(priority = 1, description="Cart Empty Confirmation")
	public void testClearCart() throws Exception{		
		ShoppingCartPage shoppingCartPage = homePage.clickOnShoppingCartIcon();
	//	WaitTool.hardWait();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		} else {
			shoppingCartPage.clearCartReturnsHomePage();
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		}
		//softAssert.assertAll();

	}

	@Test(priority = 2, description="Search by Product Number")
	public void searchByProductNumber() throws Exception{
		usersList = dbConnection.loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		System.out.println(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage = homePage.searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		//softAssert.assertAll();
	}

	@Test(priority = 3, description="Add Product to Cart from PDP")
	public void AddProductFromPDP() throws Exception{
		//WaitTool.hardWait();
		productDetailsPage.clickAddToCartButton();
		//WaitTool.hardWait();
		//Thread.sleep(10000);
		Assert.assertTrue(productDetailsPage.isDisplayedAddToCartSuccessPopup());
		//WaitTool.hardWait();
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
	//	WaitTool.hardWait();
		//softAssert.assertAll();
	}

	@Test(priority = 4, description="Search by Product Description")
	public void SearchByProductDesc() throws Exception{
		usersList = dbConnection.loadDataFromExcel("searchByProductDesc","Search");
		System.out.println(usersList.get(0).getSearchProductKeyword());
		searchPage = productDetailsPage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
	//	WaitTool.hardWait();
		//softAssert.assertAll();
	}

	@Test(priority = 5, description="Add Product to Cart from PLP")
	public void AddProductFromPLP() throws Exception{
		searchPage.clickFirstProductAddToCartButtonInProductList();
		//Thread.sleep(5000);
		Assert.assertTrue(searchPage.isDisplayedCheckoutButton());
		//softAssert.assertAll();
	}

	@Test(priority = 6, description="Click on CheckOut from Modal on PLP")
	public void clickOnCheckOutModal() throws Exception{
		shoppingCartPage =  searchPage.clickOnCheckoutButton();

	}

	@Test(priority = 7, description="Quick Order from SC page")
	public void QuickOrderFromShoppingCart() throws Exception{
		quickOrderPad=shoppingCartPage.clickOnQuickOrderLink();
		Assert.assertTrue(quickOrderPad.isDisplayedDefaultSixRowsInQuickOrderPad());
		usersList = dbConnection.loadDataFromExcel("addProductsUsingQuickOrder","QuickOrder");
		System.out.println("usersList.get(0).getPartNumber1()"+usersList.get(0).getPartNumber1());
		System.out.println("usersList.get(0).getQuantity1()"+usersList.get(0).getQuantity1());
		quickOrderPad.fillFirstPartNumberTextBox(usersList.get(0).getPartNumber1());
		quickOrderPad.fillFirstQuantityTextBox(usersList.get(0).getQuantity1());
		shoppingCartPage = quickOrderPad.clickOnAddToCartButton();
		shoppingCartPage.selectDefaultOptionFromShippingDropdown();
		Assert.assertTrue(shoppingCartPage.isDeliveryMessageDisplayed());
		//softAssert.assertAll();
	}

	@Test(priority = 8, description="Add to Saved List from SC Page")
	public void addToSavedListFromShoppingCart() throws Exception{
		shoppingCartPage.clickCreateOrEditSavedList();
		Assert.assertTrue(shoppingCartPage.isAddToExistingOrCreateNewListTitleTextDisplayed());
		Assert.assertTrue(shoppingCartPage.isDisplayedExistingOrNewTabsOnAddToListModal());
		//softAssert.assertAll();

	}

	@Test(priority = 9, description="Creating New Saved List")
	public void createNewSavedList() throws Exception{
		String newlistcreated = shoppingCartPage.addItemToNewList(newListName);
		//WaitTool.hardWait();
		savedListsPage = shoppingCartPage.clickMyAccountSavedListsQuickLink();
		String newlistdisplayed = savedListsPage.getNewlyCreatedList();
		System.out.println("newlistdisplayed is "+ newlistdisplayed);
		System.out.println("newlistcreated is "+ newlistcreated);
		Assert.assertTrue(newlistcreated.equals(newlistdisplayed));
		savedListsPage.clickOnNewlyCreatedList();
		//softAssert.assertAll();
	}

	@Test(priority = 10, description="Validate Print Bin Labels")
	public void validatePrintBinLabels() throws Exception{
		savedListsPage.clickOnPrintBinLabelsLink();
	//	WaitTool.hardWait();
	//	WaitTool.hardWait();
		Assert.assertTrue(savedListsPage.isContactNumberOnBinLabelDisplayed());
		Assert.assertTrue(savedListsPage.isProductDescriptionOnBinLabelDisplayed());
		Assert.assertTrue(savedListsPage.isHDSPartTextOnBinLabelDisplayed());
		CommonFunctions.closecurrentBrowser(driver);
		CommonFunctions.moveToNewWindow(driver);
	//	WaitTool.hardWait();
		//softAssert.assertAll();

	}

	@Test(priority = 11, description="Click Cart Icon")
	public void clickShoppingCartIcon() throws Exception{
		shoppingCartPage = savedListsPage.clickOnShoppingCartIcon();
	//	Thread.sleep(10000);
		//softAssert.assertAll();
	}

	@Test(priority = 12, description="Validate P&A")
	public void validatePNA() throws Exception{
		String subtotalValue = shoppingCartPage.displayedSubtotalValue();
		String taxValue = shoppingCartPage.displayedTaxValue();
		String totalValue = shoppingCartPage.displayedTotalValue();
		subtotalValue = shoppingCartPage.displayedSubtotalValue();
		taxValue = shoppingCartPage.displayedTaxValue();
		totalValue = shoppingCartPage.displayedTotalValue();
		System.out.println("SubtotalValue: " +subtotalValue);
		System.out.println("TaxValue: "+taxValue);
		System.out.println("TotalValue: "+totalValue);
		//softAssert.assertAll();
	}

	@Test(priority = 13, description="Add Payment and Checkout Page")
	public void addPaymentAndCheckoutPage() throws Exception{
	//	WaitTool.hardWait();
		paymentAndCheckOutPage = shoppingCartPage.clickonCheckOutButton();
		paymentAndCheckOutPage.insertPONumber();
		System.out.println("*******Inserted PO number**********");
		//softAssert.assertAll();
	}

	@Test(priority = 14, description="Validate P&A results from SC Page")
	public void validatePNAResults() throws Exception{
		System.out.println("*******validatePNAResults tests**********");
		String subtotalValue = paymentAndCheckOutPage.displayedSubtotalValue();
		String taxValue = paymentAndCheckOutPage.displayedTaxValue();
		String totalValue = paymentAndCheckOutPage.displayedTotalValue();
		subtotalValue = paymentAndCheckOutPage.displayedSubtotalValue();
		taxValue = paymentAndCheckOutPage.displayedTaxValue();
		totalValue = paymentAndCheckOutPage.displayedTotalValue();
		System.out.println("SubtotalValue: " +subtotalValue);
		System.out.println("TaxValue: "+taxValue);
		System.out.println("TotalValue: "+totalValue);
		//softAssert.assertAll();
	}

	@Test(priority = 15, description="Place web order")
	public void placeWebOrder() throws Exception{
		orderConfirmationPage = paymentAndCheckOutPage.clickOnSubmitSecureOrder();
		//softAssert.assertAll();

	}

	@Test(priority = 16, description="Capture Web Order Number")
	public void captureWebOrderNumber() throws Exception{
		String orderNumber = orderConfirmationPage.storeOrderNumber();
		System.out.println("orderNumber is "+ orderNumber);	
		softAssert.assertAll();
	} 

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}