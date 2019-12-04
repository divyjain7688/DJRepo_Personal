package com.selenium.ebiz.product_listing_page.plp_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class ProductDetailsPageGuestUser_WORKING extends BaseClassV8_ParallelGrid {


    /*Few elements like Add to link  from below expected element are not visible in QA*/

    /**
     * dj073227
     * US-Cat-380 - This test is to verify that as a unauthenticated User I want to view the Product Details Page
     * so I can view specifications and details of products in the catalog to make a purchase.
     */
    @Test(description = "specificationAndDetailsOfProductGuestUser", dataProvider = "browsers")
    public void specificationAndDetailsOfProductGuestUser(String browser, String version, String os, Method method) throws MalformedURLException, Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().clickOnProductListingPageFirstProductName();
        Assert.assertTrue(pageManager.productDetailsPage().isImageThumbnailsDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isProductNameDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isPartNumberDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isPriceDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isShippingChargesDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isReturnsDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isDeliveryDayDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isQuantityStepperDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isBrandNameDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isAddToCartButtonDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isAddToQuoteButtonDisplayed());
        //Assert.assertTrue(productDetailsPage.isQuickCheckOutButtonDisplayed());
        //	Assert.assertTrue(pageManager.productDetailsPage().isAddToLisButtonDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isProductDetailsTitleDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isProductSpecificationDisplayed());
    }


}
