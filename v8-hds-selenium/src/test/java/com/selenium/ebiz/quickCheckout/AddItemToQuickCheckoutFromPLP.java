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

public class AddItemToQuickCheckoutFromPLP extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Bhavani
    mapped with: W80-5933/FMQAECOMM-726
	 */

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void quickCheckout_AddItemToQuickCheckoutFromPLP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().isPlpHeadingTextDisplayed();
        
        String plpPartNumber = pageManager.productListingPage().getFirstProductPartNumber();
        Log.info(plpPartNumber);
        pageManager.productListingPage().clickOnFirstQuickCheckOutButton();
        
        pageManager.quickCheckout().isQuickCheckoutPageTitleDisplayed();
        Assert.assertTrue(pageManager.quickCheckout().isAddedPartNumberDisplayed(plpPartNumber));
    }
}
