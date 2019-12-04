package com.selenium.ebiz.quickCheckout;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class AddItemToQuickCheckoutFromPDP extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Iuliia
    mapped with: W80-5932
	 */

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")

    public void quickCheckout_AddItemToQuickCheckoutFromPDP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
        String pdpPartNumber = pageManager.productDetailsPage().getDisplayedPartNumber();
        pageManager.productDetailsPage().clickOnQuickCheckOutButton();
        pageManager.quickCheckout().isQuickCheckoutPageTitleDisplayed();
        Assert.assertTrue(pageManager.quickCheckout().isAddedPartNumberDisplayed(pdpPartNumber));
    }
}
