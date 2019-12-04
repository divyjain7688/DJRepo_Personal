/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-1 [1]Add to List From Compare Page as non SUMA user - Page Redirection
 * <p>
 * ALM Test Instance ID: 649409
 */
package com.selenium.ebiz.compareProducts.compareProducts_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddToListFromComparePageAsNonSUMAUserPageRedirection extends BaseClassV8_Parallel {

    public String newListName = "List_";
    public String existingListName1, existingListName2, partNumFromCompareProducts;
    public String firstCompareProduct, secondCompareProduct;
    public String newlistcreated1, newlistcreated2;
    int max = 3;

    @Test(description = "Verify Compare Checkboxes Displayed ")
    public void verifyCompareCheckboxesDisplayed() throws Exception {
        pageManager.homePage().moveToSubCategoryPage();
        Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
    }

    @Test(dependsOnMethods = {"verifyCompareCheckboxesDisplayed"}, description = "Verify Navigated To Compare Products Page")
    public void verifyNavigatedToCompareProductsPage() throws Exception {
        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().clickCompareTheseButton();
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"verifyNavigatedToCompareProductsPage"}, description = " Verify Sign In Or Register Page")
    public void verifySignInOrRegisterPage() throws Exception {
        pageManager.compareTheseItems().addToListInsideFirstComparisonTile.click();
        Assert.assertTrue(pageManager.signInOrRegisterPage().signInOrRegisterTitle.isDisplayed());

    }

    @Test(dependsOnMethods = {"verifySignInOrRegisterPage"}, description = " Enter Valid Credentials")
    public void enterValidCredentials() throws Exception {
        pageManager.signInOrRegisterPage().loginToFromBrowsePage(RandomAccountSelect.users.pop(), configread.getPassword());
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"enterValidCredentials"}, description = " Verify Add To New List Modal Window")
    public void verifyAddToNewListModalWindow() throws Exception {
        firstCompareProduct = pageManager.compareTheseItems().getPartNumbers(0);
        Log.info("firstCompareProduct: " + firstCompareProduct);
        pageManager.compareTheseItems().addToListInsideFirstComparisonTile.click();
        Assert.assertTrue(pageManager.addToExistingORCreateNewList_modal().isAddToExistingOrCreateNewListTitleTextDisplayed());

    }

    @Test(dependsOnMethods = {"verifyAddToNewListModalWindow"}, description = " Add First Item To New List")
    public void addFirstItemToNewList() throws Exception {
        //firstCompareProduct = pageManager.compareTheseItems().getPartNumbers(0);
        //pageManager.compareTheseItems().clickOnAddToListButton(0);
        newlistcreated1 = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"addFirstItemToNewList"}, description = " Add Second Item New List")
    public void addSecondItemToNewList() throws Exception {
        secondCompareProduct = pageManager.compareTheseItems().getPartNumbers(1);
        Log.info("secondCompareProduct: " + secondCompareProduct);
        pageManager.compareTheseItems().clickOnAddToListButton(1);
        newlistcreated2 = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"addSecondItemToNewList"}, description = " Add First Item To Existing List")
    public void addFirstItemToExistingList() throws Exception {
        pageManager.compareTheseItems().isAddToListInsideFirstComparisonTileDisplayed();
        pageManager.compareTheseItems().clickOnAddToListButton(0);
        existingListName1 = pageManager.addToExistingORCreateNewList_modal().addItemExistingList();
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());

    }

    @Test(dependsOnMethods = {"addFirstItemToExistingList"}, description = " Add Second Item To Existing List")
    public void AddSecondItemToExistingList() throws Exception {
        pageManager.compareTheseItems().clickOnAddToListButton(1);
        existingListName2 = pageManager.addToExistingORCreateNewList_modal().addItemExistingList();
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());

    }

    //@Test(dependsOnMethods ={"AddSecondItemToExistingList"}, description=" Verify Item Removed From Compare Products Page")
    public void verifyRemoveFirstItemFromCompareProductsPage() throws Exception {
        //int beforeRemoveTile = pageManager.compareTheseItems().getNoOfAddAnotherProductTiles();
        //Log.info("beforeRemoveTile: " + beforeRemoveTile);
        pageManager.compareTheseItems().clickRemoveLinkInsideFirstTileDisplayed();
        //Log.info("After del: " + pageManager.compareTheseItems().numberOfComparisonTiles() +"    "+"Before Del: "+  max);
        //int afterRemoveTile = pageManager.compareTheseItems().getNoOfAddAnotherProductTiles();
        //Assert.assertNotEquals(pageManager.compareTheseItems().numberOfComparisonTiles(), max);
        //Assert.assertNotEquals(beforeRemoveTile, afterRemoveTile);
        //Assert.assertTrue(condition);
    }

    //@Test(dependsOnMethods ={"verifyRemoveFirstItemFromCompareProductsPage"}, description=" Verify Click Back Search Results PLP")
    public void verifyClickBackSearchResultsPLP() throws Exception {
        pageManager.compareTheseItems().clickBackToSearchLink();
        Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());

    }

    @Test(dependsOnMethods = {"AddSecondItemToExistingList"}, description = "Verify First Compare Item Added To New Saved List")
    public void verifyFirstCompareItemAddedToNewSavedList() throws Exception {
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().clickOnList(newlistcreated1);
        String newlistcreated1Part = pageManager.savedListsDetailPage().getPartNumNewlyCreatedList();
        Log.info("newlistcreated1Part: " + newlistcreated1Part);
        Assert.assertEquals(newlistcreated1Part, firstCompareProduct);
    }

    @Test(dependsOnMethods = {"verifyFirstCompareItemAddedToNewSavedList"}, description = "Verify Second Compare Item Added To Saved List")
    public void verifySecondCompareItemAddedToNewSavedList() throws Exception {
        pageManager.savedListsPage().clickOnList(newlistcreated2);
        String newlistcreated2Part = pageManager.savedListsDetailPage().getPartNumNewlyCreatedList();
        Log.info("newlistcreated2Part: " + newlistcreated2Part);
        Assert.assertEquals(newlistcreated2Part, secondCompareProduct);
    }

    @Test(dependsOnMethods = {"verifySecondCompareItemAddedToNewSavedList"}, description = " Verify First Item Added To Existing List")
    public void verifyFirstItemAddedToExistingList() throws Exception {
        pageManager.savedListsPage().clickOnList(existingListName1);
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(firstCompareProduct));
    }

    @Test(dependsOnMethods = {"verifyFirstItemAddedToExistingList"}, description = " Verify Second Item Added To Existing List")
    public void verifySecondItemAddedToExistingList() throws Exception {
        pageManager.savedListsPage().clickOnList(existingListName1);
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(secondCompareProduct));
    }

    @Test(dependsOnMethods = {"verifySecondItemAddedToExistingList"}, description = "Logout")
    public void testLogout() throws Exception {
        pageManager.loginPage().logoutOfApplication();

    }


}
