package com.selenium.ebiz.product_listing_page.plp_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

/**
 * @author dj073227
 */
public class CompareTheseItemsPageGuestUser_WORKING extends BaseClassV8_ParallelGrid {

    int productSelectedFromPLPPage;
    int numberOfComparisonTiles;
    int numberOfremoveLinksInsideComparisonTiles;

    /**
     * US-Cat-372 - This test is to verify that when guest user navigate to PLP page,
     * select 2 or more products, he should be navigated to compare these items page and should see all tag,
     * tiles and links of selected products.User should also be able to navigate through breadcrum
     *
     * @throws MalformedURLException
     * @throws Exception
     */
    @Test(description = "verifyProductTilesWithButtonsGuestUser", dataProvider = "browsers")
    public void verifyProductTilesWithButtonsGuestUser(String browser, String version, String os, Method method) throws MalformedURLException, Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().clickonFirstCheckbox();
        productSelectedFromPLPPage = pageManager.productListingPage().counterIncrease(productSelectedFromPLPPage);
        System.out.println("1 productSelectedFromPLPPage " + productSelectedFromPLPPage);
        pageManager.productListingPage().clickonSecondCheckbox();
        //	productSelectedFromPLPPage = CompareTheseItems.counterIncrease();
        productSelectedFromPLPPage = pageManager.productListingPage().counterIncrease(productSelectedFromPLPPage);
        System.out.println("2 productSelectedFromPLPPage " + productSelectedFromPLPPage);
        Assert.assertTrue(pageManager.productListingPage().isComapreProductWidgetDisplayed());
        pageManager.productListingPage().clickCompareTheseButton();
        numberOfComparisonTiles = pageManager.compareTheseItems().numberOfComparisonTiles();
        numberOfremoveLinksInsideComparisonTiles = pageManager.compareTheseItems().numberOfremoveLinksInsideComparisonTiles();
        Assert.assertEquals(numberOfComparisonTiles, productSelectedFromPLPPage, numberOfremoveLinksInsideComparisonTiles);
        Assert.assertTrue(pageManager.compareTheseItems().isAddAnotherProductTileDisplayed());
        Assert.assertTrue(pageManager.compareTheseItems().isFirstTileDisplayed());
        Assert.assertTrue(pageManager.compareTheseItems().isRemoveLinkInsideFirstTileDisplayed());
        Assert.assertTrue(pageManager.compareTheseItems().isQuantityBarInsideFirstComparisonTileDisplayed());
        Assert.assertTrue(pageManager.compareTheseItems().isProductImageInsideFirstComparisonTileDisplayed());
        Assert.assertTrue(pageManager.compareTheseItems().isAddToListInsideFirstComparisonTileDisplayed());
        Assert.assertTrue(pageManager.compareTheseItems().isAddToQuoteInsideFirstComparisonTile());
        Assert.assertTrue(pageManager.compareTheseItems().isAddToCartInsideFirstComparisonTile());
        Assert.assertTrue(pageManager.compareTheseItems().isSecondTileDisplayed());
        Assert.assertTrue(pageManager.compareTheseItems().isRemoveLinkInsideSecondTileDisplayed());
        Assert.assertTrue(pageManager.compareTheseItems().isQuantityBarInsideSecondComparisonTileDisplayed());
        Assert.assertTrue(pageManager.compareTheseItems().isProductImageInsideSecondComparisonTileDisplayed());
        Assert.assertTrue(pageManager.compareTheseItems().isAddToListInsideSecondComparisonTileDisplayed());
        Assert.assertTrue(pageManager.compareTheseItems().isAddToQuoteInsideSecondComparisonTile());
        Assert.assertTrue(pageManager.compareTheseItems().isAddToCartInsideSecondComparisonTile());
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
        Assert.assertTrue(pageManager.compareTheseItems().isAddAnotherProductTileDisplayed());
        pageManager.compareTheseItems().clickOnAddNewProductTile();
        pageManager.productListingPage().clickonFourthCheckbox();
        pageManager.productListingPage().clickCompareTheseButton();
        Assert.assertTrue(pageManager.compareTheseItems().isProductSpecificationExists());
    }

}
