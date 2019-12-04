package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.SwitchTool;
import com.selenium.ebiz.tools.WaitTool;

public class PoolCareAndMaintenance {
	private WebDriver driver;
	protected WaitTool waitTool;
	private PageManager pageManager;
	protected SwitchTool switchTool;


	public PoolCareAndMaintenance(WebDriver driver)
	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager = new PageManager(driver);
	}

	@FindBy(xpath="//div[@class=\"contentLink\"]//a[text()='Pool Water Testing Tool']")
	public WebElement poolWaterTestingToolLink;
	
	public void clickOnPoolWaterTestingToolLink()
	{
		waitTool.waitForElement(driver, poolWaterTestingToolLink);
		poolWaterTestingToolLink.click();
		pageManager.common().moveToNewWindow(driver);
	}
	
}
