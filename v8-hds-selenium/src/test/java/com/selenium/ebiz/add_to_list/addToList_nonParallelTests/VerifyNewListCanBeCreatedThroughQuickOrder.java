package com.selenium.ebiz.add_to_list.addToList_nonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Iuliia Shaposhnikov
 * <p>
 * FMQAECOMM-29  VerifyNewListCanBeCreatedThroughQuickOrder
 * <p>
 * ALM Test Instance ID: 649219
 */

public class VerifyNewListCanBeCreatedThroughQuickOrder extends BaseClassV8_Parallel {
    String firstNumber, secondNumber, thirdNumber;
    public String newListName = "List_";

    @Test()
    public void test_Login() throws Exception {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().isDisplayedLeftNavgation();
    }

    @Test(dependsOnMethods = {"test_Login"}, description = "Add products to HomePage Quick Pad")
    public void test_AddProductToHomePageQuickOrder() throws Exception {
        pageManager.homePage().clickOnQuickOrderLink();
        pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad();
        GetUserList("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstPartNumberTextBox(usersList.get(0).getPartNumber1());
        firstNumber = usersList.get(0).getPartNumber1();
        Log.info(firstNumber.equals(pageManager.quickOrderPad().firstPartNumberTextBoxFilledValue()));

    }

    @Test(dependsOnMethods = {"test_AddProductToHomePageQuickOrder"}, description = "AddProductToTheNewList")
    public void test_AddToNewListFromSavedListModal() throws Exception {
        pageManager.quickOrderPad().clickAddTolist();
        pageManager.addToExistingORCreateNewList_modal().isAddToExistingOrCreateNewListTitleTextDisplayed();
        String newlistcreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);

        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().recentlyUpdatedLink.click();
        String newlistdisplayed = pageManager.savedListsPage().getNewlyCreatedList();
        Log.info("Newlistdisplayed is: " + newlistdisplayed + "  " + "Newlistcreated is " + newlistcreated);
        Assert.assertEquals(newlistcreated, newlistdisplayed);

    }

    @Test(dependsOnMethods = {"test_AddToNewListFromSavedListModal"}, description = "Verify product details at the saved list")
    public void test_VerifyProductDetailsAtSavedList() throws Exception {

        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(firstNumber));
    }

    @Test(dependsOnMethods = {"test_VerifyProductDetailsAtSavedList"})
    public void test_NavigateToHomePageQuickOrder() throws Exception {
        pageManager.homePage().clickOnQuickOrderLink();
        pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad();
        GetUserList("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstPartNumberTextBox(usersList.get(0).getPartNumber2());
        secondNumber = usersList.get(0).getPartNumber2();
        Log.info(firstNumber.equals(pageManager.quickOrderPad().firstPartNumberTextBoxFilledValue()));

    }

    @Test(dependsOnMethods = {"test_NavigateToHomePageQuickOrder"})
    public void test_AddToExistingListFromSavedListModal() throws Exception {
        pageManager.quickOrderPad().clickAddTolist();
        pageManager.addToExistingORCreateNewList_modal().isAddToExistingOrCreateNewListTitleTextDisplayed();
        pageManager.addToExistingORCreateNewList_modal().addItemToExistingList();
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(secondNumber));
    }

    @Test(dependsOnMethods = {"test_AddToExistingListFromSavedListModal"})
    public void test_NavigateToQuickOrderPage() throws Exception {
        pageManager.homePage().clickOnQuickOrderLink();
        pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad();
        pageManager.quickOrderPad().clickAddMoreRowsFirstTime();
        pageManager.quickOrderPage().isDisplayedQuickOrderPageHeadingText();
        GetUserList("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPage().fillFirstPartNumberTextBox(usersList.get(0).getPartNumber3());
        thirdNumber = usersList.get(0).getPartNumber3();
        Log.info(firstNumber.equals(pageManager.quickOrderPad().firstPartNumberTextBoxFilledValue()));
    }

    @Test(dependsOnMethods = {"test_NavigateToQuickOrderPage"})
    public void test_AddToExistingListFromQuickOrderPage() throws Exception {

        pageManager.quickOrderPage().addToListButton.click();
        pageManager.addToExistingORCreateNewList_modal().isAddToExistingOrCreateNewListTitleTextDisplayed();
        pageManager.addToExistingORCreateNewList_modal().addItemToExistingList();
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(thirdNumber));
    }


}
