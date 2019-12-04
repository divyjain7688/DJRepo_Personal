package com.selenium.ebiz.add_to_cart.old_add_to_cart_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartForUnavailableProducts_WORKING extends BaseClassV8_Parallel {

	private int productAddedToCart,displayedShoppingCartProductCount;
	int counter;



	@Test(priority = 0)
	public void test_Login() throws Exception {

		LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        waitTool.waitForElement(driver,pageManager.loginPage().loggedAccountNumberText);

	}

	/*
	 *@storyDescription :  To verify As a user I want to know if there are items in my shopping cart that are unavailable.
	 *@US :US-Ord-203
	 *@author Lakshmi
	 */

	@Test(priority = 1)
	public void test_ClearShoppingCart() throws Exception {
        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Check and clear Shopping cart");

	}
	@Test(priority = 2)
	public void test_AddProductsFromPDP() throws Exception {

		GetUserList("searchForUnavailableProduct", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		pageManager.productListingPage().clickFirstProductInProductList();
		pageManager.productDetailsPage().clickAddToCartButton();
		productAddedToCart = pageManager.homePage().counterIncrease(productAddedToCart);
		Log.info("productAddedToCart is "+ productAddedToCart);
		pageManager.common().refresh();
		displayedShoppingCartProductCount = pageManager.homePage().getShoppingCartProductCount();
		Log.info("displayedShoppingCartProductCount is "+ displayedShoppingCartProductCount);
		Assert.assertEquals(productAddedToCart, displayedShoppingCartProductCount);
	}
	@Test(priority = 3)
	public void verifyShoppingCartForUnavailableProducts() throws Exception {

        counter = pageManager.common().counterIncrease();
        Log.info("counter is" + counter);
        pageManager.homePage().clickOnShoppingCartIcon();

        int pnumber = pageManager.shoppingCartPage().displyedPartNumberText();
        Log.info("pnumber is" + pnumber);
        Assert.assertEquals(pnumber, counter);
    }
    @Test(priority = 4)
    public void verifyShoppingCartCounterEqualsToQStepper()

    {
        int qstepper = pageManager.shoppingCartPage().displayedQuantityStepperText();
        Log.info("qstepper is" + qstepper);
        Assert.assertEquals(qstepper, counter);
    }
    @Test(priority = 5)
    public void verifyShoppingCartCounterEqualsToProductPriceText()

    {
        int prodprice = pageManager.shoppingCartPage().displayedProductPriceText();
        Log.info("prodprice is" + prodprice);
        Assert.assertEquals(prodprice, counter);
    }
    @Test(priority = 6)
    public void verifyShoppingCartCounterEqualsaddToList()
    {
		int addToList = pageManager.shoppingCartPage().isAddToListButtonDisplayed();
		Log.info("addToList is"+ addToList);
		Assert.assertEquals(addToList, counter);

	}


}


