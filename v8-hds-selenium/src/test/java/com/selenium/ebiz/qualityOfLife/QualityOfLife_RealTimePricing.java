package com.selenium.ebiz.qualityOfLife;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class QualityOfLife_RealTimePricing extends BaseClassV8_ParallelGrid {

    /*
    designed by Iuliia
    mapped with QL-63
    User will be directed to Product Listing Page (PLP) where they can see part prices meaning RTP call is successful
     */

    public String newListName = "List_";
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void qualityOfLife_RealTimePricing(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().isDisplayedListView();
        Assert.assertTrue(pageManager.productListingPage().productPriceList.get(0).isDisplayed());
    }
}
