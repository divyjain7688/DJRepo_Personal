package com.selenium.ebiz.add_to_list.addToList_nonParallelTests;
/**
 * @author Divy Jain
 * <p>
 * FMQA-2369  Verify Add Items to Saved List from Product Listing Pages Grid and List View
 * <p>
 * ALM Test Instance ID: 649221
 */

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyAddItemsToSavedListFromPLPGridAndListView extends BaseClassV8_Parallel {

    public String newListName = "List_", newlistcreated, newlistdisplayed, displayedProductPartNumber, displayedQuantity;

    @Test(description = "Login")
    public void testLogin() {
        LoginToHDS(
                RandomAccountSelect.users.pop(), configread.getPassword());
        Assert.assertTrue(pageManager.loginPage().loggedAccountNumberText.isDisplayed());
    }

    @Test(dependsOnMethods = {"testLogin"}, description = "Search First Product By keyword And Navigate To PLP Grid View")
    public void test_searchFirstProductByKeywordAndNavigateToPLPGridView() throws Exception {
        GetUserList("searchByKeywordOrPartNumber", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
    }

    @Test(dependsOnMethods = {"test_searchFirstProductByKeywordAndNavigateToPLPGridView"}, description = "Select First Product From PLP Grid View And Add To New List")
    public void test_addFirstProductFromPLPGridViewToNewList() throws Exception {
        displayedProductPartNumber = pageManager.productListingPage().getFirstProductPartNumber();
        displayedQuantity = pageManager.productListingPage().getFirstProductQuantity();
        pageManager.productListingPage().clickOnProductAddToList(0);
        pageManager.addToExistingORCreateNewList_modal().isAddToExistingOrCreateNewListTitleTextDisplayed();
        newlistcreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
    }

    @Test(dependsOnMethods = {"test_addFirstProductFromPLPGridViewToNewList"}, description = "Verify First Product Added From PLP Grid View To New List")
    public void test_verifyFirstProductAddedFromPLPGridViewToNewList() throws Exception {
        pageManager.homePage().clickSavedListUtilityBar();
        pageManager.savedListsPage().recentlyUpdatedLink.click();
        newlistdisplayed = pageManager.savedListsPage().getNewlyCreatedList();
        Assert.assertEquals(newlistcreated, newlistdisplayed);
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(displayedProductPartNumber));
    }

    @Test(dependsOnMethods = {"test_verifyFirstProductAddedFromPLPGridViewToNewList"}, description = "Search Second Product By keyword And Navigate To PLP Grid View")
    public void test_searchSecondProductByKeywordAndNavigateToPLPGridView() throws Exception {
        GetUserList("searchByKeywordOrPartNumber", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
    }

    @Test(dependsOnMethods = {"test_searchSecondProductByKeywordAndNavigateToPLPGridView"}, description = "Select Second Product From PLP Grid View And Add To Newly Created List")
    public void test_addSecondProductFromPLPGridViewToNewlyCreatedList() throws Exception {
        displayedProductPartNumber = pageManager.productListingPage().getSecondProductPartNumber();
        displayedQuantity = pageManager.productListingPage().getSecondProductQuantity();
        pageManager.productListingPage().clickOnProductAddToList(1);
        //clickOnSecondProductAddToList();
        pageManager.addToExistingORCreateNewList_modal().isAddToExistingOrCreateNewListTitleTextDisplayed();
        pageManager.addToExistingORCreateNewList_modal().addItemToExistingList();
    }

    @Test(dependsOnMethods = {"test_addSecondProductFromPLPGridViewToNewlyCreatedList"}, description = "verify Second Product Added From PLP Grid view to New list")
    public void test_verifySecondProductAddedFromPLPGridViewToExistingList() throws Exception {
        pageManager.homePage().clickSavedListUtilityBar();
        pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(displayedProductPartNumber));
    }


    @Test(dependsOnMethods = {"test_verifySecondProductAddedFromPLPGridViewToExistingList"}, description = "Search First Product By keyword And Navigate To PLP List View")
    public void test_searchtProductByKeywordAndNavigateToPLPListView() throws Exception {
        GetUserList("searchByKeywordOrPartNumber", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().clickOnListView();
    }

    @Test(dependsOnMethods = {"test_searchtProductByKeywordAndNavigateToPLPListView"}, description = "Select First Product From PLP List View And Add To New List")
    public void test_addFirstProductFromPLPListViewToNewList() throws Exception {
        displayedProductPartNumber = pageManager.productListingPage().getFirstProductPartNumberTEXTFromListView();
        displayedQuantity = pageManager.productListingPage().getFirstProductQuantityFromListView();
        pageManager.productListingPage().clickOnProductAddToListFromListViewByInt(0);
        pageManager.addToExistingORCreateNewList_modal().isAddToExistingOrCreateNewListTitleTextDisplayed();
        newlistcreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
    }

    @Test(dependsOnMethods = {"test_addFirstProductFromPLPListViewToNewList"}, description = "Verify First Product Added From PLP List View To New List")
    public void test_verifyFirstProductAddedFromPLPListViewToNewList() throws Exception {
        pageManager.homePage().clickSavedListUtilityBar();
        pageManager.savedListsPage().recentlyUpdatedLink.click();
        newlistdisplayed = pageManager.savedListsPage().getNewlyCreatedList();
        Assert.assertEquals(newlistcreated, newlistdisplayed);
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(displayedProductPartNumber));
    }

    @Test(dependsOnMethods = {"test_verifyFirstProductAddedFromPLPListViewToNewList"}, description = "Search Second Product By keyword And Navigate To PLP List View")
    public void test_searchSecondProductByKeywordAndNavigateToPLPListView() throws Exception {
        GetUserList("searchByKeywordOrPartNumber", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().clickOnListView();
    }

    @Test(dependsOnMethods = {"test_searchSecondProductByKeywordAndNavigateToPLPListView"}, description = "Select Second Product From PLP List View And Add To Newly Created List")
    public void test_addSecondProductFromPLPListViewToNewlyCreatedList() throws Exception {
        displayedProductPartNumber = pageManager.productListingPage().getSecondProductPartNumberFromListView();
        displayedQuantity = pageManager.productListingPage().getSecondProductQuantityFromListView();
        pageManager.productListingPage().clickOnProductAddToListFromListViewByInt(1);
        pageManager.addToExistingORCreateNewList_modal().isAddToExistingOrCreateNewListTitleTextDisplayed();
        pageManager.addToExistingORCreateNewList_modal().addItemToExistingList();
    }

    @Test(dependsOnMethods = {"test_addSecondProductFromPLPListViewToNewlyCreatedList"}, description = "verify Second Product Added From PLP List view to New list")
    public void test_verifySecondProductAddedFromPLPListViewToExistingList() throws Exception {
        pageManager.homePage().clickSavedListUtilityBar();
        pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(displayedProductPartNumber));
    }
}
