package com.selenium.ebiz.add_to_list.addToList_grid;
/**
 * @author Iuliia
 * <p>
 * FMQA-2371 Verify Add All To Saved List From Shopping Cart Page
 * <p>
 * ALM Test Instance ID: 649228
 * <p>
 * modified: 2/8/2019
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
import java.util.Arrays;

public class VerifyAddAllToSavedListFromShoppingCartPage_Grid extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;


    @Test(dataProvider = "browsers")
    //description = "Verify the part numbers on the New saved list matches the part numbers on the shopping cart page")

    public void addtolist_CreateNewListAndVerifyListWasCreatedWithAddedParts(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        pageManager.quickOrderPad().addTwoDifferentProductsUsingQuickOrder();
        pageManager.quickOrderPad().clickAddTolist();
        pageManager.addToExistingORCreateNewList_modal().createNewListInAddToListModal();
        //pageManager.shoppingCartPage().clickOnQuickOrderLink();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(usersList.get(0).getPartNumber1()));
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(usersList.get(0).getPartNumber2()));
    }

    @Test(dataProvider = "browsers", enabled = false)
   //         description = "Verify the prices on the New saved list matches the prices on the shopping cart page", invocationCount = 10)
    public void addtolist_CreateNewListAndVerifyListWasCreatedWithAddedPrices(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        pageManager.quickOrderPad().addTwoDifferentProductsUsingQuickOrder();
        pageManager.quickOrderPad().clickOnAddToCartButton();
        String[] shoppingcartPrices = {pageManager.shoppingCartPage().productPriceDisplayed.get(0).getText(),
                pageManager.shoppingCartPage().productPriceDisplayed.get(1).getText(),
                pageManager.shoppingCartPage().productPriceDisplayed.get(2).getText(),
                pageManager.shoppingCartPage().productPriceDisplayed.get(3).getText(),
                pageManager.shoppingCartPage().productPriceDisplayed.get(4).getText(),
                pageManager.shoppingCartPage().productPriceDisplayed.get(5).getText()};
        for (String l : shoppingcartPrices) {
            Log.info("shoppingCartPrices: " + l);
        }

        pageManager.shoppingCartPage().clickCreateOrEditSavedList();
        pageManager.addToExistingORCreateNewList_modal().createNewListInAddToListModal();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnNewlyCreatedList();

        String[] savedlistPrices = {pageManager.savedListsDetailPage().displayedPartPrices.get(0).getText(),
                pageManager.savedListsDetailPage().displayedPartPrices.get(1).getText(),
                pageManager.savedListsDetailPage().displayedPartPrices.get(2).getText(),
                pageManager.savedListsDetailPage().displayedPartPrices.get(3).getText(),
                pageManager.savedListsDetailPage().displayedPartPrices.get(4).getText(),
                pageManager.savedListsDetailPage().displayedPartPrices.get(5).getText()};
        for (String l : savedlistPrices) {
            Log.info("savedlistPrices " + l);
        }
        Arrays.sort(savedlistPrices, String.CASE_INSENSITIVE_ORDER);
        Arrays.sort(shoppingcartPrices, String.CASE_INSENSITIVE_ORDER);
        Assert.assertEquals(savedlistPrices, shoppingcartPrices);


    }


    @Test(dataProvider = "browsers")
            //description = "Add Products Into Existing List and Verify The Parts are matched")
    public void addtolist_AddProductsFromQuickOrderPad_AddToList_VerifyPartNumbers(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.shoppingCartPage().clickOnQuickOrderLink();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().addTwoDifferentProductsUsingQuickOrder();
        pageManager.quickOrderPad().clickOnAddToCartButton();
        pageManager.shoppingCartPage().clickCreateOrEditSavedList();
        pageManager.addToExistingORCreateNewList_modal().addItemToExistingList();
        pageManager.common().refresh();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnNewlyCreatedList();
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(usersList.get(0).getPartNumber1()));
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(usersList.get(0).getPartNumber2()));
    }


}