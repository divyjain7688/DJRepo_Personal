package com.selenium.ebiz.product_listing_page.plp_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class CompareTheseItemsPageAuthenticatedUser_WORKING extends BaseClassV8_ParallelGrid {

    int productSelectedFromPLPPage;
    int numberOfComparisonTiles;
    int numberOfremoveLinksInsideComparisonTiles;

    /**
     * dj073227
     * US-Cat-362 - This test is to verify that when user logged in,navigate to PLP page,
     * select 2 or more products, he should be navigated to compare these items page and should see all tag,
     * tiles and links of selected products.User should also be able to navigate through breadcrum
     *
     * @throws MalformedURLException
     * @throws Exception
     */
    @Test(description = "verifyProductTilesWithButtonsAuthenticatedUser", dataProvider = "browsers")
    public void verifyProductTilesWithButtonsAuthenticatedUser(String browser, String version, String os, Method method) throws MalformedURLException, Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().clickonFirstCheckbox();
        productSelectedFromPLPPage = pageManager.productListingPage().counterIncrease(productSelectedFromPLPPage);
        System.out.println("1 productSelectedFromPLPPage " + productSelectedFromPLPPage);
        pageManager.productListingPage().clickonSecondCheckbox();
        //	productSelectedFromPLPPage = CompareTheseItems.counterIncrease();
        productSelectedFromPLPPage = pageManager.productListingPage().counterIncrease(productSelectedFromPLPPage);
        System.out.println("2 productSelectedFromPLPPage " + productSelectedFromPLPPage);
        pageManager.productListingPage().isComapreProductWidgetDisplayed();
        pageManager.productListingPage().clickCompareTheseButton();
        numberOfComparisonTiles = pageManager.compareTheseItems().numberOfComparisonTiles();
        numberOfremoveLinksInsideComparisonTiles = pageManager.compareTheseItems().numberOfremoveLinksInsideComparisonTiles();
        Assert.assertEquals(numberOfComparisonTiles, productSelectedFromPLPPage, numberOfremoveLinksInsideComparisonTiles);
        pageManager.compareTheseItems().isAddAnotherProductTileDisplayed();
        pageManager.compareTheseItems().isFirstTileDisplayed();
        pageManager.compareTheseItems().isRemoveLinkInsideFirstTileDisplayed();
        pageManager.compareTheseItems().isQuantityBarInsideFirstComparisonTileDisplayed();
        pageManager.compareTheseItems().isProductImageInsideFirstComparisonTileDisplayed();
        pageManager.compareTheseItems().isAddToListInsideFirstComparisonTileDisplayed();
        pageManager.compareTheseItems().isAddToQuoteInsideFirstComparisonTile();
        pageManager.compareTheseItems().isAddToCartInsideFirstComparisonTile();
        pageManager.compareTheseItems().isSecondTileDisplayed();
        pageManager.compareTheseItems().isRemoveLinkInsideSecondTileDisplayed();
        pageManager.compareTheseItems().isQuantityBarInsideSecondComparisonTileDisplayed();
        pageManager.compareTheseItems().isProductImageInsideSecondComparisonTileDisplayed();
        pageManager.compareTheseItems().isAddToListInsideSecondComparisonTileDisplayed();
        pageManager.compareTheseItems().isAddToQuoteInsideSecondComparisonTile();
        pageManager.compareTheseItems().isAddToCartInsideSecondComparisonTile();
        pageManager.compareTheseItems().clickRemoveLinkInsideFirstTileDisplayed();
        //	numberOfComparisonTiles = CompareTheseItems.counterDecrease();
        numberOfComparisonTiles = pageManager.productListingPage().counterDecrease(numberOfComparisonTiles);
        Assert.assertEquals(numberOfComparisonTiles, pageManager.compareTheseItems().numberOfComparisonTiles());
        pageManager.compareTheseItems().clickRemoveLinkInsideFirstTileDisplayed();
        //numberOfComparisonTiles = CompareTheseItems.counterDecrease();
        numberOfComparisonTiles = pageManager.productListingPage().counterDecrease(numberOfComparisonTiles);
        Assert.assertEquals(numberOfComparisonTiles, pageManager.compareTheseItems().isNumberOfComparisonTilesZero());
        pageManager.compareTheseItems().clickOnL2BreadCrum();
        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().clickonThirdCheckbox();
        //productSelectedFromPLPPage = CompareTheseItems.counterIncrease();
        productSelectedFromPLPPage = pageManager.productListingPage().counterIncrease(productSelectedFromPLPPage);
        pageManager.productListingPage().clickCompareTheseButton();
        pageManager.compareTheseItems().isAddAnotherProductTileDisplayed();
        pageManager.compareTheseItems().clickOnAddNewProductTile();
        pageManager.productListingPage().clickonFourthCheckbox();
        pageManager.productListingPage().clickCompareTheseButton();
        Assert.assertTrue(pageManager.compareTheseItems().isProductSpecificationExists());
    }

}
