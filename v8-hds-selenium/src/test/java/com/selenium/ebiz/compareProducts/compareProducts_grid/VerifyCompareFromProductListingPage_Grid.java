package com.selenium.ebiz.compareProducts.compareProducts_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author dj073227
 * This test case is mapped with ALM 81588
 * Verify Compare from Product Listing Page.
 * modified: Iuliia
 */

public class VerifyCompareFromProductListingPage_Grid extends BaseClassV8_ParallelGrid {
    String FirstProductPriceOnPLP, SecondProductPriceOnPLP, FirstProductPriceOnComPage, SecondProductPriceOnComPage;

    @Test(dataProvider = "browsers")
    public void compProd__VerifyComparePriceFromPLP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        //pageManager.loginPage().loggedAccountNumberText.isDisplayed();

        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");

        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().isCompareThesePartsButtonEnabled();

        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().isCompareThesePartsButtonEnabled();

        FirstProductPriceOnPLP = pageManager.productListingPage().getFirstProductPriceInProductList();
        SecondProductPriceOnPLP = pageManager.productListingPage().getSecondProductPriceInProductList();
        pageManager.productListingPage().clickCompareTheseButton();
        FirstProductPriceOnComPage = pageManager.compareTheseItems().getFirstProductPrice();
        SecondProductPriceOnComPage = pageManager.compareTheseItems().getSecondProductPrice();
        Log.info("FirstProductPriceOnPLP is " + FirstProductPriceOnPLP);
        Log.info("SecondProductPriceOnPLP is " + SecondProductPriceOnPLP);
        Log.info("FirstProductPriceOnComPage is " + FirstProductPriceOnComPage);
        Log.info("SecondProductPriceOnComPage is " + SecondProductPriceOnComPage);

        pageManager.compareTheseItems().backToPLPPageButton.click();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().clickonFourthCheckbox();
        pageManager.productListingPage().clickonFifthCheckbox();
        pageManager.productListingPage().isTextOnPopupWindowDisplayed();

        Assert.assertTrue(FirstProductPriceOnPLP.equals(FirstProductPriceOnComPage));
        Assert.assertTrue(SecondProductPriceOnPLP.equals(SecondProductPriceOnComPage));
        pageManager.productListingPage().selectBrandFromSortByDropdown();
        Assert.assertTrue(FirstProductPriceOnPLP.equals(FirstProductPriceOnComPage));
        Assert.assertTrue(SecondProductPriceOnPLP.equals(SecondProductPriceOnComPage));
    }

}
