package com.selenium.ebiz.product_listing_page.plp_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dj073227
 */
public class ProductListingPageAuthenticatedUser_WORKING extends BaseClassV8_ParallelGrid {

    String expectedPopupErrorMessage = "The maximum number of products that can be compared is 4. Please refine your selection.";
    String relevanceValueinSortByDropdown = "Relevance";
    String brandValueinSortByDropdown = "Brand";
    String productNameValueinSortByDropdown = "Product Name";
    String lowToHighPriceValueinSortByDropdown = "Price: Low to High";
    String highToLowPriceValueinSortByDropdown = "Price: High to Low";
    String topSellersValueinSortByDropdown = "Top Sellers";
    String countryOfOriginValueinSortByDropdown = "Country of Origin";


    /**
     * dj073227
     * US-Cat-330 - This method is used to verify that when user logged in and navigate to
     * PLP page, products are displayed in Grid view on Product Listing Page
     *
     * @throws Exception
     * @throws MalformedURLException
     */
    @Test(description = "verifySubCategoryPageGridView", dataProvider = "browsers")
    public void verifySubCategoryPageGridView(String browser, String version, String os, Method method) throws MalformedURLException, Exception {

        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().moveToSubCategoryPage();
        Boolean flag = pageManager.productListingPage().isGridViewDisplayed();
        Assert.assertTrue(flag);
    }

    /**
     * dj073227
     * US-Cat-350 - This method is used to verify that when user does not logged in to website
     * and navigate to PLP page, products are displayed in List view by default
     * on Product Listing Page
     *
     * @throws Exception
     * @throws MalformedURLException
     */

    @Test(description = "verifySubCategoryPageListView", dataProvider = "browsers")
    public void verifySubCategoryPageListView(String browser, String version, String os, Method method) throws MalformedURLException, Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().moveToSubCategoryPage();
        Boolean flag = pageManager.productListingPage().isDisplayedListViewButton();
        Assert.assertTrue(flag);
    }


    /**
     * dj073227
     * US-Cat-371 - This method is used to verify that when user logged in to website,navigate to PLP page
     * and select a product from PLP page ,Product compare widget should gets displayed in
     * bottom of page and user can select max of 4 products to compare on PLP page.
     */
    @Test(description = "verifyProductSelectWidget", dataProvider = "browsers")
    public void verifyProductSelectWidget(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().moveToSubCategoryPage();
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
     * US-Cat-266 - This method is used to verify that once user logged in and navigate to
     * PLP page, user should be able to see "sort by" and its dropdown options
     *
     * @throws Exception
     * @throws MalformedURLException
     */
    @Test(description = "verifySortByDropDown", dataProvider = "browsers")
    public void verifySortByDropDown(String browser, String version, String os, Method method) throws MalformedURLException, Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().moveToSubCategoryPage();
        ArrayList<String> optionsText = new ArrayList<String>();
        List<WebElement> optionsinDropDown = pageManager.productListingPage().getSortByDropDownList();
        for (WebElement we : optionsinDropDown) {
            optionsText.add(we.getText());
            System.out.println(optionsText);
        }
        Assert.assertTrue(optionsText.contains(relevanceValueinSortByDropdown));
        Assert.assertTrue(optionsText.contains(brandValueinSortByDropdown));
        Assert.assertTrue(optionsText.contains(productNameValueinSortByDropdown));
        Assert.assertTrue(optionsText.contains(lowToHighPriceValueinSortByDropdown));
        Assert.assertTrue(optionsText.contains(highToLowPriceValueinSortByDropdown));
        Assert.assertTrue(optionsText.contains(topSellersValueinSortByDropdown));
        Assert.assertTrue(optionsText.contains(countryOfOriginValueinSortByDropdown));
    }

    /**
     * dj073227
     * US-Cat-370 - This method is used to verify that when a user logged in to website,navigate to PLP page,
     * select the product and then deselect the selected product from PLP page, Product compare widget
     * should gets updated accordingly.When user scroll up or scroll down the PLP page, Product compare
     * widget should be in place.
     */
    @Test(description = "verifyProductSelectDeselectWidgetAndScrollUpDown", dataProvider = "browsers")
    public void verifyProductSelectDeselectWidgetAndScrollUpDown(String browser, String version, String os, Method method) throws Exception {

        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().moveToSubCategoryPage();
        //Assert.assertFalse(pageManager.productListingPage().isComapreProductWidgetDisplayed());
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

    /*Verified till the feature is developed.Promotional spot is not visible*/

    /**
     * dj073227
     * US-Cat-265 - This test is to verify that once user logged in and navigate to PLP page,
     * user should see Result counter with value above the grid/list of products.
     *
     * @throws Exception
     * @throws MalformedURLException
     */
    @Test(description = "verifyResultCounter", dataProvider = "browsers")
    public void verifyResultCounter(String browser, String version, String os, Method method) throws MalformedURLException, Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().moveToSubCategoryPage();
        Assert.assertTrue(pageManager.productListingPage().isResultCounterDisplayed());
    }

}

