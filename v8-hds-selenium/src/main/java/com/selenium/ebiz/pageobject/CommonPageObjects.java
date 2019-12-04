package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPageObjects {

    private WebDriver driver;
    private WaitTool waitTool;
    private PageManager pageManager;
    public Logger Log = Logger.getLogger(CommonPageObjects.class.getName());

    /*
    *** The collection of common page object that mays be seeing on any page
     */

    public CommonPageObjects(WebDriver driver)
    {
        this.driver = driver;
        this.waitTool = new WaitTool();
        PageFactory.initElements(driver, this);
        this.pageManager=new PageManager(driver);
    }


    @FindBy(xpath = "//div[@class='email-print']/a[2]")
    public WebElement emailPageLink;

    @FindBy(xpath = "//a[@data-hds-tag='print']")
    public WebElement printIcon;

    @FindBy(xpath = "//*[@class='repair-parts-wizard__email-print']/div[1]/a[1]")
    public WebElement printIconReparePartPage;

    @FindBy(xpath = "//*[@class='repair-parts-wizard__email-print']/div[1]/a[2]")
    public WebElement emailPageLinkReparePartPage;
    
//  Home in BreadCrumbs
	@FindBy(xpath = "//div[@data-hds-tag='breadcrumbs']//a[contains(text(),'Home')]")
	WebElement breadCrumbHomeLinkText;

    public boolean isEmailIconDisplayed(){
        waitTool.waitForElement(driver,emailPageLink);
        return emailPageLink.isDisplayed();

    }
    public boolean isPrintIconDisplayed(){
        waitTool.waitForElement(driver,printIcon);
        return printIcon.isDisplayed();
    }




}
