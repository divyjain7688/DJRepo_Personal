package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopByCategory
{
	private  WebDriver driver; private WaitTool   waitTool;

	public ShopByCategory(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']/div[@class='flyout-menu__page']/div[@class='flyout-nav__list-container']/ul/li/a[text()='Lighting']")
	public
	WebElement shopByCategoryLighting;


	@FindBy(linkText = "Blinds & Accessories")
	WebElement categoryBlindsAndAccessoriesLinkText;

	@FindBy(linkText = "Blinds")
	WebElement categoryBlindsLinkText;

	//To Verify for the Categories

	@FindBy(xpath = "//ul[@id='categoryFacetList_1_13054_60493']/li")
	private List<WebElement> categoriesAllLinks;


	//To Verify for the Categories
	@FindBy(xpath = "//*[@id='PageHeading_2_-3001_165468']/h1")
	WebElement CategoryPageHeadingText;


	public String getCategoryPageHeadingText() {
		return CategoryPageHeadingText.getText().trim();
	}


	//To Verify for the top category
	@FindBy(xpath = "//*[@id='PageHeading_2_-3001_40466']/h1")
	WebElement topCategoryPageHeadingText;

	public String getTopCategoryPageHeadingText() {
		return topCategoryPageHeadingText.getText().trim();
	}


	//To Verify for the Sub category
	@FindBy(xpath = "//*[@id='PageHeading_2_-3001_165469']/h1")
	WebElement subCategoryPageHeadingText;

	public String getSubCategoryPageHeadingText() {
		return subCategoryPageHeadingText.getText().trim();
	}
	// Click on Blinds and Accessories
	public ShopByCategory clickCategoryBlindsAndAccessoriesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryBlindsAndAccessoriesLinkText);
		categoryBlindsAndAccessoriesLinkText.click();
		waitTool.waitFor(driver, true);
		return new ShopByCategory(driver);

	}

	// Click on Blinds and Accessories
	public SubCategory clickCategoryBlindsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryBlindsLinkText);
		categoryBlindsLinkText.click();
		waitTool.waitFor(driver, true);
		return new SubCategory(driver);

	}

}
