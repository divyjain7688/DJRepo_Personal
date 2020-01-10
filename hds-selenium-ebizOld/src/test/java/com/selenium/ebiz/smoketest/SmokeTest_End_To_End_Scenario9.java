/**
 * 
 *  This is for Smoke Test
 *   
 */

package com.selenium.ebiz.smoketest;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
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
import com.selenium.ebiz.tools.WaitTool;

public class SmokeTest_End_To_End_Scenario9 extends BaseClass{
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

	@Test(priority = 3, description="Add Product To Quote")
	public void clickOnAddToQuote() throws Exception
	{		
		String quote = "Quote_";
		productDetailsPage.clickAddToQuoteButton();
		productDetailsPage.addItemToNewQuote(quote);
	}

	@Test(priority = 4, description="Navigates To Quote Page")
	public void navigateToQuotesPage() throws Exception
	{				
		//WaitTool.hardWait();
		quotesPage = productDetailsPage.navigateToQuotesPage();
		//WaitTool.hardWait();
	}


	@Test(priority = 5, description="Navigates To Payment and Checkout Page from Quotes Page")
	public void navigateToPaymentsAndCheckoutPage() throws Exception
	{				
		//WaitTool.hardWait();
		paymentAndCheckOutPage =  quotesPage.clickOnCheckoutQuoteLinkOfLatestQuote();
	}

	@Test(priority = 6, description="Place web order")
	public void placeWebOrder() throws Exception
	{
		paymentAndCheckOutPage.insertPONumber();
		orderConfirmationPage = paymentAndCheckOutPage.clickOnSubmitSecureQuote();

	}

	@Test(priority = 7, description="Capture Web Order Number")
	public void captureWebOrderNumber() throws Exception
	{
		String orderNumber = orderConfirmationPage.storeOrderNumber();
		System.out.println("orderNumber is "+ orderNumber);	
	}



	@AfterClass
	public void teardown()
	{
		//driver.quit();
	}
}