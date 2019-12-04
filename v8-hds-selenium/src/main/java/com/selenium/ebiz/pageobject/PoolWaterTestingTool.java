package com.selenium.ebiz.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.SwitchTool;
import com.selenium.ebiz.tools.WaitTool;

public class PoolWaterTestingTool {
	private WebDriver driver;
	protected WaitTool waitTool;
	private PageManager pageManager;


	public PoolWaterTestingTool(WebDriver driver)
	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager = new PageManager(driver);
	}

	@FindBy(xpath="//h1[text()='Pool Water Testing']")
	public WebElement poolWaterTestingHeader;
	
	
	@FindBy(xpath="//div[@class='breadcrumbs']//a[text()='Pool Care & Maintenance']")
	public WebElement poolCareAndMaintenanceLinkInBreadcrumb;
	
	@FindBy(xpath="//div[@class='pool-water-analysis__volume-container el--margin-top-2 type--caption']/div[1]")
	public WebElement mandatoryPoolVolumeText;
	
	@FindBy(xpath="//div[@class='el--flex--wrap el--margin-top-2 type--caption']/div[1]")
	public WebElement mandatoryPoolTypeText;
	
	@FindBy(xpath="//div[@class='pool-water-analysis__options']/label[1]")
	public WebElement mandatoryFreeChlorineText;
	
	@FindBy(xpath="//div[@class='pool-water-analysis__options']/label[2]")
	public WebElement mandatoryPhText;
	
	@FindBy(xpath="//input[@class='pool-water-analysis__volume jq-pool-water-analysis__amount el--margin-right-1']")
	public WebElement poolVolumeTextBox;
	
	@FindBy(xpath="//select[@class='pool-water-analysis__volume-unit el--margin-top-1']	")
	public WebElement poolVolumeDropdown;
	
	@FindBy(xpath="//div[text()='Chlorine']/../span")
	public WebElement chlorineRadioButton;
	
	@FindBy(xpath="//div[text()='Salt']/../span")
	public WebElement saltRadioButton;
	
	@FindBy(xpath="//div[@class='pool-water-analysis__options']/label[1]//input")
	public WebElement freeChlorineTextBox;
	
	@FindBy(xpath="//div[@class='pool-water-analysis__options']/label[2]//input")
	public WebElement pHTextBox;
	
	@FindBy(xpath="//span[text()='Total Hardness']/..//input")
	public WebElement totalHardnessTextBox;
	
	@FindBy(xpath="//span[text()='Total Alkalinity']/..//input")
	public WebElement totalAlkalinityTextBox;

	@FindBy(xpath="//span[text()='Total Chlorine']/..//input")
	public WebElement totalChlorineTextBox;
	
	@FindBy(xpath="//span[text()='Cyanuric acid']/..//input")
	public WebElement cyanuricAcidTextBox;
	
	@FindBy(xpath="//div[text()='Algae?']/../span")
	public WebElement algaeCheckBox;
	
	@FindBy(xpath="//div[text()='Cloudy?']/../span")
	public WebElement cloudyCheckBox;
	
	@FindBy(xpath="//button[contains(text(),'Calculate')]")
	public WebElement calculateButton;
	
	@FindBy(xpath="//div[@class='pool-water-analysis__treatment-plan__step el--margin-top-2']")
	public List<WebElement> recommendedProducts;	
	
	@FindBy(xpath="//div[@class='pool-water-analysis__treatment-plan__header-right el--padding-3']")
	public WebElement dataPoolSnapshot;
	
	@FindBy(xpath="//div[@class='input__error type--body-small error-show']")
	public List<WebElement> errorMessageForWrongData;
	
	@FindBy(xpath="//div[@class='pool-water-analysis__email-print el--margin-top-4']/div[@class='email-print']")
	public WebElement emailAndPrintAtBottomOfPage;
	
	@FindBy(xpath="//div[@class='pool-water-analysis__header']//div[@class='email-print']")
	public WebElement emailAndPrintAtTopOfPage;
	
	@FindBy(xpath="//div[@class='product-detail__buttons el--margin-top-2 ']/button[@class='btn btn--full btn--large type--caps']/../..//div[@class='product-detail__part-number type--body-small type--caps el--margin-top-1']")
	public List<WebElement> recommendedPartNumbers;
	
	@FindBy(xpath="//div[@class='product-detail__buttons el--margin-top-2 ']/button[@class='btn btn--full btn--large type--caps']")
	public List<WebElement> addToCartOfecommendedPartNumbers;
	
	@FindBy(xpath="//div[@class='product-detail__buttons el--margin-top-2 ']//button[contains(text(),'Add to list')]/../../..//div[@class='product-detail__product-name']/a")
	public List<WebElement> productNameOfecommendedPartNumbers;
	
	@FindBy(xpath="//div[@class='product-detail__buttons el--margin-top-2 ']//a[contains(text(),'Add to quote')]/../../..//div[@class='product-detail__product-name']/a")
	public List<WebElement> productNameOfecommendedPartNumbersGuestUser;
	
	@FindBy(xpath="//div[@class='product-detail__buttons el--margin-top-2 ']//button[contains(text(),'Add to list')]")
	public List<WebElement> addToListOfecommendedPartNumbers;
	
	@FindBy(xpath="//div[@class='product-detail__buttons el--margin-top-2 ']//a[contains(text(),'Add to list')]	")
	public List<WebElement> addToListOfecommendedPartNumbersGuestUser;
	
	@FindBy(xpath="//div[@class='product-detail__buttons el--margin-top-2 ']//a[contains(text(),'Add to quote')]")
	public List<WebElement> addToQuoteOfecommendedPartNumbersGuestUser;
	
	@FindBy(xpath="//div[@class='product-detail__buttons el--margin-top-2 ']//button[contains(text(),'Add to quote')]")
	public List<WebElement> addToQuoteOfecommendedPartNumbers;
	
	public Boolean  isPoolWaterTestingHeaderDisplayed()
	{
		waitTool.waitForElement(driver, poolWaterTestingHeader);
		 return poolWaterTestingHeader.isDisplayed();
	}
	
	public Boolean areMandatoryFieldsDisplayed()
	{
		Boolean flag = false;
		List<WebElement> mandatory = new ArrayList<WebElement>();
		mandatory.add(mandatoryPoolVolumeText);
		mandatory.add(mandatoryPoolTypeText);
		mandatory.add(mandatoryFreeChlorineText);
		mandatory.add(mandatoryPhText);
		
		for(WebElement mandate : mandatory)
		{
			if(mandate.isDisplayed())
			{
				flag= true;
			}
		}
		return flag;
	}
	
	public void enterDataToGetRecommendProductsForGallons(String poolVolume,String poolVolumeDropdownValue,String freeChlorine,
			String pH, String totalHardness, String totalAlkalinity, String totalChlorine, String cyanuricAcid)
	{
		waitTool.waitForElement(driver, poolVolumeTextBox);
		poolVolumeTextBox.sendKeys(poolVolume);
		pageManager.common().selectByVisibleTextFromDropdown(poolVolumeDropdown, poolVolumeDropdownValue);
		chlorineRadioButton.click();
		freeChlorineTextBox.sendKeys(freeChlorine);
		pHTextBox.sendKeys(pH);
		totalHardnessTextBox.sendKeys(totalHardness);
		totalAlkalinityTextBox.sendKeys(totalAlkalinity);
		totalChlorineTextBox.sendKeys(totalChlorine);
		cyanuricAcidTextBox.sendKeys(cyanuricAcid);
		algaeCheckBox.click();
		calculateButton.click();
	}
	
	public void enterDataToGetRecommendProductsForLiters(String poolVolume,String poolVolumeDropdownValue,String freeChlorine,
			String pH, String totalHardness, String totalAlkalinity, String totalChlorine, String cyanuricAcid)
	{
		waitTool.waitForElement(driver, poolVolumeTextBox);
		poolVolumeTextBox.sendKeys(poolVolume);
		pageManager.common().selectByVisibleTextFromDropdown(poolVolumeDropdown, poolVolumeDropdownValue);
		saltRadioButton.click();
		freeChlorineTextBox.sendKeys(freeChlorine);
		pHTextBox.sendKeys(pH);
		totalHardnessTextBox.sendKeys(totalHardness);
		totalAlkalinityTextBox.sendKeys(totalAlkalinity);
		totalChlorineTextBox.sendKeys(totalChlorine);
		cyanuricAcidTextBox.sendKeys(cyanuricAcid);
		cloudyCheckBox.click();
		calculateButton.click();
	}
	
	public Boolean enterInvalidDataAndVerifyErrors(String poolVolume,String freeChlorine,
			String pH)
	{
		Boolean flag = false;
		waitTool.waitForElement(driver, poolVolumeTextBox);
		poolVolumeTextBox.sendKeys(poolVolume);
		pHTextBox.sendKeys(pH);
		freeChlorineTextBox.sendKeys(freeChlorine);
		poolVolume=poolVolume+poolVolume;
		poolVolumeTextBox.clear();
		poolVolumeTextBox.sendKeys(poolVolume);
		int size = errorMessageForWrongData.size();
		if(size==3)
			flag=true;
		return flag;
		
	}
	
	
	
	public Boolean isListOfrecommendedProductsDisplayed()
	{
		waitTool.waitForElement(driver, dataPoolSnapshot);
		Boolean flag = false;
		if(recommendedProducts.size()>0)
			flag=true;
		return flag;
		
	}
	
	public String getPartNumberOfOneRecommendedPartAndClickAddToCart()
	{
		waitTool.waitForElement(driver, dataPoolSnapshot);
		String pnumber =  recommendedPartNumbers.get(0).getText();
		pnumber=pnumber.substring(pnumber.indexOf("T")+1);
		pnumber=pnumber.trim();
		System.out.println("pnumber ssss"+ pnumber);
		addToCartOfecommendedPartNumbers.get(0).click();
		return pnumber;
	}
	
	public String getPartNumberOfOneRecommendedPartAndClickAddToList()
	{
		waitTool.waitForElement(driver, dataPoolSnapshot);
		String pnumber =  recommendedPartNumbers.get(0).getText();
		pnumber=pnumber.substring(pnumber.indexOf("T")+1);
		pnumber=pnumber.trim();
		addToListOfecommendedPartNumbers.get(0).click();
		return pnumber;
	}
	
	public String getPartNumberOfOneRecommendedPartAndClickAddToListGuesUser()
	{
		waitTool.waitForElement(driver, dataPoolSnapshot);
		String pnumber =  recommendedPartNumbers.get(0).getText();
		pnumber=pnumber.substring(pnumber.indexOf("T")+1);
		pnumber=pnumber.trim();
		addToListOfecommendedPartNumbersGuestUser.get(0).click();
		return pnumber;
	}
	
	
	public String getPartNumberOfOneRecommendedPartAndClickAddToQuote()
	{
		waitTool.waitForElement(driver, dataPoolSnapshot);
		String pnumber =  recommendedPartNumbers.get(0).getText();
		pnumber=pnumber.substring(pnumber.indexOf("T")+1);
		pnumber=pnumber.trim();
		System.out.println("pnum isss"+ pnumber);
		addToQuoteOfecommendedPartNumbers.get(0).click();
		return pnumber;
	}
	
	public String getPartNumberOfOneRecommendedPartAndClickAddToQuoteGuestUser()
	{
		waitTool.waitForElement(driver, dataPoolSnapshot);
		String pnumber =  recommendedPartNumbers.get(0).getText();
		pnumber=pnumber.substring(pnumber.indexOf("T")+1);
		pnumber=pnumber.trim();
		addToQuoteOfecommendedPartNumbersGuestUser.get(0).click();
		return pnumber;
	}
	
	
	public void clickOnproductNameOfecommendedPartNumbers()
	{
		waitTool.waitForElement(driver, dataPoolSnapshot);
		productNameOfecommendedPartNumbers.get(0).click();
		pageManager.common().moveToNewWindow(driver);
	}
	
	public void clickOnproductNameOfecommendedPartNumbersGuestUser()
	{
		waitTool.waitForElement(driver, dataPoolSnapshot);
		productNameOfecommendedPartNumbersGuestUser.get(0).click();
		pageManager.common().moveToNewWindow(driver);
	}
	
}
