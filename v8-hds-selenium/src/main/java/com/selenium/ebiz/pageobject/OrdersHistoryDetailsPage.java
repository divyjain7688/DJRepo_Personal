package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class OrdersHistoryDetailsPage{
	private  WebDriver driver; 
	private WaitTool waitTool;
	private PageManager pageManager;

	public OrdersHistoryDetailsPage(WebDriver driver) 	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		this.pageManager = new PageManager(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//h1[@data-hds-tag='order-history-details__heading'][contains(text(),'Order History Detail')]")
	WebElement orderHistoryDetailsTitle;

	@FindBy(xpath="//*[@data-hds-tag='order-history-details__header__order-number']")
	public WebElement orderNumber;

	@FindBy(xpath="//div[@data-hds-tag='order-history-details__summary__order-po-number']")
	public WebElement poNumber;

	@FindBy(xpath = "//div[@data-hds-tag='order-history-details__grand-total-price']")
	public WebElement totalPrice;

	@FindBy(xpath = "//*[@data-hds-tag='order-history-details__summary__order-status']")
	public WebElement orderStatus;

	@FindBy(xpath="//span[contains(., 'Add to Cart')]")
	List<WebElement> addToCartButton;
	
	@FindBy(xpath="//a[@class='link--regular']")
	List<WebElement> partNumbers;
	
	@FindBy(xpath = "//div[@data-hds-tag='price']")
	List<WebElement> productPrice;
	
	@FindBy(xpath = "//div[@data-hds-tag='order-history-details__shipment-item__unit-price']")
	List<WebElement> eachProductPrice;
	
	@FindBy(xpath = "//button[@data-hds-tag='order-history-details__actions__add-all-to-cart']")
	WebElement addAllToCartButton;
	
	@FindBy(xpath = "//div[@data-hds-tag='order-history-details__grand-total-price']")
	WebElement totalValue;
	
	//@FindBy(xpath = "//div[@data-hds-tag='order-history-details__shipment-details']//div[@class='shipment-details__items shipment-details__items--collapsed']//div[contains(text(),'Show items')]")
	@FindBy(css = "div.shipment-details__items-toggle-hidden>svg.icon.icon--plus")
	List<WebElement> showItems;

	@FindBy(xpath = "//button[text()='Add All to List']")
	WebElement addAllToListButton;
	
	@FindBy(xpath = "//div[@class='shipment-details__items shipment-details__items--collapsed']//*[@class='icon icon--plus']")
	List<WebElement> showItemsPlusButtons;
	
	public boolean isDisplayedOrderHistoryDetailsTitle(){
		waitTool.waitForElement(driver, orderHistoryDetailsTitle);
		pageManager.common().scrolltoViewElement(orderHistoryDetailsTitle, driver);
		return orderHistoryDetailsTitle.isDisplayed();
	}
	
	public void clickOnFirstAddToCartButton(){

		pageManager = new PageManager(driver);
		int displayedShoppingCartProductCountBeforeAddToCart=pageManager.homePage().getShoppingCartProductCount();
		System.out.println("displayedShoppingCartProductCountBeforeAddToCart   "+ displayedShoppingCartProductCountBeforeAddToCart);
		waitTool.waitForElement(driver, addToCartButton.get(0));
		//pageManager.common().scrolltoViewElement(addToCartButton.get(0), driver);
		addToCartButton.get(0).click();
		waitTool.waitFor(driver, true);
		pageManager.common().scrolltoViewElement(pageManager.homePage().shoppingCartProductCount, driver);
		int displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		while(displayedShoppingCartProductCountAfterAddToCart==displayedShoppingCartProductCountBeforeAddToCart)
		{
			displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		}
		System.out.println("displayedShoppingCartProductCountAfterAddToCart is "+ displayedShoppingCartProductCountAfterAddToCart);
		Assert.assertTrue(displayedShoppingCartProductCountBeforeAddToCart<displayedShoppingCartProductCountAfterAddToCart);
	
	}	
	
	public String getFirstPartNumber() {
		waitTool.waitForElement(driver,partNumbers.get(0));
		String pn=partNumbers.get(0).getText().trim();
		System.out.println("*** Order History Part Number: " + pn);
		return pn;
	}
	
	public String getFirstProductPrice(){
		System.out.println("*** Order History Product Price: " + productPrice.get(0).getText().trim());
		return productPrice.get(0).getText().trim();
	}
	
	public String getFirstProductPriceEach(){
		System.out.println("*** Order History Product Price: " + eachProductPrice.get(0).getText().trim().substring(1, 8));
		return eachProductPrice.get(0).getText().trim().substring(1, 8);
	}

	public void clickOnAddAllToCartButton() throws Exception {
		//pageManager = new PageManager(driver);
		int displayedShoppingCartProductCountBeforeAddToCart=pageManager.homePage().getShoppingCartProductCount();
		System.out.println("displayedShoppingCartProductCountBeforeAddToCart   "+ displayedShoppingCartProductCountBeforeAddToCart);
		
		waitTool.waitForElement(driver, addAllToCartButton);
		pageManager.common().scrolltoViewElement(addAllToCartButton, driver);
		addAllToCartButton.click();
		
		//.refresh(driver);
		int displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		System.out.println("displayedShoppingCartProductCountAfterAddToCart is "+ displayedShoppingCartProductCountAfterAddToCart);
		Assert.assertNotEquals(displayedShoppingCartProductCountBeforeAddToCart,displayedShoppingCartProductCountAfterAddToCart);
		
	}
	
	
	public void clickOnAddAllToListButton() throws Exception {
		addAllToListButton.click();
	}
	
	public boolean isDisplayedTotalValue(){
		waitTool.waitForElement(driver, totalValue);
		pageManager.common().scrolltoViewElement(totalValue, driver);
		return totalValue.isDisplayed();
	}

	public String getTotalValue(){
		waitTool.waitForElement(driver, totalValue);
		System.out.println("*** Order History Detail Page Total Value: " + totalValue.getText());
		return totalValue.getText();
	}
	
	public Double getConvertedTotalValueToInt(){
		Double totalOHDP;
		String total = getTotalValue();
		totalOHDP = Double.parseDouble(total.substring(1));
		System.out.println("totalOHDP: " + totalOHDP);
		return totalOHDP;
	}

	public List<String> getAllPartNumbers() {
		List<String> all_OH_partNum=new ArrayList<>();
	    for(int i=0; i<partNumbers.size(); i++){
	    	all_OH_partNum.add(partNumbers.get(i).getText());
	        System.out.println(partNumbers.get(i).getText());

	    }
	    return all_OH_partNum;
	}
	
	public List<String> getAllProductPrice() {
		List<String> all_OH_productPrice=new ArrayList<>();
	    for(int i=0; i<productPrice.size(); i++){
	    	all_OH_productPrice.add(productPrice.get(i).getText());
	        System.out.println(productPrice.get(i).getText());

	    }
	    return all_OH_productPrice;
	}
	
	public void clickOnShowItems(){
		System.out.println("showItems.size(): " + showItems.size());
		try{
			for(int i=1; i<showItems.size(); i++){
				pageManager.common().scrolltoViewElement(showItems.get(i), driver);
				showItems.get(i).getSize();
				System.out.println("i: " + i);
				System.out.println("showItems.get(i)" + showItems.get(i));
				showItems.get(i).click();
			}
		}catch(Exception e){
			System.out.println(" Didn't find items to show ");
		}
	
		
	}
	
	public void clickOnShowItemsButton()
	{
		try
		{
			if(showItemsPlusButtons.size()>0)
			{
				for(WebElement showItemsPlusButton:showItemsPlusButtons)
				{
					showItemsPlusButton.click();
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("show item plus button not displayed"+showItemsPlusButtons.size() );
		}
	}

}

