package com.selenium.ebiz.add_to_cart.old_add_to_cart_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartLinksButtons_WORKING extends BaseClassV8_Parallel {

	private int counter;


	@Test(priority = 0)
	public void test_login() throws Exception {

		LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

	}

	/**
	 * Description : To verify As a user I want the ability to perform certain actions in the shopping cart
	 *  via links and buttons.
	 * @author lakshmi
	 * @modified Iuliia
	 * data 12/17/2018
	 * US-Ord-204
	 * */

	@Test(priority = 1)
	public void test_verifyShoppingCartClear() throws Exception {
		pageManager.shoppingCartPage().checkClearShoppingCart();
		Log.info("Check and clear Shopping cart");

		}
	@Test(priority = 2)
	public void test_getIntoShoppingCart() throws Exception{
		pageManager.homePage().moveToSubCategoryPage();
		pageManager.productListingPage().clickonFirstProductAddToCart();
		pageManager.productListingPage().clickOnCloseAddtocartSuccessPopup();
		pageManager.productListingPage().refreshPage();
		counter = pageManager.common().counterIncrease();
		Log.info("counter value is "+ counter);
		/*productListingPage.addToCartAndNavigateToSCP();
		productListingPage.clickOnCloseAddtocartSuccessPopup();
		productListingPage.refreshPage();
		counter = .counterIncrease();
		System.out.println("counter value is "+ counter);*/
		pageManager.productListingPage().clickOnHDSupplyLogoInHeader();
		pageManager.homePage().shoppingCartIcon.click();
	}

	@Test(priority = 3)
	public void test_verifyFooterTopLinkisDisplayed() {

		//Verify links,buttons are displayed on the Shopping cart page
		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedFooterTopLink());

	}
	@Test(priority = 4)
	public void test_verifyReturnPolicyLinkisDisplayed() {

		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedReturnPolicyLink());
	}
	@Test(priority = 5)
	public void test_verifysaveAsQuoteButtonisDisplayed() {

		Assert.assertTrue(pageManager.shoppingCartPage().saveAsQuoteButton.isDisplayed());
	}
	@Test(priority = 6)
	public void test_verifyViewSavedQuotesisDisplayed() {

		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedViewSavedQuotesLink());;
	}
	@Test(priority = 7)
	public void test_verifyemptyCartLinkisDisplayed() {

		Assert.assertTrue(pageManager.shoppingCartPage().emptyCartLink.isDisplayed());
	}
	@Test(priority = 8)
	public void test_verifyCheckoutButtonisDisplayed() {
		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedCheckoutButton());
	}
	@Test(priority = 9)
	public void test_VerifyaddToQuoteModalisDisplayed() throws Exception {

        pageManager.shoppingCartPage().saveAsQuoteButton.click();

        waitTool.waitForElement(driver,pageManager.shoppingCartPage().addToQuoteModal);
        pageManager.shoppingCartPage().addToQuoteModal.click();

        waitTool.waitForElement(driver,pageManager.shoppingCartPage().addToQuoteButtonOnQuoteModal);
        pageManager.shoppingCartPage().addToQuoteButtonOnQuoteModal.click();
        waitTool.waitForElement(driver,pageManager.shoppingCartPage().successMessageAfterAddToQuote);
        //waitTool.hardWait10sec();
        //waitTool.hardWait10sec();
        //Assert.assertTrue(pageManager.shoppingCartPage().successMessageAfterAddToQuote.isDisplayed());
        pageManager.shoppingCartPage().closeButtonOnAddToQuoteSuccessMessage.click();
        Assert.assertTrue(pageManager.shoppingCartPage().areThreeCheckOutButtonsDisplayed());

    }
    @Test(priority = 10)
    public void test_VerifyThreeCheckOutButtonsDisplayed() throws Exception
    {
		pageManager.shoppingCartPage().ClickEmptyCartLinkAndCancel();
		Assert.assertTrue(pageManager.shoppingCartPage().areThreeCheckOutButtonsDisplayed());
		pageManager.shoppingCartPage().clickOnViewSavedQuotesLink();
		pageManager.common().navigateBack();
		pageManager.shoppingCartPage().clickOnReturnPolicyLink();
		Assert.assertTrue(pageManager.shoppingCartPage().isReturnPolicyTextDisplayed());
		pageManager.common().navigateBack();
		pageManager.shoppingCartPage().ClickTopLink();
		Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
		pageManager.shoppingCartPage().clickonCheckOutButton();

		/*	//verify that we have 3 checkout buttons in shopping cart page.
		Assert.assertEquals(shoppingCartPage.getNumberofCheckoutBtn(), 3);
		//verify a pop up is displayed when we click on empty cart.
		shoppingCartPage.ClickEmptyCartLink();
		waitTool.hardWait();
		Thread.sleep(6000);			
		//shoppingCartPage.isDialogPresent(driver);
		//System.out.println("kjadfds");
		.acceptPopupMessageBox(driver);
		//System.out.println(alert.getText());
		//verify click onsave as quote
		//shoppingCartPage.clickSaveasQuoteButton();

		//verify Authenticated user will be take to Final Pricing and Billing page
		paymentAndCheckoutPage=shoppingCartPage.clickonCheckOutButton();
		Assert.assertTrue(.isElementPresent(paymentAndCheckoutPage.paymentAndCheckoutPageHeadingText));

		//"Top" link - Takes user to the very top of the Shopping Cart page. 
		shoppingCartPage.ClickTopLink();
		Assert.assertTrue(shoppingCartPage.isDisplayedShoppingCartPage());*/
	}

}


