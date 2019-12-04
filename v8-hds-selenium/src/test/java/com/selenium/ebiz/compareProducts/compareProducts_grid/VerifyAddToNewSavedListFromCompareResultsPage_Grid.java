/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-5 [1]Verify Add to New Saved List from Compare Results Page
 * <p>
 * ALM Test Instance ID: 649417
 * <p>
 * Modified: Iuliia
 */
package com.selenium.ebiz.compareProducts.compareProducts_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;


public class VerifyAddToNewSavedListFromCompareResultsPage_Grid extends BaseClassV8_ParallelGrid {

    public String newListName = "List_";
    public String newlistcreated1, newlistcreated2, newlistcreated3, newlistcreated4;
    public String firstCompareProduct, secondCompareProduct, thirdCompareProduct, fourthCompareProduct;
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
	/*
	Disabled due to the Saved list changes
	 */
    public void compProd__VerifyAddToNewSavedListFromCompareResultsPage(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().clickonFourthCheckbox();
        pageManager.productListingPage().clickCompareTheseButton();
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();
        firstCompareProduct = pageManager.compareTheseItems().getPartNumbers(0);
        Log.info("firstCompareProduct: " + firstCompareProduct);
        pageManager.compareTheseItems().clickOnAddToListButton(0);
        newlistcreated1 = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();
        secondCompareProduct = pageManager.compareTheseItems().getPartNumbers(1);
        Log.info("secondCompareProduct: " + secondCompareProduct);
        pageManager.compareTheseItems().clickOnAddToListButton(1);
        newlistcreated2 = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();

        thirdCompareProduct = pageManager.compareTheseItems().getPartNumbers(2);
        Log.info("secondCompareProduct: " + secondCompareProduct);

        pageManager.compareTheseItems().clickOnAddToListButton(2);
        newlistcreated3 = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();

        fourthCompareProduct = pageManager.compareTheseItems().getPartNumbers(3);
        Log.info("secondCompareProduct: " + secondCompareProduct);
        pageManager.compareTheseItems().clickOnAddToListButton(3);
        newlistcreated4 = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();

        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        // pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().clickOnList(newlistcreated1);
        String newlistcreated1Part = pageManager.savedListsDetailPage().getPartNumNewlyCreatedList();
        Log.info("newlistcreated1Part: " + newlistcreated1Part);
        //  Assert.assertEquals(newlistcreated1Part,firstCompareProduct);
        //pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnList(newlistcreated2);
        String newlistcreated2Part = pageManager.savedListsDetailPage().getPartNumNewlyCreatedList();
        Log.info("newlistcreated2Part: " + newlistcreated2Part);
        //   Assert.assertEquals(newlistcreated2Part,secondCompareProduct);

        //pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnList(newlistcreated3);
        String newlistcreated3Part = pageManager.savedListsDetailPage().getPartNumNewlyCreatedList();
        Log.info("newlistcreated3Part: " + newlistcreated3Part);
        // Assert.assertEquals(newlistcreated3Part,thirdCompareProduct);

        //pageManager.savedListsPage().recentlyUpdatedLink.click();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnList(newlistcreated4);
        String newlistcreated4Part = pageManager.savedListsDetailPage().getPartNumNewlyCreatedList();
        Log.info("newlistcreated4Part: " + newlistcreated4Part);
        Assert.assertEquals(newlistcreated4Part, fourthCompareProduct);
        Assert.assertEquals(newlistcreated1Part, firstCompareProduct);
        Assert.assertEquals(newlistcreated2Part, secondCompareProduct);
        Assert.assertEquals(newlistcreated3Part, thirdCompareProduct);
    }


}
