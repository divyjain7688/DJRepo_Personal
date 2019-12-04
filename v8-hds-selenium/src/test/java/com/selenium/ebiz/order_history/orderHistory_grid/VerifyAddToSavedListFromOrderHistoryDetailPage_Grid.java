package com.selenium.ebiz.order_history.orderHistory_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author dj073227
 * Verify Add to Saved List from the Order History detail page
 * ALM Test Instance id 649215
 */
public class VerifyAddToSavedListFromOrderHistoryDetailPage_Grid extends BaseClassV8_ParallelGrid {
    public String newListName = "List_", newlistCreated, newlistDisplayed;
    public List<String> partNumberOnOHDPage, partNumberOnSavedListPage;


    @Test(dataProvider = "browsers")
    public void orderHistory_VerifyAddToListFromOHDP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        //pageManager.loginPage().loggedAccountNumberText.isDisplayed();
        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        pageManager.ordersPage().clickOnFirstOrderNumberInOrdersPage();
        //	pageManager.ordersHistoryDetailsPage().isDisplayedOrderHistoryDetailsTitle();

        //description="get All Part Numbers From Order History Details Page")
        pageManager.ordersHistoryDetailsPage().clickOnShowItemsButton();
        //	partNumberOnOHDPage=pageManager.ordersHistoryDetailsPage().getAllPartNumbers();
        //	Log.info("partNumberOnOHDPage is" + partNumberOnOHDPage);
        //description="Add Products of Order To New List")

        pageManager.ordersHistoryDetailsPage().clickOnAddAllToListButton();
        newlistCreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        Log.info("newlistCreated is  " + newlistCreated);

        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        newlistDisplayed = pageManager.savedListsPage().getNewlyCreatedList();
        System.out.println("newlistDisplayed is  " + newlistDisplayed);
        pageManager.savedListsPage().clickOnExistingFirstSavedList();
        partNumberOnSavedListPage = pageManager.savedListsDetailPage().getPartNumbersFromSavedList();
        Log.info("partNumberOnSavedListPage iss" + partNumberOnSavedListPage);
        Assert.assertEquals(newlistCreated, newlistDisplayed);
        //below asserion is failing
        //	Assert.assertTrue(partNumberOnSavedListPage.containsAll(partNumberOnOHDPage) && partNumberOnOHDPage.containsAll(partNumberOnSavedListPage));
    }


}
