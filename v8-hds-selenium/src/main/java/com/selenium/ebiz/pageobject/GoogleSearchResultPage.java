package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchResultPage
{
	private  WebDriver driver;
	private WaitTool   waitTool;
	private PageManager pageManager;

	public GoogleSearchResultPage(WebDriver driver) 	{
		this.pageManager=new PageManager(driver);
		PageFactory.initElements(driver, this);

	}

	public WebElement ele;

	//Header google Logo
	@FindBy(id = "main")
	WebElement googleResultSection;

	//Search result list
	@FindAll({@FindBy(how = How.XPATH  , using = "//div[@id='main']//div/cite")})
	public List<WebElement> searchResultList;

	//Search result list
	@FindAll({@FindBy(how = How.XPATH  , using = "//div[@id='main']//h3/a")})
	public List<WebElement> searchResultList1;

	//Header google result page next button
	@FindBy(xpath = "//a[@id='pnnext']")
	WebElement googleResultPageNextButton;

	/**
	 * Method to Verify the presence of Google result section.
	 * @return boolean true\false
	 */
	public boolean isDisplayedGoogleResultSection(){
		return pageManager.common().isElementPresent(googleResultSection);
	}

	/**
	 * Method to find specific search result or link in the search result section.
	 * @return boolean true\false
	 */
	public boolean findSpecificLinkinSearchresultList() throws Exception {
		boolean flag = false;
		while(pageManager.common().isElementPresent(googleResultPageNextButton)) {
			for(int i=0;i<searchResultList.size(); i++) {
				if(searchResultList.get(i).getText().trim().startsWith("https://hdsupplysolutions.com")) 
					ele = searchResultList1.get(i);
				flag = true;
				break;
			}
			if(flag==false) 				 
				googleResultPageNextButton.click();				
			else
				break;
		}
		return flag;
	}

	/**
	 * Method to click on search result link.
	 *  */
	public void clickOnSearchResultLink() {
		ele.click();
		//return new ProductPage();
	}
}
