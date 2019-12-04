/**
 * @author Bhavani
 * <p>
 * FMQA-2446 [1]To Verify if item can be added from Product Comparison Results Page
 * <p>
 * ALM Test Instance ID: 649408
 */
package com.selenium.ebiz.compareProducts.compareProducts_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;


public class VerifyIfItemCanBeAddedFromProductComparisonResultsPage extends BaseClassV8_Parallel {

    String partNumberFromCompareProductsPage, partNumberFromSCP;
    String productPriceFromCompareProductsPage, productPriceFromSCP;

    /**
     *  Verifying the add to Cart from PLP List View
     * @throws Exception
     */

    @Test(description = "Login")
    public void testLogin() throws Exception {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Assert.assertTrue(pageManager.homePage().isDisplayedLeftNavgation());
    }

    @Test(dependsOnMethods = {"testLogin"}, description = "Cart Empty Confirmation")
    public void testClearCart() throws Exception {
        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");
    }

    @Test(dependsOnMethods = {"testClearCart"}, description = "Verify Compare Checkboxes Displayed ")
    public void verifyCompareCheckboxesDisplayed() throws Exception {
        pageManager.homePage().moveToSubCategoryPage();
        Assert.assertTrue(pageManager.productListingPage().isDisplayedCompareCheckBoxes());
    }

    @Test(dependsOnMethods = {"verifyCompareCheckboxesDisplayed"}, description = "Verify Navigated To Compare Products Page")
    public void verifyNavigatedToCompareProductsPage() throws Exception {
        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().clickCompareTheseButton();
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"verifyNavigatedToCompareProductsPage"}, description = " Verify Quantity Field takes upto four digits only")
    public void verifyPartFieldTakesUptoFourDigits() throws Exception {
        GetUserList("invalidPartNumber", "QuickOrder");
        Log.info(" ******* qtyInvalid: " + usersList.get(0).getQuantity1());
        String qtyInvalid = usersList.get(0).getQuantity1();
        pageManager.compareTheseItems().enterQuantity((usersList.get(0).getQuantity1()));

        String qtyValid = pageManager.compareTheseItems().getQty();
        Log.info(" ******* qtyValid: " + qtyValid);
        Log.info("qtyValid :" + qtyValid.length());
        Log.info("qtyInvalid :" + qtyInvalid.length());
        assertNotEquals(qtyValid.length(), qtyInvalid.length());
        assertNotEquals(qtyValid, qtyInvalid);
    }

    @Test(dependsOnMethods = {"verifyPartFieldTakesUptoFourDigits"}, description = "Verify Add To Cart From Compare Products Page")
    public void verifyAddToCartFromCompareProductsPage() throws Exception {
        partNumberFromCompareProductsPage = pageManager.compareTheseItems().getPartNumber();
        productPriceFromCompareProductsPage = pageManager.compareTheseItems().getPrice();
        Log.info("PartNumberFromCompareProductsPage: " + partNumberFromCompareProductsPage);
        Log.info("ProductPriceFromCompareProductsPage: " + productPriceFromCompareProductsPage);
        pageManager.compareTheseItems().clickOnAddToCartButton();
    }

    @Test(dependsOnMethods = {"verifyAddToCartFromCompareProductsPage"}, description = "Verify Shopping Cart Page")
    public void verifyShoppingCartPage() throws Exception {
        pageManager.homePage().clickOnShoppingCartIcon();
        Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
    }

    @Test(dependsOnMethods = {"verifyShoppingCartPage"}, description = "Verify Product Part Number")
    public void verifyProductPartNumber() {
        partNumberFromSCP = pageManager.shoppingCartPage().getPartNumberText();
        Assert.assertEquals(partNumberFromSCP, partNumberFromCompareProductsPage);
    }

    @Test(dependsOnMethods = {"verifyProductPartNumber"}, description = "Verify Product Price")
    public void verifyProductPrice() {
        productPriceFromSCP = pageManager.shoppingCartPage().getProductPrice();
        Assert.assertEquals(productPriceFromSCP, productPriceFromCompareProductsPage);
    }

    @Test(dependsOnMethods = {"verifyProductPrice"}, description = "Logout")
    public void testLogout() throws Exception {
        pageManager.loginPage().logoutOfApplication();

    }

}
