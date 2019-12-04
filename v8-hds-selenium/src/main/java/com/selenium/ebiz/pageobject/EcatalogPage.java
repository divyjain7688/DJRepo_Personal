package com.selenium.ebiz.pageobject;


import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcatalogPage
{
	private  WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;
	public EcatalogPage(WebDriver driver) 
	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		this.pageManager=new PageManager(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy (xpath= "//div[@id=\"BookshelfFilterTabView_Content\"]")
	WebElement LeftFlyover;

	@FindBy (xpath= "//div[text()='Bookshelf Filters']")
	public WebElement bookshelfFilters;


	public Boolean isBookshelfFiltersdisplayed()
	{
		waitTool.waitForElement(driver, bookshelfFilters);
		pageManager.common().scrolltoViewElement(bookshelfFilters, driver);
		return pageManager.common().isElementPresent(bookshelfFilters);
	}
}