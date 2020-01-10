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

public class SubCategoryAppliancesPage  extends BaseClass{

	public SubCategoryAppliancesPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		//wait.until(ExpectedConditions.visibilityOf(DishwashersAndRepairText));
		wait.until(ExpectedConditions.visibilityOf(breadCrumbLinkText));
	}
	
	@FindAll(@FindBy(xpath="//button[starts-with(@id,'removeItem_')]"))
	List<WebElement> shoppingCartRemoveButton;
	
	@FindBy(xpath="//a[@id='clickableErrorMessageImg']/div[@class='close_icon']")
	WebElement popupCloseButton;
	
	@FindBy(xpath = "//h1[contains(text(),'Dishwashers & Repair')]")
	WebElement DishwashersAndRepairText;
	
	@FindBy(linkText = "Dryers")
	WebElement subCategoryDryersLinkText;
	
	@FindBy(xpath="//a[@class='btn btn--large btn--full cart-added__checkout-desktop']")
	WebElement modalAddCartCheckOutButton;
	
	@FindBy(xpath="//div[starts-with(@id,'container_')]/div[1]/div/div")
	WebElement breadCrumbLinkText;
	
	@FindBy(xpath = "//div[contains(text(),'Washer & Dryer Repair')]")
	WebElement subCategoryWasherDryerRepairLinkText;
	
	@FindBy(xpath="//a[text()='Dishwashers']")
	WebElement subCategoryDishwashersLinkText;
	
	@FindBy(xpath = "//li[1]/a/div[@class='facetCountContainer']")
	WebElement subCategoryFromLeftNavigation;
	
	@FindBy(xpath = "//h1")
	WebElement subCategoryDishwashersHeading;
	
	@FindAll(@FindBy(xpath="//li/a/div[@class='facetCountContainer']"))
	List<WebElement> subCategoriesLeftFrame;
	
	@FindAll(@FindBy(xpath="//section[@class='subcat-list-tile']/div/div[@class='subcat-list-tile__details']/div[@class='subcat-tile__attributes type--caption']//span[2]"))
	List<WebElement> subCategoriesProductAttriburesText;

	@FindBy(xpath = "//div[@class='pagination']/div/div/span")
	WebElement subCategoryPageNumbersView;
	
	@FindBy(xpath = "//a[@id='WC_SearchBasedNavigationResults_pagination_link_right_categoryResults']")
	WebElement subCategoryFowardPageButton;

	@FindBy(xpath = "//a[@id='WC_SearchBasedNavigationResults_pagination_link_left_categoryResults']")
	WebElement subCategoryBackwardPageButton;

	@FindBy(xpath = "//div[@class='pagination__info']/input[@type='number']")
	WebElement subCategoryPageEdit;
	
	@FindBy(xpath = "//a[@id='WC_SearchBasedNavigationResults_pagination_link_list_categoryResults']")
	WebElement subCategoryListViewLink;
	
	@FindAll(@FindBy(xpath="//a[starts-with(@id,'listViewAdd2Cart_')]"))
	List<WebElement> subCategoryAddToCartButton;	

	@FindBy(xpath = "//div[@class='header-mini-cart__header']")
	WebElement subCategoryAddtoCartText;

	@FindAll(@FindBy(xpath="//img[starts-with(@id,'productThumbNailImage_')]"))
	List<WebElement> imageClick;
	
	@FindBy(xpath="//div[starts-with(@class,'image-viewer__thumbs')]")
	WebElement zoomImage;
	
	@FindBy(xpath="//img[@class='image-viewer__zoom-img']")
	public WebElement viewImage; 
	
	@FindBy(linkText = "×")
	WebElement close;
	
	/**
	 *  Method to Click on checkout in Modal	
	 * @throws InterruptedException
			WaitTool.waitForElement(driver, popupCloseButton);
			popupCloseButton.click();
			WaitTool.waitFor(driver,true) ;
		}
	
	/**
	 *  Method to Remove the Cart is shopping cart page.
	 * @return
	 * @throws InterruptedException
	 */
	public List<WebElement> getShoppingCartRemoveButton() throws InterruptedException {
	/**		WaitTool.waitFor(driver,true) ;	
			System.out.println("shoppingCartRemoveButton"+shoppingCartRemoveButton.size());
			if (shoppingCartRemoveButton.size()>0) {
				
				for(int i =0;i<=shoppingCartRemoveButton.size();i++) {
					shoppingCartRemoveButton.get(0).click();
					WaitTool.waitFor(driver,true) ;
				} 
				
			}*/
			return shoppingCartRemoveButton;
	}

	/**
	 *  Method to Click on checkout in Modal	
	 * @return
	 * @throws InterruptedException
	 */
	public ShoppingCartPage clickModalAddCartCheckOutButton() throws InterruptedException {
			WaitTool.waitForElement(driver, modalAddCartCheckOutButton);
			modalAddCartCheckOutButton.click();
			WaitTool.waitFor(driver,true) ;
			return new ShoppingCartPage(driver);
		}
	
	public boolean isDisplayedBreadCrumb(){
			return CommonFunctions.isElementPresent(breadCrumbLinkText);
		}
	
	/**
	 *  Method to Click on Washer & Dryer Repair in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryWasherDryerRepairLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryWasherDryerRepairLinkText);
			subCategoryWasherDryerRepairLinkText.click();
			WaitTool.waitFor(driver,true) ;
		}
	
		/**
		 *  Method to get Total number of Pages in sub category 
		 * @return
		 * @throws InterruptedException
		 */
	public String getSubCategoryTotalPageNumbers() throws InterruptedException {
			return subCategoryPageNumbersView.getText().trim();
	}
		
		/**
		 *  Method to Click on image in Sub Categories	
		 * @return
		 * @throws InterruptedException
		 */
		public List<WebElement> getSubCategoryLinkText() throws InterruptedException {
				WaitTool.waitFor(driver,true) ;	
				return imageClick;
		}		
		
		public boolean isDisplayedZoomImage(){
			return CommonFunctions.isElementPresent(zoomImage);
		}
		
		public String getZoomImage() {
			System.out.println(viewImage.getCssValue("max-width"));
			System.out.println(viewImage.getAttribute("style"));
			return viewImage.getAttribute("style");
		}
		
		public boolean isDisplayedMorePages(){
			return CommonFunctions.isElementPresent(subCategoryPageNumbersView);
		}
		
		public boolean isDisplayedForwardPages(){
			return CommonFunctions.isElementPresent(subCategoryFowardPageButton);
		}

		public boolean isDisplayedBackwardPages(){
			return CommonFunctions.isElementPresent(subCategoryBackwardPageButton);
		}

		public boolean isDisplayedEditField(){
			return CommonFunctions.isElementPresent(subCategoryPageEdit);
		}
		
		public String getSubCategortName() throws InterruptedException {
			return subCategoryDishwashersHeading.getText().trim();
		}
		
		public String getPageNumberEdit() throws InterruptedException {
			return subCategoryPageEdit.getAttribute("value").trim();
		}

		public ProductPage selectSubCategoriesFromLeftFrame() throws InterruptedException {
			subCategoriesLeftFrame.get(0).click();
			WaitTool.waitFor(driver,true);
			return new ProductPage(driver);				
		}
		
		public List<WebElement> selectSubCategoriesAddtoCartButton() throws InterruptedException {
			WaitTool.waitFor(driver,true) ;	
			return subCategoryAddToCartButton;			
		}

		public List<WebElement> selectSubCategoriesProductAttributesText() throws InterruptedException {
			WaitTool.waitFor(driver,true) ;	
			return subCategoriesProductAttriburesText;			
		}
	
		public String getAddtoCartText() throws InterruptedException {
			WaitTool.waitFor(driver,true) ;
			return subCategoryAddtoCartText.getAttribute("innerHTML").trim();
		}
		
		public ProductPage clickSubCategoryDishwashersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryDishwashersLinkText);
			subCategoryDishwashersLinkText.click();
			WaitTool.waitFor(driver,true);
			return new ProductPage(driver);
		}
		
		public ProductListingPage clickSubCategoryDishwashersLink() throws InterruptedException {
				WaitTool.waitForElement(driver, subCategoryDishwashersLinkText);
				subCategoryDishwashersLinkText.click();
				WaitTool.waitFor(driver,true);
				return new ProductListingPage(driver);
		}
		
		public ProductPage clickSubCategoryDryersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryDryersLinkText);
			subCategoryDryersLinkText.click();
			WaitTool.waitFor(driver,true);
			return new ProductPage(driver);
		}

		public SubCategoryAppliancesPage clickSubCategoryListViewLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryListViewLink);
			subCategoryListViewLink.click();
			WaitTool.waitFor(driver,true);
			return new SubCategoryAppliancesPage(driver);
		}
		
		public ProductListingPage clickSubCategoryListtViewLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryListViewLink);
			subCategoryListViewLink.click();
			WaitTool.waitFor(driver,true);
			return new ProductListingPage(driver);
		}

		public SubCategoryAppliancesPage clickSubCategoryForwardPageButton() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryFowardPageButton);
			CommonFunctions.scrolltoViewElement(subCategoryFowardPageButton, driver);
			subCategoryFowardPageButton.click();
			WaitTool.waitFor(driver,true);
			return new SubCategoryAppliancesPage(driver);
		}

		public SubCategoryAppliancesPage clickSubCategoryBackwardPageButton() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryBackwardPageButton);
			subCategoryBackwardPageButton.click();
			WaitTool.waitFor(driver,true);
			return new SubCategoryAppliancesPage(driver);
		}

		public void enterPageNumber(String pageNumber) {
			subCategoryPageEdit.clear();
			subCategoryPageEdit.sendKeys(pageNumber);
		}
		
		public void alertCancelPopUpWindow() throws Exception {
			Thread.sleep(2000);
			CommonFunctions.cancelPopupMessageBox(driver);
		}

		public void close(){
			close.click();
		}

	
}
