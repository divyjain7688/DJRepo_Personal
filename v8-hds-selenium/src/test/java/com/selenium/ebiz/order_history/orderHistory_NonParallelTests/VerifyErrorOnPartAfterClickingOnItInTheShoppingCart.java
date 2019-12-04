package com.selenium.ebiz.order_history.orderHistory_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Iuliia
 * <p>
 * FMQAECOMM-20 : Order History - Verify Error On Part After Clicking On It In The ShoppingCart
 * <p>
 * ALM Test Instance ID: 649217
 */

public class VerifyErrorOnPartAfterClickingOnItInTheShoppingCart extends BaseClassV8_Parallel {
    private String firstProductNumber, secondPN, thirdPN, fourthPN, partNumberOnFrequentlyPurchased;
    private String newListName = "List_";


    @Test
    public void test_LoginAndAddProductsTOCart() throws Exception {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        //pageManager.loginPage().loggedAccountNumberText.isDisplayed();
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.homePage().clickOnQuickOrderLink();
        pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad();
        GetUserList("addProductsUsingQuickOrder", "QuickOrder");
        firstProductNumber = usersList.get(0).getPartNumber1();
        thirdPN = usersList.get(0).getPartNumber3();
        pageManager.quickOrderPad().fillFirstPartNumberTextBox(firstProductNumber);
        //	Assert.assertEquals(firstProductNumber, pageManager.quickOrderPad().firstPartNumberTextBoxFilledValue());
    }

    @Test(dependsOnMethods = {"test_LoginAndAddProductsTOCart"})
    public void test_VerifyPartAddedToCartAndClickOnPDP() throws Exception {

        // The method throws the error
        pageManager.quickOrderPad().clickOnAddToCartButton();
        // pageManager.quickOrderPad().addToCartButton.click();
        pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(firstProductNumber);
        pageManager.shoppingCartPage().productsImages.get(0).click();
        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        Assert.assertTrue(pageManager.productDetailsPage().getDisplayedPartNumber().contains(firstProductNumber));
    }

    @Test(dependsOnMethods = {"test_VerifyPartAddedToCartAndClickOnPDP"})
    public void test_AddMorePartsFromPDP() throws Exception {
        pageManager.shoppingCartPage().checkClearShoppingCart();
        GetUserList("addProductsUsingQuickOrder", "QuickOrder");
        secondPN = usersList.get(0).getPartNumber2();
        pageManager.homePage().searchByKeywordOrPartNumber(secondPN);
        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        pageManager.productDetailsPage().clickAddToCartButton();
        pageManager.homePage().clickOnShoppingCartIcon();
        Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(secondPN));
    }

    @Test(dependsOnMethods = {"test_AddMorePartsFromPDP"})
    public void test_VerifySecondPartAddedToCartAndClickOnPDP() {
        pageManager.shoppingCartPage().productsImages.get(0).click();
        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        Assert.assertTrue(pageManager.productDetailsPage().getDisplayedPartNumber().contains(secondPN));
    }

    @Test(dependsOnMethods = {"test_VerifySecondPartAddedToCartAndClickOnPDP"})
    public void test_AddMorePartsToSavedList() throws Exception {
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.homePage().clickOnQuickOrderLink();
        pageManager.quickOrderPad().fillFirstPartNumberTextBox(thirdPN);
        pageManager.quickOrderPad().clickAddTolist();
        pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().isDisplayedSavedListspageHeadingText();
        pageManager.savedListsPage().clickOnRecentlyUpdatedLink();
        pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(thirdPN);

        pageManager.savedListsDetailPage().clickonFirstAddToCartbtn();
        pageManager.homePage().clickOnShoppingCartIcon();
        Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(thirdPN));
    }

    @Test(dependsOnMethods = {"test_AddMorePartsToSavedList"})
    public void test_VerifyThirdPartAddedToCartAndClickOnPDP() {
        pageManager.shoppingCartPage().productsImages.get(0).click();
        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        Assert.assertTrue(pageManager.productDetailsPage().getDisplayedPartNumber().contains(thirdPN));
    }

    @Test(dependsOnMethods = {"test_VerifyThirdPartAddedToCartAndClickOnPDP"})
    public void test_AddMorePartsFromoOrderHistoryPage() throws Exception {
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        pageManager.ordersPage().isDisplayedOrderspageHeading();
        try {
            pageManager.ordersPage().clickOnFirstOrderNumberInOrdersPage();
            fourthPN = pageManager.ordersHistoryDetailsPage().getFirstPartNumber();
            Log.info("fourthPN: " + fourthPN);
            pageManager.ordersHistoryDetailsPage().clickOnFirstAddToCartButton();
            pageManager.homePage().clickOnShoppingCartIcon();
            pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(fourthPN);
            pageManager.shoppingCartPage().productsImages.get(0).click();
            Assert.assertTrue(pageManager.productDetailsPage().getDisplayedPartNumber().contains(fourthPN));
        } catch (Exception e) {
            System.out.println("No orders found");
        }

    }

    @Test(dependsOnMethods = {"test_AddMorePartsFromoOrderHistoryPage"})
    public void test_AddMorePartsFromFrequentlyPurchased() throws Exception {
        pageManager.homePage().clickFrePurchasedUtilityBar();
        pageManager.frequentlyPurchasedPage().frequentlyPurchasedpageHeadingText.isDisplayed();
        partNumberOnFrequentlyPurchased = pageManager.frequentlyPurchasedPage().listProductPartNumbers.get(0).getText();
        pageManager.frequentlyPurchasedPage().clickOnFirstProductDisplayed();
        Assert.assertTrue(pageManager.productDetailsPage().getDisplayedPartNumber().contains(partNumberOnFrequentlyPurchased));
    }


}
