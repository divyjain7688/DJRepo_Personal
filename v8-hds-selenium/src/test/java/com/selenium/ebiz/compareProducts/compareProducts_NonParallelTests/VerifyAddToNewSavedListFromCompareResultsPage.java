/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-5 [1]Verify Add to New Saved List from Compare Results Page
 * <p>
 * ALM Test Instance ID: 649417
 */
package com.selenium.ebiz.compareProducts.compareProducts_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyAddToNewSavedListFromCompareResultsPage extends BaseClassV8_Parallel {

    public String newListName = "List_";
    public String newlistcreated1, newlistcreated2, newlistcreated3, newlistcreated4;
    public String firstCompareProduct, secondCompareProduct, thirdCompareProduct, fourthCompareProduct;

    @Test(description = "Login")
    public void testLogin() throws Exception {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
    }

    @Test(dependsOnMethods = {"testLogin"}, description = "Search by Product Description")
    public void test_SearchByProductDesc() throws Exception {
        GetUserList("searchByProdDesc", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
    }

    @Test(dependsOnMethods = {"test_SearchByProductDesc"}, description = "Verify Navigated To Compare Products Page")
    public void verifyNavigatedToCompareProductsPage() throws Exception {
        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().clickonFourthCheckbox();
        pageManager.productListingPage().clickCompareTheseButton();
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"verifyNavigatedToCompareProductsPage"}, description = " Verify First Item Added To New List")
    public void verifyFirstItemAddedToNewList() throws Exception {
        firstCompareProduct = pageManager.compareTheseItems().getPartNumbers(0);
        Log.info("firstCompareProduct: " + firstCompareProduct);
        pageManager.compareTheseItems().clickOnAddToListButton(0);
        newlistcreated1 = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"verifyFirstItemAddedToNewList"}, description = " Verify Second Item Added To New List")
    public void verifySecondItemAddedToNewList() throws Exception {
        secondCompareProduct = pageManager.compareTheseItems().getPartNumbers(1);
        Log.info("secondCompareProduct: " + secondCompareProduct);
        pageManager.compareTheseItems().clickOnAddToListButton(1);
        newlistcreated2 = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"verifySecondItemAddedToNewList"}, description = "Verify Third Item Added To New List")
    public void verifyThirdItemAddedToNewList() throws Exception {
        thirdCompareProduct = pageManager.compareTheseItems().getPartNumbers(2);
        Log.info("secondCompareProduct: " + secondCompareProduct);

        pageManager.compareTheseItems().clickOnAddToListButton(2);
        newlistcreated3 = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"verifyThirdItemAddedToNewList"}, description = "Verify Fourth Item Added To New List")
    public void verifyFourthItemAddedToNewList() throws Exception {
        fourthCompareProduct = pageManager.compareTheseItems().getPartNumbers(3);
        Log.info("secondCompareProduct: " + secondCompareProduct);
        pageManager.compareTheseItems().clickOnAddToListButton(3);
        newlistcreated4 = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"verifyFourthItemAddedToNewList"}, description = "Verify First Compare Item Added To Saved List")
    public void verifyFirstCompareItemAddedToSavedList() throws Exception {
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        // pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().clickOnList(newlistcreated1);
        String newlistcreated1Part = pageManager.savedListsDetailPage().getPartNumNewlyCreatedList();
        Log.info("newlistcreated1Part: " + newlistcreated1Part);
        Assert.assertEquals(newlistcreated1Part, firstCompareProduct);
    }

    @Test(dependsOnMethods = {"verifyFirstCompareItemAddedToSavedList"}, description = "Verify Second Compare Item Added To Saved List")
    public void verifySecondCompareItemAddedToSavedList() throws Exception {
        //pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().clickOnList(newlistcreated2);
        String newlistcreated2Part = pageManager.savedListsDetailPage().getPartNumNewlyCreatedList();
        Log.info("newlistcreated2Part: " + newlistcreated2Part);
        Assert.assertEquals(newlistcreated2Part, secondCompareProduct);
    }

    @Test(dependsOnMethods = {"verifySecondCompareItemAddedToSavedList"}, description = "Verify Third Compare Item Added To Saved List")
    public void verifyThirdCompareItemAddedToSavedList() throws Exception {
        //pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().clickOnList(newlistcreated3);
        String newlistcreated3Part = pageManager.savedListsDetailPage().getPartNumNewlyCreatedList();
        Log.info("newlistcreated3Part: " + newlistcreated3Part);
        Assert.assertEquals(newlistcreated3Part, thirdCompareProduct);
    }

    @Test(dependsOnMethods = {"verifyThirdCompareItemAddedToSavedList"}, description = "Verify Fourth Compare Item Added To Saved List")
    public void verifyFourthCompareItemAddedToSavedList() throws Exception {
        //pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().clickOnList(newlistcreated4);
        String newlistcreated4Part = pageManager.savedListsDetailPage().getPartNumNewlyCreatedList();
        Log.info("newlistcreated4Part: " + newlistcreated4Part);
        Assert.assertEquals(newlistcreated4Part, fourthCompareProduct);
    }

    @Test(dependsOnMethods = {"verifyFourthCompareItemAddedToSavedList"}, description = "Logout")
    public void testLogout() throws Exception {
        pageManager.loginPage().logoutOfApplication();

    }

}
