package com.selenium.ebiz.add_to_cart.old_add_to_cart_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ShoppingCartDefaultShippingAddress_WORKING extends BaseClassV8_Parallel {
	/**
	 * @storyDescription :  To verify As a user I want my default shipping address to appear on the Shopping Cart page
	 * @US :US-Ord-205
	 * @author Lakshmi
	 * @modified Iuliia
	 * @data 12/17/2018
	 */

    private String shippingAddressLine1OnSC;
    private String shippingAddressLine2OnSC;
    private String shippingAddressLine3OnSC;
    private String shippingAddressLine1OnMA;
    private String shippingAddressLine2OnMA;
    private String shippingAddressLine3OnMA;
    private String shippingAddressLine1OnSCForND;
    private String shippingAddressLine2OnSCForND;
    private String shippingAddressLine3OnSCForND;


	@Test(description = "loginWithValidCredentialAndLogoutTest")
	public void test_login() throws Exception {
		LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

		//	usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		//	homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

	}

	@Test(priority = 1)
	public void test_clearCart() throws Exception {
		pageManager.shoppingCartPage().checkClearShoppingCart();
		Log.info("Check and clear Shopping cart");
	}


	@Test(priority = 2)
	public void test_addProductIntoShoppingCart() throws Exception {
		//usersList = dbConnection.loadDataFromExcel("verifyMyAccountsPageLinks","MyAccount");
		GetUserList("verifyMyAccountsPageLinks", "MyAccount");
		/*usersList = dbConnection.loadDataFromExcel("verifyBreadCrumbForCurrentPageUnautheticateduser","Categories");
			homePage.clickHeaderShopByCategoryLinkText();
			waitTool.hardWait();
			productListingPage = homePage.clickonCategoriesToreachProductList(driver, usersList.get(0).getCategory(),usersList.get(0).getL1SubCategory(),usersList.get(0).getL2SubCategory());
			Assert.assertTrue(productPage.verifyProductsDisplayed());
			productDetailsPage = productPage.clickFirstProductInProductList();
			//verify if user is able to select a product and product details page is displayed.
			Assert.assertTrue(productDetailsPage.isDisplayedproductDetailsHeader());
			productDetailsPage.clickAddToCartButton();
			waitTool.hardWait();
			homePage =productDetailsPage.clickcloseAddtocartSuccessPopup();
			waitTool.hardWait();
			homePage.clickHeaderMyCartLinkTextAfterAddTocart();
			shoppingCartPage = homePage.clickHeaderMyCartLinkText();*/


		pageManager.homePage().moveToSubCategoryPage();
		pageManager.productListingPage().clickOnProductByInt(0);
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.productDetailsPage().clickOnCloseAddtocartSuccessPopup();
		driver.navigate().refresh();
		pageManager.homePage().clickOnShoppingCartIcon();
	}

	@Test(priority = 3)
	public void test_verifyShoppingCartWithDefaultOptionFromShippingAddress() throws Exception {


			//Verify that Ship to Address is displayed
			pageManager.shoppingCartPage().selectDefaultOptionFromShippingDropdown();

		//	waitTool.waitForElement(driver,pageManager.shoppingCartPage().shippingToDropdown);
			waitTool.waitForElement(driver,pageManager.shoppingCartPage().shipToAddressText);
			driver.navigate().refresh();

		//	Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShippingAddressText());

			shippingAddressLine1OnSC = pageManager.shoppingCartPage().getShippingAddressLine1Text();
			shippingAddressLine2OnSC = pageManager.shoppingCartPage().getShippingAddressLine2Text();
			shippingAddressLine3OnSC = pageManager.shoppingCartPage().getShippingAddressLine3Text();

			pageManager.homePage().clickAccountLinkText();
			Log.info("Click Account link text");

			shippingAddressLine1OnMA = pageManager.myAccountPage().getShippingAddressLine1Text();
			shippingAddressLine2OnMA = pageManager.myAccountPage().getShippingAddressLine2Text();
			shippingAddressLine3OnMA = pageManager.myAccountPage().getShippingAddressLine3Text();

			Assert.assertEquals(shippingAddressLine1OnSC, shippingAddressLine1OnMA);
			Assert.assertEquals(shippingAddressLine2OnSC, shippingAddressLine2OnMA);
			Assert.assertEquals(shippingAddressLine3OnSC, shippingAddressLine3OnMA);
			pageManager.homePage().clickOnShoppingCartIcon();
			Log.info("Click on SC from my account page");
		}


		@Test(priority = 4)
		public void test_verifyShoppingCartWith_NON_DefaultOptionFromShippingAddress() throws Exception {

            pageManager.shoppingCartPage().selectNonDefaultOptionFromShippingDropdown();
            waitTool.waitForElement(driver,pageManager.shoppingCartPage().shippingToDropdown);
            waitTool.waitFor(driver,true);
            driver.navigate().refresh();

            shippingAddressLine1OnSCForND = pageManager.shoppingCartPage().getShippingAddressLine1Text();
            shippingAddressLine2OnSCForND = pageManager.shoppingCartPage().getShippingAddressLine2Text();
            shippingAddressLine3OnSCForND = pageManager.shoppingCartPage().getShippingAddressLine3Text();

            Assert.assertNotEquals(shippingAddressLine1OnSCForND, shippingAddressLine1OnMA);
            Assert.assertNotEquals(shippingAddressLine2OnSCForND, shippingAddressLine2OnMA);
            Assert.assertNotEquals(shippingAddressLine3OnSCForND, shippingAddressLine3OnMA);
        }

        @Test(priority = 5)
         public void test_addNewAddressLink() throws Exception {
			pageManager.shoppingCartPage().addNewAddressLink.click();
			//waitTool.hardWait();
			Assert.assertTrue(pageManager.shoppingCartPage().isAddNewAddressModalWindowDisplayed());
			String shippingAddressName= "New name" + pageManager.common().getRandomNumber();
			String companyOrPropertyName= usersList.get(0).getCompanyOrPropertyName();

			pageManager.shoppingCartPage().createNewAddress(
			    //    usersList.get(0).getShippingAddressName()
                   shippingAddressName,
                    companyOrPropertyName,
                 //   usersList.get(0).getCompanyOrPropertyName(),
                    usersList.get(0).getAddress(),
					usersList.get(0).getCity(),
                    usersList.get(0).getState(),
                    usersList.get(0).getZipCode(),
                    usersList.get(0).getPhoneNumber());

            driver.navigate().refresh();


            Log.info(pageManager.shoppingCartPage().getShippingAddressLine1Text() + "  and  " + companyOrPropertyName);
            Assert.assertEquals(pageManager.shoppingCartPage().getShippingAddressLine1Text(), usersList.get(0).getCompanyOrPropertyName());

            waitTool.waitForElement(driver,pageManager.homePage().accountIcon);


			pageManager.homePage().clickAccountLinkText();
			pageManager.myAccountPage().goToAddressBook();
			pageManager.myAccountPage().clickOnDeleteButtons();


		/*			//Verify that default Shipping Address is displayed as the default Ship To Address
			System.out.println("actual adress =====================" +addres);
			//Assert.assertTrue(addres.equalsIgnoreCase("default"));
			Assert.assertTrue(shoppingCartPage.isDisplayedShippingToDropDown());
			//Verify that there is a dropdown menu for the user to select a different address from the list of saved addresses
			Assert.assertTrue(shoppingCartPage.selectShippingtoAddressApartfromDefaultaddress());
			waitTool.hardWait();
			//Verify that Dropdown menu allows user to select a different address from the list of addresses saved 
			String addres1 = shoppingCartPage.getFirstSelectedOptionFromShippingtoDrpDown();
			Assert.assertFalse(addres.equalsIgnoreCase(addres1),"Address have been change after selecting new address");*/
		}
	}



