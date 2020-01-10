package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class CategoryPage extends BaseClass{

	public CategoryPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// 
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
		public CategoryPage clickCategoryBlindsAndAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, categoryBlindsAndAccessoriesLinkText);
			categoryBlindsAndAccessoriesLinkText.click();
			WaitTool.waitFor(driver, true);
			return new CategoryPage(driver);

		}
		
		// Click on Blinds and Accessories
		public SubCategory clickCategoryBlindsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, categoryBlindsLinkText);
			categoryBlindsLinkText.click();
			WaitTool.waitFor(driver, true);
			return new SubCategory(driver);

		}
	
}
