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

public class CreateQuotesFromPLPGridView extends BaseClassV8_ParallelGrid {
    ArrayList<UsersListBean> usersList;

    /* Designed by: Iuliia
     * Creating a new quote from PLP
     * WCS 8.0W80-2410
       W80-2170-01: Creating a new Quote from PLP
     */
    @Test(dataProvider = "browsers", enabled = false)
    public void quote_createNewQuoteFromPLP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);


        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchByProductDesc", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().isGridViewDisplayed();

        pageManager.productListingPage().clickAddToQuoteButton(0);
        pageManager.addToExistingORCreateNewQUOTE_modal().isAddToExistingOrCreateNewQuoteTitleTextDisplayed();
        pageManager.addToExistingORCreateNewQUOTE_modal().createAndVerifyNewQuote();

    }

    @Test(dataProvider = "browsers")
    public void quote_ValidateLinksOnAddToquoteModalWindow(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().isGridViewDisplayed();
        String prodDesc = pageManager.productListingPage().listProductsDescriptionText.get(1).getText();
        Log.info("PLP prod desc: " + prodDesc);
        pageManager.productListingPage().clickAddToQuoteButton(1);
        pageManager.addToExistingORCreateNewQUOTE_modal().isAddToExistingOrCreateNewQuoteTitleTextDisplayed();
        String quoteModalProductTitle = pageManager.addToExistingORCreateNewQUOTE_modal().partNumberDescriptionOnModalwindow.getText();
        Log.info("Quote modal prod desc: " + quoteModalProductTitle);
        Assert.assertTrue(quoteModalProductTitle.contains(prodDesc));
        Assert.assertTrue(pageManager.addToExistingORCreateNewQUOTE_modal().isSeeAllQuotesBtnDisplayed());
    }

    @Test(dataProvider = "browsers")
    public void quote_addToExistingQuoteFromPLP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickQuotesUtilityBar();
		pageManager.quoteListsPage().createNewQuote();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().isGridViewDisplayed();
        String plpProddesc = pageManager.productListingPage().listProductsDescriptionText.get(1).getText();
        System.out.println("plpProddesc is "+ plpProddesc);
        pageManager.productListingPage().clickAddToQuoteButton(1);
        pageManager.addToExistingORCreateNewQUOTE_modal().addItemIntoExistingQuoteById();
        //	String quoteN= pageManager.addToExistingORCreateNewQUOTE_modal().captureQuoteNumberOnPopupAfterAddingToExistingQuote();
        pageManager.homePage().clickQuotesUtilityBar();
        pageManager.quoteListsPage().isDisplayedQuotesPageHeadingText();
      //  pageManager.quoteListsPage().getSortByDropdown("ID");
      //  String listName = pageManager.quoteListsPage().listAllQuotesIDs.get(0).getText();
        pageManager.quoteListsPage().quoteIDList.get(0).click();
        pageManager.quotesPriceDetailPage().isDisplayedPriceQuoteTitle();
        Assert.assertTrue(pageManager.quotesPriceDetailPage().isAddedPartDescriptionTextIsDisplayedOnPriceQuotepage(plpProddesc));


    }


}
