package com.selenium.ebiz.add_to_list.addToList_grid;
/**
 * @author Iuliia
 * <p>
 * FMQA-2370 Verify Search Results For Keyword Search_Add To Saved List
 * <p>
 * ALM Test Instance ID: 649220
 */

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class VerifySearchResultsForKeywordSearch_AddToSavedList_Grid extends BaseClassV8_ParallelGrid {

    public String newListName, searchKeyw, displayedPartNumber;
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void addtolist_AddToNewListFromSearchWithValidKeyword(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        //Assert.assertTrue(pageManager.homePage().isDisplayedLeftNavgation());
        usersList = pageManager.dBCon().loadDataFromExcel("searchWithValidKeyword", "Search");
        searchKeyw = usersList.get(0).getSearchProductKeyword();
        pageManager.homePage().searchByKeywordOrPartNumber(searchKeyw);
        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.productListingPage().clickFirstProductInProductList();
        displayedPartNumber = pageManager.productDetailsPage().getDisplayedPartNumber();
        Log.info(displayedPartNumber);
        pageManager.productDetailsPage().clickAddToListButton();
        pageManager.addToExistingORCreateNewList_modal().isDisplayedExistingOrNewTabsOnAddToListModal();
        String newlistcreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        String newlistdisplayed = pageManager.savedListsPage().getNewlyCreatedList();
        Log.info("Newlistdisplayed is: " + newlistdisplayed + "  " + "Newlistcreated is " + newlistcreated);
        Assert.assertEquals(newlistcreated, newlistdisplayed);
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(displayedPartNumber));
    }

    @Test(dataProvider = "browsers")
    public void addtolist_test_AddToNewExistingListFromSearchWithValidKeyword(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchWithValidKeyword", "Search");
        searchKeyw = usersList.get(0).getSearchProductKeyword();
        pageManager.homePage().searchByKeywordOrPartNumber(searchKeyw);
        pageManager.productListingPage().clickFirstProductInProductList();
        displayedPartNumber = pageManager.productDetailsPage().getDisplayedPartNumber();
        Log.info(displayedPartNumber);
        pageManager.productDetailsPage().clickAddToListButton();
        pageManager.addToExistingORCreateNewList_modal().WaitForAddToListExistingTabDisplayed();
        pageManager.addToExistingORCreateNewList_modal().addItemToExistingList();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(displayedPartNumber));
    }
}
