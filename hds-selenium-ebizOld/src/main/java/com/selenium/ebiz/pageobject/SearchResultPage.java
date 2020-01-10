package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.By;
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

public class SearchResultPage extends BaseClass {
	WebDriver driver;
	public SearchResultPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(headerSearchResultText));
		
	}
	
	@FindBy(xpath="//div[@class=\"subcat-grid-tile__header type--caption input-group compare_target\"]/span")
	WebElement searchPartNumberText;
	
	@FindBy(xpath = "//*[@class='montserrat type--body-x-large'][contains(text(), 'We're sorry, we couldn't find any results for')]")
	WebElement noResultPageTitle;
	
	@FindBy(xpath="//span[@class='type--body-x-large price--offerprice']")
	WebElement searchPriceText;
	
	@FindBy(xpath ="//div[@class='widget_search_results']/section/p[1][contains(text(), 'Check your spelling or use different keywords and try again.')]")	
	WebElement noResultPagePara1;

	@FindBy(xpath ="//div[@class='widget_search_results']/section/p[2][contains(text(), 'The item you are looking for may be discontinued or available by calling us at 1.800.431.3000.')]")
	WebElement noResultPagePara2;
	
	@FindAll(@FindBy(xpath="//div[@class=\"subcat-tile__attributes type--caption\"]//span[text()='Brand:']/.."))
	WebElement searchBrandText;
	
	@FindBy(xpath="//label[starts-with(@id,'facet_1159710810195112114105991015840123505332534812541_10_-3004_')]/span")
	WebElement searchPriceCheckbox;
	
	@FindBy(xpath="//label[starts-with(@id,'facet_98114971101005887104105114108112111111108_10_-3004_')]/span")
	WebElement searchBrandCheckbox;
	
	@FindBy(xpath = "//h1[contains(text(),'Search result')]")
	WebElement headerSearchResultEdit;
	
	@FindBy(xpath = "//h1[contains(text(),'Search')]")
	WebElement headerSearchResultText;
	
	@FindBy(xpath = "//DIV[@class=\"header__main\"]//a[@class='main__logo']")
	WebElement hDSupplyLogo;
	
	@FindBy(xpath = "//div[@class='subcat-grid-tile-container']")
	WebElement searchResultPageGridViewIcon;	
	
	@FindBy(css = "#WC_SearchBasedNavigationResults_pagination_link_grid_categoryResults")
	WebElement gridViewTextElement;
	
	@FindBy (xpath = "//*[contains(@class,'icon--list-view icon icon--list-view--disabled')]")
	WebElement listViewDisabledState;
	
	
	// List<WebElement> searchResultList= driver.findElements(By.xpath("//div[@class='subcat-grid-tile-container']/section"));
	

	public boolean noResultPagePara1() {
		//System.out.println(noResultPagePara1.getText());
		return  noResultPagePara1.isDisplayed();
	}

	public boolean noResultPagePara2() {
		return  noResultPagePara2.isDisplayed();
	}
	
	/**
	 * @return the Search Part Number
	 */
	public String getSearchPartNumberText() {
		return searchPartNumberText.getText().trim();
	}
	
	public boolean isDisplayedSearchPriceText(){
		return CommonFunctions.isElementPresent(searchPriceText);
	}
	
	/**
	 *  Verify to display of Price
	 * @return
	 */
	public boolean isDisplayedSearchBrandText(){
		return CommonFunctions.isElementPresent(searchBrandText);
	}

	/**
	 * Method to click on Price checkbox
	 * @return boolean true\false
	 */
	public void clickSearchPriceCheckbox() {
		WaitTool.waitForElement(driver,	searchPriceCheckbox);
		searchPriceCheckbox.click();
		WaitTool.waitFor(driver, true);
	}
	
	/**
	 * Method to click on Price checkbox
	 * @return boolean true\false
	 */
	public SearchResultPage clickSearchBrandCheckbox() {
		WaitTool.waitForElement(driver,	searchBrandCheckbox);
		searchBrandCheckbox.click();
		WaitTool.waitFor(driver, true);
		return new SearchResultPage(driver);
	}
	
	/**
	 * Method to verify is search result is displayed.
	 * @return boolean true\false
	 */
	public boolean isDisplayedSearchResultList(){
		System.out.println("Search in method");
		List<WebElement> searchResultList= driver.findElements(By.xpath("//div[@class='subcat-grid-tile-container']/section"));
		if(searchResultList.size()>0)
			return true;
		else
			return false;			
	}
	
	/**
	 * Method to Method to verify if search result is displayed in grid view
	 * @return boolean true\false
	 */
	public boolean isDisplayedSearchResultPageGridViewIcon(){
		return CommonFunctions.isElementPresent(searchResultPageGridViewIcon);		
		
	}
	
	/**
	 * Method to click on home page logo to return to homepage
	 * @return boolean true\false
	 */
	public LoginPage clickOnHDSupplyLogo() {
		WaitTool.waitForElement(driver,	hDSupplyLogo);
		hDSupplyLogo.click();
		WaitTool.waitFor(driver, true);
		return new LoginPage(driver);
		
	}
	
	public HomePage clickOnHDSupplyLogoAsLoggedinUser() {
		WaitTool.waitForElement(driver,	hDSupplyLogo);
		hDSupplyLogo.click();
		WaitTool.waitFor(driver, true);
		return new HomePage(driver);
		
	}
	
	public void clickGridViewTextElement() {
		gridViewTextElement.click();
	}
	
	/**
	 * Method to Method to verify if search result is displayed in list view
	 * @return If true : List view is NOT the view; if false List view is the current view
	 */
	public boolean isDisplayedSearchResultPageListViewIcon(){
		return CommonFunctions.isElementPresent(listViewDisabledState);		
		
	}
	
	public boolean noResultSearchTitle() {
		return  noResultPageTitle.isDisplayed();
	}
}
