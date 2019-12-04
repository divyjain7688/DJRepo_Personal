package com.selenium.ebiz.smoketest;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest_End_To_End_Scenario_7_New_V8 extends BaseClassV8_Parallel {

	String pnumberOnPLPPage;
	String username;
	int productAddedToCart,displayedShoppingCartProductCount;


	@Test(priority = 0, description="Login To Application")
	public void testLogin() {
		username = RandomAccountSelect.users.pop();
		Log.info(username);
		pageManager.loginPage().LoginToHDS(username, configread.getPassword());
		//LoginToHDS(username, configread.getPassword());
	}

	@Test(priority = 1, description="Verify Cart is empty")
	public void testClearCart() throws Exception{
		pageManager.shoppingCartPage().checkClearShoppingCart();
		Log.info("Checked the SC");
	}


	@Test(priority = 2, description="logout")
	public void logout() throws Exception
	{
		pageManager.homePage().clickOnSignOutIcon();
		Log.info("Logout");

	}

	@Test(priority = 3, description="Navigate to Product Listing Page")
	public void navigateToProductListingPage() throws Exception
	{
		pageManager.homePage().moveToSubCategoryPage();
		Log.info("Selected sub categories");

	}

	@Test(priority = 4, description="Add product To Cart")
	public void addProductToCartFromPLP() throws Exception
	{
		pnumberOnPLPPage = pageManager.productListingPage().getFirstProductPartNumber();
		pageManager.productListingPage().clickonFirstProductAddToCart();
	}

	/*  @Test(priority = 5, description="Validate Add To Cart Success Modal")
    public void test_VerifyPartWasAddedIntoSC()
    {
        productAddedToCart = pageManager.homePage().counterIncrease(productAddedToCart);
        Log.info("productAddedToCart is "+ productAddedToCart);
       // .refresh(driver);
        displayedShoppingCartProductCount = pageManager.homePage().getShoppingCartProductCount();
        Log.info("displayedShoppingCartProductCount is "+ displayedShoppingCartProductCount);
        Assert.assertEquals(productAddedToCart, displayedShoppingCartProductCount);
<<<<<<< HEAD
      //  Assert.assertTrue(pageManager.productListingPage().isDisplayedAddToCartSuccessPopup());
    }

    @Test(priority = 6, description="Click On Shoppingcart")
    public void test_clickOnSCIcon() throws Exception
    {
        pageManager.homePage().clickOnShoppingCartIcon();

    }

    @Test(priority = 7, description="Login Via Header From Shopping Cart Page")
    public void LoginFromShoppingCartPage()
    {
        pageManager.shoppingCartPage().loginToHdSupplySite(username,configread.getPassword());
        Log.info(username);
        waitTool.waitForElement(driver,pageManager.loginPage().loggedAccountNumberText);
        
    }

    @Test(priority = 8, description="Click On Add To List")
    public void test_clickOnAddToList()
    {
       // pageManager.shoppingCartPage().wait.until(ExpectedConditions.elementToBeClickable(pageManager.shoppingCartPage().addToListButton));
      pageManager.shoppingCartPage().wait.until(ExpectedConditions.visibilityOf(pageManager.shoppingCartPage().accountText));
    	Log.info("Wait visibility of into Add To List btn");
        pageManager.shoppingCartPage().clickAddToListButton();
        Assert.assertTrue(pageManager.shoppingCartPage().isAddToListModalWindowDisplayed());
    }

    @Test(priority = 9, description="Create New List")
    public void createNewList() throws Exception
    {
        String newlist = "List_";
        pageManager.shoppingCartPage().createNewList(newlist);
    }

    @Test(priority = 10, description="Navigate To Saved List")
    public void navigateToSavedList() throws Exception
    {
        pageManager.shoppingCartPage().clickMyAccountSavedListsQuickLink();
        Log.info("Click on My Account Saved lists link");
        pageManager.savedListsPage().clickSharedListt();
        Log.info("Click on Shared List");
        pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().clickOnExistingFirstSavedList();
        Log.info("Click on Existing First Saved List");

    }


    @Test(priority = 11, description="Validate Product In Newly Created Saved List")
    public void validateProductInSavedList() throws Exception {
        //  pageManager.savedListsPage().displayedAddedItemInExistingList();
        String pnumberOnSavedList = pageManager.savedListsPage().displayedAddedItemInExistingList();
        Log.info("pnumberOnSavedList is " + pnumberOnSavedList);
        Log.info("pnumberOnPLPPage is " + pnumberOnPLPPage);
        Assert.assertEquals(pnumberOnPLPPage, pnumberOnSavedList);
    }

    @Test(priority = 12, description="Add To Cart From Saved List")
    public void addToCartFromSavedList() throws Exception
    {
        //	waitTool.hardWait();
        pageManager.savedListsPage().clickonFirstAddToCartbtn();
        .scrollUp(driver);
        pageManager.homePage().clickOnShoppingCartIcon();
    }

    @Test(priority = 13, description="Continue To Checkout Page")
    public void NavigateToAddPaymentAndCheckoutPage() throws Exception
    {
        pageManager.shoppingCartPage().clickonCheckOutButton();
    }

    @Test(priority = 14, description="Place web order")
    public void placeWebOrder() throws Exception{
        pageManager.paymentAndCheckOutPage().clickOnChargeHDSupplyAccountRadioButton();
        pageManager.paymentAndCheckOutPage().insertPONumber();
        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
    }

    @Test(priority = 15, description="Capture Web Order Number")
    public void captureWebOrderNumber() throws Exception{
        String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
        System.out.println("orderNumber is "+ orderNumber);
    }
=======
    }*/

	@Test(priority = 6, description="Click On Shoppingcart")
	public void test_clickOnSCIcon() throws Exception
	{
		pageManager.homePage().clickOnShoppingCartIcon();

	}

	@Test(priority = 7, description="Login Via Header From Shopping Cart Page")
	public void LoginFromShoppingCartPage() throws Exception
	{
		pageManager.loginPage().loginToHdSupplySite(username,configread.getPassword());
		Log.info(username);
		Assert.assertTrue(pageManager.loginPage().loggedAccountNumberText.isDisplayed());

	}

	@Test(priority = 8, description="Click On Add To List")
	public void test_clickOnAddToList()
	{
		// pageManager.shoppingCartPage().wait.until(ExpectedConditions.elementToBeClickable(pageManager.shoppingCartPage().addToListButton));
		//pageManager.shoppingCartPage().wait.until(ExpectedConditions.visibilityOf(pageManager.shoppingCartPage().accountText));
		//Log.info("Wait visibility of into Add To List btn");
		pageManager.shoppingCartPage().clickAddToListButton();
		Assert.assertTrue(pageManager.shoppingCartPage().isAddToListModalWindowDisplayed());
	}

	@Test(priority = 9, description="Create New List")
	public void createNewList() throws Exception
	{
		String newlist = "List_";
	// the method need to be modified:	pageManager.shoppingCartPage().createNewList(newlist);
	}

	@Test(priority = 10, description="Navigate To Saved List")
	public void navigateToSavedList() throws Exception
	{
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		Log.info("Click on My Account Saved lists link");
		pageManager.savedListsPage().clickSharedListt();
		Log.info("Click on Shared List");
		pageManager.savedListsPage().recentlyUpdatedLink.click();
		pageManager.savedListsPage().clickOnExistingFirstSavedList();
		Log.info("Click on Existing First Saved List");

	}


	@Test(priority = 11, description="Validate Product In Newly Created Saved List")
	public void validateProductInSavedList() throws Exception {
		//  pageManager.savedListsPage().displayedAddedItemInExistingList();
		String pnumberOnSavedList = pageManager.savedListsDetailPage().displayedAddedItemInExistingList();
		Log.info("pnumberOnSavedList is " + pnumberOnSavedList);
		Log.info("pnumberOnPLPPage is " + pnumberOnPLPPage);
		Assert.assertEquals(pnumberOnPLPPage, pnumberOnSavedList);
	}

	@Test(priority = 12, description="Add To Cart From Saved List")
	public void addToCartFromSavedList() throws Exception
	{
		//	WaitTool.hardWait();
		pageManager.savedListsDetailPage().clickonFirstAddToCartbtn();
		pageManager.homePage().clickOnShoppingCartIcon();
	}

	@Test(priority = 13, description="Continue To Checkout Page")
	public void NavigateToAddPaymentAndCheckoutPage() throws Exception
	{
		pageManager.shoppingCartPage().clickonCheckOutButton();
	}

	@Test(priority = 14, description="Place web order")
	public void placeWebOrder() throws Exception{
		pageManager.paymentAndCheckOutPage().clickOnChargeHDSupplyAccountRadioButton();
		pageManager.paymentAndCheckOutPage().insertPONumber();
		pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
	}

	@Test(priority = 15, description="Capture Web Order Number",enabled=false)
	public void captureWebOrderNumber() throws Exception{
		String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
		System.out.println("orderNumber is "+ orderNumber);
	}


}
