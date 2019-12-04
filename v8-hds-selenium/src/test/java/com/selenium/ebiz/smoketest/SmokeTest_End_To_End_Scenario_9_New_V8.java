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

public class SmokeTest_End_To_End_Scenario_9_New_V8 extends BaseClassV8_Parallel{

	public String newListName;

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
		//waitTool.hardWait();
		Assert.assertTrue(pageManager.frequentlyPurchasedPage().frequentlyPurchasedpageHeadingText.isDisplayed());
	}

	@Test(priority = 2, description="Select One Item From Frequently Purchased Page")
	public void clickOnFirstProdut() throws Exception
	{		
		pageManager.frequentlyPurchasedPage().clickOnFirstProductDisplayed();
	//	waitTool.hardWait();
		Assert.assertTrue(pageManager.productDetailsPage().productDetailsModuleTitle.isDisplayed());
	}
	
	@Test(priority = 3, description="Add Product To Quote")
	public void clickOnAddToQuote() throws Exception
	{		
		String quote = "Quote_";
		pageManager.productDetailsPage().clickAddToQuoteButton();
		pageManager.productDetailsPage().addItemToNewQuote(quote);
		Assert.assertTrue(pageManager.productDetailsPage().productDetailsModuleTitle.isDisplayed());
	}

	@Test(priority = 4, description="Navigates To Quote Page")
	public void navigateToQuotesPage() throws Exception
	{				
		//waitTool.hardWait();
		pageManager.productDetailsPage().navigateToQuotesPage();
	//	waitTool.hardWait();
		Assert.assertTrue(pageManager.quoteListsPage().quotespageHeadingText.isDisplayed());
	}
	

	@Test(priority = 5, description="Navigates To Payment and Checkout Page from Quotes Page")
	public void navigateToPaymentsAndCheckoutPage() throws Exception
	{				
		//waitTool.hardWait();
		pageManager.quoteListsPage().clickOnCheckoutQuoteLinkOfLatestQuote();
		Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedAddPaymentAndCheckoutTitle());
	}

	@Test(priority = 6, description="Place web order")
	public void placeWebOrder() throws Exception
	{
		pageManager.paymentAndCheckOutPage().insertPONumber();
		pageManager.paymentAndCheckOutPage().clickOnSubmitSecureQuote();
		Assert.assertTrue(pageManager.quotesConfirmationPage().isDisplayedQuoteConfirmationText());
		
	}

	@Test(priority = 7, description="Capture Web Order Number")
	public void captureWebOrderNumber() throws Exception
	{
		String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
		System.out.println("orderNumber is "+ orderNumber);	
		Assert.assertTrue(pageManager.quotesConfirmationPage().thankYouForYourOrderText.isDisplayed());
	}
}