package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;

public class CompareTheseItems  extends BaseClass 
{
	public CompareTheseItems(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf((breadcrums)));
	}

	int j;

	@FindBy(xpath="//div[@class='breadcrumbs']")
	WebElement breadcrums;

	@FindBy(xpath="//section[@class='comparison-tile']")
	List<WebElement> comparisonTiles;

	@FindBy(xpath="//a[@id='comparePageRemoveItemMain_1']")
	List<WebElement> removeLinksInsideComparisonTiles;

	@FindBy(xpath="//a[@id='addAnotherProduct']")
	WebElement addAnotherProductTile;

	@FindBy(xpath="//section[@class='comparison-tile'][1]")
	WebElement firstComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][1]//a[@id='comparePageRemoveItemMain_1']")
	WebElement removeLinkInsideFirstComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][1]//img")
	WebElement productImageInsideFirstComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][1]//section[@class='number-stepper']")
	WebElement quantityBarInsideFirstComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][1]//*[contains(text(),'Add to list')]")
	WebElement addToListInsideFirstComparisonTile;

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
	WebElement addToListInsideSecondComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][2]//*[contains(text(),'Add to quote')]")
	WebElement addToQuoteInsideSecondComparisonTile;

	@FindBy(xpath="//section[@class='comparison-tile'][2]//a[@id='add2CartBtn_1']")
	WebElement addToCartInsideSecondComparisonTile;

	@FindBy(xpath="//div[@class='breadcrumbs']//a[last()]")
	WebElement l2InBreadCrum;


	@FindBy(xpath="//div[@class=\"product-comparison-table__row\"]")
	List<WebElement> productSpecificationTableBelowProductTiles;

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
}
