package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {
	private  WebDriver driver;
	private WaitTool   waitTool;

	public ProductPage(WebDriver driver) 
	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath = "//div[@class='subcat-grid-tile-container']/section/div[2]")
	List<WebElement> productList;	
	
	@FindBy(className = "subcat-grid-tile")
	WebElement productAvailableLinkText;	
	

	@FindBy(linkText = "Saved Lists")
	WebElement topHeadersavedlistLinkText;

	@FindBy(xpath = "//div[contains(@id,'PageHeading_2')]/h1")
	WebElement productPageHeader;

	@FindBy(xpath = "//span[@class= 'breadcrumbs__link--selected']")
	WebElement currentPagebreadCrumbHomeLinkText;

	/**
	 * @description: Method to verify if is product is displayed to randomly click on first product
	 * @return true if product is displayed
	 */
	public boolean verifyProductsDisplayed() throws InterruptedException {
		try	{
			return productList.get(0).isDisplayed();
		}catch(Exception e) {
			return false;
		}

	}

	/**
	 * @description method to click on first products in the product grid.
	 * @return ProductDetailsPage
	 */
	public ProductDetailsPage clickFirstProductInProductList() throws Exception {
		//waitTool.hardWait();
		System.out.println(productList.get(0));
		waitTool.waitForElement(driver, productList.get(0));
		productList.get(0).click();
		waitTool.waitFor(driver,true);	
		return new ProductDetailsPage(driver);
	}

	//Method to verify if is product is displayed to randomly click on first product
	public String getHeaderName() throws Exception {
		//waitTool.hardWait();
		waitTool.waitForElement(driver, productPageHeader);
		return productPageHeader.getText().trim();			
	}

	/**
	 * @name verifyBreadCrumbForCurrentPage
	 * @description Method to verify BreadCrumb For CurrentPage
	 * @return boolean match
	 * 
	 */

	public boolean verifyBreadCrumbForCurrentPage(String subCategoryname) throws InterruptedException {		
		String[] breadCrumb = currentPagebreadCrumbHomeLinkText.getText().split("/");
		if(breadCrumb[breadCrumb.length-1].equalsIgnoreCase(subCategoryname)) {
			return false;
		}
		return true;
	}
	


}

