package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SubCategoryAppliancesPage {

    private  WebDriver driver;
    private WaitTool waitTool;
    private PageManager pageManager;

    public SubCategoryAppliancesPage(WebDriver driver) 	{
        this.driver = driver;  this.waitTool = new WaitTool();
        this.pageManager=new PageManager(driver);
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(xpath="//button[starts-with(@id,'removeItem_')]"))
    List<WebElement> shoppingCartRemoveButton;

    @FindBy(xpath="//a[@id='clickableErrorMessageImg']/div[@class='close_icon']")
    WebElement popupCloseButton;

    @FindBy(xpath = "//h1[contains(text(),'Dishwashers & Repair')]")
    WebElement DishwashersAndRepairText;

    @FindBy(linkText = "//div[@class='content_section']//div[contains(text(),'Dryers')]")
    WebElement subCategoryDryersLinkText;

    @FindBy(xpath="//a[@class='btn btn--large btn--full cart-added__checkout-desktop']")
    WebElement modalAddCartCheckOutButton;

    @FindBy(xpath="//div[starts-with(@id,'container_')]/div[1]/div/div")
    public WebElement breadCrumbLinkText;

    @FindBy(xpath="//div[contains(text(),'Washer & Dryer Repair')]") 
    WebElement subCategoryWasherDryerRepairLinkText;

    @FindBy(xpath="//a[text()='Dishwashers']")
    WebElement subCategoryDishwashersLinkText;

    @FindBy(xpath = "//li[1]/a/div[@class='facetCountContainer']")
    WebElement subCategoryFromLeftNavigation;

    @FindBy(xpath = "//h1")
    public WebElement subCategoryDishwashersHeading;

    @FindAll(@FindBy(xpath="//li/a/div[@class='facetCountContainer']"))
    List<WebElement> subCategoriesLeftFrame;

    @FindAll(@FindBy(xpath="//section[@class='subcat-list-tile']/div/div[@class='subcat-list-tile__details']/div[@class='subcat-tile__attributes type--caption']//span[2]"))
    List<WebElement> subCategoriesProductAttriburesText;

    @FindBy(xpath = "//div[@class='pagination']/div/div/span")
    public WebElement subCategoryPageNumbersView;

    @FindBy(xpath = "//a[@id='WC_SearchBasedNavigationResults_pagination_link_right_categoryResults']")
    public WebElement subCategoryFowardPageButton;

    @FindBy(xpath = "//a[@id='WC_SearchBasedNavigationResults_pagination_link_left_categoryResults']")
    public WebElement subCategoryBackwardPageButton;

    @FindBy(xpath = "//div[@class='pagination__info']/input[@type='number']")
    public WebElement subCategoryPageEdit;

    @FindBy(xpath = "//a[@id='WC_SearchBasedNavigationResults_pagination_link_list_categoryResults']")
    WebElement subCategoryListViewLink;

    @FindAll(@FindBy(xpath="//a[starts-with(@id,'listViewAdd2Cart_')]"))
    List<WebElement> subCategoryAddToCartButton;

    @FindBy(xpath = "//div[@class='header-mini-cart__header']")
    WebElement subCategoryAddtoCartText;

    @FindAll(@FindBy(xpath="//img[starts-with(@id,'productThumbNailImage_')]"))
    List<WebElement> imageClick;

    @FindBy(xpath="//div[starts-with(@class,'image-viewer__thumbs')]")
    WebElement zoomImage;

    @FindBy(xpath="//img[@class='image-viewer__zoom-img']")
    public WebElement viewImage;

    @FindBy(linkText = "×")
    WebElement close;

    /**
     *  Method to Click on checkout in Modal
     * @throws InterruptedException
    waitTool.waitForElement(driver, popupCloseButton);
    popupCloseButton.click();
    waitTool.waitFor(driver,true) ;
    }

    /**
     *  Method to Remove the Cart is shopping cart page.
     * @return
     * @throws InterruptedException
     */
    public List<WebElement> getShoppingCartRemoveButton() throws InterruptedException {
        /**		waitTool.waitFor(driver,true) ;
         System.out.println("shoppingCartRemoveButton"+shoppingCartRemoveButton.size());
         if (shoppingCartRemoveButton.size()>0) {

         for(int i =0;i<=shoppingCartRemoveButton.size();i++) {
         shoppingCartRemoveButton.get(0).click();
         waitTool.waitFor(driver,true) ;
         }

         }*/
        return shoppingCartRemoveButton;
    }

    /**
     *  Method to Click on checkout in Modal
     * @return
     * @throws InterruptedException
     */
    public ShoppingCartPage clickModalAddCartCheckOutButton() throws InterruptedException {
        waitTool.waitForElement(driver, modalAddCartCheckOutButton);
        modalAddCartCheckOutButton.click();
        waitTool.waitFor(driver,true) ;
        return new ShoppingCartPage(driver);
    }

	/*public boolean isDisplayedBreadCrumb(){
		return .isElementPresent(breadCrumbLinkText);
	}*/

    /**
     *  Method to Click on Washer & Dryer Repair in Sub Categories
     * @throws InterruptedException
     */
    public void clickSubCategoryWasherDryerRepairLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, subCategoryWasherDryerRepairLinkText);
        subCategoryWasherDryerRepairLinkText.click();
        waitTool.waitFor(driver,true) ;
    }

    /**
     *  Method to get Total number of Pages in sub category
     * @return
     * @throws InterruptedException
     */
    public String getSubCategoryTotalPageNumbers() throws InterruptedException {
        return subCategoryPageNumbersView.getText().trim();
    }

    /**
     *  Method to Click on image in Sub Categories
     * @return
     * @throws InterruptedException
     */
    public List<WebElement> getSubCategoryLinkText() throws InterruptedException {
        waitTool.waitFor(driver,true) ;
        return imageClick;
    }

    public boolean isDisplayedZoomImage(){
        return pageManager.common().isElementPresent(zoomImage);
    }

    public String getZoomImage() {
        System.out.println(viewImage.getCssValue("max-customizedPartWidthDimension"));
        System.out.println(viewImage.getAttribute("style"));
        return viewImage.getAttribute("style");
    }
    
    public boolean isDisplayedForwardPages(){
    	waitTool.waitForElement(driver, subCategoryFowardPageButton);
		return pageManager.common().isElementPresent(subCategoryFowardPageButton);
	}

	/*public boolean isDisplayedMorePages(){
		return .isElementPresent(subCategoryPageNumbersView);
	}

	public boolean isDisplayedForwardPages(){
		return .isElementPresent(subCategoryFowardPageButton);
	}

	public boolean isDisplayedBackwardPages(){
		return .isElementPresent(subCategoryBackwardPageButton);
	}

	public boolean isDisplayedEditField(){
		return .isElementPresent(subCategoryPageEdit);
	}

	public String getSubCategortName() throws InterruptedException {
		return subCategoryDishwashersHeading.getText().trim();
	}

	public String getPageNumberEdit() throws InterruptedException {
		return subCategoryPageEdit.getAttribute("value").trim();
	}*/

    public ProductPage selectSubCategoriesFromLeftFrame() throws InterruptedException {
        subCategoriesLeftFrame.get(0).click();
        waitTool.waitFor(driver,true);
        return new ProductPage(driver);
    }

    public List<WebElement> selectSubCategoriesAddtoCartButton() throws InterruptedException {
        waitTool.waitFor(driver,true) ;
        return subCategoryAddToCartButton;
    }

    public List<WebElement> selectSubCategoriesProductAttributesText() throws InterruptedException {
        waitTool.waitFor(driver,true) ;
        return subCategoriesProductAttriburesText;
    }

    public String getAddtoCartText() throws InterruptedException {
        waitTool.waitFor(driver,true) ;
        return subCategoryAddtoCartText.getAttribute("innerHTML").trim();
    }

    public ProductPage clickSubCategoryDishwashersLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, subCategoryDishwashersLinkText);
        subCategoryDishwashersLinkText.click();
        waitTool.waitFor(driver,true);
        return new ProductPage(driver);
    }

    public ProductListingPage clickSubCategoryDishwashersLink() throws InterruptedException {
        waitTool.waitForElement(driver, subCategoryDishwashersLinkText);
        subCategoryDishwashersLinkText.click();
        waitTool.waitFor(driver,true);
        return new ProductListingPage(driver);
    }

    public ProductPage clickSubCategoryDryersLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, subCategoryDryersLinkText);
        subCategoryDryersLinkText.click();
        waitTool.waitFor(driver,true);
        return new ProductPage(driver);
    }

    public SubCategoryAppliancesPage clickSubCategoryListViewLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, subCategoryListViewLink);
        subCategoryListViewLink.click();
        waitTool.waitFor(driver,true);
        return new SubCategoryAppliancesPage(driver);
    }

    public ProductListingPage clickSubCategoryListtViewLinkText() throws InterruptedException {
        waitTool.waitForElement(driver, subCategoryListViewLink);
        subCategoryListViewLink.click();
        waitTool.waitFor(driver,true);
        return new ProductListingPage(driver);
    }

    public SubCategoryAppliancesPage clickSubCategoryForwardPageButton() throws InterruptedException {
        waitTool.waitForElement(driver, subCategoryFowardPageButton);
        pageManager.common().scrolltoViewElement(subCategoryFowardPageButton, driver);
        subCategoryFowardPageButton.click();
        waitTool.waitFor(driver,true);
        return new SubCategoryAppliancesPage(driver);
    }

    public SubCategoryAppliancesPage clickSubCategoryBackwardPageButton() throws InterruptedException {
        waitTool.waitForElement(driver, subCategoryBackwardPageButton);
        subCategoryBackwardPageButton.click();
        waitTool.waitFor(driver,true);
        return new SubCategoryAppliancesPage(driver);
    }

    public void enterPageNumber(String pageNumber) {
        subCategoryPageEdit.clear();
        subCategoryPageEdit.sendKeys(pageNumber);
    }

    public void alertCancelPopUpWindow() throws Exception {
        //	Thread.sleep(2000);
        waitTool.waitForAlert(driver);
        pageManager.common().cancelPopupMessageBox(driver);
    }

    public void close(){
        close.click();
    }


}
