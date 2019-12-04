package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PropertyLookupPage {
	private  WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;
	
	public PropertyLookupPage(WebDriver driver) {
		this.driver = driver;  this.waitTool = new WaitTool();
		this.pageManager=new PageManager(driver);
		PageFactory.initElements(driver, this);
	//	WebDriverWait wait = new WebDriverWait(driver, 5000);
	//	wait.until(ExpectedConditions.visibilityOf((yourPropertiesHeadingText)));
	}	
	
	//Property For Cobarnd User
	@FindBy(xpath = "//table[@id='sumaList']/tbody/tr/td[text()='SAP Web Test Account - Core Arif']")
	WebElement propertyValueForCobrandUser;
	
	//Your Properties Heading text
	@FindBy(xpath = "//div[@class='modal__inner']//div[@class='widget-wrapper']")
	WebElement yourPropertiesHeadingText;
	
	@FindBy(xpath = "//select[@class='jq-suma-list-sort']/option[@value='Name']")
	WebElement selectNameFromHeader; 
	
	@FindBy(xpath = "//select[@class='jq-suma-list-sort']/option[@value= 'Account #']")
	WebElement selectAccountFromDropdown; 
	
	@FindBy(xpath = "//select[@class='jq-suma-list-sort']/option[@value='City']")
	WebElement selectCityFromDropdown; 
	
	@FindBy(xpath = "//select[@class='jq-suma-list-sort']/option[@value= 'State']")
	WebElement selectStateFromDropdown; 
	
	//Table column header 'Name'
	@FindBy(xpath = "//div[@class='modal__content']//th[text()='Name']")
	WebElement nameTableColumnHeader;
	
	//Table column header 'Account Number'
	@FindBy(xpath = "//div[@class='modal__content']//th[text()='Account #']")
	WebElement accountNoTableColumnHeader;

	//Table column header 'City'
	@FindBy(xpath = "//div[@class='modal__content']//th[text()='City']")
	WebElement cityTableColumnHeader;

	//Table column header 'State'
	@FindBy(xpath = "//div[@class='modal__content']//th[text()='State']")
	WebElement stateTableColumnHeader;
	
	//Name List
	//@FindBy(xpath = "//*[@id=\"sumaList\"]//tbody/tr/td[1]")
	@FindBy(xpath = "//table[@id='sumaList']//tr/td[1]")
	List<WebElement> propertyNameList;
	
	//Account Number List
	@FindBy(xpath = "//*[@id=\"sumaList\"]//tbody/tr/td[2]")
	List<WebElement> accountNumberList;

	//City List
	@FindBy(xpath = "//*[@id=\"sumaList\"]//tbody/tr/td[3]")
	List<WebElement> cityList;

	//State List
	@FindBy(xpath = "//*[@id=\"sumaList\"]//tbody/tr/td[4]")
	List<WebElement> stateList;
	
	@FindBy(xpath = "//table[@id='sumaList']//tbody//td[text()='SAP Web Test Account']")
	WebElement sapWebTestActCoreArif;
	
	@FindBy(xpath = "//div[@class='header__main']//div[@id='contentRecommendationWidget_HdsHeaderLogoESpot']")
	WebElement hDSupplyLogoInHeader;
	

	@FindBy(xpath = "//tr[@class='property-selector']//td[contains(text(),'0012482411')]/..")
	WebElement account411;
	
	//@FindBy(xpath = "//tr[@class='property-selector']//td[contains(text(),'0010017688')]")
	@FindBy(xpath = "//tr[@class='property-selector'][1]//td[2]")
	WebElement selectFirstAccount;
	
	/**
	 * click on user property from Property Lookup modal
	 */	
	public void clickProperty(String property) {
		//.scrolltoViewElement(propertyNameList.get(0), driver);
		for(WebElement we:propertyNameList) {
			if(we.getText().equalsIgnoreCase(property)) {
				we.click();
				waitTool.waitFor(driver, true);
				break;
			}
			}
		
	}
	
	/**
	 *  @return True if properties table sorted by Name otherwise False
	 */
	public boolean IsDisplayedPropertyTableSortedByName() {
		waitTool.waitForElement(driver, nameTableColumnHeader);
		return pageManager.common().isTableSortedByColumn(nameTableColumnHeader,propertyNameList);
		
	}
	
	/**
	 *  @return True if properties table sorted by Account Number otherwise False
	 */
	public boolean IsDisplayedPropertyTableSortedByAccountNumber() {
		//waitTool.waitForElement(driver, accountNoTableColumnHeader);selectAccountFromDropdown
		waitTool.waitForElement(driver, selectAccountFromDropdown);
		return pageManager.common().isTableSortedByColumn(selectAccountFromDropdown,accountNumberList);
		
	}
	
	/**
	 *  @return True if properties table sorted by City otherwise False
	 */
	public boolean IsDisplayedPropertyTableSortedByCity() {
		//waitTool.waitForElement(driver, cityTableColumnHeader);
		waitTool.waitForElement(driver, selectCityFromDropdown);
		return pageManager.common().isTableSortedByColumn(selectCityFromDropdown, cityList);
		
	}
	
	/**
	 *  @return True if properties table sorted by State otherwise False
	 */
	public boolean IsDisplayedPropertyTableSortedByState() {
		//waitTool.waitForElement(driver, stateTableColumnHeader);
		waitTool.waitForElement(driver, selectStateFromDropdown);
		return pageManager.common().isTableSortedByColumn(selectStateFromDropdown,stateList);
		
	}	
	
	public void clickSAPWebTestActCoreArif(){
		sapWebTestActCoreArif.getSize();
		pageManager.common().scrolltoViewElement(sapWebTestActCoreArif, driver);
		System.out.println("scrolltoViewElement");
		sapWebTestActCoreArif.click();
	}
	
	public void clickSAPWebTestActAccount411() throws Exception{
		pageManager.common().scrolltoViewElement(account411, driver);
		System.out.println("account411");
	//	waitTool.hardWait();
		waitTool.waitForElement(driver, account411);
		account411.click();
	}
	
	public HomePage clickOnHDSupplyLogoInHeader() throws Exception
	{
		//waitTool.hardWait2sec();
		waitTool.waitForElement(driver, hDSupplyLogoInHeader);
		pageManager.common().scrolltoViewElement(hDSupplyLogoInHeader, driver);
		hDSupplyLogoInHeader.click();
		System.out.println("waited and clicked on hDSupplyLogoInHeader");
		return new HomePage(driver);	
	}
	
	/**
	 * click on Account from Property dropdown
	 */	
	public String clickOnOneAccount(){
		waitTool.waitForElement(driver, selectFirstAccount);

		pageManager.common().scrolltoViewElement(selectFirstAccount, driver);
		
		String accountNumber = selectFirstAccount.getText();
		selectFirstAccount.click();
		return accountNumber;
	}
}

