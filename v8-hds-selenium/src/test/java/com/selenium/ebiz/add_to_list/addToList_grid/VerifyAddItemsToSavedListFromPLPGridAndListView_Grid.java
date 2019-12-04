package com.selenium.ebiz.add_to_list.addToList_grid;
/**
 * @author Divy Jain
 * <p>
 * FMQA-2369  Verify Add Items to Saved List from Product Listing Pages Grid and List View
 * <p>
 * ALM Test Instance ID: 649221
 * <p>
 * modified: Iuliia
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

public class VerifyAddItemsToSavedListFromPLPGridAndListView_Grid extends BaseClassV8_ParallelGrid {

    private String newListName = "List_";
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void addtolist_addFirstProductFromPLPGridViewToNewList(String browser, String version, String os, Method method) throws Exception {
       String displayedProductPartNumber=null;
    	this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        displayedProductPartNumber = pageManager.productListingPage().getFirstProductPartNumber();
        System.out.println("addtolist_addFirstProductFromPLPGridViewToNewList displayedProductPartNumber" + displayedProductPartNumber);
        pageManager.productListingPage().clickOnProductAddToList(0);
        pageManager.addToExistingORCreateNewList_modal().createNewListInAddToListModal();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(displayedProductPartNumber));
    }

    @Test(dataProvider = "browsers")
    public void addtolist_searchSecondProductByKeywordAndAddToExistingListFromPLPGridView(String browser, String version, String os, Method method) throws Exception {
    	String displayedProductPartNumber=null;
    	this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        System.out.println("addtolist_searchSecondProductByKeywordAndAddToExistingListFromPLPGridView search part is "+ usersList.get(0).getSearchProductKeyword());
        displayedProductPartNumber = pageManager.productListingPage().getSecondProductPartNumber();
        System.out.println("addtolist_searchSecondProductByKeywordAndAddToExistingListFromPLPGridView displayedProductPartNumber is "+ displayedProductPartNumber);
        pageManager.productListingPage().clickOnProductAddToList(1);
        //clickOnSecondProductAddToList();
        pageManager.addToExistingORCreateNewList_modal().addItemToExistingList();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(displayedProductPartNumber));
    }


    @Test(dataProvider = "browsers")
            //description = "Search First Product By keyword And Add To New List from PLP List View")
    public void addtolist_searchtProductByKeywordAndAddToListFromPLPListView(String browser, String version, String os, Method method) throws Exception {
    	String displayedProductPartNumber=null;
    	this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().clickOnListView();
        displayedProductPartNumber = pageManager.productListingPage().getFirstProductPartNumberTEXTFromListView();
        pageManager.productListingPage().clickOnProductAddToListFromListViewByInt(0);
        pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(displayedProductPartNumber));
    }

    @Test(dataProvider = "browsers")
    public void addtolist_searchSecondProductByKeywordAndAddToExistingListFromPLPListView(String browser, String version, String os, Method method) throws Exception {
    	String displayedProductPartNumber=null;
    	this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        System.out.println("addtolist_searchSecondProductByKeywordAndAddToExistingListFromPLPListView search part is "+ usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().clickOnListView();
        displayedProductPartNumber = pageManager.productListingPage().getSecondProductPartNumberFromListView();
        System.out.println("addtolist_searchSecondProductByKeywordAndAddToExistingListFromPLPListView displayedProductPartNumber is "+ displayedProductPartNumber);
        pageManager.productListingPage().clickOnProductAddToListFromListViewByInt(1);
        pageManager.addToExistingORCreateNewList_modal().addItemToExistingList();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnNewlyCreatedList();

        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(displayedProductPartNumber));
    }
}
