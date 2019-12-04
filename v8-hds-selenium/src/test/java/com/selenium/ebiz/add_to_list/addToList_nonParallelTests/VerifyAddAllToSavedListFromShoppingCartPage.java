package com.selenium.ebiz.add_to_list.addToList_nonParallelTests;
/**
 * @author Iuliia
 * <p>
 * FMQA-2371 Verify Add All To Saved List From Shopping Cart Page
 * <p>
 * ALM Test Instance ID: 649228
 */

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class VerifyAddAllToSavedListFromShoppingCartPage extends BaseClassV8_Parallel {


    private String newListName, firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber, sixNumber, shoppingCartPartsText;


    @Test()
    public void test_Login() {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Assert.assertTrue(pageManager.homePage().isDisplayedLeftNavgation());
    }

    @Test(dependsOnMethods = {"test_Login"})
    public void test_ClearShoppingCart() throws Exception {
        pageManager.shoppingCartPage().checkClearShoppingCart();
        // driver is already in the SC page, no need the validation of Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
    }

    @Test(dependsOnMethods = {"test_ClearShoppingCart"}, description = "Quick Order page should get displayed")
    public void test_VerifyQuickOrderPadIsDisplayed() throws Exception {
        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        Assert.assertTrue(pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad());
    }

    @Test(dependsOnMethods = {"test_VerifyQuickOrderPadIsDisplayed"}, description = "Add products to Shopping Cart")
    public void test_GetProductNumbersIntoQuickOrderForm() throws Exception {

        GetUserList("addDifferentProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstSixPartNumberTextBox(usersList.get(0).getPartNumber1(), usersList.get(0).getPartNumber2(), usersList.get(0).getPartNumber3(),
                usersList.get(0).getPartNumber4(), usersList.get(0).getPartNumber5(), usersList.get(0).getPartNumber6());

        firstNumber = usersList.get(0).getPartNumber1();
        secondNumber = usersList.get(0).getPartNumber2();
        thirdNumber = usersList.get(0).getPartNumber3();
        fourthNumber = usersList.get(0).getPartNumber4();
        fifthNumber = usersList.get(0).getPartNumber5();
        sixNumber = usersList.get(0).getPartNumber6();
        Log.info("first " + firstNumber + "__ second " + secondNumber + "_third " + thirdNumber + "_fourth " + fourthNumber + "_fifth " + fifthNumber + "_six " + sixNumber);

        Assert.assertEquals(firstNumber, pageManager.quickOrderPad().firstPartNumberTextBoxFilledValue());
        Assert.assertEquals(sixNumber, pageManager.quickOrderPad()._lastPartNumberTextBoxFilledValue());
    }

    @Test(dependsOnMethods = {"test_GetProductNumbersIntoQuickOrderForm"}, description = "Click Add To Cart from Quick Order Pad")
    public void test_AddProducts() throws Exception {

        // pageManager.quickOrderPad().addToCartButton.click();
        pageManager.quickOrderPad().clickOnAddToCartButton();
        shoppingCartPartsText = pageManager.shoppingCartPage().partNumberDisplayed_text.getText();
        Log.info("SC parts: " + shoppingCartPartsText);
    }

    @Test(dependsOnMethods = {"test_AddProducts"}, description = "Verify the displayed parts")
    public void test_VerifyPartsWereAddedIntoSC() throws Exception {

        String ItemsCountFromCart = pageManager.shoppingCartPage().getItemsCountFromCart();
        int displyedPartNumberText = pageManager.shoppingCartPage().displyedPartNumberText();
        String valueOfDisplyedPartNumberText = String.valueOf(displyedPartNumberText);
        Log.info(valueOfDisplyedPartNumberText + " and " + ItemsCountFromCart);
        Assert.assertEquals(valueOfDisplyedPartNumberText, ItemsCountFromCart);
    }

    @Test(dependsOnMethods = {"test_VerifyPartsWereAddedIntoSC"}, description = "Create New list And Verify List Was Created")
    public void test_CreateNewListAndVerifyListWasCreated() throws Exception {
        pageManager.shoppingCartPage().clickCreateOrEditSavedList();
        String newlistcreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        String newlistdisplayed = pageManager.savedListsPage().getNewlyCreatedList();
        Log.info("Newlistdisplayed is: " + newlistdisplayed + "  " + "Newlistcreated is " + newlistcreated);
        Assert.assertEquals(newlistcreated, newlistdisplayed);
    }

    @Test(dependsOnMethods = {"test_CreateNewListAndVerifyListWasCreated"}, description = "Verify the parts on the saved list matches the parts added on the shopping cart page")
    public void test_VerifyAddedPartsInSavedList() throws Exception {
        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        //pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(firstNumber));
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(secondNumber));
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(thirdNumber));
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(fourthNumber));
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(fifthNumber));
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(sixNumber));
    }

    @Test(dependsOnMethods = {"test_VerifyAddedPartsInSavedList"}, description = "Verify the prices on the saved list matches the prices added on the shopping cart page")
    public void test_VerifyPricesOfTheAddedPartsInSavedList() throws Exception {

        String[] savedlistPrices = {pageManager.savedListsDetailPage().displayedPartPrices.get(0).getText(),
                pageManager.savedListsDetailPage().displayedPartPrices.get(1).getText(),
                pageManager.savedListsDetailPage().displayedPartPrices.get(2).getText(),
                pageManager.savedListsDetailPage().displayedPartPrices.get(3).getText(),
                pageManager.savedListsDetailPage().displayedPartPrices.get(4).getText(),
                pageManager.savedListsDetailPage().displayedPartPrices.get(5).getText()};
        for (String l : savedlistPrices) {
            System.out.println("savedlistPrices " + l);
        }


        pageManager.homePage().clickOnShoppingCartIcon();

        String[] shoppingcartPrices = {pageManager.shoppingCartPage().productPriceDisplayed.get(0).getText(),
                pageManager.shoppingCartPage().productPriceDisplayed.get(1).getText(),
                pageManager.shoppingCartPage().productPriceDisplayed.get(2).getText(),
                pageManager.shoppingCartPage().productPriceDisplayed.get(3).getText(),
                pageManager.shoppingCartPage().productPriceDisplayed.get(4).getText(),
                pageManager.shoppingCartPage().productPriceDisplayed.get(5).getText()};
        for (String l : shoppingcartPrices) {
            System.out.println("shoppingCartPrices: " + l);
        }
        Arrays.sort(savedlistPrices, String.CASE_INSENSITIVE_ORDER);
        Arrays.sort(shoppingcartPrices, String.CASE_INSENSITIVE_ORDER);
        Assert.assertEquals(savedlistPrices, shoppingcartPrices);


    }

    @Test(dependsOnMethods = {"test_VerifyPricesOfTheAddedPartsInSavedList"}, description = "Add Products Into Existing List and select an existing list name")
    public void test_AddProductsIntoQuickOrderPad() throws Exception {

        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        GetUserList("addDifferentProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstSixPartNumberTextBox(usersList.get(0).getPartNumber1(), usersList.get(0).getPartNumber2(), usersList.get(0).getPartNumber3(),
                usersList.get(0).getPartNumber4(), usersList.get(0).getPartNumber5(), usersList.get(0).getPartNumber6());

        Assert.assertEquals(firstNumber, pageManager.quickOrderPad().firstPartNumberTextBoxFilledValue());
        Assert.assertEquals(usersList.get(0).getQuantity1(), pageManager.quickOrderPad().firstQuantityTextBoxFilledValue());
        Assert.assertEquals(sixNumber, pageManager.quickOrderPad()._lastPartNumberTextBoxFilledValue());

    }

    @Test(dependsOnMethods = {"test_AddProductsIntoQuickOrderPad"}, description = "Navigate into existing list")
    public void test_NavigateIntoExistingListList() throws Exception {

        //  pageManager.quickOrderPad().addToCartButton.click();
        pageManager.quickOrderPad().clickOnAddToCartButton();
        // shoppingCartPartsText = pageManager.shoppingCartPage().partNumberDisplayed_text.getText();
        pageManager.shoppingCartPage().clickCreateOrEditSavedList();
        pageManager.addToExistingORCreateNewList_modal().addItemToExistingList();
        // WebDriver driver = this.getDriver();
        // .refresh(driver);
        // driver.navigate().refresh();
        pageManager.common().refresh();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();

    }

    @Test(dependsOnMethods = {"test_NavigateIntoExistingListList"}, description = "Verify Parts Are Matched")
    public void test_VerifyPartsAreAddedToTheExistingList() throws Exception {

        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(firstNumber));
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(secondNumber));
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(thirdNumber));
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(fourthNumber));
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(fifthNumber));
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(sixNumber));

    }


}