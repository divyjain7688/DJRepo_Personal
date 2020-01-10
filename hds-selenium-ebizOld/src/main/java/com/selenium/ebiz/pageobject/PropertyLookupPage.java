package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class PropertyLookupPage extends BaseClass{
	
	public PropertyLookupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf((yourPropertiesHeadingText)));
	}	
	
	//Property For Cobarnd User
	@FindBy(xpath = "//table[@id='sumaList']/tbody/tr/td[text()='SAP Web Test Account - Core Arif']")
	WebElement propertyValueForCobrandUser;
	
	//Your Properties Heading text
	@FindBy(xpath = "//div[@class=\"modal__inner\"]//div[@class=\"widget-wrapper\"]")
	WebElement yourPropertiesHeadingText;
	
	//Table column header 'Name'
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']//th[contains(text(),'Name')]")
	WebElement nameTableColumnHeader;
	
	//Table column header 'Account Number'
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']//th[contains(text(),'Account #')]")
	WebElement accountNoTableColumnHeader;

	//Table column header 'City'
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']//th[contains(text(),'City')]")
	WebElement cityTableColumnHeader;

	//Table column header 'State'
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']//th[contains(text(),'State')]")
	WebElement stateTableColumnHeader;
	
	//Name List
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']/tbody/tr/td[1]")
	List<WebElement> propertyNameList;
	
	//Account Number List
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']/tbody/tr/td[2]")
	List<WebElement> accountNumberList;

	//City List
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']/tbody/tr/td[3]")
	List<WebElement> cityList;

	//State List
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']/tbody/tr/td[4]")
	List<WebElement> stateList;
	
	@FindBy(xpath = "//table[@id='sumaList']//tbody//td[text()='SAP Web Test Account']")
	WebElement sapWebTestActCoreArif;
	
	@FindBy(xpath = "//div[@class='header__main']//div[@id='contentRecommendationWidget_HdsHeaderLogoESpot']")
	WebElement hDSupplyLogoInHeader;
	

	@FindBy(xpath = "//tr[@class='property-selector']//td[contains(text(),'0012482411')]/..")
	WebElement account411;
	
	@FindBy(xpath = "//tr[@class='property-selector']//td[contains(text(),'0010017688')]")
	WebElement selectAccount0010017688;
	
	/**
	 * click on user property from Property Lookup modal
	 */	
	public void clickProperty(String property) {
		for(WebElement we:propertyNameList) {
			if(we.getText().equalsIgnoreCase(property)) {
				we.click();
				WaitTool.waitFor(driver, true);
				break;
			}
			}
		
	}
	
	/**
	 *  @return True if properties table sorted by Name otherwise False
	 */
	public boolean IsDisplayedPropertyTableSortedByName() {
		return CommonFunctions.isTableSortedByColumn(nameTableColumnHeader,propertyNameList);
		
	}
	
	/**
	 *  @return True if properties table sorted by Account Number otherwise False
	 */
	public boolean IsDisplayedPropertyTableSortedByAccountNumber() {
		return CommonFunctions.isTableSortedByColumn(accountNoTableColumnHeader,accountNumberList);
		
	}
	
	/**
	 *  @return True if properties table sorted by City otherwise False
	 */
	public boolean IsDisplayedPropertyTableSortedByCity() {
		return CommonFunctions.isTableSortedByColumn(cityTableColumnHeader,cityList);
		
	}
	
	/**
	 *  @return True if properties table sorted by State otherwise False
	 */
	public boolean IsDisplayedPropertyTableSortedByState() {
		return CommonFunctions.isTableSortedByColumn(stateTableColumnHeader,stateList);
		
	}	
	
	public void clickSAPWebTestActCoreArif(){
		CommonFunctions.scrolltoViewElement(sapWebTestActCoreArif, driver);
		System.out.println("scrolltoViewElement");
		sapWebTestActCoreArif.click();
	}
	
	public void clickSAPWebTestActAccount411() throws Exception{
		CommonFunctions.scrolltoViewElement(account411, driver);
		System.out.println("account411");
		WaitTool.hardWait();
		System.out.println("hardWait");
		account411.click();
	}
	
	public HomePage clickOnHDSupplyLogoInHeader() throws Exception
	{
		WaitTool.hardWait2sec();
		CommonFunctions.scrolltoViewElement(hDSupplyLogoInHeader, driver);
		hDSupplyLogoInHeader.click();
		System.out.println("waited and clicked on hDSupplyLogoInHeader");
		return new HomePage(driver);	
	}
	
	/**
	 * click on Account from Property dropdown
	 */	
	public String clickOnOneAccount(){
		CommonFunctions.scrolltoViewElement(selectAccount0010017688, driver);
		String accountNumber = selectAccount0010017688.getText();
		selectAccount0010017688.click();
		return accountNumber;
	}
}

