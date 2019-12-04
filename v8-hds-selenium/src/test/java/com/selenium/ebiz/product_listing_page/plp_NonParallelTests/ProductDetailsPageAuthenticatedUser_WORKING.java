package com.selenium.ebiz.product_listing_page.plp_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class ProductDetailsPageAuthenticatedUser_WORKING extends BaseClassV8_ParallelGrid {

    /*Sub category filter on frequently purchased page is not working. W80-2087 bug raised for the same.*/

    /**
     * US-Cat-390 - This test is to verify that as a authenticated User I want to view the Product Details Page
     * so I can view specifications and details of products in the catalog to make a purchase.
     *
     * @throws Exception
     * @throws MalformedURLException
     */
    @Test(description = "specificationAndDetailsOfProductAuthenticatedUser", dataProvider = "browsers")
    public void specificationAndDetailsOfProductAuthenticatedUser(String browser, String version, String os, Method method) throws MalformedURLException, Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
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
        Assert.assertTrue(pageManager.addToExistingORCreateNewList_modal().isAddToLisButtonDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isProductDetailsTitleDisplayed());
        Assert.assertTrue(pageManager.productDetailsPage().isProductSpecificationDisplayed());
    }

}
