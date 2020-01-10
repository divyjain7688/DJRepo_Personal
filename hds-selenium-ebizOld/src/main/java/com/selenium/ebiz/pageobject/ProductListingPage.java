package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class ProductListingPage extends BaseClass 
{
	public ProductListingPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf((sortByLabel)));
	}

	@FindBy(xpath = "//a[text()='New']")
	WebElement addToListNewTab;

	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement newListNameEdit;

	@FindBy(xpath = "//div[@class='listCreate']//button[contains(text(),'Create List')]")
	WebElement createListButton;

	@FindBy(xpath="//span[text()='Sort by:']")
	WebElement sortByLabel;
	
	@FindBy(xpath="//div[@class=\"cart-added__details\"]//a[contains(text(),'Checkout')]")
	WebElement checkoutButtonOnAddToCartPopup;
	
	@FindBy(xpath="//div[@class='breadcrumbs']")
	WebElement breadcrumb;

	@FindBy(xpath="//div[@class='breadcrumbs']//a[contains(text(),'Home')]")
	WebElement homeLinkOnBreadcrumb;
	
	@FindBy(xpath="//a[@class='jq-subcat--toggle-list']")
	WebElement productListingPageListViewButton;

	@FindBy(xpath="//a[@class='jq-subcat--toggle-grid']")
	WebElement productListingPageGridViewButton;

	@FindBy(xpath="//div[@class='subcat-grid-tile-container']")
	WebElement productListingPageGridView;

	@FindBy(xpath="//div[@class='subcat-list-tile-container']")
	WebElement productListingPageListView;

	@FindBy(xpath="//div[@class='subcat-grid-tile-container']//section[@class='subcat-grid-tile'][1]//label[@class='header__compare']//span[1]")
	WebElement productListingPageFirstProductCheckbox;

	@FindBy(xpath="//div[@class='subcat-grid-tile-container']//section[@class='subcat-grid-tile'][1]/div[@class='type--center']")
	WebElement productListingPageFirstProduct;
	
	@FindBy(xpath="//div[@class='subcat-grid-tile-container']//section[@class='subcat-grid-tile'][1]/div[@class='type--center']/..//*[contains(text(),'Add to List')]")
	WebElement productListingPageFirstProductAddToList;
	

	@FindBy(xpath="//div[@class='subcat-grid-tile-container']//section[@class='subcat-grid-tile'][1]/div[@class='subcat-grid-tile__header type--caption input-group compare_target']/span[1]")
	WebElement productListingPageFirstProductPartNumber;
	
	
	@FindBy(xpath="//section[@class='subcat-grid-tile'][1]//button[@title='Add To Cart']")
	WebElement productListingPageFirstProductAddToCart;
	
	@FindBy(xpath="//section[@class='subcat-grid-tile'][2]//button[@title='Add To Cart']")
	WebElement productListingPageSecondProductAddToCart;
	
	@FindBy(xpath="//div[@class='modal modal--visible']//a[@class='modal__close jq-close-modal']")
	WebElement closeAddtocartSuccessPopup;

	@FindBy(xpath="//div[@class='subcat-grid-tile-container']//section[@class='subcat-grid-tile'][2]//label[@class='header__compare']//span[1]")
	WebElement productListingPageSecondProductCheckbox;

	@FindBy(xpath="//div[@class='subcat-grid-tile-container']//section[@class='subcat-grid-tile'][3]//label[@class='header__compare']//span[1]")
	WebElement productListingPageThirdProductCheckbox;

	@FindBy(xpath="//div[@class='subcat-grid-tile-container']//section[@class='subcat-grid-tile'][4]//label[@class='header__compare']//span[1]")
	WebElement productListingPageFourthProductCheckbox;

	@FindBy(xpath="//div[@class='subcat-grid-tile-container']//section[@class='subcat-grid-tile'][5]//label[@class='header__compare']//span[1]")
	WebElement productListingPageFifthProductCheckbox;

	@FindBy(xpath="//section[@class='compare-floating-widget']")
	WebElement compareProductWidgets;

	@FindBy(xpath="//section[@class='compare-floating-widget']/div[@class='compare-floating-widget__items']/div[1]")
	WebElement compareProductWidgetsFirstProductSelected;

	@FindBy(xpath="//section[@class='compare-floating-widget']/div[@class='compare-floating-widget__items']/div[2]")
	WebElement compareProductWidgetsSecondProductSelected;

	@FindBy(xpath="//section[@class='compare-floating-widget']/div[@class='compare-floating-widget__items']/div[3]")
	WebElement compareProductWidgetsThirdProductSelected;

	@FindBy(xpath="//section[@class='compare-floating-widget']/div[@class='compare-floating-widget__items']/div[4]")
	WebElement compareProductWidgetsFourthProductSelected;

	@FindBy(xpath="//section[@class='compare-floating-widget']/div[@class='compare-floating-widget__items']/div[1][text()='+']")
	WebElement compareProductWidgetsFirstProductDeselected;

	@FindBy(xpath="//section[@class='compare-floating-widget']/div[@class='compare-floating-widget__items']/div[2][text()='+']")
	WebElement compareProductWidgetsSecondProductDeselected;

	@FindBy(xpath="//section[@class='compare-floating-widget']/div[@class='compare-floating-widget__items']/div[3][text()='+']")
	WebElement compareProductWidgetsThirdProductDeselected;

	@FindBy(xpath="//section[@class='compare-floating-widget']/div[@class='compare-floating-widget__items']/div[4][text()='+']")
	WebElement compareProductWidgetsFourthProductDeselected;

	@FindBy(xpath="//div[@aria-labelledby='ui-id-2']//div[@class='widget_product_comparison_popup widget_site_popup']//div[@class='body']")
	WebElement popupWindowMessage;

	@FindBy(xpath="//div[@aria-labelledby='ui-id-2']//div[@class='widget_product_comparison_popup widget_site_popup']//div[@class='button_container ']")
	WebElement popupWindowOkButton;
	
	@FindBy(xpath = "//div[@class='header__main']//div[@id='contentRecommendationWidget_HdsHeaderLogoESpot']")
	WebElement hDSupplyLogoInHeader;

	@FindBy(xpath="//select[@id='orderBy']")
	WebElement sortByDropDown;

	@FindBy(xpath="//div[@class='subcat-header__results']")
	WebElement resultCounterLabel;

	@FindBy(xpath="//div[@class='subcat-grid-tile-container']//section[last()][@class='compare-floating-widget']/div[@class='compare-floating-widget__actions']/button")
	WebElement compareTheseButton;
	
	// This is to Add to Cart Quote
	@FindAll(@FindBy(xpath="//a[starts-with(@id,'add2QuoteBtn')]"))
	List<WebElement> subCategoryAddToQuote;	

	@FindBy(xpath = "//div[@class='quote-add__footer']//button[@id='createNewQuoteBtn']")
	WebElement createQuoteButton;
	
	@FindBy(xpath="//div[starts-with(@id,'container_')]/div/div/div/section[1]/div[1]/span")
	WebElement searchPartNumberText;

	@FindBy(className = "subcat-grid-tile")
	WebElement productAvailableLinkText;	

	@FindBy(linkText = "Saved Lists")
	WebElement topHeadersavedlistLinkText;

	@FindBy(xpath = "//div[contains(@id,'PageHeading_2')]/h1")
	WebElement productPageHeader;

	//breadcrum displayed in current page
	@FindBy(xpath = "//div[@class='breadcrumbs']")
	WebElement currentPagebreadCrumbHomeLinkText;

	@FindBy(xpath = "//a[@class='modal__close jq-close-modal']")
	WebElement closePopupMsg;

	@FindBy(xpath="//div[@class='main__cart-info']//a[@id='widget_minishopcart'][@role='button']")  
	WebElement shoppingCartIcon;
	
	// Text of Price
	@FindBy(xpath="//div[starts-with(@id,'section_0_10_-3004_')]/a")
	WebElement searchPriceText;

	// Checkbox of Brand
	@FindBy(xpath="//label[starts-with(@id,'facet_98114971101005887104105114108112111111108_10_-3004_')]/span")
	WebElement searchBrandCheckbox;
	
	//Product Image
	@FindBy(xpath = "//img[starts-with(@id,'productThumbNailImage_')]")
	WebElement productImage;
	
	//Add to Quote
	@FindBy(id="add2QuoteBtn")
	WebElement addToQuoteButton;
	
	@FindBy(xpath = "//div[@class='quotes-add__new-input']//input[@class='jq-quote-add--input']")
	WebElement quoteNameEdit;
	
	@FindBy(xpath = "//div[@id='msgpopup_content_wrapper']")
	WebElement quoteSuccessPopup;
	
	@FindBy(xpath = "//div[@class='close_icon']")
	WebElement closeQuoteSuccessPopupIcon;
	
	@FindBy(xpath = "//div[@class='tabs__bar']//a[@class='tabs__tab jq-tabs--toggle']")
	WebElement newTab;
	
	@FindBy(xpath="//div[@class='subcat-grid-tile-container']/section[1]//section[@class='number-stepper']/button[text()='+']")
	WebElement increaseQuantityButton;
	
	@FindBy(xpath="//div[@class='subcat-grid-tile-container']/section[1]//section[@class='number-stepper']/button[text()='-']")
	WebElement decreaseQuantityButton;
	
	@FindBy(xpath="//div[@class='subcat-grid-tile-container']/section[1]//section[@class='number-stepper']/input")
	WebElement quantityEdit;
	
	// This is to Add to Cart Button
	@FindAll(@FindBy(xpath="//a[starts-with(@id,'listViewAdd2Cart_')]"))
	List<WebElement> subCategoryAddToCartButton;	

	// Verify to display of Price
	public boolean isDisplayedSearchPriceText(){
		System.out.println("Inside price Text");
		return CommonFunctions.isElementPresent(searchPriceText);
	}

	// Text of Brand
	@FindAll(@FindBy(xpath="//div[starts-with(@id,'section_mfName_ntk_cs_10_-3004_')]/a"))
	WebElement searchBrandText;

	// Verify to display of Price
	public boolean isDisplayedSearchBrandText(){
		System.out.println("Inside Brand Text");
		return CommonFunctions.isElementPresent(searchBrandText);
	}

	/**
	 * @return the Search Part Number
	 */
	public String getSearchPartNumberText() {
		return searchPartNumberText.getText().trim();
	}


	/**
	 * Method to click on Price checkbox
	 * @return boolean true\false
	 */
	public ProductListingPage clickSearchBrandCheckbox() {
		WaitTool.waitForElement(driver,	searchBrandCheckbox);
		searchBrandCheckbox.click();
		WaitTool.waitFor(driver, true);
		return new ProductListingPage(driver);
	}
	
	/**
	 * Method to click on Product Image
	 * @return boolean true\false
	 */
	public ProductDetailsPage clickProductImage() {
		//WaitTool.waitForElement(driver,	searchBrandCheckbox);
		productImage.click();
		//WaitTool.waitFor(driver, true);
		return new ProductDetailsPage(driver);
	}


	/**
	 * @description: Method to verify if is product is displayed to randomly click on first product
	 * @return true if product is displayed
	 */
	public boolean verifyProductsDisplayed() throws InterruptedException {
		try	{
			//System.out.println(productList.size());
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


	public Boolean isDisplayedAddToCartSuccessPopup()
	{
		WaitTool.waitForElement(driver, closeAddtocartSuccessPopup);
		return closeAddtocartSuccessPopup.isDisplayed();
	}


	public Boolean isGridViewDisplayed()
	{
		return productListingPageGridView.isDisplayed();
	}

	public Boolean isListViewDisplayed()
	{
		return productListingPageListViewButton.isDisplayed();
	}

	public void clickonFirstCheckbox()
	{
		CommonFunctions.scrolltoViewElement(productListingPageFirstProductCheckbox, driver);
		productListingPageFirstProductCheckbox.click();
	}

	public void clickonFirstProductAddToCart()
	{
		WaitTool.waitForElement(driver, productListingPageFirstProductAddToCart);
		CommonFunctions.scrolltoViewElement(productListingPageFirstProductAddToCart, driver);
		productListingPageFirstProductAddToCart.click();
	}
	
	public void clickonSecondProductAddToCart()
	{
		CommonFunctions.scrolltoViewElement(productListingPageSecondProductAddToCart, driver);
		productListingPageSecondProductAddToCart.click();
	}
	
	public void clickOnCloseAddtocartSuccessPopup()
	{
		WaitTool.waitForElement(driver,closeAddtocartSuccessPopup);
		CommonFunctions.scrolltoViewElement(closeAddtocartSuccessPopup, driver);
		closeAddtocartSuccessPopup.click();
		WaitTool.waitForElement(driver, sortByLabel);
	}
	
	public void refreshPage()
	{
		CommonFunctions.refresh(driver);
	}
	
	public void clickonSecondCheckbox()
	{
		CommonFunctions.scrolltoViewElement(productListingPageSecondProductCheckbox, driver);
		productListingPageSecondProductCheckbox.click();
	}

	public void clickonThirdCheckbox()
	{
		CommonFunctions.scrolltoViewElement(productListingPageThirdProductCheckbox, driver);
		productListingPageThirdProductCheckbox.click();
	}

	public void clickonFourthCheckbox()
	{
		CommonFunctions.scrolltoViewElement(productListingPageFourthProductCheckbox, driver);
		productListingPageFourthProductCheckbox.click();
	}

	public void clickonFifthCheckbox()
	{
		CommonFunctions.scrolltoViewElement(productListingPageFifthProductCheckbox, driver);
		productListingPageFifthProductCheckbox.click();
	}

	public Boolean isComapreProductWidgetDisplayed()
	{
		CommonFunctions.mouseHover(driver, compareProductWidgets);
		Boolean flag = compareProductWidgets.isDisplayed();
		return flag;
	}

	public Boolean isFirstProductOnProductWidgetSelected()
	{
		Boolean flag = compareProductWidgetsFirstProductSelected.isDisplayed();
		return flag;
	}

	public Boolean isSecondProductOnProductWidgetSelected()
	{
		Boolean flag = compareProductWidgetsSecondProductSelected.isDisplayed();
		return flag;
	}

	public Boolean isThirdProductOnProductWidgetSelected()
	{
		Boolean flag = compareProductWidgetsThirdProductSelected.isDisplayed();
		return flag;
	}

	public Boolean isFourthProductOnProductWidgetSelected()
	{		
		CommonFunctions.scrolltoViewElement(productListingPageFifthProductCheckbox, driver);
		Boolean flag = compareProductWidgetsFourthProductSelected.isDisplayed();
		return flag;
	}

	public Boolean isFirstProductOnProductWidgetDeselected()
	{
		Boolean flag = compareProductWidgetsFirstProductDeselected.isDisplayed();
		return flag;
	}

	public Boolean isSecondProductOnProductWidgetDeselected()
	{
		Boolean flag = compareProductWidgetsSecondProductDeselected.isDisplayed();
		return flag;
	}

	public Boolean isThirdProductOnProductWidgetDeselected()
	{
		Boolean flag = compareProductWidgetsThirdProductDeselected.isDisplayed();
		return flag;
	}

	public Boolean isFourthProductOnProductWidgetDeselected()
	{		
		CommonFunctions.scrolltoViewElement(productListingPageFifthProductCheckbox, driver);
		Boolean flag = compareProductWidgetsFourthProductDeselected.isDisplayed();
		return flag;
	}

	public String isTextOnPopupWindowDisplayed() 
	{
		String text = popupWindowMessage.getText();
		popupWindowOkButton.click();
		return text;
	}

	public void scrollUp()
	{
		CommonFunctions.scrollUp(driver);
	}

	public void scrollDown()
	{
		CommonFunctions.scrollDown(driver);
	}

	public Boolean isSortByLabelDisplayed()
	{
		return sortByLabel.isDisplayed();
	}

	// public List isSortByDropDownDisplayed()
	public List getSortByDropDownList()
	{
		Select select = new Select(sortByDropDown);  
		List<WebElement> options = select.getOptions();  
		return options;
	}

	public Boolean isResultCounterDisplayed() 
	{
		return resultCounterLabel.isDisplayed();
	}

	public CompareTheseItems clickCompareTheseButton()
	{
		CommonFunctions.scrolltoViewElement(compareTheseButton, driver);
		compareTheseButton.click();
		return new CompareTheseItems(driver);
	}

	
	public String getFirstProductPartNumber() 
	{
		WaitTool.waitForElement(driver, productListingPageFirstProductPartNumber);
		CommonFunctions.scrolltoViewElement(productListingPageFirstProductPartNumber, driver);
		return productListingPageFirstProductPartNumber.getText();
	}
	public ProductDetailsPage clickOnFirstProduct()
	{
		productListingPageFirstProduct.click();
		return new ProductDetailsPage(driver);
	}
	
	// Method to get Quantities from the product
	public String getQuantity() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		CommonFunctions.scrolltoViewElement(quantityEdit, driver);
		System.out.println("quantity value is " +quantityEdit.getAttribute("value") );
		return quantityEdit.getAttribute("value").trim();
	}
	
	//Method to enter Quantities
	public void enterQuantity(String quantity) {
		quantityEdit.clear();
		quantityEdit.sendKeys(quantity);
	}
	
	// Method to click on increase the quantity
	public void clickIncreaseQuantity() throws InterruptedException {
		increaseQuantityButton.click();
		WaitTool.waitFor(driver,true);
	}
	
	// Method to click on decrease the quantity
	public void clickDecreaseQuantity() throws InterruptedException {
		decreaseQuantityButton.click();
		WaitTool.waitFor(driver,true);
	}

	
	@FindAll(@FindBy(xpath="//div[@class='subcat-grid-tile-container']/section/div[starts-with(@id,'CatalogEntryProdImg')]"))
	List<WebElement> productList;
	
	@FindAll(@FindBy(xpath="//div[@class='subcat-grid-tile-container']/section[@class='subcat-grid-tile']"))
	List<WebElement> productListGrid;
	
	@FindAll(@FindBy(xpath="//div[@class='subcat-grid-tile-container']/section[@class='subcat-grid-tile']/descendant::button[contains(text(),'Add to List')]"))
	List<WebElement> productsListAddToListBtn;
	
	public void clickOnListView() throws Exception
	{
	//WaitTool.waitForElement(driver, productListingPageListViewButton);
	CommonFunctions.scrolltoViewElement(productListingPageListViewButton, driver);
	productListingPageListViewButton.click();
	WaitTool.hardWait();

	} 

	public CreateNewSavedListPage addAllProductsToAddToList(){
		for(int i=0;i<=productListGrid.size();i++) {
			productsListAddToListBtn.get(i).click();
			return new CreateNewSavedListPage(driver);			
		}
		return null;
	}
	
	// Method to Select on any subcategories to Add to Cart
	public List<WebElement> selectSubCategoriesAddtoQuote() throws InterruptedException {
		WaitTool.waitFor(driver,true) ;	
		return subCategoryAddToQuote;			
	}
	
	// Method to Select on any subcategories to Add to Cart
	public List<WebElement> selectSubCategoriesAddtoCartButton() throws InterruptedException {
		WaitTool.waitFor(driver,true) ;	
		return subCategoryAddToCartButton;			
	}
	
	public void clickAddToQuoteButton(){
		addToQuoteButton.click();
	}
	
	public boolean isDisplayedCreateQuoteButton(){
		return createQuoteButton.isDisplayed();
	}
	
	public void clickCreateQuoteButton(){
		createQuoteButton.click();
	}
	
	public void enterQuoteName(String quote){
		quoteNameEdit.sendKeys(quote);
	}
	
	public Boolean isDisplayedQuoteSuccessPopup()
	{
		return quoteSuccessPopup.isDisplayed();
	}
	
	public void clickCloseQuoteSuccessPopupIcon(){
		closeQuoteSuccessPopupIcon.click();
	}
	
	public HomePage clickOnHDSupplyLogoInHeader()
	{
		CommonFunctions.scrolltoViewElement(hDSupplyLogoInHeader, driver);
		hDSupplyLogoInHeader.click();
		return new HomePage(driver);
	}
	
	public boolean isDisplayedNewTab(){
		return newTab.isDisplayed();
	}
	
	public void clickNewTab(){
		newTab.click();
	}
	
	public ShoppingCartPage clickOnShoppingCartIcon() throws Exception {
		WaitTool.waitForElement(driver, shoppingCartIcon);
		CommonFunctions.scrolltoViewElement(shoppingCartIcon, driver);
		shoppingCartIcon.click();
		return new ShoppingCartPage(driver);
	}
	
	public Boolean isBreadcrumbDisplayed()
	{
		return breadcrumb.isDisplayed();
	}
	
	public HomePage clickOnHomeLinkOnBreadcrumb()
	{
		homeLinkOnBreadcrumb.click();
		return new HomePage(driver);
	}
	
	public void clickOnFirstProductAddToList()
	{
		CommonFunctions.scrolltoViewElement(productListingPageFirstProductAddToList, driver);
		productListingPageFirstProductAddToList.click();
	}
	
	public String addItemToNewList(String newListName) {
		addToListNewTab.click();
		String random = CommonFunctions.getRandomString(4);
		newListName = newListName + random;
		newListNameEdit.sendKeys(newListName);
		createListButton.click();
		return newListName;
	}
	
	public ShoppingCartPage clickOnCheckoutButtonOnAddToCartPopup()
	{
		WaitTool.waitForElement(driver, checkoutButtonOnAddToCartPopup);
		CommonFunctions.scrolltoViewElement(checkoutButtonOnAddToCartPopup, driver);
		checkoutButtonOnAddToCartPopup.click();
		return new ShoppingCartPage(driver);
	}
	
	public int counterIncrease(int counterValue)
	{
		counterValue=counterValue+1;
		return counterValue;
	}

	public int counterDecrease(int counterValue)
	{
		counterValue = counterValue-1;
		System.out.println("Decreasing counter " + counterValue);
		return counterValue;
	}
}
