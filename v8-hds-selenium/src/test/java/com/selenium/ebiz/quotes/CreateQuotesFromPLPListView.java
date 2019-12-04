package com.selenium.ebiz.quotes;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class CreateQuotesFromPLPListView extends BaseClassV8_ParallelGrid {
    ArrayList<UsersListBean> usersList;

    /* Designed by: Iuliia
     * Creating a new quote from PLP
     * WCS 8.0W80-2410
       W80-2170-01: Creating a new Quote from PLP
     */
    @Test(dataProvider = "browsers")
    public void quote_createNewQuoteFromPLPListView(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);


        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchByProductDesc", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        Log.info(usersList.get(0).getSearchProductKeyword());

        pageManager.productListingPage().clickOnListView();
        pageManager.productListingPage().gridListViewAddtoQuote.get(1).click();

        pageManager.addToExistingORCreateNewQUOTE_modal().isAddToExistingOrCreateNewQuoteTitleTextDisplayed();
        pageManager.addToExistingORCreateNewQUOTE_modal().createAndVerifyNewQuote();
    }


    @Test(dataProvider = "browsers")
    public void quote_addToExistingQuoteFromPLPListView(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickQuotesUtilityBar();
		pageManager.quoteListsPage().createNewQuote();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().clickOnListView();
        String plpProddesc = pageManager.productListingPage().listViewProductDescription.get(2).getText();
        pageManager.productListingPage().gridListViewAddtoQuote.get(2).click();
        pageManager.addToExistingORCreateNewQUOTE_modal().addItemIntoExistingQuoteById();
        pageManager.homePage().clickQuotesUtilityBar();
        pageManager.quoteListsPage().isDisplayedQuotesPageHeadingText();
        pageManager.quoteListsPage().listAllQuotesIDs.get(0).click();
        Assert.assertTrue(pageManager.quotesPriceDetailPage().isAddedPartDescriptionTextIsDisplayedOnPriceQuotepage(plpProddesc));
    }

}
