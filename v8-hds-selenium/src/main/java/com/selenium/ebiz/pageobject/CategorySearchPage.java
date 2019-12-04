/**
 * @author nm064123
 */
package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CategorySearchPage
{
	private  WebDriver driver; private WaitTool   waitTool;

	public CategorySearchPage(WebDriver driver) 
	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
	}

}
