package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class QuotesPriceDetailPage{
	private WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;
	
	public QuotesPriceDetailPage(WebDriver driver) 	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		pageManager=new PageManager(driver);
	}
	
	@FindBy(xpath = "//h1[@data-hds-tag=\"quote-detail__header-label\"]")
	WebElement priceQuoteTitle;

	@FindBy(xpath = "//*[@id='headerQuoteId']")
	WebElement idNumber;

	@FindBy(xpath = "//div[@data-hds-tag=\"shopping-cart__item-list-details\"]/div[1]")
	List<WebElement> listProductsDescriptionText;

	@FindBy(xpath = "//div[@data-hds-tag=\"shopping-cart__item-list-actions-partnumber\"]")
	List<WebElement> listProductPartNumbers;

	@FindBy(xpath = "//*[@data-hds-tag='quote-detail__checkout__logon-btn']")
	WebElement checkoutBtn;
	
	@FindBy(xpath = "//div[text()='Created By']/../div[2]")
	WebElement createdByName;

	

	
	@FindBy(xpath = "//div[@class='button-strip']//button[contains(text(),'Cancel')]")
	WebElement cancelButton;
	
	@FindBy(xpath = "//a[@class=\"jq-open-modal\"]")
	public WebElement emailToLink;
	
	@FindBy(xpath = "//div[@data-hds-tag=\"quote-detail__share-quote\"]")
	public WebElement shareQuoteLink;
	
	
	public boolean isDisplayedPriceQuoteTitle(){
		waitTool.waitForElement(driver, priceQuoteTitle);
		return priceQuoteTitle.isDisplayed();	
	}
	
	public void clickOnPrintIcon(){
		waitTool.waitForElement(driver, priceQuoteTitle);
		pageManager.commonPageObjects().printIcon.click();
	}
	

	
	public void clickOnCancelButton(){
		cancelButton.click();
	}

	public boolean isAddedpartNumberIsDisplayedOnPriceQuotepage(String partNumber){
			waitTool.waitForElement(driver,priceQuoteTitle);
			Boolean flag=false;
			//System.out.println("quote name " + quoteName);
			for(WebElement displayedPartNumbers : listProductPartNumbers)
			{
				System.out.println("Price Quote page part numbers: " + displayedPartNumbers.getText());
			}

			for(WebElement displayedPartNumbers : listProductPartNumbers)
			{
				if(displayedPartNumbers.getText().contains(partNumber))
				{
					flag=true;
					System.out.println("flag updated to true");
					break;
				}
			}
			return flag;
		}

	public boolean isAddedPartDescriptionTextIsDisplayedOnPriceQuotepage(String partDesc){
		waitTool.waitForElement(driver,priceQuoteTitle);
		Boolean flag=false;
		for(WebElement displayedPartsDescription : listProductsDescriptionText)
		{
			System.out.println("Price Quote page Parts Description: " + displayedPartsDescription.getText());
		}

		for(WebElement displayedPartsDescription : listProductsDescriptionText)
		{
			if(displayedPartsDescription.getText().contains(partDesc))
			{
				flag=true;
				System.out.println("flag updated to true");
				break;
			}
		}
		return flag;
	}
	
	public void clilckOnEmailToLink()
	{
		waitTool.waitForElement(driver, emailToLink);
		emailToLink.click();
	}
	
	public void clilckOnshareQuoteLink()
	{
		pageManager.common().refresh();
		waitTool.waitForElement(driver, shareQuoteLink);
		pageManager.common().scrolltoViewElement(shareQuoteLink, driver);
		shareQuoteLink.click();
	}
	
	public String getCreatedByNameText()
	{
		waitTool.waitForElement(driver, createdByName);
		return createdByName.getText().trim();
	}
}

