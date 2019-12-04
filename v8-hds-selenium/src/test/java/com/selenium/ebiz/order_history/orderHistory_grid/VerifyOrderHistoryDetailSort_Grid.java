/**
 * @author Bhavani
 * <p>
 * FMQA-2375 Verify Order History Detail Sort
 * <p>
 * ALM Test Instance ID: 649216
 * <p>
 * modified: Iuliia
 */
package com.selenium.ebiz.order_history.orderHistory_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class VerifyOrderHistoryDetailSort_Grid extends BaseClassV8_ParallelGrid {

    /**
     *  Verifying the add to Cart from PLP List View
     * @throws Exception
     */
	/*
	Disabled due tot the issue: FMQAECOMM-208
	 */
    @Test(dataProvider = "browsers")
    public void orderHistory_VerifyOrderHistoryDetailSort(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        pageManager.ordersPage().isDisplayedOrderspageHeading();

        pageManager.ordersPage().isDisplayedorderHistorySortOptionsDropdown();
        pageManager.ordersPage().isDisplayedorderHistoryFilterDaysDropdown();
        pageManager.ordersPage().isDisplayedorderHistorySearchFilterDropdown();

        pageManager.ordersPage().placedOnDefaultVal.isSelected();
        pageManager.ordersPage().ninetyDaysDefaultVal.isSelected();
        pageManager.ordersPage().salesOrderNumberDefaultVal.isSelected();

        //pageManager.ordersPage().isSelectedAllSortOptions();
        pageManager.ordersPage().isSelectedAllSortOptionsFromDropDown();

        pageManager.ordersPage().isSelectedAllDaysFromDropDown();

        pageManager.ordersPage().isSelectedAllFilterSearchFromDropDown();

        pageManager.ordersPage().clickOnFirstOrderNumberInOrdersPage();
        Assert.assertTrue(pageManager.ordersHistoryDetailsPage().isDisplayedOrderHistoryDetailsTitle());
    }


}
