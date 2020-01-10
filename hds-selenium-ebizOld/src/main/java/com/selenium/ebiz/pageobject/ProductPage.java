package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class ProductPage extends BaseClass{

	public ProductPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(productAvailableLinkText));		
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
		WaitTool.hardWait();
		System.out.println(productList.get(0));
		WaitTool.waitForElement(driver, productList.get(0));
		productList.get(0).click();
		WaitTool.waitFor(driver,true);	
		return new ProductDetailsPage(driver);
	}

	//Method to verify if is product is displayed to randomly click on first product
	public String getHeaderName() throws Exception {
		WaitTool.hardWait();
		return productPageHeader.getText().trim();			
	}
	
	public boolean isDisplayedtopHeadersavedlistLinkText(){
		return CommonFunctions.isElementPresent(topHeadersavedlistLinkText);
	}

	/**
	 * @name verifyBreadCrumbForCurrentPage
	 * @description Method to verify BreadCrumb For CurrentPage
	 * @param text value (current page)
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
	

	//Method to Click on SavedList in utility bar {once clicked not sure to which its navigated.)
	public SavedListsPage clickSavedListUtilityBar() throws InterruptedException {
		WaitTool.waitForElement(driver,	topHeadersavedlistLinkText);
		topHeadersavedlistLinkText.click();
		WaitTool.waitFor(driver, true);
		return new SavedListsPage(driver);
	}


}

