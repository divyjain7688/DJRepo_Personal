package com.selenium.ebiz.add_to_cart.addToCart_grid;

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
 * @author Divy Jain
 * FMQA-2448  Verify Rich Relevance Recommendation section
 * ALM Test Instance ID: 649411
 * modified: Iuliia
 */
public class VerifyRichRelevanceRecommendationsection_Grid extends BaseClassV8_ParallelGrid {

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers", enabled = false)
    public void addtocart_NavigateToPLPPageUsingSearchAndVerifyRichRelevance(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Log.info("Login");

        usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        Assert.assertTrue(pageManager.productListingPage().richRelevanceThroughSearch.isDisplayed());
        Assert.assertTrue(pageManager.productListingPage().isAddToCartUnderRichRelevanceDisplayed());
        Assert.assertTrue(pageManager.productListingPage().isPriceUnderRichRelevanceDisplayed());
    }

    @Test(dataProvider = "browsers", enabled = false)
    public void addtocart_NavigateToPLPPageUsingNavigationAndVerifyRichRelevance(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.homePage().moveToSubCategoryPage();
        Assert.assertTrue(pageManager.productListingPage().isRichRelevanceDisplayed());
        Assert.assertTrue(pageManager.productListingPage().isAddToCartUnderRichRelevanceDisplayed());
        Assert.assertTrue(pageManager.productListingPage().isPriceUnderRichRelevanceDisplayed());
    }
}
