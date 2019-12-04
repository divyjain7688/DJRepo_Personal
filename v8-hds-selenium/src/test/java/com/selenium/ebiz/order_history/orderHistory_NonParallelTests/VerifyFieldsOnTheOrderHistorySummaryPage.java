/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-3 : Order History - Order History Summary - Verify fields on the Order History Summary Page
 * <p>
 * ALM Test Instance ID: 649214
 */
package com.selenium.ebiz.order_history.orderHistory_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyFieldsOnTheOrderHistorySummaryPage extends BaseClassV8_Parallel {

    String orderNumber, totalFromSCP, totalFromOHDP, firstOrderNum;
    int noOfOrders;

    /**
     *  Verifying the add to Cart from PLP List View
     * @throws Exception
     */

    @Test(description = "Login")
    public void Login() throws Exception {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
    }

    @Test(dependsOnMethods = {"Login"}, description = "Clear Cart")
    public void clearCart() throws Exception {
        pageManager.shoppingCartPage().checkClearShoppingCart();
        Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());

    }

    @Test(dependsOnMethods = {"clearCart"}, description = "Verify Orders On My Account Page")
    public void verifyOrdersOnMyAccountPage() throws Exception {
        pageManager.homePage().clickAccountLinkText();
        Assert.assertTrue(pageManager.myAccountPage().isOrdersLinkDisplayed());
    }

    @Test(dependsOnMethods = {"verifyOrdersOnMyAccountPage"}, description = "Verify Header Order History Status Link")
    public void verifyHeaderOrderHistoryStatusLink() throws Exception {
        Assert.assertTrue(pageManager.homePage().isDisplayedTopHeaderOrderHistoryStatusLink());
    }

    @Test(dependsOnMethods = {"verifyHeaderOrderHistoryStatusLink"}, description = "Verify Orders Page")
    public void verifyOrdersPage() throws Exception {
        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        Assert.assertTrue(pageManager.ordersPage().isDisplayedOrderspageHeading());

    }

    @Test(dependsOnMethods = {"verifyOrdersPage"}, description = "Verify Pagination on Orders Page")
    public void verifyPaginationOnOrderPage() throws Exception {
        Assert.assertTrue(pageManager.ordersPage().paginationRight.get(0).isDisplayed());
        Assert.assertTrue(pageManager.ordersPage().paginationRight.get(1).isDisplayed());
        Log.info("Verified Pagination");

    }

    @Test(dependsOnMethods = {"verifyPaginationOnOrderPage"}, description = "Verify Orders Search Field")
    public void verifyOrdersSearchField() throws Exception {
        firstOrderNum = pageManager.ordersPage().getFirstOrderNumberInOrdersPage();
        Assert.assertTrue(pageManager.ordersPage().ordersSearchField.isDisplayed());
    }

    @Test(dependsOnMethods = {"verifyOrdersSearchField"}, description = "Verify No. Of Orders After Search")
    public void verifyNoOfOrdersAfterSearch() throws Exception {
        pageManager.ordersPage().enterOrderNumberInSearchField(firstOrderNum);
        pageManager.ordersPage().clickOrdersSearchButton();
        noOfOrders = pageManager.ordersPage().getNoOfOrdersAfterSearch();
        Assert.assertEquals(noOfOrders, 1);

    }

    @Test(dependsOnMethods = {"verifyNoOfOrdersAfterSearch"}, description = "Verify Searched Order Num")
    public void verifySearchedOrderNum() throws Exception {
        String searchedOrderNum = pageManager.ordersPage().getOrderNumberAfterSearch();
        Assert.assertEquals(searchedOrderNum, firstOrderNum);

    }

    @Test(dependsOnMethods = {"verifySearchedOrderNum"}, description = "Verify Column Headers on Orders Page")
    public void verifyColumnHeadersOnOrderPage() throws Exception {
        Assert.assertTrue(pageManager.ordersPage().orderNumberHeading.isDisplayed());
        Assert.assertTrue(pageManager.ordersPage().poNumberHeading.isDisplayed());
        Assert.assertTrue(pageManager.ordersPage().totalChargeHeading.isDisplayed());
        Assert.assertTrue(pageManager.ordersPage().placedOnHeading.isDisplayed());
        Assert.assertTrue(pageManager.ordersPage().statusHeading.isDisplayed());
        Assert.assertTrue(pageManager.ordersPage().shippedToHeading.isDisplayed());

    }

    @Test(dependsOnMethods = {"verifyColumnHeadersOnOrderPage"}, description = "Verify Tab Headers on Orders Page")
    public void verifyTabHeaderOnOrderPage() throws Exception {
        Assert.assertTrue(pageManager.ordersPage().openHeadingLink.isDisplayed());
        Assert.assertTrue(pageManager.ordersPage().cancelledHeadingLink.isDisplayed());
        Assert.assertTrue(pageManager.ordersPage().allHeadingLink.isDisplayed());
        Log.info("Verified column tabs");

    }

    @Test(dependsOnMethods = {"verifyTabHeaderOnOrderPage"}, description = "Verify Dropdowns on Orders Page")
    public void verifyDropdownsOnOrderPage() throws Exception {
        Assert.assertTrue(pageManager.ordersPage().isDisplayedorderHistorySortOptionsDropdown());
        Assert.assertTrue(pageManager.ordersPage().isDisplayedorderHistoryFilterDaysDropdown());
        Assert.assertTrue(pageManager.ordersPage().isDisplayedorderHistorySearchFilterDropdown());
        Log.info("Verified dropdowns");
    }

}
