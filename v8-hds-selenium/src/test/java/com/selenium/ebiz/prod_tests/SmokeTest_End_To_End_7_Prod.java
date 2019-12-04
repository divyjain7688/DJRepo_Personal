package com.selenium.ebiz.prod_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest_End_To_End_7_Prod extends BaseClassV8_Parallel {

String pnumberOnPLPPage;
String username;



    @Test(description="Login To Application")
    public void testLogin() throws Exception {
        LoginToHDS(configread.getUserName(), configread.getPassword());
        pageManager.homePage().clickPropertyDropdown();
        pageManager.homePage().clickOnAccount0012482411UnderUser();
    }

    @Test(dependsOnMethods = {"testLogin"}, description="Verify Cart is empty")
    public void testClearCart() throws Exception{
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.homePage().hDSupplyLogoInHeader.click();
        Log.info("Checked the SC");
    }


    @Test(dependsOnMethods = {"testClearCart"},description="logout")
    public void logout() throws Exception
    {
        pageManager.homePage().clickOnSignOutIcon();
        Log.info("Logout");

    }

    @Test(dependsOnMethods = {"logout"}, description="Navigate to Product Listing Page")
    public void navigateToProductListingPage() throws Exception
    {
        pageManager.homePage().moveToSubCategoryPage();
        Log.info("Selected sub categories");

    }

    @Test(dependsOnMethods = {"navigateToProductListingPage"}, description="Add product To Cart")
    public void addProductToCartFromPLP() throws Exception
    {
        pnumberOnPLPPage = pageManager.productListingPage().getFirstProductPartNumber();
        pageManager.productListingPage().clickonFirstProductAddToCart();

    }


    @Test(dependsOnMethods = {"addProductToCartFromPLP"}, description="Login Via Header From Shopping Cart Page")
    public void loginFromShoppingCartPage() throws Exception
    {
        pageManager.loginPage().loginToHdSupplySite(username,configread.getPassword());
        Log.info(username);
        Assert.assertTrue(pageManager.loginPage().loggedAccountNumberText.isDisplayed());

    }

    @Test(dependsOnMethods = {"loginFromShoppingCartPage"}, description="Click On Add To List")
    public void clickOnAddToList()
    {
        pageManager.shoppingCartPage().clickAddToListButton();
        Assert.assertTrue(pageManager.shoppingCartPage().isAddToListModalWindowDisplayed());
    }

    @Test(dependsOnMethods = {"clickOnAddToList"}, description="Create New List")
    public void createNewList()
    {
        String newlist = "List_";
     //te method need to be modified:   pageManager.shoppingCartPage().createNewList(newlist);

    }

    @Test(dependsOnMethods = {"createNewList"}, description="Navigate To Saved List")
    public void navigateToSavedList()
    {
    	pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
    	pageManager.savedListsPage().clickSharedListt();
        pageManager.savedListsPage().clickOnExistingFirstSavedList();

    }


    @Test(dependsOnMethods = {"navigateToSavedList"}, description="Validate Product In Newly Created Saved List")
    public void validateProductInSavedList() throws Exception
    {
      //  pageManager.savedListsPage().displayedAddedItemInExistingList();
        String pnumberOnSavedList =   pageManager.savedListsDetailPage().displayedAddedItemInExistingList();
        System.out.println("pnumberOnSavedList is " + pnumberOnSavedList);
        System.out.println("pnumberOnPLPPage is " + pnumberOnPLPPage);
        Assert.assertEquals(pnumberOnPLPPage, pnumberOnSavedList);
    }

    @Test(dependsOnMethods = {"validateProductInSavedList"}, description="Add To Cart From Saved List")
    public void addToCartFromSavedList() throws Exception
    {
        pageManager.savedListsDetailPage().clickonFirstAddToCartbtn();
       // pageManager.savedListsPage().clickonCheckOutButton();
        pageManager.homePage().clickOnShoppingCartIcon();
    }

    @Test(dependsOnMethods = {"addToCartFromSavedList"}, description="Continue To Checkout Page")
    public void navigateToAddPaymentAndCheckoutPage() throws Exception
    {
        pageManager.shoppingCartPage().clickonCheckOutButton();
    }

    @Test(dependsOnMethods = {"navigateToAddPaymentAndCheckoutPage"}, description="Place web order")
    public void placeWebOrder() throws Exception{
        pageManager.paymentAndCheckOutPage().isDisplayedAddPaymentAndCheckoutTitle();
        pageManager.paymentAndCheckOutPage().clickOnChargeHDSupplyAccountRadioButton();
        pageManager.paymentAndCheckOutPage().insertPONumber();
        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
    }

    @Test(dependsOnMethods = {"placeWebOrder"}, description="Capture Web Order Number",enabled=false)
    public void captureWebOrderNumber() throws Exception{
        String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
        System.out.println("orderNumber is "+ orderNumber);
    }


}
