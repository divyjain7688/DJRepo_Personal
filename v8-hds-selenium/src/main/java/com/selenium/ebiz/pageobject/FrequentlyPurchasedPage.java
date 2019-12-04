package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class FrequentlyPurchasedPage
{
	private  WebDriver driver; private WaitTool   waitTool;

	ArrayList<String> initialValue;
	ArrayList<Double> finalValue;
	int j;
	String message = "You have no frequently purchased products for the specified search criteria.";
	PageManager pageManager;

	public FrequentlyPurchasedPage(WebDriver driver)
	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		pageManager=new PageManager(driver);

	}


	@FindBy(xpath = "//h1[contains(text(),'Frequently Purchased')]")
	public WebElement frequentlyPurchasedpageHeadingText;

	@FindBy(xpath = "//h3[@class='montserrat']")
	WebElement noFrequentlyPurchasedProductText;

	@FindBy (xpath= "//div[@class='frequently-purchased-header__paging']")
	WebElement paginationformat;

	@FindBy (xpath= "//a[@class='frequently-purchased-filter-box__header jq-frequently-purchased-filter-box--toggle'][contains(text(),'Status')]/..")
	WebElement statusFilter;

	@FindBy (xpath= "//*[@class='frequently-purchased-filter-box__filters']/a")
	public
	WebElement activeStatusFilter;

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

	@FindBy (xpath= "//*[@class='frequently-purchased-header__paging']/div[2]")
	public
	WebElement displayedHeaderPaging;

	@FindBy(xpath="//div[@class='breadcrumbs']")
	WebElement breadCrumOnFrequentPurchasePage;

	@FindBy(xpath="//div[@class='breadcrumbs']/a[text()='Home']")
	WebElement homeInbreadCrumOnFrequentPurchasePage;

	/*@FindBy(xpath="//h1[text()='Frequently Purchased']")
	WebElement frequentlyPurchasedText;*/

	@FindBy(xpath="//div[@class='select--alt']/select[@class='jq-fpp-number-of-days-change']")
	WebElement overThePast;

	@FindBy(xpath="//div[@class='select--alt']/select[@class='jq-fpp-sort-by-change']")
	WebElement sortBy;

	//	@FindBy(xpath="//div[@class='type--semi-bold type--caption type--caps']/div[1]/span[1]")
	@FindBy(xpath="//div[@class='subcat-tile__attributes type--caption']//span[text()='Total Spent:']/../span[2]")
	List<WebElement> totalSpentValues;

	@FindBy(xpath="//div[@class='subcat-list-tile__details']//span[text()='Quantity:']/../span[2]")
	List<WebElement> quantityValues;

	@FindBy(xpath="//*[@data-hds-tag='header-quick-order__qty-field']")
	public List<WebElement> quantityFieldBox;

	@FindBy(xpath="//div[@class='subcat-list-tile__details']//span[text()='Frequency:']/../span[2]")
	List<WebElement> frequencyValues;

	@FindBy(xpath="//section[@class='subcat-list-tile']")
	List<WebElement> productDisplayed;

	@FindBy(xpath="//div[@class='pagination']//*[@data-hds-tag='icon--arrow-up-circle-next-page']")
	WebElement nextPageButton;

	@FindBy(xpath="//div[@class='pagination']/a[1]")
	WebElement previousPageButton;

	@FindBy(xpath="//div[@class='pagination__info']")
	WebElement pagination;

	@FindBy(xpath="//section[@class='subcat-list-tile'][1]//div[@class='subcat-list-tile__image']")
	public
	WebElement firstProductImage;

	// 8/23/2019 Bhavani: Updated xpath for addTocartBtn 
	//@FindBy(xpath="//*[text()='Add To Cart']")
	@FindBy(xpath="//a[@data-hds-tag='subcat-list-tile__add-to-cart']//span[text()='Add To Cart']")
	public List<WebElement> addTocartBtn;

	@FindBy(xpath="//*[@data-hds-tag='subcat-list-tile__add-to-list']")
	public
	List<WebElement> addToListBtn;

	@FindBy(xpath="//*[@data-hds-tag='subcat-tile__add-to-quote']")
	// Add to quote web property was changed in 1.14 release
	// "//*[@data-hds-tag='subcat-list-tile__add-to-quote']")
	public
	List<WebElement> addToQuotetBtn;

	@FindBy(xpath="//*[@data-hds-tag='subcat-list-tile__part']")
	public
	List<WebElement> listProductPartNumbers;

	@FindBy(xpath = "//*[@data-hds-tag='subcat-list-tile']")
	public List<WebElement> allProducts;

	@FindBy(xpath = "//*[@data-hds-tag='subcat-list-tile__details--product_name']")
	public List<WebElement> listProductsShortDescription;

	@FindBy(xpath="//section[@class='subcat-list-tile'][2]//div[@class='subcat-list-tile__image']")
	WebElement secondProductImageDisplayed;

	public boolean isBreadCrumbDisplayed() {
		return pageManager.common().isElementPresent(breadCrumOnFrequentPurchasePage);
	}

	public void breadCrumText() {
		breadCrumOnFrequentPurchasePage.getText();
	}

	/*public Boolean isFrequentlyPurchasedTextDisplayed()
	{
		return frequentlyPurchasedText.isDisplayed();
	}*/
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

	public Boolean isDisplayedOverThePastDropDown()
	{
		return overThePast.isDisplayed();
	}
	
	public Boolean isDisplayedSortByDropDown()
	{
		return sortBy.isDisplayed();
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
	
	public String getTextAndclickOnEligibleForSbscriptionsFilterFirstValueCheckBox()
	{
			eligibleForSbscriptionsFilterFirstValueCheckBox.click();
			return eligibleForSbscriptionsFilterFirstValueText.getText();
	}
	
	public String brandFilterFirstValue()
	{
		return brandFilterFirstValueText.getText();
	}

	public void clickOnBrandFilterFirstValueCheckBox()
	{
			brandFilterFirstValueCheckBox.click();
	}

	public String getTextAndclickOnBrandFilterFirstValueCheckBox()
	{
			brandFilterFirstValueCheckBox.click();
			return brandFilterFirstValueText.getText();
	}
	
	public String categoryFilterFirstValue()
	{
		return categoryFilterFirstValueText.getText();
	}

	public String getTextAndclickOnCategoryFilterFirstValueCheckBox()
	{
			categoryFilterFirstValueCheckBox.click();
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

	public String getTextAndclickOnSubcategoryFilterFirstValueCheckBox()
	{
			
			subcategoryFilterFirstValueCheckBox.click();
			return subcategoryFilterFirstValueText.getText();
	}
	
	public String displayedFilterValue()
	{
			String str = displayedHeaderPaging.getText();
			str =str.substring(str.lastIndexOf("f") + 1);
			str = str.trim();
			return str;

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

	/*public boolean isFrequentlyPurchsedTextDisplayed() {
		return .isElementPresent(frequentlyPurchasedText);
	}*/

	public boolean isFrequentlyPurchasedpageHeadingTextIdsplayed(){
		return frequentlyPurchasedpageHeadingText.isDisplayed();
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
			.navigateBackToPLP(driver);
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
			.navigateBackToPLP(driver);
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
					pageManager.common().scrolltoViewElement(nextPageButton, driver);
					nextPageButton.click();

					//WaitTool.getDefaultWait4Page();
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
			pageManager.common().navigateBack();
			return "0";
		}
	}

	public void clickOnTwelveMonthsInOverThePastDropdown()
	{
		Select select = new Select(overThePast);
		select.selectByValue("365");
	}

	public void navigateToHomePage()
	{
		homeInbreadCrumOnFrequentPurchasePage.click();

	}

	public void addToCartFirstProduct()
	{
		//waitTool.waitForElement(driver, firstProductImage);
		pageManager.common().scrolltoViewElement(firstProductImage, driver);
		addTocartBtn.get(0).click();
		//waitTool.waitFor(driver,true);

	}

	public void clickOnFirstProductDisplayed()
	{
		waitTool.waitForElement(driver, firstProductImage);
		pageManager.common().scrolltoViewElement(firstProductImage, driver);
		firstProductImage.click();

	}

	public void clickOnSecondProductDisplayed()
	{
		waitTool.waitForElement(driver, secondProductImageDisplayed);
		secondProductImageDisplayed.click();

	}
	
	public boolean isFrequentlyPurchasedPageHeadingTextDisplayed()
	{
		waitTool.waitForElement(driver, frequentlyPurchasedpageHeadingText);
		pageManager.common().scrolltoViewElement(frequentlyPurchasedpageHeadingText, driver);
		return frequentlyPurchasedpageHeadingText.isDisplayed();
	}

	public boolean isQuantityFieldBoxIsDisplayed(){
		waitTool.waitForElement(driver,quantityFieldBox.get(1));
		return quantityFieldBox.get(1).isDisplayed();
	}

	public boolean navigationToNextAndPreviousPage(){
		boolean check = false;
		Integer firstPageProductSize = pageManager.frequentlyPurchasedPage().allProducts.size();
		System.out.println("firstPageProductSize: " + firstPageProductSize);
		nextPageButton.click();
		Integer secondPageProductSize = pageManager.frequentlyPurchasedPage().allProducts.size();
		System.out.println("secondPageProductSize: " + secondPageProductSize);
		previousPageButton.click();
		waitTool.waitFor(driver,true);
		Integer previousPageProductSize = pageManager.frequentlyPurchasedPage().allProducts.size();
		System.out.println("previousPageProductSize: " + previousPageProductSize);
		Assert.assertTrue(secondPageProductSize> 0);
		if(previousPageProductSize.equals(firstPageProductSize)){
			check=true;
		}
		System.out.println(check);

		return check;
	}


	

}
