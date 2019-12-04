package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MinicartPage
{
	private  WebDriver driver; private WaitTool   waitTool;
	
	public MinicartPage(WebDriver driver) {
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);

	}
	
	//View cart button
	@FindBy(id = "GotoCartButton1")  
	public WebElement viewCartButton;
	
	//Total number of items count on minicart header
	@FindBy(xpath = "//div[@class='header-mini-cart__header__item-count type--semi-bold oswald']")
	public WebElement miniCartHeaderTotalNumberOfItems;
	
	//Minicart subtotal
	@FindBy(xpath = "//span[@class='header-mini-cart__subtotal']")
	public WebElement minicartSubTotal;

	@FindBy(xpath = "//div[@class='header-mini-cart__empty']")
	public WebElement headerMinicartEmpty;	
	
	// MiniCart Popup
	@FindBy(xpath="//a[@id='widget_minishopcart' and @class='selected']")
	WebElement miniShopCartPopup;
	
	/*@FindBy(id = "widget_minishopcart")  
	WebElement shoppingCartIcon;*/
	
	/*public HomePage clickOnShoppingCartIcon() throws Exception {
		//waitTool.hardWait2sec();
		waitTool.waitForElement(driver, shoppingCartIcon);
		shoppingCartIcon.click();
		return new HomePage(driver);
	}*/
	
	/**
	 * click on View Cart button from minicart modal overlay
	 * @return the driver to shopping cart page
	 */
	public ShoppingCartPage clickViewCartButton() throws Exception {
		waitTool.waitForElement(driver, viewCartButton);
		viewCartButton.click();
		waitTool.waitFor(driver, true);
		return new ShoppingCartPage(driver);
	}
	
	/**
	 * @return the text displayed in Minicart if there are no items in the cart
	 */
	public String getHeaderMinicartEmptyText() {
		return headerMinicartEmpty.getText();
		
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
	 * @return the Cart subtotal displayed in the Minicart modal
	 * @throws Exception
	 */
	public String getMinicartSubtotal() throws Exception {
	//	waitTool.hardWait();
		waitTool.waitForElement(driver, minicartSubTotal);
		//System.out.println("Minicart subtotal" +minicartSubTotal.getText().replace("$", ""));
		//return minicartSubTotal.getText().replace("$", "");	
		System.out.println("Minicart subtotal" +minicartSubTotal.getText());
		return minicartSubTotal.getText();
		
	}
}

