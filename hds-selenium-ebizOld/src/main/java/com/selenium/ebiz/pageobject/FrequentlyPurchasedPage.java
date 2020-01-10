package com.selenium.ebiz.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class FrequentlyPurchasedPage extends BaseClass{
	ArrayList<String> initialValue ;
	ArrayList<Double> finalValue ;
	int j;
	String message = "You have no frequently purchased products for the specified search criteria.";
	public FrequentlyPurchasedPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver,0);
		wait.until(ExpectedConditions.visibilityOf((frequentlyPurchasedpageHeadingText)));
	}


	@FindBy(xpath = "//h1[contains(text(),'Frequently Purchased')]")
	WebElement frequentlyPurchasedpageHeadingText;

	@FindBy(xpath = "//h3[@class='montserrat']")
	WebElement noFrequentlyPurchasedProductText;


	@FindBy (xpath= "//div[@class='frequently-purchased-header__paging']")
	WebElement paginationformat;

	@FindBy (xpath= "//a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle'][contains(text(),'Status')]/..")
	WebElement statusFilter;

	@FindBy (xpath= "//div[@class='frequently-purchased-filter-box frequently-purchased-filter-box--expanded'][3]/a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle']")
	WebElement categoryFilter;

	@FindBy (xpath= "//a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle'][contains(text(),'Sub Category')]/..")
	WebElement subcategoryFilter;

	@FindBy (xpath= "//a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle'][contains(text(),'Brand')]/..")
	WebElement brandFilter;

	@FindBy (xpath= "//a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle'][contains(text(),'Status')]/../div/a")
	WebElement statusFilterActiveValueText;

	@FindBy (xpath= "//a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle'][contains(text(),'Brand')]/../div[1]//div")
	WebElement brandFilterFirstValueText;

	@FindBy (xpath= "//a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle'][contains(text(),'Brand')]/../div[1]//div/../span")
	WebElement brandFilterFirstValueCheckBox;

	@FindBy (xpath= "//div[@class='frequently-purchased-filter-box frequently-purchased-filter-box--expanded'][3]/a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle']/../div[1]//div")
	WebElement categoryFilterFirstValueText;

	@FindBy (xpath= "//div[@class='frequently-purchased-filter-box frequently-purchased-filter-box--expanded'][3]/a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle']/../div[1]//div/../span")
	WebElement categoryFilterFirstValueCheckBox;

	@FindBy (xpath= "//a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle'][contains(text(),'Sub Category')]/../div[1]//div")
	WebElement subcategoryFilterFirstValueText;

	@FindBy (xpath= "//a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle'][contains(text(),'Sub Category')]/../div[1]//div/../span")
	WebElement subcategoryFilterFirstValueCheckBox;

	@FindBy (xpath= "//a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle'][contains(text(),'Eligible for Subscriptions?')]/../div[1]//div")
	WebElement eligibleForSbscriptionsFilterFirstValueText;

	@FindBy (xpath= "//a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle'][contains(text(),'Eligible for Subscriptions?')]/../div[1]//div/../span")
	WebElement eligibleForSbscriptionsFilterFirstValueCheckBox;

	@FindBy (xpath= "//a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle'][contains(text(),'Status')]")
	WebElement statusFilterFirstValueText;

	@FindBy (xpath= "//div[@class='frequently-purchased-header__paging']/div[2]")
	WebElement displayFilterValue;

	@FindBy(xpath="//div[@class='breadcrumbs']")
	WebElement breadCrumOnFrequentPurchasePage;
	
	@FindBy(xpath="//div[@class='breadcrumbs']/a[text()='Home']")
	WebElement homeInbreadCrumOnFrequentPurchasePage;

	@FindBy(xpath="//h1[text()='Frequently Purchased']")
	WebElement frequentlyPurchasedText;

	@FindBy(xpath="//div[@class='select--alt']/select[@class='jq-fpp-number-of-days-change']")
	WebElement overThePast;

	@FindBy(xpath="//div[@class='select--alt']/select[@class='jq-fpp-sort-by-change']")
	WebElement sortBy;

	//	@FindBy(xpath="//div[@class='type--semi-bold type--caption type--caps']/div[1]/span[1]")
	@FindBy(xpath="//div[@class='subcat-tile__attributes type--caption']//span[text()='Total Spent:']/../span[2]")
	List<WebElement> totalSpentValues;

	@FindBy(xpath="//div[@class='subcat-list-tile__details']//span[text()='Quantity:']/../span[2]")
	List<WebElement> quantityValues;

	@FindBy(xpath="//div[@class='subcat-list-tile__details']//span[text()='Frequency:']/../span[2]")
	List<WebElement> frequencyValues;

	@FindBy(xpath="//section[@class='subcat-list-tile']")
	List<WebElement> productDisplayed;

	@FindBy(xpath="//div[@class='pagination']//*[@data-hds-tag='icon--arrow-up-circle-next-page']")
	WebElement nextPageButton;
	
	@FindBy(xpath="//div[@class='pagination__info']")
	WebElement pagination;
	
	@FindBy(xpath="//section[@class='subcat-list-tile'][1]//div[@class='subcat-list-tile__image']")
	WebElement firstProductDisplayed;
	
	@FindBy(xpath="//section[@class='subcat-list-tile'][2]//div[@class='subcat-list-tile__image']")
	WebElement secondProductDisplayed;
	
	public boolean isBreadCrumbDisplayed() {
		return CommonFunctions.isElementPresent(breadCrumOnFrequentPurchasePage);
	}

	public void breadCrumText() {
		breadCrumOnFrequentPurchasePage.getText();
	}

	public Boolean isFrequentlyPurchasedTextDisplayed()
	{
		return frequentlyPurchasedText.isDisplayed();
	}
	public Boolean isStatusFilterDisplayed()
	{
		return statusFilter.isDisplayed();
	}

	public Boolean isCategoryFilterDisplayed()
	{
		return categoryFilter.isDisplayed();
	}

	public Boolean isSubcategoryFilterDisplayed()
	{
		return subcategoryFilter.isDisplayed();
	}

	public Boolean isBrandFilterDisplayed()
	{
		return brandFilter.isDisplayed();
	}

	public String statusFilterActiveValue()
	{
		System.out.println("statusFilterActiveValueText.getText() is " + statusFilterActiveValueText.getText());
		return statusFilterActiveValueText.getText();
	}

	public String eligibleForSbscriptionsFilterFirstValue()
	{
		return eligibleForSbscriptionsFilterFirstValueText.getText();
	}

	public void clickOnEligibleForSbscriptionsFilterFirstValueCheckBox()
	{
		eligibleForSbscriptionsFilterFirstValueCheckBox.click();
	}

	public String brandFilterFirstValue()
	{
		return brandFilterFirstValueText.getText();
	}

	public void clickOnBrandFilterFirstValueCheckBox()
	{
		brandFilterFirstValueCheckBox.click();
	}

	public String categoryFilterFirstValue()
	{
		return categoryFilterFirstValueText.getText();
	}

	public void clickOnCategoryFilterFirstValueCheckBox()
	{
		categoryFilterFirstValueCheckBox.click();
	}

	public String subcategoryFilterFirstValue()
	{
		return subcategoryFilterFirstValueText.getText();
	}

	public void clickOnSubcategoryFilterFirstValueCheckBox()
	{
		subcategoryFilterFirstValueCheckBox.click();
	}

	public String displayedFilterValue()
	{
		try 
		{			
			String str = displayFilterValue.getText();
			str =str.substring(str.lastIndexOf("f") + 1);
			str = str.trim();
			return str;
		}
		catch(Exception e) 
		{
			return "0";
		}

	}

	public Boolean isPaginationformatdisplayed()
	{
		return paginationformat.isDisplayed();
	}

	/**
	 * get Page Heading text
	 * @return string page heading text
	 */
	public String getFrequentlyPurchasedpageHeadingText() {
		return frequentlyPurchasedpageHeadingText.getText().trim();
	}

	public boolean isFrequentlyPurchsedTextDisplayed() {
		return CommonFunctions.isElementPresent(frequentlyPurchasedText);
	}

	public List getOverThePastDropdown()
	{
		Select select = new Select(overThePast);  
		List<WebElement> options = select.getOptions(); 
		return options;
	}

	public List getSortByDropdown()
	{
		Select select = new Select(sortBy);  
		List<WebElement> options = select.getOptions();  
		return options;
	}

	public String defaultValueinOverThePastDropdown()
	{
		Select select = new Select(overThePast);  
		return select.getFirstSelectedOption().getText();
	}


	public boolean isSortByTotalSpentValue()
	{		
		initialValue= new ArrayList<String>();
		finalValue= new ArrayList<Double>();
		Select select = new Select(sortBy);  
		select.selectByValue("purchaseTotal");
		for(WebElement tspent : totalSpentValues)
		{
			initialValue.add(tspent.getText());

		}
		System.out.println("initialValue are" + initialValue);
		for(String initVal : initialValue)
		{
			initVal=initVal.substring(1);
			initVal = initVal.replace(",", "");
			initVal = initVal.replace(".", "");
			double finVal = Double.parseDouble(initVal);
			finalValue.add(finVal);
		}
		System.out.println("final value are " + finalValue);
		boolean sorted = false;        
		for (int i = 1; i < finalValue.size(); i++) {

			if (finalValue.get(i-1).compareTo(finalValue.get(i)) >= 0) 
				sorted = true;
		}
		System.out.println("sorted value is  " + sorted);
		return sorted;

	}


	public boolean isSortByQuantityValue()
	{		
		initialValue= new ArrayList<String>();
		finalValue= new ArrayList<Double>();
		Select select = new Select(sortBy);  
		select.selectByValue("totalQty");
		for(WebElement quant : quantityValues)
		{
			initialValue.add(quant.getText());
		}
		System.out.println("initialValue are" + initialValue);
		for(String initVal : initialValue)
		{
			initVal = initVal.replace(",", "");
			initVal = initVal.replace(".", "");
			double finVal = Double.parseDouble(initVal);
			finalValue.add(finVal);
		}
		System.out.println("final value are " + finalValue);
		boolean sorted = false;        
		for (int i = 1; i < finalValue.size(); i++) {

			if (finalValue.get(i-1).compareTo(finalValue.get(i)) >= 0) sorted = true;
		}
		System.out.println("sorted value is  " + sorted);
		return sorted;

	}

	public boolean isSortByFrequencyValue()
	{		
		initialValue= new ArrayList<String>();
		finalValue= new ArrayList<Double>();
		Select select = new Select(sortBy);  
		select.selectByValue("timesOrdered");
		for(WebElement freq : frequencyValues)
		{
			initialValue.add(freq.getText());
		}
		System.out.println("initialValue are" + initialValue);
		for(String initVal : initialValue)
		{
			initVal = initVal.replace(",", "");
			initVal = initVal.replace(".", "");
			double finVal = Double.parseDouble(initVal);
			finalValue.add(finVal);
		}
		System.out.println("final value are " + finalValue);
		boolean sorted = false;        
		for (int i = 1; i < finalValue.size(); i++) {

			if (finalValue.get(i-1).compareTo(finalValue.get(i)) >= 0) sorted = true;
		}
		System.out.println("sorted value is  " + sorted);
		return sorted;
	}

	public void clickOnThreeMonthsInOverThePastDropdown() 
	{
		Select select = new Select(overThePast); 
		select.selectByValue("91");
	}


	/*public String overThePastThreeMonthFilterProducts()
	{	

		if(productDisplayed.size()>0)
		{
			System.out.println("productDisplayed.size()" + productDisplayed.size());
			return 	Integer.toString(productDisplayed.size());

		}
		else 
		{
			CommonFunctions.navigateBack(driver);
			System.out.println("0000000");
			return "0";
		}

	}*/

	public void clickOnSixMonthsInOverThePastDropdown() 
	{
		Select select = new Select(overThePast); 
		select.selectByValue("182");
	}

/*	public String overThePastSixMonthFilterProducts()
	{	

		if(productDisplayed.size()>0)
		{
			System.out.println("productDisplayed.size()" + productDisplayed.size());
			return 	Integer.toString(productDisplayed.size());
		}
		else 
		{
			CommonFunctions.navigateBack(driver);
			System.out.println("0000000");
			return "0";
		}


	}*/

	public void clickOnNineMonthsInOverThePastDropdown() 
	{
		Select select = new Select(overThePast); 
		select.selectByValue("273");
	}

	public String overThePastFilterProducts() throws Exception
	{	

		if(productDisplayed.size()>0)
		{
			int size =0;
			try {
			String paginationtext = pagination.getText();
			paginationtext =paginationtext.substring(paginationtext.lastIndexOf("f") + 1);
			paginationtext=paginationtext.trim();
			int paginationNumber = Integer.parseInt(paginationtext);			

			for(int i=1;i<paginationNumber;i++)
			{
				size = size + productDisplayed.size();
				System.out.println("size isssss"+ size);
				CommonFunctions.scrolltoViewElement(nextPageButton, driver);
				nextPageButton.click();
				WaitTool.hardWait();
			}
			System.out.println("productDisplayed.size()" + size);
			}
			catch(NoSuchElementException  e)
			{
				System.out.println("there is no pagination");
			}
			size = size +  productDisplayed.size();
			System.out.println("productDisplayed.size()" + size);
			String numberOfProductTiles = Integer.toString(size);
			return numberOfProductTiles;

		}
		else 
		{
			CommonFunctions.navigateBack(driver);
			System.out.println("0000000");
			return "0";
		}


	}

	public void clickOnTwelveMonthsInOverThePastDropdown() 
	{
		Select select = new Select(overThePast); 
		select.selectByValue("365");
	}

	public HomePage navigateToHomePage()
	{
		homeInbreadCrumOnFrequentPurchasePage.click();
		return new HomePage(driver);
	}

	public ProductDetailsPage clickOnFirstProductDisplayed()
	{
		WaitTool.waitForElement(driver, firstProductDisplayed);
		CommonFunctions.scrolltoViewElement(firstProductDisplayed, driver);
		firstProductDisplayed.click();
		return new ProductDetailsPage(driver);
	}
	
	public ProductDetailsPage clickOnSecondProductDisplayed()
	{
        WaitTool.waitForElement(driver, secondProductDisplayed);
		secondProductDisplayed.click();
		return new ProductDetailsPage(driver);
	}

}
