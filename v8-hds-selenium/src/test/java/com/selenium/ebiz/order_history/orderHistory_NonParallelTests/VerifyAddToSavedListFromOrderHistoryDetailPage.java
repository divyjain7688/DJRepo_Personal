package com.selenium.ebiz.order_history.orderHistory_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author dj073227
 * Verify Add to Saved List from the Order History detail page
 * ALM Test Instance id 649215
 */
public class VerifyAddToSavedListFromOrderHistoryDetailPage extends BaseClassV8_Parallel {
    public String newListName = "List_", newlistCreated, newlistDisplayed;
    public List<String> partNumberOnOHDPage, partNumberOnSavedListPage;

    @Test(description = "Login")
    public void testLogin() {
        //  username = RandomAccountSelect.users.pop();
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Assert.assertTrue(pageManager.loginPage().loggedAccountNumberText.isDisplayed());
    }

    @Test(dependsOnMethods = {"testLogin"}, description = "Navigate To Order History Details Page")
    public void navigateToOrderHistoryDetailPage() throws Exception {
        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        pageManager.ordersPage().clickOnFirstOrderNumberInOrdersPage();
        Assert.assertTrue(pageManager.ordersHistoryDetailsPage().isDisplayedOrderHistoryDetailsTitle());
    }

    @Test(dependsOnMethods = {"navigateToOrderHistoryDetailPage"}, description = "get All Part Numbers From Order History Details Page")
    public void getAllPartNumbersFromOHDPage() {
        pageManager.ordersHistoryDetailsPage().clickOnShowItemsButton();
        partNumberOnOHDPage = pageManager.ordersHistoryDetailsPage().getAllPartNumbers();
        System.out.println("partNumberOnOHDPage iss" + partNumberOnOHDPage);

    }

    @Test(dependsOnMethods = {"getAllPartNumbersFromOHDPage"}, description = "Add Products of Order To New List")
    public void addProductsOfOrderToNewList() throws Exception {
        pageManager.ordersHistoryDetailsPage().clickOnAddAllToListButton();
        newlistCreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        System.out.println("newlistCreated is  " + newlistCreated);
    }

    @Test(dependsOnMethods = {"addProductsOfOrderToNewList"}, description = "Navigate To Saved List And Verify New List")
    public void verifyNewListOnSavedListPage() throws InterruptedException {
        pageManager.homePage().clickSavedListUtilityBar();
        newlistDisplayed = pageManager.savedListsPage().getNewlyCreatedList();
        System.out.println("newlistDisplayed is  " + newlistDisplayed);
        Assert.assertTrue(newlistCreated.equals(newlistDisplayed));

    }

    @Test(dependsOnMethods = {"verifyNewListOnSavedListPage"}, description = "get All Part Numbers From Saved List And Verify")
    public void getAllPartNumbersFromSavedListPage() {
        partNumberOnSavedListPage = pageManager.savedListsDetailPage().getPartNumbersFromSavedList();
        System.out.println("partNumberOnSavedListPage iss" + partNumberOnSavedListPage);
        Assert.assertTrue(partNumberOnSavedListPage.containsAll(partNumberOnOHDPage) && partNumberOnOHDPage.containsAll(partNumberOnSavedListPage));
    }


}
