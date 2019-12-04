package com.selenium.ebiz.product_listing_page.plp_grid;

/**
 * @author Iuliia
 * <p>
 * ALM Test Instance ID: 657784
 */

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyLeft_Nav_Filter_Tabs extends BaseClassV8_ParallelGrid {
    /*
    Disabled by FMQAECOMM-209

    4/1/2019: Fixed byy Iuliia - updated element property of "displayedCategoryFilterFacets"
     */

    @Test(dataProvider = "browsers")
    public void plp_VerifyShowMoreFilterInPLP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().searchByKeywordOrPartNumber("labels");
        pageManager.plpFilters().isDisplayedCategoryFilterTab();
        pageManager.plpFilters().isDisplayedShowMoreOnCategoryFilterTab();
        pageManager.plpFilters().clickShowMoreOnCategoryFilterTab();
        Assert.assertTrue(pageManager.plpFilters().getExtandedFacetNumberInCategoryTab() >= 5);
    }

    @Test(dataProvider = "browsers")
    public void plp_VerifyShowMoreNotDisplayed(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().searchByKeywordOrPartNumber("bicycle permits");
        //SearchProductKeyword
        pageManager.plpFilters().isDisplayedCategoryFilterTab();
        Assert.assertTrue(pageManager.plpFilters().verifyShowMoreAbsent());
    }

    @Test(dataProvider = "browsers")
    public void plp_VerifyShowMoreReturnMoreFilters(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().searchByKeywordOrPartNumber("A-Shape");
        pageManager.plpFilters().isDisplayedCategoryFilterTab();
        Log.info(pageManager.plpFilters().displayedCategoryFilterFacets.size());
        int filtersBeforeExpandShowMore = pageManager.plpFilters().displayedCategoryFilterFacets.size();
        Log.info("filtersBeforeExpandShowMore: " + filtersBeforeExpandShowMore);
        pageManager.plpFilters().clickShowMoreOnCategoryFilterTab();
        int filtersAfterExpandShowMore = pageManager.plpFilters().getExtandedFacetNumberInCategoryTab();
        Log.info("filtersAfterExpandShowMore: " + filtersAfterExpandShowMore);
        Assert.assertTrue(filtersBeforeExpandShowMore <= 10);
        Assert.assertTrue(filtersAfterExpandShowMore >= 11);

    }


    @Test(dataProvider = "browsers")
    public void plp_SelectFilterAndVerifyResult(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        //Select any filter facet under the filters tab
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().searchByKeywordOrPartNumber("A-shape");
        pageManager.plpFilters().isDisplayedCategoryFilterTab();
        String filterFacetText = pageManager.plpFilters().displayedCategoryFilterFacets.get(1).getText();
        Log.info("Category Facet Filter text -- " + filterFacetText);
        pageManager.plpFilters().selectAndClickSubCategory(1);
        Log.info("Select the second facet under Category");
        pageManager.plpFilters().filteredBreadcrumbIsDisplayed(2);
        //        waitForAllUnderSubCategoryIsDisplayed();
        pageManager.plpFilters().isDisplayedCategoryFilterTab();
        String filteredTextOnBreadCrumb = pageManager.productListingPage().listfilteredBreadCrumb.get(2).getText();
        Log.info("Breadcrumb text after filtered --  " + filteredTextOnBreadCrumb);
        String countResult = pageManager.plpFilters().subcategoryResultCountAfterFilter.getText();
        Log.info(countResult + "   subcategoryResultCountAfterFilter");
        Assert.assertTrue(filterFacetText.contains(filteredTextOnBreadCrumb), "Verify the selected filter returned the correct result");
        Assert.assertTrue(filterFacetText.contains(countResult), "Verify the count result displays correct filtered amount");

    }

    @Test(dataProvider = "browsers", enabled = true)
    public void plp_SelectSubCategoryFilterAndVerifyResult(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        //Select any filter facet under the filters tab
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().searchByKeywordOrPartNumber("filter");
        pageManager.plpFilters().isDisplayedCategoryFilterTab();
        Log.info("Category Facet Filter text -- " + pageManager.plpFilters().displayedCategoryFilterFacets.get(0).getText());
        pageManager.plpFilters().selectAndClickSubCategory(0);
        Log.info("Select the First facet under Category");
        //pageManager.plpFilters().waitForAllUnderSubCategoryIsDisplayed();
        pageManager.plpFilters().isDisplayedShowMoreOnCategoryFilterTab();

        String subCategoryFacetText = pageManager.plpFilters().displayedCategoryFilterFacets.get(1).getText();
        pageManager.plpFilters().selectAndClickSubCategory(1);
        Log.info("Select the filter under SubCategory:   " + subCategoryFacetText);

        String displayedSubCategoryInBreadcrumb = pageManager.productListingPage().listfilteredBreadCrumb.get(3).getText();
        /*
        7/29/2019 Iuliia: Updated 117 line to get 3rd filtered breadcrumb instead of 4th
         */
        Log.info("Last selected filter in the Breadcrumb: " + displayedSubCategoryInBreadcrumb);

        Assert.assertTrue(subCategoryFacetText.contains(displayedSubCategoryInBreadcrumb), "Verify the selected filters returned the correct result");
    }

    @Test(dataProvider = "browsers")
    public void plp_NavigateBackFromPDPWithFilteredProduct(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().searchByKeywordOrPartNumber("faucet");
        pageManager.plpFilters().isDisplayedCategoryFilterTab();

        Log.info(pageManager.plpFilters().displayedCategoryFilterFacets.get(0).getText());
        pageManager.plpFilters().selectAndClickSubCategory(0);
        Log.info("Select the First filter under Category");
        String displayedSubCategoryTextInBreadcrumb = pageManager.productListingPage().filteredBreadCrumbinPLP(1);
        Log.info("displayedSubCategoryInBreadcrumb: " + displayedSubCategoryTextInBreadcrumb);
        pageManager.productListingPage().clickFirstProductInProductList();
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
        pageManager.plpFilters().navigateBackToPLP();
        String displayedSubCategoryInBreadcrumbAfterPDP = pageManager.productListingPage().filteredBreadCrumbinPLP(1);
        Log.info("displayedSubCategoryInBreadcrumbAfterPDP: " + displayedSubCategoryInBreadcrumbAfterPDP);
        //Product listing page is displayed with defaulted to filters tab and correct facets selected
        Assert.assertEquals(displayedSubCategoryTextInBreadcrumb, displayedSubCategoryInBreadcrumbAfterPDP);
    }

    @Test(dataProvider = "browsers")
    public void plp_NavigateBackFromPDPWithTwoFilters(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        //Select any filter facet under the filters tab
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().searchByKeywordOrPartNumber("filter");
        pageManager.plpFilters().isDisplayedCategoryFilterTab();
        Log.info("First facet under category: " + pageManager.plpFilters().displayedCategoryFilterFacets.get(0).getText());
        //   pageManager.plpFilters().isDisplayedShowMoreOnCategoryFilterTab();
        pageManager.plpFilters().selectAndClickSubCategory(0);
        Log.info("Select the First subcategory under Category Tab");

        pageManager.plpFilters().isDisplayedShowMoreOnCategoryFilterTab();

        // pageManager.plpFilters().waitForAllUnderSubCategoryIsDisplayed();

        // pageManager.plpFilters().isDisplayedCategoryFilterTab();

        String displayedFirstSelectedSubCategoryInBreadcrumb = pageManager.productListingPage().filteredBreadCrumbinPLP(2);
        Log.info(" First Subcategory Breadcrumb:" + displayedFirstSelectedSubCategoryInBreadcrumb);

        //  Log.info("Select the filter under SubCategory:   " + pageManager.plpFilters().displayedCategoryFilterFacets.get(0).getText());
        // pageManager.plpFilters().waitForAllUnderSubCategoryIsDisplayed();

        pageManager.plpFilters().selectAndClickSubCategory(1);
        Log.info("Select second subcategory");

        pageManager.plpFilters().filteredBreadcrumbIsDisplayed(3);
        String displayedSecondSubCategoryInBreadcrumb = pageManager.productListingPage().listfilteredBreadCrumb.get(3).getText();
        Log.info(" Second Subcategory Breadcrumb: " + displayedSecondSubCategoryInBreadcrumb);

        pageManager.productListingPage().clickFirstProductInProductList();
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
        pageManager.plpFilters().navigateBackToPLP();
        pageManager.productListingPage().isDisplayedListViewButton();
        String displayedSubCategoryTextInBreadcrumbAfterPDP = pageManager.productListingPage().listfilteredBreadCrumb.get(3).getText();
        Log.info("displayedSubCategoryInBreadcrumbAfterPDP: " + displayedSubCategoryTextInBreadcrumbAfterPDP);
        Assert.assertEquals(displayedSecondSubCategoryInBreadcrumb, displayedSubCategoryTextInBreadcrumbAfterPDP);
    }


}

