package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;

public class GoogleSearchResultPage extends BaseClass{

	public GoogleSearchResultPage(WebDriver driver) 	{
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(googleResultSection));
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
		return CommonFunctions.isElementPresent(googleResultSection);
	}

	/**
	 * Method to find specific search result or link in the search result section.
	 * @return boolean true\false
	 */
	public boolean findSpecificLinkinSearchresultList() throws Exception {
		boolean flag = false;
		while(CommonFunctions.isElementPresent(googleResultPageNextButton)) {
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
