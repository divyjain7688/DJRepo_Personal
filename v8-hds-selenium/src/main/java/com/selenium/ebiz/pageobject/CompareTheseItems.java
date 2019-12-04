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

public class CompareTheseItems
{
	private  WebDriver driver;
	private WaitTool   waitTool;
	protected PageManager pageManager;

	public CompareTheseItems(WebDriver driver) 
	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager = new PageManager(driver);

	}

	int j;

	@FindBy(xpath="//span[@class='link--regular']")
	public WebElement backToPLPPageButton;
	
	@FindBy(xpath="//h1[@data-hds-tag='product-comparison__heading'][contains(text(),'Compare Products')]")
	WebElement compareProductsTitle;
	
	@FindBy(xpath="//h1[text()='Compare Products']")
	WebElement compareProductsText;
	
	@FindBy(xpath="//div[@class='breadcrumbs']")
	WebElement breadcrums;

	@FindBy(xpath="//section[@class='comparison-tile']")
	public List<WebElement> comparisonTiles;

	@FindBy(xpath="//a[@id='comparePageRemoveItemMain_1']")
	List<WebElement> removeLinksInsideComparisonTiles;

	@FindBy(xpath="//a[@id='addAnotherProduct']")
	WebElement addAnotherProductTile;
	
	@FindBy(xpath="//a[@id='addAnotherProduct']")
	List<WebElement> addAnotherProductTiles;

	@FindBy(xpath="//section[@class='comparison-tile'][1]")
	WebElement firstComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][1]//a[@id='comparePageRemoveItemMain_1']")
	WebElement removeLinkInsideFirstComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][1]//img")
	WebElement productImageInsideFirstComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][1]//section[@class='number-stepper']")
	WebElement quantityBarInsideFirstComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][1]//*[contains(text(),'Add to list')]")
	public WebElement addToListInsideFirstComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][1]//*[contains(text(),'Add to quote')]")
	WebElement addToQuoteInsideFirstComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][1]//a[@id='add2CartBtn_1']")
	WebElement addToCartInsideFirstComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][2]")
	WebElement secondComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][2]//a[@id='comparePageRemoveItemMain_1']")
	WebElement removeLinkInsideSecondComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][2]//img")
	WebElement productImageInsideSecondComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][2]//section[@class='number-stepper']")
	WebElement quantityBarInsideSecondComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][2]//*[contains(text(),'Add to list')]")
	public WebElement addToListInsideSecondComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][2]//*[contains(text(),'Add to quote')]")
	WebElement addToQuoteInsideSecondComparisonTile;

	//@FindBy(xpath="//section[@class='comparison-tile'][2]//a[@id='add2CartBtn_1']")
	@FindBy(xpath="//section[@class='comparison-tile'][2]//a[@id='add2CartBtn_33']")
	WebElement addToCartInsideSecondComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][3]//*[contains(text(),'Add to list')]")
	WebElement addToListInsideThirdComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][4]//*[contains(text(),'Add to list')]")
	WebElement addToListInsideFourthComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile']//*[contains(text(),'Add to list')]")
	public List<WebElement> addToListButtons;

	@FindBy(xpath="//div[@class='breadcrumbs']//a[last()]")
	WebElement l2InBreadCrum;

	@FindBy(xpath="//div[@class=\"product-comparison-table__row\"]")
	List<WebElement> productSpecificationTableBelowProductTiles;

	@FindBy(xpath="//input[@data-hds-tag='comparison-tile-quantity']")
	List<WebElement> quantityTextFields;

	@FindBy(xpath="//div[contains(text(),'Add To Cart')]")
	List<WebElement> addToCartButtons;

	@FindBy(xpath="//div[@class='type--caption type--caps']")
	public List<WebElement> partNumber;

	@FindBy(xpath="//span[@data-hds-tag='price--offerprice']")
	List<WebElement>  price;
	
	@FindBy(xpath="//span[@class='link--regular']")
	WebElement backToSearchLink;

	/*public static int counterIncrease()
	{
		i++;
		return i;
	}

	public static int counterDecrease()
	{
		i--;
		return i;
	}*/

	public int numberOfComparisonTiles()
	{	
	waitTool.waitForElement(driver, compareProductsText);
		j=0;
		for(WebElement we:comparisonTiles)  
		{  
			j++;
		}
		return j;  
	}

	public int isNumberOfComparisonTilesZero() 
	{
		return comparisonTiles.size();
	}

	public int numberOfremoveLinksInsideComparisonTiles()
	{
		for(WebElement we:removeLinksInsideComparisonTiles)  
		{  
			j++;
		}
		return j;  
	}

	public Boolean isAddAnotherProductTileDisplayed()
	{
		return addAnotherProductTile.isDisplayed();
	}

	public void clickRemoveLinksFromCompareTiles()
	{
		for(WebElement we:removeLinksInsideComparisonTiles)  
		{  
			we.click();
		}
	}

	public Boolean isDisplayedCompareProductsTitle()
	{
		waitTool.waitForElement(driver, compareProductsTitle);
		return compareProductsTitle.isDisplayed();
	}

	public Boolean isFirstTileDisplayed()
	{
		return firstComparisonTile.isDisplayed();
	}

	public Boolean isRemoveLinkInsideFirstTileDisplayed()
	{
		return removeLinkInsideFirstComparisonTile.isDisplayed();
	}

	public void clickRemoveLinkInsideFirstTileDisplayed()
	{
		waitTool.waitForElement(driver, removeLinkInsideFirstComparisonTile);
		pageManager.common().scrolltoViewElement(removeLinkInsideFirstComparisonTile, driver);
		removeLinkInsideFirstComparisonTile.click();
	}

	public Boolean isProductImageInsideFirstComparisonTileDisplayed()
	{
		return productImageInsideFirstComparisonTile.isDisplayed();
	}

	public Boolean isQuantityBarInsideFirstComparisonTileDisplayed()
	{
		return quantityBarInsideFirstComparisonTile.isDisplayed();
	}

	public Boolean isAddToListInsideFirstComparisonTileDisplayed()
	{
		return addToListInsideFirstComparisonTile.isDisplayed();
	}
	
	public Boolean isDisplayedBackToSearchLink()
	{
		return backToSearchLink.isDisplayed();
	}
	
	public void clickBackToSearchLink()
	{
		waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver, backToSearchLink);
		pageManager.common().scrolltoViewElement(backToSearchLink, driver);
		 backToSearchLink.click();
	}
	
	public void clickOnAddToListInsideFirstComparisonTileDisplayed(int i)
	{
		waitTool.waitForElement(driver, addToListButtons.get(i));
		pageManager.common().scrolltoViewElement(addToListButtons.get(i), driver);
		addToListButtons.get(i).getSize();
		addToListButtons.get(i).click();
	}

	public Boolean isAddToQuoteInsideFirstComparisonTile()
	{
		return addToQuoteInsideFirstComparisonTile.isDisplayed();
	}

	public Boolean isAddToCartInsideFirstComparisonTile()
	{
		return addToCartInsideFirstComparisonTile.isDisplayed();
	}

	public Boolean isSecondTileDisplayed()
	{
		return secondComparisonTile.isDisplayed();
	}

	public Boolean isRemoveLinkInsideSecondTileDisplayed()
	{
		return removeLinkInsideSecondComparisonTile.isDisplayed();
	}

	public void clickRemoveLinkInsideSecondTileDisplayed()
	{
		removeLinkInsideSecondComparisonTile.click();
	}

	public Boolean isProductImageInsideSecondComparisonTileDisplayed()
	{
		return productImageInsideSecondComparisonTile.isDisplayed();
	}

	public Boolean isQuantityBarInsideSecondComparisonTileDisplayed()
	{
		return quantityBarInsideSecondComparisonTile.isDisplayed();
	}

	public Boolean isAddToListInsideSecondComparisonTileDisplayed()
	{
		return addToListInsideSecondComparisonTile.isDisplayed();
	}

	public Boolean isAddToQuoteInsideSecondComparisonTile()
	{
		return addToQuoteInsideSecondComparisonTile.isDisplayed();
	}

	public Boolean isAddToCartInsideSecondComparisonTile()
	{
		return addToCartInsideSecondComparisonTile.isDisplayed();
	}

	public ProductListingPage clickOnL2BreadCrum() 
	{
		l2InBreadCrum.click();
		return new ProductListingPage(driver);
	}

	public ProductListingPage clickOnAddNewProductTile()
	{
		addAnotherProductTile.click();
		return new ProductListingPage(driver);
	}
	
	public int getNoOfAddAnotherProductTiles(){
		System.out.println("addAnotherProductTiles: " + addAnotherProductTiles.size());
		return addAnotherProductTiles.size();
	}

	public Boolean isProductSpecificationExists()
	{	Boolean flag =false;
	for(WebElement we : productSpecificationTableBelowProductTiles)
	{	
		if(we.isDisplayed())
		{
			flag = true;
		}
		else
		{
			flag = false;
			break;
		}
	}
	return flag;
	}

	/**
	 * Enter quantity
	 * @param quantity
	 */
	public void enterQuantity(String quantity) {
		pageManager.common().scrolltoViewElement(quantityTextFields.get(0), driver);
		quantityTextFields.get(0).clear();
		quantityTextFields.get(0).sendKeys(quantity);
	}

	public String getQty() {	
		return quantityTextFields.get(0).getAttribute("value");
	}

	public void clickOnAddToCartButton() {

		//pageManager = new PageManager(driver);

		int displayedShoppingCartProductCountBeforeAddToCart=pageManager.homePage().getShoppingCartProductCount();
		System.out.println("displayedShoppingCartProductCountBeforeAddToCart   "+ displayedShoppingCartProductCountBeforeAddToCart);

		pageManager.common().scrolltoViewElement(addToCartInsideSecondComparisonTile, driver);
		addToCartInsideSecondComparisonTile.click();

		pageManager.common().refresh();
		pageManager.common().scrolltoViewElement(pageManager.homePage().shoppingCartProductCount, driver);
		int displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		System.out.println("displayedShoppingCartProductCountAfterAddToCart is "+ displayedShoppingCartProductCountAfterAddToCart);

		Assert.assertNotEquals(displayedShoppingCartProductCountBeforeAddToCart,displayedShoppingCartProductCountAfterAddToCart);
	}

	public String getPartNumber() {
		return partNumber.get(1).getText();
	}

	public String getPartNumbers(int i) {
		System.out.println("partNumber " + partNumber.get(i).getText().substring(5));
		return partNumber.get(i).getText().substring(5);

	}

	public List<String> getAllPartNumbers() {
		waitTool.waitForElement(driver, pageManager.compareTheseItems().compareProductsTitle);
		List<String> all_CP_partNum=new ArrayList<>();
		for(int i=0; i<partNumber.size(); i++){
			all_CP_partNum.add(partNumber.get(i).getText().trim().substring(5));
			System.out.println(partNumber.get(i).getText().trim().substring(5));

		}
		return all_CP_partNum;
	}

	public boolean compareParts(List<String> PLP, List<String> CP){
		return pageManager.common().comparePartsAdded(PLP, CP);
	}

	public String getPrice() {
		return price.get(1).getText();
	}

	public void clickOnAddToListButton(int i) throws InterruptedException
	{
		pageManager.common().refresh();
		waitTool.waitForElement(driver, addToListButtons.get(i));
		pageManager.common().scrolltoViewElement(addToListButtons.get(i), driver);
		//addToListInsideSecondComparisonTile.getLocation();
		addToListButtons.get(i).getSize();
		addToListButtons.get(i).getLocation();
		addToListButtons.get(i).click();
		Assert.assertTrue(pageManager.addToExistingORCreateNewList_modal().isAddToExistingOrCreateNewListTitleTextDisplayed());	

	}

	public String getFirstProductPrice() {
		return price.get(0).getText().trim();
	}
	public String getSecondProductPrice() {
		return price.get(1).getText();
	}
}

