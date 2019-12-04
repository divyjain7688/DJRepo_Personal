package com.selenium.ebiz.compareProducts.compareProducts_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author dj073227
 * This test case is mapped with ALM 81588
 * Verify Compare from Product Listing Page.
 */

public class VerifyCompareFromProductListingPage extends BaseClassV8_Parallel {
    String FirstProductPriceOnPLP, SecondProductPriceOnPLP, FirstProductPriceOnComPage, SecondProductPriceOnComPage;

    @Test(description = "Login")
    public void testLogin() {
        //  username = RandomAccountSelect.users.pop();
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Assert.assertTrue(pageManager.loginPage().loggedAccountNumberText.isDisplayed());
    }

    @Test(dependsOnMethods = {"testLogin"}, description = "Test Clear Cart")
    public void testClearCart() throws Exception {
        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");
    }

    @Test(dependsOnMethods = {"testClearCart"}, description = "Verify Compare These Parts Button Is Disabled")
    public void verifyCompareWidgetIsDisable() throws Exception {
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().clickonFirstCheckbox();
        Assert.assertFalse(pageManager.productListingPage().isCompareThesePartsButtonEnabled());
    }

    @Test(dependsOnMethods = {"verifyCompareWidgetIsDisable"}, description = "Verify Compare These Parts Button Is Enabled")
    public void verifyCompareWidgetIsEnable() throws Exception {
        pageManager.productListingPage().clickonSecondCheckbox();
        Assert.assertTrue(pageManager.productListingPage().isCompareThesePartsButtonEnabled());
    }

    @Test(dependsOnMethods = {"verifyCompareWidgetIsEnable"}, description = "Verify Price Of Product")
    public void verifyPriceOfProduct() throws Exception {
        FirstProductPriceOnPLP = pageManager.productListingPage().getFirstProductPriceInProductList();
        SecondProductPriceOnPLP = pageManager.productListingPage().getSecondProductPriceInProductList();
        pageManager.productListingPage().clickCompareTheseButton();
        FirstProductPriceOnComPage = pageManager.compareTheseItems().getFirstProductPrice();
        SecondProductPriceOnComPage = pageManager.compareTheseItems().getSecondProductPrice();
        System.out.println("FirstProductPriceOnPLP is " + FirstProductPriceOnPLP);
        System.out.println("SecondProductPriceOnPLP is " + SecondProductPriceOnPLP);
        System.out.println("FirstProductPriceOnComPage is " + FirstProductPriceOnComPage);
        System.out.println("SecondProductPriceOnComPage is " + SecondProductPriceOnComPage);

        Assert.assertTrue(FirstProductPriceOnPLP.equals(FirstProductPriceOnComPage));
        Assert.assertTrue(SecondProductPriceOnPLP.equals(SecondProductPriceOnComPage));
    }

    @Test(dependsOnMethods = {"verifyPriceOfProduct"}, description = "Verify Message About Selecting 4 Products")
    public void verifyProductComparisonMessage() {
        pageManager.compareTheseItems().backToPLPPageButton.click();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().clickonFourthCheckbox();
        pageManager.productListingPage().clickonFifthCheckbox();
        String message = pageManager.productListingPage().isTextOnPopupWindowDisplayed();
    }

    @Test(dependsOnMethods = {"verifyProductComparisonMessage"}, description = "Verify Price Of Product After Sort By Brand")
    public void verifyPriceOfProductAfterSortByBrand() throws Exception {
        pageManager.productListingPage().selectBrandFromSortByDropdown();
        Assert.assertTrue(FirstProductPriceOnPLP.equals(FirstProductPriceOnComPage));
        Assert.assertTrue(SecondProductPriceOnPLP.equals(SecondProductPriceOnComPage));
    }

}
