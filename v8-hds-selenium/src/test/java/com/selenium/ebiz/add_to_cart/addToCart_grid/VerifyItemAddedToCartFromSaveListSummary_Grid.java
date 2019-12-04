package com.selenium.ebiz.add_to_cart.addToCart_grid;

/**
 * @author Sandhya
 * <p>
 * FMQA-2444 To Verify if items can be added from a Saved List Summary
 * <p>
 * ALM Test Instance ID: 649406
 * <p>
 * Fixed the issue by Bhavani
 */

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyItemAddedToCartFromSaveListSummary_Grid extends BaseClassV8_ParallelGrid {
    String savedListPage;
    String partNumber;
    String price;

    /**
     *  To Verify if items can be added from a Saved List Summary
     * @throws Exception
     */

    @Test(dataProvider = "browsers")
    //disabled the test case because saved list page UI got changed

    public void addtocart_VerifyItemAddedToCartFromSaveListSummary(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().clickOnProductListingPageFirstProductName();
        pageManager.productDetailsPage().clickAddToListButton();
        String list = pageManager.addToExistingORCreateNewList_modal().addItemToNewList("List");
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickFirstSavedListNameLinkText();
        partNumber = pageManager.savedListsDetailPage().getdisplayedPartNumber();
        Log.info("partNumber is " + partNumber);
        //Get displayed price property is dinamicly changed on Saved List
        //price = pageManager.savedListsPage().getdisplayedPrice();
        //Log.info("price is "+ price);
        //pageManager.savedListsPage().isDisplayedSaveListPartImage();
        pageManager.savedListsDetailPage().clickonFirstAddToCartbtn();
        pageManager.homePage().clickOnShoppingCartIcon();
        Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(partNumber));
        //Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartPriceIsSameInShoppingCart(price));

    }
}
