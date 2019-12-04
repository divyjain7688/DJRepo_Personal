/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-1 [1]Add to List From Compare Page as non SUMA user - Page Redirection
 * <p>
 * ALM Test Instance ID: 649409
 */
package com.selenium.ebiz.compareProducts.compareProducts_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class AddToListFromComparePageAsNonSUMAUserPageRedirection_Grid extends BaseClassV8_ParallelGrid {

    public String newListName = "List_";
    public String existingListName1, existingListName2, partNumFromCompareProducts;
    public String firstCompareProduct, secondCompareProduct;
    public String newlistcreated1, newlistcreated2;
    int max = 3;

    @Test(description = "Verify Compare Checkboxes Displayed ", dataProvider = "browsers", enabled = false)
	/*
	Disabled until the issue fixed: FMQAECOMM-1
	 */
    public void compProd_AddToListFromComparePageAsNonSUMAUserPageRedirection_Grid
            (String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().isGridViewDisplayed();

        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().clickCompareTheseButton();
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();

        pageManager.compareTheseItems().addToListInsideFirstComparisonTile.click();
        pageManager.signInOrRegisterPage().signInOrRegisterTitle.isDisplayed();

        pageManager.commonLogin().signIn(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();

        firstCompareProduct = pageManager.compareTheseItems().getPartNumbers(0);
        Log.info("firstCompareProduct: " + firstCompareProduct);
        pageManager.compareTheseItems().addToListInsideFirstComparisonTile.click();
        pageManager.addToExistingORCreateNewList_modal().isAddToExistingOrCreateNewListTitleTextDisplayed();

        //firstCompareProduct = pageManager.compareTheseItems().getPartNumbers(0);
        //pageManager.compareTheseItems().clickOnAddToListButton(0);
        newlistcreated1 = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();

        secondCompareProduct = pageManager.compareTheseItems().getPartNumbers(1);
        Log.info("secondCompareProduct: " + secondCompareProduct);
        pageManager.compareTheseItems().clickOnAddToListButton(1);
        newlistcreated2 = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();
        pageManager.compareTheseItems().isAddToListInsideFirstComparisonTileDisplayed();
        pageManager.compareTheseItems().clickOnAddToListButton(0);
        existingListName1 = pageManager.addToExistingORCreateNewList_modal().addItemExistingList();
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();
        pageManager.compareTheseItems().clickOnAddToListButton(1);
        existingListName2 = pageManager.addToExistingORCreateNewList_modal().addItemExistingList();
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();

        //int beforeRemoveTile = pageManager.compareTheseItems().getNoOfAddAnotherProductTiles();
        //Log.info("beforeRemoveTile: " + beforeRemoveTile);
        pageManager.compareTheseItems().clickRemoveLinkInsideFirstTileDisplayed();
        //Log.info("After del: " + pageManager.compareTheseItems().numberOfComparisonTiles() +"    "+"Before Del: "+  max);
        //int afterRemoveTile = pageManager.compareTheseItems().getNoOfAddAnotherProductTiles();
        //Assert.assertNotEquals(pageManager.compareTheseItems().numberOfComparisonTiles(), max);
        //Assert.assertNotEquals(beforeRemoveTile, afterRemoveTile);
        //Assert.assertTrue(condition);

        pageManager.compareTheseItems().clickBackToSearchLink();
        pageManager.productListingPage().isGridViewDisplayed();

        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnList(newlistcreated1);
        String newlistcreated1Part = pageManager.savedListsDetailPage().getPartNumNewlyCreatedList();
        Log.info("newlistcreated1Part: " + newlistcreated1Part);
        Assert.assertEquals(newlistcreated1Part, firstCompareProduct);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnList(newlistcreated2);
        String newlistcreated2Part = pageManager.savedListsDetailPage().getPartNumNewlyCreatedList();
        Log.info("newlistcreated2Part: " + newlistcreated2Part);
        Assert.assertEquals(newlistcreated2Part, secondCompareProduct);

        pageManager.savedListsPage().clickOnList(existingListName1);
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(firstCompareProduct));

        pageManager.savedListsPage().clickOnList(existingListName1);
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(secondCompareProduct));
    }


}
