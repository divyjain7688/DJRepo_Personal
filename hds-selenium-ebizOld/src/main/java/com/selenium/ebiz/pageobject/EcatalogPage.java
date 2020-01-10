package com.selenium.ebiz.pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;

public class EcatalogPage extends BaseClass
{
	public EcatalogPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver,0);
		wait.until(ExpectedConditions.visibilityOf((LeftFlyover)));
	}

	@FindBy (xpath= "//div[@id=\"BookshelfFilterTabView_Content\"]")
	WebElement LeftFlyover;

}