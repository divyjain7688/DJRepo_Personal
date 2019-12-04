/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-28 [1]Verify Return to Results Page from Compare Results Page
 * <p>
 * ALM Test Instance ID: 649464
 */
package com.selenium.ebiz.compareProducts.compareProducts_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyReturnToResultsPageFromCompareResultsPage extends BaseClassV8_Parallel {

    String searchPLPHeading, subCategory, plpHeading, searchPLPHeadingAfterBackClick;

    @Test(description = "Search By Product Desc That Has Double Quotes ")
    public void testSearchByProductDesc() throws Exception {
        GetUserList("searchByProductDescWithDoubleQuotes", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
    }

    @Test(dependsOnMethods = {"testSearchByProductDesc"}, description = "Verify Navigated To Compare Products Page")
    public void verifyNavigatedToCompareProductsPage() throws Exception {
        searchPLPHeading = pageManager.productListingPage().getPLPHeadingText();
        pageManager.productListingPage().clickCompareCheckBoxes(4);
        pageManager.productListingPage().clickCompareTheseButton();
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"verifyNavigatedToCompareProductsPage"}, description = "Verify Navigated To Search Results Page On Back Search")
    public void verifyNavigatedToSearchPageOnBackToSearch() throws Exception {
        pageManager.compareTheseItems().clickBackToSearchLink();
        searchPLPHeadingAfterBackClick = pageManager.productListingPage().getPLPHeadingText();
        Log.info("searchPLPHeadingAfterBackClick: " + searchPLPHeadingAfterBackClick + "searchPLPHeading: " + searchPLPHeading);
        Assert.assertEquals(searchPLPHeadingAfterBackClick, searchPLPHeading);
    }

    @Test(dependsOnMethods = {"verifyNavigatedToSearchPageOnBackToSearch"}, description = "Verify Navigate To SubCategory Has Ampersand ")
    public void verifyNavigateToSubCategoryHasAmpersand() throws Exception {
        pageManager.homePage().clickOnHDSupplyLogoInHeader();
        pageManager.homePage().clickCategoryAppliancessLinkText();
        pageManager.appliances().clickTopCategoryRefrigeratorsFreezersLinkText();
        Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
    }

    @Test(dependsOnMethods = {"verifyNavigateToSubCategoryHasAmpersand"}, description = "Verify Navigated To Compare Products Page After Selecting Products From Subcategory")
    public void verifyNavigatedToCPPAfterSelectingProductsFromSubCat() throws Exception {
        subCategory = pageManager.productListingPage().getPLPHeadingText();
        pageManager.productListingPage().clickCompareCheckBoxes(4);
        pageManager.productListingPage().clickCompareTheseButton();
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"verifyNavigatedToCPPAfterSelectingProductsFromSubCat"}, description = "Verify Navigated To Subcategory On Back Search")
    public void verifyNavigatedToSubCatOnBackToSearch() throws Exception {
        pageManager.compareTheseItems().clickBackToSearchLink();
        plpHeading = pageManager.productListingPage().getPLPHeadingText();
        Log.info("plpHeading: " + plpHeading + "subCategory: " + subCategory);
        Assert.assertEquals(plpHeading, subCategory);
    }

    @Test(dependsOnMethods = {"verifyNavigatedToSubCatOnBackToSearch"}, description = "Verify Price Selected ")
    public void verifyPriceSelected() throws Exception {
        pageManager.productListingPage().clickCompareCheckBoxes(4);
        //pageManager.productListingPage().clickClearAllLink();
        pageManager.homePage().clickOnPriceLessThan25CheckBox();
        pageManager.productListingPage().clickCompareCheckBoxes(4);
        pageManager.productListingPage().clickCompareTheseButton();
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"verifyPriceSelected"}, description = "Verify Price Selected Persists")
    public void verifyPriceSelectedPersists() throws Exception {
        pageManager.compareTheseItems().clickBackToSearchLink();
        Assert.assertTrue(pageManager.homePage().IsSelectedPriceLessThan25CheckBox());

    }

}
