package com.selenium.ebiz.smoketest.smoke_parallel;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;


public class SmokeScenario_individualTests extends BaseClassV8_ParallelGrid {

    public String newListName="List_";
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers", description="Login")
    public void smoke_Login(String browser, String version, String os, Method method) throws Exception
    {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        Log.info("Running smoke_Login");

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        Assert.assertTrue(pageManager.loginPage().loggedAccountNumberText.isDisplayed());
    //    Assert.assertTrue(pageManager.homePage().isDisplayedLeftNavgation());

    }

    /**
     * This test is used to verify end to end happy path after any deployment.
     * This test solve the purpose of smoke test
     */

    @Test(dataProvider = "browsers", description="Check if Cart is Empty")
    public void smoke_ClearCart(String browser, String version, String os, Method method) throws Exception
    {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        Log.info("Running smoke Clear Cart");

        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");
    }


    @Test(description="Search by Product Number and Add Product to Cart from PDP", dataProvider = "browsers")
    public void smoke_SearchByProductNumberAddToCartFromPDP(String browser, String version, String os, Method method) throws Exception
    {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        Log.info("Running smoke_SearchByProductNumberAddToCartFromPDP");

        usersList=pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
        Log.info(usersList.get(0).getSearchProductPartNumber());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
    //    int beforeaddToCart = pageManager.homePage().getShoppingCartProductCount();
		pageManager.productDetailsPage().addToCartPDP();
	//	pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
	//	pageManager.homePage().clickOnShoppingCartIcon();
	//	Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(usersList.get(0).getSearchProductPartNumber()));
//		Assert.assertEquals(pageManager.homePage().getShoppingCartProductCount(),beforeaddToCart+1);
	}

    @Test(description="Search by Product Description and Add Product to Cart from PLP",dataProvider = "browsers")
    public void smoke_SearchByProductDescAndAddProductToCartFromPLP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        Log.info("Running smoke_SearchByProductDescAndAddProductToCartFromPLP");

        usersList=pageManager.dBCon().loadDataFromExcel("searchByProductDesc","Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().clickonFirstProductAddToCart();
    //    pageManager.homePage().clickOnShoppingCartIcon();

       // usersList = pageManager.dBCon().loadDataFromExcel("searchByProductDesc", "Search");
       // pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
       // Log.info(usersList.get(0).getSearchProductKeyword());
       // pageManager.productListingPage().isGridViewDisplayed();
       // pageManager.productListingPage().clickonFirstProductAddToCart();
       // pageManager.productListingPage().addToCartAndNavigateToSCP(0);
    }


    @Test(description="Add product using Quick Order Pad from SC page",dataProvider = "browsers")
    public void smoke_AddToCartFromQuickOrderPad(String browser, String version, String os, Method method) throws Exception
    {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        Log.info("Running smoke_AddToCartFromQuickOrderPad ");

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList= pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(),usersList.get(0).getQuantity1());
        Log.info(usersList.get(0).getPartNumber1());
        pageManager.quickOrderPad().clickOnAddToCartButton();
        Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(usersList.get(0).getPartNumber1()));

    }
    /*

    @Test(description="Add to Saved List from SC Page",dataProvider = "browsers")
    public void test_addToSavedListFromShoppingCart(String browser, String version, String os, Method method) throws Exception
    {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(),usersList.get(0).getQuantity1());
        pageManager.quickOrderPad().addToCartButton.click();
        pageManager.shoppingCartPage().clickCreateOrEditSavedList();
        pageManager.shoppingCartPage().isAddToExistingOrCreateNewListTitleTextDisplayed();
        Assert.assertTrue(pageManager.shoppingCartPage().addToListExistingTab.isDisplayed());
    }

    @Test(description="Creating New Saved List",dataProvider = "browsers")
    public void test_CreateNewSavedList(String browser, String version, String os, Method method) throws Exception
    {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(),usersList.get(0).getQuantity1());
        pageManager.quickOrderPad().clickAddTolist();
        pageManager.addToExistingORCreateNewList_modal().createNewListInAddToListModal();

    }

    @Test(description="Validate Print Bin Labels",dataProvider = "browsers")
    public void test_validatePrintBinLabels(String browser, String version, String os, Method method) throws Exception
    {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().clickOnPrintBinLabelsLink();
        Assert.assertTrue(pageManager.savedListsPage().isContactNumberOnBinLabelDisplayed());
        Assert.assertTrue(pageManager.savedListsPage().isProductDescriptionOnBinLabelDisplayed());
        Assert.assertTrue(pageManager.savedListsPage().isHDSPartTextOnBinLabelDisplayed());

    }
*/

    @Test(description = "Order placement end-to-end",dataProvider = "browsers")
    public void smoke_CreateTheOrderWithTwoDifferentParts(String browser, String version, String os, Method method) throws Exception
    {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        Log.info("Running smoke_CreateTheOrderWithTwoDifferentParts ");

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList=pageManager.dBCon().loadDataFromExcel("addDifferentProductsUsingQuickOrder", "QuickOrder");
        pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getPartNumber2(),usersList.get(0).getQuantity1());
        pageManager.shoppingCartPage().clickOnQuickOrderLink();

        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(),usersList.get(0).getQuantity1());
        pageManager.quickOrderPad().addToCartButton.click();
        pageManager.shoppingCartPage().clickonCheckOutButton();
        Log.info("Click Checkout btn on SC page");
        pageManager.paymentAndCheckOutPage().isPageTitleDisplayed();
        Log.info("Wait for Payment and Checkout page");
        pageManager.paymentAndCheckOutPage().VerifyPNAValuesIsDisplayed();
        pageManager.paymentAndCheckOutPage().insertPONumber();
        Log.info("*******Inserted PO number**********");
        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
        Log.info("Click submit secure order");
       /* String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
        Log.info("orderNumber is "+ orderNumber);
        Assert.assertTrue(pageManager.orderConfirmationPage().orderNumber.isDisplayed());*/

    }


}
