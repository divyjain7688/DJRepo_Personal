/**
 *
 *  This is for Smoke Test
 *
 */

package com.selenium.ebiz.prod_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest__End_To_End_2_Prod extends BaseClassV8_Parallel {


	public String newListName;

	/**
	 *  Launching of the Browser and login with Valid Credentials
	 *  Select the Property
	 */

	@Test(priority = 0, description="Login To Application")
	public void testLogin() throws Exception {
		LoginToHDS(configread.getUserName(),configread.getPassword());

		pageManager.homePage().clickPropertyDropdown();
		pageManager.homePage().clickOnAccount0012482411UnderUser();
	}

	@Test(priority = 1, description="Verify Cart is empty")
	    public void testClearCart() throws Exception{
	        pageManager.homePage().clickOnShoppingCartIcon();
	        try{
	            pageManager.shoppingCartPage().shoppingCartEmptyMessage.isDisplayed();
	            Log.info("Cart is Empty :"+ pageManager.shoppingCartPage().shoppingCartEmptyMessage.getText());
	            pageManager.homePage().clickOnHDSupplyLogoInHeader();
	        } catch (Exception e){

	            pageManager.shoppingCartPage().clearShoppingCart();
	            pageManager.homePage().hDSupplyLogoInHeader.click();
	        }

	    }
	  
	  

	@Test(priority = 2, description="Search by Product Description")
	public void searchByProductDescription() throws Exception{
		GetUserList("searchByProductDesc","Search");
		System.out.println(usersList.get(0).getSearchProductKeyword());
		pageManager.homePage().searchDescription(usersList.get(0).getSearchProductKeyword());
		Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
	}

	@Test(priority = 3, description="Add Product to Cart from PLP")
	public void AddProductToCartFromPLP() throws Exception{
		pageManager.productListingPage().clickonFirstProductAddToCart();
		//TODO- add new assertion
	//	Assert.assertTrue(pageManager.productListingPage().isDisplayedAddToCartSuccessPopup());
	//	pageManager.productListingPage().clickOnCloseAddtocartSuccessPopup();
		pageManager.productListingPage().refreshPage();
	}


	@Test(priority = 4, description="Add Product To New Save List From PLP")
	public void AddProductToNewSaveList()
	{
		newListName = "List_";
		pageManager.productListingPage().clickOnProductAddToList(0);
		String newlistcreated = pageManager.productListingPage().addItemToNewList(newListName);
		Log.info("newlistcreated is" + newlistcreated);
		Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
	}



	@Test(priority = 5, description="Verify Alternate Ship To Address ON SC Page")
	public void ValidateAddreessOnShoppingCart(){

		driver.navigate().refresh();
		pageManager.homePage().shoppingCartIcon.click();
		Log.info("scrolltoViewElement.click");
		pageManager.shoppingCartPage().getAlternateOptionFromShippingtoDrpDown();
	}


	@Test(priority = 6, description="Quick Order Peachtree Product from SC page")
	public void QuickOrderPeachTreeProductFromShoppingCart() throws Exception
	{
		pageManager.shoppingCartPage().clickOnQuickOrderLink();
		Assert.assertTrue(pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad());
		GetUserList("addPeachtreeProductsUsingQuickOrder","QuickOrder");
		Log.info("usersList.get(0).getPartNumber1()"+ usersList.get(0).getPartNumber1());
		Log.info("usersList.get(0).getQuantity1()"+ usersList.get(0).getQuantity1());
		pageManager.quickOrderPad().fillFirstPartNumberTextBox(usersList.get(0).getPartNumber1());

		pageManager.quickOrderPad().fillFirstQuantityTextBox(usersList.get(0).getQuantity1());

		pageManager.captureScreenShot().TakeScreenShot("q order pad");

		pageManager.quickOrderPad().clickOnAddToCartButton();

		//ToDo - add the verification step the part number is added into the sc
	}

	@Test(priority = 7, description="Validate Peachtree Product Message On SC page before customization")
	public void verifyPeachTreeProductOnShoppingCartBeforeCustomization() throws Exception
	{
		Assert.assertTrue(pageManager.shoppingCartPage().mustBeCustomizedMessage.isDisplayed());
		Assert.assertTrue(pageManager.shoppingCartPage().isCustomizeThisItemLinkDisplayed());
	}

	@Test(priority = 8, description="Validate PT configurator Text Window")
	public void validatePTConfiguratorTextWindow(){

		pageManager.shoppingCartPage().customizeThisItemLink.click();
		Assert.assertTrue(pageManager.customizeConfigModal().isPTConfiguratorModalWindowDisplayed());
	}

	@Test(priority = 9, description="Customize peachTree Product And Do Add To Cart")
	public void customizePeachTreeProductAndAddToCart() throws Exception
	{
		GetUserList("customizePeachTreeProductAndAddToCart","CustomizePeachTreeItem");
		pageManager.customizeConfigModal().switchToIframeAndFillTheForm(usersList.get(0).getFlatOrAssemble(), usersList.get(0).getLabelFormat(),
				usersList.get(0).getColor(), usersList.get(0).getStyle(), usersList.get(0).getImprintLine1(),
				usersList.get(0).getImprintLine2(), usersList.get(0).getImprintLine3(),usersList.get(0).getImprintLine4(),
				usersList.get(0).getImprintLine5(), usersList.get(0).getImprintLine6(), usersList.get(0).getImprintLine7(),
				usersList.get(0).getComments());
	}

	@Test(priority = 10, description="Validate Peachtree Product Message On SC page after customization")
	public void verifyPeachTreeProductOnShoppingCartAfterCustomization() throws Exception
	{
	//	Assert.assertTrue(pageManager.shoppingCartPage().youHaveCutomizedLink.isDisplayed());
		Assert.assertTrue(pageManager.shoppingCartPage().isYouHaveCustomizeLinkDisplayed());	
	}


	@Test(priority = 11, description="Continue To Checkout Page")
	public void NavigateToAddPaymentAndCheckoutPage() throws Exception
	{
		pageManager.shoppingCartPage().clickonCheckOutButton();

	}

	@Test(priority = 12, description="Validate Cart Summary")
	public void validateCartSummary() throws Exception{
		String subtotalValue = pageManager.paymentAndCheckOutPage().displayedSubtotalValue();
		String shippingValue = pageManager.paymentAndCheckOutPage().displayShippingValuealValue();
		String taxValue = pageManager.paymentAndCheckOutPage().displayedTaxValue();
		String totalValue = pageManager.paymentAndCheckOutPage().displayedTotalValue();
		Log.info("SubtotalValue: " +subtotalValue);
		Log.info("shippingValue: " +shippingValue);
		Log.info("TaxValue: "+taxValue);
		Log.info("TotalValue: "+totalValue);
	}

	@Test(priority = 13, description="Place web order")
	public void placeWebOrder() throws Exception{
		pageManager.paymentAndCheckOutPage().insertPONumber();
		Log.info("*******Inserted PO number**********");
		pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();

	}

	@Test(priority = 14, description="Capture Web Order Number",enabled=false)
	public void captureWebOrderNumber() throws Exception{
		String orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
		Log.info("orderNumber is "+ orderNumber);
	}


}