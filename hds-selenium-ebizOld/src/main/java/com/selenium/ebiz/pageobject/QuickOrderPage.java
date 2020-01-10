package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;

public class QuickOrderPage extends BaseClass{
	
	public QuickOrderPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(quickOrderText));		
	}
	
	@FindBy(xpath="//h1[text()='Quick Order']")
	WebElement quickOrderText;
	
	@FindBy(xpath="//div[@class='quickordermodal activated']")
	WebElement quickOrderSection;
	
	@FindBy(xpath = "//div[@id='quick_order']/div[@class='error_text'][@id='WC_QuickOrderForm_div_6']")
	WebElement errorMsg;
	
	@FindBy(xpath = "//h1[contains(text(),'Quick Order')]")
	WebElement quickOrderPageHeadingText;
	
	@FindBy(xpath = "//div[@class='quick-order__buttons'][1]/button[text()='Add To Cart']")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//div[@class='quick-order__buttons']/a[text()='Add to quote']")
	WebElement addToQuoteButton;
	
	@FindBy(xpath = "//div[@class='quick-order__buttons'][1]/button[text()='Add to list']")
	WebElement addToListButton;
	
	@FindBy(xpath = "//div[@class='quick-order__buttons'][1]/button[text()='Add more parts']")
	WebElement addMorePartsButton;
	
	@FindBy(xpath = "//div[@class=\"quick-order__part-container\"]//input[@name=\"partNumber_7\"]")
	WebElement seventhPartNumberTextBox;
	
	@FindBy(xpath = "//div[@class='input_sub_fields']//input[@name='partNumber_1']")
	WebElement firstpartNumberTextBox;

	@FindBy(xpath = "//div[@class='input_sub_fields']//input[@name='quantity_1']")
	WebElement firstQuantityTextBox;
	
	@FindBy(xpath = "//div[@class='tabs__bar']//a[@class='tabs__tab jq-tabs--toggle']")
	WebElement newTab;

	@FindBy(xpath = "//div[@class='quote-add__footer']//button[@id='createNewQuoteBtn']")
	WebElement createQuoteButton;
	
	@FindBy(xpath = "//div[@id='msgpopup_content_wrapper']")
	WebElement quoteSuccessPopup;
	
	@FindBy(xpath = "//div[@class='close_icon']")
	WebElement closeQuoteSuccessPopupIcon;
	
	@FindBy(xpath = "//div[@class='quotes-add__new-input']//input[@class='jq-quote-add--input']")
	WebElement quoteNameEdit;
	
	@FindBy(xpath = "//div[@class=\"header__main\"]//div[@id=\"contentRecommendationWidget_HdsHeaderLogoESpot\"]")
	WebElement hDSupplyLogoInHeader;
	
	public Boolean isDisplayedAddToCartButton()
	{
		return addToCartButton.isDisplayed();
	}
	
	public Boolean isAddToQuoteButtondisplayed()
	{
		return addToQuoteButton.isDisplayed();
	}
	
	public Boolean isAddToListButtondisplayed()
	{
		return addToListButton.isDisplayed();
	}
	
	public Boolean isAddMorePartsButtondisplayed()
	{
		return addMorePartsButton.isDisplayed();
	}
	
	/**
	 * @name isDisplayedquickOrderSection
	 * @description Method to verify the presence of quick order section after clicking.
	 * @return String value
	 */
	public boolean isDisplayedquickOrderSection(){
		return CommonFunctions.isElementPresent(quickOrderSection);
	}

	public boolean isDisplayedErrorMsg(){
		return CommonFunctions.isElementPresent(errorMsg);
	}
	
	/**
	 * @return true if quick order page heading text is displayed on page otherwise false
	 */
	public boolean isDisplayedQuickOrderPageHeadingText(){
		return CommonFunctions.isElementPresent(quickOrderPageHeadingText);
	}
	
	public Boolean insertSpecialCharInPartNumberTextbox(String spec)
	{
		seventhPartNumberTextBox.sendKeys(spec);
		String value = seventhPartNumberTextBox.getText();
		System.out.println("value is " + value);
		return value.isEmpty();
	}
	
	public void fillFirstPartNumberTextBox(String partNumber1)
	{
		firstpartNumberTextBox.clear();
		firstpartNumberTextBox.sendKeys(partNumber1);	
	}

	public void fillFirstQuantityTextBox(String quantity1)
	{
		firstQuantityTextBox.clear();
		firstQuantityTextBox.sendKeys(quantity1);	

	}
	
	public void clickAddToQuoteButton()
	{
		 addToQuoteButton.click();
	}
	

	public boolean isDisplayedNewTab(){
		return newTab.isDisplayed();
	}
	
	public void clickNewTab(){
		newTab.click();
	}
		
	public void enterQuoteName(String quote){
		quoteNameEdit.sendKeys(quote);
	}
	
	public boolean isDisplayedCreateQuoteButton(){
		return createQuoteButton.isDisplayed();
	}
	
	public void clickCreateQuoteButton(){
		createQuoteButton.click();
	}
	
	public Boolean isDisplayedQuoteSuccessPopup()
	{
		return quoteSuccessPopup.isDisplayed();
	}
	
	public void clickCloseQuoteSuccessPopupIcon(){
		closeQuoteSuccessPopupIcon.click();
		//return new HomePage(driver);
	}
	
	public HomePage clickOnHDSupplyLogoInHeader()
	{
		hDSupplyLogoInHeader.click();
		return new HomePage(driver);
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

