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
import com.selenium.ebiz.tools.WaitTool;

public class SmokeTest_End_To_End_Scenario2 extends BaseClass{
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

	/**
	 *  Launching of the Browser and login with Valid Credentials
	 *  Select the Property
	 */

	@BeforeClass
	public void driverSetup() throws Exception {
		driver = initialize();		
	}

	@Test(priority = 0, description="Login To Application")
	public void testLogin() throws Exception {
		//driver = initialize();
		loginPage = new LoginPage(driver);
		//WaitTool.hardWait();
		homePage = loginPage.loginToHDS();
		//homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
		//WaitTool.hardWait();
		//Validating the HomePage displayed or not by checking Hi text.
		System.out.println( "Welcome Note :"+homePage.getWelcomeNote());	
		System.out.println( "Its Smoke Test");	
		Assert.assertTrue(homePage.getWelcomeNote().contains("Hi")); 
		homePage.clickPropertyDropdown();
		homePage.clickOnAccount0012482411UnderUser();		
	}

	@Test(priority = 1, description="Verify Cart is empty")
	public void testClearCart() throws Exception{		
		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		//WaitTool.hardWait();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		} else {
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCartReturnsHomePage();
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		}

	}

	@Test(priority = 2, description="Search by Product Description")
	public void searchByProductDescription() throws Exception{
		usersList = dbConnection.loadDataFromExcel("searchByProductDesc","Search");
		System.out.println(usersList.get(0).getSearchProductKeyword());
		productListingPage = homePage.searchDescription(usersList.get(0).getSearchProductKeyword());
		Assert.assertTrue(productListingPage.isGridViewDisplayed());
	}

	@Test(priority = 3, description="Add Product to Cart from PLP")
	public void AddProductToCartFromPLP() throws Exception{
		productListingPage.clickonFirstProductAddToCart();
		//WaitTool.hardWait();
		Assert.assertTrue(productListingPage.isDisplayedAddToCartSuccessPopup());
		//	WaitTool.hardWait();
		productListingPage.clickOnCloseAddtocartSuccessPopup();		
		//WaitTool.hardWait();
		productListingPage.refreshPage();
	}


	@Test(priority = 4, description="Add Product To New Save List From PLP")
	public void AddProductToNewSaveList() throws Exception
	{
		newListName = "List_";
		productListingPage.clickOnFirstProductAddToList();
		String newlistcreated = productListingPage.addItemToNewList(newListName);
		System.out.println("newlistcreated is" + newlistcreated);
		Assert.assertTrue(productListingPage.isGridViewDisplayed());
	}


	@Test(priority = 5, description="Verify Alternate Ship To Address ON SC Page")
	public void ValidateAddreessOnShoppingCart() throws Exception{
		shoppingCartPage = homePage.clickOnShoppingCartIcon();
		shoppingCartPage.getAlternateOptionFromShippingtoDrpDown();
		/*need confirmation on next step*/
	}


	@Test(priority = 6, description="Quick Order Peachtree Product from SC page")
	public void QuickOrderPeachTreeProductFromShoppingCart() throws Exception
	{
		quickOrderPad=shoppingCartPage.clickOnQuickOrderLink();
		Assert.assertTrue(quickOrderPad.isDisplayedDefaultSixRowsInQuickOrderPad());
		usersList = dbConnection.loadDataFromExcel("addPeachtreeProductsUsingQuickOrder","QuickOrder");
		System.out.println("usersList.get(0).getPartNumber1()"+usersList.get(0).getPartNumber1());
		System.out.println("usersList.get(0).getQuantity1()"+usersList.get(0).getQuantity1());
		quickOrderPad.fillFirstPartNumberTextBox(usersList.get(0).getPartNumber1());
		//WaitTool.hardWait();
		quickOrderPad.fillFirstQuantityTextBox(usersList.get(0).getQuantity1());
		//WaitTool.hardWait();

		shoppingCartPage = quickOrderPad.clickOnAddToCartButton();
	}

	@Test(priority = 7, description="Validate Peachtree Product Message On SC page before customization")
	public void verifyPeachTreeProductOnShoppingCartBeforeCustomization() throws Exception
	{
		Assert.assertTrue(shoppingCartPage.isMustBeCustomizedMessageDisplayed());
		Assert.assertTrue(shoppingCartPage.isCustomizeThisItemLinkDisplayed());
	}

	@Test(priority = 8, description="Validate PT configurator Text Window")
	public void validatePTConfiguratorTextWindow() throws Exception
	{		
		//WaitTool.hardWait();
		shoppingCartPage.clickOnCustomizeThisItemLink();
		//	WaitTool.hardWait();
		Assert.assertTrue(shoppingCartPage.isPTConfiguratorModalWindowDisplayed());
	}

	@Test(priority = 9, description="Customize peachTree Product And Do Add To Cart")
	public void customizePeachTreeProductAndAddToCart() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("customizePeachTreeProductAndAddToCart","CustomizePeachTreeItem");
		shoppingCartPage.fillCustomizeItemForm(usersList.get(0).getFlatOrAssemble(), usersList.get(0).getLabelFormat(), 
				usersList.get(0).getColor(), usersList.get(0).getStyle(), usersList.get(0).getImprintLine1(),
				usersList.get(0).getImprintLine2(), usersList.get(0).getImprintLine3(),usersList.get(0).getImprintLine4(),
				usersList.get(0).getImprintLine5(), usersList.get(0).getImprintLine6(), usersList.get(0).getImprintLine7(), 
				usersList.get(0).getComments());
	}

	@Test(priority = 10, description="Validate Peachtree Product Message On SC page after customization")
	public void verifyPeachTreeProductOnShoppingCartAfterCustomization() throws Exception
	{
		Assert.assertTrue(shoppingCartPage.isYouHaveCustomizeLinkDisplayed());
	}


	@Test(priority = 11, description="Continue To Checkout Page")
	public void NavigateToAddPaymentAndCheckoutPage() throws Exception
	{
		paymentAndCheckOutPage = shoppingCartPage.clickonCheckOutButton();
	}

	@Test(priority = 12, description="Validate Cart Summary")
	public void validateCartSummary() throws Exception{
		String subtotalValue = paymentAndCheckOutPage.displayedSubtotalValue();
		String shippingValue = paymentAndCheckOutPage.displayShippingValuealValue();
		String taxValue = paymentAndCheckOutPage.displayedTaxValue();
		String totalValue = paymentAndCheckOutPage.displayedTotalValue();
		System.out.println("SubtotalValue: " +subtotalValue);
		System.out.println("shippingValue: " +shippingValue);
		System.out.println("TaxValue: "+taxValue);
		System.out.println("TotalValue: "+totalValue);
	}

	@Test(priority = 13, description="Place web order")
	public void placeWebOrder() throws Exception{
		paymentAndCheckOutPage.insertPONumber();
		System.out.println("*******Inserted PO number**********");
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