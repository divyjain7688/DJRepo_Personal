package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class OfferPage {

    private WebDriver driver;
    private WaitTool waitTool;
    private PageManager pageManager;

    public OfferPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitTool  = new WaitTool();
        pageManager = new PageManager(driver);

    }

    @FindBy(xpath = "//*[@data-hds-tag='nav__links-offers__link']")
    public WebElement offersPageTitleText;

    @FindBy(xpath = "//*[@class='offer-box__promo divider--thin']")
    List<WebElement> listOfAllOffers;

    @FindBy(xpath = "//*[@class='subcat-grid-tile__header type--caption input-group compare_target']")
    List<WebElement> listOfAllProducts;

    public void clickOnTheOfferDetail(int index){
        listOfAllOffers.get(index).click();
    }

    public int getNumberOfAllListedProducts(){
        return listOfAllProducts.size();
    }
    
    public Boolean isDisplayedOffersTitleText(){
    	return pageManager.common().isElementPresent(offersPageTitleText);
    }
}