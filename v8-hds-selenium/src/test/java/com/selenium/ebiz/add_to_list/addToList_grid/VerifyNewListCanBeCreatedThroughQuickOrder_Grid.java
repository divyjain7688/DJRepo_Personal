package com.selenium.ebiz.add_to_list.addToList_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Iuliia Shaposhnikov
 * <p>
 * FMQAECOMM-29  VerifyNewListCanBeCreatedThroughQuickOrder
 * <p>
 * ALM Test Instance ID: 649219
 * <p>
 * modified: Iuliia
 */

public class VerifyNewListCanBeCreatedThroughQuickOrder_Grid extends BaseClassV8_ParallelGrid {

    public String newListName = "List_", newlistcreated, secondNumber, thirdNumber;
    ;
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
            //, description = "Add Product To New List From HomePage QuickOrderPad")
    public void addtolist_AddProductToNewListFromHomePageQuickOrder(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickOnQuickOrderLink();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(), usersList.get(0).getQuantity1());
        pageManager.quickOrderPad().clickAddTolist();
        newlistcreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        String newlistdisplayed = pageManager.savedListsPage().getNewlyCreatedList();
        Assert.assertEquals(newlistcreated, newlistdisplayed);
        Log.info("Newlistdisplayed is: " + newlistdisplayed + "  " + "Newlistcreated is " + newlistcreated);
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(usersList.get(0).getPartNumber1()));

    }


    @Test(dataProvider = "browsers")
    public void addtolist_AddSecondPartInHomePageOrderPadAndAddToExistingList(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickOnQuickOrderLink();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        secondNumber = usersList.get(0).getPartNumber2();
        pageManager.quickOrderPad().fillFirstPartNumberTextBox(secondNumber);
        pageManager.quickOrderPad().clickAddTolist();
        pageManager.addToExistingORCreateNewList_modal().addItemToExistingList();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(secondNumber));
    }

    @Test(dataProvider = "browsers")

    public void addtolist_AddThirdPartToExistingListFromQuickOrderPad(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickOnQuickOrderLink();
        pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad();
        pageManager.quickOrderPad().clickAddMoreRowsFirstTime();
        pageManager.quickOrderPage().isDisplayedQuickOrderPageHeadingText();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        thirdNumber = usersList.get(0).getPartNumber3();
        pageManager.quickOrderPage().fillFirstPartNumberTextBox(thirdNumber);
        pageManager.quickOrderPage().addToListButton.click();
        pageManager.addToExistingORCreateNewList_modal().addItemToExistingList();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(thirdNumber));
    }


}
