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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.add_to_cart.ShoppingCartDefaultShippingAddress_WORKING;
import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.check_out.CheckOutFinalPricingAndBilling_WORKING;
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

public class SmokeTest_End_To_End_Scenario7 extends BaseClass{
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
	String pnumberOnPLPPage;
	String pnumberOnSavedList;

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
	//	WaitTool.hardWait();
		homePage = loginPage.loginToHDS();
		//homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
	//	WaitTool.hardWait();
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
	//	WaitTool.hardWait();
		if (shoppingCartPage.isShoppingCartEmptyMessageDisplayed()) {
			System.out.println("Cart is Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		} else {
			System.out.println("Cart is not Empty :"+ shoppingCartPage.isShoppingCartEmptyMessageDisplayed());
			shoppingCartPage.clearCartReturnsHomePage();
			homePage = shoppingCartPage.clickOnHDSupplyLogoInHeader();
		}

	}
	

	@Test(priority = 2, description="Launch Application")
	public void logoutAndLogin() throws Exception 
	{
		loginPage = homePage.clickOnSignOutIcon();
	//	WaitTool.hardWait();	
	}

	@Test(priority = 3, description="Navigate to Product Listing Page")
	public void navigateToProductListingPage() throws Exception
	{		
		productListingPage= loginPage.moveToSubCategoryPage();
	//	WaitTool.hardWait();	
	}

	@Test(priority = 4, description="Add product To Cart")
	public void addProductToCartFromPLP() throws Exception
	{		
		pnumberOnPLPPage = productListingPage.getFirstProductPartNumber();
		productListingPage.clickonFirstProductAddToCart();
		//WaitTool.hardWait();	
	}

	@Test(priority = 5, description="Validate Add To Cart Success Modal")
	public void validateAddToCartSuccessModal() throws Exception
	{		
		Assert.assertTrue(productListingPage.isDisplayedAddToCartSuccessPopup());
	}

	@Test(priority = 6, description="Click On Checkout")
	public void clickOnAddToCart() throws Exception
	{		
		shoppingCartPage =  productListingPage.clickOnCheckoutButtonOnAddToCartPopup();
	//	WaitTool.hardWait();	
	}

	@Test(priority = 7, description="Login Via Header From Shopping Cart Page")
	public void verifyPartNumberAndQuantity() throws Exception
	{		
		shoppingCartPage=shoppingCartPage.loginToHDS();
	}

	@Test(priority = 8, description="Click On Add To List")
	public void clickOnAddToList() throws Exception
	{		
		shoppingCartPage.clickAddToListButton();
	//	WaitTool.hardWait();	
		Assert.assertTrue(shoppingCartPage.isAddToListModalWindowDisplayed());
	}

	@Test(priority = 9, description="Create New List")
	public void createNewList() throws Exception
	{		
		String newlist = "List_";
		shoppingCartPage = shoppingCartPage.createNewList(newlist);
	//	WaitTool.hardWait();
	}

	@Test(priority = 10, description="Navigate To Saved List")
	public void navigateToSavedList() throws Exception
	{		
		savedListsPage = shoppingCartPage.clickMyAccountSavedListsQuickLink();
	//	WaitTool.hardWait();
		savedListsPage.clickSharedListt();
		savedListsPage.clickOnExistingFirstSavedList();
		//WaitTool.hardWait();
	}

	
	@Test(priority = 11, description="Validate Product In Newly Created Saved List")
	public void validateProductInSavedList() throws Exception
	{		
		pnumberOnSavedList = savedListsPage.displayedAddedItemInExistingList();
		System.out.println("pnumberOnSavedList is " + pnumberOnSavedList);
		System.out.println("pnumberOnPLPPage is " + pnumberOnPLPPage);
		Assert.assertEquals(pnumberOnPLPPage, pnumberOnSavedList);
	}
	
	@Test(priority = 12, description="Add To Cart From Saved List")
	public void addToCartFromSavedList() throws Exception
	{		
	//	WaitTool.hardWait();
		savedListsPage.clickOnAddToCartButton();
		shoppingCartPage=savedListsPage.clickonCheckOutButton();
	}
	
	@Test(priority = 13, description="Continue To Checkout Page")
	public void NavigateToAddPaymentAndCheckoutPage() throws Exception
	{
		paymentAndCheckOutPage = shoppingCartPage.clickonCheckOutButton();
	}
	
	@Test(priority = 14, description="Place web order")
	public void placeWebOrder() throws Exception{
		paymentAndCheckOutPage.clickOnChargeHDSupplyAccountRadioButton();
		paymentAndCheckOutPage.insertPONumber();
		orderConfirmationPage = paymentAndCheckOutPage.clickOnSubmitSecureOrder();
	}

	@Test(priority = 15, description="Capture Web Order Number")
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