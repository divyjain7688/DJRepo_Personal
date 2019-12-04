package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductListingPage {

	private WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;

	public ProductListingPage(WebDriver driver)
	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager = new PageManager(driver);
	}
	int i;
	 List<String> productCountValue = new ArrayList<String>();

	@FindBy(xpath = "//div[contains(text(),'Part# searched matches this manufacturer number.')]")
	public WebElement manufacturerNumberMessage;
	
	@FindBy(xpath = "//a[text()='New']")
	WebElement addToListNewTab;

	@FindBy(xpath = "//input[@id='name']")
	WebElement newListNameEdit;

	@FindBy(xpath = "//div[@class='listCreate']//button[contains(text(),'Create List')]")
	WebElement createListButton;

	@FindBy(xpath="//span[text()='Sort by:']")
	WebElement sortByLabel;

	@FindBy(xpath="//div[@class='cart-added__details']//a[contains(text(),'Checkout')]")
	WebElement checkoutButtonOnAddToCartPopup;

	@FindBy(xpath="//div[@class='breadcrumbs']")
	WebElement breadcrumb;

	@FindBy(xpath = "//*[@data-hds-tag='breadcrumbs']/a[3]")
    public WebElement filteredBreadCrumb;

    @FindBy(xpath = "//*[@data-hds-tag='breadcrumbs']/a")
    public List<WebElement> listfilteredBreadCrumb;


    @FindBy(xpath = "//*[@class='rich-relevance__block category_page_engage_banner_2_widget_new_rr1']")
	public WebElement bMediaBanner;

	@FindBy(xpath="//div[@class='breadcrumbs']//a[contains(text(),'Home')]")
	WebElement homeLinkOnBreadcrumb;

	@FindBy(xpath="//a[@class='jq-subcat--toggle-list']")
	WebElement productListingPageListViewButton;

	@FindBy(xpath="//a[@class='jq-subcat--toggle-grid']")
	WebElement productListingPageGridViewButton;

	@FindBy(xpath="//div[@class='subcat-grid-tile-container']")
	WebElement productListingPageGridView;

	@FindBy(xpath="//a[@class='jq-subcat--toggle-list']")
	public WebElement productListingPageListView;
	
	@FindBy(xpath="//section[@data-hds-tag='subcat-grid-tile'][1]/div[@class='subcat-grid-tile__description']/a")
	WebElement productListingPageFirstProductName;
	
	@FindBy(xpath="//label[@class='header__compare']//span")
	List<WebElement> compareCheckboxes;

	@FindBy(xpath="//div[@class='subcat-grid-tile-container']//section[@class='subcat-grid-tile'][1]//label[@class='header__compare']//span[1]")
	WebElement productListingPageFirstProductCheckbox;

	@FindBy(xpath="//*[@class='subcat-grid-tile__header type--caption input-group compare_target']/span[1]")
			//"//div[@class='subcat-grid-tile-container']//section[@class='subcat-grid-tile'][1]/div[@class='type--center']")
	List<WebElement> listProductListingPageProductNumber;
	
	@FindBy(xpath="//a[text()='Customize this item']/../../../..//div[@class=\"subcat-grid-tile__header type--caption input-group compare_target\"]/span")
List<WebElement> customizedThisItemProductNumbers;
	
    @FindBy(xpath="//*[@class='subcat-grid-tile__description']")
    public
    List<WebElement> listProductsDescriptionText;

	@FindBy(xpath="//*[contains(text(),'Add to List')]")
	List<WebElement> productListingPageProductAddToList;

	@FindBy(xpath = "//*[@class='product-badge product-badge--red']")
	public List<WebElement> listClearanceBadges;

	@FindBy(xpath = "//*[text()='Limited Stock']")
	public WebElement limitedStockBadge;


	
	@FindBy(xpath="//div[@class='subcat-grid-tile-container']/section//section[@class='number-stepper']/input")
	List<WebElement>  productListingPageProductQuantity;
	
	@FindBy(xpath="//section[@class='subcat-list-tile']//div[@data-hds-tag='subcat-list-tile__part-quantity-availability']/div/section/input")
	List<WebElement> productListingPageListViewProductQuantity;
	
	@FindBy(xpath="//section[@class='subcat-list-tile']//div[@data-hds-tag='subcat-list-tile__part-quantity-availability']/span[@data-hds-tag=\"subcat-list-tile__part\"]")
	List<WebElement> productListingPageListViewPartNumber;
	
	@FindBy(xpath="//section[@class='subcat-grid-tile'][1]//button[@title='Add To Cart']")
	WebElement productListingPageFirstProductAddToCart;
	
	//Do not change the xpath from list to grid. Since this button is called in AddToCartListView method. For grid refer above element.
	@FindAll(@FindBy(xpath="//div[@class='subcat-list-tile-container']//a[starts-with(@data-hds-tag, 'subcat-list-tile__add-to-cart')]"))
	List<WebElement> addToCartButtons;
	
	@FindAll(@FindBy(xpath="//span[@data-hds-tag='subcat-list-tile__part']"))
	List<WebElement> partnumbersInListView;


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

	@FindBy(xpath="//button[@id='compareButton_']")
	WebElement compareThesePartsButton;
	
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
	
	@FindBy(xpath="//div[@class='pagination__info']")
	WebElement pageNumberBlock;

	@FindBy(xpath="//div[@class='subcat-header__results']")
	WebElement resultCounterLabel;	
	
	@FindBy(xpath="//div[@class='subcat-header__results']/span")
	WebElement resultCounterLabelValue;
	
	//@FindBy(xpath="//div[@class='subcat-grid-tile-container']//section[last()][@class='compare-floating-widget']/div[@class='compare-floating-widget__actions']/button")
	@FindBy(xpath="//section[last()][@class='compare-floating-widget']/div[@class='compare-floating-widget__actions']/button")
	WebElement compareTheseButton;
	
	@FindBy(linkText ="//section[@class='compare-floating-widget']//div[@class='compare-floating-widget__actions']//div//a")
	WebElement clearAllLink;

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


	// Text of Price
	@FindBy(xpath="//div[starts-with(@id,'section_0_10_-3004_')]/a")
	WebElement searchPriceText;

	// Checkbox of Brand
	@FindBy(xpath="//label[starts-with(@id,'facet_98114971101005887104105114108112111111108_10_-3004_')]/span")
	WebElement searchBrandCheckbox;
	
	//@FindBy(xpath="//label[@id='facet_839710810132801141059910158401234232505312541_10_-3004_16951']")
	//@FindBy(xpath="//div[@id='839710810132801141059910158401234232505312541_ACCE_Label']")
	@FindBy (xpath= "//div[contains(text(),'Less than $24.99')]")
	WebElement priceLessThan25;
	
	@FindBy(xpath="//div[@id='83971081013280114105991015840123505332534812541_ACCE_Label']")
	WebElement priceBetween25And50;
	
	//Product Image
	@FindBy(xpath = "//img[starts-with(@id,'productThumbNailImage_')]")
	WebElement productImage;

	//Add to List
	@FindBy(id="add2QuoteBtn")
	List<WebElement> addToListButton;

	//Add to Quote
	@FindBy(id="add2QuoteBtn")
	List<WebElement> listAddToQuoteButtons;

	@FindBy(xpath = "//div[@class='quotes-add__new-input']//input[@class='jq-quote-add--input']")
	WebElement quoteNameEdit;


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
	
	@FindBy(xpath="//div[@class='rich-relevance__block search_page_new_rr1_results']")
	public WebElement richRelevanceThroughSearch;
	
	@FindBy(xpath="//div[@class='rich-relevance__block category_page_new_rr1']")
	public WebElement richRelevanceThroughNavigation;
	
	//@FindBy(xpath="//div[@class='rich-relevance__block search_page_new_rr1_results']//div[@class='type--semi-bold type--caption type--caps']")
	@FindBy(xpath = "//div[@data-hds-tag='rich-relevance__block']//span[@class='type--body-x-large']")
	public List<WebElement> PriceUnderRichRelevance;


	@FindBy(xpath = "//*[@class='product-tile type--caption']//div[4]")
	public List<WebElement> strikeThroughRichRelevancePrice;
	
	//@FindBy(xpath="//div[@class='rich-relevance__block search_page_new_rr1_results']//span[text()='Add to cart']")
	@FindBy(xpath="//div[@data-hds-tag='rich-relevance__block']//span[text()='Add to cart']")
	public List<WebElement> AddToCartUnderRichRelevance;
	
	@FindBy(xpath="//h1[@data-hds-tag='PageHeading__flexible-header']")
	public WebElement plpHeadingText;

	@FindBy(xpath="//a[text()='Customize this item']")
	List<WebElement> customizeThisItemLinks;
	
	//@FindBy(xpath="//a[@data-hds-tag='pagination__right']")
	@FindBy(xpath="//div[@class='pagination']/a")
	public WebElement rightPagination;

	@FindBy(xpath="//section[@class='subcat-grid-tile']")
	List<WebElement> noOfTiles;
	
	//@FindBy(xpath = "//div[@class='content__description type--caption']")
	@FindBy(xpath = "//div[@class='content__description type--caption']/span[contains(text(),'re sorry, we couldn')]")
	WebElement alertMessageBox;

	//LIST  VIEW

	@FindBy(xpath = "//*[@data-hds-tag='subcat-list-tile__details--product_name']/a")
	public
	List<WebElement> listViewProductDescription;
	
	@FindBy(xpath = "//*[@data-hds-tag='subcat-tile__add-to-quote']")
	//Add to Quote list view web property had changed
	// 		"//*[@data-hds-tag='subcat-list-tile__add-to-quote']")
	public List<WebElement> gridListViewAddtoQuote;
	
	
	@FindAll(@FindBy(xpath="//div[@class='subcat-grid-tile-container']/section/div[starts-with(@id,'CatalogEntryProdImg')]"))
	public	List<WebElement> productList;
	
	@FindAll(@FindBy(xpath="//button[@data-hds-tag=\"subcat-tile__quick-checkout\"]"))
	public	List<WebElement> quickCheckoutButtons;
	
	@FindAll(@FindBy(xpath="//span[@class='type--body-x-large price--offerprice']"))
	public
	List<WebElement> productPriceList;
	
	@FindAll(@FindBy(xpath="//div[@class='subcat-grid-tile-container']/section[@class='subcat-grid-tile']"))
	List<WebElement> productListGrid;

	@FindBy(xpath = "//*[@data-hds-tag='subcat-list-tile']")
    public    List<WebElement> productListInListView;

	@FindAll(@FindBy(xpath="//div[@class='subcat-grid-tile-container']/section[@class='subcat-grid-tile']/descendant::button[contains(text(),'Add to List')]"))
	List<WebElement> productsListAddToListBtn;
	
	@FindBy(xpath = "//span[contains(text(),'re sorry, we couldn')]")
	public WebElement couldNotFindAnyResultText;
	
	@FindBy(xpath = "//div[contains(text(),'Replacement for discontinued Part#')]")
	public WebElement replacementForDiscontinuedPartMessage;

	@FindBy(xpath = "//span[contains(text(),'Did you mean:')]")
	public WebElement didYouMeanTextMessage;
	
	@FindBy(xpath = "//h2[contains(text(),'t find any results for')]")
	public WebElement weAreSorryWeCouldNotFindProductText;
	
	@FindBy(xpath="//a[@class=\"link--regular type--body-small customize jq-open-modal\"]/../../../..//button[@id='quickCheckoutBtn']")
	List<WebElement>  quickCheckOutButtonForCustomizedProduct;
	
	@FindBy(xpath="//button[@id='quickCheckoutBtn']")
	List<WebElement>  quickCheckOutButton;
	
	 @FindBy(xpath = "//div[@class='el--flex el--flex--center el--margin-right-1']")
	 WebElement showXXPerPageText;
	 
	 @FindBy(xpath = "//select[@class='select--alt']")
	  WebElement showPerPageDropdown;

	@FindBy(xpath="//span[@data-hds-tag='subcat-header__result-count']")
	WebElement numberOfListTextDisplayed;
			
	
	public boolean isDisplayedAlertMessageBox(){
		waitTool.waitForElement(driver, alertMessageBox);
		System.out.println(alertMessageBox.getText());
		return pageManager.common().isElementPresent(alertMessageBox);
	}
	
	public int getNoOfTiles(){
		//System.out.println("Inside price Text");
		int NoOfTiles =  noOfTiles.size();
		System.out.println("NoOfTiles: " + NoOfTiles);
		return NoOfTiles;
	}
	
	public boolean isDisplayedRightPagination(){
		System.out.println("Displayed right pagination");
		
		waitTool.waitForElement(driver, rightPagination);
		pageManager.common().scrolltoViewElement(rightPagination, driver);
		return pageManager.common().isElementPresent(rightPagination);
	}
	
	public void clickRightPagination(){
		System.out.println("Before click right pagination");
		pageManager.common().scrollDown(driver);
		//waitTool.waitForElement(driver, rightPagination);
		pageManager.common().scrolltoViewElement(rightPagination, driver);
		rightPagination.getSize();
		rightPagination.click();

	}
	
	// Verify to display of Price
	public boolean isDisplayedSearchPriceText(){
		System.out.println("Inside price Text");
		return pageManager.common().isElementPresent(searchPriceText);
	}

	// Text of Brand
	@FindAll(@FindBy(xpath="//div[starts-with(@id,'section_mfName_ntk_cs_10_-3004_')]/a"))
	WebElement searchBrandText;

	// Verify to display of Price
	public boolean isDisplayedSearchBrandText(){
		System.out.println("Inside Brand Text");
		return pageManager.common().isElementPresent(searchBrandText);
	}

	/**
	 * @return the Search Part Number
	 */
	public String getSearchPartNumberText() {
		return searchPartNumberText.getText().trim();
	}

	public String getPLPHeadingText() {
		waitTool.waitForElement(driver, plpHeadingText);
		System.out.println("PLP Heading: " + plpHeadingText.getText());
		return plpHeadingText.getText();
	}
	
	public Boolean isPlpHeadingTextDisplayed() {
		waitTool.waitForElement(driver, plpHeadingText);
		System.out.println("PLP Heading: " + plpHeadingText.getText());
		return plpHeadingText.isDisplayed();
	}
	

	public String filteredBreadCrumbinPLP(int number){

		System.out.println(listfilteredBreadCrumb.get(number).getText());
		waitTool.waitForElement(driver, listfilteredBreadCrumb.get(number));
		pageManager.common().scrolltoViewElement(listfilteredBreadCrumb.get(number), driver);
		 return listfilteredBreadCrumb.get(number).getText();
	}

	public void isBreadCrumbDisplayed(String searchProduct)
	{
		searchProduct = "Home Search: "+ searchProduct;
		System.out.println(searchProduct + "and  "+breadcrumb.getText() );
		Assert.assertEquals(searchProduct, breadcrumb.getText());
	}

	/**
	 * Method to click on Price checkbox
	 * @return boolean true\false
	 */
	public void clickSearchBrandCheckbox() {
		waitTool.waitForElement(driver,	searchBrandCheckbox);
		searchBrandCheckbox.click();
		waitTool.waitFor(driver, true);
	}
	
	public void clickpriceLessThan25() {
		waitTool.waitForElement(driver,	priceLessThan25);
		priceLessThan25.click();
		waitTool.waitFor(driver, true);
	}
	
	public void clickPriceBetween25And50() {
		waitTool.waitForElement(driver,	priceBetween25And50);
		priceBetween25And50.click();
		waitTool.waitFor(driver, true);
	}
	
	public int getNumOfItemsLessThan25() {
		waitTool.waitForElement(driver,	priceLessThan25);
		pageManager.common().scrolltoViewElement(priceLessThan25, driver);
		
		String NoOfItems = priceLessThan25.getText();
		NoOfItems = NoOfItems.substring(NoOfItems.indexOf("(") + 1);
		NoOfItems = NoOfItems.substring(0, NoOfItems.indexOf(")"));
		return Integer.parseInt(NoOfItems);
		 
	}
	
	public int getNumOfItemsPriceBetween25And50() {
		waitTool.waitForElement(driver,	priceBetween25And50);
		
		String NoOfItems = priceBetween25And50.getText();
		NoOfItems = NoOfItems.substring(NoOfItems.indexOf("(") + 1);
		NoOfItems = NoOfItems.substring(0, NoOfItems.indexOf(")"));
		
		return Integer.parseInt(NoOfItems);
	}
	

	/**
	 * Method to click on Product Image
	 * @return boolean true\false
	 */
	public void clickProductImage() {
		productImage.click();
		//waitTool.waitFor(driver, true);
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
	
	public boolean isDisplayedCompareCheckBoxes() throws InterruptedException {
		try	{
			return compareCheckboxes.get(0).isDisplayed();
		}catch(Exception e) {
			return false;
		}

	}
	
	public void clickCompareCheckBoxes(int maxCount){
		waitTool.waitForElement(driver, compareCheckboxes.get(0));
		for(int count=0; count<maxCount; count++){
			waitTool.waitForElement(driver, compareCheckboxes.get(count));
			compareCheckboxes.get(count).getSize();
			compareCheckboxes.get(count).getLocation();
			pageManager.common().scrolltoViewElement(compareCheckboxes.get(count), driver);
			compareCheckboxes.get(count).click();
		}
	}
	
	public List<String> getAllPartNumbers(int maxCount) {
	    List<String> all_PLP_partNum=new ArrayList<>();
	    for(int i=0; i<maxCount; i++){
	      all_PLP_partNum.add(listProductListingPageProductNumber.get(i).getText().trim().substring(5));
	      System.out.println(listProductListingPageProductNumber.get(i).getText().trim().substring(5));

	    }
	    return all_PLP_partNum;
	  }

	/**
	 * @description method to click on first products in the product grid.
	 * @return ProductDetailsPage
	 */
	public void clickFirstProductInProductList() throws Exception {

		//System.out.println(productList.get(0));
		waitTool.waitForElement(driver, productList.get(0));
		pageManager.common().scrolltoViewElement(productList.get(0), driver);
		productList.get(0).click();
		waitTool.waitFor(driver,true);
	}

	public void clickSecondProductInProductList() throws Exception 
	{
		waitTool.waitForElement(driver, productList.get(1));
		productList.get(1).click();
		waitTool.waitFor(driver,true);
	}
	
	public String getFirstProductPriceInProductList() throws Exception {

		//System.out.println(productList.get(0));
		waitTool.waitForElement(driver, productPriceList.get(0));
		return productPriceList.get(0).getText().trim();
	
	}

	public String getSecondProductPriceInProductList() throws Exception 
	{
		waitTool.waitForElement(driver, productPriceList.get(1));
		return productPriceList.get(1).getText().trim();
		
	}
	
	//Method to verify if is product is displayed to randomly click on first product
	public String getHeaderName() throws Exception {
		//	waitTool.hardWait();
		waitTool.waitForElement(driver, productPageHeader);
		return productPageHeader.getText().trim();
	}

	public boolean isDisplayedtopHeadersavedlistLinkText(){
		return pageManager.common().isElementPresent(topHeadersavedlistLinkText);
	}

	/**
	 * @name verifyBreadCrumbForCurrentPage
	 * @description Method to verify BreadCrumb For CurrentPage
	 * param text value (current page)
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
	public void clickSavedListUtilityBar() throws InterruptedException {
		waitTool.waitForElement(driver,	topHeadersavedlistLinkText);
		topHeadersavedlistLinkText.click();
		waitTool.waitFor(driver, true);
	}

	//Duplicated method from ProductDetailPage
	/*	public Boolean isDisplayedAddToCartSuccessPopup()
	{
		waitTool.waitForElement(driver, closeAddtocartSuccessPopup);
		return closeAddtocartSuccessPopup.isDisplayed();
	}
	 */

	public Boolean isGridViewDisplayed()
	{
		waitTool.waitForElement(driver, productListingPageGridView);
		return productListingPageGridView.isDisplayed();
	}

	public Boolean isDisplayedListViewButton()
	{
		return productListingPageListViewButton.isDisplayed();
	}
	
	public Boolean isDisplayedListView() throws Exception
	{
		waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver, productListingPageListView);
		pageManager.common().scrolltoViewElement(productListingPageListView, driver);
		return productListingPageListView.isDisplayed();
	
	}
	
	public void clickonFirstProductAddToCartListView() throws Exception
	{
		pageManager = new PageManager(driver);
		int displayedShoppingCartProductCountBeforeAddToCart=pageManager.homePage().getShoppingCartProductCount();
		System.out.println("displayedShoppingCartProductCountBeforeAddToCart   "+ displayedShoppingCartProductCountBeforeAddToCart);
		waitTool.waitForElement(driver, addToCartButtons.get(0));
		addToCartButtons.get(0).click();
		waitTool.waitFor(driver, true);
		int displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		while(displayedShoppingCartProductCountAfterAddToCart==displayedShoppingCartProductCountBeforeAddToCart)
		{
			displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		}
		System.out.println("displayedShoppingCartProductCountAfterAddToCart is "+ displayedShoppingCartProductCountAfterAddToCart);
		Assert.assertTrue(displayedShoppingCartProductCountBeforeAddToCart<displayedShoppingCartProductCountAfterAddToCart);
	}

	public void clickonFirstCheckbox()
	{
		waitTool.waitForElement(driver, productListingPageFirstProductCheckbox);
		pageManager.common().scrolltoViewElement(productListingPageFirstProductCheckbox, driver);
		productListingPageFirstProductCheckbox.click();
	}


		public void clickonFirstProductAddToCart() throws Exception
		{
			int displayedShoppingCartProductCountBeforeAddToCart=pageManager.homePage().getShoppingCartProductCount();
			System.out.println("displayedShoppingCartProductCountBeforeAddToCart   "+ displayedShoppingCartProductCountBeforeAddToCart);
			waitTool.waitForElement(driver, productListingPageFirstProductAddToCart);
			pageManager.common().scrolltoViewElement(productListingPageFirstProductAddToCart, driver);
			productListingPageFirstProductAddToCart.click();
			waitTool.waitForElement(driver, productListingPageFirstProductAddToCart);
			pageManager.common().scrolltoViewElement(productListingPageFirstProductAddToCart, driver);
			int displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
			while(displayedShoppingCartProductCountAfterAddToCart==displayedShoppingCartProductCountBeforeAddToCart)
			{
				displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
			}
			
			System.out.println("displayedShoppingCartProductCountAfterAddToCart is "+ displayedShoppingCartProductCountAfterAddToCart);
			Assert.assertTrue(displayedShoppingCartProductCountBeforeAddToCart<displayedShoppingCartProductCountAfterAddToCart);
			}

	public void addToCartAndNavigateToSCP(int i) throws Exception {
		int displayedShoppingCartProductCountBeforeAddToCart=pageManager.homePage().getShoppingCartProductCount();
		System.out.println("Shopping Cart Product Count Before AddToCart   "+ displayedShoppingCartProductCountBeforeAddToCart);
		pageManager.common().scrolltoViewElement(addToCartButtons.get(i), driver);
		System.out.println(addToCartButtons.get(i).getText());
		addToCartButtons.get(i).click();
		waitTool.waitFor(driver, true);
	//	waitTool.waitFor(driver,pageManager.homePage().shoppingCartIcon.isDisplayed());
		pageManager.homePage().clickOnShoppingCartIcon();
		int displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		while(displayedShoppingCartProductCountAfterAddToCart==displayedShoppingCartProductCountBeforeAddToCart)
		{
			displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		}
		
		System.out.println("displayedShoppingCartProductCountAfterAddToCart is "+ displayedShoppingCartProductCountAfterAddToCart);
		Assert.assertNotEquals(displayedShoppingCartProductCountBeforeAddToCart,displayedShoppingCartProductCountAfterAddToCart);
	}

	public void clickOnCloseAddtocartSuccessPopup()
	{
		waitTool.waitForElement(driver,closeAddtocartSuccessPopup);
		pageManager.common().scrolltoViewElement(closeAddtocartSuccessPopup, driver);
		closeAddtocartSuccessPopup.click();
		waitTool.waitForElement(driver, sortByLabel);
	}

	public void refreshPage()
	{
		pageManager.common().refresh();
	}

	public void clickonSecondCheckbox()
	{
		waitTool.waitForElement(driver, productListingPageSecondProductCheckbox);
		pageManager.common().scrolltoViewElement(productListingPageSecondProductCheckbox, driver);
		productListingPageSecondProductCheckbox.click();
	}

	public void clickonThirdCheckbox()
	{
		waitTool.waitForElement(driver, productListingPageThirdProductCheckbox);
		pageManager.common().scrolltoViewElement(productListingPageThirdProductCheckbox, driver);
		productListingPageThirdProductCheckbox.click();
	}

	public void clickonFourthCheckbox()
	{
		waitTool.waitForElement(driver, productListingPageFourthProductCheckbox);
		pageManager.common().scrolltoViewElement(productListingPageFourthProductCheckbox, driver);
		productListingPageFourthProductCheckbox.click();
	}

	public void clickonFifthCheckbox()
	{
		pageManager.common().scrolltoViewElement(productListingPageFifthProductCheckbox, driver);
		productListingPageFifthProductCheckbox.click();
	}

	public Boolean isComapreProductWidgetDisplayed()
	{
		pageManager.common().mouseHover(driver, compareProductWidgets);
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
		pageManager.common().scrolltoViewElement(productListingPageFifthProductCheckbox, driver);
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
		pageManager.common().scrolltoViewElement(productListingPageFifthProductCheckbox, driver);
		Boolean flag = compareProductWidgetsFourthProductDeselected.isDisplayed();
		return flag;
	}

	public String isTextOnPopupWindowDisplayed()
	{
		String text = popupWindowMessage.getText();
		popupWindowOkButton.click();
		return text;
	}

	public Boolean isSortByLabelDisplayed()
	{
		return sortByLabel.isDisplayed();
	}

	// public List isSortByDropDownDisplayed()
	public List getSortByDropDownList()
	{
		List<String> optionsValue = new ArrayList<String>();
		Select select = new Select(sortByDropDown);
		List<WebElement> options = select.getOptions();
		for(WebElement option : options)
		{
			optionsValue.add(option.getText());
		}
		return optionsValue;
	}

	public String getFirstOptionFromSortByDropDown()
	{
		Select select = new Select(sortByDropDown);
		System.out.println("value is "+ select.getFirstSelectedOption().getText());
		return select.getFirstSelectedOption().getText();
	}
	
	public Boolean isResultCounterDisplayed()
	{
		return resultCounterLabel.isDisplayed();
	}

	public void clickCompareTheseButton()
	{
		waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver, compareTheseButton);
		pageManager.common().scrolltoViewElement(compareTheseButton, driver);
		compareTheseButton.click();
		System.out.println("clicked on compareTheseButton ");
	/*	PageManager pageManager=new PageManager(driver);
		waitTool.waitForElement(driver, pageManager.compareTheseItems().compareProductsTitle);*/
	}
	
	public void clickClearAllLink()
	{
		waitTool.waitForElement(driver, clearAllLink);
		pageManager.common().scrolltoViewElement(clearAllLink, driver);
		clearAllLink.click();
	}
	
	public String getFirstProductPartNumberListView()
	{
		waitTool.waitForElement(driver, partnumbersInListView.get(0));
		pageManager.common().scrolltoViewElement(partnumbersInListView.get(0), driver);
		return partnumbersInListView.get(0).getText();
	}

	public String getFirstProductPartNumber()
	{
		waitTool.waitForElement(driver, listProductListingPageProductNumber.get(0));
		pageManager.common().scrolltoViewElement(listProductListingPageProductNumber.get(0), driver);
		return listProductListingPageProductNumber.get(0).getText();
	}

	public String getSecondProductPartNumber()
	{
		waitTool.waitForElement(driver, listProductListingPageProductNumber.get(1));
		pageManager.common().scrolltoViewElement(listProductListingPageProductNumber.get(1), driver);
		return listProductListingPageProductNumber.get(1).getText();
	}
	
	public String getFirstProductQuantity() throws InterruptedException {
		pageManager.common().scrolltoViewElement(productListingPageProductQuantity.get(0), driver);
		System.out.println("quantity value is " +productListingPageProductQuantity.get(0).getAttribute("value") );
		return productListingPageProductQuantity.get(0).getAttribute("value").trim();
	}

	public String getSecondProductQuantity() throws InterruptedException {
		pageManager.common().scrolltoViewElement(productListingPageProductQuantity.get(1), driver);
		System.out.println("quantity value is " +productListingPageProductQuantity.get(1).getAttribute("value") );
		return productListingPageProductQuantity.get(1).getAttribute("value").trim();
	}


	public String getFirstProductPartNumberTEXTFromListView()

	//the method to get text of the first part number in the List VIEW
	{
		waitTool.waitForElement(driver,partnumbersInListView .get(0));
		pageManager.common().scrolltoViewElement(partnumbersInListView.get(0), driver);
		return partnumbersInListView.get(0).getText();
	}

	public String getSecondProductPartNumberFromListView()
	{
	//	waitTool.waitForElement(driver,productListingPageListView);
		waitTool.waitForElement(driver, productListingPageListViewPartNumber.get(1));
		pageManager.common().scrolltoViewElement(productListingPageListViewPartNumber.get(1), driver);
		return productListingPageListViewPartNumber.get(1).getText();
	}
	
	public void enterPLPListViewProductQuantity(String quantity) {
		pageManager.common().scrolltoViewElement(productListingPageListViewProductQuantity.get(0), driver);
		productListingPageListViewProductQuantity.get(0).clear();
		productListingPageListViewProductQuantity.get(0).sendKeys(quantity);
	}
	
	public String getFirstProductQuantityFromListView() throws InterruptedException {
		pageManager.common().scrolltoViewElement(productListingPageListViewProductQuantity.get(0), driver);
		System.out.println("quantity value is " +productListingPageListViewProductQuantity.get(0).getAttribute("value") );
		return productListingPageListViewProductQuantity.get(0).getAttribute("value").trim();
	}

	public String getSecondProductQuantityFromListView() throws InterruptedException {
		pageManager.common().scrolltoViewElement(productListingPageListViewProductQuantity.get(1), driver);
		System.out.println("quantity value is " +productListingPageListViewProductQuantity.get(1).getAttribute("value") );
		return productListingPageListViewProductQuantity.get(1).getAttribute("value").trim();
	}

	
	public void clickOnProductByInt(int productCount)
	{
		listProductListingPageProductNumber.get(productCount).click();

	}

	// Method to get Quantities from the product
	public String getQuantity() throws InterruptedException {
		pageManager.common().scrolltoViewElement(quantityEdit, driver);
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
		waitTool.waitForElement(driver, increaseQuantityButton);
		pageManager.common().scrolltoViewElement(increaseQuantityButton, driver);
		increaseQuantityButton.click();
		waitTool.waitFor(driver,true);
	}

	// Method to click on decrease the quantity
	public void clickDecreaseQuantity() throws InterruptedException {
		decreaseQuantityButton.click();
		waitTool.waitFor(driver,true);
	}


	public void clickOnListView() throws Exception
	{
		waitTool.waitForElement(driver, productListingPageListViewButton);
		pageManager.common().scrolltoViewElement(productListingPageListViewButton, driver);
		productListingPageListViewButton.click();
		waitTool.waitForElement(driver, productListingPageListView);
	}
	
	public void clickOnProductListingPageFirstProductName() throws Exception
	{
		waitTool.waitForElement(driver, productListingPageFirstProductName);
		productListingPageFirstProductName.click();

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
		waitTool.waitFor(driver,true) ;
		return subCategoryAddToQuote;
	}

	// Method to Select on any subcategories to Add to Cart
	public List<WebElement> selectSubCategoriesAddtoCartButton() throws InterruptedException {
		waitTool.waitFor(driver,true) ;
		return subCategoryAddToCartButton;
	}

	public void clickAddToQuoteButton(int i){
		listAddToQuoteButtons.get(i).click();
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



	public HomePage clickOnHDSupplyLogoInHeader()
	{
		pageManager.common().scrolltoViewElement(hDSupplyLogoInHeader, driver);
		hDSupplyLogoInHeader.click();
		return new HomePage(driver);
	}

	public boolean isDisplayedNewTab(){
		waitTool.waitForElement(driver, newTab);
		pageManager.common().scrolltoViewElement(newTab, driver);
		return newTab.isDisplayed();
	}

	public void clickNewTab(){
		newTab.click();
	}

	/*public ShoppingCartPage clickOnShoppingCartIcon() throws Exception {
		waitTool.waitForElement(driver, shoppingCartIcon);
		.scrolltoViewElement(shoppingCartIcon, driver);
		shoppingCartIcon.click();
		return new ShoppingCartPage(driver);
	}*/

	public Boolean isBreadcrumbDisplayed()
	{
		return breadcrumb.isDisplayed();
	}

	public HomePage clickOnHomeLinkOnBreadcrumb()
	{
		homeLinkOnBreadcrumb.click();
		return new HomePage(driver);
	}

	public void clickOnProductAddToList(int product)
	{
		waitTool.waitForElement(driver, productListingPageProductAddToList.get(product));
		pageManager.common().scrolltoViewElement(productListingPageProductAddToList.get(product), driver);
		System.out.println("productListingPageProductAddToList.get(product) is" + productListingPageProductAddToList.get(product).getText());
		productListingPageProductAddToList.get(product).click();
	}


	public void clickOnProductAddToListFromListViewByInt(int product)
	{
		waitTool.waitForElement(driver, productListingPageProductAddToList.get(product));
		pageManager.common().scrolltoViewElement(productListingPageProductAddToList.get(product), driver);
        productListingPageProductAddToList.get(product).click();
	}
	
	/*public void clickOnSecondProductAddToListFromListView()
	{
		.scrolltoViewElement(productListingPageListViewProductAddToList.get(1), driver);
		productListingPageListViewProductAddToList.get(1).click();
	}
	*/
	public String addItemToNewList(String newListName) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf((addToListNewTab)));
		addToListNewTab.getSize();
		addToListNewTab.click();
		String random = pageManager.common().getRandomString(4);
		newListName = newListName + random;
		newListNameEdit.sendKeys(newListName);
		createListButton.click();
		return newListName;
	}

	public ShoppingCartPage clickOnCheckoutButtonOnAddToCartPopup()
	{
		waitTool.waitForElement(driver, checkoutButtonOnAddToCartPopup);
		//wait.until(ExpectedConditions.visibilityOf(checkoutButtonOnAddToCartPopup));
		pageManager.common().scrolltoViewElement(checkoutButtonOnAddToCartPopup, driver);
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
	
	public Boolean isDisplayedRichRelevanceThroughSearch()
	{	
		waitTool.waitForElement(driver, richRelevanceThroughSearch);
		pageManager.common().scrolltoViewElement(richRelevanceThroughSearch, driver);
		return richRelevanceThroughSearch.isDisplayed();
	}
	
	public Boolean isRichRelevanceDisplayed()
	{	
		waitTool.waitForElement(driver, richRelevanceThroughNavigation);
		pageManager.common().scrolltoViewElement(richRelevanceThroughNavigation, driver);
		return richRelevanceThroughNavigation.isDisplayed();
	}
	
	public Boolean isAddToCartUnderRichRelevanceDisplayed()
	{	Boolean flag = false;
		for(WebElement element : AddToCartUnderRichRelevance )
		{
			if(element.isDisplayed())
			{
				flag=true;
			}
		}
		return flag;
	}
	
	public Boolean isPriceUnderRichRelevanceDisplayed()
	{	Boolean flag = false;
		for(WebElement element : PriceUnderRichRelevance )
		{
			if(element.isDisplayed())
			{
				flag=true;
			}
		}
		return flag;
	}

	public void isStrikedPriceUnderRichRelevanceDisplayed() {
		try{
			Assert.assertTrue(getListOfPricesOnRichRelevanceCarousel().contains("LIST PRICE"));
		}
		catch (AssertionError e){
			driver.findElement(By.xpath("//*[@id='nextPageButtonsearch_page_new_rr1_results']")).click();
			System.out.println("catch exception and click next btn on Carosuel");
			Assert.assertTrue(getListOfPricesOnRichRelevanceCarousel().contains("LIST PRICE"));
		}
	}
	private String getListOfPricesOnRichRelevanceCarousel(){
		int prices = strikeThroughRichRelevancePrice.size();
		StringBuilder string = new StringBuilder();
		for (i = 0; i < prices; i++) {
			String firstCarousel = strikeThroughRichRelevancePrice.get(i).getText();
			string.append(firstCarousel);
			System.out.println("firstCarousel: " + firstCarousel);
		}
		return string.toString();
	}


	public Boolean isCompareThesePartsButtonEnabled()
	{
		return compareThesePartsButton.isEnabled();
	}
	
	public void selectBrandFromSortByDropdown()
	{
		Select select = new Select(sortByDropDown);
		select.selectByIndex(1);
		select.getFirstSelectedOption();
	}
	
	public void selectFromSortByDropdownAndGridViewDispayed()
	{
		Select select = new Select(sortByDropDown);
		for (int count =1; count<=5; count++){
			select.selectByIndex(1);
			select.getFirstSelectedOption();
			isGridViewDisplayed();
			isDisplayedFirstCustomizeThisItemLinks();
		}
	}
	
	public void selectOptionFromSortByDropdown(String option) {
        waitTool.waitForElement(driver, sortByDropDown);
		pageManager.common().scrolltoViewElement(sortByDropDown, driver);
        Select select = new Select(sortByDropDown);
        select.selectByVisibleText(option);
        System.out.println("selectedOptionSortByDropdown: " + option);
    }
	
	public void VerifyTheListGetSortedBy(String option) {
			selectOptionFromSortByDropdown(option);
			Assert.assertTrue(isGridViewDisplayed());

	}
	
	public Boolean selectAttributeFromSortByDropDown(String value)
	{
		Boolean flag = true;
		Select select = new Select(sortByDropDown);
		select.selectByVisibleText(value);
		waitTool.waitForElement(driver, resultCounterLabelValue);
		productCountValue.add(resultCounterLabelValue.getText());
		System.out.println("size is "+ productCountValue.size());
		if(productCountValue.size()>=7)
		{
			String valueAtZeroIndex = productCountValue.get(0);
			System.out.println("valueAtZeroIndex is "+ valueAtZeroIndex);
			for(String values : productCountValue)
			{
				System.out.println("values is "+ values);
				if(!values.equals(valueAtZeroIndex))
				{
					flag=false;
				}
			}
		}
		System.out.println("falg is "+ flag);
		return flag;
	}
	
	public void verifyNumberOfListDisplayed(String optionValue)
	{
		int numberOfListTextDisplayed =getNumberOfListTextDisplayed();
		if(numberOfListTextDisplayed==0)
		{
			System.out.println("There are 0 list dispalyed on saved list page");
		}
		else
		{
			pageManager.common().selectByVisibleTextFromDropdown(showPerPageDropdown, optionValue);
			int optionIntegerValue = Integer.parseInt(optionValue);
			if(optionIntegerValue>numberOfListTextDisplayed)
			{
				Assert.assertTrue(listProductsDescriptionText.size()==numberOfListTextDisplayed);
			}
			else
			{
				Assert.assertTrue(listProductsDescriptionText.size()==optionIntegerValue);

			}
		}
	}
	
	public int getNumberOfListTextDisplayed()
	{
		return Integer.parseInt(numberOfListTextDisplayed.getText());

	}
	
	public void clickAddToCartButtonUnderRichRelevance() throws Exception {
		waitTool.waitForElement(driver, AddToCartUnderRichRelevance.get(0));
		pageManager.common().scrolltoViewElement(AddToCartUnderRichRelevance.get(0), driver);
		AddToCartUnderRichRelevance.get(0).click();
		pageManager.common().refresh();
		
	}
	
	public String clickOnFirstCustomizeThisItemLinks()
	{
		waitTool.waitFor(driver,true);
		waitTool.waitForElement(driver,customizeThisItemLinks.get(0));
		pageManager.common().scrolltoViewElement(customizeThisItemLinks.get(0),driver);
		String pnumber = customizedThisItemProductNumbers.get(0).getText();
		customizeThisItemLinks.get(0).click();
		System.out.println("pnumber iss"+ pnumber);
		return pnumber;
	}
	
	public Boolean isDisplayedFirstCustomizeThisItemLinks()
	{
		waitTool.waitForElement(driver, customizeThisItemLinks.get(0));
		return customizeThisItemLinks.get(0).isDisplayed();
	}

	public boolean isBMediaBannerDisplayed(){
		waitTool.waitFor(driver,true);
		waitTool.waitForElement(driver,bMediaBanner);
		return bMediaBanner.isDisplayed();
	}

	public String  getTextFilteredBreadCrumb()
	{
		waitTool.waitForElement(driver, filteredBreadCrumb);
		pageManager.common().scrolltoViewElement(filteredBreadCrumb, driver);
		return filteredBreadCrumb.getText();
	}
	
	public int getTotalNumberOfProductDisplayd()
	{
		int count = productList.size();
		return count;
	}
	
	public Boolean isQuickCheckoutButtonsIdsplayed()
	{
	Boolean flag = false;
	int size = quickCheckoutButtons.size();
	if(size>0)
	{
		flag=true;
		
	}
	else
		flag=false;
	return flag;
	}

	public void clickOnFirstQuickCheckOutButtonForCustomizedProduct()
	{
		waitTool.waitForElement(driver, quickCheckOutButtonForCustomizedProduct.get(0));
		pageManager.common().scrolltoViewElement(quickCheckOutButtonForCustomizedProduct.get(0), driver);
		quickCheckOutButtonForCustomizedProduct.get(0).click();
	}
	
	public void clickOnFirstQuickCheckOutButton()
	{
		waitTool.waitForElement(driver, quickCheckOutButton.get(0));
		quickCheckOutButton.get(0).click();
	}
	
	 public Boolean isShowXXPerPageTextDisplayed() {
	        waitTool.waitForElement(driver, showXXPerPageText);
	        return showXXPerPageText.isDisplayed();
	    }
	 
	  public String getDefaultValueFromShowPerPageDropdown() {
	        waitTool.waitForElement(driver, showPerPageDropdown);
	        pageManager.common().scrolltoViewElement(showPerPageDropdown, driver);
	        return pageManager.common().getSelectedDropdownOption(driver,showPerPageDropdown);
	    }
	  
	  public int[] getAllOptionsFromShowPerPageDropdown() {
		  List<WebElement> dropdownValues = pageManager.common().selectDropdownOptions(driver, showPerPageDropdown);
	        int i = 0;
	        int[] optionsText = new int[dropdownValues.size()];
	        for (WebElement dropdownValue : dropdownValues) {
	            optionsText[i] = Integer.parseInt(dropdownValue.getText());
	            System.out.println("optionsText" + i + optionsText[i]);
	            i++;
	        }

	        System.out.println("actaul valuesss" + Arrays.toString(optionsText));
	        return optionsText;
	    }

}
