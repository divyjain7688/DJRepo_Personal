/**
 * @author Bhavani
 * <p>
 * FMQA-2446 [1]To Verify if item can be added from Product Comparison Results Page
 * <p>
 * ALM Test Instance ID: 649408
 * <p>
 * Modified: Iuliia
 */
package com.selenium.ebiz.compareProducts.compareProducts_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class VerifyIfItemCanBeAddedFromProductComparisonResultsPage_Grid extends BaseClassV8_ParallelGrid {

    String partNumberFromCompareProductsPage, partNumberFromSCP;
    String productPriceFromCompareProductsPage, productPriceFromSCP;

    /**
     *  Verifying the add to Cart from compare products page
     * @throws Exception
     */

    @Test(description = "Verify Add To Cart From Compare Products Page", dataProvider = "browsers")
    public void compProd_VerifyItemsCouldBeAddToCartFromCompareProductsPage(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        // pageManager.homePage().isDisplayedLeftNavgation();
        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().isDisplayedCompareCheckBoxes();
        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().clickCompareTheseButton();
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();

        partNumberFromCompareProductsPage = pageManager.compareTheseItems().getPartNumber();
        productPriceFromCompareProductsPage = pageManager.compareTheseItems().getPrice();
        Log.info("PartNumberFromCompareProductsPage: " + partNumberFromCompareProductsPage);
        Log.info("ProductPriceFromCompareProductsPage: " + productPriceFromCompareProductsPage);
        pageManager.compareTheseItems().clickOnAddToCartButton();
        pageManager.homePage().clickOnShoppingCartIcon();
        partNumberFromSCP = pageManager.shoppingCartPage().getPartNumberText();
        productPriceFromSCP = pageManager.shoppingCartPage().getProductPrice();
        Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
        // description="Verify Product Part Number")
        Assert.assertEquals(partNumberFromSCP, partNumberFromCompareProductsPage);
        //description="Verify Product Price")
        Assert.assertEquals(productPriceFromSCP, productPriceFromCompareProductsPage);
    }
/* this functionality has nothing to do to the test purpose

	@Test(description=" Verify Quantity Field takes upto four digits only")
	public void verifyPartFieldTakesUptoFourDigits() throws Exception
	{
		usersList=pageManager.dBCon().loadDataFromExcel("invalidPartNumber", "QuickOrder");

		String qtyInvalid = usersList.get(0).getQuantity1();
		Log.info(" ******* qtyInvalid: " + qtyInvalid);
		pageManager.compareTheseItems().enterQuantity((usersList.get(0).getQuantity1()));

		String qtyValid = pageManager.compareTheseItems().getQty();
		Log.info(" ******* qtyValid: " + qtyValid );
		Log.info("qtyValid :"+ qtyValid.length());
		Log.info("qtyInvalid :"+ qtyInvalid.length());
		assertNotEquals(qtyValid.length(), qtyInvalid.length());
		assertNotEquals(qtyValid, qtyInvalid);
	}

	*/
}
