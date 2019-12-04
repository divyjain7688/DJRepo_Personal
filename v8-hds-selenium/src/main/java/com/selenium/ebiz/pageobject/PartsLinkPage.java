package com.selenium.ebiz.pageobject;


import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PartsLinkPage
{
	private  WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;

	public PartsLinkPage(WebDriver driver)
	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		this.pageManager = new PageManager(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy (xpath= "//h1[contains(text(),'PartsLink')]")
	public WebElement partsLinkPageTitle;

	@FindBy (id= "partslink_SearchTerm")
	public WebElement partsLinkPageSearchBox;

	@FindBy(id="jq-partslink-search-by-id")
	WebElement searchBtn;

	@FindBy(xpath="//*[text()='Product Diagrams']")
	WebElement productDiagramsPageTitle;

	@FindBy(xpath = "//*[@class='type--body-small']/div[2]/span")
	public WebElement maytagModelNumber;

	@FindBy(xpath = "//*[@data-hds-tag='product-diagram']")
	public WebElement productsDiagramCarousel;

	@FindBy(xpath = "//*[@data-hds-tag='product-diagram__open-button']")
	public List<WebElement> listProdDiagramOpenButtons;

	@FindBy(xpath = "//*[@data-hds-tag='search-result']")
	public WebElement invalidSearchResultText;

	@FindBy(xpath = "//*[@data-hds-tag='repair-parts-wizard__part-select-header-title']")
	public WebElement selectedPartHeaderTitle;

	public boolean isPartsLinkPageTitleDisplayed(){
	    pageManager.common().scrolltoViewElement(partsLinkPageTitle,driver);
		waitTool.waitForElement(driver,partsLinkPageTitle);
		return partsLinkPageTitle.isDisplayed();
	}

	public void searchByInputOnPartsLinkPage(String keyword)
	{
		waitTool.waitForElement(driver,partsLinkPageSearchBox);
		partsLinkPageSearchBox.getSize();
		partsLinkPageSearchBox.clear();
		partsLinkPageSearchBox.sendKeys(keyword);
		pageManager.common().scrolltoViewElement(searchBtn, driver);
		searchBtn.click();
	}

	public boolean isProductDiagramPageDisplayed(){
	waitTool.waitForElement(driver,productDiagramsPageTitle);
	return productDiagramsPageTitle.isDisplayed();
	}

	public boolean isMaytagModelNumberDisplayed(){
		waitTool.waitForElement(driver,maytagModelNumber);
		return maytagModelNumber.isDisplayed();
	}



}