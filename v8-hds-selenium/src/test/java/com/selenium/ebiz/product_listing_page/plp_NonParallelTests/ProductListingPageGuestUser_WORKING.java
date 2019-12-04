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
public class ProductListingPageGuestUser_WORKING extends BaseClassV8_ParallelGrid {
    String expectedPopupErrorMessage = "The maximum number of products that can be compared is 4. Please refine your selection.";

    /**
     * dj073227
     * US-Cat-320 - This method is used to verify that when user does not logged in to website
     * and navigate to PLP page, products are displayed in Grid view on Product Listing Page
     *
     * @throws Exception
     * @throws MalformedURLException
     */
    @Test(description = "verifySubCategoryPageGridView", dataProvider = "browsers")
    public void verifySubCategoryPageGridView(String browser, String version, String os, Method method) throws MalformedURLException, Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.homePage().moveToSubCategoryPage();
        Boolean flag = pageManager.productListingPage().isGridViewDisplayed();
        Assert.assertTrue(flag);
    }

    /**
     * dj073227
     * US-Cat-340 - This method is used to verify that when user does not logged in to website
     * and navigate to PLP page, products are displayed in List view by default
     * on Product Listing Page
     *
     * @throws Exception
     * @throws MalformedURLException
     */

	/*	Test was failing: expecting list view by default right but currently it is grid view by default.W80-1730  is raised
	Requirement got updated to have grid view as default view*/
    @Test(description = "verifySubCategoryPageListView", dataProvider = "browsers")
    public void verifySubCategoryPageListView(String browser, String version, String os, Method method) throws MalformedURLException, Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.homePage().moveToSubCategoryPage();
        Boolean flag = pageManager.productListingPage().isDisplayedListViewButton();
        Assert.assertTrue(flag);
    }

    /**
     * dj073227
     * US-Cat-361 - This method is used to verify that when user does not logged in to website,navigate to PLP page
     * and select a product from PLP page ,Product compare widget should gets displayed in
     * bottom of page and user can select max of 4 products to compare on PLP page.
     */
    @Test(description = "verifyProductSelectWidget", dataProvider = "browsers")
    public void verifyProductSelectWidget(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.homePage().moveToSubCategoryPage();
        //Assert.assertFalse(pageManager.productListingPage().isComapreProductWidgetDisplayed());
        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().isFirstProductOnProductWidgetSelected();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().isSecondProductOnProductWidgetSelected();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().isThirdProductOnProductWidgetSelected();
        pageManager.productListingPage().clickonFourthCheckbox();
        pageManager.productListingPage().isFourthProductOnProductWidgetSelected();
        pageManager.productListingPage().isComapreProductWidgetDisplayed();
        pageManager.productListingPage().clickonFifthCheckbox();
        String actualPopupErrorMessage = pageManager.productListingPage().isTextOnPopupWindowDisplayed();
        Assert.assertTrue(actualPopupErrorMessage.contains(expectedPopupErrorMessage));
    }

    /**
     * dj073227
     * US-Cat-360 - This method is used to verify that when a user does not logged in to website,navigate to PLP page
     * and select th eproduct and then deselect the selected product from PLP page, Product compare widget
     * should gets updated accordingly.When user scroll up or scroll down the PLP page, Product compare
     * widget should be in place.
     */
    @Test(description = "verifyProductSelectDeselectWidgetAndScrollUpDown", dataProvider = "browsers")
    public void verifyProductSelectDeselectWidgetAndScrollUpDown(String browser, String version, String os, Method method) throws Exception {
        //	Assert.assertFalse(productListingPage.isComapreProductWidgetDisplayed());
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().isFirstProductOnProductWidgetSelected();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().isSecondProductOnProductWidgetSelected();
        pageManager.common().scrollUp(driver);
        pageManager.productListingPage().isComapreProductWidgetDisplayed();
        pageManager.common().scrollDown(driver);
        pageManager.productListingPage().isComapreProductWidgetDisplayed();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().isThirdProductOnProductWidgetSelected();
        pageManager.productListingPage().clickonFourthCheckbox();
        pageManager.productListingPage().isFourthProductOnProductWidgetSelected();
        pageManager.productListingPage().isComapreProductWidgetDisplayed();
        pageManager.productListingPage().clickonFifthCheckbox();
        String actualPopupErrorMessage = pageManager.productListingPage().isTextOnPopupWindowDisplayed();
        actualPopupErrorMessage.contains(expectedPopupErrorMessage);
        pageManager.productListingPage().clickonFourthCheckbox();
        pageManager.productListingPage().isFourthProductOnProductWidgetDeselected();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().isThirdProductOnProductWidgetDeselected();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().isSecondProductOnProductWidgetDeselected();
        pageManager.productListingPage().clickonFirstCheckbox();
        Assert.assertFalse(pageManager.productListingPage().isComapreProductWidgetDisplayed());
    }


}
