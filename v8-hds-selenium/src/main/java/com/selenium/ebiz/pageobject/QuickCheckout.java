package com.selenium.ebiz.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;

public class QuickCheckout {
	private WebDriver driver;
	protected PageManager pageManager;
	private WaitTool waitTool;
	private ArrayList<UsersListBean> usersList;

	public QuickCheckout(WebDriver driver) {
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager = new PageManager(driver);

	}
	@FindBy(xpath = "//*[@data-hds-tag='quick-checkout__header-label']")
	WebElement quickCheckoutPageTitle;

	@FindBy(xpath = "//div[@data-hds-tag='shopping-cart__item-list-actions-partnumber']")
	List<WebElement> partNumbers;
	
	@FindBy(xpath = "//*[@class='list-item__customize-label']")
	public WebElement youHaveCustomizedThisItemText;
	//a[@class="link--regular type--caption customize jq-open-modal"]
	@FindBy(xpath = "//div[@class='list-item__customize-label']/a")
	public WebElement customizeThisItemLink;
	
    @FindBy(xpath = "//a[contains(text(),'ve customized this item')]")
    public WebElement youHaveCustomizedThisItem;
    
	@FindBy(xpath = "//*[@data-hds-tag='shopping-cart__item-list-options-customize']//div[4]")
	public WebElement customizedPartWidthDimension;

	@FindBy(xpath = "//*[@data-hds-tag='shopping-cart__item-list-options-customize']//div[5]")
	public WebElement customizedPartLengthDimension;
	
	@FindBy(xpath = "//div[text()='Please choose another item, or remove this item to continue.']")
	WebElement partNumberNoLongerAvailableMessage;

	@FindBy(xpath = "//select[@class='jq-shipping-selection']")
	WebElement shippingToDropdown;
	
	@FindBy(xpath = "//div[@class='quick-checkout__shipping-to-indent el--margin-top-2 type--caption']/div[1]")
	public WebElement displayedShippingToAddress1;
	
	@FindBy(xpath = "//div[@class='quick-checkout__shipping-to-indent el--margin-top-2 type--caption']/div[2]")
	public WebElement displayedShippingToAddress2;
	
	@FindBy(xpath = "//div[@class='quick-checkout__shipping-to-indent el--margin-top-2 type--caption']/div[3]")
	public WebElement displayedShippingToAddress3;

	@FindBy(xpath = "//div[contains(text(),'ve customized this item')]")
	public WebElement customizedThisItemLink;
	
	@FindBy(xpath = "//button[@class='quick-checkout__items-submit btn btn--large oswald el--hide--mobile jq-submit-order']")
	public WebElement submitSecureOrder;
	
	@FindBy(xpath = "//input[@id='poNumber']")
    public WebElement enterPONumber;
	
	@FindBy(xpath = "//input[@id='quick-checkout__add-parts_input']")
    public WebElement addPartsToYourOrderPartNumber;
	
	@FindBy(xpath = "//input[@id='quick-checkout__add-parts_quantity']")
    public WebElement addPartsToYourOrderQuantity;
	
	@FindBy(xpath = "//div[@id='skuAddSearch_quick-checkout__add-parts_input']")
    List<WebElement> addPartsToYourOrderPartNumberSuggestionList;
	
	@FindBy(xpath = "//button[@id='quick-checkout__add-parts_button']")
    public WebElement addPartsToYourOrderButton;
	
	public Boolean isQuickCheckoutPageTitleDisplayed(){
		waitTool.waitForElement(driver,quickCheckoutPageTitle);
		return  quickCheckoutPageTitle.isDisplayed();
	}
	
	public Boolean isAddedPartNumberDisplayed(String pnumber)
	{
		Boolean flag=false;
		for(WebElement partNumber :partNumbers)
		{
			if(partNumber.getText().contains(pnumber))
			{
				flag = true; 
				break;
			}
				
		}
		return flag;
	}
	
	public Boolean isPartNumberNoLongerAvailableMessageDisplayed()
	{
		waitTool.waitForElement(driver, partNumberNoLongerAvailableMessage);
		return partNumberNoLongerAvailableMessage.isDisplayed();
	}
	
	public void selectSpecificOptionFromShippingDropdown(String optionValue) throws InterruptedException
	{
		System.out.println("optionValue is "+ optionValue);
		waitTool.waitForElement(driver, shippingToDropdown);
		Select select = new Select(shippingToDropdown);
		select.selectByVisibleText(optionValue);
		waitTool.waitFor(driver, true);
		pageManager.common().refresh();
	}

	public Boolean submitSecureOrder()
	{
       Boolean flag = false;
		String pONumber = pageManager.common().getRandomNumber();
        //waitTool.waitForElement(driver, enterPONumber);
		waitTool.waitFor(driver, true);
        enterPONumber.sendKeys(pONumber);
        waitTool.waitForElement(driver, submitSecureOrder);
        pageManager.common().scrolltoViewElement(submitSecureOrder, driver);
		submitSecureOrder.click();
		try
		{
		pageManager.common().acceptPopupMessageBox(driver);
		flag=true;
		}
		catch(Exception e)
		{
			System.out.println("no pop up appeared");
		}
		return flag;
	}
	
	public void clickOnCustomizeThisItemLink()
	{
		waitTool.waitFor(driver, true);
		pageManager.common().scrolltoViewElement(customizeThisItemLink, driver);
		customizeThisItemLink.click();
	}
	
	public void addpartToOrder(String partnumber)
	{
		waitTool.waitForElement(driver, addPartsToYourOrderPartNumber);
		addPartsToYourOrderPartNumber.sendKeys(partnumber);	
		addPartsToYourOrderQuantity.clear();
		addPartsToYourOrderQuantity.sendKeys("1");
		//waitTool.waitForElement(driver, addPartsToYourOrderPartNumberSuggestionList.get(0));
		//addPartsToYourOrderPartNumberSuggestionList.get(0).click();
		waitTool.waitForElement(driver, addPartsToYourOrderButton);
		pageManager.common().scrolltoClickElement(addPartsToYourOrderButton, driver);
	//	addPartsToYourOrderButton.click();
	}
	
	public Boolean isCustomizeThisItemLinkDisplayed()
	{
		waitTool.waitFor(driver, true);
		return customizeThisItemLink.isDisplayed();
	}
	
	public Boolean isYouHaveCustomizedThisItemDisplayed()
	{
		waitTool.waitForElement(driver, youHaveCustomizedThisItem);
		return youHaveCustomizedThisItem.isDisplayed();
	}

}
