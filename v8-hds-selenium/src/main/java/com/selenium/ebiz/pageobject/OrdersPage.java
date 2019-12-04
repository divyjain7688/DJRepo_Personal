package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class OrdersPage{
	private  WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;

	public OrdersPage(WebDriver driver) 	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		this.pageManager=new PageManager(driver);
		PageFactory.initElements(driver, this);

	}

	//@FindBy(xpath="//h1[contains(text(),'Orders')]")
	@FindBy(xpath="//h1[contains(text(),'Order History')]|//h1[contains(text(),'Orders')]")
	WebElement ordersPageTitle;


	@FindBy(xpath="//div[@class='breadcrumbs']")
	WebElement breadcrumb;

	@FindBy(xpath="//div[@class='breadcrumbs']/a[contains(text(),'Home')]")
	WebElement homeLinkInBreadcrumb;

	@FindBy(xpath="//div[@class='breadcrumbs']/a[contains(text(),'Account')]")
	WebElement accountLinkInBreadcrumb;

	@FindBy(xpath = "//td[@data-hds-tag='orders-history__order__order-number']")
	//@FindBy(xpath = "//div[@data-hds-tag='orders-history-summary']//td[@data-hds-tag='orders-history__order__order-number']")
	public List<WebElement> orderNumbers;

	@FindBy(xpath = "//div[@data-hds-tag='orders-history-summary']//td[@data-hds-tag='orders-history__order__order-number']")
	public List<WebElement> openOrderNumbers;
	
	@FindBy(xpath="//p[contains(text(),'Your order number is')]/strong/a")
	WebElement orderNumber;

	@FindBy(xpath = "//td[@data-hds-tag='orders-history__order__grand-total']")
	public List<WebElement> totalCharges;

	@FindBy(xpath = "//td[@data-hds-tag='orders-history__order__po-number']")
	public List<WebElement> poNumbers;

	@FindBy(xpath = "//td[@data-hds-tag='orders-history__order__order-status']")
	public List<WebElement> statuses;

	@FindBy(xpath = "//table[@data-hds-tag='orders-history__orders-listing']//tr[@data-hds-tag='orders-history__order']//td[1]")
	public WebElement orderNumAfterSearch;
	
	@FindBy(xpath = "//table[@data-hds-tag='orders-history__orders-listing']//td[@data-hds-tag='orders-history__order__order-number']")
	List<WebElement> openOrderNum;

	@FindBy(xpath = "//table[@data-hds-tag='orders-history__orders-listing']//tr[@data-hds-tag='orders-history__order']")
	List<WebElement> NoOforderNumAfterSearch;

	@FindBy(xpath="//div[@class='order-history__table-sort select--alt el--margin-right-4 el--margin-top-2']")
	WebElement orderHistorySortOptionsDropdown;

	@FindBy(xpath="//div[@data-hds-tag='orders-history-summary__filter']")
	WebElement orderHistoryFilterDaysDropdown;

	@FindBy(xpath="//div[@class='order-history__table-search-filter el--margin-right-1 el--margin-top-2 select--alt']")
	WebElement orderHistorySearchFilterDropdown;

	@FindBy(xpath="//select[@data-hds-tag='orders-history-summary__sort-options']")
	WebElement orderHistorySortOptionsDropdownOptions;

	@FindBy(xpath = "//select[@data-hds-tag='orders-history-summary__filter__days']")
	public WebElement orderHistoryDaysOptions;

	@FindBy(xpath = "//select[@data-hds-tag='orders-history-summary__search__filter-by']")
	public WebElement orderHistorySearchFilterOptions;

	@FindBy(xpath = "//select[@data-hds-tag='orders-history-summary__sort-options']/option[@data-hds-tag='orders-history-summary__sort__placed-on']")
	public WebElement placedOnDefaultVal;

	@FindBy(xpath = "//select[@data-hds-tag='orders-history-summary__filter__days']/option[@data-hds-tag='orders-history-summary__filter__days-90']")
	public WebElement ninetyDaysDefaultVal;

	@FindBy(xpath = "//select[@data-hds-tag='orders-history-summary__search__filter-by']/option[@data-hds-tag='orders-history-summary__search__filter-by-order']")
	public WebElement salesOrderNumberDefaultVal;

	@FindBy(id = "search-placeholder-id")
	public WebElement ordersSearchField;

	@FindBy(xpath = "//div[@data-hds-tag='orders-history-summary__search__term']//a[@id='jq-order-history-summary-search-by-id']")
	WebElement ordersSearchButton;

	@FindBy(xpath = "//table[@data-hds-tag='orders-history__orders-listing']//th[contains(text(),'Order Number')]")
	public WebElement orderNumberHeading;

	@FindBy(xpath = "//table[@data-hds-tag='orders-history__orders-listing']//th[contains(text(),'PO Number')]")
	public WebElement poNumberHeading;

	@FindBy(xpath = "//table[@data-hds-tag='orders-history__orders-listing']//th[contains(text(),'Total Charge')]")
	public WebElement totalChargeHeading;

	@FindBy(xpath = "//table[@data-hds-tag='orders-history__orders-listing']//th[contains(text(),'Placed On')]")
	public WebElement placedOnHeading;

	@FindBy(xpath = "//table[@data-hds-tag='orders-history__orders-listing']//th[contains(text(),'Status')]")
	public WebElement statusHeading;

	@FindBy(xpath = "//table[@data-hds-tag='orders-history__orders-listing']//th[contains(text(),'Shipped To')]")
	public WebElement shippedToHeading;

	@FindBy(xpath = "//div[@data-hds-tag='orders-history-summary__tabs']//a[contains(text(),'Open')]")
	public WebElement openHeadingLink;

	@FindBy(xpath = "//div[@data-hds-tag='orders-history-summary__tabs']//a[contains(text(),'Canceled')]")
	public WebElement cancelledHeadingLink;

	@FindBy(xpath = "//div[@data-hds-tag='orders-history-summary__tabs']//a[contains(text(),'All')]")
	public WebElement allHeadingLink;

	@FindBy(xpath = "//a[@data-hds-tag='orders-history-pagination-right']")
	public List<WebElement> paginationRight;




	/**
	 * get Page Heading text
	 * @return string page heading text
	 */
	public String getOrderspageHeadingText()
	{
		return ordersPageTitle.getText().trim();
	}

	public Boolean isBreadcrumbDisplayed()
	{
		return breadcrumb.isDisplayed();
	}

	public Boolean isDisplayedOrderspageHeading()
	{
		waitTool.waitForElement(driver, ordersPageTitle);
		pageManager.common().scrolltoViewElement(ordersPageTitle, driver);
		return pageManager.common().isElementPresent(ordersPageTitle);
	}

	public HomePage navigateToHomePage()
	{
		homeLinkInBreadcrumb.click();
		return new HomePage(driver);
	}

	public MyAccountPage navigateToMyAccountPage()
	{
		accountLinkInBreadcrumb.click();
		return new MyAccountPage(driver);
	}

	public void clickOnFirstOrderNumberInOrdersPage() throws Exception {
		//System.out.println(orderNumbers.get(0));
		waitTool.waitForElement(driver, orderNumbers.get(0));
		pageManager.common().scrolltoViewElement(orderNumbers.get(0), driver);
		orderNumbers.get(0).click();
	}

	public String getFirstOrderNumberInOrdersPage() throws Exception {
		waitTool.waitForElement(driver, openOrderNum.get(0));
		System.out.println(openOrderNum.get(0));
		return openOrderNum.get(0).getText();
	}

	public Boolean isDisplayedorderHistorySortOptionsDropdown()
	{
		waitTool.waitForElement(driver, orderHistorySortOptionsDropdown);
		pageManager.common().scrolltoViewElement(orderHistorySortOptionsDropdown, driver);
		return orderHistorySortOptionsDropdown.isDisplayed();
	}

	public Boolean isDisplayedorderHistoryFilterDaysDropdown()
	{
		waitTool.waitForElement(driver, orderHistoryFilterDaysDropdown);
		return orderHistoryFilterDaysDropdown.isDisplayed();
	}

	public Boolean isDisplayedorderHistorySearchFilterDropdown()
	{
		waitTool.waitForElement(driver, orderHistorySearchFilterDropdown);
		return orderHistorySearchFilterDropdown.isDisplayed();
	}

	public String getOrderNumberAfterSearch() throws Exception {
		waitTool.waitForElement(driver, orderNumAfterSearch);
		System.out.println(orderNumAfterSearch);
		return orderNumAfterSearch.getText();
	}

	public int getNoOfOrdersAfterSearch() throws Exception {
		waitTool.waitForElement(driver, NoOforderNumAfterSearch.get(0));
		System.out.println("NoOforderNumAfterSearch: " + NoOforderNumAfterSearch.size());
		return NoOforderNumAfterSearch.size();
	}

	public void isSelectedAllSortOptionsFromDropDown(){
		Select sortOptions = new Select(orderHistorySortOptionsDropdownOptions);
		System.out.println(sortOptions.getOptions().size());
		for(int i=0;i<sortOptions.getOptions().size();i++){
			sortOptions.selectByIndex(i);
			WebElement selectedValue = sortOptions.getFirstSelectedOption();
			System.out.println(selectedValue.getText());
			switch (i) {
				case 0:
					Assert.assertEquals(selectedValue.getText(),"Order Number");
					break;

				case 1:
					Assert.assertEquals(selectedValue.getText(),"PO Number");
					break;

				case 2:
					Assert.assertEquals(selectedValue.getText(),"Total Charge");
					break;

				case 3:
					Assert.assertEquals(selectedValue.getText(),"Placed On");
					break;

				case 4:
					Assert.assertEquals(selectedValue.getText(),"Status");
					break;

				case 5:
					Assert.assertEquals(selectedValue.getText(),"Shipped To");
					break;

				default:
					break;
			}
		}
	}

	public  void isSelectedAllDaysFromDropDown(){
		Select sortOptions = new Select(orderHistoryDaysOptions);
		System.out.println(sortOptions.getOptions().size());
		for(int i=0;i<sortOptions.getOptions().size();i++){
			sortOptions.selectByIndex(i);
			WebElement selectedValue = sortOptions.getFirstSelectedOption();
			System.out.println(selectedValue.getText());
			switch (i) {
				case 0:
					Assert.assertEquals(selectedValue.getText(),"Past 7 days");
					break;

				case 1:
					Assert.assertEquals(selectedValue.getText(),"Past 30 days");
					break;

				case 2:
					Assert.assertEquals(selectedValue.getText(),"Past 60 days");
					break;

				case 3:
					Assert.assertEquals(selectedValue.getText(),"Past 90 days");
					break;

				case 4:
					Assert.assertEquals(selectedValue.getText(),"Select Custom Dates");
					break;

				default:
					break;
			}
		}

	}
	public  void isSelectedAllFilterSearchFromDropDown(){
		Select sortOptions = new Select(orderHistorySearchFilterOptions);
		System.out.println(sortOptions.getOptions().size());
		for(int i=0;i<sortOptions.getOptions().size();i++){
			sortOptions.selectByIndex(i);
			WebElement selectedValue = sortOptions.getFirstSelectedOption();
			System.out.println(selectedValue.getText());
			switch (i) {
				case 0:
					Assert.assertEquals(selectedValue.getText(),"Sales Order Number(s)");
					break;

				case 1:
					Assert.assertEquals(selectedValue.getText(),"P.O.Number");
					break;

				case 2:
					Assert.assertEquals(selectedValue.getText(),"Part Number");
					break;

				case 3:
					Assert.assertEquals(selectedValue.getText(),"Keyword");
					break;

				default:
					break;
			}
		}


	}

	public void enterOrderNumberInSearchField(String orderNum){
		/*System.out.println(orderNum.substring(1));
		ordersSearchField.sendKeys(orderNum.substring(1));*/
		waitTool.waitForElement(driver, ordersSearchField);
		System.out.println(orderNum);
		ordersSearchField.sendKeys(orderNum);
	}

	public void clickOrdersSearchButton(){
		ordersSearchButton.click();
	}

	public void clickOnCreatedOrderNumberInOrdersPage(String orderNum) throws Exception {
		waitTool.waitForElement(driver, orderNumbers.get(0));
		for(int i=0; i<=orderNumbers.size()-1; i++){
			if(orderNum.substring(1).equals(orderNumbers.get(i).getText())){
				pageManager.common().scrolltoViewElement(orderNumbers.get(i), driver);
				orderNumbers.get(i).click();
				System.out.println("Clicked on Created Order Number");
			}
		}
		/*waitTool.waitFor(driver,true);
		waitTool.waitForElement(driver, orderNumber);
		.scrolltoViewElement(orderNumber, driver);
		orderNumber.click();*/
		}

	public void clickCreatedOrderNumberFromOrdersPageOpenTabs(String orderNum) throws Exception {
		waitTool.waitForElement(driver, openOrderNumbers.get(0));
		for(int i=0; i<=openOrderNumbers.size()-1; i++){
			if(orderNum.equals(openOrderNumbers.get(i).getText())){
				pageManager.common().scrolltoViewElement(openOrderNumbers.get(i), driver);
				openOrderNumbers.get(i).click();
				System.out.println("Clicked on Created Order Number");
			}
		}
		waitTool.waitFor(driver,true);

	}



	/*public void isSelectedOrderNumber(){
		Select sortOptions = new Select(orderHistorySortOptionsDropdownOptions);
		sortOptions.getOptions().size();
		sortOptions.selectByIndex(0);

		WebElement selectedValue = sortOptions.getFirstSelectedOption();
		System.out.println(selectedValue.getText());
		Assert.assertEquals(selectedValue.getText(),"Order Number");
	}*/

		/*	public  void isSelectedAllFilterSearchFromDropDown(WebDriver driver, WebElement element){
				Select sortOptions = new Select(element);
				System.out.println(sortOptions.getOptions().size());
				for(int i=0;i<sortOptions.getOptions().size();i++){
					sortOptions.selectByIndex(i);
					WebElement selectedValue = sortOptions.getFirstSelectedOption();
					System.out.println(selectedValue.getText());
					switch (i) {
					case 0:
						Assert.assertEquals(selectedValue.getText(),"Order Number");
						break;

					case 1:
						Assert.assertEquals(selectedValue.getText(),"PO Number");
						break;

					case 2:
						Assert.assertEquals(selectedValue.getText(),"Total Charge");
						break;

					case 3:
						Assert.assertEquals(selectedValue.getText(),"Placed On");
						break;

					case 4:
						Assert.assertEquals(selectedValue.getText(),"Status");
						break;

					case 5:
						Assert.assertEquals(selectedValue.getText(),"Shipped To");
						break;

					default:
						break;
					}
				}


	}*/


	public String getDaysDefaultText(){
		//.selectByVisibleTextFromDropdown(orderHistorySortOptionsDropdownOptions, "Placed On");
		//return orderHistorySortOptionsDropdownOptions.getText();
		return pageManager.common().getSelectedDropdownOption(driver, orderHistorySortOptionsDropdownOptions);
	}

	/*public String getSalesOrderDefaultText(){
		return orderHistorySearchFilterDropdown.getText();
	}*/


	public String getPlacedOnDefaultText(){
		return pageManager.common().getSelectedDropdownOption(driver, orderHistorySortOptionsDropdownOptions);
	}

	public boolean isOrderPageHeadingDisplayed(){
		pageManager.common().scrolltoViewElement(orderNumberHeading,driver);
		orderNumberHeading.isDisplayed();
		poNumberHeading.isDisplayed();
		totalChargeHeading.isDisplayed();
	    placedOnHeading.isDisplayed();
		statusHeading.isDisplayed();
		shippedToHeading.isDisplayed();

		return true;

	}

	/*public void isSelectedAllSortOptions(){
		 getSelectedDropDownText(driver, orderHistorySortOptionsDropdownOptions);
	}*/

 public Boolean isPONumberDisapleyed(String pnumber)
 {
	 Boolean flag = false;
	 for(WebElement poNumber : poNumbers)
	 {
		 if(poNumber.getText().contains(pnumber))
		 {
			 flag=true;
			 System.out.println("flag is true now" +flag);
			 break;
		 }
	 }
	 System.out.println("flag value is "+ flag);
	 return flag;
 }
}

