package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;


public class SearchPage extends BaseClass
{
	public SearchPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf((searchText)));
	}

	@FindBy(xpath="//div[@class='subcat-list-tile__part-quantity-availability']//span[contains(text(),'PART')]/..")
	WebElement displayedPartNumber;
	
	@FindAll(@FindBy(xpath="//div[@class='subcat-grid-tile-container']/section/div[starts-with(@id,'CatalogEntryProdImg')]"))
	List<WebElement> productList;
	
	@FindAll(@FindBy(xpath="//div[@class='subcat-grid-tile-container']//button[starts-with(@data-hds-tag, 'subcat-tile__add-to-cart')]"))
	List<WebElement> addToCartButton;

	@FindBy(xpath="//div[@dataci_product]")
	WebElement displayedProduct;
	
	@FindBy(xpath="//h1[contains(text(),'Search:')]")
	WebElement searchText;

	@FindBy(xpath="//img[starts-with(@id,'productThumbNailImage_')]")
	WebElement productImageLink;
	
	@FindBy(xpath = "//div[@class='modal__inner']//a[@class='modal__close jq-close-modal']")
	WebElement closeAddtocartSuccessPopup;
	
	@FindBy(xpath = "//div[@class='modal__inner']")
	WebElement AddtocartSuccessPopup;
	
	@FindBy(xpath="//div[@class='main__cart-info']//a[@id='widget_minishopcart'][@role='button']")  
	WebElement shoppingCartIcon;
	
	//@FindBy(xpath = "//div[@class='cart-added__icons']//a[@class='btn btn--large btn--full cart-added__checkout-desktop']")
	@FindBy(xpath="//div[@class='cart-added']//div[@class='cart-added__details']//a[contains(text(),'Checkout')]")
	WebElement checkoutButton;
	
	/**
	 * Clicking on the Product Image
	 */
	public ProductDetailsPage clickProductImageLink() {
		productImageLink.click();
		return new ProductDetailsPage(driver);
	}


	public Boolean isPartNumberDisplayed()
	{
		return displayedPartNumber.isDisplayed();
	}

	public ProductDetailsPage clickOnProduct()
	{
		displayedProduct.click();

		return new ProductDetailsPage(driver);
	}
	
	/**
	 * @description method to click on first products in the product grid.
	 * @return ProductDetailsPage
	 */
	public ProductDetailsPage clickFirstProductInProductList() throws Exception {
		WaitTool.hardWait();
		System.out.println(productList.get(0));
		WaitTool.waitForElement(driver, productList.get(0));
		productList.get(0).click();
		return new ProductDetailsPage(driver);
	}
	
	public void clickFirstProductAddToCartButtonInProductList() throws Exception {
		//WaitTool.hardWait();
		System.out.println(addToCartButton.get(0));
		WaitTool.waitForElement(driver, addToCartButton.get(0));
		addToCartButton.get(0).click();
	}
	
	public Boolean isDisplayedAddToCartSuccessPopup()
	{
		WaitTool.waitForElement(driver, closeAddtocartSuccessPopup);
		return closeAddtocartSuccessPopup.isDisplayed();
	}
	
	public void clickOnCloseAddtocartSuccessPopup()
	{
		closeAddtocartSuccessPopup.click();
	}
	
	public ShoppingCartPage clickOnShoppingCartIcon() throws Exception {
		WaitTool.hardWait();
		shoppingCartIcon.click();
		return new ShoppingCartPage(driver);
	}
	
	public ShoppingCartPage clickOnCheckoutButton(){
		WaitTool.waitForElement(driver, checkoutButton);
		checkoutButton.click();
		return new ShoppingCartPage(driver);
	}
	
	public Boolean isDisplayedCheckoutButton(){
		WaitTool.waitForElement(driver, AddtocartSuccessPopup);
		System.out.println("wating forrrrr AddtocartSuccessPopup");
		CommonFunctions.scrolltoViewElement(checkoutButton, driver);
		System.out.println("scrolltoViewElement forrrrr checkoutButton");
		Boolean flag = checkoutButton.isDisplayed();
		System.out.println("flag value isss" + flag);
		return flag;
	}
}