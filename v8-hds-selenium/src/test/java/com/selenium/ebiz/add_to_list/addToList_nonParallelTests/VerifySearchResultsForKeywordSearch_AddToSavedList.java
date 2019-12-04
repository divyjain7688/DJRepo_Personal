package com.selenium.ebiz.add_to_list.addToList_nonParallelTests;
/**
 * @author Iuliia
 * <p>
 * FMQA-2370 Verify Search Results For Keyword Search_Add To Saved List
 * <p>
 * ALM Test Instance ID: 649220
 */

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySearchResultsForKeywordSearch_AddToSavedList extends BaseClassV8_Parallel {


    String newListName, searchKeyw, displayedPartNumber;

    @Test()
    public void test_Login() {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Assert.assertTrue(pageManager.homePage().isDisplayedLeftNavgation());

    }

    @Test(dependsOnMethods = {"test_Login"})
    public void test_EnterValidKeywordInSeach() throws Exception {
        GetUserList("searchWithValidKeyword", "Search");
        searchKeyw = usersList.get(0).getSearchProductKeyword();
        pageManager.homePage().searchByKeywordOrPartNumber(searchKeyw);
        Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
    }

    @Test(dependsOnMethods = {"test_EnterValidKeywordInSeach"})
    public void test_SelectTheProductAndAddToList() throws Exception {
        pageManager.productListingPage().clickFirstProductInProductList();
        displayedPartNumber = pageManager.productDetailsPage().getDisplayedPartNumber();
        Log.info(displayedPartNumber);
        pageManager.productDetailsPage().clickAddToListButton();
        Assert.assertTrue(pageManager.addToExistingORCreateNewList_modal().isDisplayedExistingOrNewTabsOnAddToListModal());
    }

    @Test(dependsOnMethods = {"test_SelectTheProductAndAddToList"})
    public void test_CreateNewList() {

        String newlistcreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().recentlyUpdatedLink.click();
        String newlistdisplayed = pageManager.savedListsPage().getNewlyCreatedList();
        Log.info("Newlistdisplayed is: " + newlistdisplayed + "  " + "Newlistcreated is " + newlistcreated);
        Assert.assertEquals(newlistcreated, newlistdisplayed);
    }

    @Test(dependsOnMethods = {"test_CreateNewList"})
    public void test_VerifyPartDetailsAtNewList() {
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(displayedPartNumber));
    }

    @Test(dependsOnMethods = {"test_VerifyPartDetailsAtNewList"})
    public void test_AddItemIntoExistingList() throws Exception {
        pageManager.homePage().searchByKeywordOrPartNumber(searchKeyw);
        pageManager.productListingPage().clickFirstProductInProductList();
        pageManager.productDetailsPage().clickAddToListButton();
        pageManager.addToExistingORCreateNewList_modal().WaitForAddToListExistingTabDisplayed();
        pageManager.addToExistingORCreateNewList_modal().addItemToExistingList();
    }

    @Test(dependsOnMethods = {"test_AddItemIntoExistingList"})
    public void test_VerifyPartDetailsOnExistingList() throws Exception {
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(displayedPartNumber));
    }
}
