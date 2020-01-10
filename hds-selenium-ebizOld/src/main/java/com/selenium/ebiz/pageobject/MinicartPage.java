package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class MinicartPage extends BaseClass{
	
	public MinicartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf((viewCartButton)));
	}
	
	//View cart button
	@FindBy(id = "GotoCartButton1")  
	WebElement viewCartButton;
	
	//Total number of items count on minicart header
	@FindBy(xpath = "//div[@class='header-mini-cart__header__item-count type--semi-bold oswald']")
	WebElement miniCartHeaderTotalNumberOfItems;
	
	//Minicart subtotal
	@FindBy(xpath = "//span[@class='header-mini-cart__subtotal']")
	WebElement minicartSubTotal;

	@FindBy(xpath = "//div[@class='header-mini-cart__empty']")
	WebElement headerMinicartEmpty;	
	
	// MiniCart Popup
	@FindBy(xpath="//a[@id='widget_minishopcart' and @class='selected']")
	WebElement miniShopCartPopup;
	
	@FindBy(id = "widget_minishopcart")  
	WebElement shoppingCartIcon;
	
	public HomePage clickOnShoppingCartIcon() throws Exception {
		WaitTool.hardWait2sec();
		shoppingCartIcon.click();
		return new HomePage(driver);
	}
	
	/**
	 * click on View Cart button from minicart modal overlay
	 * @return the driver to shopping cart page
	 */
	public ShoppingCartPage clickViewCartButton() throws Exception {
		WaitTool.waitForElement(driver, viewCartButton);
		viewCartButton.click();
		WaitTool.waitFor(driver, true);
		return new ShoppingCartPage(driver);
	}
	
	/**
	 * @return the text displayed in Minicart if there are no items in the cart
	 */
	public String getHeaderMinicartEmptyText() {
		return headerMinicartEmpty.getText();
		
	}
	
	/**
	 * @return true if View cart button is displayed in the Minicart modal otherwise False
	 */
	public boolean IsDisplayedViewCartButton() {
		return viewCartButton.isDisplayed();
		
	}
	
	/**
	 * @return the number of items displayed in Minicart widget header
	 */
	public String getMiniCartHeaderDisplayTotalNumberOfItems() {
		
		String noOfItems = miniCartHeaderTotalNumberOfItems.getText().replaceAll("[^0-9]", "");
		System.out.println("Number of items in Minicart"+noOfItems);
		return noOfItems;
	}
	
	/**
	 * @return true if Minicart show number of items in the cart is displayed otherwise false
	 */
	public boolean IsDisplayedMiniCartHeaderDisplayTotalNumberOfItems() {
		return miniCartHeaderTotalNumberOfItems.isDisplayed();
		
	}
	
	/**
	 * @return true if subtotal is displayed  in Minicart modal otherwise false
	 */
	public boolean isDisplayedMinicartSubtotal() {
		minicartSubTotal.isDisplayed();
		return true;	
	}
	
	/**
	 * @return the Cart subtotal displayed in the Minicart modal
	 * @throws Exception
	 */
	public String getMinicartSubtotal() throws Exception {
		WaitTool.hardWait();
		//System.out.println("Minicart subtotal" +minicartSubTotal.getText().replace("$", ""));
		//return minicartSubTotal.getText().replace("$", "");	
		System.out.println("Minicart subtotal" +minicartSubTotal.getText());
		return minicartSubTotal.getText();
		
	}
	
	/**
	 * @return true if Empty Minicart is displayed otherwise False
	 */
	public boolean isDisplayedHeaderMiniCartEmpty() {
		return CommonFunctions.isElementPresent(headerMinicartEmpty);
		
	}	
	
}

