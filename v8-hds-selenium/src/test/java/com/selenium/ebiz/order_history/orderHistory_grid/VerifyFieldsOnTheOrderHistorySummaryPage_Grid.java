/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-3 : Order History - Order History Summary - Verify fields on the Order History Summary Page
 * <p>
 * ALM Test Instance ID: 649214
 * Modified: Iuliia
 */
package com.selenium.ebiz.order_history.orderHistory_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class VerifyFieldsOnTheOrderHistorySummaryPage_Grid extends BaseClassV8_ParallelGrid {

	String orderNumber, totalFromSCP, totalFromOHDP, firstOrderNum;
	int noOfOrders;


	@Test(dataProvider = "browsers")
	public void orderHistory_VerifyPaginationOnTheOrderHistorySummaryPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickAccountLinkText();
		pageManager.myAccountPage().isOrdersLinkDisplayed();
	
		pageManager.homePage().isDisplayedTopHeaderOrderHistoryStatusLink();
		pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
		pageManager.ordersPage().isDisplayedOrderspageHeading();

		Boolean paginationRightTop = pageManager.ordersPage().paginationRight.get(0).isDisplayed();
		Boolean paginationRightBottom = pageManager.ordersPage().paginationRight.get(1).isDisplayed();
		Log.info("Verified Pagination");

		Assert.assertTrue(paginationRightTop);
		Assert.assertTrue(paginationRightBottom);
	}

	@Test(dataProvider = "browsers")
	public void orderHistory_VerifySearchOnTheOrderHistorySummaryPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

		pageManager.homePage().isDisplayedTopHeaderOrderHistoryStatusLink();
		pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
		pageManager.ordersPage().isDisplayedOrderspageHeading();

		firstOrderNum = pageManager.ordersPage().getFirstOrderNumberInOrdersPage();
		pageManager.ordersPage().ordersSearchField.isDisplayed();

		pageManager.ordersPage().enterOrderNumberInSearchField(firstOrderNum);
		pageManager.ordersPage().clickOrdersSearchButton();
		noOfOrders = pageManager.ordersPage().getNoOfOrdersAfterSearch();

		String searchedOrderNum = pageManager.ordersPage().getOrderNumberAfterSearch();
		
		Assert.assertEquals(noOfOrders, 1);
		Assert.assertEquals(searchedOrderNum, firstOrderNum);

	}

	@Test(dataProvider = "browsers")
	public void orderHistory_VerifyColumnHeadingsOnTheOrderHistorySummaryPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

		pageManager.homePage().isDisplayedTopHeaderOrderHistoryStatusLink();
		pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
		pageManager.ordersPage().isDisplayedOrderspageHeading();

		/*Verify Column Headers on Orders Page*/
		Assert.assertTrue(pageManager.ordersPage().orderNumberHeading.isDisplayed());
		Assert.assertTrue(pageManager.ordersPage().poNumberHeading.isDisplayed());
		Assert.assertTrue(pageManager.ordersPage().totalChargeHeading.isDisplayed());
		Assert.assertTrue(pageManager.ordersPage().placedOnHeading.isDisplayed());
		Assert.assertTrue(pageManager.ordersPage().statusHeading.isDisplayed());
		Assert.assertTrue(pageManager.ordersPage().shippedToHeading.isDisplayed());
	}
	
	@Test(dataProvider = "browsers")
	public void orderHistory_VerifyTabHeadersOnTheOrderHistorySummaryPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

		pageManager.homePage().isDisplayedTopHeaderOrderHistoryStatusLink();
		pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
		pageManager.ordersPage().isDisplayedOrderspageHeading();
		
		/* Verify Tab Headers on Orders Page */
		Assert.assertTrue(pageManager.ordersPage().openHeadingLink.isDisplayed());
		Assert.assertTrue(pageManager.ordersPage().cancelledHeadingLink.isDisplayed());
		Assert.assertTrue(pageManager.ordersPage().allHeadingLink.isDisplayed());
		Log.info("Verified column tabs");
	}
	
	@Test(dataProvider = "browsers")
	public void orderHistory_VerifyDropdownOnTheOrderHistorySummaryPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

		pageManager.homePage().isDisplayedTopHeaderOrderHistoryStatusLink();
		pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
		pageManager.ordersPage().isDisplayedOrderspageHeading();
		/* Verify Dropdowns on Orders Page */
		Assert.assertTrue(pageManager.ordersPage().isDisplayedorderHistorySortOptionsDropdown());
		Assert.assertTrue(pageManager.ordersPage().isDisplayedorderHistoryFilterDaysDropdown());
		Assert.assertTrue(pageManager.ordersPage().isDisplayedorderHistorySearchFilterDropdown());
		Log.info("Verified dropdowns");


	}

}
